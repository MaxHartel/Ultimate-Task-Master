import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lesson 18-19: Activity - Task Master GUI
 * 
 * This class represents the main TaskMaster JPanel. 
 * 
 * It contains a ToDoListPanel and the control sub-panel.
 * 
 * @author CS121 Instructors
 * @version [semester]
 * @author [your name]
 */
@SuppressWarnings("serial")
public class TaskMasterPanel extends JPanel
{	
	private ToDoListPanel listPanel;
	private JTextField descriptionField;
	private JPanel controlPanel;
	private JScrollPane listScrollPane;
	
	public TaskMasterPanel(){
		setPreferredSize(new Dimension(500, 400));		
		setLayout(new BorderLayout());
		controlPanel = new JPanel();
		listPanel = new ToDoListPanel("Test List");
		listScrollPane = new JScrollPane(listPanel);
		descriptionField = new JTextField(15);
		
		listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		listScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		listPanel.addTask(new Task("Task 1"));
		listPanel.addTask(new Task("Task 2"));
		listPanel.addTask(new Task("Task 3"));
		
		JButton getWorkButton = new JButton("Get Work");
		JButton addTaskButton = new JButton("Add Task");
		
		controlPanel.add(descriptionField);
		controlPanel.add(addTaskButton);
		controlPanel.add(getWorkButton);
		
		
		getWorkButtonListener listener = new getWorkButtonListener();
		addTaskButtonListener addlistener = new addTaskButtonListener();
		addTaskButton.addActionListener(addlistener);
		getWorkButton.addActionListener(listener);
		
		add(listScrollPane,BorderLayout.CENTER);
		add(controlPanel,BorderLayout.SOUTH);
	}
	
	private class getWorkButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			listPanel.showWorkDialog();
		}
		
	}
	
	private class addTaskButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String text = descriptionField.getText();
			listPanel.addTask(new Task(text));
			controlPanel.revalidate();
			
		}
		
	}
	
}
