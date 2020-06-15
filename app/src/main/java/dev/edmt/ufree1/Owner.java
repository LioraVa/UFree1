package dev.edmt.ufree1;

import androidx.appcompat.app.AppCompatActivity;
//import  dev.edmt.ufree1.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Owner extends AppCompatActivity {
    EditText buns, tel, city, add, d1_s, d1_e, d2_s, d2_e, d3_s, d3_e, d4_s, d4_e, d5_s, d5_e;
    Button btn_sv;
    Spinner filed;
    DatabaseReference databaseOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        getSupportActionBar().setTitle("Business Information");

        buns = (EditText)findViewById(R.id.tx_busn);
        tel = (EditText)findViewById(R.id.tx_tel);
        city = (EditText)findViewById(R.id.tx_city);
        add = (EditText)findViewById(R.id.tx_add);
        btn_sv = (Button)findViewById(R.id.btn);
        filed = (Spinner) findViewById(R.id.tx_filed);

        d1_s = (EditText)findViewById(R.id.Sunday_start);
        d1_e = (EditText)findViewById(R.id.Sunday_end);

        d2_s = (EditText)findViewById(R.id.Monday_start);
        d2_e = (EditText)findViewById(R.id.Monday_end);

        d3_s = (EditText)findViewById(R.id.Tuesday_start);
        d3_e = (EditText)findViewById(R.id.Tuesday_end);

        d4_s = (EditText)findViewById(R.id.Wednesday_start);
        d4_e = (EditText)findViewById(R.id.Wednesday_end);

        d5_s = (EditText)findViewById(R.id.Thursday_start);
        d5_e = (EditText)findViewById(R.id.Thursday_end);

        Intent intent = getIntent();
//        final String id = intent.getStringExtra(Signup_Form.User_id);
        final String id_ = intent.getStringExtra(Signup_Form.User_id);
//        final String owner_Name = intent.getStringExtra(Signup_Form.User_name);

//                databaseOwner = FirebaseDatabase.getInstance().getReference().child("Profiles");
        databaseOwner = FirebaseDatabase.getInstance().getReference("Profiles");//.child(id);

        btn_sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String busn = buns.getText().toString().trim();
                String pon = tel.getText().toString().trim();
                String cty = city.getText().toString().trim();
                String adrs = add.getText().toString().trim();
                String fld = filed.getSelectedItem().toString().trim();


                String da1_s = d1_s.getText().toString().trim();
                String da1_e = d1_e.getText().toString().trim();
                String da2_s = d1_s.getText().toString().trim();
                String da2_e = d1_e.getText().toString().trim();
                String da3_s = d1_s.getText().toString().trim();
                String da3_e = d1_e.getText().toString().trim();
                String da4_s = d1_s.getText().toString().trim();
                String da4_e = d1_e.getText().toString().trim();
                String da5_s = d1_s.getText().toString().trim();
                String da5_e = d1_e.getText().toString().trim();

//                String sessionId = getIntent().getStringExtra("KEY_ID");
                int img=0;

                if (TextUtils.isEmpty(busn)){
                    Toast.makeText(Owner.this, "Please enter business name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fld)){
                    Toast.makeText(Owner.this, "Please enter field of business ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pon)){
                    Toast.makeText(Owner.this, "Please enter Office phone", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cty)){
                    Toast.makeText(Owner.this, "Please enter city", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(adrs)){
                    Toast.makeText(Owner.this, "Please enter address", Toast.LENGTH_SHORT).show();
                    return;
                }
//                if (fld == "Hairdressing"){
//                    img =
//                }
//                String id = databaseOwner.push().getKey();
                String id = databaseOwner.push().getKey();
//                (String di, String name, String filed, int profilePic, String phone, String city, String address)

                Profile pro = new Profile(id_, busn, fld, img , pon, cty, adrs, da1_s, da1_e ,da2_s, da2_e, da3_s, da3_e,da4_s,da4_e ,da5_s,da5_e);
//                Profile pro = new Profile(id_, busn, fld, R.drawable.grip, pon,cty,adrs);

                databaseOwner.child(id).setValue(pro);
//                databaseOwner.child(sessionId).setValue(pro);

                Toast.makeText(Owner.this, "Details saved successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

    }
}
