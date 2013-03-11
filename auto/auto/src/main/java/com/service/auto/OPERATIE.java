package com.service.auto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;


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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bon_oper", joinColumns = { @JoinColumn(name =
			"id_oper"/*, nullable = false, updatable = false*/) }, inverseJoinColumns = { @JoinColumn(name =
					"id_bon"/*, nullable = false, updatable = false*/) })
	private Set<BON> bon;
	
	public Set<BON> getBon() {
		return bon;
	}

	public void setBon(Set<BON> bon) {
		this.bon = bon;
	}

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
