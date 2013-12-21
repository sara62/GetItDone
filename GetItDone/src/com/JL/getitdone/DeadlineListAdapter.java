package com.JL.getitdone;

import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DeadlineListAdapter extends BaseAdapter{
	private ArrayList<TaskRecord> tasks = new ArrayList<TaskRecord>();
	public DeadlineListAdapter(){
		tasks.add(new TaskRecord(
				"Assignment 4", "Oct 1, 2013"));
		tasks.add(new TaskRecord(
				"Assignment 5", "Oct 1, 2013"));
		tasks.add(new TaskRecord(
				"Assignment 8", "Oct 1, 2013"));
		tasks.add(new TaskRecord(
				"Lab Report 4", "Oct 1, 2013"));
	}	
	
	public int getCount(){
		return tasks.size();
	}
	
	public Object getItem (int position){
		return getItem(position);
	}
	
	public long getItemId(int position){
		return position;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View view = convertView;
		
		if (view == null){
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.deadline_row, parent, false);
		}
		
		TaskRecord time = tasks.get(position);
		
		TextView timeTextView = (TextView) view.findViewById(R.id.deadline_date);
		timeTextView.setText(time.getTime());
		
		TextView tasksTextView = (TextView) view.findViewById(R.id.deadline_name);
		tasksTextView.setText(time.getTasks());
	return view;	
	}

}
