package com.manojbhadane.android.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by manoj.bhadane on 08-12-2017.
 */
@Dao
public interface ProfileDao
{
    @Query("SELECT * FROM profile")
    List<Profile> getAllProfiles();

    @Insert
    void insertAll(List<Profile> profile);

    @Update
    void update(Profile profile);

    @Delete
    void delete(Profile profile);
}
