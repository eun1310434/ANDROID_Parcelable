package com.eun1310434.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableData implements Parcelable {
    int key;
    String value;

    public ParcelableData(int _key, String _value) {
        key = _key;
        value = _value;
    }

    public ParcelableData(Parcel src) {
        key = src.readInt();
        value = src.readString();
    }

    //Parcelable interface 활용 -  내부의 CREATOR 객체 생성
    @SuppressWarnings("unchecked")
    public static final Creator CREATOR = new Creator() {

        public ParcelableData createFromParcel(Parcel in) {
            return new ParcelableData(in);
        }

        public ParcelableData[] newArray(int size) {
            return new ParcelableData[size];
        }

    };


    public int describeContents() {
        return 0;
    }

    //데이터 Parcel 객체 작성
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(key);
        dest.writeString(value);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int _key) {
        this.key = _key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String _value) {
        this.value = _value;
    }

}
