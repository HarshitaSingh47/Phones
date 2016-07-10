package com.example.mahe.phones;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class displayinfo extends Activity {
    Bundle user_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abcd);

        user_info=getIntent().getExtras();
        String username=user_info.getString("user");
        String number=user_info.getString("number");

        TextView t1=(TextView)findViewById(R.id.tv2);
        TextView t2=(TextView)findViewById(R.id.tv3);


        Toast t=Toast.makeText(displayinfo.this,username,Toast.LENGTH_SHORT);
        t.show();
        t1.setText(username);
        t2.setText(number);



    }



}
