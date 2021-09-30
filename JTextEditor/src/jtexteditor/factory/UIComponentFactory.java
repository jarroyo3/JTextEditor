package jtexteditor.factory;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import jtexteditor.MouseEvent;

public enum UIComponentFactory {

	INSTANCE;

	public JTextArea createTextArea() {
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Ariala", Font.PLAIN, 12));
		textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		textArea.addMouseListener(new MouseEvent());
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		return textArea;
	}

	public JToolBar getToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.addSeparator();
		toolBar.addSeparator();
		toolBar.setFloatable(false);
		return toolBar;
	}

	public JPanel createJPanel() {
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new BorderLayout());
		return backgroundPanel;
	}

	public JScrollPane createTextScroll(JTextArea textArea) {
		JScrollPane textScroll = new JScrollPane(textArea);
		textScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		return textScroll;
	}
}
