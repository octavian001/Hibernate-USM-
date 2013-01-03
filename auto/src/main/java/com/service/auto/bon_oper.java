package com.service.auto;

public class bon_oper {
	
	private Integer id_bon = null;
    private Integer id_oper = null;
    
    public bon_oper(){
    	
    }

	public bon_oper(Integer id_bon, Integer id_oper) {
		this.id_bon = id_bon;
		this.id_oper = id_oper;
	}

	public Integer getId_bon() {
		return id_bon;
	}

	public Integer getId_oper() {
		return id_oper;
	}

	public void setId_bon(Integer id_bon) {
		this.id_bon = id_bon;
	}

	public void setId_oper(Integer id_oper) {
		this.id_oper = id_oper;
	}
	
	
    
    
}
