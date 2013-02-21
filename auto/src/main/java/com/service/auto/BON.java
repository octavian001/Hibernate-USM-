package com.service.auto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;

@Entity
@Table(name="BON")
public class BON {
    
	@Id
	@GeneratedValue
	@Column(name = "id_bon")
	private Integer id_bon = null;
	
	@Column(name = "data_bon", unique = true, nullable = false)
	private String data_bon = null;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_mecanic",referencedColumnName="id_mecanic")
	private MECANIC id_mecanic = null;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_proprietar",referencedColumnName="id_proprietar")
	private PROPRIETAR id_proprietar = null;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_auto",referencedColumnName="id_auto")
	private AUTO id_auto = null;
	
	@Column(name = "pret_total", unique = true, nullable = false)
	private Integer pret_total = null;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bon_oper", joinColumns = { @JoinColumn(name =
			"id_bon"/*, nullable = false, updatable = false*/) }, inverseJoinColumns = { @JoinColumn(name =
					"id_oper"/*, nullable = false, updatable = false*/) })
	private Set<OPERATIE> oper;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bon_piese", joinColumns = { @JoinColumn(name =
			"id_bon"/*, nullable = false, updatable = false*/) }, inverseJoinColumns = { @JoinColumn(name =
					"id_piesa"/*, nullable = false, updatable = false*/) })
	private Set<PIESE> piese;
	
	public BON(String data_bon, MECANIC id_mecanic, PROPRIETAR id_proprietar,
			AUTO id_auto, Integer pret_total, Set<OPERATIE> oper, Set<PIESE> piese) {
		
		this.data_bon = data_bon;
		this.id_mecanic = id_mecanic;
		this.id_proprietar = id_proprietar;
		this.id_auto = id_auto;
		this.pret_total = pret_total;
		this.oper = oper;
		this.piese = piese;
	}


	public BON(){
	 	
	}
	
	/*
	public BON(String data_bon, MECANIC id_mecanic, PROPRIETAR id_proprietar,
			AUTO id_auto, Integer pret_total) {
	
		this.data_bon = data_bon;
		this.id_mecanic = id_mecanic;
		this.id_proprietar = id_proprietar;
		this.id_auto = id_auto;
		this.pret_total = pret_total;
	}
*/

	public Set<OPERATIE> getOper() {
		return oper;
	}


	public Set<PIESE> getPiese() {
		return piese;
	}


	public void setPiese(Set<PIESE> piese) {
		this.piese = piese;
	}


	public void setOper(Set<OPERATIE> oper) {
		this.oper = oper;
	}


	public Integer getId_bon() {
		return id_bon;
	}

	public String getData_bon() {
		return data_bon;
	}

	public MECANIC getId_mecanic() {
		return id_mecanic;
	}

	public PROPRIETAR getId_proprietar() {
		return id_proprietar;
	}

	public AUTO getId_auto() {
		return id_auto;
	}

	public Integer getPret_total() {
		return pret_total;
	}

	public void setId_bon(Integer id_bon) {
		this.id_bon = id_bon;
	}

	public void setData_bon(String data_bon) {
		this.data_bon = data_bon;
	}

	public void setId_mecanic(MECANIC id_mecanic) {
		this.id_mecanic = id_mecanic;
	}

	public void setId_proprietar(PROPRIETAR id_proprietar) {
		this.id_proprietar = id_proprietar;
	}

	public void setId_auto(AUTO id_auto) {
		this.id_auto = id_auto;
	}

	public void setPret_total(Integer pret_total) {
		this.pret_total = pret_total;
	}

	
	}
