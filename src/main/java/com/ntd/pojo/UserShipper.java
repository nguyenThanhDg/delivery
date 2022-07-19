/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "UserShipper.findByFirstName", query = "SELECT u FROM UserShipper u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserShipper.findByLastName", query = "SELECT u FROM UserShipper u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserShipper.findByEmail", query = "SELECT u FROM UserShipper u WHERE u.email = :email"),
    @NamedQuery(name = "UserShipper.findByPhone", query = "SELECT u FROM UserShipper u WHERE u.phone = :phone"),
    @NamedQuery(name = "UserShipper.findByUsername", query = "SELECT u FROM UserShipper u WHERE u.username = :username"),
    @NamedQuery(name = "UserShipper.findByPassword", query = "SELECT u FROM UserShipper u WHERE u.password = :password"),
    @NamedQuery(name = "UserShipper.findByActive", query = "SELECT u FROM UserShipper u WHERE u.active = :active"),
    @NamedQuery(name = "UserShipper.findByCreatedDate", query = "SELECT u FROM UserShipper u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserShipper.findByIdentity", query = "SELECT u FROM UserShipper u WHERE u.identity = :identity"),
    @NamedQuery(name = "UserShipper.findByAvatar", query = "SELECT u FROM UserShipper u WHERE u.avatar = :avatar"),
    @NamedQuery(name = "UserShipper.findByAddress", query = "SELECT u FROM UserShipper u WHERE u.address = :address"),
    @NamedQuery(name = "UserShipper.findByDob", query = "SELECT u FROM UserShipper u WHERE u.dob = :dob")})
public class UserShipper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identity")
    private int identity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "avatar")
    private String avatar;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipper")
    private Set<ProductShipper> productShipperSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipper")
    private Set<Rating> ratingSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipper")
    private Set<Comment> commentSet;

    public UserShipper() {
    }

    public UserShipper(Integer id) {
        this.id = id;
    }

    public UserShipper(Integer id, String firstName, String lastName, String email, String phone, String username, String password, Date createdDate, int identity, String avatar, String address, Date dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
        this.identity = identity;
        this.avatar = avatar;
        this.address = address;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    @XmlTransient
    public Set<ProductShipper> getProductShipperSet() {
        return productShipperSet;
    }

    public void setProductShipperSet(Set<ProductShipper> productShipperSet) {
        this.productShipperSet = productShipperSet;
    }

    @XmlTransient
    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
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
