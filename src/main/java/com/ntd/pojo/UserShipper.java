/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "user_shipper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserShipper.findAll", query = "SELECT u FROM UserShipper u"),
    @NamedQuery(name = "UserShipper.findById", query = "SELECT u FROM UserShipper u WHERE u.id = :id"),
    @NamedQuery(name = "UserShipper.findByIdentity", query = "SELECT u FROM UserShipper u WHERE u.identity = :identity"),
    @NamedQuery(name = "UserShipper.findByAddress", query = "SELECT u FROM UserShipper u WHERE u.address = :address"),
    @NamedQuery(name = "UserShipper.findByDob", query = "SELECT u FROM UserShipper u WHERE u.dob = :dob")})
public class UserShipper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identity")
    private int identity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    
    
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User userS;

    public UserShipper() {
    }

    public UserShipper(Integer id) {
        this.id = id;
    }

    public UserShipper(Integer id, int identity, String address, Date dob) {
        this.id = id;
        this.identity = identity;
        this.address = address;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public User getUser() {
        return userS;
    }

    public void setUserS(User userS) {
        this.userS = userS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserShipper)) {
            return false;
        }
        UserShipper other = (UserShipper) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntd.pojo.UserShipper[ id=" + id + " ]";
    }
    
}
