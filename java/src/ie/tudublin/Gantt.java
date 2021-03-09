package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{
	float leftBorder;
	float rightBorder;

	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void settings()
	{
		size(600, 600);
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
		stroke(255);
		fill(255);
		textAlign(CENTER, CENTER);
		for(int i = 1; i <= 30; i++)
		{
			float x = map(i, 1, 30, leftBorder, width - rightBorder);
			line(x, rightBorder,x, height - rightBorder);
			text(i, x, rightBorder / 2);
		}

		for(int i = 0; i < tasks.size(); i++)
		{
			textAlign(CENTER, CENTER);
			float y = map(i, 0, tasks.size(), rightBorder + 50, height - rightBorder - 50);
			Task t = tasks.get(i);
			float x1 = map(t.getStart(), 1, 30, leftBorder, width - rightBorder);
			float x2 = map(t.getEnd(), 1, 30, leftBorder, width - rightBorder);
			int c = (int) map(i, 0, tasks.size(), 0, 255);
			noStroke();
			fill(c, 255, 255);
			rect(x1, y - 20, x2 - x1, 40);
			stroke(255);
			fill(255);
			text(t.getTask(), leftBorder / 2, y);
		}
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
		colorMode(HSB);
		leftBorder = width * 0.2f;
		rightBorder = width * 0.05f;
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
