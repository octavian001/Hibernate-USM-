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

@Entity
@Table(name="AUTO")
public class AUTO {
	
	   @Id
	   @GeneratedValue
	   @Column(name = "id_auto")
       private Integer id_auto = null;
	   
	   @Column(name = "nr_inmatr", unique = true, nullable = false)
	   private String nr_inmatr = null;
	   
	   @Column(name =  "serie_motor",unique = true ,nullable = false)
       private String serie_motor = null;
	   
	   @Column(name = "an_fabr", unique = false, nullable = false)
       private Integer an_fabr = null;
	   
	   @ManyToOne(/*cascade = CascadeType.ALL*/)
	   @JoinColumn(name="id_marca"/*,referencedColumnName="id_marca"*/)
       private MARCA id_marca = null;
	   
	   @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="id_proprietar"/*,referencedColumnName="id_proprietar"*/)
       private PROPRIETAR id_proprietar = null;
       
       public AUTO(){
    	   
       }
       

	   public AUTO( String nr_inmatr, String serie_motor,
			Integer an_fabr,MARCA id_marca, PROPRIETAR id_proprietar) {
	
		this.nr_inmatr = nr_inmatr;
		this.serie_motor = serie_motor;
		this.an_fabr = an_fabr;
		this.id_marca = id_marca;
		this.id_proprietar = id_proprietar;
	}

	public Integer getId_auto() {
		return id_auto;
	}

	public String getNr_inmatr() {
		return nr_inmatr;
	}

	public String getSerie_motor() {
		return serie_motor;
	}
 
	public Integer getAn_fabr() {
		return an_fabr;
	}
	
	public MARCA getId_marca() {
		return id_marca;
	}
	 
    public PROPRIETAR getId_proprietar() {
		return id_proprietar;
	}

	public void setId_proprietar(PROPRIETAR id_proprietar) {
		this.id_proprietar = id_proprietar;
	}


	public void setId_auto(Integer id_auto) {
		this.id_auto = id_auto;
	}

	public void setNr_inmatr(String nr_inmatr) {
		this.nr_inmatr = nr_inmatr;
	}

	public void setSerie_motor(String serie_motor) {
		this.serie_motor = serie_motor;
	}

	public void setAn_fabr(Integer an_fabr) {
		this.an_fabr = an_fabr;
	}

	public MARCA setId_marca(MARCA id_marca) {
		return this.id_marca = id_marca;
	}
		
       
        
	}

