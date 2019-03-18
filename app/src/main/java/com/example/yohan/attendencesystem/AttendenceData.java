package com.example.yohan.attendencesystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

public class AttendenceData extends AppCompatActivity {

    ImageButton btnNext;
    DatabaseReference mDatabase1,mDatabase2,mDatabase3;
    FirebaseAuth mAuth;
    TextView tvTime;
    Spinner sp_time;
    EditText etLec,etLecName,etRemarks;
    CheckBox checkMid,checkQuiz;
    String mid,quiz;
    static String course,year;

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

        tvTime.setText(datetime+"");
     //   mFirebase1 = FirebaseDatabase.getInstance().getReference("Databases").child(datetime);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        String id = user.getUid();


        mDatabase1 = FirebaseDatabase.getInstance().getReference("Users").child(id);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        course = dataSnapshot.child("course").getValue().toString();
                        year = dataSnapshot.child("year").getValue().toString();
                        if(course.equals("CIS") && year.equals("2.2")){
                            mDatabase2 = FirebaseDatabase.getInstance().getReference("Attendence_Database").child("2_2_CIS").child(datetime);

                            HashMap<String,String> AttendData = new HashMap<>();
                            AttendData.put("Date",datetime);
                            AttendData.put("Lec_Period",period);
                            AttendData.put("Lecture",lec);
                            AttendData.put("Lecturer_Name",lecName);
                            AttendData.put("mid",mid);
                            AttendData.put("Quiz",quiz);
                            AttendData.put("Remarks",remarks);
                            mDatabase2.setValue(AttendData).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(AttendenceData.this,"Successfully added",Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(AttendenceData.this,"Error!",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            Intent i = new Intent(AttendenceData.this,AttendenceMarks.class);
                            startActivity(i);


                        }else if(course.equals("PST") && year.equals("2.2")){
                            mDatabase3 = FirebaseDatabase.getInstance().getReference("Attendence_Database").child("2_2_PST").child(datetime);

                            HashMap<String,String> AttendData = new HashMap<>();
                            AttendData.put("Date",datetime);
                            AttendData.put("Lec_Period",period);
                            AttendData.put("Lecture",lec);
                            AttendData.put("Lecturer_Name",lecName);
                            AttendData.put("mid",mid);
                            AttendData.put("Quiz",quiz);
                            AttendData.put("Remarks",remarks);
                            mDatabase3.setValue(AttendData).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(AttendenceData.this,"Successfully added",Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(AttendenceData.this,"Error!",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            Intent i = new Intent(AttendenceData.this,AttendenceMarks.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


//                Intent i = new Intent(AttendenceData.this,AttendenceMarks.class);
//                i.putExtra("time",datetime);
//                i.putExtra("timeperiod",period);
//                i.putExtra("lecturer",lec);
//                i.putExtra("lecName",lecName);
//                i.putExtra("mid",mid);
//                i.putExtra("quiz",quiz);
//                i.putExtra("remarks",remarks);
//                startActivity(i);
//                tvTime.setText("");
//                etLec.setText("");
//                etLecName.setText("");
//                checkMid.setChecked(false);
//                checkQuiz.setChecked(false);
//                etRemarks.setText("");
            }
        });

    }

}
