package com.JL.getitdone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddDeadlineActivity extends Activity {
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_deadline);

		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_deadline, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	//Save button
	public void onSave(View view){
		Intent intent = getIntent();
		
		EditText timeView = (EditText) findViewById(R.id.time_view);
		intent.putExtra("time", timeView.getText().toString());
		
		EditText notesView = (EditText) findViewById(R.id.notes_view);
		intent.putExtra("notes", notesView.getText().toString());
		
		EditText tagView = (EditText) findViewById(R.id.tags_view);
		intent.putExtra("tags", tagView.getText().toString());
		
		this.setResult(RESULT_OK, intent);
		finish();
	}
	
	//Cancel button
	public void onCancel(View view){
		finish();
	}

}
