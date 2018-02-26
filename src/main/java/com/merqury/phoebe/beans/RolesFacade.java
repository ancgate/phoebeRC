/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.beans;

import com.merqury.phoebe.entity.Permissions;
import com.merqury.phoebe.entity.Roles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author jeffersonbienaime
 */
@Stateless
public class RolesFacade extends AbstractFacade<Roles> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public RolesFacade() {
        super(Roles.class);
    }
    
    public List <Permissions> listOfPermissionsInRole(Integer idRole){        
      TypedQuery<Permissions> query = em.createNamedQuery("Permissions.FindPermissionsInRole", Permissions.class);  
      query.setParameter("idRole", idRole);  
      return query.getResultList();
      //String sql = "SELECT idPermission, PermissionName FROM PERMISSIONS WHERE idPermission IN ( SELECT DISTINCT(idPermission) FROM Roles_has_Permissions WHERE idRole = '" + idRole + "');";  
    }
    
}
