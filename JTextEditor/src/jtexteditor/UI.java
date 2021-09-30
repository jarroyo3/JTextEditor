package jtexteditor;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import jtexteditor.controller.EditorController;
import jtexteditor.factory.UIComponentFactory;
import jtexteditor.utils.StringUtils;
import jtexteditor.view.toolbar.menu.MenuBar;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel backgroundPanel;
	private JTextArea textArea;
	private MenuBar menuBar;
	private JToolBar toolbar;
	private JScrollPane scrollTextArea;

	public UI(EditorController controller) {
		init(controller);
	}

	private void saveAs() throws IOException {
		JFileChooser saveFileChoose = new JFileChooser();
		int optionSaveFile = saveFileChoose.showSaveDialog(this);
		if (optionSaveFile == JFileChooser.APPROVE_OPTION) {
			File file = saveFileChoose.getSelectedFile();
			setTitle(file.getName() + " | ");
			BufferedWriter out = new BufferedWriter(new FileWriter(file.getPath()));
			out.write(textArea.getText());
			out.close();
		}
	}

	private void init(EditorController controller) {
		textArea = UIComponentFactory.INSTANCE.createTextArea();
		this.toolbar = UIComponentFactory.INSTANCE.getToolBar();
		backgroundPanel = UIComponentFactory.INSTANCE.createJPanel();
		this.menuBar = new MenuBar();
		menuBar.addListenerSubscription(controller);
		this.scrollTextArea = UIComponentFactory.INSTANCE.createTextScroll(textArea);

		backgroundPanel.add(BorderLayout.CENTER, this.scrollTextArea);
		backgroundPanel.add(BorderLayout.PAGE_START, this.toolbar);
		this.getContentPane().add(BorderLayout.CENTER, backgroundPanel);
		this.setTitle("New Document");
		this.setLocationByPlatform(true);
		this.setJMenuBar(this.menuBar);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
	}

	public void clearTextArea() {
		textArea.setText(StringUtils.EMPTY);
	}

	public void write(BufferedWriter out) throws IOException {
		textArea.write(out);

	}

	public String retrieveTextAreaContent() {
		return textArea.getText();
	}
}
