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

public class Cafeterias extends ListActivity {
	private MyAdapter mAdapter = null;
	public class Node{
		public String mTitulo;
		public Integer mImageResource; 
		public String mDescripcion;
	}
	private static ArrayList<Node> mArray = new ArrayList<Node>();
		
	private void setData(){ 
		mArray.clear();
		//miguelin
		Node mynode0 = new Node();
		mynode0.mTitulo = this.getResources().getString(R.string.miguelin); 
		mynode0.mImageResource = R.drawable.miguelin; 
		mynode0.mDescripcion = this.getResources().getString(R.string.descr_miguelin); 
		mArray.add(mynode0);
		//gabanna
		Node mynode1 = new Node();
		mynode1.mTitulo = this.getResources().getString(R.string.gabana); 
		mynode1.mImageResource = R.drawable.gabana; 
		mynode1.mDescripcion = this.getResources().getString(R.string.descr_gabana); 
		mArray.add(mynode1);
		//postigo
		Node mynode2 = new Node();
		mynode2.mTitulo = this.getResources().getString(R.string.postigo); 
		mynode2.mImageResource = R.drawable.elpostigo; 
		mynode2.mDescripcion = this.getResources().getString(R.string.descr_postigo); 
		mArray.add(mynode2);
		//paris
		Node mynode3 = new Node();
		mynode3.mTitulo = this.getResources().getString(R.string.paris); 
		mynode3.mImageResource = R.drawable.paris; 
		mynode3.mDescripcion = this.getResources().getString(R.string.descr_paris); 
		mArray.add(mynode3);
		//mana
		Node mynode4 = new Node();
		mynode4.mTitulo = this.getResources().getString(R.string.mana); 
		mynode4.mImageResource = R.drawable.mana; 
		mynode4.mDescripcion = this.getResources().getString(R.string.descr_mana); 
		mArray.add(mynode4);
		//ibiza
		Node mynode5 = new Node();
		mynode5.mTitulo = this.getResources().getString(R.string.ibiza); 
		mynode5.mImageResource = R.drawable.ibiza; 
		mynode5.mDescripcion = this.getResources().getString(R.string.descr_ibiza); 
		mArray.add(mynode5);
		//dulces
		Node mynode6 = new Node();
		mynode6.mTitulo = this.getResources().getString(R.string.dulces); 
		mynode6.mImageResource = R.drawable.dulces; 
		mynode6.mDescripcion = this.getResources().getString(R.string.descr_dulces); 
		mArray.add(mynode6);		
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
		getMenuInflater().inflate(R.menu.donde_comer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) { 
		switch (item.getItemId()) {
			case R.id.menu_dondecomer:
				startActivity(new Intent(this, DondeComer.class));
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
				view = inflater.inflate(R.layout.activity_cafeterias, null);
			}else{
				view = convertView;
			}
			ImageView img = (ImageView) (ImageView) view.findViewById(R.id.img_cafeteria);
			img.setImageDrawable (mContext.getResources().getDrawable(mArray.get(position).mImageResource));
			TextView tTitle = (TextView) view.findViewById(R.id.tituloCafeteria); 
			tTitle.setText(mArray.get(position).mTitulo);
			TextView hTitle = (TextView) view.findViewById(R.id.descripcionCafeteria); 
			hTitle.setText(mArray.get(position).mDescripcion);
			return view; 
		}
	}
}