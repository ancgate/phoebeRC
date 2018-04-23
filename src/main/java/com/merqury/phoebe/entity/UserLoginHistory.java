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
@Table(name = "UserLoginHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserLoginHistory.findAll", query = "SELECT u FROM UserLoginHistory u"),
    @NamedQuery(name = "UserLoginHistory.findByIdUserLoginHistory", query = "SELECT u FROM UserLoginHistory u WHERE u.idUserLoginHistory = :idUserLoginHistory"),
    @NamedQuery(name = "UserLoginHistory.findByHostName", query = "SELECT u FROM UserLoginHistory u WHERE u.hostName = :hostName"),
    @NamedQuery(name = "UserLoginHistory.findByComputerName", query = "SELECT u FROM UserLoginHistory u WHERE u.computerName = :computerName"),
    @NamedQuery(name = "UserLoginHistory.findByRemoteAddress", query = "SELECT u FROM UserLoginHistory u WHERE u.remoteAddress = :remoteAddress"),
    @NamedQuery(name = "UserLoginHistory.findByUserRole", query = "SELECT u FROM UserLoginHistory u WHERE u.userRole = :userRole"),
    @NamedQuery(name = "UserLoginHistory.findByUserAction", query = "SELECT u FROM UserLoginHistory u WHERE u.userAction = :userAction"),
    @NamedQuery(name = "UserLoginHistory.findByLoginDate", query = "SELECT u FROM UserLoginHistory u WHERE u.loginDate = :loginDate")})
public class UserLoginHistory implements Identifiable, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUserLoginHistory", nullable = false)
    private Integer idUserLoginHistory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "hostName", nullable = false, length = 255)
    private String hostName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "computerName", nullable = false, length = 45)
    private String computerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "remoteAddress", nullable = false, length = 255)
    private String remoteAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userRole", nullable = false, length = 45)
    private String userRole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userAction", nullable = false, length = 45)
    private String userAction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loginDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    @ManyToOne(optional = false)
    private Users idUser;

    public UserLoginHistory() {
    }

    public UserLoginHistory(Integer idUserLoginHistory) {
        this.idUserLoginHistory = idUserLoginHistory;
    }

    public UserLoginHistory(Integer idUserLoginHistory, String hostName, String computerName, String remoteAddress, String userRole, Date loginDate) {
        this.idUserLoginHistory = idUserLoginHistory;
        this.hostName = hostName;
        this.computerName = computerName;
        this.remoteAddress = remoteAddress;
        this.userRole = userRole;
        this.loginDate = loginDate;
        
    }
    
    public UserLoginHistory(String hostName, String computerName, String remoteAddress, String userRole, Date loginDate, Users user, String userAction) {
        this.hostName = hostName;
        this.computerName = computerName;
        this.remoteAddress = remoteAddress;
        this.userRole = userRole;
        this.loginDate = loginDate;
        this.idUser = user;
        this.userAction= userAction;
    }

    @Override
    public Integer getIdentifier() {
        return idUserLoginHistory ;
    }

    public void setIdUserLoginHistory(Integer idUserLoginHistory) {
        this.idUserLoginHistory = idUserLoginHistory;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public String getUserAction() {
        return userAction;
    }

    public void setUserAction(String userAction) {
        this.userAction = userAction;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserLoginHistory != null ? idUserLoginHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLoginHistory)) {
            return false;
        }
        UserLoginHistory other = (UserLoginHistory) object;
        if ((this.idUserLoginHistory == null && other.idUserLoginHistory != null) || (this.idUserLoginHistory != null && !this.idUserLoginHistory.equals(other.idUserLoginHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.merqury.phoebe.entity.UserLoginHistory[ idUserLoginHistory=" + idUserLoginHistory + " ]";
    }
    
}
