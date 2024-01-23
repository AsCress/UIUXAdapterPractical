package com.example.uiuxadapterpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Context context;

    TypedArray images;
    String [] titleList;
    String [] descList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        titleList=getResources().getStringArray(R.array.Languages);
        descList=getResources().getStringArray(R.array.LanguagesDesc);
        images=getResources().obtainTypedArray(R.array.LanguagesImg);

        lv=(ListView)findViewById(R.id.listView);

        OurAdapter ourAdapter = new OurAdapter(this, titleList, descList, images);
        lv.setAdapter(ourAdapter);
    }
}
