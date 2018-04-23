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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "orgParamController")
@SessionScoped
public class OrgParamController implements Serializable {

    @Inject
    private OrgParamFacade orgParamfacade;
    private OrgParam orgParam = new OrgParam();

    private OrgParam selectedorgParam;
    private List<OrgParam> orgParams;

    @PostConstruct
    public void init() {
        orgParams = new ArrayList<>();
        orgParams.addAll(orgParamfacade.findAll());
    }

    public String insert() {
        this.orgParamfacade.create(orgParam);
        this.orgParam = new OrgParam();
        return "orgParamList";
    }

    public void delete(OrgParam orgParam) {
        this.orgParamfacade.remove(orgParam);
    }

    public String update(OrgParam orgParam) {
        this.orgParam = orgParam;
        return "updateOrgParam";
    }

    public String update() {
        this.orgParamfacade.edit(orgParam);
        return "orgParamList";
    }

    public OrgParamController() {
    }

    public OrgParamFacade getOrgParamfacade() {
        return orgParamfacade;
    }

    public void setOrgParamfacade(OrgParamFacade orgParamfacade) {
        this.orgParamfacade = orgParamfacade;
    }

    public OrgParam getOrgParam() {
        return orgParam;
    }

    public void setOrgParam(OrgParam orgParam) {
        this.orgParam = orgParam;
    }

    public OrgParam getSelectedorgParam() {
        return selectedorgParam;
    }

    public void setSelectedorgParam(OrgParam selectedorgParam) {
        this.selectedorgParam = selectedorgParam;
    }

    public List<OrgParam> getOrgParams() {
        return orgParams;
    }

    public void setOrgParams(List<OrgParam> orgParams) {
        this.orgParams = orgParams;
    }

}
