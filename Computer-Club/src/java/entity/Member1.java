/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "MEMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m")
    , @NamedQuery(name = "Member1.findByMemberid", query = "SELECT m FROM Member1 m WHERE m.memberid = :memberid")
    , @NamedQuery(name = "Member1.findByProgcode", query = "SELECT m FROM Member1 m WHERE m.progcode = :progcode")
    , @NamedQuery(name = "Member1.findByFirstname", query = "SELECT m FROM Member1 m WHERE m.firstname = :firstname")
    , @NamedQuery(name = "Member1.findByLastname", query = "SELECT m FROM Member1 m WHERE m.lastname = :lastname")
    , @NamedQuery(name = "Member1.findByEmail", query = "SELECT m FROM Member1 m WHERE m.email = :email")
    , @NamedQuery(name = "Member1.findByContactnum", query = "SELECT m FROM Member1 m WHERE m.contactnum = :contactnum")
    , @NamedQuery(name = "Member1.findByIcnum", query = "SELECT m FROM Member1 m WHERE m.icnum = :icnum")
    , @NamedQuery(name = "Member1.findByPass", query = "SELECT m FROM Member1 m WHERE m.pass = :pass")
    , @NamedQuery(name = "Member1.findByGender", query = "SELECT m FROM Member1 m WHERE m.gender = :gender")
    , @NamedQuery(name = "Member1.findByMemfeestats", query = "SELECT m FROM Member1 m WHERE m.memfeestats = :memfeestats")
    , @NamedQuery(name = "Member1.findByPosition", query = "SELECT m FROM Member1 m WHERE m.position = :position")
    , @NamedQuery(name = "Member1.findByAcademicyear", query = "SELECT m FROM Member1 m WHERE m.academicyear = :academicyear")})
public class Member1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MEMBERID")
    private String memberid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PROGCODE")
    private String progcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CONTACTNUM")
    private String contactnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ICNUM")
    private String icnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PASS")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMFEESTATS")
    private Boolean memfeestats;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSITION")
    private int position;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "ACADEMICYEAR")
    private String academicyear;
    @OneToMany(mappedBy = "memberid")
    private List<Eventmember> eventmemberList;

    public Member1() {
    }

    public Member1(String memberid) {
        this.memberid = memberid;
    }

    public Member1(String memberid, String progcode, String firstname, String lastname, String email, String contactnum, String icnum, String pass, String gender, Boolean memfeestats, int position, String academicyear) {
        this.memberid = memberid;
        this.progcode = progcode;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.contactnum = contactnum;
        this.icnum = icnum;
        this.pass = pass;
        this.gender = gender;
        this.memfeestats = memfeestats;
        this.position = position;
        this.academicyear = academicyear;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getProgcode() {
        return progcode;
    }

    public void setProgcode(String progcode) {
        this.progcode = progcode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactnum() {
        return contactnum;
    }

    public void setContactnum(String contactnum) {
        this.contactnum = contactnum;
    }

    public String getIcnum() {
        return icnum;
    }

    public void setIcnum(String icnum) {
        this.icnum = icnum;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getMemfeestats() {
        return memfeestats;
    }

    public void setMemfeestats(Boolean memfeestats) {
        this.memfeestats = memfeestats;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getAcademicyear() {
        return academicyear;
    }

    public void setAcademicyear(String academicyear) {
        this.academicyear = academicyear;
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
        hash += (memberid != null ? memberid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member1)) {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.memberid == null && other.memberid != null) || (this.memberid != null && !this.memberid.equals(other.memberid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Member1[ memberid=" + memberid + " ]";
    }
    
}
