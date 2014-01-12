package com.JL.getitdone;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends ListActivity {
	private static final String TAG = "Main"; // For debugging
	static final int DEADLINE_ADD_REQUEST = 1;
	private Context context = null;
	private DeadlineListAdapter deadlineListAdapter = null;
	ArrayList<TaskRecord> tasks = new ArrayList<TaskRecord>();
	public static final String EXTRA_DEADLINE_ID = "com.JL.getitdone.deadline_id";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate(Bundle) called");
		setContentView(R.layout.activity_main);

		ListView listView = getListView();
		deadlineListAdapter = new DeadlineListAdapter(this, tasks);

		setListAdapter(deadlineListAdapter);

		// Click on a row
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> myAdapter, View view,
					final int position, long arg3) {

				final String[] options_array = { "Edit", "Delete" };
				AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
				builder.setItems(options_array,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) { //
								// TODO Auto-generated method stub
								if (which == 0) {
									Intent click = new Intent(Main.this,
											EditDeadlineActivity.class);
									startActivityForResult(click,
											DEADLINE_ADD_REQUEST);

								} else {
									tasks.remove(position);
									Toast.makeText(getApplicationContext(),
											"Deleted succesfully",
											Toast.LENGTH_LONG).show();
								}
							}
						});
				builder.create();
				builder.show();
			}
		});

	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d(TAG, "onStart() called");
	}

	@Override
	public void onPause() {
		super.onStart();
		Log.d(TAG, "onPause() called");
	}

	@Override
	public void onResume() {
		super.onStart();
		Log.d(TAG, "onResume() called");
	}

	@Override
	public void onStop() {
		super.onStart();
		Log.d(TAG, "onStop() called");
	}

	@Override
	public void onDestroy() {
		super.onStart();
		Log.d(TAG, "on() called");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_search:
			// openSearch();
			return true;
		case R.id.add:
			Intent add = new Intent(Main.this, AddDeadlineActivity.class);
			startActivityForResult(add, DEADLINE_ADD_REQUEST);
			return true;
		case R.id.action_settings:
			// /openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request we're responding to
		if (requestCode == DEADLINE_ADD_REQUEST) {
			// Make sure the request was successful
			if (resultCode == RESULT_OK) {
				String time = data.getStringExtra("time");
				String note = data.getStringExtra("notes");
				String tag = data.getStringExtra("tags");

				generateData(note, time, tag);
				deadlineListAdapter.notifyDataSetChanged();
				Toast.makeText(this, note + " is added", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

	public ArrayList<TaskRecord> generateData(String note, String time,
			String tag) {

		tasks.add(new TaskRecord(note, time, tag));

		return tasks;
	}

}
