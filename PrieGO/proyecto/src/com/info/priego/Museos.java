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

	public class Museos extends ListActivity {
		private MyAdapter mAdapter = null;
		public class Node{
			public String mTitulo;
			public Integer mImageResource; 
			public String mDescripcion;
		}
		private static ArrayList<Node> mArray = new ArrayList<Node>();
		
		private void setData(){ 
			mArray.clear();
			//Museo_niceto
			Node mynode0 = new Node();
			mynode0.mTitulo = this.getResources().getString(R.string.niceto); 
			mynode0.mImageResource = R.drawable.niceto; 
			mynode0.mDescripcion = this.getResources().getString(R.string.descr_niceto); 
			mArray.add(mynode0);
			//Museo_historio
			Node mynode1 = new Node();
			mynode1.mTitulo = this.getResources().getString(R.string.historico); 
			mynode1.mImageResource = R.drawable.sanfrancisco; 
			mynode1.mDescripcion = this.getResources().getString(R.string.descr_historico); 
			mArray.add(mynode1);
			//Museo_lozano
			Node mynode2 = new Node();
			mynode2.mTitulo = this.getResources().getString(R.string.lozano); 
			mynode2.mImageResource = R.drawable.lozano; 
			mynode2.mDescripcion = this.getResources().getString(R.string.descr_lozano); 
			mArray.add(mynode2);
			//Museo_micologico
			Node mynode3 = new Node();
			mynode3.mTitulo = this.getResources().getString(R.string.micologico); 
			mynode3.mImageResource = R.drawable.micologico; 
			mynode3.mDescripcion = this.getResources().getString(R.string.descr_micologico); 
			mArray.add(mynode3);
			//Museo_almendra
			Node mynode4 = new Node();
			mynode4.mTitulo = this.getResources().getString(R.string.almendra); 
			mynode4.mImageResource = R.drawable.almendra; 
			mynode4.mDescripcion = this.getResources().getString(R.string.descr_almendra); 
			mArray.add(mynode4);
			//Museo_castil
			Node mynode5 = new Node();
			mynode5.mTitulo = this.getResources().getString(R.string.castil); 
			mynode5.mImageResource = R.drawable.castil; 
			mynode5.mDescripcion = this.getResources().getString(R.string.descr_castil); 
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
					view = inflater.inflate(R.layout.activity_museos, null);
				}else{
					view = convertView;
				}
				ImageView img = (ImageView) (ImageView) view.findViewById(R.id.img_museo);
				img.setImageDrawable (mContext.getResources().getDrawable(mArray.get(position).mImageResource));
				TextView tTitle = (TextView) view.findViewById(R.id.tituloMuseo); 
				tTitle.setText(mArray.get(position).mTitulo);
				TextView hTitle = (TextView) view.findViewById(R.id.descripcionMuseo); 
				hTitle.setText(mArray.get(position).mDescripcion);
				return view; 
			}
		}
	}