/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.entity.Roles;
import com.merqury.phoebe.entity.Users;
import com.merqury.phoebe.facade.RolesFacadeLocal;
import com.merqury.phoebe.facade.UsersFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "usersController")
@SessionScoped
public class UsersController implements Serializable {

    private Users user = new Users();
    private Users selectedUser;
    private List<Users> selectedUsers;

    private String username;
    private List<Users> usernames;

    private Integer[] selectedRoles;
    private List<Roles> roles;
   
    
    
    @EJB 
    UsersFacadeLocal userFacadeLocal;
    @EJB
    RolesFacadeLocal rolesFacadeLocal;
    

    @PostConstruct
    public void init() {
        roles = new ArrayList<>();
        roles.addAll(rolesFacadeLocal.findAll());
        usernames = new ArrayList<>();
        usernames.addAll(userFacadeLocal.findAll());
    }
        
     /**
     * Creates a new instance of UsersController
     */
    public UsersController() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Users selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<Users> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<Users> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Users> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<Users> usernames) {
        this.usernames = usernames;
    }

    public Integer[] getSelectedRoles() {
        return selectedRoles;
    }

    public void setSelectedRoles(Integer[] selectedRoles) {
        this.selectedRoles = selectedRoles;
    }



    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
    
    public String insert() {
        this.userFacadeLocal.create(user);
        this.user = new Users();
        return "index";
    }

    public void delete(Users user) {
        this.userFacadeLocal.remove(user);
    }

    public String update(Users user) {
       this.user=user;
       return "updateUser";
    }

    public String update() {       
        System.out.println(selectedRoles);
        user=userFacadeLocal.find(username);
        List<Roles> rolesAssigned = Arrays.stream(selectedRoles).map(
                rolesFacadeLocal::find)
                .collect(Collectors.toList());
        user.setRolesCollection(rolesAssigned);
        this.userFacadeLocal.edit(user);
        return "userList";
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Users) event.getObject()).getUsername());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Users) event.getObject()).getUsername());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
