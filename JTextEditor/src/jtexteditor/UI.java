package jtexteditor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Highlighter;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class UI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel backgroundPanel;
	private JTextArea mainTextArea;;
	private Highlighter highlighter;
	private JMenuItem newFile, openFile, saveFile, saveAsFile, cut, copy,
			paste, selectAll, find, findAndReplace;
	private JFileChooser openFileChoose;

	public UI() {
		backgroundPanel = new JPanel();
		mainTextArea = new JTextArea();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newFile) {
			EditorController.clear(mainTextArea);
		} else if (e.getSource() == openFile) {
			openFileChoose = new JFileChooser();
			int optionOpenFile = openFileChoose.showOpenDialog(this);
			if (optionOpenFile == JFileChooser.APPROVE_OPTION) {
				EditorController.clear(mainTextArea);
				this.setTitle(openFileChoose.getSelectedFile().getName());
				try {
					Scanner scan = new Scanner(new FileReader(openFileChoose
							.getSelectedFile().getPath()));
					while (scan.hasNext())
						mainTextArea.append(scan.nextLine() + "\n");
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		} else if (e.getSource() == saveAsFile) {
			try {
				saveAs();
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
		} else if (e.getSource() == saveFile) {
			try {
				save();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		} else if (e.getSource() == cut) {
			mainTextArea.cut();
		} else if (e.getSource() == copy) {
			mainTextArea.copy();
		} else if (e.getSource() == paste) {
			mainTextArea.paste();
		} else if (e.getSource() == find) {
			new FindDialog(mainTextArea, false);
		} else if (e.getSource() == findAndReplace) {
			new FindDialog(mainTextArea, true);
		}

	}

	private void save() throws IOException {
		if (openFileChoose != null) {
			File file = openFileChoose.getSelectedFile();
			setTitle(file.getName());
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			mainTextArea.write(out);
			out.close();
		} else {
			saveAs();
		}
	}

	private void saveAs() throws IOException {
		JFileChooser saveFileChoose = new JFileChooser();
		int optionSaveFile = saveFileChoose.showSaveDialog(this);
		if (optionSaveFile == JFileChooser.APPROVE_OPTION) {
			File file = saveFileChoose.getSelectedFile();
			setTitle(file.getName() + " | ");
			BufferedWriter out = new BufferedWriter(new FileWriter(
					file.getPath()));
			out.write(mainTextArea.getText());
			out.close();
		}
	}

	public void init() {
		initMenuActions();
		initMainPanel();
	}

	private void initMainPanel() {
		this.getContentPane().add(BorderLayout.CENTER, backgroundPanel);
		this.setTitle("New Document" + "-SimpleTextEditor v.1");
		this.setLocationByPlatform(true);
		backgroundPanel.setLayout(new BorderLayout());
		this.setJMenuBar(buildMenu());
		backgroundPanel.add(BorderLayout.CENTER, getNotePadTextArea());
		backgroundPanel.add(BorderLayout.PAGE_START, getToolBar());

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
	}

	private void initMenuActions() {

		newFile = new JMenuItem(new DefaultEditorKit.CopyAction());
		newFile.addActionListener(this);
		newFile.setText("New");
		newFile.setToolTipText("New file");
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));

		openFile = new JMenuItem(new DefaultEditorKit.CopyAction());
		openFile.addActionListener(this);
		openFile.setText("Open");
		openFile.setToolTipText("Open file");
		openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));

		saveFile = new JMenuItem(new DefaultEditorKit.CopyAction());
		saveFile.addActionListener(this);
		saveFile.setText("Save");
		saveFile.setToolTipText("Save file");
		saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));

		saveAsFile = new JMenuItem(new DefaultEditorKit.CopyAction());
		saveAsFile.addActionListener(this);
		saveAsFile.setText("Save As");
		saveAsFile.setToolTipText("Save as...");
		saveAsFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));

		cut = new JMenuItem(new DefaultEditorKit.CopyAction());
		cut.addActionListener(this);
		cut.setText("Cut");
		cut.setToolTipText("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));

		copy = new JMenuItem(new DefaultEditorKit.CopyAction());
		copy.addActionListener(this);
		copy.setText("Copy");
		copy.setToolTipText("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));

		paste = new JMenuItem(new DefaultEditorKit.CopyAction());
		paste.addActionListener(this);
		paste.setText("Paste");
		paste.setToolTipText("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));

		selectAll = new JMenuItem(new DefaultEditorKit.CopyAction());
		selectAll.addActionListener(this);
		selectAll.setText("Select All");
		selectAll.setToolTipText("Select all");
		selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));

		find = new JMenuItem(new DefaultEditorKit.CopyAction());
		find.addActionListener(this);
		find.setText("Find");
		find.setToolTipText("Find");
		find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
				InputEvent.CTRL_MASK));

		findAndReplace = new JMenuItem(new DefaultEditorKit.CopyAction());
		findAndReplace.addActionListener(this);
		findAndReplace.setText("Find and replace");
		findAndReplace.setToolTipText("Find and replace");
		findAndReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,
				InputEvent.CTRL_MASK));
	}

	private JMenuBar buildMenu() {
		JMenuBar menu = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");

		file.add(newFile);
		file.add(openFile);
		file.add(saveFile);
		file.add(saveAsFile);
		menu.add(file);

		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectAll);
		edit.add(find);
		edit.add(findAndReplace);
		menu.add(edit);

		menu.add(help);

		return menu;
	}

	private JScrollPane getNotePadTextArea() {
		Font mainFont = new Font("Ariala", Font.PLAIN, 12);

		mainTextArea.setFont(mainFont);
		mainTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		mainTextArea.addMouseListener(new MouseAdapter() {
		});
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);

		JScrollPane textScroll = new JScrollPane(mainTextArea);
		textScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textScroll
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		return textScroll;
	}

	private JToolBar getToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.addSeparator();
		toolBar.addSeparator();
		toolBar.setFloatable(false);

		return toolBar;
	}
}
