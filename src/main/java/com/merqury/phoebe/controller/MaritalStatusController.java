/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.AbstractFacade;
import com.merqury.phoebe.beans.MaritalStatusFacade;
import com.merqury.phoebe.entity.MaritalStatus;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;


/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "maritalStatusController")
@SessionScoped
public class MaritalStatusController extends AbstractController<MaritalStatus> implements Serializable{
    
    @Inject
    private MaritalStatusFacade maritalStatusFacade;
    

    /**
     * Creates a new instance of MaritalStatusController
     */
    public MaritalStatusController() {
        super(MaritalStatus.class);
    }

    @Override
    protected AbstractFacade<MaritalStatus> getFacade() {
        return maritalStatusFacade;
    }
}
