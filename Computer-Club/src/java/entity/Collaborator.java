/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author StarmanW
 */
@Entity
@Table(name = "COLLABORATOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collaborator.findAll", query = "SELECT c FROM Collaborator c")
    , @NamedQuery(name = "Collaborator.findByCollabcode", query = "SELECT c FROM Collaborator c WHERE c.collabcode = :collabcode")
    , @NamedQuery(name = "Collaborator.findByCollabname", query = "SELECT c FROM Collaborator c WHERE c.collabname = :collabname")
    , @NamedQuery(name = "Collaborator.findByCollabtype", query = "SELECT c FROM Collaborator c WHERE c.collabtype = :collabtype")
    , @NamedQuery(name = "Collaborator.findByContactno", query = "SELECT c FROM Collaborator c WHERE c.contactno = :contactno")
    , @NamedQuery(name = "Collaborator.findByEmail", query = "SELECT c FROM Collaborator c WHERE c.email = :email")
    , @NamedQuery(name = "Collaborator.findByAdditionalnotes", query = "SELECT c FROM Collaborator c WHERE c.additionalnotes = :additionalnotes")})
public class Collaborator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COLLABCODE")
    private String collabcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COLLABNAME")
    private String collabname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COLLABTYPE")
    private int collabtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CONTACTNO")
    private String contactno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "ADDITIONALNOTES")
    private String additionalnotes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collabcode")
    private List<Sponsoreditem> sponsoreditemList;
    @OneToMany(mappedBy = "eventid")
    private List<Eventcollaborator> eventcollaboratorList;

    public Collaborator() {
    }

    public Collaborator(String collabcode) {
        this.collabcode = collabcode;
    }

    public Collaborator(String collabcode, String collabname, int collabtype, String contactno) {
        this.collabcode = collabcode;
        this.collabname = collabname;
        this.collabtype = collabtype;
        this.contactno = contactno;
    }

    public String getCollabcode() {
        return collabcode;
    }

    public void setCollabcode(String collabcode) {
        this.collabcode = collabcode;
    }

    public String getCollabname() {
        return collabname;
    }

    public void setCollabname(String collabname) {
        this.collabname = collabname;
    }

    public int getCollabtype() {
        return collabtype;
    }

    public void setCollabtype(int collabtype) {
        this.collabtype = collabtype;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdditionalnotes() {
        return additionalnotes;
    }

    public void setAdditionalnotes(String additionalnotes) {
        this.additionalnotes = additionalnotes;
    }

    @XmlTransient
    public List<Sponsoreditem> getSponsoreditemList() {
        return sponsoreditemList;
    }

    public void setSponsoreditemList(List<Sponsoreditem> sponsoreditemList) {
        this.sponsoreditemList = sponsoreditemList;
    }

    @XmlTransient
    public List<Eventcollaborator> getEventcollaboratorList() {
        return eventcollaboratorList;
    }

    public void setEventcollaboratorList(List<Eventcollaborator> eventcollaboratorList) {
        this.eventcollaboratorList = eventcollaboratorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collabcode != null ? collabcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collaborator)) {
            return false;
        }
        Collaborator other = (Collaborator) object;
        if ((this.collabcode == null && other.collabcode != null) || (this.collabcode != null && !this.collabcode.equals(other.collabcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Collaborator[ collabcode=" + collabcode + " ]";
    }
    
}
