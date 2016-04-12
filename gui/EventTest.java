package demo.gui;

import static demo.BaseDemo.*;

import java.awt.event.*;

import javax.swing.*;

public class EventTest {
	static class MyButton extends JButton {
		private static final long serialVersionUID = 1L;

		// 目前想到的所有事件
		MyButton() {
			this.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) { println("focusGained");	}
				public void focusLost(FocusEvent e) { println("focusLost");	}
			});
			this.addKeyListener(new KeyListener() {
				public void keyTyped(KeyEvent e) { println(e.paramString()); }
				public void keyPressed(KeyEvent e) { println(e.paramString()); }
				public void keyReleased(KeyEvent e) {println(e.paramString()); }
			});
			this.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) { println(e.paramString()); }
				public void mousePressed(MouseEvent e) { println(e.paramString()); }
				public void mouseReleased(MouseEvent e) {println(e.paramString()); }
				public void mouseEntered(MouseEvent e) { println(e.paramString()); }
				public void mouseExited(MouseEvent e) {  println(e.paramString()); }
			});
			this.addMouseMotionListener(new MouseMotionListener() {
				public void mouseDragged(MouseEvent e) { println(e.paramString()); }
				public void mouseMoved(MouseEvent e) { println(e.paramString()); }
			});
			this.addMouseWheelListener(new MouseWheelListener() {
				public void mouseWheelMoved(MouseWheelEvent e) { println(e.paramString()); }
			});
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.add(new MyButton());
		SwingConsole.run(f, 300, 300);
	}
}
