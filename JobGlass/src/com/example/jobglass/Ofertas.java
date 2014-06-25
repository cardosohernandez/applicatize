package com.example.jobglass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ofertas extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ofertas);
		
		
		
		//Relacionamos el boton del layout con botón java.
      //  Button boton = (Button)findViewById(R.id.button1);
        //Lo ponemos a escuchar para cuando sea pulsado
      //  boton.setOnClickListener(im.sendEmail(mailer, Address));  
		
		
	}
	
	public void send_Mail(View view){
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
				new String[] { "destinatario@mail.com" });
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
		startActivity(Intent.createChooser(emailIntent, "Enviar mail"));
	}

	

}
