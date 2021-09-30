package jtexteditor.view.toolbar.menu;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import jtexteditor.view.ListenerSuscription;
import jtexteditor.view.toolbar.item.NewFile;
import jtexteditor.view.toolbar.item.OpenFile;
import jtexteditor.view.toolbar.item.SaveAsFile;
import jtexteditor.view.toolbar.item.SaveFile;

public class FileMenu extends JMenu implements ListenerSuscription {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3322957589595752543L;

	private List<JMenuItem> menuItems;
	private JMenuItem newFile = new NewFile();
	private JMenuItem openFile = new OpenFile();
	private JMenuItem saveFile = new SaveFile();
	private JMenuItem saveAs = new SaveAsFile();

	public FileMenu() {
		setText("File");
		menuItems = List.of(newFile, openFile, saveFile, saveAs);
		menuItems.forEach(this::add);
	}

	public void addListenerSubscription(ActionListener listener) {
		menuItems.forEach(menuItem -> menuItem.addActionListener(listener));
	}
}
