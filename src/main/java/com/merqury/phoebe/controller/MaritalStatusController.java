/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.MaritalStatusFacade;
import com.merqury.phoebe.entity.MaritalStatus;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "maritalStatusController")
@SessionScoped
public class MaritalStatusController implements Serializable {
    
    @EJB
    private MaritalStatusFacade maritalStatusFacade;
   
    private MaritalStatus maritalStatus = new MaritalStatus();
    private MaritalStatus selectedMaritalStatus;
    private List<MaritalStatus> selectedMaritalStatuses;
    
    private Integer maritalStatusId; 
    private List<MaritalStatus> maritalStatuses;
    
    

    /**
     * Creates a new instance of MaritalStatusController
     */
    public MaritalStatusController() {
    }
    
    
    
}
