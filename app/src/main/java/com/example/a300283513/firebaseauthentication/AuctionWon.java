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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AuctionWon extends AppCompatActivity {


    private DatabaseReference mDatabase ;
    private ListView dataList;
    private ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction_won);
        final ArrayList<AuctionObject> auctions = new ArrayList<AuctionObject>();
        dataList = (ListView) findViewById(R.id.listwon);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        final HashMap<String, AuctionObject> datamap = new HashMap<>();
        final String current_user = getIntent().getExtras().getString("user1");

        mDatabase = FirebaseDatabase.getInstance().getReference("User");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Date date = new Date();
                for (DataSnapshot temp1:dataSnapshot.getChildren())
                {
                    String startDateString = "2007-23-12 12:20";
                    AuctionObject zabuza = temp1.getValue(AuctionObject.class);
                    startDateString = zabuza.getStartDate().toString()+" "+zabuza.getStartTime().toString();

                    Calendar c = Calendar.getInstance();
                    try {

                        String pattern = "yyyy-MM-dd HH:mm";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                       // Date date1 = simpleDateFormat.parse("2018-11-25 13:19");
                        Date date1 = simpleDateFormat.parse(startDateString);

                        System.out.println("date1 "+ date1.toString());
                        System.out.println("current date "+ c.getTime().toString());


                        if(date1.before(c.getTime())&&zabuza.getLastbid().equalsIgnoreCase(current_user)) {
                            System.out.println("continue");

                            if(zabuza.getName().contains("tama"))
                                Toast.makeText(AuctionWon.this,date1.toString(),Toast.LENGTH_LONG).show();

                            datamap.put(temp1.getKey(),zabuza);
                            auctions.add(zabuza);
                        }
                        else{
                            System.out.println("finished");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }



                }

                if (auctions.size()!=0) {
                    for (AuctionObject temp: auctions)
                    {     //  temp.getStartDate()<currenttime
                        items.add(temp.getName()+"\n"+temp.getDescription()+"\n"+ temp.getMinPrice()+ "\n"+temp.getLastbid());
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

                Intent intent = new Intent(AuctionWon.this, WonDetails.class);
                intent.putExtra("auction",auctions.get(position));
                intent.putExtra("name",auctions.get(position).getName());
                intent.putExtra("desc",auctions.get(position).getDescription());
                intent.putExtra("createdby",auctions.get(position).getCreatedBy());
                intent.putExtra("startdate",auctions.get(position).getStartDate());
                intent.putExtra("starttime",auctions.get(position).getStartTime());
                intent.putExtra("bid",auctions.get(position).getMinPrice());
                intent.putExtra("user1",current_user);

                startActivity(intent);




            }
        });
    }
}
