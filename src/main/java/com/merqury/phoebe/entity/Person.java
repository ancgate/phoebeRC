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
import javax.persistence.ManyToOne;
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
@Table(name = "Person", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"memberIdentificationNumber"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.idPerson = :idPerson"),
    @NamedQuery(name = "Person.findByMemberIdentificationNumber", query = "SELECT p FROM Person p WHERE p.memberIdentificationNumber = :memberIdentificationNumber"),
    @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Person.findByDateOfBirth", query = "SELECT p FROM Person p WHERE p.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Person.findBySex", query = "SELECT p FROM Person p WHERE p.sex = :sex"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.phone = :phone"),
    @NamedQuery(name = "Person.findByIsConverted", query = "SELECT p FROM Person p WHERE p.isConverted = :isConverted"),
    @NamedQuery(name = "Person.findByDateConversion", query = "SELECT p FROM Person p WHERE p.dateConversion = :dateConversion"),
    @NamedQuery(name = "Person.findByIsBaptized", query = "SELECT p FROM Person p WHERE p.isBaptized = :isBaptized"),
    @NamedQuery(name = "Person.findByDateBaptism", query = "SELECT p FROM Person p WHERE p.dateBaptism = :dateBaptism"),
    @NamedQuery(name = "Person.findByProfession", query = "SELECT p FROM Person p WHERE p.profession = :profession"),
    @NamedQuery(name = "Person.findByAddresse", query = "SELECT p FROM Person p WHERE p.addresse = :addresse"),
    @NamedQuery(name = "Person.findByIsMember", query = "SELECT p FROM Person p WHERE p.isMember = :isMember"),
    @NamedQuery(name = "Person.findByDateMembership", query = "SELECT p FROM Person p WHERE p.dateMembership = :dateMembership"),
    @NamedQuery(name = "Person.findByFirstVisitDate", query = "SELECT p FROM Person p WHERE p.firstVisitDate = :firstVisitDate"),
    @NamedQuery(name = "Person.findByDateWedding", query = "SELECT p FROM Person p WHERE p.dateWedding = :dateWedding"),
    @NamedQuery(name = "Person.findByDateEntry", query = "SELECT p FROM Person p WHERE p.dateEntry = :dateEntry"),
    @NamedQuery(name = "Person.findByPhotoPath", query = "SELECT p FROM Person p WHERE p.photoPath = :photoPath")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerson", nullable = false)
    private Integer idPerson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "memberIdentificationNumber", nullable = false, length = 45)
    private String memberIdentificationNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "firstName", nullable = false, length = 255)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lastName", nullable = false, length = 255)
    private String lastName;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "sex", nullable = false, length = 6)
    private String sex;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "phone", nullable = false, length = 255)
    private String phone;
    @Column(name = "isConverted")
    private Boolean isConverted;
    @Column(name = "dateConversion")
    @Temporal(TemporalType.DATE)
    private Date dateConversion;
    @Column(name = "isBaptized")
    private Boolean isBaptized;
    @Column(name = "dateBaptism")
    @Temporal(TemporalType.DATE)
    private Date dateBaptism;
    @Size(max = 45)
    @Column(name = "Profession", length = 45)
    private String profession;
    @Column(name = "Addresse")
    private Integer addresse;
    @Column(name = "isMember")
    private Boolean isMember;
    @Column(name = "dateMembership")
    @Temporal(TemporalType.DATE)
    private Date dateMembership;
    @Column(name = "firstVisitDate")
    @Temporal(TemporalType.DATE)
    private Date firstVisitDate;
    @Column(name = "dateWedding")
    @Temporal(TemporalType.DATE)
    private Date dateWedding;
    @Column(name = "dateEntry")
    @Temporal(TemporalType.DATE)
    private Date dateEntry;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lastHostUpdate", nullable = false, length = 255)
    private String lastHostUpdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "photoPath", nullable = false, length = 255)
    private String photoPath;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private Collection<PrayerRequest> prayerRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private Collection<Note> noteCollection;
    @JoinColumn(name = "idMaritalStatus", referencedColumnName = "idMaritalStatus", nullable = false)
    @ManyToOne(optional = false)
    private MaritalStatus idMaritalStatus;

    public Person() {
    }

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Person(Integer idPerson, String memberIdentificationNumber, String firstName, String lastName, String sex, String email, String phone, String photoPath) {
        this.idPerson = idPerson;
        this.memberIdentificationNumber = memberIdentificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.photoPath = photoPath;
    }

    public Person(Integer idPerson, String memberIdentificationNumber, String firstName, String lastName, Date dateOfBirth, String sex, String email, String phone, Boolean isConverted, Date dateConversion, Boolean isBaptized, Date dateBaptism, String profession, Integer addresse, Boolean isMember, Date dateMembership, Date firstVisitDate, Date dateWedding, Date dateEntry, Date dateCreated, String createdBy, Date dateModified, String modifiedBy, String lastHostUpdate, String photoPath, Collection<PrayerRequest> prayerRequestCollection, Collection<Note> noteCollection, MaritalStatus idMaritalStatus) {
        this.idPerson = idPerson;
        this.memberIdentificationNumber = memberIdentificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.isConverted = isConverted;
        this.dateConversion = dateConversion;
        this.isBaptized = isBaptized;
        this.dateBaptism = dateBaptism;
        this.profession = profession;
        this.addresse = addresse;
        this.isMember = isMember;
        this.dateMembership = dateMembership;
        this.firstVisitDate = firstVisitDate;
        this.dateWedding = dateWedding;
        this.dateEntry = dateEntry;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
        this.dateModified = dateModified;
        this.modifiedBy = modifiedBy;
        this.lastHostUpdate = lastHostUpdate;
        this.photoPath = photoPath;
        this.prayerRequestCollection = prayerRequestCollection;
        this.noteCollection = noteCollection;
        this.idMaritalStatus = idMaritalStatus;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getMemberIdentificationNumber() {
        return memberIdentificationNumber;
    }

    public void setMemberIdentificationNumber(String memberIdentificationNumber) {
        this.memberIdentificationNumber = memberIdentificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsConverted() {
        return isConverted;
    }

    public void setIsConverted(Boolean isConverted) {
        this.isConverted = isConverted;
    }

    public Date getDateConversion() {
        return dateConversion;
    }

    public void setDateConversion(Date dateConversion) {
        this.dateConversion = dateConversion;
    }

    public Boolean getIsBaptized() {
        return isBaptized;
    }

    public void setIsBaptized(Boolean isBaptized) {
        this.isBaptized = isBaptized;
    }

    public Date getDateBaptism() {
        return dateBaptism;
    }

    public void setDateBaptism(Date dateBaptism) {
        this.dateBaptism = dateBaptism;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getAddresse() {
        return addresse;
    }

    public void setAddresse(Integer addresse) {
        this.addresse = addresse;
    }

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean isMember) {
        this.isMember = isMember;
    }

    public Date getDateMembership() {
        return dateMembership;
    }

    public void setDateMembership(Date dateMembership) {
        this.dateMembership = dateMembership;
    }

    public Date getFirstVisitDate() {
        return firstVisitDate;
    }

    public void setFirstVisitDate(Date firstVisitDate) {
        this.firstVisitDate = firstVisitDate;
    }

    public Date getDateWedding() {
        return dateWedding;
    }

    public void setDateWedding(Date dateWedding) {
        this.dateWedding = dateWedding;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @XmlTransient
    public Collection<PrayerRequest> getPrayerRequestCollection() {
        return prayerRequestCollection;
    }

    public void setPrayerRequestCollection(Collection<PrayerRequest> prayerRequestCollection) {
        this.prayerRequestCollection = prayerRequestCollection;
    }

    @XmlTransient
    public Collection<Note> getNoteCollection() {
        return noteCollection;
    }

    public void setNoteCollection(Collection<Note> noteCollection) {
        this.noteCollection = noteCollection;
    }

    public MaritalStatus getIdMaritalStatus() {
        return idMaritalStatus;
    }

    public void setIdMaritalStatus(MaritalStatus idMaritalStatus) {
        this.idMaritalStatus = idMaritalStatus;
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

    public String getLastHostUpdate() {
        return lastHostUpdate;
    }

    public void setLastHostUpdate(String lastHostUpdate) {
        this.lastHostUpdate = lastHostUpdate;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.merqury.phoebe.entity.Person[ idPerson=" + idPerson + " ]";
    }
    
}
