/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.beans;

import com.merqury.phoebe.facade.MaritalStatusFacadeLocal;
import com.merqury.phoebe.entity.MaritalStatus;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jeffersonbienaime
 */
@Stateless
public class MaritalStatusFacade extends AbstractFacade<MaritalStatus> implements MaritalStatusFacadeLocal {

    @PersistenceContext(unitName = "com.merqury_phoebe_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaritalStatusFacade() {
        super(MaritalStatus.class);
    }   
    
}
