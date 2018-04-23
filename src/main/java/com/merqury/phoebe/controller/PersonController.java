/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.MaritalStatusFacade;
import com.merqury.phoebe.beans.PersonFacade;
import com.merqury.phoebe.entity.MaritalStatus;
import com.merqury.phoebe.entity.NoteType;
import com.merqury.phoebe.entity.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "personController")
@SessionScoped
public class PersonController implements Serializable {

    /**
     * Creates a new instance of PersonController
     */
    @Inject
    private PersonFacade personFacade;
    private Person person = new Person();
    private List<Person> people;
    
    private MaritalStatus maritalStatus;
    private List<MaritalStatus> maritalStatuses;
    private Integer selectedMaritalStatus;
    @Inject
    private MaritalStatusFacade maritalStatusfacade;

    public PersonController() {
    }

    @PostConstruct
    public void init() {
        people = new ArrayList<>();
        people.addAll(personFacade.findAll());
        maritalStatuses = new ArrayList<>();
        maritalStatuses.addAll(maritalStatusfacade.findAll());
    }

    public String insert() {
  
        maritalStatus = this.maritalStatusfacade.find(selectedMaritalStatus);
        person.setIdMaritalStatus(maritalStatus);
        this.personFacade.create(person);
        this.person = new Person();
        return "personList";
    }

    public void delete(Person person) {
        this.personFacade.remove(person);
    }

    public String update(Person person) {
        this.person = person;
        return "updatePerson";
    }

    public String update() {
        maritalStatus = this.maritalStatusfacade.find(selectedMaritalStatus);
        person.setIdMaritalStatus(maritalStatus);
        this.personFacade.edit(person);
        return "personList";
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

    public Integer getSelectedMaritalStatus() {
        return selectedMaritalStatus;
    }

    public void setSelectedMaritalStatus(Integer selectedMaritalStatus) {
        this.selectedMaritalStatus = selectedMaritalStatus;
    }

    public MaritalStatusFacade getMaritalStatusfacade() {
        return maritalStatusfacade;
    }

    public void setMaritalStatusfacade(MaritalStatusFacade maritalStatusfacade) {
        this.maritalStatusfacade = maritalStatusfacade;
    }
    
    
    

}
