package edu.uky.nutritionexchanges;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.os.Build;
import com.google.zxing.integration.android.*;


public class SearchActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		/*if (id == R.id.action_settings) {
			return true;
		}*/
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements OnClickListener {
		
		private View rootView;
		private ImageButton scanBtn;
		private EditText searchTxt;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			rootView = inflater.inflate(R.layout.fragment_search,
					container, false);
			// listener for barcode scan button
			scanBtn = (ImageButton)rootView.findViewById(R.id.scan_button);
			scanBtn.setOnClickListener(this);
			// TODO: listener for text box
			searchTxt = (EditText)rootView.findViewById(R.id.search_text);
			return rootView;
		}
		@Override
		public void onClick(View view) {
			int id = view.getId();
			if (id == R.id.scan_button) {
				// scan barcode
				IntentIntegrator scanIntegrator = new IntentIntegratorSupportV4(this);
				scanIntegrator.initiateScan();
			}
		}
		
		/* 
		 * when the barcode scanner returns it calls back here
		 */
		public void onActivityResult(int requestCode, int resultCode, Intent intent) {
			// retrieve scan result
			IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
			if (scanningResult == null) { 
				Toast.makeText(getActivity(), "No barcode found!", Toast.LENGTH_SHORT).show();
				return; 
			}
			String scanContent = scanningResult.getContents();
			searchTxt.setText(scanContent);
			
		}
	}




}
