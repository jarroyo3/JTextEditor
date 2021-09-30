package jtexteditor.view.toolbar.item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class OpenFile extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpenFile() {
		super(new DefaultEditorKit.CopyAction());
		setText("Open");
		setToolTipText("Open file");
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, InputEvent.CTRL_MASK));
	}
}
