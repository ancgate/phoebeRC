/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.NoteTypeFacade;
import com.merqury.phoebe.entity.NoteType;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "noteTypeController")
@SessionScoped
public class NoteTypeController implements Serializable {

        @EJB
    private NoteTypeFacade noteTypeFacade;
   
    private NoteType noteType = new NoteType();
    private NoteType selectednoteType;
    private List<NoteType> selectednoteTypes;
    
    private Integer noteTypeId; 
    private List<NoteType> noteTypes;
    
    
    
    /**
     * Creates a new instance of NoteTypeTypeController
     */
    public NoteTypeController() {
    }
    
}
