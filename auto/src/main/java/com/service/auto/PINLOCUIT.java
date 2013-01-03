package com.service.auto;

public class PINLOCUIT {
	private Integer id_piesa = null;
	private Integer id_bon = null;
	private Integer cant = null;
	
	public PINLOCUIT(){
		
	}

	public PINLOCUIT(Integer id_piesa, Integer id_bon, Integer cant) {
		
		this.id_piesa = id_piesa;
		this.id_bon = id_bon;
		this.cant = cant;
	}

	public Integer getId_piesa() {
		return id_piesa;
	}

	public Integer getId_bon() {
		return id_bon;
	}

	public Integer getCant() {
		return cant;
	}

	public void setId_piesa(Integer id_piesa) {
		this.id_piesa = id_piesa;
	}

	public void setId_bon(Integer id_bon) {
		this.id_bon = id_bon;
	}

	public void setCant(Integer cant) {
		this.cant = cant;
	}
	
	
	

}
