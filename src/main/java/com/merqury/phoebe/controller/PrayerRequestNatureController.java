/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import com.merqury.phoebe.entity.PrayerRequestNature;
import com.merqury.phoebe.beans.PrayerRequestNatureFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "prayerRequestNatureController")
@SessionScoped
public class PrayerRequestNatureController implements Serializable {

    @Inject
    PrayerRequestNatureFacade prayerRequestNatureFacade;
    PrayerRequestNature prayerRequestNature = new PrayerRequestNature();

    private PrayerRequestNature selectedprayerRequestNature;
    private List<PrayerRequestNature> prayerRequestNatures;

    @PostConstruct
    public void init() {
        prayerRequestNatures = new ArrayList<>();
        prayerRequestNatures.addAll(prayerRequestNatureFacade.findAll());
    }

    public String insert() {
        this.prayerRequestNatureFacade.create(prayerRequestNature);
        this.prayerRequestNature = new PrayerRequestNature();
        return "prayerRequestNatureList";
    }

    public void delete(PrayerRequestNature prayerRequestNature) {
        this.prayerRequestNatureFacade.remove(prayerRequestNature);
    }

    public String update(PrayerRequestNature prayerRequestNature) {
        this.prayerRequestNature = prayerRequestNature;
        return "updatePrayerRequestNature";
    }

    public String update() {
        this.prayerRequestNatureFacade.edit(prayerRequestNature);
        return "prayerRequestNatureList";
    }

    /**
     * Creates a new instance of PrayerRequestNatureController
     */
    public PrayerRequestNatureController() {
    }

    public PrayerRequestNatureFacade getPrayerRequestNatureFacade() {
        return prayerRequestNatureFacade;
    }

    public void setPrayerRequestNatureFacade(PrayerRequestNatureFacade prayerRequestNatureFacade) {
        this.prayerRequestNatureFacade = prayerRequestNatureFacade;
    }

    public PrayerRequestNature getPrayerRequestNature() {
        return prayerRequestNature;
    }

    public void setPrayerRequestNature(PrayerRequestNature prayerRequestNature) {
        this.prayerRequestNature = prayerRequestNature;
    }

    public PrayerRequestNature getSelectedprayerRequestNature() {
        return selectedprayerRequestNature;
    }

    public void setSelectedprayerRequestNature(PrayerRequestNature selectedprayerRequestNature) {
        this.selectedprayerRequestNature = selectedprayerRequestNature;
    }

    public List<PrayerRequestNature> getPrayerRequestNatures() {
        return prayerRequestNatures;
    }

    public void setPrayerRequestNatures(List<PrayerRequestNature> prayerRequestNatures) {
        this.prayerRequestNatures = prayerRequestNatures;
    }

}
