
/**
 * 02.03.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) Do it android programming
 */


package com.eun1310434.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 200;
    public static final String KEY_PARCELABLE_DATA = "parcelable_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        ParcelableData parcelableData = new ParcelableData(8080, "eun1310434");
        parcelableData.setKey(9090);
        parcelableData.setValue("Reset DATA");

        intent.putExtra(KEY_PARCELABLE_DATA, parcelableData);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }

}
