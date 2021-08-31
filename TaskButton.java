import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TaskButton extends JButton{
	private Task task;
	
	public TaskButton(Task task) {
		
		this.task = task;
		setText(task.toString());
		TaskButtonListener listener = new TaskButtonListener();
		addActionListener(listener);
	}
	
	private class TaskButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.out.println("Clicked");
			TaskButton source = (TaskButton)e.getSource();
			
			if(task.isComplete()) {
				task.setComplete(false);
				source .setForeground(Color.BLACK);
				source .setText(task.toString());
			}else {
				task.setComplete(true);
				source.setForeground(Color.GRAY);
				source.setText(task.toString());
			}
			
		}
		
	}

}
