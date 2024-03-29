/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "product_shipper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductShipper.findAll", query = "SELECT p FROM ProductShipper p"),
    @NamedQuery(name = "ProductShipper.findById", query = "SELECT p FROM ProductShipper p WHERE p.id = :id"),
    @NamedQuery(name = "ProductShipper.findByCost", query = "SELECT p FROM ProductShipper p WHERE p.cost = :cost"),
    @NamedQuery(name = "ProductShipper.findByCreatedDate", query = "SELECT p FROM ProductShipper p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "ProductShipper.findByUpdatedDate", query = "SELECT p FROM ProductShipper p WHERE p.updatedDate = :updatedDate")})
public class ProductShipper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private int cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "updated_date")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
    @Basic(optional = false)
    @Column(name = "active")
    private int active1;
    @JsonIgnore
    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product product;
    @JsonIgnore
    @JoinColumn(name = "shipper", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User shipper;

    public ProductShipper() {
    }

    public ProductShipper(Integer id) {
        this.id = id;
    }

    public ProductShipper(Integer id, int cost, Date createdDate) {
        this.id = id;
        this.cost = cost;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        if (!(object instanceof ProductShipper)) {
            return false;
        }
        ProductShipper other = (ProductShipper) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ntd.pojo.ProductShipper[ id=" + id + " ]";
    }

    /**
     * @return the shipper
     */
    public User getShipper() {
        return shipper;
    }

    /**
     * @param shipper the shipper to set
     */
    public void setShipper(User shipper) {
        this.shipper = shipper;
    }

    /**
     * @return the active1
     */
    public int getActive1() {
        return active1;
    }

    /**
     * @param active1 the active to set
     */
    public void setActive1(int active1) {
        this.active1 = active1;
    }

    
    
}
