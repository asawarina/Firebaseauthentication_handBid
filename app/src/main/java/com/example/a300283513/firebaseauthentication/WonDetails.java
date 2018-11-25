package com.example.a300283513.firebaseauthentication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.auction.asawari.AuctionObject;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WonDetails extends AppCompatActivity {
    FirebaseAuth auth;
    DatabaseReference mDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.won_details);
        TextView t1 = (TextView)findViewById(R.id.winauctionName);
        TextView t2 = (TextView)findViewById(R.id.winauctionescription);
        final TextView t3 = (TextView)findViewById(R.id.winauctionecurrentbid);

        final String startdate = getIntent().getExtras().getString("startdate");
        final String starttime = getIntent().getExtras().getString("starttime");
        final String createdby = getIntent().getExtras().getString("createdby");
        final String name =  getIntent().getExtras().getString("name");
        final String desc =  getIntent().getExtras().getString("desc");
        final String key =  getIntent().getExtras().getString("key");
        final String bid =  getIntent().getExtras().getString("bid");
        final String current_user=  getIntent().getExtras().getString("user1");
        // AuctionObject auctionObject = new AuctionObject(name,desc,bid,startdate,starttime,createdby);
        //  AuctionObject auctionObject =  getIntent().getParcelableExtra("auction");
        t1.setText(name);
        t2.setText(desc);
        t3.setText(bid);


    }

}
