/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epa.diplomado.modeloJPA;

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
 * @author Rental Servicios
 */
@Entity
@Table(name = "amigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmigoJPA.findAll", query = "SELECT a FROM AmigoJPA a")
    , @NamedQuery(name = "AmigoJPA.findByCedula", query = "SELECT a FROM AmigoJPA a WHERE a.cedula = :cedula")
    , @NamedQuery(name = "AmigoJPA.findByNombre", query = "SELECT a FROM AmigoJPA a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "AmigoJPA.findByUs", query = "SELECT a FROM AmigoJPA a WHERE a.us = :us")
   // , @NamedQuery(name = "AmigoJPA.findByIdCedula", query = "SELECT * From Amigo WHERE id_amigo='19668868'")//borrar en caso de emergencia    
    , @NamedQuery(name = "AmigoJPA.findByPass", query = "SELECT a FROM AmigoJPA a WHERE a.pass = :pass")})
public class AmigoJPA implements Serializable {

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
    @Size(max = 30)
    @Column(name = "pass")
    private String pass;
    @JoinColumn(name = "id_amigo", referencedColumnName = "cedula")
    @ManyToOne
    private UsuarioJPA idAmigo;

    public AmigoJPA() {
    }

    public AmigoJPA(String cedula) {
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

    public UsuarioJPA getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(UsuarioJPA idAmigo) {
        this.idAmigo = idAmigo;
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
        if (!(object instanceof AmigoJPA)) {
            return false;
        }
        AmigoJPA other = (AmigoJPA) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "epa.diplomado.modeloJPA.AmigoJPA[ cedula=" + cedula + " ]";
    }
    
}
