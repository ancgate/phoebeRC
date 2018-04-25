/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.UsersFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "authorizationController")
@SessionScoped
public class AuthorizationController implements Serializable {
    
    @Inject
    UsersFacade userFacade;
    /**
     * Creates a new instance of AuthorizationController
     */
    public AuthorizationController() {
    }
    public Boolean hasPermissions(String permission) {
        userFacade = new UsersFacade();
        return userFacade.hasPermissions(permission, SessionController.getUserName());
    }

}
