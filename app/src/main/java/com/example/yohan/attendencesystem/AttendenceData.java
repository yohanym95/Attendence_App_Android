package com.example.yohan.attendencesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class AttendenceData extends AppCompatActivity {

    ImageButton btnNext;
    DatabaseReference mFirebase;
    FirebaseAuth mAuth;
    TextView tvTime;
    Spinner sp_time;
    EditText etLec,etLecName,etRemarks;
    CheckBox checkMid,checkQuiz;
    String mid,quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_attendence_data);
        tvTime = findViewById(R.id.tvTime);
        sp_time = findViewById(R.id.spinnertime);
        etLec = findViewById(R.id.etLec);
        etLecName = findViewById(R.id.etLecName);
        checkMid = findViewById(R.id.checkbox_mid);
        checkQuiz = findViewById(R.id.checkbox_quiz);
        etRemarks = findViewById(R.id.etRemarks);
        btnNext = findViewById(R.id.btnNext);

        mFirebase = FirebaseDatabase.getInstance().getReference("Users");

        if(checkMid.isChecked()){
            mid = "Mid : yes";
        }else{
            mid = "Mid : No";
        }
        if(checkQuiz.isChecked()){
            quiz = "Quiz : yes";
        }else{
            quiz= "Quiz : yes";
        }

        final String period = sp_time.getSelectedItem().toString();

        final String lec = etLec.getText().toString();
        final String lecName = etLecName.getText().toString();
        final String remarks = etRemarks.getText().toString();



        final String  datetime = DateFormat.getDateTimeInstance()
                .format(new Date());
        tvTime.setText(datetime);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AttendenceData.this,AttendenceMarks.class);
                i.putExtra("time",datetime);
                i.putExtra("timeperiod",period);
                i.putExtra("lecturer",lec);
                i.putExtra("lecName",lecName);
                i.putExtra("mid",mid);
                i.putExtra("quiz",quiz);
                i.putExtra("remarks",remarks);
                startActivity(i);
            }
        });

    }

}
