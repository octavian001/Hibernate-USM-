package com.service.auto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="id_marca")
	private MARCA marca;
	
	public MODEL(){
		
	}

	public MODEL( String den_model) {
		
		this.den_model = den_model;
	}

	public MODEL(String den_model, MARCA marca) {
		
		this.den_model = den_model;
		this.marca = marca;
	}

	public Integer getId_model() {
		return id_model;
	}

	public String getDen_model() {
		return den_model;
	}

	
	public void setId_model(Integer id_model) {
		this.id_model = id_model;
	}

	public void setDen_model(String den_model) {
		this.den_model = den_model;
	}

	public MARCA getMarca() {
		return marca;
	}

	public void setMarca(MARCA marca) {
		this.marca = marca;
	}

	
	
	
}
