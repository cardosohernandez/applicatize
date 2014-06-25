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

public class Pubs extends ListActivity {
	private MyAdapter mAdapter = null;
	public class Node{
		public String mTitulo;
		public Integer mImageResource; 
		public String mDescripcion;
	}
	private static ArrayList<Node> mArray = new ArrayList<Node>();
		
	private void setData(){ 
		mArray.clear();
		//charlot
		Node mynode0 = new Node();
		mynode0.mTitulo = this.getResources().getString(R.string.charlot); 
		mynode0.mImageResource = R.drawable.charlot; 
		mynode0.mDescripcion = this.getResources().getString(R.string.descr_charlot); 
		mArray.add(mynode0);
		//impacto
		Node mynode1 = new Node();
		mynode1.mTitulo = this.getResources().getString(R.string.impacto); 
		mynode1.mImageResource = R.drawable.impacto; 
		mynode1.mDescripcion = this.getResources().getString(R.string.descr_impacto); 
		mArray.add(mynode1);
		//botica
		Node mynode2 = new Node();
		mynode2.mTitulo = this.getResources().getString(R.string.botica); 
		mynode2.mImageResource = R.drawable.labotica; 
		mynode2.mDescripcion = this.getResources().getString(R.string.descr_botica); 
		mArray.add(mynode2);
		//moma
		Node mynode3 = new Node();
		mynode3.mTitulo = this.getResources().getString(R.string.moma); 
		mynode3.mImageResource = R.drawable.moma; 
		mynode3.mDescripcion = this.getResources().getString(R.string.descr_moma); 
		mArray.add(mynode3);
		//holliwood
		Node mynode4 = new Node();
		mynode4.mTitulo = this.getResources().getString(R.string.holliwood); 
		mynode4.mImageResource = R.drawable.holliwood; 
		mynode4.mDescripcion = this.getResources().getString(R.string.descr_holliwood); 
		mArray.add(mynode4);
		//vanvas
		Node mynode5 = new Node();
		mynode5.mTitulo = this.getResources().getString(R.string.vanvas); 
		mynode5.mImageResource = R.drawable.vanvas; 
		mynode5.mDescripcion = this.getResources().getString(R.string.descr_vanvas); 
		mArray.add(mynode5);		
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
				view = inflater.inflate(R.layout.activity_pubs, null);
			}else{
				view = convertView;
			}
			ImageView img = (ImageView) (ImageView) view.findViewById(R.id.img_pubs);
			img.setImageDrawable (mContext.getResources().getDrawable(mArray.get(position).mImageResource));
			TextView tTitle = (TextView) view.findViewById(R.id.tituloPubs); 
			tTitle.setText(mArray.get(position).mTitulo);
			TextView hTitle = (TextView) view.findViewById(R.id.descripcionPubs); 
			hTitle.setText(mArray.get(position).mDescripcion);
			return view; 
		}
	}
}