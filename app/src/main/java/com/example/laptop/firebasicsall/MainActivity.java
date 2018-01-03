package com.example.laptop.firebasicsall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    Button submit;
    EditText edit,edit1;
    private DatabaseReference mDatabaseref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseref=FirebaseDatabase.getInstance().getReference();
        edit=(EditText)findViewById(R.id.Edit1);
        edit1=(EditText)findViewById(R.id.Edit2);
        submit=(Button)findViewById(R.id.Button);

        submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            String text=edit.getText().toString();
            String Email=edit1.getText().toString();
            HashMap<String,String> data=new HashMap<String, String>();
            data.put("Name",text);
            data.put("Email",Email);
            mDatabaseref.push().setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
                public void onComplete(Task<Void> task)
            {
            if(task.isSuccessful())
            {
                Toast.makeText(getApplicationContext(), "suceeded", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();

            }
            }

            });
        }
        });

    }
}
