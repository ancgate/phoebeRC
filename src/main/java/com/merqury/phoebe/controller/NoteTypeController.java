/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import java.io.Serializable;
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

    /**
     * Creates a new instance of NoteTypeController
     */
    public NoteTypeController() {
    }
    
}
