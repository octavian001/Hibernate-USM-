package com.service.auto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "PIESE")
public class PIESE {
     
	@Id
	@GeneratedValue
	@Column(name = "id_piesa")
	private Integer id_piesa = null;
	
	@Column(name = "denumire", nullable = false, unique = true)
	private String denumire = null;
	
	@Column(name = "pret", nullable = true, unique = false)
	private Integer pret = null;
	
	@Column(name = "cantitate", nullable = false, unique = false)
	private Integer cantitate = null;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bon_piese", joinColumns = { @JoinColumn(name =
			"id_piesa"/*, nullable = false, updatable = false*/) }, inverseJoinColumns = { @JoinColumn(name =
					"id_bon"/*, nullable = false, updatable = false*/) })
	private Set<BON> bon;
	
	public PIESE(){
		
	}

	public PIESE(String denumire, Integer pret,
			Integer cantitate, Set<BON> bon) {
		
		this.denumire = denumire;
		this.pret = pret;
		this.cantitate = cantitate;
		this.bon = bon;
	}

	
	
	public Set<BON> getBon() {
		return bon;
	}

	public void setBon(Set<BON> bon) {
		this.bon = bon;
	}

	public Integer getId_piesa() {
		return id_piesa;
	}

	public String getDenumire() {
		return denumire;
	}

	public Integer getPret() {
		return pret;
	}

	public Integer getCantitate() {
		return cantitate;
	}

	public void setId_piesa(Integer id_piesa) {
		this.id_piesa = id_piesa;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public void setPret(Integer pret) {
		this.pret = pret;
	}

	public void setCantitate(Integer cantitate) {
		this.cantitate = cantitate;
	}
	
	
	
}
