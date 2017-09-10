/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.wsofertas.sessionbeans;

import cl.duoc.wsofertas.constantes.Constantes;
import cl.duoc.wsofertas.entities.Usuario;
import cl.duoc.wsofertas.facade.UsuarioFacadeLocal;
import cl.duoc.wsofertas.request.LoginRequestVO;
import cl.duoc.wsofertas.request.LoginResponseVO;
import cl.duoc.wsofertas.utils.PasswordUtils;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;

/**
 *
 * @author Esteban Perez
 */
@Stateless
public class OfertasService implements OfertasServiceLocal {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    private final static Logger logger = Logger.getLogger(OfertasService.class);

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public LoginResponseVO procesarLogin(LoginRequestVO loginRequest) {
        LoginResponseVO respuesta = null;
        try {
            if (loginRequest.getUsername() == null || loginRequest.getUsername().trim().equalsIgnoreCase("")) {
                respuesta = new LoginResponseVO();
                respuesta.setCodigoRespuesta(Constantes.CODIGO_ERROR_USERNAME_LOGIN_WS);
                respuesta.setRespuesta(Constantes.DESC_ERROR_USERNAME_LOGIN_WS);
                return respuesta;
            } else if (loginRequest.getPassword() == null || loginRequest.getPassword().trim().equalsIgnoreCase("")) {
                respuesta = new LoginResponseVO();
                respuesta.setCodigoRespuesta(Constantes.CODIGO_ERROR_PASSWORD_LOGIN_WS);
                respuesta.setRespuesta(Constantes.DESC_ERROR_PASSWORD_LOGIN_WS);
                return respuesta;
            } else {
                //Primero identificamos si es que el usuario existe
                Usuario usu = usuarioFacade.obtenerUsuarioPorLogin(loginRequest.getUsername().trim());
                if (usu != null) {
                    //Si el usuario existe debemos comparar las contraseñas cifradas
                    String hashPassword = PasswordUtils.getHash(loginRequest.getPassword().trim(), Constantes.CIFRADO_SHA1);
                    if (hashPassword.trim().equals(usu.getPassword().trim())) {
                        respuesta = new LoginResponseVO();
                        respuesta.setCodigoRespuesta(Constantes.CODIGO_LOGIN_CORRECTO_WS);
                        respuesta.setRespuesta(Constantes.DESC_LOGIN_CORRECTO_WS);
                        respuesta.setCodigoUsuario(usu.getIdusuario().longValue());
                        return respuesta;
                    } else {
                        respuesta = new LoginResponseVO();
                        respuesta.setCodigoRespuesta(Constantes.CODIGO_ERROR_PASSWORD_INCORRECTA_WS);
                        respuesta.setRespuesta(Constantes.DESC_ERROR_PASSWORD_INCORRECTA_WS);
                        return respuesta;
                    }
                } else {
                    respuesta = new LoginResponseVO();
                    respuesta.setCodigoRespuesta(Constantes.CODIGO_ERROR_USUARIO_NO_EXISTE_WS);
                    respuesta.setRespuesta(Constantes.DESC_ERROR_USUARIO_NO_EXISTE_WS);
                    return respuesta;
                }
            }
        } catch (Exception e) {
            logger.error("Error grave procesando Login.", e);
            respuesta = new LoginResponseVO();
            respuesta.setCodigoRespuesta(Constantes.CODIGO_ERROR_GENERAL_WS);
            respuesta.setRespuesta(Constantes.DESC_ERROR_GENERAL_WS);
            return respuesta;
        }
    }
}
