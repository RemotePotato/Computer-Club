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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author StarmanW
 */
@Entity
@Table(name = "EVENTCOLLABORATOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventcollaborator.findAll", query = "SELECT e FROM Eventcollaborator e")
    , @NamedQuery(name = "Eventcollaborator.findByEventcollabid", query = "SELECT e FROM Eventcollaborator e WHERE e.eventcollabid = :eventcollabid")})
public class Eventcollaborator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVENTCOLLABID")
    private Integer eventcollabid;
    @JoinColumn(name = "EVENTID", referencedColumnName = "COLLABCODE")
    @ManyToOne
    private Collaborator eventid;
    @JoinColumn(name = "COLLABCODE", referencedColumnName = "EVENTID")
    @ManyToOne
    private Event collabcode;

    public Eventcollaborator() {
    }

    public Eventcollaborator(Integer eventcollabid) {
        this.eventcollabid = eventcollabid;
    }

    public Integer getEventcollabid() {
        return eventcollabid;
    }

    public void setEventcollabid(Integer eventcollabid) {
        this.eventcollabid = eventcollabid;
    }

    public Collaborator getEventid() {
        return eventid;
    }

    public void setEventid(Collaborator eventid) {
        this.eventid = eventid;
    }

    public Event getCollabcode() {
        return collabcode;
    }

    public void setCollabcode(Event collabcode) {
        this.collabcode = collabcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventcollabid != null ? eventcollabid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventcollaborator)) {
            return false;
        }
        Eventcollaborator other = (Eventcollaborator) object;
        if ((this.eventcollabid == null && other.eventcollabid != null) || (this.eventcollabid != null && !this.eventcollabid.equals(other.eventcollabid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Eventcollaborator[ eventcollabid=" + eventcollabid + " ]";
    }
    
}
