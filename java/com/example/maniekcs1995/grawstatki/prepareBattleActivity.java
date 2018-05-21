package com.example.maniekcs1995.grawstatki;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class prepareBattleActivity extends AppCompatActivity {

    public static ArrayList<Ship> ships1 = new ArrayList<Ship>();

    int[] x1 = new int[3];
    int[] y1 = new int[3];
    int startButtonId, endButtonId;
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
            readyButton, buttonShip1, buttonShip2, buttonShip3;

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
        buttonShip1 = findViewById(R.id.buttonShip1);
        buttonShip2 = findViewById(R.id.buttonShip2);
        buttonShip3 = findViewById(R.id.buttonShip3);

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



        //+++++++++++++++++++++++++ WIERSZ PIERWSZY ++++++++++++++++++++++++++++++++++

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(0)) {
                        button00.setBackgroundColor(Color.YELLOW);
                        x1[0] = (button00.getId() / 10) % 10;
                        y1[0] = button00.getId() % 10;
                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                        }
                    }
                } else {
                    if (blist.get(0)) {
                        x2[0] = (button00.getId() / 10) % 10;
                        y2[0] = button00.getId() % 10;

                        ships1.add(0, new Ship(x1[0], y1[0]);
                        if (buttonShip3.getText().toString().equals("1")) {
                            ships1.add(0, new Ship(x1[0], y1[0]);
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            buttonShip3.setText("0");
                        }

                    }
                }
            }

        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(1)) {
                        button01.setBackgroundColor(Color.YELLOW);
                        x1[0] = (button01.getId() / 10) % 10;
                        y1[0] = button01.getId() % 10;
                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x2[0], y2[0], 3);
                        }
                    }
                } else {
                    if (blist.get(1)) {
                        x2[0] = (button01.getId() / 10) % 10;
                        y2[0] = button01.getId() % 10;

                        ships1.add(new Ship(x1[0], y1[0]));
                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            buttonShip3.setText("0");
                        }

                    }
                }
            }
        });


        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(2)) {
                        button02.setBackgroundColor(Color.YELLOW);
                        x1[0] = (button02.getId() / 10) % 10;
                        y1[0] = button02.getId() % 10;
                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                        }
                    }
                } else {
                    if (blist.get(2)) {
                        x2[0] = (button02.getId() / 10) % 10;
                        y2[0] = button02.getId() % 10;

                        ships1.add(new Ship(x1[0], y1[0]));
                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            buttonShip3.setText("0");
                        }

                    }
                }
            }

        });


        //++++++++++++++++++++++++ WIERSZ DRUGI +++++++++++++++++++++++++++++++

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {
                    Toast.makeText(prepareBattleActivity.this, "przycisk10", Toast.LENGTH_SHORT).show();
                    if (!blist.get(5)) {
                        button10.setBackgroundColor(Color.YELLOW);
                        x1[0] = (button10.getId() / 10) % 10;
                        y1[0] = button10.getId() % 10;
                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                        }
                    }
                } else {
                    if (blist.get(5)) {
                        x2[0] = (button10.getId() / 10) % 10;
                        y2[0] = button10.getId() % 10;

                        ships1.add(new Ship(x1[0], y1[0]));
                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            buttonShip3.setText("0");
                        }

                    }
                }
            }

        });


        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(6)) {
                        button11.setBackgroundColor(Color.YELLOW);
                        x1[0] = (button11.getId() / 10) % 10;
                        y1[0] = button11.getId() % 10;
                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                        }
                    }
                } else {
                    if (blist.get(6)) {
                        x2[0] = (button11.getId() / 10) % 10;
                        y2[0] = button11.getId() % 10;

                        ships1.add(new Ship(x1[0], y1[0]));
                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }

                    }
                }
            }

        });


        //++++++++++++++++++++++++++++ WIERSZ TRZECI +++++++++++++++++++++++++++++++++++


        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {
                    Toast.makeText(prepareBattleActivity.this, "przycisk10", Toast.LENGTH_SHORT).show();
                    if (!blist.get(10)) {
                        button20.setBackgroundColor(Color.YELLOW);
                        x1[0] = (button20.getId() / 10) % 10;
                        y1[0] = button20.getId() % 10;
                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                        }
                    }
                } else {
                    if (blist.get(10)) {
                        x2[0] = (button20.getId() / 10) % 10;
                        y2[0] = button20.getId() % 10;

                        ships1.add(new Ship(x1[0], y1[0]));
                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            buttonShip3.setText("0");
                        }

                    }
                }
            }

        });


        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(11)) {
                        button21.setBackgroundColor(Color.YELLOW);
                        x1[0] = (button21.getId() / 10) % 10;
                        y1[0] = button21.getId() % 10;
                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                        }
                    }
                } else {
                    if (blist.get(11)) {
                        x2[0] = (button21.getId() / 10) % 10;
                        y2[0] = button21.getId() % 10;

                        ships1.add(new Ship(x1[0], y1[0]));
                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }

                    }
                }
            }

        });


        //+++++++++++++++++++++++++++++++ WIERSZ CZWARTY +++++++++++++++++++++++++++++



        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {
                    Toast.makeText(prepareBattleActivity.this, "przycisk10", Toast.LENGTH_SHORT).show();
                    if (!blist.get(15)) {
                        button30.setBackgroundColor(Color.YELLOW);
                        x1[0] = (button30.getId() / 10) % 10;
                        y1[0] = button30.getId() % 10;
                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                        }else if (!buttonShip1.getText().toString().equals("0")){
                            ships1.add(new Ship(x1[0], y1[0]));
                            placeShip(x1[0], y1[0], x1[0], y1[0]);
                            button30.setEnabled(false);
                            if (buttonShip1.getText().toString().equals("3"))
                                button30.setId(430);
                            else if (buttonShip1.getText().toString().equals("2"))
                                button30.setId(330);
                            else if (buttonShip1.getText().toString().equals("1"))
                                button30.setId(230);
                            button30.setBackgroundColor(Color.BLACK);
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                        }
                    }
                } else {
                    if (blist.get(15)) {
                        x2[0] = (button30.getId() / 10) % 10;
                        y2[0] = button30.getId() % 10;

                        ships1.add(new Ship(x1[0], y1[0]));
                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }

                    }
                }
            }

        });

        //++++++++++++++++++++++++++++++++ WIERSZ PIĄTY ++++++++++++++++++++++++++++++++

        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(20)) {

                        button40.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button40.getId() / 10) % 10;
                        y1[0] = button40.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 740;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 640;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 540;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button40.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 440;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 340;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 240;

                            button40.setBackgroundColor(Color.BLACK);

                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships1.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(20)) {

                        x2[0] = (button40.getId() / 10) % 10;
                        y2[0] = button40.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 740;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 640;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 540;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships1.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });

        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {

                    if (!blist.get(22)) {
                        button42.setBackgroundColor(Color.YELLOW);
                        x1[0] = (button42.getId() / 10) % 10;
                        y1[0] = button42.getId() % 10;
                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                        }else if (!buttonShip1.getText().toString().equals("0")){
                            ships1.add(new Ship(x1[0], y1[0]));
                            placeShip(x1[0], y1[0], x1[0], y1[0]);
                            button42.setEnabled(false);
                            if (buttonShip1.getText().toString().equals("3"))
                                button42.setId(442);
                            else if (buttonShip1.getText().toString().equals("2"))
                                button42.setId(342);
                            else if (buttonShip1.getText().toString().equals("1"))
                                button42.setId(242);
                            button42.setBackgroundColor(Color.BLACK);
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                        }
                    }
                } else {
                    if (blist.get(22)) {
                        x2[0] = (button40.getId() / 10) % 10;
                        y2[0] = button40.getId() % 10;

                        ships1.add(new Ship(x1[0], y1[0]));
                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }

                    }
                }
            }

        });
    }


    public void placeShip(int x, int y, int x2, int y2){
        int id1 = 100 + x*10 + y;
        int id2 = 100 + x2*10 + y2;
        int id3 = 0;

        if (x == x2){
            if(Math.abs(y-y2) == 2){
                int y3 = (y+y2)/2;
                id3 = 100 + x*10 + y3;
            }
        }else if(y == y2){
            if(Math.abs(x-x2) == 2){
                int x3 = (x+x2)/2;
                id3 = 100 + x3*10 + y;
            }
        }

        if(id3 == 0) {
            switch (id1) {
                case 100:
                    button00.setEnabled(false);
                    if (buttonShip2.getText().toString().equals("2"))
                        button00.setId(600);
                    else if (buttonShip2.getText().toString().equals("1"))
                        button00.setId(500);
                    button00.setBackgroundColor(Color.BLACK);
                    break;
                case 110:
                    button10.setEnabled(false);
                    if (buttonShip2.getText().toString().equals("2"))
                        button10.setId(600);
                    else if (buttonShip2.getText().toString().equals("1"))
                        button10.setId(500);
                    button10.setBackgroundColor(Color.BLACK);
                    break;
                case 120:
                    button20.setEnabled(false);
                    if (buttonShip2.getText().toString().equals("2"))
                        button20.setId(600);
                    else if (buttonShip2.getText().toString().equals("1"))
                        button20.setId(500);
                    button20.setBackgroundColor(Color.BLACK);
                    break;
            }

            switch (id2) {
                case 101:
                    button01.setEnabled(false);
                    if (buttonShip2.getText().toString().equals("2"))
                        button01.setId(600);
                    else if (buttonShip2.getText().toString().equals("1"))
                        button01.setId(500);
                    button01.setBackgroundColor(Color.BLACK);
                    break;
                case 111:
                    button11.setEnabled(false);
                    if (buttonShip2.getText().toString().equals("2"))
                        button11.setId(600);
                    else if (buttonShip2.getText().toString().equals("1"))
                        button11.setId(500);
                    button11.setBackgroundColor(Color.BLACK);
                    break;
                case 121:
                    button21.setEnabled(false);
                    if (buttonShip2.getText().toString().equals("2"))
                        button21.setId(600);
                    else if (buttonShip2.getText().toString().equals("1"))
                        button21.setId(500);
                    button21.setBackgroundColor(Color.BLACK);
                    break;
            }
        } else {
            switch (id1) {
                case 100:
                    button00.setEnabled(false);
                    button00.setId(700);
                    button00.setBackgroundColor(Color.BLACK);
                    break;
            }

            switch (id3) {
                case 101:
                    button01.setEnabled(false);
                    button01.setId(701);
                    button01.setBackgroundColor(Color.BLACK);
                    break;
            }

            switch (id2) {
                case 102:
                    button02.setEnabled(false);
                    button02.setId(702);
                    button02.setBackgroundColor(Color.BLACK);
                    break;
            }
        }

        x1[0]=500;
        y1[0]=500;

    }


    public void dimButtons(int x, int y, int length){
        int id = 100 + x*10 + y;

        switch(id){
            case 100:
                if(length == 2){
                    if (button01.getId() < 200) {
                        button01.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(1, false);
                    }
                    if(button10.getId() < 200) {
                        button10.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(5, false);
                    }
                }else if (length == 3){
                    if(button02.getId() < 200) {
                        button02.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(2, false);
                    }
                    if(button20.getId() < 200) {
                        button20.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(10, false);
                    }
                }
                break;
            case 110:
                if(length == 2){
                    if(button00.getId() < 200) {
                        button00.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(0, false);
                    }
                    if(button11.getId() < 200) {
                        button11.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(6, false);
                    }
                    if(button20.getId() < 200) {
                        button20.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(10, false);
                    }
                }else if (length == 3){
                    if(button12.getId() < 200) {
                        button12.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(7, false);
                    }
                    if(button30.getId() < 200) {
                        button30.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(15, false);
                    }
                }
                break;
            case 120:
                if(length == 2){
                    if(button10.getId() < 200) {
                        button10.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(5, false);
                    }
                    if(button21.getId() < 200) {
                        button21.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(11, false);
                    }
                    if(button30.getId() < 200) {
                        button30.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(15, false);
                    }
                }else if (length == 3){
                    if(button00.getId() < 200) {
                        button00.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(0, false);
                    }
                    if(button22.getId() < 200) {
                        button22.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(12, false);
                    }
                    if(button04.getId() < 200) {
                        button04.setBackgroundColor(Color.parseColor("#FF33B5E5"));
                        blist.set(20, false);
                    }
                }
                break;
        }
    }


    public void lightButtons(int x, int y, int length){
        int id = 100 + x*10 + y;

        switch(id){
            case 100:
                if(length == 2){
                    if(button01.getId() < 200) {
                        button01.setBackgroundColor(Color.YELLOW);
                        blist.set(1, true);
                    }
                    if(button10.getId() <200) {
                        button10.setBackgroundColor(Color.YELLOW);
                        blist.set(5, true);
                    }
                }else if (length == 3){
                    if(button02.getId() <200) {
                        button02.setBackgroundColor(Color.YELLOW);
                        blist.set(2, true);
                    }
                    if(button20.getId() < 200) {
                        button20.setBackgroundColor(Color.YELLOW);
                        blist.set(10, true);
                    }
                }
                break;
            case 110:
                if(length == 2){
                    if(button00.getId() < 200) {
                        button00.setBackgroundColor(Color.YELLOW);
                        blist.set(0, true);
                    }
                    if(button11.getId() < 200) {
                        button11.setBackgroundColor(Color.YELLOW);
                        blist.set(6, true);
                    }
                    if(button20.getId() < 200) {
                        button20.setBackgroundColor(Color.YELLOW);
                        blist.set(10, true);
                    }
                }else if (length == 3){
                    if(button12.getId() < 200) {
                        button12.setBackgroundColor(Color.YELLOW);
                        blist.set(7, true);
                    }
                    if(button30.getId() < 200) {
                        button30.setBackgroundColor(Color.YELLOW);
                        blist.set(15, true);
                    }
                }
                break;
            case 120:
                if(length == 2){
                    if(button10.getId() < 200) {
                        button10.setBackgroundColor(Color.YELLOW);
                        blist.set(5, true);
                    }
                    if(button21.getId() < 200) {
                        button21.setBackgroundColor(Color.YELLOW);
                        blist.set(11, true);
                    }
                    if(button30.getId() < 200) {
                        button30.setBackgroundColor(Color.YELLOW);
                        blist.set(15, true);
                    }
                }else if (length == 3){
                    if(button00.getId() < 200) {
                        button00.setBackgroundColor(Color.YELLOW);
                        blist.set(0, true);
                    }
                    if(button22.getId() < 200) {
                        button22.setBackgroundColor(Color.YELLOW);
                        blist.set(12, true);
                    }
                    if(button40.getId() < 200) {
                        button40.setBackgroundColor(Color.YELLOW);
                        blist.set(20, true);
                    }
                }
                break;
        }
    }
}
