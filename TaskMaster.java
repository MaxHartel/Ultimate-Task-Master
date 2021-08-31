

public class TaskMaster {
	public static void main(String  args[]) {
		Task task1 = new Task("Finish Activity 14");
		task1.setCategory(Task.Category.PERSONAL);
		
		System.out.println("Task1");
		System.out.println(task1);
		task1.setComplete(true);
		System.out.println(task1.isComplete());
		System.out.println(task1);
		
		//Test task 2
		Task task2 = new Task("Give Tigger a bath", 10);
		task2.setCategory(Task.Category.WORK);
		System.out.println("\n" + "Task2");
		System.out.println(task2);
		task2.setPriority(20);
		System.out.println(task2.getPriority());
		System.out.println(task2);
		
		
		//Test task 3
		Task task3 = new Task(task1.getDescription());
		task3.setCategory(Task.Category.NONE);
		System.out.println("Task3");
		System.out.println(task3);
		
		//Test equals
		System.out.println("Checking if Task 1 ans Task 3 are equal...");
		if(task3.equals(task1)) {
			System.out.println("Task 1 and Task 3 are equal.");
		}else {
			System.out.println("Task 1 and Task 3 are not equal.");
		}
		
		//Test compareTo
		System.out.println("Comparing Task  1 and Task 2");
		if(task1.compareTo(task2)==0) {
			System.out.println("Task 1 and Task 2 are equal");
		}else if(task1.compareTo(task2) < 0) {
			System.out.print("Task 1 is less then Task 2");
		}else {
			System.out.print("Task 1 is greater then Task 2");
		}
		System.out.println("\n");
		
		// ToDoList
		ToDoList list = new ToDoList("Get it Done");
		list.addTask(task1);
		list.addTask(task2);
		list.addTask(task3);
		list.addTask("post assignments",Task.Category.PERSONAL);
		System.out.println(list);// the above task should have a personal category
	
		//Test getWork on list
		Task maxTask = list.getWork();
		System.out.println("Top priority task: " + maxTask);
		
		//Test getWork on empty list
		ToDoList emptyList = new ToDoList("Empty List");
		System.out.println(emptyList.getWork());	
		
		//Test getWork on List with one complete task
		ToDoList oneDown = new ToDoList("has one complete task");
		Task completeTask = new Task("one down");
		completeTask.setComplete(true);
		oneDown.addTask(completeTask);
		System.out.println(oneDown.getWork());
	}

}



