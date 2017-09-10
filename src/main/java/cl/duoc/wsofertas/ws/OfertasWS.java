/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.wsofertas.ws;

import cl.duoc.wsofertas.request.LoginRequestVO;
import cl.duoc.wsofertas.request.LoginResponseVO;
import cl.duoc.wsofertas.sessionbeans.OfertasServiceLocal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Esteban Perez
 */
@WebService(serviceName = "OfertasWS")
@Stateless()
public class OfertasWS {

    @EJB
    private OfertasServiceLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "procesarLogin")
    public LoginResponseVO procesarLogin(@WebParam(name = "loginRequest") LoginRequestVO loginRequest) {
        return ejbRef.procesarLogin(loginRequest);
    }
    
}
