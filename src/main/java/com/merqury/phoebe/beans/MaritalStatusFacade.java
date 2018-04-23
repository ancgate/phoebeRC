/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.beans;

import com.merqury.phoebe.entity.MaritalStatus;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jeffersonbienaime
 */
@Stateless
public class MaritalStatusFacade extends AbstractFacade<MaritalStatus> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaritalStatusFacade() {
        super(MaritalStatus.class);
    }   

    public MaritalStatus find(MaritalStatus selectedMaritalStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
