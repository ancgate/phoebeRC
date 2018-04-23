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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "maritalStatusController")
@SessionScoped
public class MaritalStatusController implements Serializable {

    @Inject
    private MaritalStatusFacade maritalStatusFacade;
    private MaritalStatus maritalStatus = new MaritalStatus();
    private List<MaritalStatus> maritalStatuses;

    /**
     * Creates a new instance of MaritalStatusController
     */
    public MaritalStatusController() {

    }

    @PostConstruct
    public void init() {
        maritalStatuses = new ArrayList<>();
        maritalStatuses.addAll(maritalStatusFacade.findAll());
    }

    public String insert() {
        this.maritalStatusFacade.create(maritalStatus);
        this.maritalStatus = new MaritalStatus();
        return "maritalStatusList";
    }

    public void delete(MaritalStatus maritalStatus) {
        this.maritalStatusFacade.remove(maritalStatus);
    }

    public String update(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
        return "updateMaritalStatus";
    }

    public String update() {
        this.maritalStatusFacade.edit(maritalStatus);
        return "maritalStatusList";
    }

    public MaritalStatusFacade getMaritalStatusFacade() {
        return maritalStatusFacade;
    }

    public void setMaritalStatusFacade(MaritalStatusFacade maritalStatusFacade) {
        this.maritalStatusFacade = maritalStatusFacade;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<MaritalStatus> getMaritalStatuses() {
        return maritalStatuses;
    }

    public void setMaritalStatuses(List<MaritalStatus> maritalStatuses) {
        this.maritalStatuses = maritalStatuses;
    }
    
    

}
