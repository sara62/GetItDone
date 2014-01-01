package com.JL.getitdone;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

	// DatePicker
		@SuppressLint("NewApi")
		public class DatePickerFragment extends DialogFragment implements
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

			public void onDateSet(DatePicker view, int mYear, int monthOfYear, int dayOfMonth) {
				// Do something with the date chosen by the user
				year = mYear;
				month = monthOfYear + 1;
				day = dayOfMonth;
				
				//update Date
			//	date_view_button.setText(new StringBuilder().append(month)
		//				.append("-").append(day).append("-").append(year));
			//	date = String.valueOf(month) + String.valueOf(day) + String.valueOf(year);
				
			}
			private void updateDate(TextView date_view, String date) {
				// TODO Auto-generated method stub
				//timeView.setText(new StringBuilder().append(date));
			}
		

		public void showDatePickerDialog(View v) {
			DialogFragment newFragment = new DatePickerFragment();
			newFragment.show(getFragmentManager(), "datePicker");
		}
		}

