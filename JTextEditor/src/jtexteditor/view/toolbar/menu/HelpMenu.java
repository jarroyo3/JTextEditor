package jtexteditor.view.toolbar.menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;

import jtexteditor.view.ListenerSuscription;

public class HelpMenu extends JMenu implements ListenerSuscription {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3322957589595752543L;

	public HelpMenu() {
		setText("Help");
	}

	@Override
	public void addListenerSubscription(ActionListener listener) {
		// TODO develop
	}
}
