/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merqury.phoebe.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jeffersonbienaime
 */
@Entity
@Table(name = "PrayerRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrayerRequest.findAll", query = "SELECT p FROM PrayerRequest p"),
    @NamedQuery(name = "PrayerRequest.findByIdPrayerRequest", query = "SELECT p FROM PrayerRequest p WHERE p.idPrayerRequest = :idPrayerRequest"),
    @NamedQuery(name = "PrayerRequest.findByPrayerRequestDescription", query = "SELECT p FROM PrayerRequest p WHERE p.prayerRequestDescription = :prayerRequestDescription"),
    @NamedQuery(name = "PrayerRequest.findByDatePrayerRequest", query = "SELECT p FROM PrayerRequest p WHERE p.datePrayerRequest = :datePrayerRequest"),
    @NamedQuery(name = "PrayerRequest.findByCreatedBy", query = "SELECT p FROM PrayerRequest p WHERE p.createdBy = :createdBy"),
    @NamedQuery(name = "PrayerRequest.findByDateCreated", query = "SELECT p FROM PrayerRequest p WHERE p.dateCreated = :dateCreated"),
    @NamedQuery(name = "PrayerRequest.findByModifiedBy", query = "SELECT p FROM PrayerRequest p WHERE p.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "PrayerRequest.findByDateModified", query = "SELECT p FROM PrayerRequest p WHERE p.dateModified = :dateModified")})
public class PrayerRequest implements Identifiable, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrayerRequest", nullable = false)
    private Integer idPrayerRequest;
    @Size(max = 255)
    @Column(name = "prayerRequestDescription", length = 255)
    private String prayerRequestDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datePrayerRequest", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePrayerRequest;
    @Size(max = 45)
    @Column(name = "createdBy", length = 45)
    private String createdBy;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Size(max = 45)
    @Column(name = "modifiedBy", length = 45)
    private String modifiedBy;
    @Column(name = "DateModified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    @JoinColumn(name = "idPerson", referencedColumnName = "idPerson", nullable = false)
    @ManyToOne(optional = false)
    private Person idPerson;
    @JoinColumn(name = "idPrayerRequestNature", referencedColumnName = "idPrayerRequestNature", nullable = false)
    @ManyToOne(optional = false)
    private PrayerRequestNature idPrayerRequestNature;

    public PrayerRequest() {
    }

    public PrayerRequest(Integer idPrayerRequest) {
        this.idPrayerRequest = idPrayerRequest;
    }

    public PrayerRequest(Integer idPrayerRequest, Date datePrayerRequest) {
        this.idPrayerRequest = idPrayerRequest;
        this.datePrayerRequest = datePrayerRequest;
    }

    @Override
    public Integer getIdentifier() {
        return idPrayerRequest ;
    }

    public void setIdPrayerRequest(Integer idPrayerRequest) {
        this.idPrayerRequest = idPrayerRequest;
    }

    public String getPrayerRequestDescription() {
        return prayerRequestDescription;
    }

    public void setPrayerRequestDescription(String prayerRequestDescription) {
        this.prayerRequestDescription = prayerRequestDescription;
    }

    public Date getDatePrayerRequest() {
        return datePrayerRequest;
    }

    public void setDatePrayerRequest(Date datePrayerRequest) {
        this.datePrayerRequest = datePrayerRequest;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Person getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }

    public PrayerRequestNature getIdPrayerRequestNature() {
        return idPrayerRequestNature;
    }

    public void setIdPrayerRequestNature(PrayerRequestNature idPrayerRequestNature) {
        this.idPrayerRequestNature = idPrayerRequestNature;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrayerRequest != null ? idPrayerRequest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrayerRequest)) {
            return false;
        }
        PrayerRequest other = (PrayerRequest) object;
        if ((this.idPrayerRequest == null && other.idPrayerRequest != null) || (this.idPrayerRequest != null && !this.idPrayerRequest.equals(other.idPrayerRequest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.merqury.phoebe.entity.PrayerRequest[ idPrayerRequest=" + idPrayerRequest + " ]";
    }
    
}
