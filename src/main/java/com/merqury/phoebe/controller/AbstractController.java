/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.AbstractFacade;
import com.merqury.phoebe.entity.Identifiable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author jeffersonbienaime
 * @param <T>
 */
public abstract class AbstractController<T extends Identifiable> {

    private final Class<T> klazz;

    protected abstract AbstractFacade<T> getFacade();
   
    private T entity = newEntity();
    
    private T selectedEntity;

    private List<T> entities;

    protected AbstractController(Class<T> klazz){
        this.klazz = klazz;
    }
    
    private T newEntity(){
        try{
            return klazz.newInstance();
        }catch(SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException ex){
            throw new RuntimeException(ex);
        }
    }

    @PostConstruct
    public void init() {
        entities = new ArrayList<>();
        entities.addAll(getFacade().findAll());
    }

    public String insert() {
        this.getFacade().create(entity);
        this.entity = newEntity();
        return "index" + klazz.getName();
    }

    public void delete(T entity) {
        this.getFacade().remove(entity);
    }

    public String update(T entity) {
        this.entity = entity;
        return "update" + klazz.getName();
    }

    public String update() {
        System.out.println(selectedEntity);
        entity = getFacade().find(selectedEntity.getIdentifier());
        this.getFacade().edit(entity);
        return "list" + klazz.getName();
    }

}
