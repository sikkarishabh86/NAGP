package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	static String filepath = "./src/files/password.properties";

	public static String getAppPassword() throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		Properties properties = new Properties();
		properties.load(fis);
		String password = properties.getProperty("appPassword");
//		System.out.println(password);
		return password;
	}

}
