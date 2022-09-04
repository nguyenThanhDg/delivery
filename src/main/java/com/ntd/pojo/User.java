/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active"),
    @NamedQuery(name = "User.findByCreatedDate", query = "SELECT u FROM User u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "User.findByAvatar", query = "SELECT u FROM User u WHERE u.avatar = :avatar"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.userRole = :userRole")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String customer = "CUSTOMER";
    public static final String admin = "ADMIN";
    public static final String shipper = "SHIPPER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{Err.null}")
    @Size(min = 1, max = 45, message = "{Err.null}")
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull(message = "{Err.null}")
    @Size(min = 1, max = 45, message = "{Err.length}")
    @Column(name = "last_name")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "{Err.null}")
    @Size(min = 1, max = 45,message = "{Err.length}")
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "{Err.null}")
//    @Pattern(regexp="(^$|[0-9]{10})", message = "{Err.phone.value}")
    @Size(min = 1, max = 10,message = "{Err.phone}")
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull(message = "{Err.null}")
    @Size(min = 1, max = 45,message = "{Err.length}")
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull(message = "{Err.null}")
    @Size(min = 1, max = 100,message = "{Err.length.pass}")
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Boolean active;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Basic(optional = false)
    
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @Column(name = "userRole")
    private String userRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    private Collection<Rating> ratingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    private Collection<Comment> commentCollection;
    @OneToOne(mappedBy = "userS")
    @JsonIgnore
    private UserShipper userShipper;
    @Transient
    @JsonIgnore
    private MultipartFile file;
    @Transient
    @JsonIgnore
    private String confirmPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipper")
    private Collection<ProductShipper> productShipperCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipper")
    private Collection<Rating> ratingShipperCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipper",fetch= FetchType.EAGER)
    private Collection<Comment> commentShipperCollection;
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firstName, String lastName, String email, String phone, String username, String password, Date createdDate, String avatar, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
        this.avatar = avatar;
        this.userRole = role;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<Rating> getRatingCollection() {
        return ratingCollection;
    }

    public void setRatingCollection(Collection<Rating> ratingCollection) {
        this.ratingCollection = ratingCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    public UserShipper getUserShipper() {
        return userShipper;
    }

    public void setUserShipper(UserShipper userShipper) {
        this.userShipper = userShipper;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntd.pojo.User[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
     public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
 
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the productShipperCollection
     */
    public Collection<ProductShipper> getProductShipperCollection() {
        return productShipperCollection;
    }

    /**
     * @param productShipperCollection the productShipperCollection to set
     */
    public void setProductShipperCollection(Collection<ProductShipper> productShipperCollection) {
        this.productShipperCollection = productShipperCollection;
    }

    /**
     * @return the ratingShipperCollection
     */
    public Collection<Rating> getRatingShipperCollection() {
        return ratingShipperCollection;
    }

    /**
     * @param ratingShipperCollection the ratingShipperCollection to set
     */
    public void setRatingShipperCollection(Collection<Rating> ratingShipperCollection) {
        this.ratingShipperCollection = ratingShipperCollection;
    }

    /**
     * @return the commentShipperCollection
     */
    public Collection<Comment> getCommentShipperCollection() {
        return commentShipperCollection;
    }

    /**
     * @param commentShipperCollection the commentShipperCollection to set
     */
    public void setCommentShipperCollection(Collection<Comment> commentShipperCollection) {
        this.commentShipperCollection = commentShipperCollection;
    }

    
    
}
