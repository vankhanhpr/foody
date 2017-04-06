package com.example.khanh.foody4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Khanh on 3/29/2017.
 */

public class mainf extends Activity
{
    ImageView imv_back;
    //mở activity tương ứng khi nhấn vào icon Foddy
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        setContentView(R.layout.activity_main_f);
        imv_back=(ImageView)findViewById(R.id.imv_back10);
        super.onCreate(savedInstanceState);
        //tắt activity
        imv_back.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
            }
        });

    }

}

