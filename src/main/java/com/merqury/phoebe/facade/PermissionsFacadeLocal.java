/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.facade;

import com.merqury.phoebe.entity.Permissions;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeffersonbienaime
 */
@Local
public interface PermissionsFacadeLocal {

    void create(Permissions permissions);

    void edit(Permissions permissions);

    void remove(Permissions permissions);

    Permissions find(Object id);

    List<Permissions> findAll();

    List<Permissions> findRange(int[] range);

    int count();
    
}