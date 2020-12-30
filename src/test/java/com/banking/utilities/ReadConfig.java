package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File file = new File("./Configuration/config.properties");
		try {
			FileInputStream fin = new FileInputStream(file);
			pro = new Properties();
			pro.load(fin);
		} catch (Exception ex) {

		}
	}

	public String getApplicationUrl() {

		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromepath() {
		String path = pro.getProperty("chromePath");
		return path;
	}

	public String getChromeExepath() {
		String path = pro.getProperty("chromeExePath");
		return path;
	}
	
	public String getFirefoxpath() {
		String path = pro.getProperty("firefoxPath");
		return path;
	}

	public String getIEpath() {
		String path = pro.getProperty("IEPath");
		return path;
	}
}
