/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.NoteFacade;
import com.merqury.phoebe.beans.NoteTypeFacade;
import com.merqury.phoebe.entity.Note;
import com.merqury.phoebe.entity.NoteType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "noteController")
@SessionScoped
public class NoteController implements Serializable {

    @Inject
    private NoteFacade noteFacadeLocal;
    private Note note = new Note();
    
    private Note selectedNote;
    private List<Note> selectedNotes;

    private Integer noteId;
    private List<Note> notes;

    private Integer[] selectedNoteType;
    private List<NoteType> noteTypes;
    @Inject
    NoteTypeFacade noteTypeFacadeLocal;

    private LazyDataModel <Note> lazyModelNote; 
   
    /**
     * Creates a new instance of NoteController
     */
    public NoteController() {
    }

    @PostConstruct
    public void init() {
        noteTypes = new ArrayList<>();
        noteTypes.addAll(noteTypeFacadeLocal.findAll());
        notes = new ArrayList<>();
        notes.addAll(noteFacadeLocal.findAll());
    }

    public String insert() {
        this.noteFacadeLocal.create(note);
        this.note = new Note();
        return "index";
    }

    public void delete(Note note) {
        this.noteFacadeLocal.remove(note);
    }

    public String update(Note note) {
        this.note = note;
        return "updateNote";
    }

    public String update() {
        System.out.println(selectedNote);
        note = noteFacadeLocal.find(selectedNote.getIdentifier());
        this.noteFacadeLocal.edit(note);
        return "userList";
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Note Selected", ((Note) event.getObject()).getIdNoteType().getNoteTypeName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Note Unselected", ((Note) event.getObject()).getIdNoteType().getNoteTypeName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
