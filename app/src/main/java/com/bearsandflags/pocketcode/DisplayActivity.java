package com.bearsandflags.pocketcode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

/**
 * Created by Sapir on 15/09/06.
 */
public class DisplayActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_content);

        Intent intent = getIntent();
        String fileName=intent.getExtras().getString("fileName");
        System.out.println(fileName);
        RelativeLayout layout=(RelativeLayout)findViewById(R.id.display_content);
        layout.setBackgroundColor(Color.parseColor("#FDF39D"));
    }
}
