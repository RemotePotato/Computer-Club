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
@Table(name = "PROGRAMME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programme.findAll", query = "SELECT p FROM Programme p")
    , @NamedQuery(name = "Programme.findByProgcode", query = "SELECT p FROM Programme p WHERE p.progcode = :progcode")
    , @NamedQuery(name = "Programme.findByProgname", query = "SELECT p FROM Programme p WHERE p.progname = :progname")
    , @NamedQuery(name = "Programme.findByFacultycode", query = "SELECT p FROM Programme p WHERE p.facultycode = :facultycode")})
public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PROGCODE")
    private String progcode;
    @Size(max = 200)
    @Column(name = "PROGNAME")
    private String progname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "FACULTYCODE")
    private String facultycode;

    public Programme() {
    }

    public Programme(String progcode) {
        this.progcode = progcode;
    }

    public Programme(String progcode, String facultycode) {
        this.progcode = progcode;
        this.facultycode = facultycode;
    }

    public String getProgcode() {
        return progcode;
    }

    public void setProgcode(String progcode) {
        this.progcode = progcode;
    }

    public String getProgname() {
        return progname;
    }

    public void setProgname(String progname) {
        this.progname = progname;
    }

    public String getFacultycode() {
        return facultycode;
    }

    public void setFacultycode(String facultycode) {
        this.facultycode = facultycode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (progcode != null ? progcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.progcode == null && other.progcode != null) || (this.progcode != null && !this.progcode.equals(other.progcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Programme[ progcode=" + progcode + " ]";
    }
    
}
