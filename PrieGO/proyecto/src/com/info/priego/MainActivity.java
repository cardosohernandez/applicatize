package com.info.priego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) { 
		switch (item.getItemId()) {
			case R.id.menu_inicio:
				Toast.makeText(MainActivity.this,"Pantalla actual" ,Toast.LENGTH_LONG) .show();
				return true; 
			case R.id.menu_sobre:
				finish();
				//startActivity(new Intent(this, Informacion.class));
				return true;
			case R.id.menu_salir:
				finish(); 
				return true;
			default:
				return super.onOptionsItemSelected(item);
		} 
	}
	
	public void ir_quever(View view) {
		finish();
		startActivity(new Intent(this, QueVer.class));
	}
	
	public void ir_servicios(View view) {
		finish();
		startActivity(new Intent(this, DondeComer.class));
	}
	
	public void ir_dondecomer(View view) {
		finish();
		startActivity(new Intent(this, DondeComer.class));
	}
	
	public void ir_salir(View view) {
		finish();  
	}
	
}