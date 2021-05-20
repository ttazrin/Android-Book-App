package com.example.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class viewAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewall);

        ExpandableListView expandableListView = findViewById(R.id.expandableListView);

        HashMap<String, List<String>> item = new HashMap<>();

        ArrayList<String> one = new ArrayList<>();
        one.add("Bmjvg");
        one.add("Cgvb");
        one.add("Bnmvb");

        item.put("cÖ_g Aa¨vq", one);

        ArrayList<String> two = new ArrayList<>();
        two.add("mvjvZ m¤úwK©Z wKQy Z_¨ ");
        two.add("mvjvZ KLb dih Kiv n‡jv");
        two.add("cweÎZv- cwi”QbœZv");
        two.add("Dh~");
        two.add("Dh~ Kivi c×wZ");
        two.add("Dh~‡Z A½ KZevi ay‡Z nq");
        two.add("Dh~i †k‡l †`vqv");
        two.add("Dh~i e¨vcv‡i we‡kl myweav");
        two.add("gvmvn");
        two.add("gvmvn Gi kZ©");
        two.add("gvmvn Gi wbqg");
        two.add("gvmvn bó nq wK‡m");
        two.add("Dh~ f‡½i KviY");
        two.add("Zvqv¤§yg");
        two.add("†Kvb Ae¯’vq Zvqv¤§yg Ki‡e");
        two.add("Zvqv¤§y‡gi c×wZ");
        two.add("†Mvmj");
        two.add("†Mvmj KLb cÖ‡qvRb");
        two.add("†Mvm‡ji wbqg");
        two.add("mvjvZ Av`v‡qi ¯’vb");
        two.add("mvjv‡Zi ¯’vb");
        two.add("mvjvZ Av`v‡qi wbwl× ¯’vb");
        two.add("mvjv‡Zi mgq");
        two.add("dRi");
        two.add("†hvni");
        two.add("Avmi");
        two.add("gvMwie");
        two.add("Bkv");
        two.add("weZi");
        two.add("Zvnv¾y`");
        two.add("mvjv‡Zi wbwl× mgq");
        two.add("bdj mvjv‡Zi wbwl× mgq");
        two.add("mvjv‡Zi †kªYx wefvM");
        two.add("mvjv‡Zi ivKvZ mg~n");
        two.add("†cvlvK");
        two.add("cyi“‡li †cvlvK");
        two.add("gwnjvi †cvlvK");
        two.add("mvjv‡Zi AviKvb mg~n");
        two.add("mvjv‡Zi mybœvn mg~n");
        /*
        two.add("Windows Mobile");
        two.add("Windows Mobile");
        two.add("Windows Mobile");
        */
        item.put("wØZxq Aa¨vq", two);

        MyExpandableListAdapter adapter = new MyExpandableListAdapter(item);
        expandableListView.setAdapter(adapter);
    }
}
