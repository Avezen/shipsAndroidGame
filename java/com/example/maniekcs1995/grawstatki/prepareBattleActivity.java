package com.example.maniekcs1995.grawstatki;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class prepareBattleActivity extends AppCompatActivity {

    public static ArrayList<Ship> ships1 = new ArrayList<Ship>();

    int[] x1 = new int[3];
    int[] y1 = new int[3];
    int[] x2 = new int[2];
    int[] y2 = new int[2];
    String[] turn2 = new String[2];
    int[] x3, y3 = new int[1];
    String[] turn3 = new String[3];

    Button  button00, button10, button20, button30, button40,
            button01, button11, button21, button31, button41,
            button02, button12, button22, button32, button42,
            button03, button13, button23, button33, button43,
            button04, button14, button24, button34, button44,
            readyButton;

    List<Boolean> blist=new ArrayList<Boolean>(25);




    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prepare_battle_layout);

        for(int i=0; i<25; i++){
            blist.add(i, false);
        }

        readyButton = findViewById(R.id.buttonReady);

        button00 = findViewById(R.id.button00); button10 = findViewById(R.id.button10); button20 = findViewById(R.id.button20); button30 = findViewById(R.id.button30); button40 = findViewById(R.id.button40);
        button01 = findViewById(R.id.button01); button11 = findViewById(R.id.button11); button21 = findViewById(R.id.button21); button31 = findViewById(R.id.button31); button41 = findViewById(R.id.button41);
        button02 = findViewById(R.id.button02); button12 = findViewById(R.id.button12); button22 = findViewById(R.id.button22); button32 = findViewById(R.id.button32); button42 = findViewById(R.id.button42);
        button03 = findViewById(R.id.button03); button13 = findViewById(R.id.button13); button23 = findViewById(R.id.button23); button33 = findViewById(R.id.button33); button43 = findViewById(R.id.button43);
        button04 = findViewById(R.id.button04); button14 = findViewById(R.id.button14); button24 = findViewById(R.id.button24); button34 = findViewById(R.id.button34); button44 = findViewById(R.id.button44);

        button00.setId(100); button10.setId(110); button20.setId(120); button30.setId(130); button40.setId(140);
        button01.setId(101); button11.setId(111); button21.setId(121); button31.setId(131); button41.setId(141);
        button02.setId(102); button12.setId(112); button22.setId(122); button32.setId(132); button42.setId(142);
        button03.setId(103); button13.setId(113); button23.setId(123); button33.setId(133); button43.setId(143);
        button04.setId(104); button14.setId(114); button24.setId(124); button34.setId(134); button44.setId(144);


        x1[0]=500;
        y1[0]=500;


        readyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(prepareBattleActivity.this, battleActivity.class);
                startActivity(intent);
            }
        });

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(0)) {
                        button00.setBackgroundColor(Color.YELLOW);
                        blist.set(0, true);
                        x1[0] = (button00.getId() / 10) % 10;
                        y1[0] = button00.getId() % 10;
                        lightButtons(x2[0], y2[0], 2);
                    } else {
                        button00.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(0, false);
                        dimButtons(x2[0], y2[0], 2);
                    }
                }else{
                    if(blist.get(0)){
                        x2[0] = (button00.getId() / 10) % 10;
                        y2[0] = button00.getId() % 10;

                        ships1.add(0,new Ship(x1[0], y1[0], x2[0], y2[0]));
                    }
                }
            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(0)) {
                        button01.setBackgroundColor(Color.YELLOW);
                        blist.set(0, true);
                        x1[0] = (button01.getId() / 10) % 10;
                        y1[0] = button01.getId() % 10;
                        lightButtons(x2[0], y2[0], 2);
                    } else {
                        button01.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(0, false);
                        dimButtons(x2[0], y2[0], 2);
                    }
                }else{
                    if(blist.get(0)){
                        x2[0] = (button01.getId() / 10) % 10;
                        y2[0] = button01.getId() % 10;

                        ships1.add(0,new Ship(x1[0], y1[0], x2[0], y2[0]));
                    }
                }
            }
        });


    }


    public void placeShip(int x, int y, int x2, int y2){
        int id1 = 100 + x*10 + y;
        int id2 = 100 + x2*10 + y2;
    }


    public void dimButtons(int x, int y, int length){
        int id = 100 + x*10 + y;

        switch(id){
            case 100:
                if(length == 2){
                    button01.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                    blist.set(1, false);
                    button10.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                    blist.set(5, false);
                }
                break;
        }
    }


    public void lightButtons(int x, int y, int length){
        int id = 100 + x*10 + y;

        switch(id){
            case 100:
                if(length == 2){
                    button01.setBackgroundColor(Color.YELLOW);
                    blist.set(1, true);
                    button10.setBackgroundColor(Color.YELLOW);
                    blist.set(5, true);
                }
                break;
        }
    }
}
