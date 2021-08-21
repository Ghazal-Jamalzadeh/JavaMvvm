package com.jmzd.ghazal.javamvvm.roomDb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_user")
public class UserData {

    @PrimaryKey(autoGenerate = true)
    public int id; // حتما از نوع int  باشد primary key
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "family")
    public String family;

}
