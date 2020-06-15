package dev.edmt.ufree1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Form extends AppCompatActivity {
    EditText Email_log, Pass_log;
    Button btn_login;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        getSupportActionBar().setTitle("Login form");

        Email_log = (EditText)findViewById(R.id.log_Email_Log);
        Pass_log = (EditText)findViewById(R.id.log_pass);
        btn_login = (Button) findViewById(R.id.btn_log);
        firebaseAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email_log.getText().toString().trim();
                String pass = Pass_log.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Login_Form.this,"Please Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    Toast.makeText(Login_Form.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pass.length()<6) {
                    Toast.makeText(Login_Form.this, "Password too short, it's must be between 6 and 23 characters", Toast.LENGTH_SHORT).show();
                }
                if (pass.length()>32) {
                    Toast.makeText(Login_Form.this, "Password too long, it's must be between 6 and 23 characters", Toast.LENGTH_SHORT).show();
                }
                firebaseAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(Login_Form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity((new Intent(getApplicationContext(),MainActivity.class)));
                                } else {
                                    Toast.makeText(Login_Form.this, "Login Failed or User not Availble ", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    public void btn_signupForm(View view) {
        startActivity(new Intent(getApplicationContext(),Signup_Form.class));
    }
}
