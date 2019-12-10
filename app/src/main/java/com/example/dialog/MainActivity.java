package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder adb;
    AlertDialog ad;
    LinearLayout ll;
    int[] colors;
    String[] colorname ={"Red", "Green", "Blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.ll);

    }


    public void RorGorB(View view) {
        colors = new int[]{0, 0, 0};
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Single Choice");
        adb.setItems(colorname, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                colors[which] = 255;
                ll.setBackgroundColor(Color.rgb(colors[0], colors[1], colors[2]));
            }

        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad = adb.create();
        ad.show();

    }


    public void RGB(View view) {
        colors = new int[]{0, 0, 0};
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Multi Choice");
        adb.setCancelable(false);
        adb.setMultiChoiceItems(colorname, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                colors[which] = 255;
            }
        });
        adb.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(colors[0], colors[1], colors[2]));
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        ad = adb.create();
        ad.show();
    }



    public void Reset(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Reset Dialog");
        adb.setCancelable(false);
        adb.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.WHITE);
            }
        });
        ad = adb.create();
        ad.show();
    }


    public void showToast(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Toast");
        adb.setCancelable(false);
        final EditText et = new EditText(this);
        et.setHint("Type text here");
        adb.setView(et);
        adb.setPositiveButton("Toast", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = et.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        ad = adb.create();
        ad.show();

    }

    public void creds(View view) {
        Intent si = new Intent(this,Creds.class);
        startActivity(si);
    }
}
