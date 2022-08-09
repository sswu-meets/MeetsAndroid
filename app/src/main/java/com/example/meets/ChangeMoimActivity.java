package com.example.meets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChangeMoimActivity extends AppCompatActivity {
    EditText txt_place;
    LinearLayout listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changemoim);

        Button btn_finish = (Button) findViewById(R.id.btn_finish);
        Button btn_todo = (Button) findViewById(R.id.btn_todo);
        Button btn_place = findViewById(R.id.btn_place);
        EditText txt_schedule = findViewById(R.id.txt_schedule);
        EditText txt_todo = findViewById(R.id.txt_todo);


        txt_place = findViewById(R.id.txt_place);
        listView = findViewById(R.id.layout_place);


        final ArrayList<String> arrayList = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String place = txt_place.getText().toString();
                String schedule = txt_schedule.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MakeMoimActivity.class);
                intent.putExtra("schedule", schedule);
                intent.putExtra("place", place);
                startActivity(intent);
            }
        });

        btn_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTextView();
            }
        });
    }

    private void createTextView() {
        TextView textViewN = new TextView(getApplicationContext());
        textViewN.setText(txt_place.getText());
        textViewN.setTextSize(12);
        //textViewN.setTypeface(null, );
        textViewN.setId(0);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        param.leftMargin = 30;

        textViewN.setLayoutParams(param);
        listView.addView(textViewN);

    }
}
