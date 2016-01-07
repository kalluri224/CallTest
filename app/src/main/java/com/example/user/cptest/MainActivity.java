package com.example.user.cptest;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void contacts(View v){
        Intent i =new Intent();
        i.setComponent(new ComponentName(getApplicationContext(), ContactsActivity.class));
        startActivity(i);

    }
    public void call(View v) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_CALL);

        Uri.Builder builder = new Uri.Builder();
        builder.path(et1.getText().toString());
        builder.scheme("tel");
        i.setData(builder.build());
        startActivity(i);
    }
    @Override
    protected void onRestart(){
        super.onRestart();

        et1=(EditText)findViewById(R.id.editText);
        et1.setText(ApplicationConstants.mno);



    }

}

