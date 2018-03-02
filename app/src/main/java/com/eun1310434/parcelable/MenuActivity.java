package com.eun1310434.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView textView;

    public static final String KEY_PARCELABLE_DATA = "parcelable_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("key", "value");
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
            textView.setText("Get DATA\nKey : " + parcelableData.getKey() + "\nValue : " + parcelableData.getValue());
        }
    }

}
