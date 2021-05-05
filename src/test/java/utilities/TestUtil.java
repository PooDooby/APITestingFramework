package utilities;

import org.json.JSONObject;

import com.dooby.listeners.ExtentListeners;

public class TestUtil {
	
	public static boolean jsonHasKey(String json, String key) {
		
		JSONObject jObject = new JSONObject(json);
		
		ExtentListeners.testReport.get().info("Validating the presence of the key" + key);
		
		return jObject.has(key);
		
	}
	
	public static String getJsonKeyValue(String json, String key) {
		
		JSONObject jObject = new JSONObject(json);
		
		ExtentListeners.testReport.get().info("Validating the value of the key" + key);
		
		return jObject.get(key).toString();
		
	}
	

}
