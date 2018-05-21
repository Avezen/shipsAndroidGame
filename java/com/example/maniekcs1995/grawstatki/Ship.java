package com.example.maniekcs1995.grawstatki;

import java.io.Serializable;

public class Ship implements Serializable{

    int x, y, x2, y2;

    public Ship (int x, int y) {
        this.x = x;
        this.y = y;

    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
