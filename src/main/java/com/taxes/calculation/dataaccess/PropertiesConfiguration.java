package com.taxes.calculation.dataaccess;

import java.io.FileInputStream;
import java.util.Properties;

import utilities.Utilities;

public class PropertiesConfiguration {

	private static final String FILE_PROPERTIES_PATH ="./src/main/resources/database.properties";

	private static PropertiesConfiguration propertiesConfiguration = null;
	private Properties props = null;
	
	private PropertiesConfiguration() throws Exception{
		try {
		    props = new Properties();
			props.load(new FileInputStream(System.getProperty("user.dir") + FILE_PROPERTIES_PATH));
		} catch (Exception e) {
			Utilities.log(e);
			throw e;
		}
	}

	/**
	 * 
	 * Singleton to load in memory only once all properties
	 * 
	 * @return
	 * @throws Exception 
	 */
	public static PropertiesConfiguration getPropertiesConfiguration() throws Exception{
		if(propertiesConfiguration==null){
			propertiesConfiguration = new PropertiesConfiguration();
		}
		return propertiesConfiguration;
	}

	public Properties getProps() {
		return props;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("PropertiesConfiguration [props=");
		builder.append(props);
		builder.append("]");
		return builder.toString();
	}
	
}
