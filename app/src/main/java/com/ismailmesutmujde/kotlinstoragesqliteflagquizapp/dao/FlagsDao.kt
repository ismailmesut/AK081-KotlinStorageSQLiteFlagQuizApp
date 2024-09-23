package com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.dao

import android.annotation.SuppressLint
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.database.DatabaseHelper
import com.ismailmesutmujde.kotlinstoragesqliteflagquizapp.model.Flags

class FlagsDao {
    @SuppressLint("Range")
    fun getRandomly5Flags(dbh: DatabaseHelper) : ArrayList<Flags> {
        val flagsList = ArrayList<Flags>()
        val db = dbh.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM flags ORDER BY RANDOM() LIMIT 5", null)

        while (cursor.moveToNext()) {
            val flag = Flags(cursor.getInt(cursor.getColumnIndex("flag_id"))
                ,cursor.getString(cursor.getColumnIndex("flag_name"))
                ,cursor.getString(cursor.getColumnIndex("flag_image")))
            flagsList.add(flag)
        }
        return flagsList
    }

    @SuppressLint("Range")
    fun getRandomly3WrongOptions(dbh: DatabaseHelper, flag_id:Int) : ArrayList<Flags> {
        val flagsList = ArrayList<Flags>()
        val db = dbh.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM flags WHERE flag_id != $flag_id ORDER BY RANDOM() LIMIT 3", null)

        while (cursor.moveToNext()) {
            val flag = Flags(cursor.getInt(cursor.getColumnIndex("flag_id"))
                ,cursor.getString(cursor.getColumnIndex("flag_name"))
                ,cursor.getString(cursor.getColumnIndex("flag_image")))
            flagsList.add(flag)
        }
        return flagsList
    }
}