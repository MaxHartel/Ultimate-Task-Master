

public class Task implements Comparable<Task> {
	
	public enum Category { PERSONAL, WORK, NONE }
	private String description;
	private Category category;
	private int priority = 0;
	private boolean complete = false;
	private boolean descriptionMatch = false;
	private boolean priorityMatch = false;
	
	public Task(String description) {
		this.description = description;
		category =Category.NONE;
	}
	
	public Task(String description, int priority) {
		this.description = description;
		this.priority = priority;
		category =Category.NONE;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String descriptionSet) {
		this.description = descriptionSet;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int prioritySet) {
		this.priority = prioritySet;
	}
	
	public boolean isComplete() {
		return complete;
	}
	
	public void setComplete(boolean completeSet) {
		this.complete = completeSet;
	}
	
	public boolean equals(Task task1) {
		if(task1.getDescription().equalsIgnoreCase(description) && this.category == task1.getCategory()){
			descriptionMatch = true;
		}
		
		if(descriptionMatch) {
			return true;
		}else {
			return false;
		}
	}
	
	public int compareTo(Task taskX) {
		if(taskX.isComplete() && !complete) {
			return 1;
		}else if(!taskX.isComplete() && complete) {
			return -1;
		}else if((taskX.isComplete() && complete)||(!taskX.isComplete() && !complete)) {
			if(taskX.getPriority()  == priority) {
				return 0;
			}else if(taskX.getPriority() > priority) {
				return -1;
			}else if(taskX.getPriority() < priority) {
				return 1;
			}
		}
		return 0;
	}
	
	public String toString() {
		if(complete) {
			return "[X]" + description + ",  "+ category + ", " + priority;
		}else {
			return "[ ]" + description + ",  "+ category + ", " + priority;
		}
	}
	
}
