package com.example.yohan.attendencesystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnSignUp;
    EditText etName,etEmail,etPassword;
    Spinner spYear,spCourse;
    TextView tvLogin;
    DatabaseReference mFirebase;
    FirebaseAuth mAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignUp = findViewById(R.id.btnSignUp);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        spCourse = findViewById(R.id.spinner_course);
        spYear = findViewById(R.id.spinner_year);
        tvLogin = findViewById(R.id.tvLogin);
        progressBar = findViewById(R.id.ProgressBar2);


        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        String id = user.getUid();


        mFirebase = FirebaseDatabase.getInstance().getReference("Users");


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userSignup();

            }
        });



        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent i = new Intent(MainActivity.this,signin.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });


    }



    private void userSignup() {

        final String name = etName.getText().toString();
        final String email = etEmail.getText().toString();
        final String passwrod = etPassword.getText().toString();

        if(name.isEmpty()){
            etName.setError("Email is required");
            etName.requestFocus();
            return;
        }


        if(email.isEmpty()){
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Please enter valid email");
            etEmail.requestFocus();
            return;
        }

        if(passwrod.isEmpty()){
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;

        }

        if(passwrod.length() < 6){
            etPassword.setError("Minimum length of password shoul be 6");
            etPassword.requestFocus();
            return;

        }

        final String year = spYear.getSelectedItem().toString();
        final String course = spCourse.getSelectedItem().toString();


        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,passwrod).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBar.setVisibility(View.VISIBLE);
                if (task.isSuccessful()){
                    User user = new User();
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(passwrod);
                    user.setCourse(course);
                    user.setYear(year);
                    FirebaseUser currentUser= mAuth.getCurrentUser();
                    mFirebase.child(currentUser.getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){

                                Intent  i  = new Intent(MainActivity.this,AttendenceData.class);
                                startActivity(i);
                                Toast.makeText(MainActivity.this,"Registration is successful!",Toast.LENGTH_SHORT).show();

                            }else{
                                if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(getApplicationContext(),"You are already registred",Toast.LENGTH_LONG).show();
                                }
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this,"Failed : "+e.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    });
                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(MainActivity.this,"Failed : "+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
