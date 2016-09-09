package com.example.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
 private Button btnClose;
 private Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = (Button)findViewById(R.layout.activity_main);
        btnShow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,SecondActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.scale_rotate_in,R.anim.alpha_out);
 			}
		});
        
        btnClose = (Button)findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Builder Builder = new AlertDialog.Builder(MainActivity.this);
				Builder.setTitle("SystemInfomation");
				Builder.setMessage("消息提示");
				Builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0,int arg1) {
						// TODO Auto-generated method stub
						finish();
					}
				});
				Builder.setNegativeButton("No", null);
				Builder.create().show();
			}

		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
