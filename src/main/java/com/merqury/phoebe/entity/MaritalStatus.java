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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "MaritalStatus", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idMaritalStatus"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaritalStatus.findAll", query = "SELECT m FROM MaritalStatus m"),
    @NamedQuery(name = "MaritalStatus.findByIdMaritalStatus", query = "SELECT m FROM MaritalStatus m WHERE m.idMaritalStatus = :idMaritalStatus"),
    @NamedQuery(name = "MaritalStatus.findByMaritalStatusName", query = "SELECT m FROM MaritalStatus m WHERE m.maritalStatusName = :maritalStatusName"),
    @NamedQuery(name = "MaritalStatus.findByDateCreated", query = "SELECT m FROM MaritalStatus m WHERE m.dateCreated = :dateCreated"),
    @NamedQuery(name = "MaritalStatus.findByCreatedBy", query = "SELECT m FROM MaritalStatus m WHERE m.createdBy = :createdBy"),
    @NamedQuery(name = "MaritalStatus.findByDateModified", query = "SELECT m FROM MaritalStatus m WHERE m.dateModified = :dateModified"),
    @NamedQuery(name = "MaritalStatus.findByModifiedBy", query = "SELECT m FROM MaritalStatus m WHERE m.modifiedBy = :modifiedBy")})
public class MaritalStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaritalStatus", nullable = false)
    private Integer idMaritalStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "maritalStatusName", nullable = false, length = 255)
    private String maritalStatusName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaritalStatus")
    private Collection<Person> personCollection;

    public MaritalStatus() {
    }

    public MaritalStatus(Integer idMaritalStatus) {
        this.idMaritalStatus = idMaritalStatus;
    }

    public MaritalStatus(Integer idMaritalStatus, String maritalStatusName, Date dateCreated, String createdBy, Date dateModified, String modifiedBy) {
        this.idMaritalStatus = idMaritalStatus;
        this.maritalStatusName = maritalStatusName;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.dateModified = dateModified;
        this.modifiedBy = modifiedBy;
    }

    public Integer getIdMaritalStatus() {
        return idMaritalStatus;
    }

    public void setIdMaritalStatus(Integer idMaritalStatus) {
        this.idMaritalStatus = idMaritalStatus;
    }

    public String getMaritalStatusName() {
        return maritalStatusName;
    }

    public void setMaritalStatusName(String maritalStatusName) {
        this.maritalStatusName = maritalStatusName;
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
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaritalStatus != null ? idMaritalStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaritalStatus)) {
            return false;
        }
        MaritalStatus other = (MaritalStatus) object;
        if ((this.idMaritalStatus == null && other.idMaritalStatus != null) || (this.idMaritalStatus != null && !this.idMaritalStatus.equals(other.idMaritalStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.merqury.phoebe.entity.MaritalStatus[ idMaritalStatus=" + idMaritalStatus + " ]";
    }
    
}
