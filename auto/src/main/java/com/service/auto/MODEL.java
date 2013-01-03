package com.service.auto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
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

	public void setId_model(Integer id_model) {
		this.id_model = id_model;
	}

	public void setDen_model(String den_model) {
		this.den_model = den_model;
	}

	
	
}
