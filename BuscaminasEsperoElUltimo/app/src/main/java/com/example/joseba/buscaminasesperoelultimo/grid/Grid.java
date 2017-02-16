package com.example.joseba.buscaminasesperoelultimo.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.joseba.buscaminasesperoelultimo.Juego;

/**
 * Created by Joseba on 16/02/2017.
 */

public class Grid extends GridView {

    public Grid(Context context , AttributeSet attrs){
        super(context,attrs);

        Juego.getInstance().crearGrid(context);

        setNumColumns(Juego.width);
        setAdapter(new GridAdapter());
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Juego.getInstance().width * Juego.getInstance().height;
        }

        @Override
        public Object getItem(int posicion) {
            return null;
        }

        @Override
        public long getItemId(int posicion) {
            return 0;
        }

        @Override
        public View getView(int posicion, View convertView, ViewGroup parent) {
            return Juego.getInstance().getCeldaEn(posicion);
        }
    }




}
