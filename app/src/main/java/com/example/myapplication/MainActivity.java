package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
        private DrawerLayout drawer;
        private static final String TAG = "MainActivity";
        private ArrayList<String> mNames = new ArrayList<>();
        private ArrayList<String> mImageUrls = new ArrayList<>();
        private DatabaseReference chapterName;
        public String invText = "";
        public String [] array = new String[13];
        public int count =0;
        public TextView tinvisible;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mainpage);
            final Activity activity = this;
            activity.setTitle("As-Salah");
            getImages();

            tinvisible = (TextView)findViewById(R.id.textViewInvisible);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            drawer = findViewById(R.id.drawer_layout);
            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            tinvisible.setText("");

           /* for(int i=0; i<13; i++) {

                chapterName = FirebaseDatabase.getInstance().getReference().child(i+"").child("name");
                chapterName.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String chName = dataSnapshot.getValue().toString();
                        tinvisible.append(chName+",");
                    }

                    public void onCancelled(DatabaseError databaseError) {
                        Log.i("TAG", "onCancelled", databaseError.toException());
                    }
                });
            }
            invText = tinvisible.getText().toString();
            Log.i("activitytag", invText);

            StringTokenizer tokenizer = new StringTokenizer(invText, ",");
            Log.i("invt", invText);
            while (tokenizer.hasMoreTokens()) {
                array[count]=tokenizer.nextToken();
                count++;
            }
            for(int i=0; i<13;i++){
                mNames.add(array[i]);
                Log.i("arrayz", array[i]+"");
            }*/
        }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFragment()).commit();
                break;
            case R.id.nav_utshorgo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UtshorgoFragment()).commit();
                break;
            case R.id.nav_explanation:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ExplanationFragment()).commit();
                break;
            case R.id.nav_references:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ReferenceFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getImages(){

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

            mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
            mNames.add("cÖviw¤¢K K_v");

            mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
            mNames.add("cÖ_g Aa¨vq");

            mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
            mNames.add("wØZxq Aa¨vq");

            mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
            mNames.add("Z…Zxq Aa¨vq");


            mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
            mNames.add("PZz© Aa¨vq");

            mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
            mNames.add("cÂg Aa¨vq");

            mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
            mNames.add("lô Aa¨vq");

            mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
            mNames.add("mßg Aa¨vq");

            mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
            mNames.add("Aóg Aa¨vq");

            mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
            mNames.add("beg Aa¨vq");

            mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
            mNames.add("`kg Aa¨vq");

            mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
            mNames.add("GKv`k Aa¨vq");

            mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
            mNames.add("Øv`k Aa¨vq");

            initRecyclerView();


        }

        public void viewAll(View view){
            /*String s = tinvisible.getText().toString();
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            Log.i("activitytag", s);*/
            Intent intent = new Intent(this, viewAll.class);
            startActivity(intent);
        }
        private void initRecyclerView(){
            Log.d(TAG, "initRecyclerView: init recyclerview");

            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(layoutManager);
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
            recyclerView.setAdapter(adapter);
        }

}
