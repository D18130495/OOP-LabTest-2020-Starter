package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	

	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 800);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for(TableRow r : t.rows())
		{
			Task task = new Task(r);
			tasks.add(task);
		}
	}

	public void printTasks()
	{
		for(Task t : tasks)
		{
			println(t);
		}
	}

	public void displayTasks()
	{
		
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
	}
}
