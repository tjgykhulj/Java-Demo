package demo.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonEventTest extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	private JButton 
		b1 = new JButton("Append"),
		b2 = new JButton("Clear");
	private JTextArea txt = new JTextArea(6, 10);
	
	private ButtonEventTest() {
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { txt.append("test\n"); }
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { txt.setText(""); }
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(txt));
		add(b1);
		add(b2);
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new ButtonEventTest(), 400, 400);
	}

}
