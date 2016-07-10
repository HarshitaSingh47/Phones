package com.example.mahe.phones;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    EditText ed0, ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        ed0 = (EditText) findViewById(R.id.ed0);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2= (EditText) findViewById(R.id.ed2);



    }

    public void Update(View arg0) {
        switch (arg0.getId()) {
            case R.id.b1:

                boolean diditwork=true;

                try {
                    String person_name = ed0.getText().toString();
                    String person_phone = ed1.getText().toString();

                    PhoneNumber data = new PhoneNumber(MainActivity.this);
                    data.open();
                    data.enterData(person_name, person_phone);
                    data.close();
                }
                catch(Exception e){
                    diditwork=false;
                    String error=e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Something went wrong");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally {
                    if (diditwork) {

                        Dialog d = new Dialog(this);
                        d.setTitle("Heck yeah");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;
            case R.id.b2:
                break;
            case R.id.b3:
                break;



        }
    }

    public void view1(View view){

        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);

    }

    public void getInfo(View v)
    {
        String s= ed2.getText().toString();
       long l= Long.parseLong(s);
        PhoneNumber p1=new PhoneNumber(MainActivity.this);
        try {
            p1.open();

            String returnedName = p1.getName(l);
            String returnedNumber = p1.getNumber(l);
            p1.close();


            displayinfo(returnedName,returnedNumber);
        }
        catch (Exception e)
        {
            System.out.print("Hello");
        }



    }

    public void MovieList(View v){
        Intent i1=new Intent(this,MovieList.class);
        startActivity(i1);

    }







       /* setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayinfo(String name,String number){
        Intent i=new Intent(this,displayinfo.class);
        Bundle extras=new Bundle();
        extras.putString("user",name);
        extras.putString("number",number);
        i.putExtras(extras);
        startActivity(i);


    }
}
