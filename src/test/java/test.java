import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tts.scp.converter.DTOs.ResponseDTO;

public class test { 

	public static void main(String[] args) {

		File file = new File("src/test/resources/response.json");

		try {
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
			ResponseDTO dataObject = mapper.readValue(file, ResponseDTO.class);
			System.out.println(dataObject.getLastName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
