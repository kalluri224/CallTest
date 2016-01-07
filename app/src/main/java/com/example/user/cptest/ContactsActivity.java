package com.example.user.cptest;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by user on 12/26/2015.
 */
public class ContactsActivity extends Activity{

    ListView lView;
    ContentResolver resolver;
    Cursor c;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);

        lView=(ListView)findViewById(R.id.listView1);

        resolver=getContentResolver();

        c=resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

        String[] from=new String[]{
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER
        };

        int[] to=new int[]{
                R.id.Name_textView2,R.id.Num_textView3
        };

        SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.indi,c,from,to);

        lView.setAdapter(adapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {






                TextView tv1 = (TextView) arg1.findViewById(R.id.Num_textView3);
                ApplicationConstants.mno = tv1.getText().toString();
                finish();


            }
        });






    }



}
