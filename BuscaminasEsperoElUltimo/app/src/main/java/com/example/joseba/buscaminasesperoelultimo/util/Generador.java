package com.example.joseba.buscaminasesperoelultimo.util;

import java.util.Random;

/**
 * Created by Joseba on 16/02/2017.
 */

public class Generador {

    public static int[][] generate(int numerobombas, final int width, final int height) {
        //Numeros random
        Random r = new Random();

        int[][] grid = new int[width][height];
        for (int x = 0; x < width; x++) {
            grid[x] = new int[height];
        }

        while (numerobombas > 0) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            //-1 es la bomba
            if (grid[x][y] != -1) {
                grid[x][y] = -1;
                numerobombas--;
            }
        }
            grid = calcularvecino(grid,width,height);

            return grid;
    }

    private static int[][] calcularvecino ( int[][] grid , final int width , final int height){
            for (int x = 0 ; x < width ; x++) {
                for (int y = 0 ; y < height ; y++) {
                    grid[x][y] = getNumeroVecino(grid, x, y, width, height);
                }
            }
            return grid;
    }


    private static int getNumeroVecino(final int grid[][], final int x, final int y, final int width, final int height){
        if(grid[x][y]==-1)

        {


            return -1;
        }

        int cuenta = 0;

        if( estaLaMina(grid,x - 1 ,y + 1,width,height)) cuenta++; // arriba-izquierda
        if( estaLaMina(grid,x     ,y + 1,width,height)) cuenta++; // arriba
        if( estaLaMina(grid,x + 1 ,y + 1,width,height)) cuenta++; // arriba-derecha
        if( estaLaMina(grid,x - 1 ,y    ,width,height)) cuenta++; // izquierda
        if( estaLaMina(grid,x + 1 ,y    ,width,height)) cuenta++; // derecha
        if( estaLaMina(grid,x - 1 ,y - 1,width,height)) cuenta++; // abajo-izquierda
        if( estaLaMina(grid,x     ,y - 1,width,height)) cuenta++; // abajo
        if( estaLaMina(grid,x + 1 ,y - 1,width,height)) cuenta++; // abajo-derecha

        return cuenta;



    }

    private static boolean estaLaMina(int [][] grid,int x ,int y ,int widith ,int height){
        if( x >= 0 && y >=0 && x < widith && y < height){
            if( grid[x][y] == -1){
                return true;
            }
        }
        return false;
    }



}


