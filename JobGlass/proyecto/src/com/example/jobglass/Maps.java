package com.example.jobglass;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

public class Maps extends ActionBarActivity {
	GoogleMap googleMap;
	float[] results = new float[10];
	//double endLongitude = -3.599239776057402;
	//double endLatitude = 37.16821984385613;
	double endLongitude = -3.6242514000000483; //Facultad
	double endLatitude = 37.1970143;			//Facultad
	LatLng myPosition;
	Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maps);
		// if Google Play Services are available then

		// Getting reference to the SupportMapFragment of maps.xml
		SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);

		// Getting GoogleMap object from the fragment
		googleMap = fm.getMap();

		// Enabling MyLocation Layer of Google Map
		googleMap.setMyLocationEnabled(true);

		// Getting LocationManager object from System Service LOCATION_SERVICE
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		// Creating a criteria object to retrieve provider
		Criteria criteria = new Criteria();

		// Getting the name of the best provider
		String provider = locationManager.getBestProvider(criteria, true);

		// Getting Current Location
		Location location = locationManager.getLastKnownLocation(provider);

		if (location != null) {
			// Getting latitude of the current location
			double latitude = location.getLatitude();

			// Getting longitude of the current location
			double longitude = location.getLongitude();

			// Creating a LatLng object for the current location
			LatLng latLng = new LatLng(latitude, longitude);
			LatLng endLatLng = new LatLng(endLatitude, endLongitude);

			myPosition = new LatLng(latitude, longitude);

			googleMap.addMarker(new MarkerOptions().position(endLatLng).title(
					"Start"));

			
			Location.distanceBetween(latitude, longitude, endLatitude,
					endLongitude, results);
			float distance = results[0];

			//If we aproach 100 metres or more to the bussiness offer, the alarm turns on
			if (distance <= 100) {
				NotificationCompat.Builder mBuilder =
					    new NotificationCompat.Builder(this)
					    .setSmallIcon(R.drawable.iconoapp)
					    .setContentTitle("¡Alerta de trabajo!")
					    .setContentText("Oferta de trabajo cercana: Edodoncista en DENTIX")
						.setSound(soundUri)
						.setAutoCancel(true);
				
				
				Intent resultIntent = new Intent(this, Test.class);
				
				// Because clicking the notification opens a new ("special") activity, there's
				// no need to create an artificial back stack.
				PendingIntent resultPendingIntent =
				    PendingIntent.getActivity(
				    this,
				    0,
				    resultIntent,
				    PendingIntent.FLAG_UPDATE_CURRENT
				);
				
				//Setting click notification behaviour
				mBuilder.setContentIntent(resultPendingIntent);

				
				
				// Sets an ID for the notification
				int mNotificationId = 001;
				// Gets an instance of the NotificationManager service
				NotificationManager mNotifyMgr = 
				        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				// Builds the notification and issues it.
				mNotifyMgr.notify(mNotificationId, mBuilder.build());
				
				
				
				 Toast.makeText(getApplicationContext(),
				 "Oferta de trabajo cercana", Toast.LENGTH_LONG).show();
				 
			}

		}

	}

	
}
