package jtexteditor.view.toolbar.item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class Cut extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cut() {
		super(new DefaultEditorKit.CopyAction());
		setText("Cut");
		setToolTipText("Cut");
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
	}
}
