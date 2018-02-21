/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.entity;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "PrayerRequestNature", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"prayerRequestNatureName"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrayerRequestNature.findAll", query = "SELECT p FROM PrayerRequestNature p"),
    @NamedQuery(name = "PrayerRequestNature.findByIdPrayerRequestNature", query = "SELECT p FROM PrayerRequestNature p WHERE p.idPrayerRequestNature = :idPrayerRequestNature"),
    @NamedQuery(name = "PrayerRequestNature.findByPrayerRequestNatureName", query = "SELECT p FROM PrayerRequestNature p WHERE p.prayerRequestNatureName = :prayerRequestNatureName"),
    @NamedQuery(name = "PrayerRequestNature.findByPrayerRequestNatureDescription", query = "SELECT p FROM PrayerRequestNature p WHERE p.prayerRequestNatureDescription = :prayerRequestNatureDescription"),
    @NamedQuery(name = "PrayerRequestNature.findByCreatedBy", query = "SELECT p FROM PrayerRequestNature p WHERE p.createdBy = :createdBy"),
    @NamedQuery(name = "PrayerRequestNature.findByDateCreated", query = "SELECT p FROM PrayerRequestNature p WHERE p.dateCreated = :dateCreated"),
    @NamedQuery(name = "PrayerRequestNature.findByModifiedBy", query = "SELECT p FROM PrayerRequestNature p WHERE p.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "PrayerRequestNature.findByDateModified", query = "SELECT p FROM PrayerRequestNature p WHERE p.dateModified = :dateModified")})
public class PrayerRequestNature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrayerRequestNature", nullable = false)
    private Integer idPrayerRequestNature;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prayerRequestNatureName", nullable = false, length = 45)
    private String prayerRequestNatureName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PrayerRequestNatureDescription", nullable = false, length = 255)
    private String prayerRequestNatureDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "createdBy", nullable = false, length = 45)
    private String createdBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dateCreated", nullable = false, length = 45)
    private String dateCreated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modifiedBy", nullable = false, length = 45)
    private String modifiedBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dateModified", nullable = false, length = 45)
    private String dateModified;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrayerRequestNature")
    private Collection<PrayerRequest> prayerRequestCollection;

    public PrayerRequestNature() {
    }

    public PrayerRequestNature(Integer idPrayerRequestNature) {
        this.idPrayerRequestNature = idPrayerRequestNature;
    }

    public PrayerRequestNature(Integer idPrayerRequestNature, String prayerRequestNatureName, String prayerRequestNatureDescription, String createdBy, String dateCreated, String modifiedBy, String dateModified) {
        this.idPrayerRequestNature = idPrayerRequestNature;
        this.prayerRequestNatureName = prayerRequestNatureName;
        this.prayerRequestNatureDescription = prayerRequestNatureDescription;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.modifiedBy = modifiedBy;
        this.dateModified = dateModified;
    }

    public Integer getIdPrayerRequestNature() {
        return idPrayerRequestNature;
    }

    public void setIdPrayerRequestNature(Integer idPrayerRequestNature) {
        this.idPrayerRequestNature = idPrayerRequestNature;
    }

    public String getPrayerRequestNatureName() {
        return prayerRequestNatureName;
    }

    public void setPrayerRequestNatureName(String prayerRequestNatureName) {
        this.prayerRequestNatureName = prayerRequestNatureName;
    }

    public String getPrayerRequestNatureDescription() {
        return prayerRequestNatureDescription;
    }

    public void setPrayerRequestNatureDescription(String prayerRequestNatureDescription) {
        this.prayerRequestNatureDescription = prayerRequestNatureDescription;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    @XmlTransient
    public Collection<PrayerRequest> getPrayerRequestCollection() {
        return prayerRequestCollection;
    }

    public void setPrayerRequestCollection(Collection<PrayerRequest> prayerRequestCollection) {
        this.prayerRequestCollection = prayerRequestCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrayerRequestNature != null ? idPrayerRequestNature.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrayerRequestNature)) {
            return false;
        }
        PrayerRequestNature other = (PrayerRequestNature) object;
        if ((this.idPrayerRequestNature == null && other.idPrayerRequestNature != null) || (this.idPrayerRequestNature != null && !this.idPrayerRequestNature.equals(other.idPrayerRequestNature))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.merqury.phoebe.entity.PrayerRequestNature[ idPrayerRequestNature=" + idPrayerRequestNature + " ]";
    }
    
}
