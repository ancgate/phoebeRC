/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "orgParamController")
@SessionScoped
public class OrgParamController implements Serializable{

    /**
     * Creates a new instance of OrgParamController
     */
    public OrgParamController() {
    }
    
}
