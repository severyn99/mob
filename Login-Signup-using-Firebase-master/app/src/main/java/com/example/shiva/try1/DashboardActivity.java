package com.example.shiva.try1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {
    TextView Email;
    Button LogOUT ;
    FirebaseUser user;
    public static final String TAG="LOGIN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       Email = (TextView)findViewById(R.id.textView1);
       LogOUT = (Button)findViewById(R.id.button1);

       user = FirebaseAuth.getInstance().getCurrentUser();

       Email.setText(Email.getText().toString()+ user.getDisplayName());

        LogOUT.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
                Toast.makeText(DashboardActivity.this,"Log Out Successfull", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(DashboardActivity.this,login.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }

}