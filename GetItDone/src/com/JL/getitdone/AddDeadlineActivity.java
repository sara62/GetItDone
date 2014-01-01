package com.JL.getitdone;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("NewApi")
public class AddDeadlineActivity extends Activity {

	private static String date;
	private static TextView date_view;
	private static Button date_view_button;
	private static TextView timeView;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_deadline);
		date_view = (TextView) findViewById(R.id.deadline_date);
		date_view_button = (Button) findViewById(R.id.date_view_button);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);

		date_view_button.setText(new StringBuilder().append(month)
				.append("-").append(day).append("-").append(year));
		if (date == null){
			date = String.valueOf(month) + "-" + String.valueOf(day) + "-"
					+ String.valueOf(year);
		}

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

	// Save button
	public void onSave(View view) {
		if (view == null) {
			// IMPLEMENT TOAST
			return;
		}
		Intent intent = getIntent();

		timeView = (TextView) findViewById(R.id.deadline_date_view);
		intent.putExtra("time", date);

		EditText notesView = (EditText) findViewById(R.id.deadline_names_view);
		intent.putExtra("notes", notesView.getText().toString());

		EditText tagView = (EditText) findViewById(R.id.tags_view);
		intent.putExtra("tags", tagView.getText().toString());

		this.setResult(RESULT_OK, intent);
		finish();
	}

	// Cancel button
	public void onCancel(View view) {
		finish();
	}

	// DatePicker
	@SuppressLint("NewApi")
	public static class DatePickerFragment extends DialogFragment implements
			DatePickerDialog.OnDateSetListener {
		private int day, month, year;

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current date as the default date in the picker
			
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			// Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int mYear, int monthOfYear,
				int dayOfMonth) {
			// Do something with the date chosen by the user
			year = mYear;
			month = monthOfYear + 1;
			day = dayOfMonth;

			// update Date
			date_view_button.setText(new StringBuilder().append(month)
					.append("-").append(day).append("-").append(year));
			date = String.valueOf(month) + "-" + String.valueOf(day) + "-"
					+ String.valueOf(year);
		}
	}

	@SuppressLint("ValidFragment")
	public void showDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "datePicker");
	}
}