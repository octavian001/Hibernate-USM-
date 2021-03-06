package com.service.auto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MECANIC")
public class MECANIC {
	
	@Id
	@GeneratedValue
	@Column(name = "id_mecanic")
	private Integer id_mecanic = null;
	
	@Column(name = "nume", unique = false, nullable = false)
	private String nume = null;
	
	@Column(name = "prenume", unique = false, nullable = false)
	private String prenume = null;
	
	@Column(name = "cnm", unique = true, nullable = false)
	private String cnm = null;
	
	@Column(name = "telefon", unique = true, nullable = false)
	private Integer telefon = null;
	
	@Column(name = "adresa", unique = true, nullable = false)
	private String email = null;
	
	@Column(name = "email", unique = true, nullable = false)
	private String adresa = null;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="id_mecanic")
	private Set<BON> bon;
	
	public MECANIC(){
		
	}

	public MECANIC( String nume, String prenume,String cnm,
			Integer telefon, String email, String adresa) {
		
		this.nume = nume;
		this.prenume = prenume;
		this.cnm = cnm;
		this.telefon = telefon;
		this.email = email;
		this.adresa = adresa;
	}

	
	public String getCnm() {
		return cnm;
	}

	public void setCnm(String cnm) {
		this.cnm = cnm;
	}
	
	public Set<BON> getBon() {
		return bon;
	}

	public void setBon(Set<BON> bon) {
		this.bon = bon;
	}

	
	public Integer getId_mecanic() {
		return id_mecanic;
	}

	
	public String getNume() {
		return nume;
	}

	public String getPrenume() {
		return prenume;
	}
	
	public Integer getTelefon() {
		return telefon;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAdresa() {
		return adresa;
	}

	public void setId_mecanic(Integer id_mecanic) {
		this.id_mecanic = id_mecanic;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	
	
	

}
