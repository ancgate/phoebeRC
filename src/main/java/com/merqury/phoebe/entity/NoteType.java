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
@Table(name = "NoteType",  uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NoteTypeName"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NoteType.findAll", query = "SELECT n FROM NoteType n"),
    @NamedQuery(name = "NoteType.findByIdNoteType", query = "SELECT n FROM NoteType n WHERE n.idNoteType = :idNoteType"),
    @NamedQuery(name = "NoteType.findByNoteTypeName", query = "SELECT n FROM NoteType n WHERE n.noteTypeName = :noteTypeName"),
    @NamedQuery(name = "NoteType.findByNoteTypeDescription", query = "SELECT n FROM NoteType n WHERE n.noteTypeDescription = :noteTypeDescription")})
public class NoteType implements Identifiable, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNoteType", nullable = false)
    private Integer idNoteType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NoteTypeName", nullable = false, length = 255)
    private String noteTypeName;
    @Size(max = 255)
    @Column(name = "NoteTypeDescription", length = 255)
    private String noteTypeDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNoteType")
    private Collection<Note> noteCollection;
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
    

    public NoteType() {
    }

    public NoteType(Integer idNoteType) {
        this.idNoteType = idNoteType;
    }

    public NoteType(Integer idNoteType, String noteTypeName) {
        this.idNoteType = idNoteType;
        this.noteTypeName = noteTypeName;
    }

    public NoteType(String noteTypeName, String noteTypeDescription, Collection<Note> noteCollection, Date dateCreated, String createdBy, Date dateModified, String modifiedBy) {
        this.noteTypeName = noteTypeName;
        this.noteTypeDescription = noteTypeDescription;
        this.noteCollection = noteCollection;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.dateModified = dateModified;
        this.modifiedBy = modifiedBy;
    }
    

    @Override
    public Integer getIdentifier() {
        return idNoteType;
    }

    public void setIdNoteType(Integer idNoteType) {
        this.idNoteType = idNoteType;
    }

    public String getNoteTypeName() {
        return noteTypeName;
    }

    public void setNoteTypeName(String noteTypeName) {
        this.noteTypeName = noteTypeName;
    }

    public String getNoteTypeDescription() {
        return noteTypeDescription;
    }

    public void setNoteTypeDescription(String noteTypeDescription) {
        this.noteTypeDescription = noteTypeDescription;
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
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
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNoteType != null ? idNoteType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NoteType)) {
            return false;
        }
        NoteType other = (NoteType) object;
        if ((this.idNoteType == null && other.idNoteType != null) || (this.idNoteType != null && !this.idNoteType.equals(other.idNoteType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.merqury.phoebe.entity.NoteType[ idNoteType=" + idNoteType + " ]";
    }
    
}
