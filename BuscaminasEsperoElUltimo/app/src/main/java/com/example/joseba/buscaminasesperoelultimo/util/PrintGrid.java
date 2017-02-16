package com.example.joseba.buscaminasesperoelultimo.util;

import android.util.Log;

/**
 * Created by Joseba on 16/02/2017.
 */

public class PrintGrid {

    public static void print(int [][] grid ,int width , final int height){
        for(int x = 0 ; x < width ; x++ ){
            String printedText = "| ";
            for( int y = 0 ; y < height ; y++ ){
                printedText += String.valueOf(grid[x][y]).replace("-1", "B") + " | ";
            }
            Log.e("",printedText);
        }
    }
}
