package com.example.joseba.buscaminasesperoelultimo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.ActionMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.example.joseba.buscaminasesperoelultimo.util.DialogoAlerta;
import android.app.DialogFragment;

public class MainActivity extends AppCompatActivity {
    MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        menuItem=(MenuItem)findViewById(R.id.instrucciones);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //((TextView)findViewById(R.id.TextView)).setText("algo");
        Log.e("MainActivity","onCreate");
        Juego.getInstance().crearGrid(this);


      /*  menuItem.setOnMenuItemClickListener(new View.OnClickListener(){


                public void onClick(View v) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    DialogoAlerta dialogo = new DialogoAlerta();
                    dialogo.show(fragmentManager, "tagInstrucciones");
                }

        } );*/



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.principiante:
                break;
            case R.id.amateur:
                break;
            case R.id.avanzado:
                break;
            case R.id.action_settings:
                break;
            case R.id.instrucciones:


                break;
        }
        return super.onOptionsItemSelected(item);
    }




}
