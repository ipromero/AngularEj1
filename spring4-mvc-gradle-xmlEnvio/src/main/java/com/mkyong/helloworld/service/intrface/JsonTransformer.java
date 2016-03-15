package com.mkyong.helloworld.service.intrface;

import java.util.ArrayList;

import com.mkyong.helloworld.service.pjs.Producto;

public interface JsonTransformer {
	  String toJson(Object data);
	  <T> T fromJSON(String json, Class<T> clazz);
}
