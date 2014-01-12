package com.JL.getitdone;

public class TaskRecord {
	private String tasks;
	private String time;
	private String tag;
	
	public TaskRecord(String tasks, String time, String tag){
		this.tasks = tasks;
		this.time = time;
		this.tag = tag;
	}
	
	public String getTasks(){return tasks;}
	public void setTasks(String tasks){
		this.tasks = tasks;
	}
	
	public String getTime(){return time;}
	public void setTime(String time){
		this.time = time;
	}
	
	public String getTags(){return tag;}
	public void setTag(String tag){
		this.tag = tag;
	}
}
