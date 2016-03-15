package com.mkyong.helloworld.service.implmnt;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkyong.helloworld.service.intrface.JsonTransformer;

import java.io.IOException;
 
public class JsonTransformerImplJackson implements JsonTransformer {
 
    @Override
    public String toJson(Object data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
 
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
 
   /* @Override
    public Object fromJson(String json, Class clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
 
            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
*/
	@Override
	public <T> T fromJSON(String json, Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}
 
}