package com.mriksani.yourtags;

public class Deklarasi {
    private String _id, _nama, _deskripsi;

    public Deklarasi (String id, String nama, String deskripsi) {
        this._id = id;
        this._nama = nama;
        this._deskripsi = deskripsi;
    }

    public Deklarasi () {

    }

    public void set_id (String id) {
        this._id = id;
    }

    public String get_id () {
        return this._id;
    }

    public void set_nama (String nama) {
        this._nama = nama;
    }

    public String get_nama () {
        return this._nama;
    }

    public void set_deskripsi (String deskripsi) {
        this._deskripsi = deskripsi;
    }

    public String get_deskripsi () {
        return this._deskripsi;
    }

}
