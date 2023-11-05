/**
 * 
 */
package com.tekarch.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 */
public class FileUtils {

	public static String readPropertiesFile(String sFilePath, String key) throws IOException {

		File f = new File(sFilePath);
		FileInputStream fi = new FileInputStream(f);
		Properties pro = new Properties();
		pro.load(fi);

		return pro.getProperty(key);

	}

}
