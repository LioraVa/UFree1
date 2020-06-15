package dev.edmt.ufree1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import  dev.edmt.ufree1.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    EditText buns, filed, tel, city, add;
//    EditText buns, tel, city, add;
//    Spinner filed;
//    static int i=0;
    ListView listViewPro;
    List<Profile> profileList;


    Button btn_sv;
    DatabaseReference databaseOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Business List");

//        buns = (EditText)findViewById(R.id.tx_busn);
////        filed = (EditText)findViewById(R.id.tx_filed);
//        filed = (Spinner) findViewById(R.id.spinner);
//        tel = (EditText)findViewById(R.id.tx_tel);
//        city = (EditText)findViewById(R.id.tx_city);
//        add = (EditText)findViewById(R.id.tx_add);
//        btn_sv = (Button)findViewById(R.id.btn);

        listViewPro =  (ListView) findViewById(R.id.list_View);
        profileList = new ArrayList<>();
//        Intent intent = getIntent();
//        final String id = intent.getStringExtra(Signup_Form.User_id);
//        String id = intent.getStringExtra(Signup_Form.User_id);
//        final String owner_Name = intent.getStringExtra(Signup_Form.User_name);

//                databaseOwner = FirebaseDatabase.getInstance().getReference().child("Profiles");
        databaseOwner = FirebaseDatabase.getInstance().getReference("Profiles");//.child(id);

//        btn_sv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String busn = buns.getText().toString().trim();
//////                String fld = filed.getText().toString().trim();
////                  String fld = filed.getSelectedItem().toString().trim();
////
////                String pon = tel.getText().toString().trim();
////                String cty = city.getText().toString().trim();
////                String adrs = add.getText().toString().trim();
////                String sessionId = getIntent().getStringExtra("KEY_ID");
////
////                if (TextUtils.isEmpty(busn)){
////                    Toast.makeText(MainActivity.this, "Please enter business name", Toast.LENGTH_SHORT).show();
////                    return;
////                }
////                if (TextUtils.isEmpty(fld)){
////                    Toast.makeText(MainActivity.this, "Please enter field of business ", Toast.LENGTH_SHORT).show();
////                    return;
////                }
////                if (TextUtils.isEmpty(pon)){
////                    Toast.makeText(MainActivity.this, "Please enter Office phone", Toast.LENGTH_SHORT).show();
////                    return;
////                }
////                if (TextUtils.isEmpty(cty)){
////                    Toast.makeText(MainActivity.this, "Please enter city", Toast.LENGTH_SHORT).show();
////                    return;
////                }
////                if (TextUtils.isEmpty(adrs)){
////                    Toast.makeText(MainActivity.this, "Please enter address", Toast.LENGTH_SHORT).show();
////                    return;
////                }
////                String id = databaseOwner.push().getKey();
////                i++;
////                String id_ = "PRo" + i;
////                String id = databaseOwner.push().getKey();
////                Profile pro = new Profile("owner_Name", busn, fld, "http://timetobuild.co.il/wp-content/uploads/2016/03/BarberShop_01-1080x683.jpg", pon,cty,adrs);
////                databaseOwner.child(id).setValue(pro);
////                databaseOwner.child(sessionId).setValue(pro);
//
////                Toast.makeText(MainActivity.this, "Details saved successfully", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseOwner.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                profileList.clear();
                for (DataSnapshot proSnapshot: dataSnapshot.getChildren()){
                    Profile profile = proSnapshot.getValue(Profile.class);
                    profileList.add(profile);
                }
                ProfileList adapter = new ProfileList(MainActivity.this, profileList);
                listViewPro.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
