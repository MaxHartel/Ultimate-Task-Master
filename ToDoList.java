import java.util.ArrayList;
import java.util.Collections;

public class ToDoList implements ToDoListInterface {
	private String name;
	private ArrayList<Task> tasks = new ArrayList<>();
	private ArrayList<Task> incompletes = new ArrayList<>();
	private ArrayList<Task> doFirst = new ArrayList<>();
	private String BORDER = "-----------------\n";
	private boolean nameMatch;
	private int highestPriority;

	public ToDoList(String name) {
		this.name = name;

	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public void addTask(Task task) {
		tasks.add(task);

	}

	@Override
	public void addTask(String description) {
		nameMatch = false;
		String description1 = description.toLowerCase();
		for (Task x : tasks) {
			if (x.getDescription().toLowerCase() == description1) {
				nameMatch = true;
			}
		}
		if (!nameMatch) {
			tasks.add(new Task(description));
		}

	}
	
	
	public void addTask(String description, Task.Category category) {
		Task t = new Task(description);
		t.setCategory(category);
		tasks.add(t);

	}

	@Override
	public Task getWork() {
		if(tasks.isEmpty()) {
			return null;
		}else {
			Task maxTask = Collections.max(tasks);
			if (maxTask.isComplete()) {
				return null;
			}else {
				return maxTask;
			}
		}
	}
	
	
	/*
	 * this method works and produces the same result at the getWork above,
	 *  but I did it before reading the directions on how you guys wanted it to be done
	 *  so i re-did it in the correct way above
	@Override
	public Task getWork() {
		incompletes.clear();
		highestPriority = 0;

		if (tasks.isEmpty()) {
			return null;
		} else {
			getIncompletes();
			for (Task i : incompletes) {
				if (i.getPriority() > highestPriority) {
					highestPriority = i.getPriority();
				}
			}

			for (Task h : incompletes) {
				if (h.getPriority() == highestPriority) {
					doFirst.add(h);
				}
			}
			return doFirst.get(0);
		}
	}

	private ArrayList<Task> getIncompletes() {
		for (Task t : tasks) {
			if (!t.isComplete()) {
				incompletes.add(t);
			}
		}
		return incompletes;
	}
*/
	@Override
	public ArrayList<Task> getTaskList() {
		ArrayList<Task> copy = new ArrayList<>();
		for(Task t: tasks) {
			copy.add(t);
		}
		return copy;
	}

	public String toString() {
		String header = BORDER + name + "\n" + BORDER;
		for (Task t : tasks) {
			header += (t + "\n");
		}
		return header;
	}

}
