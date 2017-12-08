package com.manojbhadane.android.roomdatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by manoj.bhadane on 08-12-2017.
 */
@Entity
public class Profile
{
    @PrimaryKey(autoGenerate = true) private int uid;

    @ColumnInfo(name = "profileName")
    private String profileName;

    @ColumnInfo(name = "status")
    private boolean status;

    @ColumnInfo(name = "daysValue")
    private int daysValue;

    @ColumnInfo(name = "fromTime")
    private String fromTime;

    @ColumnInfo(name = "toTime")
    private String toTime;

    public Profile()
    {
    }

    public int getUid()
    {
        return uid;
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

    public String getProfileName()
    {
        return profileName;
    }

    public void setProfileName(String profileName)
    {
        this.profileName = profileName;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public int getDaysValue()
    {
        return daysValue;
    }

    public void setDaysValue(int daysValue)
    {
        this.daysValue = daysValue;
    }

    public String getFromTime()
    {
        return fromTime;
    }

    public void setFromTime(String fromTime)
    {
        this.fromTime = fromTime;
    }

    public String getToTime()
    {
        return toTime;
    }

    public void setToTime(String toTime)
    {
        this.toTime = toTime;
    }
}
