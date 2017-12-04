package com.connxun.util.easemob.tool;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

import static com.fasterxml.jackson.databind.SerializationFeature.*;

public class JsonTool {
	public static String write(Object data) throws Exception {
		if(data==null){
			return null;
		}
		ObjectMapper mapper= new ObjectMapper();
//		ObjectMapper mapper = new ObjectMapper();
		init(mapper);
		return mapper.writeValueAsString(data);
	}
	public static Object read(String json, Class<?>clz) throws Exception {
		if(json==null||json.equals("")||clz==null){
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		init(mapper);
		return mapper.readValue(json,clz);
	}
	private static void init(ObjectMapper mapper) {
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,false);
		mapper.configure(WRAP_EXCEPTIONS,true);
		mapper.configure(WRITE_DATES_AS_TIMESTAMPS,false);
		mapper.configure(WRITE_NULL_MAP_VALUES,false);

//		mapper.configure(SerializationConfig.Feature.WRAP_EXCEPTIONS,true);
//		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,false);
//		mapper.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES,false);

		mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

//		mapper.setSerializationInclusion(Inclusion.NON_DEFAULT);
//		mapper.setSerializationInclusion(Inclusion.NON_EMPTY);
//		mapper.setSerializationInclusion(Inclusion.NON_NULL);
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}
}