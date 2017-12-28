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
@Table(name = "FACULTY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f")
    , @NamedQuery(name = "Faculty.findByFacultycode", query = "SELECT f FROM Faculty f WHERE f.facultycode = :facultycode")
    , @NamedQuery(name = "Faculty.findByFacultyname", query = "SELECT f FROM Faculty f WHERE f.facultyname = :facultyname")})
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "FACULTYCODE")
    private String facultycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "FACULTYNAME")
    private String facultyname;

    public Faculty() {
    }

    public Faculty(String facultycode) {
        this.facultycode = facultycode;
    }

    public Faculty(String facultycode, String facultyname) {
        this.facultycode = facultycode;
        this.facultyname = facultyname;
    }

    public String getFacultycode() {
        return facultycode;
    }

    public void setFacultycode(String facultycode) {
        this.facultycode = facultycode;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultycode != null ? facultycode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.facultycode == null && other.facultycode != null) || (this.facultycode != null && !this.facultycode.equals(other.facultycode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Faculty[ facultycode=" + facultycode + " ]";
    }
    
}
