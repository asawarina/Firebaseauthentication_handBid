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

public class BidPage extends AppCompatActivity {
    FirebaseAuth auth;
    DatabaseReference mDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_page);
        TextView t1 = (TextView)findViewById(R.id.auctionName);
        TextView t2 = (TextView)findViewById(R.id.auctionescription);
        TextView t3 = (TextView)findViewById(R.id.auctionecurrentbid);
        final EditText e1= (EditText)findViewById(R.id.newbid);
        Button b1= (Button)findViewById(R.id.submit_bid);
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

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuctionObject auctionObject = new AuctionObject(name,desc,bid,startdate,starttime,createdby);
                auctionObject.setLastbid(current_user);
                int currentbid=0;
                int newbid  = Integer.parseInt(e1.getText().toString());
                try {
                    currentbid= Integer.parseInt(bid);

                }catch(Exception e)
                {
                    currentbid=0;
                    e.printStackTrace();
                }
                if(newbid>currentbid)
                {
                    auctionObject.setMinPrice(String.valueOf(newbid));
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("User");
                    mDatabase.child(key).setValue(auctionObject);
                    Toast.makeText(BidPage.this,"Bid Submitted",Toast.LENGTH_LONG).show();

                    //insert
                }else{

                    Toast.makeText(BidPage.this,"Please bid more that curretn price ",Toast.LENGTH_LONG).show();

                }

            }
        });


    }

}
