package com.example.joseba.buscaminasesperoelultimo;

/**
 * Created by Joseba on 14/02/2017.
 */
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.joseba.buscaminasesperoelultimo.util.Generador;
import com.example.joseba.buscaminasesperoelultimo.util.PrintGrid;
import com.example.joseba.buscaminasesperoelultimo.grid.Celda;

public class Juego {
    private static  Juego instance;
    private Context context;



    static public int numeroBombas = 10;
    static public int width = 8;
    static public int height = 8;

    private Celda[][]MinasGrid = new Celda[width][height];

    public static Juego getInstance() {

        if (instance == null){
            instance = new Juego();
        }


        return instance;
    }
    public Juego(){}

    public void crearGrid(Context context){
        Log.e("Juego","createGrid funciona");
        this.context = context;

        //crea el grid y lo almacena
        int[][] GenerateGrid = Generador.generate(numeroBombas,width,height);
        PrintGrid.print(GenerateGrid,width,height);
        setGrid(context,GenerateGrid);



    }
    public void setGrid(final Context context, int [][] grid){
        for(int x = 0 ; x < width ; x++){
            for( int y = 0 ; y < height ; y++){
                if (MinasGrid[x][y] == null ){
                    MinasGrid[x][y] = new Celda( width,context , x,y);
                }
                MinasGrid[x][y].setValue(grid[x][y]);
                MinasGrid[x][y].invalidate();
            }
        }
    }

    public Celda getCeldaEn(int posicion){
        int x = posicion % width;
        int y = posicion / width;

        return MinasGrid[x][y];
    }

    public Celda getCeldaEn(int x,int y){
        return MinasGrid[x][y];
    }

    public void click(int x , int y){
        if( x >= 0 && y >= 0 && x < width && y < height && !getCeldaEn(x,y).isClicked()){
            getCeldaEn(x,y).setClicked();

            if(getCeldaEn(x,y).getValue() == 0 ){
                for( int xt=-1;xt<=1;xt++){
                    for( int yt = -1 ; yt <= 1 ; yt++){
                        if(xt != yt){
                            click(x + xt ,y + yt);
                        }
                    }
                }
            }

            if (getCeldaEn(x,y).isBomba()){
                partidaPerdida();
            }
        }

        checkEnd();
    }

    private boolean checkEnd(){
        int bombaNoEncontrada =numeroBombas;
        int noReveladas = width*height;
        for (int x=0;x<width;x++){
            for (int y=0;y<height;y++){
                if(getCeldaEn(x,y).isRevelada()|| getCeldaEn(x,y).isMarcada()){
                    noReveladas--;
                }
                if (getCeldaEn(x,y).isMarcada() && getCeldaEn(x,y).isBomba()){
                    bombaNoEncontrada--;
                }
            }
        }
        if(bombaNoEncontrada == 0 && noReveladas == 0 ){
            Toast.makeText(context, "Juego Ganado", Toast.LENGTH_SHORT).show();
        }
        return false;

    }

    public void marcada(int x , int y){
        boolean isMarcada = getCeldaEn(x,y).isMarcada();
        getCeldaEn(x,y).setMarcada(!isMarcada);
        getCeldaEn(x,y).invalidate();
    }

    private void partidaPerdida(){
        Toast.makeText(context,"Partida Perdida", Toast.LENGTH_SHORT).show();

        for(int x = 0 ; x < width ; x++){
            for (int y = 0; y <height;y++){
                getCeldaEn(x,y).setRevelada();
            }
        }

    }



}
