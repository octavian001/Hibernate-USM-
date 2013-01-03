package com.service.auto;

public class PIESE {

	private Integer id_piesa = null;
	private String denumire = null;
	private Integer pret = null;
	private Integer cantitate = null;
	
	public PIESE(){
		
	}

	public PIESE(Integer id_piesa, String denumire, Integer pret,
			Integer cantitate) {
		
		this.id_piesa = id_piesa;
		this.denumire = denumire;
		this.pret = pret;
		this.cantitate = cantitate;
	}

	public Integer getId_piesa() {
		return id_piesa;
	}

	public String getDenumire() {
		return denumire;
	}

	public Integer getPret() {
		return pret;
	}

	public Integer getCantitate() {
		return cantitate;
	}

	public void setId_piesa(Integer id_piesa) {
		this.id_piesa = id_piesa;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public void setPret(Integer pret) {
		this.pret = pret;
	}

	public void setCantitate(Integer cantitate) {
		this.cantitate = cantitate;
	}
	
	
	
}
