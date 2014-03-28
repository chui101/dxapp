package edu.uky.dxapp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONNInfoParser {

	public static NInfo getNInfo(String data) throws JSONException  {
		NInfo ninfo = new NInfo();
		List<JSONObject> allHits = new ArrayList<JSONObject>();

		// We create out JSONObject from the data
		JSONObject jObj = new JSONObject(data);
		
		JSONArray hit = jObj.getJSONArray("hits");
		for (int i=0; i< hit.length(); i++) {
		    JSONObject food = hit.getJSONObject(i);
		    JSONObject fields = food.getJSONObject("fields");
		    ninfo.setItemName(getString("item_name", fields));
		    ninfo.setBrandName(getString("brand_name", fields));
		    ninfo.setNf_calories(getInt("nf_calories", fields));
		    ninfo.setNf_total_fat(getInt("nf_total_fat", fields));
		    allHits.add(food);
		}

		
		return ninfo;
	}
	
	public static NInfo getNInfoUPC(String data) throws JSONException  {
		NInfo ninfo = new NInfo();

		// We create out JSONObject from the data
		JSONObject jObj = new JSONObject(data);
		
	    ninfo.setItemName(getString("item_name", jObj));
	    ninfo.setBrandName(getString("brand_name", jObj));
	    ninfo.setNf_calories(getInt("nf_calories", jObj));
	    ninfo.setNf_total_fat(getInt("nf_total_fat", jObj));
		return ninfo;
	}
	
	private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
		JSONObject subObj = jObj.getJSONObject(tagName);
		return subObj;
	}
	
	private static String getString(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getString(tagName);
	}

	private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
		return (float) jObj.getDouble(tagName);
	}
	
	private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
		return jObj.getInt(tagName);
	}
	
}