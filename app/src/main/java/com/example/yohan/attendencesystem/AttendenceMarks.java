package com.example.yohan.attendencesystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
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

    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6,linearLayout7,linearLayout8,linearLayout9,linearLayout10,linearLayout11,linearLayout12,linearLayout13,linearLayout14,linearLayout15,linearLayout16,linearLayout17,linearLayout18,linearLayout19,linearLayout20,linearLayout21,linearLayout22,linearLayout23,linearLayout24,linearLayout25,linearLayout26,linearLayout27,linearLayout28,linearLayout29,linearLayout30,linearLayout31,linearLayout32,linearLayout33,linearLayout34;




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


        linearLayout1 = findViewById(R.id.lin1);
        linearLayout2 = findViewById(R.id.lin2);
        linearLayout3 = findViewById(R.id.lin3);
        linearLayout4 = findViewById(R.id.lin4);
        linearLayout5 = findViewById(R.id.lin5);
        linearLayout6 = findViewById(R.id.lin6);
        linearLayout7 = findViewById(R.id.lin7);
        linearLayout8 = findViewById(R.id.lin8);
        linearLayout9 = findViewById(R.id.lin9);
        linearLayout10 = findViewById(R.id.lin10);
        linearLayout11 = findViewById(R.id.lin11);
        linearLayout12 = findViewById(R.id.lin12);
        linearLayout13 = findViewById(R.id.lin13);
        linearLayout14 = findViewById(R.id.lin14);
        linearLayout15 = findViewById(R.id.lin15);
        linearLayout16 = findViewById(R.id.lin16);
        linearLayout17 = findViewById(R.id.lin17);
        linearLayout18 = findViewById(R.id.lin18);
        linearLayout19 = findViewById(R.id.lin19);
        linearLayout20 = findViewById(R.id.lin20);
        linearLayout21 = findViewById(R.id.lin21);
        linearLayout22 = findViewById(R.id.lin22);
        linearLayout23 = findViewById(R.id.lin23);
        linearLayout24 = findViewById(R.id.lin24);
        linearLayout25 = findViewById(R.id.lin25);
        linearLayout26 = findViewById(R.id.lin26);
        linearLayout27 = findViewById(R.id.lin27);
        linearLayout28 = findViewById(R.id.lin28);
        linearLayout29 = findViewById(R.id.lin29);
        linearLayout30 = findViewById(R.id.lin30);
        linearLayout31 = findViewById(R.id.lin31);
        linearLayout32 = findViewById(R.id.lin32);
        linearLayout33 = findViewById(R.id.lin33);
        linearLayout34 = findViewById(R.id.lin34);



        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        String id = user.getUid();

        Intent i = getIntent();
        String datetime = i.getStringExtra("time");
        String period = i.getStringExtra("timeperiod");
        String lec = i.getStringExtra("lecturer");
        String lecName = i.getStringExtra("lecName");
        String mid = i.getStringExtra("mid");
        String quiz = i.getStringExtra("quiz");
        String remarks = i.getStringExtra("remarks");
        
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

                            String APC2321 = dataSnapshot.child("15APC2321").getValue().toString();
                            String APC2322 = dataSnapshot.child("15APC2322").getValue().toString();
                            String APC2323 = dataSnapshot.child("15APC2323").getValue().toString();
                            String APC2324 = dataSnapshot.child("15APC2324").getValue().toString();
                            String APC2325 = dataSnapshot.child("15APC2325").getValue().toString();
                            String APC2326 = dataSnapshot.child("15APC2326").getValue().toString();
                            String APC2327 = dataSnapshot.child("15APC2327").getValue().toString();
                            String APC2328 = dataSnapshot.child("15APC2328").getValue().toString();
                            String APC2329 = dataSnapshot.child("15APC2329").getValue().toString();
                            String APC2330 = dataSnapshot.child("15APC2330").getValue().toString();
                            String APC2331 = dataSnapshot.child("15APC2331").getValue().toString();
                            String APC2332 = dataSnapshot.child("15APC2332").getValue().toString();
                            String APC2333 = dataSnapshot.child("15APC2333").getValue().toString();
                            String APC2334 = dataSnapshot.child("15APC2334").getValue().toString();
                            String APC2335 = dataSnapshot.child("15APC2335").getValue().toString();
                            String APC2336 = dataSnapshot.child("15APC2336").getValue().toString();
                            String APC2337 = dataSnapshot.child("15APC2337").getValue().toString();
                            String APC2338 = dataSnapshot.child("15APC2338").getValue().toString();
                            String APC2339 = dataSnapshot.child("15APC2339").getValue().toString();
                            String APC2340 = dataSnapshot.child("15APC2340").getValue().toString();
                            String APC2341 = dataSnapshot.child("15APC2341").getValue().toString();
                            String APC2342 = dataSnapshot.child("15APC2342").getValue().toString();
                            String APC2343 = dataSnapshot.child("15APC2343").getValue().toString();
                            String APC2344 = dataSnapshot.child("15APC2344").getValue().toString();
                            String APC2345 = dataSnapshot.child("15APC2345").getValue().toString();
                            String APC2346 = dataSnapshot.child("15APC2346").getValue().toString();
                            String APC2347 = dataSnapshot.child("15APC2347").getValue().toString();
                            String APC2348 = dataSnapshot.child("15APC2348").getValue().toString();
                            String APC2349 = dataSnapshot.child("15APC2349").getValue().toString();
                            String APC2350 = dataSnapshot.child("15APC2350").getValue().toString();
                            String APC2351 = dataSnapshot.child("15APC2351").getValue().toString();
                            String APC2352 = dataSnapshot.child("15APC2352").getValue().toString();
                            String APC2353 = dataSnapshot.child("15APC2353").getValue().toString();
                            String APC2354 = dataSnapshot.child("15APC2354").getValue().toString();
                            String APC2355 = dataSnapshot.child("15APC2355").getValue().toString();
                            String APC2356 = dataSnapshot.child("15APC2356").getValue().toString();
                            String APC2357 = dataSnapshot.child("15APC2357").getValue().toString();
                            String APC2358 = dataSnapshot.child("15APC2358").getValue().toString();
                            String APC2359 = dataSnapshot.child("15APC2359").getValue().toString();
                            String APC2360 = dataSnapshot.child("15APC2360").getValue().toString();
                            String APC2361 = dataSnapshot.child("15APC2361").getValue().toString();
                            String APC2362 = dataSnapshot.child("15APC2362").getValue().toString();
                            String APC2363 = dataSnapshot.child("15APC2363").getValue().toString();
                            String APC2364 = dataSnapshot.child("15APC2364").getValue().toString();
                            String APC2365 = dataSnapshot.child("15APC2365").getValue().toString();
                            String APC2366 = dataSnapshot.child("15APC2366").getValue().toString();
                            String APC2367 = dataSnapshot.child("15APC2367").getValue().toString();
                            String APC2368 = dataSnapshot.child("15APC2368").getValue().toString();
                            String APC2369 = dataSnapshot.child("15APC2369").getValue().toString();
                            String APC2370 = dataSnapshot.child("15APC2370").getValue().toString();
                            String APC2371 = dataSnapshot.child("15APC2371").getValue().toString();
                            String APC2372 = dataSnapshot.child("15APC2372").getValue().toString();
                            String APC2373 = dataSnapshot.child("15APC2373").getValue().toString();
                            String APC2374 = dataSnapshot.child("15APC2374").getValue().toString();
                            String APC2375 = dataSnapshot.child("15APC2375").getValue().toString();
                            String APC2376 = dataSnapshot.child("15APC2376").getValue().toString();
                            String APC2377 = dataSnapshot.child("15APC2377").getValue().toString();
                            String APC2378 = dataSnapshot.child("15APC2378").getValue().toString();
                            String APC2379 = dataSnapshot.child("15APC2379").getValue().toString();
                            String APC2380 = dataSnapshot.child("15APC2380").getValue().toString();
                            String APC2381 = dataSnapshot.child("15APC2381").getValue().toString();
                            String APC2382 = dataSnapshot.child("15APC2382").getValue().toString();
                            String APC2383 = dataSnapshot.child("15APC2383").getValue().toString();
                            String APC2384 = dataSnapshot.child("15APC2384").getValue().toString();
                            String APC2385 = dataSnapshot.child("15APC2385").getValue().toString();
                            String APC2386 = dataSnapshot.child("15APC2386").getValue().toString();
                            String APC2387 = dataSnapshot.child("15APC2387").getValue().toString();
                            String APC2388 = dataSnapshot.child("15APC2388").getValue().toString();
                            String APC2389 = dataSnapshot.child("15APC2389").getValue().toString();
                            String APC2390 = dataSnapshot.child("15APC2390").getValue().toString();
                            String APC2391 = dataSnapshot.child("15APC2391").getValue().toString();
                            String APC2392 = dataSnapshot.child("15APC2392").getValue().toString();
                            String APC2393 = dataSnapshot.child("15APC2393").getValue().toString();
                            String APC2394 = dataSnapshot.child("15APC2394").getValue().toString();
                            String APC2395 = dataSnapshot.child("15APC2395").getValue().toString();
                            String APC2396 = dataSnapshot.child("15APC2396").getValue().toString();
                            String APC2397 = dataSnapshot.child("15APC2397").getValue().toString();
                            String APC2398 = dataSnapshot.child("15APC2398").getValue().toString();
                            String APC2399 = dataSnapshot.child("15APC2399").getValue().toString();
                            String APC2400 = dataSnapshot.child("15APC2400").getValue().toString();
                            String APC2401 = dataSnapshot.child("15APC2401").getValue().toString();
                            String APC2402 = dataSnapshot.child("15APC2402").getValue().toString();
                            String APC2403 = dataSnapshot.child("15APC2403").getValue().toString();
                            String APC2404 = dataSnapshot.child("15APC2404").getValue().toString();
                            String APC2405 = dataSnapshot.child("15APC2405").getValue().toString();
                            String APC2406 = dataSnapshot.child("15APC2406").getValue().toString();
                            String APC2407 = dataSnapshot.child("15APC2407").getValue().toString();
                            String APC2408 = dataSnapshot.child("15APC2408").getValue().toString();


                            textView1.setText(APC2321);
                            textView2.setText(APC2322);
                            textView3.setText(APC2323);
                            textView4.setText(APC2324);
                            textView5.setText(APC2325);
                            textView6.setText(APC2326);
                            textView7.setText(APC2327);
                            textView8.setText(APC2328);
                            textView9.setText(APC2329);
                            textView10.setText(APC2330);
                            textView11.setText(APC2331);
                            textView12.setText(APC2332);
                            textView13.setText(APC2333);
                            textView14.setText(APC2334);
                            textView15.setText(APC2335);
                            textView16.setText(APC2336);
                            textView17.setText(APC2337);
                            textView18.setText(APC2338);
                            textView19.setText(APC2339);
                            textView20.setText(APC2340);
                            textView21.setText(APC2341);
                            textView22.setText(APC2342);
                            textView23.setText(APC2343);
                            textView24.setText(APC2344);
                            textView25.setText(APC2345);
                            textView26.setText(APC2346);
                            textView27.setText(APC2347);
                            textView28.setText(APC2348);
                            textView29.setText(APC2349);
                            textView30.setText(APC2350);
                            textView31.setText(APC2351);
                            textView32.setText(APC2352);
                            textView33.setText(APC2353);
                            textView34.setText(APC2354);
                            textView35.setText(APC2355);
                            textView36.setText(APC2356);
                            textView37.setText(APC2357);
                            textView38.setText(APC2358);
                            textView39.setText(APC2359);
                            textView40.setText(APC2360);
                            textView41.setText(APC2361);
                            textView42.setText(APC2362);
                            textView43.setText(APC2363);
                            textView44.setText(APC2364);
                            textView45.setText(APC2365);
                            textView46.setText(APC2366);
                            textView47.setText(APC2367);
                            textView48.setText(APC2368);
                            textView49.setText(APC2369);
                            textView50.setText(APC2370);
                            textView51.setText(APC2371);
                            textView52.setText(APC2372);
                            textView53.setText(APC2373);
                            textView54.setText(APC2374);
                            textView55.setText(APC2375);
                            textView56.setText(APC2376);
                            textView57.setText(APC2377);
                            textView58.setText(APC2378);
                            textView59.setText(APC2379);
                            textView60.setText(APC2380);
                            textView61.setText(APC2381);
                            textView62.setText(APC2382);
                            textView63.setText(APC2383);
                            textView64.setText(APC2384);
                            textView65.setText(APC2385);
                            textView66.setText(APC2386);
                            textView67.setText(APC2387);
                            textView68.setText(APC2388);
                            textView69.setText(APC2389);
                            textView70.setText(APC2390);
                            textView71.setText(APC2391);
                            textView72.setText(APC2392);
                            textView73.setText(APC2393);
                            textView74.setText(APC2394);
                            textView75.setText(APC2395);
                            textView76.setText(APC2396);
                            textView77.setText(APC2397);
                            textView78.setText(APC2398);
                            textView79.setText(APC2399);
                            textView80.setText(APC2400);
                            textView81.setText(APC2401);
                            textView82.setText(APC2402);
                            textView83.setText(APC2403);
                            textView84.setText(APC2404);
                            textView85.setText(APC2405);
                            textView86.setText(APC2406);
                            textView87.setText(APC2407);
                            textView88.setText(APC2408);
                            textView89.setText("15APC2409");
                            textView90.setText("15APC2410");

                            linearLayout31.setVisibility(View.GONE);
                            linearLayout32.setVisibility(View.GONE);
                            linearLayout33.setVisibility(View.GONE);
                            linearLayout34.setVisibility(View.GONE);


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
