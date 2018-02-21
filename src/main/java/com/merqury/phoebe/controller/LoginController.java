/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.merqury.phoebe.facade.*;
import com.merqury.phoebe.util.LogTrace;
import javax.ejb.EJB;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String pwd;
    private String msg;
    private String user;
    
    @EJB   
    UsersFacadeLocal userFacadeLocal; 
    
        public String validateUsernamePassword() throws IOException {
        boolean valid = userFacadeLocal.validateLogin(user, pwd);
        if (valid) {
            HttpSession session = SessionController.getSession();
            session.setAttribute("username", user);
            session.setAttribute("displayName",userFacadeLocal.getDisplayName(user));
            LogTrace.Log("S'est connecté", user,SessionController.hostname,SessionController.computerName,SessionController.remoteAddress);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Bienvenue",
                            user));
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Nom Utilisateur ou Mot de passe incorrect",
                            "Entrez à nouveau le nom d'utilisateur et le mot de passe"));
            return "login";
        }
    }  
    /**
     * Creates a new instance of LoginBean
     */
    public LoginController() {
    }
    
}
