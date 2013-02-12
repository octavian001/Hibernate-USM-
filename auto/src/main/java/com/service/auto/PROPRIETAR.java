package com.service.auto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table (name = "PROPRIETAR")
public class PROPRIETAR {
	@Id
	@GeneratedValue
	@Column(name = "id_proprietar")
	private Integer id_proprietar = null;
	
	@Column(name = "nume", unique = false, nullable = false)
	private String nume = null;
	
	@Column(name = "prenume", unique = false, nullable = false)
	private String prenume = null;
	
	@Column(name = "cnp", unique = true, nullable = true)
	private String cnp = null;
	
	@Column(name = "telefon", unique = false, nullable = false)
	private Integer telefon = null;
	
	@Column(name = "adresa", unique = false, nullable  = false)
	private String adresa = null;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="id_proprietar")
	private Set<AUTO> auto;
	
	public PROPRIETAR(){
		
	}

	public PROPRIETAR( String nume,String prenume,String cnp, Integer telefon, String adresa) {
		
		this.nume = nume;
		this.prenume = prenume;
		this.cnp = cnp;
		this.telefon = telefon;
		this.adresa = adresa;
	}
    
	
	
	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getPrenume() {
		return prenume;
	}
	
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Set<AUTO> getAuto() {
		return auto;
	}

	public void setAuto(Set<AUTO> auto) {
		this.auto = auto;
	}

	public Integer getId_proprietar() {
		return id_proprietar;
	}
    
	public String getNume() {
		return nume;
	}

	public Integer getTelefon() {
		return telefon;
	}

	public void setId_proprietar(Integer id_proprietar) {
		this.id_proprietar = id_proprietar;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}
	
	


}

