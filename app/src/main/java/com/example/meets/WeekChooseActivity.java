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

public class WeekChooseActivity extends AppCompatActivity {
    private TextView textView_Date;
    private TimePickerDialog.OnTimeSetListener callbackMethod;
    private Button btn_start;
    private Button btn_finish;
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

        this.InitialiseView();
        this.InitializeListener();
        btn_start = (Button)findViewById(R.id.btn_start_time);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickHandler(view);
            }
        });

        btn_finish = (Button)findViewById(R.id.btn_finish_time);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickHandler(view);
            }
        });

    }

    private void InitializeListener() {
        callbackMethod = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                textView_Date.setText(h + "시" + m + "분");
            }
        };
    }

    private void InitialiseView() {
        textView_Date = (TextView) findViewById(R.id.textview_date);
    }

    public void OnClickHandler(View view) {
        TimePickerDialog dialog = new TimePickerDialog(this, callbackMethod, 8, 10, true);
        dialog.show();
    }
}
