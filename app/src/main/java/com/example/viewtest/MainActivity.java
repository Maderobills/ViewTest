package com.example.viewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button regBtn,showBtn;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference reference = db.getReference().child("Names");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_et);

        regBtn = findViewById(R.id.reg_bt);
        showBtn = findViewById(R.id.show_bt);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = name.getText().toString();


                //HashMap
                HashMap<String,String> usermap = new HashMap<>();
                usermap.put("name", Name);

                reference.push().setValue(usermap);
                Toast.makeText(MainActivity.this, "Name Sent", Toast.LENGTH_SHORT).show();
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ShowData.class);
                startActivity(intent);
            }
        });
    }
}