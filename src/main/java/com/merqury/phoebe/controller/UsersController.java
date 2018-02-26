/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;

import com.merqury.phoebe.beans.RolesFacade;
import com.merqury.phoebe.beans.UsersFacade;
import com.merqury.phoebe.entity.Roles;
import com.merqury.phoebe.entity.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "usersController")
@SessionScoped
public class UsersController implements Serializable {

    @Inject
    UsersFacade userFacade;
    private Users user = new Users();
    private Users selectedUser;
    private List<Users> selectedUsers;

    private Integer userId;

    private List<Users> usernames;

    private Integer[] selectedRoles;
    private List<Roles> roles;
    @Inject
    RolesFacade rolesFacade;

    @PostConstruct
    public void init() {
        roles = new ArrayList<>();
        roles.addAll(rolesFacade.findAll());
        usernames = new ArrayList<>();
        usernames.addAll(userFacade.findAll());
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        this.userFacade.create(user);
        this.user = new Users();
        return "index";
    }

    public void delete(Users user) {
        this.userFacade.remove(user);
    }

    public String update(Users user) {
        this.user = user;
        return "updateUser";
    }

    public String update() {
        System.out.println(selectedRoles);
        user = userFacade.find(userId);
        List<Roles> rolesAssigned = Arrays.stream(selectedRoles).map(rolesFacade::find)
                .collect(Collectors.toList());
        user.setRolesCollection(rolesAssigned);
        this.userFacade.edit(user);
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
