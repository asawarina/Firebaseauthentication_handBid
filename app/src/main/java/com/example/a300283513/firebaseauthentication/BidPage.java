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

public class BidPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_page);
        TextView t1 = (TextView)findViewById(R.id.auctionName);
        TextView t2 = (TextView)findViewById(R.id.auctionescription);
        TextView t3 = (TextView)findViewById(R.id.auctionecurrentbid);
        final EditText e1= (EditText)findViewById(R.id.newbid);
        Button b1= (Button)findViewById(R.id.submit_bid);
        String name =  getIntent().getExtras().getString("name");
        String desc =  getIntent().getExtras().getString("desc");
        String key =  getIntent().getExtras().getString("key");
        final String bid =  getIntent().getExtras().getString("bid");


      //  AuctionObject auctionObject =  getIntent().getParcelableExtra("auction");
        t1.setText(name);
        t2.setText(desc);
        t3.setText(bid);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentbid=0;
                int newbid=0;
                try {
                    currentbid= Integer.parseInt(bid);
                    newbid  = Integer.parseInt(e1.getText().toString());
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                if(currentbid>newbid)
                {


                    //insert
                }else{

                    Toast.makeText(BidPage.this,"Please bid more that curretn price ",Toast.LENGTH_LONG).show();

                }
            }
        });


    }

}
