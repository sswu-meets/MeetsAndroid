package com.example.meets;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;

import java.io.Serializable;

public class WeekChooseActivity extends AppCompatActivity implements Serializable {
    TimePickerDialog.OnTimeSetListener time_start;
    TimePickerDialog.OnTimeSetListener time_finish;
    Button btn_start;
    Button btn_finish;
    TextView tv_start;
    TextView tv_finish;
    SwitchCompat switchOnOff;
    TextView tvSwitchYes;
    TextView tvSwitchNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekchoose);
        switchOnOff = findViewById(R.id.switchOnOff);
        tvSwitchYes = findViewById(R.id.tvSwitchYes);
        tvSwitchNo = findViewById(R.id.tvSwitchNo);

        switchOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                int white = ContextCompat.getColor(getApplicationContext(), R.color.white);
                int black = ContextCompat.getColor(getApplicationContext(), R.color.black);

                if(isChecked){
                    tvSwitchYes.setTextColor(black);
                    tvSwitchNo.setTextColor(white);
                }else{
                    tvSwitchYes.setTextColor(white);
                    tvSwitchNo.setTextColor(black);
                }
            }
        });
        tv_start = findViewById(R.id.tv_start_time);
        tv_finish = findViewById(R.id.tv_finish_time);

        time_start = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                tv_start.setText(h + "시" + m + "분");
            }
        };
        btn_start = findViewById(R.id.btn_start_time);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog time_dialog_start = new TimePickerDialog(WeekChooseActivity.this, android.R.style.Theme_Holo_Light_Dialog, time_start, 10, 00, true);
                time_dialog_start.show();
            }
        });

        time_finish = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                tv_finish.setText(h + "시" + m + "분");
            }
        };
        btn_finish = findViewById(R.id.btn_finish_time);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog time_dialog_end = new TimePickerDialog(WeekChooseActivity.this,android.R.style.Theme_Holo_Light_Dialog, time_finish, 20, 00, true);
                time_dialog_end.show();
            }
        });

    }
}
