/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.AbstractFacade;
import com.merqury.phoebe.beans.OrgParamFacade;
import com.merqury.phoebe.entity.OrgParam;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "orgParamController")
@SessionScoped
public class OrgParamController extends AbstractController<OrgParam> implements Serializable{

    @Inject
    private OrgParamFacade orgParamfacade;
    
    /**
     * Creates a new instance of OrgParamController
     */
    public OrgParamController() {
        super(OrgParam.class);
    }

    @Override
    protected AbstractFacade<OrgParam> getFacade() {
        return  orgParamfacade;
    }   
    
    
}
