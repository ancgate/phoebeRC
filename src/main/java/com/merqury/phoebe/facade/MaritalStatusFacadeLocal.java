/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.facade;

import com.merqury.phoebe.entity.MaritalStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeffersonbienaime
 */
@Local
public interface MaritalStatusFacadeLocal {

    void create(MaritalStatus maritalStatus);

    void edit(MaritalStatus maritalStatus);

    void remove(MaritalStatus maritalStatus);

    MaritalStatus find(Object id);

    List<MaritalStatus> findAll();

    List<MaritalStatus> findRange(int[] range);

    int count();
    
}
