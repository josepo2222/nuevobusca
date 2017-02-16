package com.example.joseba.buscaminasesperoelultimo.grid;

import android.content.Context;
import android.view.View;

import com.example.joseba.buscaminasesperoelultimo.Juego;

/**
 * Created by Joseba on 16/02/2017.
 */

public abstract class BaseCelda extends View{

    private int value;
    private boolean isBomba;
    private boolean isRevelada;
    private boolean isClicked;
    private boolean isMarcada;

    private int x ,y;
    private int position;

    public BaseCelda(Context context ){super(context);}

    public int getValue(){return value;}

    public void setValue(int value) {
        isBomba=false;
        isRevelada=false;
        isClicked=false;
        isMarcada=false;

        if( value ==-1){
            isBomba = true;
        }

        this.value = value;
    }

    public boolean isBomba() { return isBomba; }

    public void setBomba(boolean bomba) { isBomba = bomba;}

    public boolean isRevelada(){
        return isRevelada;
    }

    public void setRevelada(){
        isRevelada=true;
        invalidate();
    }

    public boolean isClicked(){return isClicked;}

    public void setClicked() {
        this.isClicked = true;
        this.isRevelada = true;

        invalidate();
    }

    public boolean isMarcada(){
        return isMarcada;
    }

    public void setMarcada(boolean marcada) {isMarcada = marcada;}

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    public int getPosition() {return position;}

    public void setPosition( int x , int y ){
        this.x = x;
        this.y = y;

        this.position = y * Juego.width + x;

        invalidate();
    }


}
