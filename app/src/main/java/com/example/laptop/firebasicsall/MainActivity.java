package com.example.laptop.firebasicsall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Button submit;
    EditText edit;
    private DatabaseReference mDatabaseref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseref=FirebaseDatabase.getInstance().getReference();
        edit=(EditText)findViewById(R.id.Edit1);
        submit=(Button)findViewById(R.id.Button);

        submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            String text=edit.getText().toString();
            mDatabaseref.child("Name").setValue(text);
            Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
        }
        });

    }
}
