/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.AbstractFacade;
import com.merqury.phoebe.beans.NoteTypeFacade;
import com.merqury.phoebe.entity.NoteType;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "noteTypeController")
@SessionScoped
public class NoteTypeController extends AbstractController<NoteType> implements Serializable {

    @Inject
    private NoteTypeFacade noteTypeFacade;
   
    /**
     * Creates a new instance of NoteTypeTypeController
     */
    public NoteTypeController() {
        super(NoteType.class);
    }

    @Override
    protected AbstractFacade<NoteType> getFacade() {
        return noteTypeFacade;
    }
    
}
