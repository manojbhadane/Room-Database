package com.manojbhadane.android.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import static com.manojbhadane.android.roomdatabase.DBHelper.DATABASE_VERSION;

/**
 * Created by manoj.bhadane on 08-12-2017.
 */
@Database(entities = {Profile.class}, version = DATABASE_VERSION)
public abstract class DBHelper extends RoomDatabase
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ProfileDB";

    public abstract ProfileDao profileDao();
}