package com.service.auto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OPERATIE")
public class OPERATIE {
    
	@Id
	@GeneratedValue
	@Column(name = "id_oper")
	private Integer id_oper = null;
	
	@Column(name = "den_oper", unique = true, nullable = false )
	private String den_oper = null;
	
	@Column(name = "pret_oper", unique = false, nullable = false)
	private Integer pret_oper = null;
	
	public OPERATIE(){
		
	}

	public OPERATIE(String den_oper, Integer pret_oper) {
		
		this.den_oper = den_oper;
		this.pret_oper = pret_oper;
	}

	public Integer getId_oper() {
		return id_oper;
	}

	public String getDen_oper() {
		return den_oper;
	}

	public Integer getPret_oper() {
		return pret_oper;
	}

	public void setId_oper(Integer id_oper) {
		this.id_oper = id_oper;
	}

	public void setDen_oper(String den_oper) {
		this.den_oper = den_oper;
	}

	public void setPret_oper(Integer pret_oper) {
		this.pret_oper = pret_oper;
	}
	
	
	
}
