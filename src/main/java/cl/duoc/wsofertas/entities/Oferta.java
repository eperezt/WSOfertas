/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.wsofertas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esteban Perez
 */
@Entity
@Table(name = "OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o")
    , @NamedQuery(name = "Oferta.findByIdoferta", query = "SELECT o FROM Oferta o WHERE o.idoferta = :idoferta")
    , @NamedQuery(name = "Oferta.findByFechainicio", query = "SELECT o FROM Oferta o WHERE o.fechainicio = :fechainicio")
    , @NamedQuery(name = "Oferta.findByFechafin", query = "SELECT o FROM Oferta o WHERE o.fechafin = :fechafin")
    , @NamedQuery(name = "Oferta.findByMinimoproductos", query = "SELECT o FROM Oferta o WHERE o.minimoproductos = :minimoproductos")
    , @NamedQuery(name = "Oferta.findByMaximoproductos", query = "SELECT o FROM Oferta o WHERE o.maximoproductos = :maximoproductos")
    , @NamedQuery(name = "Oferta.findByIspublicada", query = "SELECT o FROM Oferta o WHERE o.ispublicada = :ispublicada")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOFERTA")
    private BigDecimal idoferta;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @Lob
    @Column(name = "FOTOGRAFIA")
    private Serializable fotografia;
    @Column(name = "MINIMOPRODUCTOS")
    private BigInteger minimoproductos;
    @Column(name = "MAXIMOPRODUCTOS")
    private BigInteger maximoproductos;
    @Column(name = "ISPUBLICADA")
    private BigInteger ispublicada;
    @JoinTable(name = "RL_OFERTA_TIENDA", joinColumns = {
        @JoinColumn(name = "OFERTA_IDOFERTA", referencedColumnName = "IDOFERTA")}, inverseJoinColumns = {
        @JoinColumn(name = "TIENDA_IDTIENDA", referencedColumnName = "IDTIENDA")})
    @ManyToMany
    private List<Tienda> tiendaList;
    @OneToMany(mappedBy = "ofertaIdoferta")
    private List<Logemail> logemailList;
    @OneToMany(mappedBy = "ofertaIdoferta")
    private List<Valoracion> valoracionList;
    @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
    @OneToOne(optional = false)
    private Producto productoIdproducto;

    public Oferta() {
    }

    public Oferta(BigDecimal idoferta) {
        this.idoferta = idoferta;
    }

    public BigDecimal getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(BigDecimal idoferta) {
        this.idoferta = idoferta;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Serializable getFotografia() {
        return fotografia;
    }

    public void setFotografia(Serializable fotografia) {
        this.fotografia = fotografia;
    }

    public BigInteger getMinimoproductos() {
        return minimoproductos;
    }

    public void setMinimoproductos(BigInteger minimoproductos) {
        this.minimoproductos = minimoproductos;
    }

    public BigInteger getMaximoproductos() {
        return maximoproductos;
    }

    public void setMaximoproductos(BigInteger maximoproductos) {
        this.maximoproductos = maximoproductos;
    }

    public BigInteger getIspublicada() {
        return ispublicada;
    }

    public void setIspublicada(BigInteger ispublicada) {
        this.ispublicada = ispublicada;
    }

    @XmlTransient
    public List<Tienda> getTiendaList() {
        return tiendaList;
    }

    public void setTiendaList(List<Tienda> tiendaList) {
        this.tiendaList = tiendaList;
    }

    @XmlTransient
    public List<Logemail> getLogemailList() {
        return logemailList;
    }

    public void setLogemailList(List<Logemail> logemailList) {
        this.logemailList = logemailList;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoferta != null ? idoferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idoferta == null && other.idoferta != null) || (this.idoferta != null && !this.idoferta.equals(other.idoferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.wsofertas.entities.Oferta[ idoferta=" + idoferta + " ]";
    }
    
}
