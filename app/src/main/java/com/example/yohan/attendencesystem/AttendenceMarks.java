package com.example.yohan.attendencesystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AttendenceMarks extends AppCompatActivity {

    DatabaseReference mDatabase;
    DatabaseReference mDatabase1;
    FirebaseAuth mAuth;
    static String course,year;


    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18,textView19,textView20,textView21,textView22,textView23,textView24,textView25,textView26,textView27,textView28,textView29,textView30;
    TextView textView31,textView32,textView33,textView34,textView35,textView36,textView37,textView38,textView39,textView40,textView41,textView42,textView43,textView44,textView45,textView46,textView47,textView48,textView49,textView50,textView51,textView52,textView53,textView54,textView55,textView56,textView57,textView58,textView59,textView60;
    TextView textView61,textView62,textView63,textView64,textView65,textView66,textView67,textView68,textView69,textView70,textView71,textView72,textView73,textView74,textView75,textView76,textView77,textView78,textView79,textView80,textView81,textView82,textView83,textView84,textView85,textView86,textView87,textView88,textView89,textView90;
    TextView textView91,textView92,textView93,textView94,textView95,textView96,textView97,textView98,textView99,textView100,textView101,textView102;

    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,checkBox23,checkBox24,checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30,checkBox31,checkBox32,checkBox33,checkBox34,checkBox35,checkBox36,checkBox37,checkBox38,checkBox39,checkBox40;
    CheckBox checkBox41,checkBox42,checkBox43,checkBox44,checkBox45,checkBox46,checkBox47,checkBox48,checkBox49,checkBox50,checkBox51,checkBox52,checkBox53,checkBox54,checkBox55,checkBox56,checkBox57,checkBox58,checkBox59,checkBox60,checkBox61,checkBox62,checkBox63,checkBox64,checkBox65,checkBox66,checkBox67,checkBox68,checkBox69,checkBox70,checkBox71,checkBox72,checkBox73,checkBox74,checkBox75,checkBox76,checkBox77,checkBox78,checkBox79,checkBox80,checkBox81,checkBox82,checkBox83,checkBox84,checkBox85,checkBox86,checkBox87,checkBox88,checkBox89,checkBox90,checkBox91,checkBox92,checkBox93,checkBox94,checkBox95,checkBox96,checkBox97,checkBox98,checkBox99,checkBox100,checkBox101,checkBox102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_marks);

        textView1 = findViewById(R.id.textView4);
        textView2 = findViewById(R.id.textView5);
        textView3 = findViewById(R.id.textView6);
        textView4 = findViewById(R.id.textView7);
        textView5 = findViewById(R.id.textView8);
        textView6 = findViewById(R.id.textView9);
        textView7 = findViewById(R.id.textView10);
        textView8 = findViewById(R.id.textView11);
        textView9 = findViewById(R.id.textView12);
        textView10 = findViewById(R.id.textView13);
        textView11 = findViewById(R.id.textView14);
        textView12 = findViewById(R.id.textView15);
        textView13 = findViewById(R.id.textView16);
        textView14 = findViewById(R.id.textView17);
        textView15 = findViewById(R.id.textView18);
        textView16 = findViewById(R.id.textView19);
        textView17 = findViewById(R.id.textView20);
        textView18 = findViewById(R.id.textView21);
        textView19 = findViewById(R.id.textView22);
        textView20 = findViewById(R.id.textView23);
        textView21 = findViewById(R.id.textView24);
        textView22 = findViewById(R.id.textView25);
        textView23 = findViewById(R.id.textView26);
        textView24 = findViewById(R.id.textView27);
        textView25 = findViewById(R.id.textView28);
        textView26 = findViewById(R.id.textView29);
        textView27 = findViewById(R.id.textView30);
        textView28 = findViewById(R.id.textView31);
        textView29 = findViewById(R.id.textView32);
        textView30 = findViewById(R.id.textView33);
        textView31 = findViewById(R.id.textView34);
        textView32 = findViewById(R.id.textView35);
        textView33 = findViewById(R.id.textView36);
        textView34 = findViewById(R.id.textView37);
        textView35 = findViewById(R.id.textView38);
        textView36 = findViewById(R.id.textView39);
        textView37 = findViewById(R.id.textView40);
        textView38 = findViewById(R.id.textView41);
        textView39 = findViewById(R.id.textView42);
        textView40 = findViewById(R.id.textView43);
        textView41 = findViewById(R.id.textView44);
        textView42 = findViewById(R.id.textView45);
        textView43 = findViewById(R.id.textView46);
        textView44 = findViewById(R.id.textView47);
        textView45 = findViewById(R.id.textView48);
        textView46 = findViewById(R.id.textView49);
        textView47 = findViewById(R.id.textView50);
        textView48 = findViewById(R.id.textView51);
        textView49 = findViewById(R.id.textView52);
        textView50 = findViewById(R.id.textView53);
        textView51 = findViewById(R.id.textView54);
        textView52 = findViewById(R.id.textView55);
        textView53 = findViewById(R.id.textView56);
        textView54 = findViewById(R.id.textView57);
        textView55 = findViewById(R.id.textView58);
        textView56 = findViewById(R.id.textView59);
        textView57 = findViewById(R.id.textView60);
        textView58 = findViewById(R.id.textView61);
        textView59 = findViewById(R.id.textView62);
        textView60 = findViewById(R.id.textView63);
        textView61 = findViewById(R.id.textView64);
        textView62 = findViewById(R.id.textView65);
        textView63 = findViewById(R.id.textView66);
        textView64 = findViewById(R.id.textView67);
        textView65 = findViewById(R.id.textView68);
        textView66 = findViewById(R.id.textView69);
        textView67 = findViewById(R.id.textView70);
        textView68 = findViewById(R.id.textView71);
        textView69 = findViewById(R.id.textView72);
        textView70 = findViewById(R.id.textView73);
        textView71 = findViewById(R.id.textView74);
        textView72 = findViewById(R.id.textView75);
        textView73 = findViewById(R.id.textView76);
        textView74 = findViewById(R.id.textView77);
        textView75 = findViewById(R.id.textView78);
        textView76 = findViewById(R.id.textView79);
        textView77 = findViewById(R.id.textView80);
        textView78 = findViewById(R.id.textView81);
        textView79 = findViewById(R.id.textView82);
        textView80 = findViewById(R.id.textView83);
        textView81 = findViewById(R.id.textView84);
        textView82 = findViewById(R.id.textView85);
        textView83 = findViewById(R.id.textView86);
        textView84 = findViewById(R.id.textView87);
        textView85 = findViewById(R.id.textView88);
        textView86 = findViewById(R.id.textView89);
        textView87 = findViewById(R.id.textView90);
        textView88 = findViewById(R.id.textView91);
        textView89 = findViewById(R.id.textView92);
        textView90 = findViewById(R.id.textView93);
        textView91 = findViewById(R.id.textView94);
        textView92 = findViewById(R.id.textView95);
        textView93 = findViewById(R.id.textView96);
        textView94 = findViewById(R.id.textView97);
        textView95 = findViewById(R.id.textView98);
        textView96 = findViewById(R.id.textView99);
        textView97 = findViewById(R.id.textView100);
        textView98 = findViewById(R.id.textView101);
        textView99 = findViewById(R.id.textView102);
        textView100 = findViewById(R.id.textView103);
        textView101 = findViewById(R.id.textView104);
        textView102 = findViewById(R.id.textView105);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox10 = findViewById(R.id.checkBox10);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox12 = findViewById(R.id.checkBox12);
        checkBox13 = findViewById(R.id.checkBox13);
        checkBox14 = findViewById(R.id.checkBox14);
        checkBox15 = findViewById(R.id.checkBox15);
        checkBox16 = findViewById(R.id.checkBox16);
        checkBox17 = findViewById(R.id.checkBox17);
        checkBox18 = findViewById(R.id.checkBox18);
        checkBox19 = findViewById(R.id.checkBox19);
        checkBox20 = findViewById(R.id.checkBox20);
        checkBox21 = findViewById(R.id.checkBox21);
        checkBox22 = findViewById(R.id.checkBox22);
        checkBox23 = findViewById(R.id.checkBox23);
        checkBox24 = findViewById(R.id.checkBox24);
        checkBox25 = findViewById(R.id.checkBox25);
        checkBox26 = findViewById(R.id.checkBox26);
        checkBox27 = findViewById(R.id.checkBox27);
        checkBox28 = findViewById(R.id.checkBox28);
        checkBox29 = findViewById(R.id.checkBox29);
        checkBox30 = findViewById(R.id.checkBox30);
        checkBox31 = findViewById(R.id.checkBox31);
        checkBox32 = findViewById(R.id.checkBox32);
        checkBox33 = findViewById(R.id.checkBox33);
        checkBox34 = findViewById(R.id.checkBox34);
        checkBox35 = findViewById(R.id.checkBox35);
        checkBox36 = findViewById(R.id.checkBox36);
        checkBox37 = findViewById(R.id.checkBox37);
        checkBox38 = findViewById(R.id.checkBox38);
        checkBox39 = findViewById(R.id.checkBox39);
        checkBox40 = findViewById(R.id.checkBox40);
        checkBox41 = findViewById(R.id.checkBox41);
        checkBox42 = findViewById(R.id.checkBox42);
        checkBox43 = findViewById(R.id.checkBox43);
        checkBox44 = findViewById(R.id.checkBox44);
        checkBox45 = findViewById(R.id.checkBox45);
        checkBox46 = findViewById(R.id.checkBox46);
        checkBox47 = findViewById(R.id.checkBox47);
        checkBox48 = findViewById(R.id.checkBox48);
        checkBox49 = findViewById(R.id.checkBox49);
        checkBox50 = findViewById(R.id.checkBox50);
        checkBox51 = findViewById(R.id.checkBox51);
        checkBox52 = findViewById(R.id.checkBox52);
        checkBox53 = findViewById(R.id.checkBox53);
        checkBox54 = findViewById(R.id.checkBox54);
        checkBox55 = findViewById(R.id.checkBox55);
        checkBox56 = findViewById(R.id.checkBox56);
        checkBox57 = findViewById(R.id.checkBox57);
        checkBox58 = findViewById(R.id.checkBox58);
        checkBox59 = findViewById(R.id.checkBox59);
        checkBox60 = findViewById(R.id.checkBox60);
        checkBox61 = findViewById(R.id.checkBox61);
        checkBox62 = findViewById(R.id.checkBox62);
        checkBox63 = findViewById(R.id.checkBox63);
        checkBox64 = findViewById(R.id.checkBox64);
        checkBox65 = findViewById(R.id.checkBox65);
        checkBox66 = findViewById(R.id.checkBox66);
        checkBox67 = findViewById(R.id.checkBox67);
        checkBox68 = findViewById(R.id.checkBox68);
        checkBox69 = findViewById(R.id.checkBox69);
        checkBox70 = findViewById(R.id.checkBox70);
        checkBox71 = findViewById(R.id.checkBox71);
        checkBox72 = findViewById(R.id.checkBox72);
        checkBox73 = findViewById(R.id.checkBox73);
        checkBox74 = findViewById(R.id.checkBox74);
        checkBox75 = findViewById(R.id.checkBox75);
        checkBox76 = findViewById(R.id.checkBox76);
        checkBox77 = findViewById(R.id.checkBox77);
        checkBox78 = findViewById(R.id.checkBox78);
        checkBox79 = findViewById(R.id.checkBox79);
        checkBox80 = findViewById(R.id.checkBox80);
        checkBox81 = findViewById(R.id.checkBox81);
        checkBox82 = findViewById(R.id.checkBox82);
        checkBox83 = findViewById(R.id.checkBox83);
        checkBox84 = findViewById(R.id.checkBox84);
        checkBox85 = findViewById(R.id.checkBox85);
        checkBox86 = findViewById(R.id.checkBox86);
        checkBox87 = findViewById(R.id.checkBox87);
        checkBox88 = findViewById(R.id.checkBox88);
        checkBox89 = findViewById(R.id.checkBox89);
        checkBox90 = findViewById(R.id.checkBox90);
        checkBox91 = findViewById(R.id.checkBox91);
        checkBox92 = findViewById(R.id.checkBox92);
        checkBox93 = findViewById(R.id.checkBox93);
        checkBox94 = findViewById(R.id.checkBox94);
        checkBox95 = findViewById(R.id.checkBox95);
        checkBox96 = findViewById(R.id.checkBox96);
        checkBox97 = findViewById(R.id.checkBox97);
        checkBox98 = findViewById(R.id.checkBox98);
        checkBox99 = findViewById(R.id.checkBox99);
        checkBox100 = findViewById(R.id.checkBox100);
        checkBox101 = findViewById(R.id.checkBox101);
        checkBox102 = findViewById(R.id.checkBox102);





        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        String id = user.getUid();


        mDatabase1 = FirebaseDatabase.getInstance().getReference("Users").child(id);

        mDatabase1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 course = dataSnapshot.child("course").getValue().toString();
                 year = dataSnapshot.child("year").getValue().toString();

                if(course.equals("CIS") && year.equals("2.2")){
                    mDatabase = FirebaseDatabase.getInstance().getReference("CIS").child("2_2");
                    mDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String APC2366 = dataSnapshot.child("15APC2366").getValue().toString();
                            
                            textView1.setText(APC2366);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {


                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}
