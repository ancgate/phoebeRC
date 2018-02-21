/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.facade;

import com.merqury.phoebe.entity.Permissions;
import com.merqury.phoebe.entity.Roles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeffersonbienaime
 */
@Local
public interface RolesFacadeLocal {

    void create(Roles roles);

    void edit(Roles roles);

    void remove(Roles roles);

    Roles find(Object id);

    List<Roles> findAll();

    List<Roles> findRange(int[] range);

    int count();
    
    List <Permissions> listOfPermissionsInRole(Integer idRole);
    
    
}
