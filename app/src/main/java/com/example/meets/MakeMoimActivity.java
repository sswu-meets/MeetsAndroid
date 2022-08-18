package com.example.meets;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MakeMoimActivity extends AppCompatActivity {

    private static final String TAG = "activity_makemoim";

    private TextView tvGood1;
    private TextView tvGood2;
    private TextView tvGood3;

    private Button btnGood1;
    private Button btnGood2;
    private Button btnGood3;

    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makemoim);

        Intent intent = getIntent();
        String schedule = intent.getStringExtra("schedule");
        String place1 = intent.getStringExtra("place1");
        String place2 = intent.getStringExtra("place2");
        String place3 = intent.getStringExtra("place3");
        String todo1 = intent.getStringExtra("todo1");
        String todo2 = intent.getStringExtra("todo2");
        String todo3 = intent.getStringExtra("todo3");
        String todo4 = intent.getStringExtra("todo4");


        TextView txt_schedule = findViewById(R.id.txt_schedule);
        txt_schedule.setText(schedule);
        TextView txt_place1 = findViewById(R.id.txt_place1);
        txt_place1.setText(place1);
        TextView txt_place2 = findViewById(R.id.txt_place2);
        txt_place2.setText(place2);
        TextView txt_place3 = findViewById(R.id.txt_place3);
        txt_place3.setText(place3);

        TextView txt_todo1 = findViewById(R.id.todo1);
        txt_todo1.setText(todo1);
        TextView txt_todo2 = findViewById(R.id.todo2);
        txt_todo2.setText(todo2);
        TextView txt_todo3 = findViewById(R.id.todo3);
        txt_todo3.setText(todo3);
        TextView txt_todo4 = findViewById(R.id.todo4);
        txt_todo4.setText(todo4);

        Button moveback = findViewById(R.id.pre_page_btn);

        Button btn_plusPeople = (Button) findViewById(R.id.btn_PlusPeople);
        btn_plusPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WeekChooseActivity.class);
                startActivity(intent);
            }
        });

        Spinner spinner = findViewById(R.id.spn_Make);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.make, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                if (text.equals("편집")) {
                    String place1 = txt_place1.getText().toString();
                    String place2 = txt_place2.getText().toString();
                    String place3 = txt_place3.getText().toString();
                    String schedule = txt_schedule.getText().toString();
                    String todo1 = txt_todo1.getText().toString();
                    String todo2 = txt_todo2.getText().toString();
                    String todo3 = txt_todo3.getText().toString();
                    String todo4 = txt_todo4.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), ChangeMoimActivity.class);
                    intent.putExtra("schedule", schedule);
                    intent.putExtra("place1", place1);
                    intent.putExtra("place2", place2);
                    intent.putExtra("place3", place3);
                    intent.putExtra("todo1", todo1);
                    intent.putExtra("todo2", todo2);
                    intent.putExtra("todo3", todo3);
                    intent.putExtra("todo4", todo4);
                    startActivity(intent);
                }
                Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tvGood1 = findViewById(R.id.tv_good1);
        tvGood2 = findViewById(R.id.tv_good2);
        tvGood3 = findViewById(R.id.tv_good3);
        tvGood1.setText(count1 + "");
        tvGood2.setText(count2 + "");
        tvGood3.setText(count3 + "");
        btnGood1 = findViewById(R.id.btn_good1);
        btnGood2 = findViewById(R.id.btn_good2);
        btnGood3 = findViewById(R.id.btn_good3);

        btnGood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: btnGood1 : " + view.getClass().getName());
                count1++;
                tvGood1.setText(count1 + "");
            }
        });

        btnGood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: btnGood1 : " + view.getClass().getName());
                count2++;
                tvGood2.setText(count2 + "");
            }
        });

        btnGood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: btnGood1 : " + view.getClass().getName());
                count3++;
                tvGood3.setText(count3 + "");
            }
        });

    }
}