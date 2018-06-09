import javax.swing.JFrame;
import javax.swing.JPanel;

import prGuiJug.*;

public class JugsApplication 
{

	public static void main(String[] args) 
	{
		JugView jugsPanel = new JugPanel();
		JugController jugCtrl = new JugController(jugsPanel);
		jugsPanel.controller(jugCtrl);
		jugsPanel.enableSetting(true);
		
		JFrame ventana = new JFrame("Jugs");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel)jugsPanel);
		ventana.pack();
		ventana.setVisible(true);
	}

}

