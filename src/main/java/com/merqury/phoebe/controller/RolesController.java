/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.controller;


import com.merqury.phoebe.entity.Permissions;
import com.merqury.phoebe.entity.Roles;
import com.merqury.phoebe.facade.PermissionsFacadeLocal;
import com.merqury.phoebe.facade.RolesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author jeffersonbienaime
 */
@Named(value = "rolesController")
@SessionScoped
public class RolesController implements Serializable {

    @EJB
    private RolesFacadeLocal roleFacade;
    @EJB
    private PermissionsFacadeLocal permissionFacade;
    
    
    private Roles role = new Roles();
    
    private Roles selectedRole;
    private List<Roles> selectedRoles;
    

    private Integer[] selectedPermissions;
    private List<Permissions> permissions;

    public RolesController() {
    }

    @PostConstruct
    public void init() {
        permissions = new ArrayList<>();
        permissions.addAll(permissionFacade.findAll());      
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public List<Roles> findAll() {
        return roleFacade.findAll();
    }
    
   
    public String insert() {      
        List<Permissions> collect = Arrays.stream(selectedPermissions).map(
                permissionFacade::find)
                .collect(Collectors.toList());
        role.setPermissionsCollection(collect);
        this.roleFacade.create(role);  
        this.role = new Roles();
        return "roleList";
    }

    public void delete(Roles role) {
        this.roleFacade.remove(role);
    }

    public String update(Roles role) {
        
        this.role = role;
        return "updateRole";
    }
    public String update() {
        List<Permissions> collect = Arrays.stream(selectedPermissions).map(
                permissionFacade::find)
                .collect(Collectors.toList());
        role.setPermissionsCollection(collect);
        this.roleFacade.edit(role);  
        this.role = new Roles();
        return "roleList";
    }

    public Roles getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Roles selectedRole) {
        this.selectedRole = selectedRole;
    }

    public List<Roles> getSelectedRoles() {
        return selectedRoles;
    }

    public void setSelectedRoles(List<Roles> selectedRoles) {
        this.selectedRoles = selectedRoles;
    }
      
    
    public Integer[] getSelectedPermissions() {
        return selectedPermissions;
    }

    public void setSelectedPermissions(Integer[] selectedPermissions) {
        this.selectedPermissions = selectedPermissions;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }
    
}
