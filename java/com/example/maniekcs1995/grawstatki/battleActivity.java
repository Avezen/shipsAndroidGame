package com.example.maniekcs1995.grawstatki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class battleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);



        Toast.makeText(battleActivity.this, "Statek nr1: " +String.valueOf(prepareBattleActivity.ships1.get(0).getX()) + String.valueOf(prepareBattleActivity.ships1.get(0).getY())
                + "Statek nr2: " +String.valueOf(prepareBattleActivity.ships1.get(1).getX()) + String.valueOf(prepareBattleActivity.ships1.get(1).getY())
                + "Statek nr3: " +String.valueOf(prepareBattleActivity.ships1.get(2).getX()) + String.valueOf(prepareBattleActivity.ships1.get(2).getY())
                , Toast.LENGTH_SHORT).show();
    }
}
