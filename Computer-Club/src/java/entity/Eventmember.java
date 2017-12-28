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
@Table(name = "EVENTMEMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventmember.findAll", query = "SELECT e FROM Eventmember e")
    , @NamedQuery(name = "Eventmember.findByEventmemberid", query = "SELECT e FROM Eventmember e WHERE e.eventmemberid = :eventmemberid")})
public class Eventmember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EVENTMEMBERID")
    private Integer eventmemberid;
    @JoinColumn(name = "EVENTID", referencedColumnName = "EVENTID")
    @ManyToOne
    private Event eventid;
    @JoinColumn(name = "MEMBERID", referencedColumnName = "MEMBERID")
    @ManyToOne
    private Member1 memberid;

    public Eventmember() {
    }

    public Eventmember(Integer eventmemberid) {
        this.eventmemberid = eventmemberid;
    }

    public Integer getEventmemberid() {
        return eventmemberid;
    }

    public void setEventmemberid(Integer eventmemberid) {
        this.eventmemberid = eventmemberid;
    }

    public Event getEventid() {
        return eventid;
    }

    public void setEventid(Event eventid) {
        this.eventid = eventid;
    }

    public Member1 getMemberid() {
        return memberid;
    }

    public void setMemberid(Member1 memberid) {
        this.memberid = memberid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventmemberid != null ? eventmemberid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventmember)) {
            return false;
        }
        Eventmember other = (Eventmember) object;
        if ((this.eventmemberid == null && other.eventmemberid != null) || (this.eventmemberid != null && !this.eventmemberid.equals(other.eventmemberid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Eventmember[ eventmemberid=" + eventmemberid + " ]";
    }
    
}
