package com.example.android.assignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.lifecycle.R;

public class ActivityA extends Activity implements OnClickListener {
    private Button ButtonB,ButtonDialog;
    private TextView counterView;
    private Intent intent;
    public  int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.w("ActivityA","OnCreate Called");
        ButtonB = (Button) findViewById(R.id.btn_start_b);
        ButtonDialog =(Button)findViewById(R.id.btn_start_dialog);
        counterView= (TextView)findViewById(R.id.cntval);
        counterView.setText(String.valueOf(counter));
        ButtonB.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        intent=new Intent(this,ActivityB.class);
        counterView.setText(String.format("%04d", counter));
        intent.putExtra("COUNTER",counter);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==100 && resultCode == 200) {
            Bundle bundle = data.getExtras();
            if(bundle!=null) {
                counter =  bundle.getInt("COUNTER");

            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        counter = counter+1;
        counterView.setText(String.format("%04d", counter));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
        counterView.setText(String.format("%04d", counter));
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

    public void finishActivityA(View v) {
        ActivityA.this.finish();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityA.this, DialogActivity.class);
        startActivity(intent);
    }

}