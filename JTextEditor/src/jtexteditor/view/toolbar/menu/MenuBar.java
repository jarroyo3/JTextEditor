package jtexteditor.view.toolbar.menu;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import jtexteditor.view.ListenerSuscription;

public class MenuBar extends JMenuBar implements ListenerSuscription {

	private static final long serialVersionUID = 3082735998114712163L;

	private static List<JMenu> menuOptions;

	private JMenu fileMenu = new FileMenu();
	private JMenu editMenu = new EditMenu();
	private JMenu helpMenu = new HelpMenu();

	public MenuBar() {
		menuOptions = List.of(fileMenu, editMenu, helpMenu);
		menuOptions.forEach(this::add);
	}

	public void addListenerSubscription(ActionListener listener) {
		menuOptions.forEach(menu -> {
			ListenerSuscription menuListenerSubsriptor = (ListenerSuscription) menu;
			menuListenerSubsriptor.addListenerSubscription(listener);
		});
	}
}
