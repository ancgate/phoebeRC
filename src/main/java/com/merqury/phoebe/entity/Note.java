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
@Table(name = "Note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByIdNote", query = "SELECT n FROM Note n WHERE n.idNote = :idNote"),
    @NamedQuery(name = "Note.findByNoteDate", query = "SELECT n FROM Note n WHERE n.noteDate = :noteDate"),
    @NamedQuery(name = "Note.findByNoteDescription", query = "SELECT n FROM Note n WHERE n.noteDescription = :noteDescription"),
    @NamedQuery(name = "Note.findByDateCreated", query = "SELECT n FROM Note n WHERE n.dateCreated = :dateCreated"),
    @NamedQuery(name = "Note.findByCreatedBy", query = "SELECT n FROM Note n WHERE n.createdBy = :createdBy"),
    @NamedQuery(name = "Note.findByDateModified", query = "SELECT n FROM Note n WHERE n.dateModified = :dateModified"),
    @NamedQuery(name = "Note.findByModifiedBy", query = "SELECT n FROM Note n WHERE n.modifiedBy = :modifiedBy")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNote", nullable = false)
    private Integer idNote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noteDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date noteDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "NoteDescription", nullable = false, length = 1000)
    private String noteDescription;
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
    @JoinColumn(name = "idNoteType", referencedColumnName = "idNoteType", nullable = false)
    @ManyToOne(optional = false)
    private NoteType idNoteType;
    @JoinColumn(name = "idPerson", referencedColumnName = "idPerson", nullable = false)
    @ManyToOne(optional = false)
    private Person idPerson;

    public Note() {
    }

    public Note(Integer idNote) {
        this.idNote = idNote;
    }

    public Note(Integer idNote, Date noteDate, String noteDescription, Date dateCreated, String createdBy, Date dateModified, String modifiedBy) {
        this.idNote = idNote;
        this.noteDate = noteDate;
        this.noteDescription = noteDescription;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.dateModified = dateModified;
        this.modifiedBy = modifiedBy;
    }

    public Integer getIdNote() {
        return idNote;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
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

    public NoteType getIdNoteType() {
        return idNoteType;
    }

    public void setIdNoteType(NoteType idNoteType) {
        this.idNoteType = idNoteType;
    }

    public Person getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNote != null ? idNote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idNote == null && other.idNote != null) || (this.idNote != null && !this.idNote.equals(other.idNote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.merqury.phoebe.entity.Note[ idNote=" + idNote + " ]";
    }
    
}
