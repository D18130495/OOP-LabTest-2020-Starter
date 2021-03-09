package ie.tudublin;

import processing.data.TableRow;

public class Task {
    private String task;
    private int start;
    private int end;

    public Task(TableRow r) {
        this(r.getString("Task"), r.getInt("Start"), r.getInt("End"));
    }

    public Task(String task, int start, int end) {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    //to string
    public String toString() {
        return "Task{" +
                "task='" + task + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    //getter and setter
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}