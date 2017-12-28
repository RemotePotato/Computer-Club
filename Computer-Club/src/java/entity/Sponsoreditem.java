/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author StarmanW
 */
@Entity
@Table(name = "SPONSOREDITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sponsoreditem.findAll", query = "SELECT s FROM Sponsoreditem s")
    , @NamedQuery(name = "Sponsoreditem.findByItemcode", query = "SELECT s FROM Sponsoreditem s WHERE s.itemcode = :itemcode")
    , @NamedQuery(name = "Sponsoreditem.findByItemtype", query = "SELECT s FROM Sponsoreditem s WHERE s.itemtype = :itemtype")
    , @NamedQuery(name = "Sponsoreditem.findByItemname", query = "SELECT s FROM Sponsoreditem s WHERE s.itemname = :itemname")
    , @NamedQuery(name = "Sponsoreditem.findByItemquantity", query = "SELECT s FROM Sponsoreditem s WHERE s.itemquantity = :itemquantity")})
public class Sponsoreditem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ITEMCODE")
    private String itemcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEMTYPE")
    private int itemtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ITEMNAME")
    private String itemname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEMQUANTITY")
    private int itemquantity;
    @JoinColumn(name = "COLLABCODE", referencedColumnName = "COLLABCODE")
    @ManyToOne(optional = false)
    private Collaborator collabcode;

    public Sponsoreditem() {
    }

    public Sponsoreditem(String itemcode) {
        this.itemcode = itemcode;
    }

    public Sponsoreditem(String itemcode, int itemtype, String itemname, int itemquantity) {
        this.itemcode = itemcode;
        this.itemtype = itemtype;
        this.itemname = itemname;
        this.itemquantity = itemquantity;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public int getItemtype() {
        return itemtype;
    }

    public void setItemtype(int itemtype) {
        this.itemtype = itemtype;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(int itemquantity) {
        this.itemquantity = itemquantity;
    }

    public Collaborator getCollabcode() {
        return collabcode;
    }

    public void setCollabcode(Collaborator collabcode) {
        this.collabcode = collabcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemcode != null ? itemcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sponsoreditem)) {
            return false;
        }
        Sponsoreditem other = (Sponsoreditem) object;
        if ((this.itemcode == null && other.itemcode != null) || (this.itemcode != null && !this.itemcode.equals(other.itemcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sponsoreditem[ itemcode=" + itemcode + " ]";
    }
    
}
