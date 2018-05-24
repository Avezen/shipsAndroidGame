package com.example.maniekcs1995.grawstatki;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class battleActivity extends AppCompatActivity {

    static Button buttonShip3, buttonShip2, buttonShip1;
    public static int ship3Count = 1, ship2Count = 2, ship1Count = 3, ship1Count2 = 3;
    public static int gameOver = 0;

    Button button00, button10, button20, button30, button40,
            button01, button11, button21, button31, button41,
            button02, button12, button22, button32, button42,
            button03, button13, button23, button33, button43,
            button04, button14, button24, button34, button44;
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        if(battle2Activity.gameOver == 1){
            battle2Activity.gameOver = 0;
            prepareBattleActivity.ships1.clear();
            prepareBattle2Activity.ships2.clear();
            battleActivity.ship1Count = 3;
            battleActivity.ship2Count = 2;
            battleActivity.ship3Count = 1;
            battle2Activity.ship1Count = 3;
            battle2Activity.ship2Count = 2;
            battle2Activity.ship3Count = 1;
            Intent intent = new Intent(battleActivity.this, prepareBattleActivity.class);
            startActivity(intent);
            finish();
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText("Atakuje gracz nr 2");

        buttonShip3 = findViewById(R.id.buttonShip3);
        buttonShip2 = findViewById(R.id.buttonShip2);
        buttonShip1 = findViewById(R.id.buttonShip1);

        if(battle2Activity.buttonShip3 == null || battle2Activity.buttonShip2 == null || battle2Activity.buttonShip1 == null ){
            Intent intent = new Intent(battleActivity.this, battle2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }


        buttonShip3.setText(String.valueOf(ship3Count));
        buttonShip2.setText(String.valueOf(ship2Count));
        buttonShip1.setText(String.valueOf(ship1Count));


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
        final int[] countShip7 = {3};
        final int[] countShip6 = {2};
        final int[] countShip5 = {2};


        final AlertDialog.Builder builder = new AlertDialog.Builder(battleActivity.this);



        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button00.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button00.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button00.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button00.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button00.setEnabled(false);
                        button00.setId(700);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button00.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button00.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button00.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button00.setEnabled(false);
                        button00.setId(600);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button00.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button00.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button00.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button00.setEnabled(false);
                        button00.setId(500);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;
                            battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button00.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button00.setBackgroundColor(Color.RED);
                        button00.setEnabled(false);
                        button00.setId(400);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button00.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button00.setBackgroundColor(Color.RED);
                        button00.setEnabled(false);
                        button00.setId(300);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button00.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button00.setBackgroundColor(Color.RED);
                        button00.setEnabled(false);
                        button00.setId(200);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button00.getId() == 100){
                    button00.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button01.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button01.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button01.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button01.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button01.setEnabled(false);
                        button01.setId(701);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(701);
                        }
                    }else if ((button01.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button01.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button01.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button01.setEnabled(false);
                        button01.setId(601);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button01.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button01.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button01.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button01.setEnabled(false);
                        button01.setId(501);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button01.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button01.setBackgroundColor(Color.RED);
                        button01.setEnabled(false);
                        button01.setId(401);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button01.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button01.setBackgroundColor(Color.RED);
                        button01.setEnabled(false);
                        button01.setId(301);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button01.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button01.setBackgroundColor(Color.RED);
                        button01.setEnabled(false);
                        button01.setId(201);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button01.getId() == 101){
                    button01.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button02.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button02.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button02.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button02.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button02.setEnabled(false);
                        button02.setId(702);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button02.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button02.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button02.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button02.setEnabled(false);
                        button02.setId(602);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button02.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button02.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button02.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button02.setEnabled(false);
                        button02.setId(502);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button02.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button02.setBackgroundColor(Color.RED);
                        button02.setEnabled(false);
                        button02.setId(402);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button02.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button02.setBackgroundColor(Color.RED);
                        button02.setEnabled(false);
                        button02.setId(302);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button02.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button02.setBackgroundColor(Color.RED);
                        button02.setEnabled(false);
                        button02.setId(202);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button02.getId() == 102){
                    button02.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button03.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button03.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button03.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button03.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button03.setEnabled(false);
                        button03.setId(703);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button03.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button03.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button03.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button03.setEnabled(false);
                        button03.setId(603);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button03.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button03.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button03.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button03.setEnabled(false);
                        button03.setId(503);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button03.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button03.setBackgroundColor(Color.RED);
                        button03.setEnabled(false);
                        button03.setId(403);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button03.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button03.setBackgroundColor(Color.RED);
                        button03.setEnabled(false);
                        button03.setId(303);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button03.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button03.setBackgroundColor(Color.RED);
                        button03.setEnabled(false);
                        button03.setId(203);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button03.getId() == 103){
                    button03.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button04.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button04.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button04.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button04.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button04.setEnabled(false);
                        button04.setId(704);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button04.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button04.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button04.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button04.setEnabled(false);
                        button04.setId(604);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button04.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button04.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button04.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button04.setEnabled(false);
                        button04.setId(504);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button04.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button04.setBackgroundColor(Color.RED);
                        button04.setEnabled(false);
                        button04.setId(404);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button04.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button04.setBackgroundColor(Color.RED);
                        button04.setEnabled(false);
                        button04.setId(304);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button04.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button04.setBackgroundColor(Color.RED);
                        button04.setEnabled(false);
                        button04.setId(204);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button04.getId() == 104){
                    button04.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });


        //+++++++++++++++++++++++++++++ WIERSZ DRUGI +++++++++++++++++++++++++++++++

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button10.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button10.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button10.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button10.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button10.setEnabled(false);
                        button10.setId(710);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button10.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button10.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button10.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button10.setEnabled(false);
                        button10.setId(610);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button10.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button10.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button10.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button10.setEnabled(false);
                        button10.setId(510);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button10.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button10.setBackgroundColor(Color.RED);
                        button10.setEnabled(false);
                        button10.setId(410);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button10.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button10.setBackgroundColor(Color.RED);
                        button10.setEnabled(false);
                        button10.setId(310);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button10.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button10.setBackgroundColor(Color.RED);
                        button10.setEnabled(false);
                        button10.setId(210);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button10.getId() == 110){
                    button10.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button11.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button11.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button11.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button11.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button11.setEnabled(false);
                        button11.setId(711);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(701);
                        }
                    }else if ((button11.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button11.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button11.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button11.setEnabled(false);
                        button11.setId(611);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button11.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button11.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button11.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button11.setEnabled(false);
                        button11.setId(511);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button11.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button11.setBackgroundColor(Color.RED);
                        button11.setEnabled(false);
                        button11.setId(411);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button01.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button11.setBackgroundColor(Color.RED);
                        button11.setEnabled(false);
                        button11.setId(311);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button11.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button11.setBackgroundColor(Color.RED);
                        button11.setEnabled(false);
                        button11.setId(211);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button11.getId() == 111){
                    button11.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button12.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button12.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button12.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button12.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button12.setEnabled(false);
                        button12.setId(712);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button12.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button12.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button12.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button12.setEnabled(false);
                        button12.setId(612);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button12.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button12.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button12.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button12.setEnabled(false);
                        button12.setId(512);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button12.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button12.setBackgroundColor(Color.RED);
                        button12.setEnabled(false);
                        button12.setId(412);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button12.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button12.setBackgroundColor(Color.RED);
                        button12.setEnabled(false);
                        button12.setId(312);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button12.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button12.setBackgroundColor(Color.RED);
                        button12.setEnabled(false);
                        button12.setId(212);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button12.getId() == 112){
                    button12.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button13.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button13.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button13.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button13.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button13.setEnabled(false);
                        button13.setId(713);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button13.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button13.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button13.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button13.setEnabled(false);
                        button13.setId(613);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button13.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button13.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button13.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button13.setEnabled(false);
                        button13.setId(513);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button13.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button13.setBackgroundColor(Color.RED);
                        button13.setEnabled(false);
                        button13.setId(413);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button13.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button13.setBackgroundColor(Color.RED);
                        button13.setEnabled(false);
                        button13.setId(313);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button13.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button13.setBackgroundColor(Color.RED);
                        button13.setEnabled(false);
                        button13.setId(213);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button13.getId() == 113){
                    button13.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button14.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button14.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button14.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button14.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button14.setEnabled(false);
                        button14.setId(714);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button14.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button14.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button14.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button14.setEnabled(false);
                        button14.setId(614);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button14.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button14.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button14.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button14.setEnabled(false);
                        button14.setId(514);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button14.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button14.setBackgroundColor(Color.RED);
                        button14.setEnabled(false);
                        button14.setId(414);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button14.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button14.setBackgroundColor(Color.RED);
                        button14.setEnabled(false);
                        button14.setId(314);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button14.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button14.setBackgroundColor(Color.RED);
                        button14.setEnabled(false);
                        button14.setId(214);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button14.getId() == 114){
                    button14.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });


        //+++++++++++++++++++++++++++++++++++++++ WIERSZ TRZECI ++++++++++++++++++++++++++++++++++++++++

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button20.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button20.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button20.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button20.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button20.setEnabled(false);
                        button20.setId(720);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button20.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button20.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button20.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button20.setEnabled(false);
                        button20.setId(620);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button20.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button20.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button20.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button20.setEnabled(false);
                        button20.setId(520);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button20.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button20.setBackgroundColor(Color.RED);
                        button20.setEnabled(false);
                        button20.setId(420);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button20.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button20.setBackgroundColor(Color.RED);
                        button20.setEnabled(false);
                        button20.setId(320);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button20.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button20.setBackgroundColor(Color.RED);
                        button20.setEnabled(false);
                        button20.setId(220);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button20.getId() == 120){
                    button20.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button21.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button21.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button21.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button21.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button21.setEnabled(false);
                        button21.setId(721);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(701);
                        }
                    }else if ((button21.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button21.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button21.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button21.setEnabled(false);
                        button21.setId(621);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button21.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button21.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button21.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button21.setEnabled(false);
                        button21.setId(521);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button21.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button21.setBackgroundColor(Color.RED);
                        button21.setEnabled(false);
                        button21.setId(421);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button21.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button21.setBackgroundColor(Color.RED);
                        button21.setEnabled(false);
                        button21.setId(321);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button21.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button21.setBackgroundColor(Color.RED);
                        button21.setEnabled(false);
                        button21.setId(221);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button21.getId() == 121){
                    button21.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button22.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button22.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button22.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button22.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button22.setEnabled(false);
                        button22.setId(722);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button22.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button22.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button22.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button22.setEnabled(false);
                        button22.setId(622);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button22.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button22.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button22.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button22.setEnabled(false);
                        button22.setId(522);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button22.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button22.setBackgroundColor(Color.RED);
                        button22.setEnabled(false);
                        button22.setId(422);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button22.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button22.setBackgroundColor(Color.RED);
                        button22.setEnabled(false);
                        button22.setId(322);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button22.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button22.setBackgroundColor(Color.RED);
                        button22.setEnabled(false);
                        button22.setId(222);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button22.getId() == 122){
                    button22.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button23.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button23.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button23.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button23.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button23.setEnabled(false);
                        button23.setId(723);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button23.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button23.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button23.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button23.setEnabled(false);
                        button23.setId(623);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button23.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button23.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button23.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button23.setEnabled(false);
                        button23.setId(523);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button23.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button23.setBackgroundColor(Color.RED);
                        button23.setEnabled(false);
                        button23.setId(423);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button23.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button23.setBackgroundColor(Color.RED);
                        button23.setEnabled(false);
                        button23.setId(323);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button23.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button23.setBackgroundColor(Color.RED);
                        button23.setEnabled(false);
                        button23.setId(223);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button23.getId() == 123){
                    button23.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button24.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button24.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button24.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button24.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button24.setEnabled(false);
                        button24.setId(724);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button24.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button24.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button24.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button24.setEnabled(false);
                        button24.setId(624);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button24.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button24.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button24.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button24.setEnabled(false);
                        button24.setId(524);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button24.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button24.setBackgroundColor(Color.RED);
                        button24.setEnabled(false);
                        button24.setId(424);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button24.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button24.setBackgroundColor(Color.RED);
                        button24.setEnabled(false);
                        button24.setId(324);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button24.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button24.setBackgroundColor(Color.RED);
                        button24.setEnabled(false);
                        button24.setId(224);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button24.getId() == 124){
                    button24.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });


        //++++++++++++++++++++++++++++++++++++++ WIERSZ CZWARTY ++++++++++++++++++++++++++++++++++


        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button30.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button30.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button30.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button30.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button30.setEnabled(false);
                        button30.setId(730);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button30.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button30.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button30.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button30.setEnabled(false);
                        button30.setId(630);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button30.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button30.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button30.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button30.setEnabled(false);
                        button30.setId(530);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button30.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button30.setBackgroundColor(Color.RED);
                        button30.setEnabled(false);
                        button30.setId(430);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button30.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button30.setBackgroundColor(Color.RED);
                        button30.setEnabled(false);
                        button30.setId(330);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button30.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button30.setBackgroundColor(Color.RED);
                        button30.setEnabled(false);
                        button30.setId(230);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button30.getId() == 130){
                    button30.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button31.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button31.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button31.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button31.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button31.setEnabled(false);
                        button31.setId(731);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(701);
                        }
                    }else if ((button31.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button31.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button31.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button31.setEnabled(false);
                        button31.setId(631);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button31.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button31.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button31.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button31.setEnabled(false);
                        button31.setId(531);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button31.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button31.setBackgroundColor(Color.RED);
                        button31.setEnabled(false);
                        button31.setId(431);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button31.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button31.setBackgroundColor(Color.RED);
                        button31.setEnabled(false);
                        button31.setId(331);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button31.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button31.setBackgroundColor(Color.RED);
                        button31.setEnabled(false);
                        button31.setId(231);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button31.getId() == 131){
                    button31.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button32.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button32.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button32.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button32.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button32.setEnabled(false);
                        button32.setId(732);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button32.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button32.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button32.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button32.setEnabled(false);
                        button32.setId(632);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button32.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button32.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button32.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button32.setEnabled(false);
                        button32.setId(532);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button32.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button32.setBackgroundColor(Color.RED);
                        button32.setEnabled(false);
                        button32.setId(432);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button32.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button32.setBackgroundColor(Color.RED);
                        button32.setEnabled(false);
                        button32.setId(332);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button32.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button32.setBackgroundColor(Color.RED);
                        button32.setEnabled(false);
                        button32.setId(232);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button32.getId() == 132){
                    button32.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button33.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button33.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button33.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button33.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button33.setEnabled(false);
                        button33.setId(733);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button33.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button33.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button33.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button33.setEnabled(false);
                        button33.setId(633);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button33.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button33.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button33.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button33.setEnabled(false);
                        button33.setId(533);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button33.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button33.setBackgroundColor(Color.RED);
                        button33.setEnabled(false);
                        button33.setId(433);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button33.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button33.setBackgroundColor(Color.RED);
                        button33.setEnabled(false);
                        button33.setId(333);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button33.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button33.setBackgroundColor(Color.RED);
                        button33.setEnabled(false);
                        button33.setId(233);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button33.getId() == 133){
                    button33.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button34.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button34.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button34.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button34.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button34.setEnabled(false);
                        button34.setId(734);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button34.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button34.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button34.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button34.setEnabled(false);
                        button34.setId(634);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button34.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button34.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button34.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button34.setEnabled(false);
                        button34.setId(534);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button34.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button34.setBackgroundColor(Color.RED);
                        button34.setEnabled(false);
                        button34.setId(434);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button34.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button34.setBackgroundColor(Color.RED);
                        button34.setEnabled(false);
                        button34.setId(334);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button34.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button34.setBackgroundColor(Color.RED);
                        button34.setEnabled(false);
                        button34.setId(234);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button34.getId() == 134){
                    button34.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });


        // ++++++++++++++++++++++++++++ WIERSZ PIĄTY +++++++++++++++++++++++++++++++++++++++++++

        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button40.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button40.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button40.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button40.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button40.setEnabled(false);
                        button40.setId(740);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button40.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button40.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button40.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button40.setEnabled(false);
                        button40.setId(640);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button40.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button40.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button40.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button40.setEnabled(false);
                        button40.setId(540);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button40.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button40.setBackgroundColor(Color.RED);
                        button40.setEnabled(false);
                        button40.setId(440);
                        battle2Activity.ship1Count--;
                        battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button40.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button40.setBackgroundColor(Color.RED);
                        button40.setEnabled(false);
                        button40.setId(340);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button40.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button40.setBackgroundColor(Color.RED);
                        button40.setEnabled(false);
                        button40.setId(240);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button40.getId() == 140){
                    button40.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button41.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button41.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button41.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button41.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button41.setEnabled(false);
                        button41.setId(741);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(701);
                        }
                    }else if ((button41.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button41.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button41.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button41.setEnabled(false);
                        button41.setId(641);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button41.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button41.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button41.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button41.setEnabled(false);
                        button41.setId(541);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button41.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button41.setBackgroundColor(Color.RED);
                        button41.setEnabled(false);
                        button41.setId(441);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button41.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button41.setBackgroundColor(Color.RED);
                        button41.setEnabled(false);
                        button41.setId(341);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button41.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button41.setBackgroundColor(Color.RED);
                        button41.setEnabled(false);
                        button41.setId(241);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button41.getId() == 141){
                    button41.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button42.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button42.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button42.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button42.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button42.setEnabled(false);
                        button42.setId(742);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button42.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button42.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button42.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button42.setEnabled(false);
                        button42.setId(642);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button42.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button42.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button42.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button42.setEnabled(false);
                        button42.setId(542);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button42.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button42.setBackgroundColor(Color.RED);
                        button42.setEnabled(false);
                        button42.setId(442);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button42.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button42.setBackgroundColor(Color.RED);
                        button42.setEnabled(false);
                        button42.setId(342);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button42.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button42.setBackgroundColor(Color.RED);
                        button42.setEnabled(false);
                        button42.setId(242);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button42.getId() == 142){
                    button42.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button43.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button43.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button43.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button43.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button43.setEnabled(false);
                        button43.setId(743);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button43.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button43.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button43.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button43.setEnabled(false);
                        button43.setId(643);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button43.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button43.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button43.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button43.setEnabled(false);
                        button43.setId(543);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button43.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button43.setBackgroundColor(Color.RED);
                        button43.setEnabled(false);
                        button43.setId(443);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button43.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button43.setBackgroundColor(Color.RED);
                        button43.setEnabled(false);
                        button43.setId(343);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button43.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button43.setBackgroundColor(Color.RED);
                        button43.setEnabled(false);
                        button43.setId(243);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button43.getId() == 143){
                    button43.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i<prepareBattleActivity.ships1.size(); i++) {
                    if ((button44.getId() + 600) == prepareBattleActivity.ships1.get(i).getX() || (button44.getId() + 600) == prepareBattleActivity.ships1.get(i).getY() || (button44.getId() + 600) == ((prepareBattleActivity.ships1.get(i).getX()+prepareBattleActivity.ships1.get(i).getY())/2)){
                        countShip7[0]--;
                        button44.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button44.setEnabled(false);
                        button44.setId(744);
                        if(countShip7[0]==0){
                            battle2Activity.ship3Count = 0;battle2Activity.buttonShip3.setText(String.valueOf(battle2Activity.ship3Count));
                            sinkShip(700);
                        }
                    }else if ((button44.getId() + 500) == prepareBattleActivity.ships1.get(i).getX() || (button44.getId() + 500) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip6[0]--;
                        button44.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button44.setEnabled(false);
                        button44.setId(644);
                        if(countShip6[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(600);
                        }
                    }else if ((button44.getId() + 400) == prepareBattleActivity.ships1.get(i).getX() || (button44.getId() + 400) == prepareBattleActivity.ships1.get(i).getY()){
                        countShip5[0]--;
                        button44.setBackgroundColor(Color.parseColor("#FFFF8800"));
                        button44.setEnabled(false);
                        button44.setId(544);
                        if(countShip5[0]==0){
                            battle2Activity.ship2Count--;battle2Activity.buttonShip2.setText(String.valueOf(battle2Activity.ship2Count));
                            sinkShip(500);
                        }
                    }else if (button44.getId() + 300 == prepareBattleActivity.ships1.get(i).getX()){
                        button44.setBackgroundColor(Color.RED);
                        button44.setEnabled(false);
                        button44.setId(444);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button44.getId() + 200 == prepareBattleActivity.ships1.get(i).getX()) {
                        button44.setBackgroundColor(Color.RED);
                        button44.setEnabled(false);
                        button44.setId(344);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }else if (button44.getId() + 100 == prepareBattleActivity.ships1.get(i).getX()) {
                        button44.setBackgroundColor(Color.RED);
                        button44.setEnabled(false);
                        button44.setId(244);
                        battle2Activity.ship1Count--;battle2Activity.buttonShip1.setText(String.valueOf(battle2Activity.ship1Count));
                    }
                }
                if(button44.getId() == 144){
                    button44.setEnabled(false);
                    builder.setMessage("Pudło! Przekaż telefon graczowi nr1")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                    startActivity(intent);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();

                }
            }
        });

    }

    public void sinkShip(int value){
        AlertDialog.Builder builder = new AlertDialog.Builder(battleActivity.this);
        if(battle2Activity.ship1Count == 0 && battle2Activity.ship2Count == 0 && battle2Activity.ship3Count == 0){
            gameOver = 1;
            builder.setMessage("Zatopiłeś wszystkie statki przeciwnika. Wygrywa gracz nr2!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            Intent intent = new Intent(battleActivity.this, battle2Activity.class);
                            startActivity(intent);
                            finish();

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        if(button00.getId() >= value){
           button00.setBackgroundColor(Color.RED);
        }
        if(button01.getId() >= value){
            button01.setBackgroundColor(Color.RED);
        }
        if(button02.getId() >= value){
            button02.setBackgroundColor(Color.RED);
        }
        if(button03.getId() >= value){
            button03.setBackgroundColor(Color.RED);
        }
        if(button04.getId() >= value){
            button04.setBackgroundColor(Color.RED);
        }
        if(button10.getId() >= value){
            button10.setBackgroundColor(Color.RED);
        }
        if(button11.getId() >= value){
            button11.setBackgroundColor(Color.RED);
        }
        if(button12.getId() >= value){
            button12.setBackgroundColor(Color.RED);
        }
        if(button13.getId() >= value){
            button13.setBackgroundColor(Color.RED);
        }
        if(button14.getId() >= value){
            button14.setBackgroundColor(Color.RED);
        }
        if(button20.getId() >= value){
            button20.setBackgroundColor(Color.RED);
        }
        if(button21.getId() >= value){
            button21.setBackgroundColor(Color.RED);
        }
        if(button22.getId() >= value){
            button22.setBackgroundColor(Color.RED);
        }
        if(button23.getId() >= value){
            button23.setBackgroundColor(Color.RED);
        }
        if(button24.getId() >= value){
            button24.setBackgroundColor(Color.RED);
        }
        if(button30.getId() >= value){
            button30.setBackgroundColor(Color.RED);
        }
        if(button31.getId() >= value){
            button31.setBackgroundColor(Color.RED);
        }
        if(button32.getId() >= value){
            button32.setBackgroundColor(Color.RED);
        }
        if(button33.getId() >= value){
            button33.setBackgroundColor(Color.RED);
        }
        if(button34.getId() >= value){
            button34.setBackgroundColor(Color.RED);
        }
        if(button40.getId() >= value){
            button40.setBackgroundColor(Color.RED);
        }
        if(button41.getId() >= value){
            button41.setBackgroundColor(Color.RED);
        }
        if(button42.getId() >= value){
            button42.setBackgroundColor(Color.RED);
        }
        if(button43.getId() >= value){
            button43.setBackgroundColor(Color.RED);
        }
        if(button44.getId() >= value){
            button44.setBackgroundColor(Color.RED);
        }
    }
}
