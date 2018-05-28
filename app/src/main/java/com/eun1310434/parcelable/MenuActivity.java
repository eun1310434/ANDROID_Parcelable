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
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView textView;
    public static final String KEY_PARCELABLE_DATA = "Parcelable_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("key", "eun1310434");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        // From mainActivity intent check
        Intent intent = getIntent();
        processIntent(intent);
    }

    //전달된 인텐트 처리
    private void processIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            ParcelableData parcelableData = (ParcelableData) bundle.getParcelable(KEY_PARCELABLE_DATA);
            // 텍스트뷰에 값을 보여줍니다.
            textView.setText("Get DATA\n Key : " + parcelableData.getKey() + "\nValue : " + parcelableData.getValue());
        }
    }

}
