package com.dev.fwk.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class JacksonUtil {

    private static ObjectMapper objectMapper() {
        ObjectMapper objectMapper = ContextUtil.getBean(ObjectMapper.class);
        if(objectMapper == null) {
            log.info("ObjectMapper new create");
            objectMapper = new ObjectMapper();
        }

        return objectMapper.copy();
    }

    private static JsonFactory jf() {
        return objectMapper().getFactory();
    }

	@SuppressWarnings("deprecation")
	public static JsonFactory getJsonFactory(){
		return objectMapper().getJsonFactory();
	}

	public static JsonParser getJsonParser(String jsonStr) throws IOException{
		@SuppressWarnings("deprecation")
		JsonParser jp = getJsonFactory().createJsonParser(jsonStr);
		return jp;
	}

	public static ArrayNode createArrayNode(){
		return objectMapper().createArrayNode();
	}

	public static String getObjectToJsonStr(Object paramObject) throws JsonProcessingException{
		return objectMapper().writeValueAsString(paramObject);
	}

	public static <T> T fromJson(String jsonAsString, Class<T> pojoClass) throws IOException {
		return objectMapper().readValue(jsonAsString, pojoClass);
	}

	public static <T> T fromJson(String jsonAsString, TypeReference<T> t) throws IOException {
		return objectMapper().readValue(jsonAsString, t);
	}

	public static <T> T fromJson(FileReader fr, Class<T> pojoClass) throws IOException {
		return objectMapper().readValue(fr, pojoClass);
	}

	public static String toJson(Object pojo) throws IOException {
		return toJson(pojo, false);
	}

	public static String toJson(Object pojo, boolean prettyPrint) throws IOException {
		StringWriter sw = new StringWriter();
		@SuppressWarnings("deprecation")
		JsonGenerator jg = jf().createJsonGenerator(sw);
		if (prettyPrint) {
			jg.useDefaultPrettyPrinter();
		}
		objectMapper().writeValue(jg, pojo);
		return sw.toString();
	}

	public static void toJson(Object pojo, FileWriter fw) throws JsonGenerationException, IOException {
		toJson(pojo, fw, false);
	}

	public static void toJson(Object pojo, FileWriter fw, boolean prettyPrint) throws JsonMappingException, JsonGenerationException, IOException {
		@SuppressWarnings("deprecation")
		JsonGenerator jg = jf().createJsonGenerator(fw);
		if (prettyPrint) {
			jg.useDefaultPrettyPrinter();
		}
		objectMapper().writeValue(jg, pojo);
	}

	public static JsonNode getJsonNode(String jsonData) throws IOException{
		return objectMapper().readTree(jsonData);
	}

	public static String addArrayJsonStr(String arrayJsonData, String jsonData) throws IOException{
		JsonNode orgJsonNode = getJsonNode(arrayJsonData);
		ArrayNode arrayNode = null;
		if(orgJsonNode.isArray()){
			arrayNode = (ArrayNode) orgJsonNode;

		}else{
			arrayNode = createArrayNode();
			arrayNode.add(orgJsonNode);
		}

		JsonNode jsonNode = getJsonNode(jsonData);
		if(jsonNode.isArray()){
			ArrayNode jsonDataArrayNode = (ArrayNode) jsonNode;
			for(JsonNode jsonDataJsonNode : jsonDataArrayNode){
				arrayNode.add(jsonDataJsonNode);
			}
		}else{
			arrayNode.add(jsonNode);
		}
		return arrayNode.toString();
	}

	public static String putArrayJsonData(String arrayJsonData, String jsonData,String key, String value) throws JsonProcessingException, IOException{
		ArrayNode arrayNode = (ArrayNode)getJsonNode(arrayJsonData);
		JsonNode jsonNode = getJsonNode(jsonData);
		boolean flag = false;
		for(int i=0  ;i< arrayNode.size(); i++){
			if(arrayNode.get(i).get(key).equals(jsonNode.get(key))){
				arrayNode.remove(i);
				arrayNode.insert(i, jsonNode);
				flag = true;
			}
		}
		if(!flag){
			arrayNode.add(jsonNode);
		}

		return arrayNode.toString();
	}

	public static String putArrayJsonStr(String jsonData, String value) throws IOException{
		ArrayNode arrayNode = (ArrayNode)getJsonNode(jsonData);
		return arrayNode.add(value).toString();
	}

	public static ObjectNode putJsonNode(JsonNode jsonNode, String key, String value){
		return ((ObjectNode) jsonNode).put(key, value);
	}

	public static boolean isArrayJsonNode(ArrayNode arrayJson, String key, String val){
		boolean result = false;
		for(JsonNode jnodeSorce : arrayJson){
			String newValue =  jnodeSorce.get(key).toString();
			if(newValue.equals(val)){
				result = true;
				break;
			}
		}
		return result;
	}

	public static JsonNode findArrayJsonNode(ArrayNode arrayJson, String key, String val){
		JsonNode jsonNode = null;

		for(JsonNode jnodeSorce : arrayJson){
			String newValue =  jnodeSorce.get(key).textValue();
			if(newValue.equals(val)){
				jsonNode = jnodeSorce;
				break;
			}
		}

		return jsonNode;
	}

	public static String findJsonNodeValue(JsonNode jsonSorce, String key){
		return jsonSorce.get(key).toString();
	}
}
