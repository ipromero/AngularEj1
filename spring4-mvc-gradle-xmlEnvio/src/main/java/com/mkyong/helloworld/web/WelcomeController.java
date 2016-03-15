package com.mkyong.helloworld.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.helloworld.service.HelloWorldService;
import com.mkyong.helloworld.service.implmnt.JsonTransformerImplJackson;
import com.mkyong.helloworld.service.intrface.JsonTransformer;
import com.mkyong.helloworld.service.pjs.Producto;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	private final HelloWorldService helloWorldService;

	@Autowired
	public WelcomeController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());
		
		return "alta";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("alta");
		
		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());
		
		return model;

	}

	@RequestMapping(value = "alta", method = RequestMethod.GET)
	public String alta(Map<String, Object> model) {

		logger.debug("altaProducto() is executed!");

		model.put("title", "Alta de Productos");
		model.put("msg", "Indiquee los datos solicitados");
		
		return "alta";
	}
	
	@RequestMapping(value = "eliminar", method = RequestMethod.POST)
	public @ResponseBody String baja( @RequestBody String id) throws JsonProcessingException {

		logger.debug(". . . EliminaProducto() is executed!"+id);
		logger.debug(". ."+helloWorldService.deleteP(id) );
		
		final ObjectMapper mapper = new ObjectMapper();
		ArrayList<Producto> lstProductos = helloWorldService.getAll();
		String jsonLst  =mapper.writeValueAsString(lstProductos);
		
		
		logger.debug("elimnated. . . jsonLst  "+jsonLst);
		return jsonLst;
	}
	
	/*@RequestMapping(value = "/consulta", method = RequestMethod.POST)
	public @ResponseBody String consulta(@RequestBody String sid) throws JsonProcessingException {
*/
	@RequestMapping(value = "/consulta/{sid:.+}", method = RequestMethod.GET)
	public ModelAndView consulta( @PathVariable("sid") String snid) {
		logger.debug(". . . consultaProd() is executed!!!"+snid);
		
		Producto producto = helloWorldService.getProducto(snid);
		ModelAndView model = new ModelAndView();
		
		model.setViewName("consulta");
		logger.debug(". . .producto "+producto.getnId());
		model.addObject("producto", producto);
		
		return model;
	}	

	@RequestMapping(value = "editar", method = RequestMethod.POST)
	public @ResponseBody Producto editar2( @RequestBody String id) {
			logger.debug(". . . Editar2() is executed!!!"+id);
		
		Producto producto = helloWorldService.getProducto(id);
		logger.debug(". . .Obtenidoproductoe "+producto.getnId());
		
		
		return producto;
	}	
	
	@RequestMapping(value = "/PostFormData", method = RequestMethod.POST)
	public @ResponseBody String PostService(@RequestBody Producto producto) throws JsonProcessingException {
		
		final ObjectMapper mapper = new ObjectMapper();
		logger.debug(". . . DescProducto  "+producto.getsDescripcion());

		helloWorldService.salvaProducto(producto);
		ArrayList<Producto> lstProductos = helloWorldService.getAll();
		
		
		String jsonLst  =mapper.writeValueAsString(lstProductos);
		
		
		logger.debug(". . . jsonLst  "+jsonLst);
		return jsonLst;
	}
	
	@RequestMapping(value = "/salvare", method = {RequestMethod.POST, RequestMethod.HEAD})
	public @ResponseBody String salvarEd(@RequestBody Producto producto) throws JsonProcessingException {
	
		logger.debug(". . . 2SalvandoModificacionesProducto  "+producto.getsDescripcion());
		String resultado = helloWorldService.salvaMProducto(producto);
		
		logger.debug(". . . 2 "+resultado);
		final ObjectMapper mapper = new ObjectMapper();
		ArrayList<Producto> lstProductos = helloWorldService.getAll();
		String jsonLst  =mapper.writeValueAsString(lstProductos);
		
		
		logger.debug("salvadaedicion. . . jsonLst  "+jsonLst);
		return jsonLst;
	}
	
	@RequestMapping(value = "/PostFormDataS", method = {RequestMethod.POST, RequestMethod.HEAD})
	public @ResponseBody String PostServiceSC(@RequestBody Producto producto) {
	
		logger.debug(". . . SalvandoModificacionesProducto  "+producto.getsDescripcion());
		String resultado = helloWorldService.salvaMProducto(producto);
		
		logger.debug(". . .  "+resultado);
		return resultado;
	}
	
	@RequestMapping(value = "/formResxxxx", method = RequestMethod.POST)
	public @ResponseBody String Regresa() throws JsonProcessingException {
		
		final ObjectMapper mapper = new ObjectMapper();
		logger.debug(". . . Regresando  ");

		ArrayList<Producto> lstProductos = helloWorldService.getAll();
		
		String jsonLst  =mapper.writeValueAsString(lstProductos);
		
		logger.debug(". . . regresajsonLst  "+jsonLst);
		return jsonLst;
	}
	
	@RequestMapping(value = "regresar", method = RequestMethod.POST)
	public String regresar(Map<String, Object> model) throws JsonProcessingException {

		logger.debug("Regresando() is executed!");
		final ObjectMapper mapper = new ObjectMapper();
		ArrayList<Producto> lstProductos = helloWorldService.getAll();
		String jsonLst  =mapper.writeValueAsString(lstProductos);
		model.put("productos", jsonLst);
		
		logger.debug(". . . regresaNDOjsonLst  "+jsonLst);
		
		
		return jsonLst;
	}
	@RequestMapping(value = "/fetchAll", method = RequestMethod.POST)
	public @ResponseBody List<Producto> FetchAll() {
		ArrayList<Producto> lstProductos = helloWorldService.getAll();
		return lstProductos;
	}
	
}