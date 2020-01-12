package com.example.fuelapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.fuelapp.Models.GassStation;

import java.util.List;

import static com.example.fuelapp.Helpers.GassStationDB.getGassStations;

public class GassStationActivity extends AppCompatActivity {
    private GassStation station;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gass_station);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;
        initStation();
        ((TextView)findViewById(R.id.txtName)).setText(station.getName());
        ((TextView)findViewById(R.id.txtAddress)).setText(station.getAddress());



        GridLayout grid = findViewById(R.id.gridStations);
        int childCount = grid.getChildCount();

        for (int i= 0; i < childCount; i++){
            AppCompatButton btn = (AppCompatButton) grid.getChildAt(i);
            btn.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    startActivity(new Intent(context, ServiceActivity.class));
                }
            });
        }




    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

    private void initStation() {
        long id = getIntent().getLongExtra("id", -1);

        List<GassStation> stations = getGassStations();
        for (GassStation s : stations) {
            if (s.getId() == id) {
                station = s;
            }
        }
    }
}
