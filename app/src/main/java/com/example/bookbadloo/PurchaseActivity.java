package com.example.bookbadloo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class PurchaseActivity extends AppCompatActivity {

    TextView BacktoHome, costofone, costofmany;
    ImageView bookImg;
    TextView value;
    int count = 1;
    HospitalsModel hospitalsModel;
    Intent intent;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        value = findViewById(R.id.value);
        bookImg = findViewById(R.id.book);
        costofone = findViewById(R.id.costofone);
        costofmany = findViewById(R.id.costofmany);
        intent = getIntent();

        if(intent!=null){
            hospitalsModel= (HospitalsModel) intent.getSerializableExtra("data");
            bookImg.setImageResource(hospitalsModel.getHname());
            costofone.setText(hospitalsModel.getHstate());
            costofmany.setText(hospitalsModel.getHstate());
        }

        toolbar = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getSupportActionBar().setTitle(hospitalsModel.getHlocation());


//        BacktoHomeImg = findViewById(R.id.sushrutaHomeImgg);
        BacktoHome = findViewById(R.id.sushrutaHomee);

        BacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PurchaseActivity.this, HomeActivity.class));
            }
        });

//        BacktoHomeImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SelectedHospitalActivity.this, NavdrawerActivity.class));
//            }
//        });



//        tvSelectedHospitalNum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:"+hospitalsModel.getHnum()));
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu_2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if(itemId==R.id.rate){
            Uri uri = Uri.parse("https://notto.mohfw.gov.in/");
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        } else if (itemId==R.id.exit) {

            AlertDialog.Builder builder= new AlertDialog.Builder(PurchaseActivity.this);
            builder.setTitle("Exit");
            builder.setMessage("Are you sure you want to exit the application ? ");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finishAffinity();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        } else if (itemId==android.R.id.home) {
            super.onBackPressed();
        }
        else{

        }
        return super.onOptionsItemSelected(item);
    }



    public void increment(View v){
        count++;
        value.setText(""+count);
    }

    public void decrement(View v){
        if(count<=0) count = 0;
        else count--;
        value.setText(""+count);
    }

}