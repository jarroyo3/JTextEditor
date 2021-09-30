package jtexteditor.view.toolbar.item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class NewFile extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewFile() {
		super(new DefaultEditorKit.CopyAction());
		setText("New");
		setToolTipText("New file");
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
	}
}
