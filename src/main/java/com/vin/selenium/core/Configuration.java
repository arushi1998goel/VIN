package com.vin.selenium.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vin.dataproviders.User;
import com.vin.dataproviders.UserDetails;
import com.vin.utilities.Utilities;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class Configuration {

	private String fileName;

	public Configuration(String fileName) {
		this.fileName = fileName;
	}

	public static String readApplicationFile2(String key) throws Exception {
		String value;
		try {
			Properties prop = new Properties();
			File f = new File(Utilities.getPath() + "//config.properties");
			if (f.exists()) {
				prop.load(new FileInputStream(f));
				value = prop.getProperty(key);
			} else {
				throw new Exception("File not found");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Failed to read from application.properties file.");
			throw ex;
		}
		if (value == null) {
			throw new Exception("Key not found in properties file");
		}
		return value;
	}

	public static String readApplicationFile(String key) throws Exception {
		String value;
		try {
			Properties prop = new Properties();
			InputStream inputStream = Configuration.class.getResourceAsStream("/testdata/config.properties");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
			if (bufferReader.ready()) {
				prop.load(inputStream);
				value = prop.getProperty(key);
				inputStream.close();
				bufferReader.close();
			} else {
				throw new FileNotFoundException("File not found");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Failed to read from application.properties file.");
			throw ex;
		}
		catch (IOException ex) {
			System.out.println("IO Failure properties file.");
			throw ex;
		}
		if (value == null) {
			throw new Exception("Key not found in properties file");
		}
		return value;

	}

	public static Properties readTestData(String fileName) throws Exception {
		Properties prop = new Properties();
		try {
			InputStream inputStream = Configuration.class.getResourceAsStream("/testdata/"+fileName+".properties");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
			if (bufferReader.ready()) {
				prop.load(inputStream);
				inputStream.close();
				bufferReader.close();
			}
			else {
				throw new FileNotFoundException("File not found");
			}
		}
		catch (FileNotFoundException ex) {
			System.out.println("Failed to read from application.properties file.");
			throw ex;
		}
		catch (IOException ex) {
			System.out.println("IO Failure properties file.");
			throw ex;
		}
		return prop;
	}

	@Deprecated
	public static Properties readTestData2(String fileName) throws Exception {
		Properties prop = new Properties();
		try {
			File f = new File(Utilities.getPath() + "//src//test//resources//testdata//" + fileName + ".properties");
			if (f.exists()) {
				prop.load(new FileInputStream(f));
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found " + fileName);
		}
		return prop;
	}

	public static String readTestData(String key, String file) throws Exception {
		Properties prop = new Properties();
		String value;
		try {
			File f = new File(Utilities.getPath() + "//src//test//resources//testdata//" + file + ".properties");
			if (f.exists()) {
				prop.load(new FileInputStream(f));
				value = prop.getProperty(key);
			} else {
				throw new Exception("File not found");
			}
		} catch (FileNotFoundException ex) {
			throw ex;
		}
		if (value == null) {
			throw new Exception("Key not found in properties file");
		}
		return value;
	}

	public static void updatePropertyTestData(String fileName, String key, String value) {
		Properties props = new Properties();
		File f = new File("src//test//resources//testdata//" + fileName + ".properties");
		try {
			final FileInputStream configStream = new FileInputStream(f);
			props.load(configStream);
			configStream.close();

			props.setProperty(key, value);

			final FileOutputStream output = new FileOutputStream(f);
			props.store(output, "");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			output.close();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (final IOException ex) {
			System.out.println(ex);
		}
	}

	public static void copyProperties(Properties src_prop, Properties dest_prop) {
		for (Enumeration propertyNames = src_prop.propertyNames(); propertyNames.hasMoreElements();) {
			Object key = propertyNames.nextElement();
			dest_prop.clear();
			dest_prop.put(key, src_prop.get(key));
		}
	}


	public static String getUserPassword(String UserName) {
		String userPass=null;
		try {
			InputStream inputStream = Configuration.class.getResourceAsStream("/testdata/UserCredentials.json");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
			if(bufferReader.ready()) {
				ObjectMapper mapper = new ObjectMapper();

				UserDetails ud = mapper.readValue(inputStream, UserDetails.class);
//				System.out.println(ud);


				mapper.enable(SerializationFeature.INDENT_OUTPUT);
//				System.out.println(mapper.writeValueAsString(ud));

				for(User user:ud.getUsers())
                {
                    if(user.getUsername().equalsIgnoreCase(UserName))
                    {
                        return user.getPassword();
                    }
                }


			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userPass;
	}

}
