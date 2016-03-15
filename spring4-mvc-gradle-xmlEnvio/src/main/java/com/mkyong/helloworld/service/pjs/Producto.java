package com.mkyong.helloworld.service.pjs;

import org.springframework.stereotype.Component;

@Component
public class Producto {
	private int nId;
	private String sDescripcion;
	private String sMarca;
	private int nStock;
	
	public Producto(){
		
	}
	
	public Producto(Integer nid, String sDescripcion, String sMarca, int nStock){
		this.nId = nid;
		this.sDescripcion = sDescripcion;
		this.sMarca = sMarca;
		this.nStock = nStock;
	}
	
	public String getsDescripcion() {
		return sDescripcion;
	}
	public void setsDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
	}
	public String getsMarca() {
		return sMarca;
	}
	public void setsMarca(String sMarca) {
		this.sMarca = sMarca;
	}
	public int getnStock() {
		return nStock;
	}
	public void setnStock(int nStock) {
		this.nStock = nStock;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	
	
}
