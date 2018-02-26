/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.beans;

import com.merqury.phoebe.entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author jeffersonbienaime
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    public Boolean hasPermissions(String permissionDescription, String username) {

        String sql = "SELECT permissionName FROM PERMISSIONS WHERE idPermission IN ( SELECT DISTINCT(idPermission) FROM Roles_has_Permissions WHERE idRole IN(SELECT DISTINCT(idRole) FROM Users_has_Roles ur JOIN USERS u ON u.idUser=ur.idUser WHERE u.username='" + username + "')) order by permissionName;";
        Query query = em.createNativeQuery(sql);
        return query.getResultList().contains(permissionDescription);

    }

    public String getDisplayName(String username) {

        TypedQuery<Users> query = em.createNamedQuery("Users.findByUsername", Users.class);
        query.setParameter("username", username);
        return query.getSingleResult().getFirstName() + query.getSingleResult().getLastName();
    }

    public Boolean validateLogin(String username, String password) {

        Users user = (Users) em.createQuery("Select u from Users u where u.username=:username and u.password=:password")
                .setParameter("username", username)
                .setParameter("password", password).getSingleResult();
        return user != null;

    }

    public Boolean userExist(String Username) {
        return !getDisplayName(Username).isEmpty();

    }

    public Users getUserByUsername(String username) {
        TypedQuery<Users> query = em.createNamedQuery("Users.findByUsername", Users.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    public String getUserRole(String username) {      
       String role;
        role = (String) em.createQuery("Select r.roleName from Roles r INNER JOIN r.usersCollection u where u.username=:username")
                .setParameter("username", username)
                .getSingleResult();
        return role;
    }

}
