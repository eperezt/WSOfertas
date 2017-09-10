/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.wsofertas.sessionbeans;

import cl.duoc.wsofertas.request.LoginRequestVO;
import cl.duoc.wsofertas.request.LoginResponseVO;
import javax.ejb.Local;

/**
 *
 * @author Esteban Perez
 */
@Local
public interface OfertasServiceLocal {
    
    public LoginResponseVO procesarLogin(LoginRequestVO loginRequest);
    
}
