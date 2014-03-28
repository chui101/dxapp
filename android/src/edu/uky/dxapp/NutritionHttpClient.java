package edu.uky.dxapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class NutritionHttpClient {

	private static String BASE_URL = "https://api.nutritionix.com/v1_1/search/";
	private static String UPC_URL = "https://api.nutritionix.com/v1_1/item?upc=";
	private static String FIELDS_URL = "?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat";
	private static String ID_URL = "&appId=d65d2f8a&appKey=68e91698e581c62128795b7fac02ff54";

	
	public String getNInfoData(String key) throws UnsupportedEncodingException {
		HttpURLConnection con = null ;
		InputStream is = null;
		String query = URLEncoder.encode(key, "utf-8");

		try {
			con = (HttpURLConnection) ( new URL(BASE_URL + query + FIELDS_URL + ID_URL)).openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			
			// Let's read the response
			StringBuffer buffer = new StringBuffer();
			is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while (  (line = br.readLine()) != null )
				buffer.append(line + "\r\n");
			
			is.close();
			con.disconnect();
			return buffer.toString();
	    }
		catch(Throwable t) {
			t.printStackTrace();
		}
		finally {
			try { is.close(); } catch(Throwable t) {}
			try { con.disconnect(); } catch(Throwable t) {}
		}

		return null;
				
	}	
	
	public String getNInfoUPC(String key) throws UnsupportedEncodingException {
		HttpURLConnection con = null ;
		InputStream is = null;
		String query = URLEncoder.encode(key, "utf-8");

		try {
			con = (HttpURLConnection) ( new URL(UPC_URL + query + ID_URL)).openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();
			
			// Let's read the response
			StringBuffer buffer = new StringBuffer();
			is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while (  (line = br.readLine()) != null )
				buffer.append(line + "\r\n");
			
			is.close();
			con.disconnect();
			return buffer.toString();
	    }
		catch(Throwable t) {
			t.printStackTrace();
		}
		finally {
			try { is.close(); } catch(Throwable t) {}
			try { con.disconnect(); } catch(Throwable t) {}
		}

		return null;
				
	}
}