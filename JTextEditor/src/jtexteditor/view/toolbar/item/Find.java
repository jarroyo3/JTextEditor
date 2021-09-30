package jtexteditor.view.toolbar.item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class Find extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Find() {
		super(new DefaultEditorKit.CopyAction());
		setText("Find");
		setToolTipText("Find");
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
	}
}
