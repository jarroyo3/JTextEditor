package jtexteditor.view.toolbar.item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class Copy extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Copy() {
		super(new DefaultEditorKit.CopyAction());
		setText("Copy");
		setToolTipText("Copy");
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
	}
}
