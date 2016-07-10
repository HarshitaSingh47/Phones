package com.example.mahe.phones;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by Harshita Singh on 4/3/2016.
 */
public class PhoneNumber {

    public static final String Row_id = "_id";
    public static final String Name = "Name";
    public static final String Phone = "Phone";

    private static final String database = "person_info";
    private static final String table = "person_table";
    private static final int version = 1;


    private DBhelper our_Helper;
    private Context our_Context;
    private SQLiteDatabase our_database;

    public long enterData(String person_name, String person_phone) {

        ContentValues cv= new ContentValues();
        cv.put(Name, person_name);
        cv.put(Phone, person_phone);
        return our_database.insert(table,null,cv);

    }
    public String getData() {

        String[] columns=new String[]{Row_id,Name,Phone};
        Cursor c=our_database.query(table,columns,null,null,null,null,null);
        String result= "";

        int iRow=c.getColumnIndex(Row_id);
        int iName=c.getColumnIndex(Name);
        int iPhone=c.getColumnIndex(Phone);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            result=result+ c.getString(iRow) +" " + c.getString(iName) +" " + c.getString(iPhone) +"\n";

        }



        return result;
    }

    public String getName(long l) {

        String[] columns=new String[]{Row_id,Name,Phone};
        Cursor c=our_database.query(table,columns,Row_id + "=" + l,null,null,null,null);

        if(c!=null)
        {
            c.moveToFirst();
            String name=c.getString(1);
            return name;
        }

        return null;



    }

    public String getNumber(long l) {

        String[] columns=new String[]{Row_id,Name,Phone};
        Cursor c=our_database.query(table,columns,Row_id + "=" + l,null,null,null,null);

        if(c!=null)
        {
            c.moveToFirst();
            String  phone=c.getString(2);
            return phone;
        }

        return null;



    }






    private static class DBhelper extends SQLiteOpenHelper {


        public DBhelper(Context context) {
            super(context, database, null, version);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {


            db.execSQL("CREATE TABLE " + table + " (" +
                            Row_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            Name + " TEXT NOT NULL, " +
                            Phone + " TEXT);"


            );

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("drop table if exits " + table);
            onCreate(db);


        }
    }



    public PhoneNumber(Context c) {
        our_Context = c;
    }

    public PhoneNumber open() throws SQLException{
        our_Helper = new DBhelper(our_Context);
        our_database = our_Helper.getWritableDatabase();

        return this;
    }

    public void close(){
        our_Helper.close();
    }
}

