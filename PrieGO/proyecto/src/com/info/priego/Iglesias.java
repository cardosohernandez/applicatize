package com.info.priego;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Iglesias extends ListActivity {
	private MyAdapter mAdapter = null;
	public class Node{
		public String mTitulo;
		public Integer mImageResource; 
		public String mDescripcion;
	}
	private static ArrayList<Node> mArray = new ArrayList<Node>();
	
	private void setData(){ 
		mArray.clear();
		//Iglesia_asuncion
		Node mynode0 = new Node();
		mynode0.mTitulo = this.getResources().getString(R.string.asuncion); 
		mynode0.mImageResource = R.drawable.asuncion; 
		mynode0.mDescripcion = this.getResources().getString(R.string.descr_asuncion); 
		mArray.add(mynode0);
		//Iglesia_Sanfrancisco
		Node mynode1 = new Node();
		mynode1.mTitulo = this.getResources().getString(R.string.francisco); 
		mynode1.mImageResource = R.drawable.sanfrancisco; 
		mynode1.mDescripcion = this.getResources().getString(R.string.descr_francisco); 
		mArray.add(mynode1);
		//Iglesia_carmen
		Node mynode2 = new Node();
		mynode2.mTitulo = this.getResources().getString(R.string.carmen); 
		mynode2.mImageResource = R.drawable.camen; 
		mynode2.mDescripcion = this.getResources().getString(R.string.descr_carmen); 
		mArray.add(mynode2);
		//Iglesia_mercedes
		Node mynode3 = new Node();
		mynode3.mTitulo = this.getResources().getString(R.string.mercedes); 
		mynode3.mImageResource = R.drawable.mercedes; 
		mynode3.mDescripcion = this.getResources().getString(R.string.descr_mercedes); 
		mArray.add(mynode3);
		//Iglesia_angustias
		Node mynode4 = new Node();
		mynode4.mTitulo = this.getResources().getString(R.string.angustias); 
		mynode4.mImageResource = R.drawable.angustias; 
		mynode4.mDescripcion = this.getResources().getString(R.string.descr_angustias); 
		mArray.add(mynode4);
		//Iglesia_calvario
		Node mynode5 = new Node();
		mynode5.mTitulo = this.getResources().getString(R.string.calvario); 
		mynode5.mImageResource = R.drawable.calvario; 
		mynode5.mDescripcion = this.getResources().getString(R.string.descr_calvario); 
		mArray.add(mynode5);
		//Iglesia_aurora
		Node mynode6 = new Node();
		mynode6.mTitulo = this.getResources().getString(R.string.aurora); 
		mynode6.mImageResource = R.drawable.aurora; 
		mynode6.mDescripcion = this.getResources().getString(R.string.descr_aurora); 
		mArray.add(mynode6);
		//Iglesia_sanjuan
		Node mynode7 = new Node();
		mynode7.mTitulo = this.getResources().getString(R.string.juan); 
		mynode7.mImageResource = R.drawable.sanjuan; 
		mynode7.mDescripcion = this.getResources().getString(R.string.descr_juan); 
		mArray.add(mynode7);
		//Iglesia_sanpedro
		Node mynode8 = new Node();
		mynode8.mTitulo = this.getResources().getString(R.string.sanPedro); 
		mynode8.mImageResource = R.drawable.sanpedro; 
		mynode8.mDescripcion = this.getResources().getString(R.string.descr_sanPedro); 
		mArray.add(mynode8);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setData();
		mAdapter = new MyAdapter (this); 
		setListAdapter (mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.que_ver, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) { 
		switch (item.getItemId()) {
			case R.id.menu_quever:
				startActivity(new Intent(this, QueVer.class));
				return true; 
			case R.id.menu_inicio:
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
	
	public static class MyAdapter extends BaseAdapter{ 
		private Context mContext;
		
		public MyAdapter (Context c){mContext = c;}
		
		public int getCount() {
			// TODO Auto-generated method stub
			return mArray.size(); 
		}
	
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mArray.get(position); 
		}
	
		public long getItemId(int position) {
			// TODO Auto-generated method stub 
			return 0;
		}
		
		public View getView(int position, View convertView, ViewGroup parent) { 
			// TODO Auto-generated method stub
			View view = null;
			if (convertView == null){
				LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.activity_iglesias, null);
			}else{
				view = convertView;
			}
			ImageView img = (ImageView) (ImageView) view.findViewById(R.id.img_iglesia);
			img.setImageDrawable (mContext.getResources().getDrawable(mArray.get(position).mImageResource));
			TextView tTitle = (TextView) view.findViewById(R.id.tituloIglesia); 
			tTitle.setText(mArray.get(position).mTitulo);
			TextView hTitle = (TextView) view.findViewById(R.id.descripcionIglesia); 
			hTitle.setText(mArray.get(position).mDescripcion);
			return view; 
		}
	}
}