package com.info.priego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DondeComer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dondecomer);
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
				finish();
				startActivity(new Intent(this, MainActivity.class));
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
	
	public void ir_restaurantes(View view) {
		startActivity(new Intent(this, Restaurantes.class));
	}
	
	public void ir_cafeterias(View view) {
		startActivity(new Intent(this, Cafeterias.class));
	}
	
	public void ir_pubs(View view) {
		startActivity(new Intent(this, Pubs.class));
	}
	
	public void ir_atras(View view) {
		finish();  
		startActivity(new Intent(this, MainActivity.class));
	}
	
}