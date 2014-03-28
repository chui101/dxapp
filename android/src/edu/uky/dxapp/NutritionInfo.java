/*package edu.uky.dxapp;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;
import edu.uky.dxapp.NInfo;

public class NutritionInfo extends Activity {
	
	private TextView itemName;
	private TextView itemId;
	private TextView brandName;
	private TextView calories;
	private TextView totalFat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nutrition_info);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new Fragment()).commit();
		}
		
		String search = "cheddar cheese";
		
		itemName = (TextView) findViewById(R.id.itemName);
		itemId = (TextView) findViewById(R.id.itemId);
		brandName = (TextView) findViewById(R.id.brandName);
		calories = (TextView) findViewById(R.id.calories);
		totalFat = (TextView) findViewById(R.id.totalFat);
		
		JSONNInfoTask task = new JSONNInfoTask();
		task.execute(new String[]{search});
	}
	
private class JSONNInfoTask extends AsyncTask<String, Void, NInfo> {
		
		@Override
		protected NInfo doInBackground(String... params) {
			NInfo ninfo = new NInfo();

			try {
				String data = ( (new NutritionHttpClient()).getNInfoData(params[0]));
				ninfo = JSONNInfoParser.getNInfo(data);				
			} catch (JSONException e) {				
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ninfo;
		
	}
		
		
		
		
	@Override
		protected void onPostExecute(NInfo ninfo) {			
			super.onPostExecute(ninfo);
			
			itemName.setText(ninfo.getItemName());
			itemId.setText(ninfo.getItemId());
			brandName.setText(ninfo.getBrandName());
			calories.setText(ninfo.getNf_calories());
			totalFat.setText(ninfo.getNf_total_fat());
				
		}


	}
}
*/