package loyy.util;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingConsole {


	
	public static void run(final JFrame f,final int width,final int height){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				f.setTitle("剃刀1号");
				f.setSize(width,height);
				f.setVisible(true);
			}
		});
	}

}
