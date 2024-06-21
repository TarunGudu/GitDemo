package AparTechnologies.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
 public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
	 //read json to string
	String jsonContent =  FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
         //next step is convert string into Hasmap
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
	});
		return data;
	}
 }

//FileUtils.readFileToString(new File((System.getProperty("user.dir")+"//src//test//java//AparTechnologies//data//PurchaseOrder.json"));