package api.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Apienvironment {

	public static void createEnvironmentFile(String env) {
		try {
			Properties props = new Properties();
			props.setProperty("environment", env);
			props.setProperty("java.version", System.getProperty("java.version"));
			props.setProperty("os.name", System.getProperty("os.name"));
			props.setProperty("os.version", System.getProperty("os.version"));

			// Write properties to environment.properties in allure-results folder
			File file = new File("allure-results/environment.properties");
			FileWriter writer = new FileWriter(file);
			props.store(writer, "Environment Details");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	}
	

