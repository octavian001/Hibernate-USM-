package com.service.auto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MODEL")
public class MODEL {
	
	@Id
	@GeneratedValue
	@Column(name = "id_model")
	private Integer id_model = null;
	
	@Column(name = "den_model", unique = true, nullable = false)
	private String den_model = null;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="model")
	private Set <MARCA> marca;
	
	public MODEL(){
		
	}

	public MODEL( String den_model) {
		
		this.den_model = den_model;
	}

	public Integer getId_model() {
		return id_model;
	}

	public String getDen_model() {
		return den_model;
	}

	public Set<MARCA> getMarca() {
		return marca;
	}

	public void setId_model(Integer id_model) {
		this.id_model = id_model;
	}

	public void setDen_model(String den_model) {
		this.den_model = den_model;
	}

	public void setMarca(Set<MARCA> marca) {
		this.marca = marca;
	}

	
	
}
