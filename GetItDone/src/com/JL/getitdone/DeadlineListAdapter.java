package com.JL.getitdone;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DeadlineListAdapter extends ArrayAdapter<TaskRecord>{
	
	private ArrayList<TaskRecord> tasks;
	private final Context context;
	
	public DeadlineListAdapter(Context context, ArrayList<TaskRecord> tasks){
		super(context, R.layout.deadline_row);
		this.context = context;
		this.tasks = tasks;
	}	
	
	public int getCount(){
		return tasks.size();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View view = convertView;
		
		if (view == null){
			view = LayoutInflater.from(getContext()).inflate(R.layout.deadline_row,null);
		}
		
		TextView timeTextView = (TextView) view.findViewById(R.id.deadline_date);
		timeTextView.setText(tasks.get(position).getTime());
		
		TextView tasksTextView = (TextView) view.findViewById(R.id.deadline_name);
		tasksTextView.setText(tasks.get(position).getTasks());
		
		TextView tagsTextView = (TextView) view.findViewById(R.id.tags);
		tagsTextView.setText(tasks.get(position).getTags());
	return view;	
	}

}
