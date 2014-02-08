package loyy.util;
import static loyy.util.SwingConsole.run;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Trim extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width=30;
	int height=30;
	private JTextArea t1=new JTextArea(width,height),t2=new JTextArea(width,height),t3=new JTextArea(width,height);
	
	
	public Trim(){
		setLayout(new FlowLayout());
		add(t1);
		add(t2);
		add(t3);
	}
	public static void main(String[] args) {
	run(new Trim(),800,900);	
	}
}
