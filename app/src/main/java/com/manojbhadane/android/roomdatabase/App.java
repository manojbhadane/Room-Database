package com.manojbhadane.android.roomdatabase;

import android.app.Application;
import android.arch.persistence.room.Room;

import static com.manojbhadane.android.roomdatabase.DBHelper.DATABASE_NAME;

/**
 * Created by manoj.bhadane on 08-12-2017.
 */
public class App extends Application
{
    public static App INSTANCE;
    public DBHelper dbHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        INSTANCE = this;
        dbHelper = Room.databaseBuilder(getApplicationContext(), DBHelper.class, DATABASE_NAME).build();
    }

    public static App get()
    {
        return INSTANCE;
    }

    public DBHelper getDBInstance()
    {
        return dbHelper;
    }
}
