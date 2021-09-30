package jtexteditor.view.toolbar.item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class Paste extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Paste() {
		super(new DefaultEditorKit.CopyAction());
		setText("Paste");
		setToolTipText("Paste");
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
	}
}
