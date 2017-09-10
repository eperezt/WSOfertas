/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.wsofertas.constantes;

/**
 *
 * @author Esteban Perez
 */
public class Constantes {

    public static final String CIFRADO_SHA1 = "SHA1";

    /*
        Esteban Perez 10-09-2017
        Códigos generales de error para WS
     */
    public static final int CODIGO_ERROR_GENERAL_WS = 1;
    public static final String DESC_ERROR_GENERAL_WS = "Error general ejecutando operacion de WS, por favor contacte al administrador";

    /*
        Esteban Perez 10-09-2017
        Códigos específicos de error para WS de Login
     */
    public static final int CODIGO_ERROR_USERNAME_LOGIN_WS = 2;
    public static final String DESC_ERROR_USERNAME_LOGIN_WS = "Error: El login es obligatorio.";

    public static final int CODIGO_ERROR_PASSWORD_LOGIN_WS = 3;
    public static final String DESC_ERROR_PASSWORD_LOGIN_WS = "Error: La password es obligatoria.";

    public static final int CODIGO_ERROR_USUARIO_NO_EXISTE_WS = 4;
    public static final String DESC_ERROR_USUARIO_NO_EXISTE_WS = "Error: El usuario ingresado no se encuentra registrado.";

    public static final int CODIGO_ERROR_PASSWORD_INCORRECTA_WS = 4;
    public static final String DESC_ERROR_PASSWORD_INCORRECTA_WS = "Error: La password ingresada es incorrecta.";

    public static final int CODIGO_LOGIN_CORRECTO_WS = 0;
    public static final String DESC_LOGIN_CORRECTO_WS = "Login correcto.";
}
