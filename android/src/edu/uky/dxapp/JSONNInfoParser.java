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
		/*
		JSONObject hitsObj = getObject("hits", jObj);
		loc.setLatitude(getFloat("lat", hitsObj));
		loc.setLongitude(getFloat("lon", hitsObj));
		
		JSONObject sysObj = getObject("sys", jObj);
		loc.setCountry(getString("country", sysObj));
		loc.setSunrise(getInt("sunrise", sysObj));
		loc.setSunset(getInt("sunset", sysObj));
		loc.setCity(getString("name", jObj));
		weather.location = loc;
		
		// We get weather info (This is an array)
		JSONArray jArr = jObj.getJSONArray("weather");
		
		// We use only the first value
		JSONObject JSONWeather = jArr.getJSONObject(0);
		weather.currentCondition.setWeatherId(getInt("id", JSONWeather));
		weather.currentCondition.setDescr(getString("description", JSONWeather));
		weather.currentCondition.setCondition(getString("main", JSONWeather));
		weather.currentCondition.setIcon(getString("icon", JSONWeather));
		
		JSONObject mainObj = getObject("main", jObj);
		weather.currentCondition.setHumidity(getInt("humidity", mainObj));
		weather.currentCondition.setPressure(getInt("pressure", mainObj));
		weather.temperature.setMaxTemp(getFloat("temp_max", mainObj));
		weather.temperature.setMinTemp(getFloat("temp_min", mainObj));
		weather.temperature.setTemp(getFloat("temp", mainObj));
		
		// Wind
		JSONObject wObj = getObject("wind", jObj);
		weather.wind.setSpeed(getFloat("speed", wObj));
		weather.wind.setDeg(getFloat("deg", wObj));
		
		// Clouds
		JSONObject cObj = getObject("clouds", jObj);
		weather.clouds.setPerc(getInt("all", cObj));
		
		// We download the icon to show
		*/
		
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