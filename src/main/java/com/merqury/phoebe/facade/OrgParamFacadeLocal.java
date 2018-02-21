/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.facade;

import com.merqury.phoebe.entity.OrgParam;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeffersonbienaime
 */
@Local
public interface OrgParamFacadeLocal {

    void create(OrgParam orgParam);

    void edit(OrgParam orgParam);

    void remove(OrgParam orgParam);

    OrgParam find(Object id);

    List<OrgParam> findAll();

    List<OrgParam> findRange(int[] range);

    int count();
    
}
