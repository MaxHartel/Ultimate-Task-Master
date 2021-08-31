import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoListPanel extends JPanel{
	private ToDoList list;
	
	public ToDoListPanel(String name) {
		list= new ToDoList(name);
		this.add(new JLabel(name));
		this.setLayout(new BoxLayout( this ,BoxLayout.Y_AXIS));
	}
	
	public void addTask(Task t) {
		list.addTask(t);
		add(new TaskButton(t));
		this.revalidate();
	}
	
	public void showWorkDialog() {
		Task nextTask = list.getWork();
		if(nextTask == null) {
			JOptionPane.showMessageDialog(this,"There is no more work to do!");
		}else {
			String work = "The next task you should do is " + nextTask.getDescription();
			JOptionPane.showMessageDialog(this,work);
		}
	}

}
