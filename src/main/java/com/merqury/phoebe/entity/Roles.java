/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeffersonbienaime
 */
@Entity
@Table(name = "Roles", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"roleName"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByIdRole", query = "SELECT r FROM Roles r WHERE r.idRole = :idRole"),
    @NamedQuery(name = "Roles.findByRoleName", query = "SELECT r FROM Roles r WHERE r.roleName = :roleName"),
    @NamedQuery(name = "Roles.findByRoleDescription", query = "SELECT r FROM Roles r WHERE r.roleDescription = :roleDescription"),
    @NamedQuery(name = "Roles.findByDateCreated", query = "SELECT r FROM Roles r WHERE r.dateCreated = :dateCreated"),
    @NamedQuery(name = "Roles.findByCreatedBy", query = "SELECT r FROM Roles r WHERE r.createdBy = :createdBy"),
    @NamedQuery(name = "Roles.findByDateModified", query = "SELECT r FROM Roles r WHERE r.dateModified = :dateModified"),
    @NamedQuery(name = "Roles.findByModifiedBy", query = "SELECT r FROM Roles r WHERE r.modifiedBy = :modifiedBy")})
public class Roles implements Identifiable, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRole", nullable = false)
    private Integer idRole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "roleName", nullable = false, length = 45)
    private String roleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "roleDescription", nullable = false, length = 45)
    private String roleDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "createdBy", nullable = false, length = 255)
    private String createdBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateModified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "modifiedBy", nullable = false, length = 255)
    private String modifiedBy;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Roles_has_Permissions", joinColumns = {
        @JoinColumn(name = "idRole", referencedColumnName = "idRole", nullable = false )}, inverseJoinColumns = {
        @JoinColumn(name = "idPermission", referencedColumnName = "idPermission", nullable = false)})
    private Collection<Permissions> permissionsCollection;    
    @ManyToMany(mappedBy = "rolesCollection")
    private Collection<Users> usersCollection;

    public Roles() {
    }

    public Roles(Integer idRole) {
        this.idRole = idRole;
    }

    public Roles(Integer idRole, String roleName, String roleDescription, Date dateCreated, String createdBy, Date dateModified, String modifiedBy) {
        this.idRole = idRole;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.dateModified = dateModified;
        this.modifiedBy = modifiedBy;
    }

    @Override
    public Integer getIdentifier() {
        return idRole ;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @XmlTransient
    public Collection<Permissions> getPermissionsCollection() {
        return permissionsCollection;
    }

    public void setPermissionsCollection(Collection<Permissions> permissionsCollection) {
        this.permissionsCollection = permissionsCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.merqury.phoebe.entity.Roles[ idRole=" + idRole + " ]";
    }
    
}
