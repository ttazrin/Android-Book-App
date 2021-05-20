package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class subchapters extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";
    //public TextView textViewChapter;
    private DatabaseReference chapterName;
    private DatabaseReference subchap;
    private DatabaseReference numbers;
    public TextView name;
    String n = "";
    String[] tvShows;
    int count;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subchapters);
        Log.d(TAG, "onCreate: started.");

        String imagePosition = getIntent().getStringExtra("position");
        name = findViewById(R.id.textView7);
        //getIncomingIntent();


        chapterName = FirebaseDatabase.getInstance().getReference().child(imagePosition+"").child("name");
        chapterName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String chName = dataSnapshot.getValue().toString();
                name.setText( chName);
            }

            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG", "onCancelled", databaseError.toException());
            }
        });

        numbers = FirebaseDatabase.getInstance().getReference().child(imagePosition+"").child("number");
        numbers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               n= dataSnapshot.getValue().toString();
            }

            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG", "onCancelled", databaseError.toException());
            }
        });

        //textViewChapter = (TextView)findViewById(R.id.textView7);


        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("1");*/

        chapNames(Integer.parseInt(imagePosition), Integer.parseInt(n));

        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.subchapter_layoutlist, R.id.textView9, tvShows);

        final ListView theListView = (ListView)findViewById(R.id.theListView);

        theListView.setAdapter(theAdapter);
    }


    private void chapNames(int position, int n){
        tvShows = new String[n] ;
        count = 0;
        subchap = FirebaseDatabase.getInstance().getReference().child(position+"").child("subvalue");

        subchap.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    tvShows[count]= postSnapshot.getValue().toString();
                    count++;
                }
            }

            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG", "onCancelled", databaseError.toException());
            }
        });
    }

    /*private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            Log.d(TAG, "imgPosition + position");

            //setImage(imageUrl, imageName);
        }
    }*/

}