/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.NoteTypeFacade;
import com.merqury.phoebe.entity.NoteType;
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
@Named(value = "noteTypeController")
@SessionScoped
public class NoteTypeController implements Serializable {

    @Inject
    private NoteTypeFacade noteTypeFacade;
    private NoteType noteType = new NoteType();
    private List<NoteType> noteTypes;

    /**
     * Creates a new instance of NoteTypeTypeController
     */
    public NoteTypeController() {

    }

    @PostConstruct
    public void init() {
        noteTypes = new ArrayList<>();
        noteTypes.addAll(noteTypeFacade.findAll());
    }

    public String insert() {
        this.noteTypeFacade.create(noteType);
        this.noteType = new NoteType();
        return "orgParamList";
    }

    public void delete(NoteType noteType) {
        this.noteTypeFacade.remove(noteType);
    }

    public String update(NoteType noteType) {
        this.noteType = noteType;
        return "updateOrgParam";
    }

    public String update() {
        this.noteTypeFacade.edit(noteType);
        return "orgParamList";
    }

    public NoteTypeFacade getNoteTypeFacade() {
        return noteTypeFacade;
    }

    public void setNoteTypeFacade(NoteTypeFacade noteTypeFacade) {
        this.noteTypeFacade = noteTypeFacade;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    public List<NoteType> getNoteTypes() {
        return noteTypes;
    }

    public void setNoteTypes(List<NoteType> noteTypes) {
        this.noteTypes = noteTypes;
    }
    
    

}
