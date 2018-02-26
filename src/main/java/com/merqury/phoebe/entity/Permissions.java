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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Permissions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"permissionName"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissions.findAll", query = "SELECT p FROM Permissions p"),
    @NamedQuery(name = "Permissions.findByIdPermission", query = "SELECT p FROM Permissions p WHERE p.idPermission = :idPermission"),
    @NamedQuery(name = "Permissions.findByPermissionName", query = "SELECT p FROM Permissions p WHERE p.permissionName = :permissionName"),
    @NamedQuery(name = "Permissions.findByPermissionDescription", query = "SELECT p FROM Permissions p WHERE p.permissionDescription = :permissionDescription"),
    @NamedQuery(name = "Permissions.findByDateCreated", query = "SELECT p FROM Permissions p WHERE p.dateCreated = :dateCreated"),
    @NamedQuery(name = "Permissions.findByCreatedBy", query = "SELECT p FROM Permissions p WHERE p.createdBy = :createdBy"),
    @NamedQuery(name = "Permissions.findByDateModified", query = "SELECT p FROM Permissions p WHERE p.dateModified = :dateModified"),
    @NamedQuery(name = "Permissions.FindPermissionsInRole", query = "SELECT p FROM Permissions p  INNER JOIN  p.rolesCollection role WHERE role.idRole = :idRole"),
    @NamedQuery(name = "Permissions.findByModifiedBy", query = "SELECT p FROM Permissions p WHERE p.modifiedBy = :modifiedBy")})
public class Permissions implements Identifiable, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermission", nullable = false)
    private Integer idPermission;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "permissionName", nullable = false, length = 45)
    private String permissionName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "permissionDescription", nullable = false, length = 45)
    private String permissionDescription;
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
    @ManyToMany(mappedBy = "permissionsCollection")
    private Collection<Roles> rolesCollection;

    public Permissions() {
    }

    public Permissions(Integer idPermission) {
        this.idPermission = idPermission;
    }

    public Permissions(Integer idPermission, String permissionName, String permissionDescription, Date dateCreated, String createdBy, Date dateModified, String modifiedBy) {
        this.idPermission = idPermission;
        this.permissionName = permissionName;
        this.permissionDescription = permissionDescription;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.dateModified = dateModified;
        this.modifiedBy = modifiedBy;
    }

    @Override
    public Integer getIdentifier() {
        return idPermission ;
    }

    public void setIdPermission(Integer idPermission) {
        this.idPermission = idPermission;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
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
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermission != null ? idPermission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissions)) {
            return false;
        }
        Permissions other = (Permissions) object;
        if ((this.idPermission == null && other.idPermission != null) || (this.idPermission != null && !this.idPermission.equals(other.idPermission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.merqury.phoebe.entity.Permissions[ idPermission=" + idPermission + " ]";
    }
    
}
