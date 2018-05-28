/*=====================================================================
□ Infomation
  ○ Data : 23.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference
     - Do it android app Programming
     - Hello JAVA Programming
     - http://itmining.tistory.com/5

□ Function
  ○ Parcelable
     - Interface for classes whose instances can be written to and restored from a Parcel.
       Classes implementing the Parcelable interface must also have a non-null static field called CREATOR of a type that implements the Parcelable.
       Creator interface.
     - Note
       : Parcel is not a general-purpose serialization mechanism,
         and you should never store any Parcel data on disk or send it over the network.

□ Study
  ○ Parcelable
     -
=====================================================================*/
package com.eun1310434.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 10;
    public static final String KEY_PARCELABLE_DATA = "Parcelable_data";

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {// 응답을 받는 메소드
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(
                    getApplicationContext(),
                    "onActivityResult - "+
                            "requestCode : " + requestCode +
                            ", resultCode : " + resultCode, Toast.LENGTH_LONG).show();

            if (resultCode == -1) {//10 대신 Parcelable_data를 사용해도 됨
                String name = data.getExtras().getString("key");
                Toast.makeText(getApplicationContext(), "key : " + name, Toast.LENGTH_LONG).show();
            }
        }
    }
}
