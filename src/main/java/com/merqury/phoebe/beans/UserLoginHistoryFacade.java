/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.beans;

import com.merqury.phoebe.entity.UserLoginHistory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jeffersonbienaime
 */
@Stateless
public class UserLoginHistoryFacade extends AbstractFacade<UserLoginHistory> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserLoginHistoryFacade() {
        super(UserLoginHistory.class);
    }
    
}
