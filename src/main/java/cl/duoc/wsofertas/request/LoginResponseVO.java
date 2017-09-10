/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.wsofertas.request;

/**
 *
 * @author Esteban Perez
 */
public class LoginResponseVO {
    
    private String respuesta;
    private int codigoRespuesta;
    private long codigoUsuario;

    public LoginResponseVO() {
        this.respuesta = "";
        this.codigoRespuesta = 0;
        this.codigoUsuario = 0;
    }

    public LoginResponseVO(String respuesta, int codigoRespuesta, long codigoUsuario) {
        this.respuesta = respuesta;
        this.codigoRespuesta = codigoRespuesta;
        this.codigoUsuario = codigoUsuario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}
