package jtexteditor.view.toolbar.item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class SelectAll extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SelectAll() {
		super(new DefaultEditorKit.CopyAction());
		setText("Select All");
		setToolTipText("Select all");
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
	}
}
