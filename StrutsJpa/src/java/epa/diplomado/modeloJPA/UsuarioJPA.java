/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epa.diplomado.modeloJPA;

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
 * @author Hellmuth
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioJPA.findAll", query = "SELECT u FROM UsuarioJPA u")
    , @NamedQuery(name = "UsuarioJPA.findByCedula", query = "SELECT u FROM UsuarioJPA u WHERE u.cedula = :cedula")
    , @NamedQuery(name = "UsuarioJPA.findByNombre", query = "SELECT u FROM UsuarioJPA u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UsuarioJPA.findByUs", query = "SELECT u FROM UsuarioJPA u WHERE u.us = :us")
    , @NamedQuery(name = "UsuarioJPA.findByPass", query = "SELECT u FROM UsuarioJPA u WHERE u.pass = :pass")})
public class UsuarioJPA implements Serializable {

    @OneToMany(mappedBy = "idAmigo")
    private List<AmigoJPA> amigoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "us")
    private String us;
    @Size(max = 300)
    @Column(name = "pass")
    private String pass;

    public UsuarioJPA() {
    }

    public UsuarioJPA(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioJPA)) {
            return false;
        }
        UsuarioJPA other = (UsuarioJPA) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "epa.diplomado.modelo.UsuarioJPA[ cedula=" + cedula + " ]";
    }

    @XmlTransient
    public List<AmigoJPA> getAmigoList() {
        return amigoList;
    }

    public void setAmigoList(List<AmigoJPA> amigoList) {
        this.amigoList = amigoList;
    }
}