package com.mriksani.yourtags.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mriksani.yourtags.model.Deklarasi;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_yourtags";

    private static final String tb_tags = "tb_tags";

    private static final String tb_tag_id = "id";
    private static final String tb_tag_nama = "nama";
    private static final String tb_tag_deskripsi = "deskripsi";

    private static final String CREATE_TABLE_TUGAS = "CREATE TABLE " + tb_tags + "("
            + tb_tag_id + " INTEGER PRIMARY KEY ,"
            + tb_tag_nama + " TEXT,"
            + tb_tag_deskripsi + " TEXT "+ ")";

    public DataHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TUGAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateTugas(Deklarasi mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tag_id, mdNotif.get_id());
        values.put(tb_tag_nama, mdNotif.get_nama());
        values.put(tb_tag_deskripsi, mdNotif.get_deskripsi());
        db.insert(tb_tags, null, values);
        db.close();
    }

    public List<Deklarasi> ReadTugas() {
        List<Deklarasi> judulModelList = new ArrayList<Deklarasi>();
        String selectQuery = "SELECT  * FROM " + tb_tags;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Deklarasi mdKontak = new Deklarasi();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_deskripsi(cursor.getString(2));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

   public int UpdateTugas(Deklarasi mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_tag_nama, mdNotif.get_nama());
        values.put(tb_tag_deskripsi, mdNotif.get_deskripsi());

        return db.update(tb_tags, values, tb_tag_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }

    public void DeleteTugas(Deklarasi mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_tags, tb_tag_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

