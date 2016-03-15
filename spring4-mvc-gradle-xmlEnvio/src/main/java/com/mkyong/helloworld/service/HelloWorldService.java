package com.mkyong.helloworld.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mkyong.helloworld.service.data.DataDB;
import com.mkyong.helloworld.service.pjs.Producto;

@Service
public class HelloWorldService {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);
	private final DataDB dataDB = new DataDB();
	
	
	public String getDesc() {

		logger.debug("getDesc() is executed!");

		return "";

	}

	public String getTitle(String name) {

		logger.debug("getTitle() is executed! $name : {}", name);

		if(StringUtils.isEmpty(name)){
			return "Stationary App";
		}else{
			return "Hello " + name;
		}
		
	}
	
	public boolean salvaProducto(Producto producto){
		boolean resultado = false;
		resultado = dataDB.salvaProducto(producto);
		return resultado;
	}
	public String salvaMProducto(Producto producto){
		String resultado = dataDB.salvaMProducto(producto);
		return resultado;
	}
	public ArrayList<Producto> getAll(){
		ArrayList<Producto> lstProducto = dataDB.getAllPrd();		
		return lstProducto;
	}
	
	public Producto getProducto(String snid){
		Producto producto = dataDB.getPrducto(snid);
		return producto;
	}
	public String deleteP(String snid){
		String resultado = dataDB.deleteP(snid);
		return resultado;
	}
}