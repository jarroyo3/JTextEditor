package jtexteditor.view.toolbar.menu;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import jtexteditor.view.ListenerSuscription;
import jtexteditor.view.toolbar.item.Copy;
import jtexteditor.view.toolbar.item.Cut;
import jtexteditor.view.toolbar.item.Find;
import jtexteditor.view.toolbar.item.FindAndReplace;
import jtexteditor.view.toolbar.item.Paste;
import jtexteditor.view.toolbar.item.SelectAll;

public class EditMenu extends JMenu implements ListenerSuscription {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3322957589595752543L;
	private static List<JMenuItem> menuItems;

	private JMenuItem cut;
	private JMenuItem copy;
	private JMenuItem paste;
	private JMenuItem selectAll;
	private JMenuItem find;
	private JMenuItem findAndReplace;

	public EditMenu() {
		setText("Edit");
		cut = new Cut();
		copy = new Copy();
		paste = new Paste();
		selectAll = new SelectAll();
		find = new Find();
		findAndReplace = new FindAndReplace();
		menuItems = List.of(cut, copy, paste, selectAll, find, findAndReplace);
		menuItems.forEach(this::add);
	}

	public void addListenerSubscription(ActionListener listener) {
		menuItems.forEach(menuItem -> menuItem.addActionListener(listener));
	}
}
