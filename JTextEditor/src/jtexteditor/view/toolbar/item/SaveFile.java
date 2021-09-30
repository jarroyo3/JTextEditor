package jtexteditor.view.toolbar.item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

public class SaveFile extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaveFile() {
		super(new DefaultEditorKit.CopyAction());
		setText("Save");
		setToolTipText("Save file");
		setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
	}
}
