package com.JL.getitdone;

public class TaskRecord {
	private String tasks;
	private String time;
	
	public TaskRecord(String tasks, String time){
		this.tasks = tasks;
		this.time = time;
	}
	
	public String getTasks(){return tasks;}
	public void setTasks(String tasks){
		this.tasks = tasks;
	}
	
	public String getTime(){return time;}
	public void setTime(String time){
		this.time = time;
	}
}
