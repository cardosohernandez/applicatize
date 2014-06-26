package com.example.caseriodeiznajar;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.os.Build;

public class Principal extends Activity
{
    private WebView browser;
 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
 
        browser = (WebView)findViewById(R.id.webkit);
 
                //habilitamos javascript y el zoom
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setBuiltInZoomControls(true);
 
        //habilitamos los plugins (flash)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO)
        {
            browser.getSettings().setPluginState(PluginState.ON);
        }
        else
        {
            //IMPORTANTE!! este método ha sido eliminado en Android 4.3 
                        //por lo que si lo necesitamos para mantener la compatibilidad 
                        //hacia atrás hay que compilar el proyecto con Android 4.2 como máximo
            browser.getSettings().setPluginsEnabled(true);
        }
         
 
        browser.loadUrl("http://www.pcclass.es/caserio/app");
    }
}