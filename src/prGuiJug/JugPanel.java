package prGuiJug;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class JugPanel extends JPanel implements JugView {
	private JLabel jugALabel;
	private JLabel jugBLabel;
	private JButton FillJugAButton;
	private JButton FillJugBButton;
	private JTextField contentJugAText;
	private JTextField contentJugBText;
	private JTextField capacityJugAText;
	private JTextField capacityJugBText;
	private JButton emptyJugAButton;
	private JButton emptyJugBButton;
	private JTextArea historyTextArea;
	private JLabel informationLabel;
	private JButton pourA2BButton;
	private JButton pourB2AButton;
	private JButton goButton;
	private JTextField initialJugACapacityText;
	private JTextField initialJugBCapacityText;
	private JLabel jugAContentLabel;
	private JLabel jugACapacityLabel;
	private JLabel jugBContentLabel;
	private JLabel jugBCapacityLabel;
	private JButton endButton;

	public JugPanel() 
	{
		setLayout(new BorderLayout(5, 5));

		// Creating Capacity Panel
		JPanel setCapacityPanel = new JPanel();
		setCapacityPanel.setLayout(new GridLayout(1, 3, 2, 2));
		capacityJugAText = new JTextField(4);
		capacityJugBText = new JTextField(4);
		jugALabel = new JLabel("Jug A");
		jugBLabel = new JLabel("Jug B");
		initialJugACapacityText = new JTextField(4);
		initialJugBCapacityText = new JTextField(4);
		goButton = new JButton("Setting Capacities");
		JPanel jugAInitialCapacityPanel = new JPanel();
		jugAInitialCapacityPanel.setLayout(new FlowLayout());
		jugAInitialCapacityPanel.add(jugALabel);
		jugAInitialCapacityPanel.add(initialJugACapacityText);
		JPanel jugBInitialCapacityPanel = new JPanel();
		jugBInitialCapacityPanel.setLayout(new FlowLayout());
		jugBInitialCapacityPanel.add(jugBLabel);
		jugBInitialCapacityPanel.add(initialJugBCapacityText);
		setCapacityPanel.add(jugAInitialCapacityPanel);
		setCapacityPanel.add(goButton);
		setCapacityPanel.add(jugBInitialCapacityPanel);

		// Central Panel
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new GridLayout(2, 1, 5, 5));

		// Jugs Panel
		JPanel jugsPanel = new JPanel();
		jugsPanel.setLayout(new GridLayout(1, 3, 5, 5));

		// Jug A Panel
		JPanel jugAPanel = new JPanel();
		jugAPanel.setLayout(new GridLayout(4, 1, 2, 2));
		FillJugAButton = new JButton("Fill");
		contentJugAText = new JTextField(4);
		contentJugAText.setEditable(false);
		capacityJugAText = new JTextField(4);
		capacityJugAText.setEditable(false);
		emptyJugAButton = new JButton("Empty");
		jugAContentLabel = new JLabel("Content: ");
		jugACapacityLabel = new JLabel("Capacity: ");
		JPanel jugAContentPanel = new JPanel();
		JPanel jugACapacityPanel = new JPanel();
		jugAContentPanel.setLayout(new FlowLayout());
		jugAContentPanel.add(jugAContentLabel);
		jugAContentPanel.add(contentJugAText);
		jugACapacityPanel.setLayout(new FlowLayout());
		jugACapacityPanel.add(jugACapacityLabel);
		jugACapacityPanel.add(capacityJugAText);
		jugAPanel.add(FillJugAButton);
		jugAPanel.add(jugAContentPanel);
		jugAPanel.add(jugACapacityPanel);
		jugAPanel.add(emptyJugAButton);

		// Arrows Panel
		JPanel arrowsPanel = new JPanel();
		arrowsPanel.setLayout(new GridLayout(3, 1, 2, 2));
		pourA2BButton = new JButton(new ImageIcon("imagenes/go-next.jpg"));
		pourB2AButton = new JButton(new ImageIcon("imagenes/go-previous.jpg"));
		
		endButton = new JButton("End");
		arrowsPanel.add(pourA2BButton);
		arrowsPanel.add(pourB2AButton);
		arrowsPanel.add(endButton);

		// Jug B Panel
		JPanel jugBPanel = new JPanel();
		jugBPanel.setLayout(new GridLayout(4, 1, 2, 2));
		FillJugBButton = new JButton("Fill");
		contentJugBText = new JTextField(4);
		contentJugBText.setEditable(false);
		capacityJugBText = new JTextField(4);
		capacityJugBText.setEditable(false);
		emptyJugBButton = new JButton("Empty");
		jugBContentLabel = new JLabel("Content: ");
		jugBCapacityLabel = new JLabel("Capacity: ");
		JPanel jugBContentPanel = new JPanel();
		JPanel jugBCapacityPanel = new JPanel();
		jugBContentPanel.setLayout(new FlowLayout());
		jugBContentPanel.add(jugBContentLabel);
		jugBContentPanel.add(contentJugBText);
		jugBCapacityPanel.setLayout(new FlowLayout());
		jugBCapacityPanel.add(jugBCapacityLabel);
		jugBCapacityPanel.add(capacityJugBText);

		jugBPanel.add(FillJugBButton);
		jugBPanel.add(jugBContentPanel);
		jugBPanel.add(jugBCapacityPanel);
		jugBPanel.add(emptyJugBButton);

		// History Panel
		historyTextArea = new JTextArea();
		historyTextArea.setEditable(false);
		JScrollPane historyPanel = new JScrollPane(historyTextArea);

		// informacion Label
		informationLabel = new JLabel();

		// Built all panels together
		jugsPanel.add(jugAPanel);
		jugsPanel.add(arrowsPanel);
		jugsPanel.add(jugBPanel);
		centralPanel.add(jugsPanel);
		centralPanel.add(historyPanel);
		add(setCapacityPanel, BorderLayout.NORTH);
		add(centralPanel, BorderLayout.CENTER);
		add(informationLabel, BorderLayout.SOUTH);
	}

	public void controller(ActionListener al) 
	{
		goButton.addActionListener(al);
		FillJugAButton.addActionListener(al);
		FillJugBButton.addActionListener(al);
		emptyJugAButton.addActionListener(al);
		emptyJugBButton.addActionListener(al);
		pourA2BButton.addActionListener(al);
		pourB2AButton.addActionListener(al);
		endButton.addActionListener(al);
		goButton.setActionCommand(JugView.GO);
		FillJugAButton.setActionCommand(JugView.FILL_A);
		FillJugBButton.setActionCommand(JugView.FILL_B);
		emptyJugAButton.setActionCommand(JugView.EMPTY_A);
		emptyJugBButton.setActionCommand(JugView.EMPTY_B);
		pourA2BButton.setActionCommand(JugView.POUR_A2B);
		pourB2AButton.setActionCommand(JugView.POUR_B2A);
		endButton.setActionCommand(JugView.END);
	}

	public void error(String msg) 
	{
		informationLabel.setForeground(Color.RED);
		informationLabel.setText(msg);
	}

	public void ok(String msg) 
	{
		informationLabel.setForeground(Color.BLUE);
		informationLabel.setText(msg);
	}

	public void enableSetting(boolean b) 
	{
		jugALabel.setEnabled(b);
		jugBLabel.setEnabled(b);
		goButton.setEnabled(b);
		initialJugACapacityText.setEnabled(b);
		initialJugBCapacityText.setEnabled(b);

		FillJugAButton.setEnabled(!b);
		FillJugBButton.setEnabled(!b);
		emptyJugAButton.setEnabled(!b);
		emptyJugBButton.setEnabled(!b);
		jugAContentLabel.setEnabled(!b);
		jugBContentLabel.setEnabled(!b);
		jugACapacityLabel.setEnabled(!b);
		jugBCapacityLabel.setEnabled(!b);
		pourA2BButton.setEnabled(!b);
		pourB2AButton.setEnabled(!b);
		endButton.setEnabled(!b);
	}

	public int getCapacityJugA() 
	{
		return Integer.parseInt(initialJugACapacityText.getText());
	}

	public int getCapacityJugB() 
	{
		return Integer.parseInt(initialJugBCapacityText.getText());
	}

	public void setJugACapacity(int c) 
	{
		capacityJugAText.setText("" + c);
	}

	public void setJugBCapacity(int c) 
	{
		capacityJugBText.setText("" + c);
	}

	public void setJugAContent(int c) 
	{
		contentJugAText.setText("" + c);
	}

	public void setJugBContent(int c) 
	{
		contentJugBText.setText("" + c);
	}

	public void addMessage2History(String msg) 
	{
		historyTextArea.append(msg + "\n");
	}

	public void clearHistory() 
	{
		historyTextArea.setText("");
		capacityJugAText.setText("");
		capacityJugBText.setText("");
		contentJugAText.setText("");
		contentJugBText.setText("");
	}

}