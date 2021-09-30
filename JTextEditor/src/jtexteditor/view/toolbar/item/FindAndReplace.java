package jtexteditor.view.toolbar.item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class FindAndReplace extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FindAndReplace() {
		super(new DefaultEditorKit.CopyAction());
		setText("Find and replace");
		setToolTipText("Find and replace");
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
	}
}
