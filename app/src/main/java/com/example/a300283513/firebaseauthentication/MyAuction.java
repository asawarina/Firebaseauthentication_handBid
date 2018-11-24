package com.example.a300283513.firebaseauthentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.auction.asawari.AuctionObject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAuction extends AppCompatActivity {


    private DatabaseReference mDatabase ;
    private ListView dataList;private ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_auction);
        final ArrayList<AuctionObject> auctions = new ArrayList<AuctionObject>();
        dataList = (ListView) findViewById(R.id.user_list);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        final HashMap<String, AuctionObject> datamap = new HashMap<>();
        final String current_user = getIntent().getExtras().getString("user1");

        mDatabase = FirebaseDatabase.getInstance().getReference("User");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot temp1:dataSnapshot.getChildren())
                {
                    AuctionObject zabuza = temp1.getValue(AuctionObject.class);
                    datamap.put(temp1.getKey(),zabuza);
                    auctions.add(zabuza);
                }

                if (auctions.size()!=0) {
                    for (AuctionObject temp: auctions)
                    {     //  temp.getStartDate()<currenttime
                        items.add(temp.getName()+"\n"+temp.getDescription());
                    }
                }
                dataList.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dataList.setClickable(true);
        dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key="";

                Intent intent = new Intent(MyAuction.this, BidPage.class);
                intent.putExtra("auction",auctions.get(position));
                intent.putExtra("name",auctions.get(position).getName());
                intent.putExtra("desc",auctions.get(position).getDescription());
                intent.putExtra("createdby",auctions.get(position).getCreatedBy());
                intent.putExtra("startdate",auctions.get(position).getStartDate());
                intent.putExtra("starttime",auctions.get(position).getStartTime());
                intent.putExtra("bid",auctions.get(position).getMinPrice());
                intent.putExtra("user1",current_user);
                for(String itr: datamap.keySet())
                {
                        AuctionObject tempAuction=datamap.get(itr);
                     if( auctions.get(position).getName().equalsIgnoreCase(tempAuction.getName())
                             && auctions.get(position).getDescription().equalsIgnoreCase(tempAuction.getDescription())
                             &&auctions.get(position).getCreatedBy().equalsIgnoreCase(tempAuction.getCreatedBy()))
                    {
                        key=itr;
                    }
                    intent.putExtra("key",key);
                    Toast.makeText(MyAuction.this,key,Toast.LENGTH_LONG).show();
                }


                startActivity(intent);
                finish();

                Toast.makeText(MyAuction.this,auctions.get(position).getStartDate(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
