package com.example.android.assignment;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;

import com.example.android.lifecycle.R;

public class ActivityB extends Activity {
    public int ctrB =0, ctr =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            ctrB= extras.getInt("COUNTER");
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ctr=ctrB + 1;
        Intent intent = new Intent();
        intent.putExtra("COUNTER",ctr);
        setResult(200,intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void finishActivityB(View v) {
        ActivityB.this.finish();
    }
}