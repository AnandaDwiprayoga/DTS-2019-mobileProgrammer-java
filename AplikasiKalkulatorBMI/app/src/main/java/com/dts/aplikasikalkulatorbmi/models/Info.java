package com.dts.aplikasikalkulatorbmi.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Info implements Parcelable {
    String jKelamin;
    String hasilBmi;
    String kategori;
    String umur;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.jKelamin);
        dest.writeString(this.hasilBmi);
        dest.writeString(this.kategori);
        dest.writeString(this.umur);
    }

    public Info(String jKelamin, String hasilBmi, String kategori, String umur) {
        this.jKelamin = jKelamin;
        this.hasilBmi = hasilBmi;
        this.kategori = kategori;
        this.umur = umur;
    }

    public String getjKelamin() {
        return jKelamin;
    }

    public void setjKelamin(String jKelamin) {
        this.jKelamin = jKelamin;
    }

    public String getHasilBmi() {
        return hasilBmi;
    }

    public void setHasilBmi(String hasilBmi) {
        this.hasilBmi = hasilBmi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public static Creator<Info> getCREATOR() {
        return CREATOR;
    }

    protected Info(Parcel in) {
        this.jKelamin = in.readString();
        this.hasilBmi = in.readString();
        this.kategori = in.readString();
        this.umur = in.readString();
    }

    public static final Parcelable.Creator<Info> CREATOR = new Parcelable.Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel source) {
            return new Info(source);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };
}
