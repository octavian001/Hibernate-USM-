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
@Table (name = "MARCA")
public class MARCA {
	
	@Id
	@GeneratedValue
	@Column(name = "id_marca")
	private Integer id_marca = null;
	
	 @Column(name = "den_marca", nullable = false, unique = true)
	private String den_marca = null;
	
	 @ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="id_model",referencedColumnName="id_model")
	private MODEL id_model = null;
	
	public MARCA(){
		
	}

	public MARCA( String den_marca, MODEL id_model) {
	
		this.den_marca = den_marca;
		this.id_model = id_model;
		
	}
	
	
	public Integer getId_marca() {
		return id_marca;
	}
   
	public String getDen_marca() {
		return den_marca;
	}

	public MODEL getId_model() {
		return id_model;
	}

	public void setId_marca(Integer id_marca) {
		this.id_marca = id_marca;
	}

	public void setDen_marca(String den_marca) {
		this.den_marca = den_marca;
	}

	public void setId_model(MODEL id_model) {
		this.id_model = id_model;
	}
	
	

}
