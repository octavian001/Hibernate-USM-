package com.service.auto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MECANIC")
public class MECANIC {
	
	@Id
	@GeneratedValue
	@Column(name = "id_mecanic")
	private Integer id_mecanic = null;
	
	@Column(name = "nume", unique = true, nullable = false)
	private String nume = null;
	
	@Column(name = "prenume", unique = true, nullable = false)
	private String prenume = null;
	
	@Column(name = "telefon", unique = true, nullable = false)
	private Integer telefon = null;
	
	@Column(name = "email", unique = true)
	private String email = null;
	
	@Column(name = "adresa", unique = true)
	private String adresa = null;
	
	public MECANIC(){
		
	}

	public MECANIC( String nume, String prenume,
			Integer telefon, String email, String adresa) {
		
		this.nume = nume;
		this.prenume = prenume;
		this.telefon = telefon;
		this.email = email;
		this.adresa = adresa;
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
