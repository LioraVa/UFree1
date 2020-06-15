package dev.edmt.ufree1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Form extends AppCompatActivity {

    EditText tetEmail, tetPassword, tetConfirm, tetName, tetPho;
    Button btn_register;
    CheckBox chkBox;
    String chk_busnss = "";
    public static final String User_name ="username";
    public static final String User_id = "userid";



    ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        //Casting Views
        getSupportActionBar().setTitle("Signup Form");
        tetEmail = (EditText)findViewById(R.id.tet_Email);
        tetPassword = (EditText)findViewById(R.id.tet_Pass);
        tetConfirm = (EditText)findViewById(R.id.tet_Confi_Pass);
        tetName = (EditText)findViewById(R.id.tet_Name);
        tetPho = (EditText)findViewById(R.id.tet_Pon);
        btn_register = (Button) findViewById(R.id.btn_Register);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        chkBox = (CheckBox) findViewById(R.id.chk_Bnss);

//        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        firebaseAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = tetEmail.getText().toString().trim();
                final String password = tetPassword.getText().toString().trim();
                String con_password = tetConfirm.getText().toString().trim();
                final String name = tetName.getText().toString().trim();
                final String phone = tetPho.getText().toString().trim();

                if(chkBox.isChecked())
                    chk_busnss = "YES";
                else
                    chk_busnss = "NO";
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(Signup_Form.this,"Please Enter Confirm Name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(Signup_Form.this,"Please Enter Phone",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Signup_Form.this,"Please Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup_Form.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(con_password)){
                    Toast.makeText(Signup_Form.this,"Please Enter Confirm Password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length()<6) {
                    Toast.makeText(Signup_Form.this, "Password too short, it's must be between 6 and 23 characters", Toast.LENGTH_SHORT).show();
                }
                if (password.length()>32) {
                    Toast.makeText(Signup_Form.this, "Password too long, it's must be between 6 and 23 characters", Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.VISIBLE);
                if (password.equals(con_password)){
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        User information;
//                                        String b_id = databaseReference.push().getKey();
//                                        final User user = new User(b_id, name, phone, email, password, chk_busnss);
                                        final User user = new User(name, phone, email, password, chk_busnss);
//                                        String id, String name, String phone, String mail, String password, String bussness)

                                        FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(Signup_Form.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                                if(chkBox.isChecked()){
//                                                    Intent intent = new Intent(getApplicationContext(), Owner.class);
//                                                    intent.putExtra("KEY_ID", email);
//                                                    startActivity(intent);
//                                                    startActivity(new Intent(getApplicationContext(), Owner.class));
                                                    Intent intent = new Intent(getApplicationContext(), Owner.class);
                                                    intent.putExtra(User_id, user.getMail());
                                                    intent.putExtra(User_name, user.getMail());
                                                    startActivity(intent);
                                                    return;

                                                }
                                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                            }
                                        });

                                    } else {
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(Signup_Form.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else{
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(Signup_Form.this,"Password and Confirm Password not match",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}