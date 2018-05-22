package com.example.maniekcs1995.grawstatki;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class prepareBattle2Activity extends AppCompatActivity {

    public static ArrayList<Ship> ships2 = new ArrayList<Ship>();

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
                if(buttonShip1.getText().toString().equals("0")) {
                      Intent intent = new Intent(prepareBattle2Activity.this, battleActivity.class);
                      startActivity(intent);
                      finish();
                }else{
                    Toast.makeText(prepareBattle2Activity.this, "Wciąż są statki w Twoim porcie. Wystaw je na pole bitwy!", Toast.LENGTH_SHORT).show();
                }

            }
        });



        //+++++++++++++++++++++++++ WIERSZ PIERWSZY ++++++++++++++++++++++++++++++++++

        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(0)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button00.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button00.getId() / 10) % 10;
                        y1[0] = button00.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 700;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 600;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 500;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button00.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 400;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 300;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 200;

                            button00.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(0)) {

                        x2[0] = (button00.getId() / 10) % 10;
                        y2[0] = button00.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 700;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 600;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 500;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(1)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button01.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button01.getId() / 10) % 10;
                        y1[0] = button01.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 701;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 601;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 501;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button01.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 401;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 301;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 201;

                            button01.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(1)) {

                        x2[0] = (button01.getId() / 10) % 10;
                        y2[0] = button01.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 701;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 601;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 501;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(prepareBattle2Activity.this, "Przycisk 02", Toast.LENGTH_SHORT).show();

                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(2)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button02.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button02.getId() / 10) % 10;
                        y1[0] = button02.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 702;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 602;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 502;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button02.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 402;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 302;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 202;

                            button02.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(2)) {

                        x2[0] = (button02.getId() / 10) % 10;
                        y2[0] = button02.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 702;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 602;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 502;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(3)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button03.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button03.getId() / 10) % 10;
                        y1[0] = button03.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 703;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 603;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 503;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button03.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 403;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 303;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 203;

                            button03.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(3)) {

                        x2[0] = (button03.getId() / 10) % 10;
                        y2[0] = button03.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 703;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 603;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 503;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(4)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button04.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button04.getId() / 10) % 10;
                        y1[0] = button04.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 704;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 604;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 504;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button04.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 404;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 304;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 204;

                            button04.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(4)) {
                        Toast.makeText(prepareBattle2Activity.this, "chuj", Toast.LENGTH_SHORT).show();
                        x2[0] = (button04.getId() / 10) % 10;
                        y2[0] = button04.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 704;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 604;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 504;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        //++++++++++++++++++++++++ WIERSZ DRUGI +++++++++++++++++++++++++++++++

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(5)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button10.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button10.getId() / 10) % 10;
                        y1[0] = button10.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 710;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 610;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 510;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button10.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 410;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 310;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 210;

                            button10.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(5)) {

                        x2[0] = (button10.getId() / 10) % 10;
                        y2[0] = button10.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 710;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 610;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 510;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(6)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button11.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button11.getId() / 10) % 10;
                        y1[0] = button11.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 711;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 611;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 511;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button11.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 411;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 311;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 211;

                            button11.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(6)) {

                        x2[0] = (button11.getId() / 10) % 10;
                        y2[0] = button11.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 711;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 611;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 511;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(7)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button12.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button12.getId() / 10) % 10;
                        y1[0] = button12.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 712;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 612;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 512;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button12.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 412;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 312;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 212;

                            button12.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(7)) {

                        x2[0] = (button12.getId() / 10) % 10;
                        y2[0] = button12.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 712;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 612;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 512;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(8)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button13.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button13.getId() / 10) % 10;
                        y1[0] = button13.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 713;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 613;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 513;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button13.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 413;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 313;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 213;

                            button13.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(8)) {

                        x2[0] = (button13.getId() / 10) % 10;
                        y2[0] = button13.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 713;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 613;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 513;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(9)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button14.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button14.getId() / 10) % 10;
                        y1[0] = button14.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 714;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 614;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 514;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button14.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 414;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 314;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 214;

                            button14.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(9)) {

                        x2[0] = (button14.getId() / 10) % 10;
                        y2[0] = button14.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 714;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 614;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 514;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        //++++++++++++++++++++++++++++ WIERSZ TRZECI +++++++++++++++++++++++++++++++++++


        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(10)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button20.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button20.getId() / 10) % 10;
                        y1[0] = button20.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 720;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 620;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 520;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button20.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 420;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 320;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 220;

                            button20.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(10)) {

                        x2[0] = (button20.getId() / 10) % 10;
                        y2[0] = button20.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 720;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 620;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 520;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(11)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button21.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button21.getId() / 10) % 10;
                        y1[0] = button21.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 721;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 621;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 521;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button21.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 421;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 321;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 221;

                            button21.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(11)) {

                        x2[0] = (button21.getId() / 10) % 10;
                        y2[0] = button21.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 721;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 621;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 521;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(12)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button22.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button22.getId() / 10) % 10;
                        y1[0] = button22.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 722;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 622;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 522;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button22.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 422;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 322;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 222;

                            button22.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(12)) {

                        x2[0] = (button22.getId() / 10) % 10;
                        y2[0] = button22.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 722;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 622;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 522;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(13)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button23.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button23.getId() / 10) % 10;
                        y1[0] = button23.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 723;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 623;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 523;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button23.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 423;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 323;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 223;

                            button23.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(13)) {

                        x2[0] = (button23.getId() / 10) % 10;
                        y2[0] = button23.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 723;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 623;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 523;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(14)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button24.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button24.getId() / 10) % 10;
                        y1[0] = button24.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 724;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 624;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 524;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button24.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 424;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 324;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 224;

                            button24.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(14)) {

                        x2[0] = (button24.getId() / 10) % 10;
                        y2[0] = button24.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 724;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 624;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 524;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        //+++++++++++++++++++++++++++++++ WIERSZ CZWARTY +++++++++++++++++++++++++++++



        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(15)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button30.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button30.getId() / 10) % 10;
                        y1[0] = button30.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 730;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 630;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 530;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button30.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 430;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 330;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 230;

                            button30.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(15)) {

                        x2[0] = (button30.getId() / 10) % 10;
                        y2[0] = button30.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 730;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 630;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 530;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });

        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(16)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button31.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button31.getId() / 10) % 10;
                        y1[0] = button31.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 731;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 631;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 531;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button31.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 431;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 331;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 231;

                            button31.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(16)) {

                        x2[0] = (button11.getId() / 10) % 10;
                        y2[0] = button11.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 731;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 631;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 531;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(17)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button32.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button32.getId() / 10) % 10;
                        y1[0] = button32.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 732;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 632;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 532;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button32.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 432;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 332;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 232;

                            button32.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(17)) {

                        x2[0] = (button32.getId() / 10) % 10;
                        y2[0] = button32.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 732;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 632;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 532;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(18)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button33.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button33.getId() / 10) % 10;
                        y1[0] = button33.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 733;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 633;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 533;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button33.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 433;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 333;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 233;

                            button33.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(18)) {

                        x2[0] = (button33.getId() / 10) % 10;
                        y2[0] = button33.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 733;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 633;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 533;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(19)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button34.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button34.getId() / 10) % 10;
                        y1[0] = button34.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 734;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 634;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 534;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button34.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 434;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 334;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 234;

                            button34.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(19)) {

                        x2[0] = (button34.getId() / 10) % 10;
                        y2[0] = button34.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 734;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 634;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 534;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
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
                        if(!buttonShip1.getText().toString().equals("0"))
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
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
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
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });

        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(21)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button41.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button41.getId() / 10) % 10;
                        y1[0] = button41.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 741;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 641;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 541;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button41.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 441;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 341;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 241;

                            button41.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(21)) {

                        x2[0] = (button41.getId() / 10) % 10;
                        y2[0] = button41.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 741;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 641;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 541;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(22)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button42.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button42.getId() / 10) % 10;
                        y1[0] = button42.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 742;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 642;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 542;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button42.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 442;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 342;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 242;

                            button42.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(22)) {

                        x2[0] = (button42.getId() / 10) % 10;
                        y2[0] = button42.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 742;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 642;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 542;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(23)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button43.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button43.getId() / 10) % 10;
                        y1[0] = button43.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 743;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 643;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 543;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button43.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 443;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 343;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 243;

                            button43.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(23)) {

                        x2[0] = (button43.getId() / 10) % 10;
                        y2[0] = button43.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 743;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 643;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 543;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
                    }
                }
            }

        });


        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (x1[0] == 500 && y1[0] == 500) {
                    if (!blist.get(24)) {
                        if(!buttonShip1.getText().toString().equals("0"))
                        button44.setBackgroundColor(Color.YELLOW);

                        x1[0] = (button44.getId() / 10) % 10;
                        y1[0] = button44.getId() % 10;

                        if (buttonShip3.getText().toString().equals("1")) {
                            lightButtons(x1[0], y1[0], 3);
                            startButtonId = 744;
                        }else if (!buttonShip2.getText().toString().equals("0")){
                            lightButtons(x1[0], y1[0], 2);
                            if(buttonShip2.getText().toString().equals("2")){
                                startButtonId = 644;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                startButtonId = 544;
                            }
                        }else if (!buttonShip1.getText().toString().equals("0")){

                            button44.setEnabled(false);

                            if (buttonShip1.getText().toString().equals("3"))
                                startButtonId = 444;
                            else if (buttonShip1.getText().toString().equals("2"))
                                startButtonId = 344;
                            else if (buttonShip1.getText().toString().equals("1"))
                                startButtonId = 244;

                            button44.setBackgroundColor(Color.BLACK);
                            x1[0]=500; y1[0]=500;
                            int numberOfShips = Integer.valueOf(buttonShip1.getText().toString()) - 1;
                            buttonShip1.setText(String.valueOf(numberOfShips));
                            ships2.add(new Ship(startButtonId, 0));
                        }
                    }
                } else {
                    if (blist.get(24)) {

                        x2[0] = (button44.getId() / 10) % 10;
                        y2[0] = button44.getId() % 10;


                        if (buttonShip3.getText().toString().equals("1")) {
                            dimButtons(x1[0], y1[0], 3);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);
                            endButtonId = 744;
                            buttonShip3.setText("0");
                        } else if (!buttonShip2.getText().toString().equals("0")){
                            dimButtons(x1[0], y1[0], 2);
                            placeShip(x1[0], y1[0], x2[0], y2[0]);

                            if(buttonShip2.getText().toString().equals("2")){
                                endButtonId = 644;
                            }
                            if(buttonShip2.getText().toString().equals("1")){
                                endButtonId = 544;
                            }

                            int numberOfShips = Integer.valueOf(buttonShip2.getText().toString()) - 1;
                            buttonShip2.setText(String.valueOf(numberOfShips));
                        }
                        ships2.add(new Ship(startButtonId, endButtonId));
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
                    button00.setId(200);
                    button00.setBackgroundColor(Color.BLACK);
                    break;
                case 101:
                    button01.setEnabled(false);
                    button01.setId(200);
                    button01.setBackgroundColor(Color.BLACK);
                    break;
                case 102:
                    button02.setEnabled(false);
                    button02.setId(200);
                    button02.setBackgroundColor(Color.BLACK);
                    break;
                case 103:
                    button03.setEnabled(false);
                    button03.setId(200);
                    button03.setBackgroundColor(Color.BLACK);
                    break;
                case 104:
                    button04.setEnabled(false);
                    button04.setId(200);
                    button04.setBackgroundColor(Color.BLACK);
                    break;
                case 110:
                    button10.setEnabled(false);
                    button10.setId(200);
                    button10.setBackgroundColor(Color.BLACK);
                    break;
                case 111:
                    button11.setEnabled(false);
                    button11.setId(200);
                    button11.setBackgroundColor(Color.BLACK);
                    break;
                case 112:
                    button12.setEnabled(false);
                    button12.setId(200);
                    button12.setBackgroundColor(Color.BLACK);
                    break;
                case 113:
                    button13.setEnabled(false);
                    button13.setId(200);
                    button13.setBackgroundColor(Color.BLACK);
                    break;
                case 114:
                    button14.setEnabled(false);
                    button14.setId(200);
                    button14.setBackgroundColor(Color.BLACK);
                    break;
                case 120:
                    button20.setEnabled(false);
                    button20.setId(200);
                    button20.setBackgroundColor(Color.BLACK);
                    break;
                case 121:
                    button21.setEnabled(false);
                    button21.setId(200);
                    button21.setBackgroundColor(Color.BLACK);
                    break;
                case 122:
                    button22.setEnabled(false);
                    button22.setId(200);
                    button22.setBackgroundColor(Color.BLACK);
                    break;
                case 123:
                    button23.setEnabled(false);
                    button23.setId(200);
                    button23.setBackgroundColor(Color.BLACK);
                    break;
                case 124:
                    button24.setEnabled(false);
                    button24.setId(200);
                    button24.setBackgroundColor(Color.BLACK);
                    break;
                case 130:
                    button30.setEnabled(false);
                    button30.setId(200);
                    button30.setBackgroundColor(Color.BLACK);
                    break;
                case 131:
                    button31.setEnabled(false);
                    button31.setId(200);
                    button31.setBackgroundColor(Color.BLACK);
                    break;
                case 132:
                    button32.setEnabled(false);
                    button32.setId(200);
                    button32.setBackgroundColor(Color.BLACK);
                    break;
                case 133:
                    button33.setEnabled(false);
                    button33.setId(200);
                    button33.setBackgroundColor(Color.BLACK);
                    break;
                case 134:
                    button34.setEnabled(false);
                    button34.setId(200);
                    button34.setBackgroundColor(Color.BLACK);
                    break;
                case 140:
                    button40.setEnabled(false);
                    button40.setId(200);
                    button40.setBackgroundColor(Color.BLACK);
                    break;
                case 141:
                    button41.setEnabled(false);
                    button41.setId(200);
                    button41.setBackgroundColor(Color.BLACK);
                    break;
                case 142:
                    button42.setEnabled(false);
                    button42.setId(200);
                    button42.setBackgroundColor(Color.BLACK);
                    break;
                case 143:
                    button43.setEnabled(false);
                    button43.setId(200);
                    button43.setBackgroundColor(Color.BLACK);
                    break;
                case 144:
                    button44.setEnabled(false);
                    button44.setId(200);
                    button44.setBackgroundColor(Color.BLACK);
                    break;
            }

            switch (id2) {
                case 100:
                    button00.setEnabled(false);
                    button00.setId(200);
                    button00.setBackgroundColor(Color.BLACK);
                    break;
                case 101:
                    button01.setEnabled(false);
                    button01.setId(200);
                    button01.setBackgroundColor(Color.BLACK);
                    break;
                case 102:
                    button02.setEnabled(false);
                    button02.setId(200);
                    button02.setBackgroundColor(Color.BLACK);
                    break;
                case 103:
                    button03.setEnabled(false);
                    button03.setId(200);
                    button03.setBackgroundColor(Color.BLACK);
                    break;
                case 104:
                    button04.setEnabled(false);
                    button04.setId(200);
                    button04.setBackgroundColor(Color.BLACK);
                    break;
                case 110:
                    button10.setEnabled(false);
                    button10.setId(200);
                    button10.setBackgroundColor(Color.BLACK);
                    break;
                case 111:
                    button11.setEnabled(false);
                    button11.setId(200);
                    button11.setBackgroundColor(Color.BLACK);
                    break;
                case 112:
                    button12.setEnabled(false);
                    button12.setId(200);
                    button12.setBackgroundColor(Color.BLACK);
                    break;
                case 113:
                    button13.setEnabled(false);
                    button13.setId(200);
                    button13.setBackgroundColor(Color.BLACK);
                    break;
                case 114:
                    button14.setEnabled(false);
                    button14.setId(200);
                    button14.setBackgroundColor(Color.BLACK);
                    break;
                case 120:
                    button20.setEnabled(false);
                    button20.setId(200);
                    button20.setBackgroundColor(Color.BLACK);
                    break;
                case 121:
                    button21.setEnabled(false);
                    button21.setId(200);
                    button21.setBackgroundColor(Color.BLACK);
                    break;
                case 122:
                    button22.setEnabled(false);
                    button22.setId(200);
                    button22.setBackgroundColor(Color.BLACK);
                    break;
                case 123:
                    button23.setEnabled(false);
                    button23.setId(200);
                    button23.setBackgroundColor(Color.BLACK);
                    break;
                case 124:
                    button24.setEnabled(false);
                    button24.setId(200);
                    button24.setBackgroundColor(Color.BLACK);
                    break;
                case 130:
                    button30.setEnabled(false);
                    button30.setId(200);
                    button30.setBackgroundColor(Color.BLACK);
                    break;
                case 131:
                    button31.setEnabled(false);
                    button31.setId(200);
                    button31.setBackgroundColor(Color.BLACK);
                    break;
                case 132:
                    button32.setEnabled(false);
                    button32.setId(200);
                    button32.setBackgroundColor(Color.BLACK);
                    break;
                case 133:
                    button33.setEnabled(false);
                    button33.setId(200);
                    button33.setBackgroundColor(Color.BLACK);
                    break;
                case 134:
                    button34.setEnabled(false);
                    button34.setId(200);
                    button34.setBackgroundColor(Color.BLACK);
                    break;
                case 140:
                    button40.setEnabled(false);
                    button40.setId(200);
                    button40.setBackgroundColor(Color.BLACK);
                    break;
                case 141:
                    button41.setEnabled(false);
                    button41.setId(200);
                    button41.setBackgroundColor(Color.BLACK);
                    break;
                case 142:
                    button42.setEnabled(false);
                    button42.setId(200);
                    button42.setBackgroundColor(Color.BLACK);
                    break;
                case 143:
                    button43.setEnabled(false);
                    button43.setId(200);
                    button43.setBackgroundColor(Color.BLACK);
                    break;
                case 144:
                    button44.setEnabled(false);
                    button44.setId(200);
                    button44.setBackgroundColor(Color.BLACK);
                    break;
            }
        } else {
            switch (id1) {
                case 100:
                    button00.setEnabled(false);
                    button00.setId(200);
                    button00.setBackgroundColor(Color.BLACK);
                    break;
                case 101:
                    button01.setEnabled(false);
                    button01.setId(200);
                    button01.setBackgroundColor(Color.BLACK);
                    break;
                case 102:
                    button02.setEnabled(false);
                    button02.setId(200);
                    button02.setBackgroundColor(Color.BLACK);
                    break;
                case 103:
                    button03.setEnabled(false);
                    button03.setId(200);
                    button03.setBackgroundColor(Color.BLACK);
                    break;
                case 104:
                    button04.setEnabled(false);
                    button04.setId(200);
                    button04.setBackgroundColor(Color.BLACK);
                    break;
                case 110:
                    button10.setEnabled(false);
                    button10.setId(200);
                    button10.setBackgroundColor(Color.BLACK);
                    break;
                case 111:
                    button11.setEnabled(false);
                    button11.setId(200);
                    button11.setBackgroundColor(Color.BLACK);
                    break;
                case 112:
                    button12.setEnabled(false);
                    button12.setId(200);
                    button12.setBackgroundColor(Color.BLACK);
                    break;
                case 113:
                    button13.setEnabled(false);
                    button13.setId(200);
                    button13.setBackgroundColor(Color.BLACK);
                    break;
                case 114:
                    button14.setEnabled(false);
                    button14.setId(200);
                    button14.setBackgroundColor(Color.BLACK);
                    break;
                case 120:
                    button20.setEnabled(false);
                    button20.setId(200);
                    button20.setBackgroundColor(Color.BLACK);
                    break;
                case 121:
                    button21.setEnabled(false);
                    button21.setId(200);
                    button21.setBackgroundColor(Color.BLACK);
                    break;
                case 122:
                    button22.setEnabled(false);
                    button22.setId(200);
                    button22.setBackgroundColor(Color.BLACK);
                    break;
                case 123:
                    button23.setEnabled(false);
                    button23.setId(200);
                    button23.setBackgroundColor(Color.BLACK);
                    break;
                case 124:
                    button24.setEnabled(false);
                    button24.setId(200);
                    button24.setBackgroundColor(Color.BLACK);
                    break;
                case 130:
                    button30.setEnabled(false);
                    button30.setId(200);
                    button30.setBackgroundColor(Color.BLACK);
                    break;
                case 131:
                    button31.setEnabled(false);
                    button31.setId(200);
                    button31.setBackgroundColor(Color.BLACK);
                    break;
                case 132:
                    button32.setEnabled(false);
                    button32.setId(200);
                    button32.setBackgroundColor(Color.BLACK);
                    break;
                case 133:
                    button33.setEnabled(false);
                    button33.setId(200);
                    button33.setBackgroundColor(Color.BLACK);
                    break;
                case 134:
                    button34.setEnabled(false);
                    button34.setId(200);
                    button34.setBackgroundColor(Color.BLACK);
                    break;
                case 140:
                    button40.setEnabled(false);
                    button40.setId(200);
                    button40.setBackgroundColor(Color.BLACK);
                    break;
                case 141:
                    button41.setEnabled(false);
                    button41.setId(200);
                    button41.setBackgroundColor(Color.BLACK);
                    break;
                case 142:
                    button42.setEnabled(false);
                    button42.setId(200);
                    button42.setBackgroundColor(Color.BLACK);
                    break;
                case 143:
                    button43.setEnabled(false);
                    button43.setId(200);
                    button43.setBackgroundColor(Color.BLACK);
                    break;
                case 144:
                    button44.setEnabled(false);
                    button44.setId(200);
                    button44.setBackgroundColor(Color.BLACK);
                    break;
            }

            switch (id3) {
                case 100:
                    button00.setEnabled(false);
                    button00.setId(200);
                    button00.setBackgroundColor(Color.BLACK);
                    break;
                case 101:
                    button01.setEnabled(false);
                    button01.setId(200);
                    button01.setBackgroundColor(Color.BLACK);
                    break;
                case 102:
                    button02.setEnabled(false);
                    button02.setId(200);
                    button02.setBackgroundColor(Color.BLACK);
                    break;
                case 103:
                    button03.setEnabled(false);
                    button03.setId(200);
                    button03.setBackgroundColor(Color.BLACK);
                    break;
                case 104:
                    button04.setEnabled(false);
                    button04.setId(200);
                    button04.setBackgroundColor(Color.BLACK);
                    break;
                case 110:
                    button10.setEnabled(false);
                    button10.setId(200);
                    button10.setBackgroundColor(Color.BLACK);
                    break;
                case 111:
                    button11.setEnabled(false);
                    button11.setId(200);
                    button11.setBackgroundColor(Color.BLACK);
                    break;
                case 112:
                    button12.setEnabled(false);
                    button12.setId(200);
                    button12.setBackgroundColor(Color.BLACK);
                    break;
                case 113:
                    button13.setEnabled(false);
                    button13.setId(200);
                    button13.setBackgroundColor(Color.BLACK);
                    break;
                case 114:
                    button14.setEnabled(false);
                    button14.setId(200);
                    button14.setBackgroundColor(Color.BLACK);
                    break;
                case 120:
                    button20.setEnabled(false);
                    button20.setId(200);
                    button20.setBackgroundColor(Color.BLACK);
                    break;
                case 121:
                    button21.setEnabled(false);
                    button21.setId(200);
                    button21.setBackgroundColor(Color.BLACK);
                    break;
                case 122:
                    button22.setEnabled(false);
                    button22.setId(200);
                    button22.setBackgroundColor(Color.BLACK);
                    break;
                case 123:
                    button23.setEnabled(false);
                    button23.setId(200);
                    button23.setBackgroundColor(Color.BLACK);
                    break;
                case 124:
                    button24.setEnabled(false);
                    button24.setId(200);
                    button24.setBackgroundColor(Color.BLACK);
                    break;
                case 130:
                    button30.setEnabled(false);
                    button30.setId(200);
                    button30.setBackgroundColor(Color.BLACK);
                    break;
                case 131:
                    button31.setEnabled(false);
                    button31.setId(200);
                    button31.setBackgroundColor(Color.BLACK);
                    break;
                case 132:
                    button32.setEnabled(false);
                    button32.setId(200);
                    button32.setBackgroundColor(Color.BLACK);
                    break;
                case 133:
                    button33.setEnabled(false);
                    button33.setId(200);
                    button33.setBackgroundColor(Color.BLACK);
                    break;
                case 134:
                    button34.setEnabled(false);
                    button34.setId(200);
                    button34.setBackgroundColor(Color.BLACK);
                    break;
                case 140:
                    button40.setEnabled(false);
                    button40.setId(200);
                    button40.setBackgroundColor(Color.BLACK);
                    break;
                case 141:
                    button41.setEnabled(false);
                    button41.setId(200);
                    button41.setBackgroundColor(Color.BLACK);
                    break;
                case 142:
                    button42.setEnabled(false);
                    button42.setId(200);
                    button42.setBackgroundColor(Color.BLACK);
                    break;
                case 143:
                    button43.setEnabled(false);
                    button43.setId(200);
                    button43.setBackgroundColor(Color.BLACK);
                    break;
                case 144:
                    button44.setEnabled(false);
                    button44.setId(200);
                    button44.setBackgroundColor(Color.BLACK);
                    break;
            }

            switch (id2) {
                case 100:
                    button00.setEnabled(false);
                    button00.setId(200);
                    button00.setBackgroundColor(Color.BLACK);
                    break;
                case 101:
                    button01.setEnabled(false);
                    button01.setId(200);
                    button01.setBackgroundColor(Color.BLACK);
                    break;
                case 102:
                    button02.setEnabled(false);
                    button02.setId(200);
                    button02.setBackgroundColor(Color.BLACK);
                    break;
                case 103:
                    button03.setEnabled(false);
                    button03.setId(200);
                    button03.setBackgroundColor(Color.BLACK);
                    break;
                case 104:
                    button04.setEnabled(false);
                    button04.setId(200);
                    button04.setBackgroundColor(Color.BLACK);
                    break;
                case 110:
                    button10.setEnabled(false);
                    button10.setId(200);
                    button10.setBackgroundColor(Color.BLACK);
                    break;
                case 111:
                    button11.setEnabled(false);
                    button11.setId(200);
                    button11.setBackgroundColor(Color.BLACK);
                    break;
                case 112:
                    button12.setEnabled(false);
                    button12.setId(200);
                    button12.setBackgroundColor(Color.BLACK);
                    break;
                case 113:
                    button13.setEnabled(false);
                    button13.setId(200);
                    button13.setBackgroundColor(Color.BLACK);
                    break;
                case 114:
                    button14.setEnabled(false);
                    button14.setId(200);
                    button14.setBackgroundColor(Color.BLACK);
                    break;
                case 120:
                    button20.setEnabled(false);
                    button20.setId(200);
                    button20.setBackgroundColor(Color.BLACK);
                    break;
                case 121:
                    button21.setEnabled(false);
                    button21.setId(200);
                    button21.setBackgroundColor(Color.BLACK);
                    break;
                case 122:
                    button22.setEnabled(false);
                    button22.setId(200);
                    button22.setBackgroundColor(Color.BLACK);
                    break;
                case 123:
                    button23.setEnabled(false);
                    button23.setId(200);
                    button23.setBackgroundColor(Color.BLACK);
                    break;
                case 124:
                    button24.setEnabled(false);
                    button24.setId(200);
                    button24.setBackgroundColor(Color.BLACK);
                    break;
                case 130:
                    button30.setEnabled(false);
                    button30.setId(200);
                    button30.setBackgroundColor(Color.BLACK);
                    break;
                case 131:
                    button31.setEnabled(false);
                    button31.setId(200);
                    button31.setBackgroundColor(Color.BLACK);
                    break;
                case 132:
                    button32.setEnabled(false);
                    button32.setId(200);
                    button32.setBackgroundColor(Color.BLACK);
                    break;
                case 133:
                    button33.setEnabled(false);
                    button33.setId(200);
                    button33.setBackgroundColor(Color.BLACK);
                    break;
                case 134:
                    button34.setEnabled(false);
                    button34.setId(200);
                    button34.setBackgroundColor(Color.BLACK);
                    break;
                case 140:
                    button40.setEnabled(false);
                    button40.setId(200);
                    button40.setBackgroundColor(Color.BLACK);
                    break;
                case 141:
                    button41.setEnabled(false);
                    button41.setId(200);
                    button41.setBackgroundColor(Color.BLACK);
                    break;
                case 142:
                    button42.setEnabled(false);
                    button42.setId(200);
                    button42.setBackgroundColor(Color.BLACK);
                    break;
                case 143:
                    button43.setEnabled(false);
                    button43.setId(200);
                    button43.setBackgroundColor(Color.BLACK);
                    break;
                case 144:
                    button44.setEnabled(false);
                    button44.setId(200);
                    button44.setBackgroundColor(Color.BLACK);
                    break;
            }
        }

        x1[0]=500;
        y1[0]=500;

    }


    public void dimButtons(int x, int y, int length){
        int id = 100 + x*10 + y;

        if(button00.getId() < 200){
            button00.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(0, false);
        }

        if(button01.getId() < 200){
            button01.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(1, false);
        }

        if(button02.getId() < 200){
            button02.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(2, false);
        }

        if(button03.getId() < 200){
            button03.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(3, false);
        }

        if(button04.getId() < 200){
            button04.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(4, false);
        }

        if(button10.getId() < 200){
            button10.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(5, false);
        }

        if(button11.getId() < 200){
            button11.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(6, false);
        }

        if(button12.getId() < 200){
            button12.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(7, false);
        }

        if(button13.getId() < 200){
            button13.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(8, false);
        }

        if(button14.getId() < 200){
            button14.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(9, false);
        }

        if(button20.getId() < 200){
            button20.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(10, false);
        }

        if(button21.getId() < 200){
            button21.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(11, false);
        }

        if(button22.getId() < 200){
            button22.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(12, false);
        }

        if(button23.getId() < 200){
            button23.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(13, false);
        }

        if(button24.getId() < 200){
            button24.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(14, false);
        }

        if(button30.getId() < 200){
            button30.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(15, false);
        }

        if(button31.getId() < 200){
            button31.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(16, false);
        }

        if(button32.getId() < 200){
            button32.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(17, false);
        }

        if(button33.getId() < 200){
            button33.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(18, false);
        }

        if(button34.getId() < 200){
            button34.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(19, false);
        }

        if(button40.getId() < 200){
            button40.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(20, false);
        }

        if(button41.getId() < 200){
            button41.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(21, false);
        }

        if(button42.getId() < 200){
            button42.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(22, false);
        }

        if(button43.getId() < 200){
            button43.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(23, false);
        }

        if(button44.getId() < 200){
            button44.setBackgroundColor(Color.parseColor("#FF33B5E5"));
            blist.set(24, false);
        }

        /*
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
        */
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
            case 101:
                if(length == 2){
                    if(button00.getId() < 200) {
                        button00.setBackgroundColor(Color.YELLOW);
                        blist.set(0, true);
                    }
                    if(button02.getId() <200) {
                        button02.setBackgroundColor(Color.YELLOW);
                        blist.set(2, true);
                    }
                    if(button11.getId() <200) {
                        button11.setBackgroundColor(Color.YELLOW);
                        blist.set(6, true);
                    }
                }else if (length == 3){
                    if(button03.getId() <200) {
                        button03.setBackgroundColor(Color.YELLOW);
                        blist.set(3, true);
                    }
                    if(button21.getId() < 200) {
                        button21.setBackgroundColor(Color.YELLOW);
                        blist.set(11, true);
                    }
                }
                break;
            case 102:
                if(length == 2){
                    if(button01.getId() < 200) {
                        button01.setBackgroundColor(Color.YELLOW);
                        blist.set(1, true);
                    }
                    if(button03.getId() <200) {
                        button03.setBackgroundColor(Color.YELLOW);
                        blist.set(3, true);
                    }
                    if(button12.getId() <200) {
                        button12.setBackgroundColor(Color.YELLOW);
                        blist.set(7, true);
                    }
                }else if (length == 3){
                    if(button00.getId() <200) {
                        button00.setBackgroundColor(Color.YELLOW);
                        blist.set(0, true);
                    }
                    if(button04.getId() < 200) {
                        button04.setBackgroundColor(Color.YELLOW);
                        blist.set(4, true);
                    }
                    if(button22.getId() < 200) {
                        button22.setBackgroundColor(Color.YELLOW);
                        blist.set(12, true);
                    }
                }
                break;
            case 103:
                if(length == 2){
                    if(button02.getId() < 200) {
                        button02.setBackgroundColor(Color.YELLOW);
                        blist.set(2, true);
                    }
                    if(button04.getId() <200) {
                        button04.setBackgroundColor(Color.YELLOW);
                        blist.set(4, true);
                    }
                    if(button13.getId() <200) {
                        button13.setBackgroundColor(Color.YELLOW);
                        blist.set(8, true);
                    }
                }else if (length == 3){
                    if(button01.getId() <200) {
                        button01.setBackgroundColor(Color.YELLOW);
                        blist.set(0, true);
                    }
                    if(button23.getId() < 200) {
                        button23.setBackgroundColor(Color.YELLOW);
                        blist.set(13, true);
                    }
                }
                break;
            case 104:
                if(length == 2){
                    if(button03.getId() < 200) {
                        button03.setBackgroundColor(Color.YELLOW);
                        blist.set(3, true);
                    }
                    if(button14.getId() <200) {
                        button14.setBackgroundColor(Color.YELLOW);
                        blist.set(9, true);
                    }
                }else if (length == 3){
                    if(button02.getId() <200) {
                        button02.setBackgroundColor(Color.YELLOW);
                        blist.set(2, true);
                    }
                    if(button24.getId() < 200) {
                        button24.setBackgroundColor(Color.YELLOW);
                        blist.set(14, true);
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
            case 111:
                if(length == 2){
                    if(button01.getId() < 200) {
                        button01.setBackgroundColor(Color.YELLOW);
                        blist.set(1, true);
                    }
                    if(button10.getId() < 200) {
                        button10.setBackgroundColor(Color.YELLOW);
                        blist.set(5, true);
                    }
                    if(button12.getId() < 200) {
                        button12.setBackgroundColor(Color.YELLOW);
                        blist.set(7, true);
                    }
                    if(button21.getId() < 200) {
                        button21.setBackgroundColor(Color.YELLOW);
                        blist.set(11, true);
                    }
                }else if (length == 3){
                    if(button13.getId() < 200) {
                        button13.setBackgroundColor(Color.YELLOW);
                        blist.set(8, true);
                    }
                    if(button31.getId() < 200) {
                        button31.setBackgroundColor(Color.YELLOW);
                        blist.set(16, true);
                    }
                }
                break;
            case 112:
                if(length == 2){
                    if(button11.getId() < 200) {
                        button11.setBackgroundColor(Color.YELLOW);
                        blist.set(6, true);
                    }
                    if(button13.getId() < 200) {
                        button13.setBackgroundColor(Color.YELLOW);
                        blist.set(8, true);
                    }
                    if(button02.getId() < 200) {
                        button02.setBackgroundColor(Color.YELLOW);
                        blist.set(2, true);
                    }
                    if(button22.getId() < 200) {
                        button22.setBackgroundColor(Color.YELLOW);
                        blist.set(12, true);
                    }
                }else if (length == 3){
                    if(button10.getId() < 200) {
                        button10.setBackgroundColor(Color.YELLOW);
                        blist.set(5, true);
                    }
                    if(button14.getId() < 200) {
                        button14.setBackgroundColor(Color.YELLOW);
                        blist.set(9, true);
                    }
                    if(button32.getId() < 200) {
                        button32.setBackgroundColor(Color.YELLOW);
                        blist.set(17, true);
                    }
                }
                break;
            case 113:
                if(length == 2){
                    if(button12.getId() < 200) {
                        button12.setBackgroundColor(Color.YELLOW);
                        blist.set(7, true);
                    }
                    if(button14.getId() < 200) {
                        button14.setBackgroundColor(Color.YELLOW);
                        blist.set(9, true);
                    }
                    if(button03.getId() < 200) {
                        button03.setBackgroundColor(Color.YELLOW);
                        blist.set(3, true);
                    }
                    if(button23.getId() < 200) {
                        button23.setBackgroundColor(Color.YELLOW);
                        blist.set(13, true);
                    }
                }else if (length == 3){
                    if(button11.getId() < 200) {
                        button11.setBackgroundColor(Color.YELLOW);
                        blist.set(6, true);
                    }
                    if(button33.getId() < 200) {
                        button33.setBackgroundColor(Color.YELLOW);
                        blist.set(18, true);
                    }
                }
                break;
            case 114:
                if(length == 2){
                    if(button13.getId() < 200) {
                        button13.setBackgroundColor(Color.YELLOW);
                        blist.set(8, true);
                    }
                    if(button04.getId() < 200) {
                        button04.setBackgroundColor(Color.YELLOW);
                        blist.set(4, true);
                    }
                    if(button24.getId() < 200) {
                        button24.setBackgroundColor(Color.YELLOW);
                        blist.set(14, true);
                    }
                }else if (length == 3){
                    if(button12.getId() < 200) {
                        button12.setBackgroundColor(Color.YELLOW);
                        blist.set(7, true);
                    }
                    if(button34.getId() < 200) {
                        button34.setBackgroundColor(Color.YELLOW);
                        blist.set(19, true);
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
            case 121:
                if(length == 2){
                    if(button11.getId() < 200) {
                        button11.setBackgroundColor(Color.YELLOW);
                        blist.set(6, true);
                    }
                    if(button22.getId() < 200) {
                        button22.setBackgroundColor(Color.YELLOW);
                        blist.set(12, true);
                    }
                    if(button20.getId() < 200) {
                        button20.setBackgroundColor(Color.YELLOW);
                        blist.set(10, true);
                    }
                    if(button31.getId() < 200) {
                        button31.setBackgroundColor(Color.YELLOW);
                        blist.set(16, true);
                    }
                }else if (length == 3){
                    if(button01.getId() < 200) {
                        button01.setBackgroundColor(Color.YELLOW);
                        blist.set(1, true);
                    }
                    if(button23.getId() < 200) {
                        button23.setBackgroundColor(Color.YELLOW);
                        blist.set(13, true);
                    }
                    if(button41.getId() < 200) {
                        button41.setBackgroundColor(Color.YELLOW);
                        blist.set(21, true);
                    }
                }
                break;
            case 122:
                if(length == 2){
                    if(button12.getId() < 200) {
                        button12.setBackgroundColor(Color.YELLOW);
                        blist.set(7, true);
                    }
                    if(button23.getId() < 200) {
                        button23.setBackgroundColor(Color.YELLOW);
                        blist.set(13, true);
                    }
                    if(button21.getId() < 200) {
                        button21.setBackgroundColor(Color.YELLOW);
                        blist.set(11, true);
                    }
                    if(button32.getId() < 200) {
                        button32.setBackgroundColor(Color.YELLOW);
                        blist.set(17, true);
                    }
                }else if (length == 3){
                    if(button02.getId() < 200) {
                        button02.setBackgroundColor(Color.YELLOW);
                        blist.set(2, true);
                    }
                    if(button20.getId() < 200) {
                        button20.setBackgroundColor(Color.YELLOW);
                        blist.set(10, true);
                    }
                    if(button42.getId() < 200) {
                        button42.setBackgroundColor(Color.YELLOW);
                        blist.set(22, true);
                    }
                    if(button24.getId() < 200) {
                        button24.setBackgroundColor(Color.YELLOW);
                        blist.set(14, true);
                    }
                }
                break;
            case 123:
                if(length == 2){
                    if(button13.getId() < 200) {
                        button13.setBackgroundColor(Color.YELLOW);
                        blist.set(8, true);
                    }
                    if(button24.getId() < 200) {
                        button24.setBackgroundColor(Color.YELLOW);
                        blist.set(14, true);
                    }
                    if(button22.getId() < 200) {
                        button22.setBackgroundColor(Color.YELLOW);
                        blist.set(12, true);
                    }
                    if(button33.getId() < 200) {
                        button33.setBackgroundColor(Color.YELLOW);
                        blist.set(18, true);
                    }
                }else if (length == 3){
                    if(button03.getId() < 200) {
                        button03.setBackgroundColor(Color.YELLOW);
                        blist.set(3, true);
                    }
                    if(button21.getId() < 200) {
                        button21.setBackgroundColor(Color.YELLOW);
                        blist.set(11, true);
                    }
                    if(button43.getId() < 200) {
                        button43.setBackgroundColor(Color.YELLOW);
                        blist.set(23, true);
                    }
                }
                break;
            case 124:
                if(length == 2){
                    if(button14.getId() < 200) {
                        button14.setBackgroundColor(Color.YELLOW);
                        blist.set(9, true);
                    }
                    if(button23.getId() < 200) {
                        button23.setBackgroundColor(Color.YELLOW);
                        blist.set(13, true);
                    }
                    if(button34.getId() < 200) {
                        button34.setBackgroundColor(Color.YELLOW);
                        blist.set(19, true);
                    }
                }else if (length == 3){
                    if(button04.getId() < 200) {
                        button04.setBackgroundColor(Color.YELLOW);
                        blist.set(4, true);
                    }
                    if(button22.getId() < 200) {
                        button22.setBackgroundColor(Color.YELLOW);
                        blist.set(12, true);
                    }
                    if(button44.getId() < 200) {
                        button44.setBackgroundColor(Color.YELLOW);
                        blist.set(24, true);
                    }
                }
                break;
            case 130:
                if(length == 2){
                    if(button31.getId() < 200) {
                        button31.setBackgroundColor(Color.YELLOW);
                        blist.set(16, true);
                    }
                    if(button20.getId() < 200) {
                        button20.setBackgroundColor(Color.YELLOW);
                        blist.set(10, true);
                    }
                    if(button40.getId() < 200) {
                        button40.setBackgroundColor(Color.YELLOW);
                        blist.set(20, true);
                    }
                }else if (length == 3){
                    if(button10.getId() < 200) {
                        button10.setBackgroundColor(Color.YELLOW);
                        blist.set(5, true);
                    }
                    if(button32.getId() < 200) {
                        button32.setBackgroundColor(Color.YELLOW);
                        blist.set(17, true);
                    }
                }
                break;
            case 131:
                if(length == 2){
                    if(button21.getId() < 200) {
                        button21.setBackgroundColor(Color.YELLOW);
                        blist.set(11, true);
                    }
                    if(button41.getId() < 200) {
                        button41.setBackgroundColor(Color.YELLOW);
                        blist.set(21, true);
                    }
                    if(button30.getId() < 200) {
                        button30.setBackgroundColor(Color.YELLOW);
                        blist.set(15, true);
                    }
                    if(button32.getId() < 200) {
                        button32.setBackgroundColor(Color.YELLOW);
                        blist.set(17, true);
                    }
                }else if (length == 3){
                    if(button11.getId() < 200) {
                        button11.setBackgroundColor(Color.YELLOW);
                        blist.set(6, true);
                    }
                    if(button33.getId() < 200) {
                        button33.setBackgroundColor(Color.YELLOW);
                        blist.set(18, true);
                    }
                }
                break;
            case 132:
                if(length == 2){
                    if(button22.getId() < 200) {
                        button22.setBackgroundColor(Color.YELLOW);
                        blist.set(12, true);
                    }
                    if(button42.getId() < 200) {
                        button42.setBackgroundColor(Color.YELLOW);
                        blist.set(22, true);
                    }
                    if(button31.getId() < 200) {
                        button31.setBackgroundColor(Color.YELLOW);
                        blist.set(16, true);
                    }
                    if(button33.getId() < 200) {
                        button33.setBackgroundColor(Color.YELLOW);
                        blist.set(18, true);
                    }
                }else if (length == 3){
                    if(button12.getId() < 200) {
                        button12.setBackgroundColor(Color.YELLOW);
                        blist.set(7, true);
                    }
                    if(button34.getId() < 200) {
                        button34.setBackgroundColor(Color.YELLOW);
                        blist.set(19, true);
                    }
                    if(button30.getId() < 200) {
                        button30.setBackgroundColor(Color.YELLOW);
                        blist.set(15, true);
                    }
                }
                break;
            case 133:
                if(length == 2){
                    if(button23.getId() < 200) {
                        button23.setBackgroundColor(Color.YELLOW);
                        blist.set(13, true);
                    }
                    if(button43.getId() < 200) {
                        button43.setBackgroundColor(Color.YELLOW);
                        blist.set(23, true);
                    }
                    if(button32.getId() < 200) {
                        button32.setBackgroundColor(Color.YELLOW);
                        blist.set(17, true);
                    }
                    if(button34.getId() < 200) {
                        button34.setBackgroundColor(Color.YELLOW);
                        blist.set(19, true);
                    }
                }else if (length == 3){
                    if(button13.getId() < 200) {
                        button13.setBackgroundColor(Color.YELLOW);
                        blist.set(8, true);
                    }
                    if(button31.getId() < 200) {
                        button31.setBackgroundColor(Color.YELLOW);
                        blist.set(16, true);
                    }
                }
                break;
            case 134:
                if(length == 2){
                    if(button24.getId() < 200) {
                        button24.setBackgroundColor(Color.YELLOW);
                        blist.set(14, true);
                    }
                    if(button44.getId() < 200) {
                        button44.setBackgroundColor(Color.YELLOW);
                        blist.set(24, true);
                    }
                    if(button33.getId() < 200) {
                        button33.setBackgroundColor(Color.YELLOW);
                        blist.set(18, true);
                    }

                }else if (length == 3){
                    if(button14.getId() < 200) {
                        button14.setBackgroundColor(Color.YELLOW);
                        blist.set(9, true);
                    }
                    if(button32.getId() < 200) {
                        button32.setBackgroundColor(Color.YELLOW);
                        blist.set(17, true);
                    }
                }
                break;

            case 140:
                if(length == 2){
                    if(button30.getId() < 200) {
                        button30.setBackgroundColor(Color.YELLOW);
                        blist.set(15, true);
                    }
                    if(button41.getId() < 200) {
                        button41.setBackgroundColor(Color.YELLOW);
                        blist.set(21, true);
                    }
                }else if (length == 3){
                    if(button20.getId() < 200) {
                        button20.setBackgroundColor(Color.YELLOW);
                        blist.set(10, true);
                    }
                    if(button42.getId() < 200) {
                        button42.setBackgroundColor(Color.YELLOW);
                        blist.set(22, true);
                    }
                }
                break;
            case 141:
                if(length == 2){
                    if(button31.getId() < 200) {
                        button31.setBackgroundColor(Color.YELLOW);
                        blist.set(16, true);
                    }
                    if(button40.getId() < 200) {
                        button40.setBackgroundColor(Color.YELLOW);
                        blist.set(20, true);
                    }
                    if(button42.getId() < 200) {
                        button42.setBackgroundColor(Color.YELLOW);
                        blist.set(22, true);
                    }
                }else if (length == 3){
                    if(button21.getId() < 200) {
                        button21.setBackgroundColor(Color.YELLOW);
                        blist.set(11, true);
                    }
                    if(button43.getId() < 200) {
                        button43.setBackgroundColor(Color.YELLOW);
                        blist.set(23, true);
                    }
                }
                break;
            case 142:
                if(length == 2){
                    if(button32.getId() < 200) {
                        button32.setBackgroundColor(Color.YELLOW);
                        blist.set(17, true);
                    }
                    if(button41.getId() < 200) {
                        button41.setBackgroundColor(Color.YELLOW);
                        blist.set(21, true);
                    }
                    if(button43.getId() < 200) {
                        button43.setBackgroundColor(Color.YELLOW);
                        blist.set(23, true);
                    }
                }else if (length == 3){
                    if(button22.getId() < 200) {
                        button22.setBackgroundColor(Color.YELLOW);
                        blist.set(12, true);
                    }
                    if(button44.getId() < 200) {
                        button44.setBackgroundColor(Color.YELLOW);
                        blist.set(24, true);
                    }
                    if(button40.getId() < 200) {
                        button40.setBackgroundColor(Color.YELLOW);
                        blist.set(20, true);
                    }
                }
                break;
            case 143:
                if(length == 2){
                    if(button33.getId() < 200) {
                        button33.setBackgroundColor(Color.YELLOW);
                        blist.set(18, true);
                    }
                    if(button42.getId() < 200) {
                        button42.setBackgroundColor(Color.YELLOW);
                        blist.set(22, true);
                    }
                    if(button44.getId() < 200) {
                        button44.setBackgroundColor(Color.YELLOW);
                        blist.set(24, true);
                    }
                }else if (length == 3){
                    if(button23.getId() < 200) {
                        button23.setBackgroundColor(Color.YELLOW);
                        blist.set(13, true);
                    }
                    if(button41.getId() < 200) {
                        button41.setBackgroundColor(Color.YELLOW);
                        blist.set(21, true);
                    }
                }
                break;
            case 144:
                if(length == 2){
                    if(button34.getId() < 200) {
                        button34.setBackgroundColor(Color.YELLOW);
                        blist.set(19, true);
                    }
                    if(button43.getId() < 200) {
                        button43.setBackgroundColor(Color.YELLOW);
                        blist.set(23, true);
                    }

                }else if (length == 3){
                    if(button24.getId() < 200) {
                        button24.setBackgroundColor(Color.YELLOW);
                        blist.set(14, true);
                    }
                    if(button42.getId() < 200) {
                        button42.setBackgroundColor(Color.YELLOW);
                        blist.set(22 , true);
                    }
                }
                break;
        }
    }
}
