/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.UserLoginHistoryFacade;
import com.merqury.phoebe.beans.UsersFacade;
import com.merqury.phoebe.entity.UserLoginHistory;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.merqury.phoebe.util.LogTrace;
import com.merqury.phoebe.util.phoebeUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

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

    @Inject
    UsersFacade userFacadeLocal;

    @Inject
    UserLoginHistoryFacade userLoginHistoryFacade;
    UserLoginHistory userLoginHistory;

    public String validateUsernamePassword() throws IOException {
        boolean valid = userFacadeLocal.validateLogin(user, pwd);
        if (valid) {
            HttpSession session = SessionController.getSession();
            session.setAttribute("username", user);
            session.setAttribute("displayName", userFacadeLocal.getDisplayName(user));
            LogTrace.Log("S'est connecté", user, SessionController.hostname, SessionController.computerName, SessionController.remoteAddress);
            userLoginHistory = new UserLoginHistory(SessionController.hostname, SessionController.computerName, SessionController.remoteAddress,
                    userFacadeLocal.getUserRole(user), phoebeUtil.CurrentDate(), userFacadeLocal.getUserByUsername(user));
            userLoginHistoryFacade.create(userLoginHistory);
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

    public String logout() {
        HttpSession session = SessionController.getSession();
        try {
            LogTrace.Log("s'est déconnecté", SessionController.getUserName(), SessionController.hostname, SessionController.computerName, SessionController.remoteAddress);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.invalidate();
        return "/login";
    }

}
