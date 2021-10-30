/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanModelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ironside
 */
@Entity
@Table(name = "activos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activos.findAll", query = "SELECT a FROM Activos a"),
    @NamedQuery(name = "Activos.findByIdActivo", query = "SELECT a FROM Activos a WHERE a.idActivo = :idActivo"),
    @NamedQuery(name = "Activos.findByCodigo", query = "SELECT a FROM Activos a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Activos.findByDescripcion", query = "SELECT a FROM Activos a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Activos.findByCategoria", query = "SELECT a FROM Activos a WHERE a.categoria = :categoria"),
    @NamedQuery(name = "Activos.findByPrecio", query = "SELECT a FROM Activos a WHERE a.precio = :precio"),
    @NamedQuery(name = "Activos.findByStock", query = "SELECT a FROM Activos a WHERE a.stock = :stock"),
    @NamedQuery(name = "Activos.findByFechaEntrada", query = "SELECT a FROM Activos a WHERE a.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "Activos.findByEstado", query = "SELECT a FROM Activos a WHERE a.estado = :estado")})
public class Activos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_activo")
    private Integer idActivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;

    public Activos() {
    }

    public Activos(Integer idActivo) {
        this.idActivo = idActivo;
    }

    public Activos(Integer idActivo, int codigo, String descripcion, String categoria, float precio, int stock, Date fechaEntrada, String estado) {
        this.idActivo = idActivo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.fechaEntrada = fechaEntrada;
        this.estado = estado;
    }

    public Integer getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(Integer idActivo) {
        this.idActivo = idActivo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivo != null ? idActivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activos)) {
            return false;
        }
        Activos other = (Activos) object;
        if ((this.idActivo == null && other.idActivo != null) || (this.idActivo != null && !this.idActivo.equals(other.idActivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanModelo.Activos[ idActivo=" + idActivo + " ]";
    }
    
}
