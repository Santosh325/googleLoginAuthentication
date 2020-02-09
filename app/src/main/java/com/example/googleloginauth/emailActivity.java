package com.example.googleloginauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class emailActivity extends AppCompatActivity {
    Button logoutbutton;
    TextView showmail;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        mAuth = FirebaseAuth.getInstance();
        logoutbutton = findViewById(R.id.logoutbutton);
        FirebaseUser fUser = mAuth.getCurrentUser();
        String mail = fUser.getEmail();
        showmail = findViewById(R.id.showmail);
        showmail.setText(mail);
        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
