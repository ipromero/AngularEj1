package com.mkyong.helloworld.service.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mkyong.helloworld.service.HelloWorldService;
import com.mkyong.helloworld.service.pjs.Producto;

public class DataDB {
	private static final Logger logger = LoggerFactory.getLogger(DataDB.class);
	Map<Integer, Producto> mapPrd = new HashMap<Integer, Producto>();
	
	public boolean salvaProducto(Producto producto){
		boolean resultado = false;
		if(encontrado(producto)){
			logger.debug("Producto Ya existe: {}",producto.getsDescripcion());
			return resultado;
		}
		
		producto.setnId(mapPrd.size()+1);
		mapPrd.put(mapPrd.size()+1, producto);
		logger.debug("salveProducto: {}", mapPrd.size()+": "+producto.getsDescripcion());
		//inTime
		resultado = true;
		
		return resultado;
	}
	
	public String salvaMProducto(Producto producto){
		String resultado = "El producto no fue encontrado";
		Iterator it = mapPrd.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry e = (Map.Entry)it.next();
		    Producto otmp = (Producto)e.getValue();
		    System.out.println(e.getKey() + " " + otmp.getsDescripcion());
		    logger.debug("Buscando: {}"+ otmp.getnId() + " - " + otmp.getsDescripcion());
		    if( otmp.getnId()  == producto.getnId() ){
		    	otmp.setnStock( producto.getnStock() );
		    	otmp.setsDescripcion(producto.getsDescripcion());
		    	otmp.setsMarca(producto.getsMarca());
		    	return "El producto fue modificado exitosamente";
		    }
		}
	
		return resultado;
	}
	
	public boolean encontrado(Producto producto){
		boolean resultado = false;
		
		Iterator it = mapPrd.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry e = (Map.Entry)it.next();
		    Producto otmp = (Producto)e.getValue();
		    System.out.println(e.getKey() + " " + otmp.getsDescripcion());
		    logger.debug("Buscando: {}"+ e.getKey() + " - " + otmp.getsDescripcion());
		    if( otmp.getsDescripcion().equals(producto.getsDescripcion())){
		    	return true;
		    }
		}
		return resultado;
	}
	
	public ArrayList<Producto> getAllPrd(){
		ArrayList<Producto> lstProducto = new ArrayList<Producto>();
		Iterator it = mapPrd.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry e = (Map.Entry)it.next();
		    System.out.println(e.getKey() + " " + e.getValue());
		    lstProducto.add((Producto)e.getValue());
		}
		
		return lstProducto;
	}
	public Producto  getPrducto(String sid){
		Producto resultado = new Producto();
		
		Iterator it = mapPrd.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry e = (Map.Entry)it.next();
		    Producto otmp = (Producto)e.getValue();
		    logger.debug("BuscandoPorConsulta: {param}"+sid+ " - " + otmp.getnId()+".."+ otmp.getsDescripcion());
		    if( Integer.parseInt(sid) == otmp.getnId() ){
		    	 logger.debug("Lo encontre");
		    	resultado = otmp;
		    	break;
		    }
		    
		}
		logger.debug("res  "+resultado.getsDescripcion());
		return resultado;
	}
	
	public String deleteP(String sid){

		Iterator it = mapPrd.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry e = (Map.Entry)it.next();		    
		    Producto otmp = (Producto)e.getValue();
		    logger.debug("BuscandoPorConsulta: {param}"+sid+ " - " + otmp.getnId()+".."+ otmp.getsDescripcion());
		    if( Integer.parseInt(sid) == otmp.getnId() ){
		    	 logger.debug("EliminarLo encontre");
		    	mapPrd.remove(e.getKey());
		    	return "Registro fue eliminado exitosamente";
		    }
		    
		}
		
		return "Registro no fue eliminado";
	}
}
