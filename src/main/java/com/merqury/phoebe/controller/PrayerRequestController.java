/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.MaritalStatusFacade;
import com.merqury.phoebe.beans.PersonFacade;
import com.merqury.phoebe.beans.PrayerRequestFacade;
import com.merqury.phoebe.entity.MaritalStatus;
import com.merqury.phoebe.entity.Person;
import com.merqury.phoebe.entity.PrayerRequest;
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
@Named(value = "prayerRequestController")
@SessionScoped
public class PrayerRequestController implements Serializable {

    @Inject
    private PersonFacade personFacade;
    private Person person = new Person();
    private List<Person> people;
    private Integer selectedPerson;
    
    
    private PrayerRequest prayerRequest;
    private List<PrayerRequest> prayerRequests;
    @Inject
    private PrayerRequestFacade prayerRequestFacade;
    
    
    /**
     * Creates a new instance of PrayerRequestController
     */
    public PrayerRequestController() {
    }

    @PostConstruct
    public void init() {
        people = new ArrayList<>();
        people.addAll(personFacade.findAll());
        prayerRequests = new ArrayList<>();
        prayerRequests.addAll(prayerRequestFacade.findAll());
    }

    public String insert() {

        person = this.personFacade.find(selectedPerson);
        prayerRequest.setIdPerson(person);
        this.prayerRequestFacade.create(prayerRequest);
        this.prayerRequest = new PrayerRequest();
        return "prayerRequestList";
    }

    public void delete(Person person) {
        this.personFacade.remove(person);
    }

    public String update(Person person) {
        this.person = person;
        return "updatePrayerRequest";
    }

    public String update() {
        person = this.personFacade.find(selectedPerson);
        prayerRequest.setIdPerson(person);
        this.prayerRequestFacade.edit(prayerRequest);
        return "prayerRequestList";
    }

    public PersonFacade getPersonFacade() {
        return personFacade;
    }

    public void setPersonFacade(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Integer getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Integer selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public PrayerRequest getPrayerRequest() {
        return prayerRequest;
    }

    public void setPrayerRequest(PrayerRequest prayerRequest) {
        this.prayerRequest = prayerRequest;
    }

    public List<PrayerRequest> getPrayerRequests() {
        return prayerRequests;
    }

    public void setPrayerRequests(List<PrayerRequest> prayerRequests) {
        this.prayerRequests = prayerRequests;
    }

    public PrayerRequestFacade getPrayerRequestFacade() {
        return prayerRequestFacade;
    }

    public void setPrayerRequestFacade(PrayerRequestFacade prayerRequestFacade) {
        this.prayerRequestFacade = prayerRequestFacade;
    }
    
    
    

}
