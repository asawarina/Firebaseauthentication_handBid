package com.example.a300283513.firebaseauthentication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class CreateAuction extends AppCompatActivity {

     Button mFirebaseBtn;
     EditText mNameField, mDField, mPField,mStart,mHrs;
    User user;

     FirebaseAuth auth;

     DatabaseReference mDatabase ;



     /*Button mFirebaseBtn;
     EditText mNameField, mDField, mPField,mStart,mHrs;

    FirebaseDatabase database;
     DatabaseReference mDatabase ;

  */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_auction);




        mFirebaseBtn =(Button) findViewById(R.id.done);
        mNameField =(EditText) findViewById(R.id.PrdctName);
        mDField =(EditText) findViewById(R.id.Description);
        mPField =(EditText)  findViewById(R.id.MinPrice);
        mStart =(EditText) findViewById(R.id.startDate);
        mHrs =(EditText) findViewById(R.id.startTime);





        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String user =  getIntent().getExtras().getString("user1");
                try {
                    mDatabase = FirebaseDatabase.getInstance().getReference().child(user);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.print(e);
                    Toast.makeText(
                            CreateAuction.this,
                            e.toString(),
                            Toast.LENGTH_LONG).show();
                }

                String name = mNameField.getText().toString().trim();
                String description = mDField.getText().toString().trim();
                String MinPrice=mPField.toString().trim();
                String startDate = mStart.getText().toString().trim();
                String startTime = mHrs.getText().toString().trim();



                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name",name);
                dataMap.put("Description",user);
                dataMap.put("Min Price",user);
                dataMap.put("StartDate",startDate);
                dataMap.put("StartTime",startTime);
                dataMap.put("user_name",user);

                mDatabase.push().setValue(dataMap);

                mNameField.setText(null);
                mDField.setText(null);
                mPField.setText(null);
                mStart.setText(null);
                mHrs.setText(null);
            }


        });
      //  mDatabase = FirebaseDatabase.getInstance().getReference().child("User");
        // user= new User();



    }
    /*private void getValue(){

        user.setName(mNameField.getText().toString());
        user.setDescription(mDField.getText().toString());
        user.setMinPrice(mPField.getText().toString());
        user.setStartDate(mStart.getText().toString());
        user.setStartTime(mHrs.getText().toString());
    }


    public void done(View view){
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValue();

                mDatabase.child("User02").setValue(user);
                Toast.makeText(CreateAuction.this,"Data Inserted",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/


       /*

        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString().trim();
                String description = mDField.getText().toString().trim();
                String MinPrice=mPField.toString().trim();
                String startDate = mStart.getText().toString().trim();
                String startTime = mHrs.getText().toString().trim();

                HashMap<String, String> dataMap = new HashMap<>();
                dataMap.put("Name",name);
                dataMap.put("Description",description);
                dataMap.put("Min Price",MinPrice);
                dataMap.put("StartDate",startDate);
                dataMap.put("StartTime",startTime);

                mDatabase.push().setValue(dataMap);

                mNameField.setText(null);
                mDField.setText(null);
                mPField.setText(null);
                mStart.setText(null);
                mHrs.setText(null);
            }


        });*/

}
       /* mFirebaseBtn =(Button) findViewById(R.id.done);
        mNameField = (EditText)findViewById(R.id.PrdctName);
        mDField = (EditText) findViewById(R.id.Description);
        mPField = (EditText) findViewById(R.id.MinPrice);
        mStart =(EditText) findViewById(R.id.startDate);
        mHrs =(EditText) findViewById(R.id.startTime);

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("User");

       user = new User();

        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        getValue();
                        mDatabase.child("User03").setValue(user);
                        Toast.makeText(CreateAuction.this,"Data Inserted",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }

   */



       //useless
       /*    public void mFirebaseBtn(View view) {

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                getValue();
                mDatabase.child("User03").setValue(user);
                Toast.makeText(CreateAuction.this,"Data Inserted",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
       // this.mFirebaseBtn = mFirebaseBtn;

    }*/












