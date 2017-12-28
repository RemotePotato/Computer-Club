/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author StarmanW
 */
@Entity
@Table(name = "EVENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findByEventid", query = "SELECT e FROM Event e WHERE e.eventid = :eventid")
    , @NamedQuery(name = "Event.findByEventname", query = "SELECT e FROM Event e WHERE e.eventname = :eventname")
    , @NamedQuery(name = "Event.findByEventtype", query = "SELECT e FROM Event e WHERE e.eventtype = :eventtype")
    , @NamedQuery(name = "Event.findByEventdate", query = "SELECT e FROM Event e WHERE e.eventdate = :eventdate")
    , @NamedQuery(name = "Event.findByEventtime", query = "SELECT e FROM Event e WHERE e.eventtime = :eventtime")
    , @NamedQuery(name = "Event.findByEventlocation", query = "SELECT e FROM Event e WHERE e.eventlocation = :eventlocation")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EVENTID")
    private String eventid;
    @Size(max = 255)
    @Column(name = "EVENTNAME")
    private String eventname;
    @Column(name = "EVENTTYPE")
    private Integer eventtype;
    @Column(name = "EVENTDATE")
    @Temporal(TemporalType.DATE)
    private Date eventdate;
    @Column(name = "EVENTTIME")
    @Temporal(TemporalType.TIME)
    private Date eventtime;
    @Size(max = 255)
    @Column(name = "EVENTLOCATION")
    private String eventlocation;
    @OneToMany(mappedBy = "collabcode")
    private List<Eventcollaborator> eventcollaboratorList;
    @OneToMany(mappedBy = "eventid")
    private List<Eventmember> eventmemberList;

    public Event() {
    }

    public Event(String eventid) {
        this.eventid = eventid;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Integer getEventtype() {
        return eventtype;
    }

    public void setEventtype(Integer eventtype) {
        this.eventtype = eventtype;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public Date getEventtime() {
        return eventtime;
    }

    public void setEventtime(Date eventtime) {
        this.eventtime = eventtime;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    @XmlTransient
    public List<Eventcollaborator> getEventcollaboratorList() {
        return eventcollaboratorList;
    }

    public void setEventcollaboratorList(List<Eventcollaborator> eventcollaboratorList) {
        this.eventcollaboratorList = eventcollaboratorList;
    }

    @XmlTransient
    public List<Eventmember> getEventmemberList() {
        return eventmemberList;
    }

    public void setEventmemberList(List<Eventmember> eventmemberList) {
        this.eventmemberList = eventmemberList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventid != null ? eventid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventid == null && other.eventid != null) || (this.eventid != null && !this.eventid.equals(other.eventid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Event[ eventid=" + eventid + " ]";
    }
    
}
