package jtexteditor.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import jtexteditor.UI;
import jtexteditor.actions.ActionHandler;
import jtexteditor.actions.SaveAction;
import jtexteditor.utils.Constants;

public class EditorController implements ActionListener, WindowListener, Controller {

	private UI ui;
	private Map<String, ActionHandler> commands;

	public EditorController() {
		this.ui = new UI(this);
		commands = Map.of(Constants.SAVE_TEXT, new SaveAction(this));
	}

	public void clearTextArea() {
		ui.clearTextArea();
	}

	public void setUiTitle(String title) {
		ui.setTitle(title);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("AAAAAAAAAAAA");
		System.out.println(e.getActionCommand());
		try {
			commands.get(e.getActionCommand()).handle(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
//		if (e.getSource() == newFile) {
//			clearTextArea();
//		} else if (e.getSource() == openFile) {
//			openFileChoose = new JFileChooser();
//			int optionOpenFile = openFileChoose.showOpenDialog(this);
//			if (optionOpenFile == JFileChooser.APPROVE_OPTION) {
//				clearTextArea();
//				this.setTitle(openFileChoose.getSelectedFile().getName());
//				try {
//					Scanner scan = new Scanner(new FileReader(openFileChoose.getSelectedFile().getPath()));
//					while (scan.hasNext()) {
//						textArea.append(scan.nextLine() + "\n");
//					}
//					scan.close();
//				} catch (Exception e1) {
//					System.out.println(e1.getMessage());
//				}
//			}
//		} else if (e.getSource() == saveAsFile) {
//			try {
//				saveAs();
//			} catch (IOException e1) {
//				System.out.println(e1.getMessage());
//			}
//		} else if (e.getSource() == saveFile) {
//			try {
//				save();
//			} catch (Exception e2) {
//				System.out.println(e2.getMessage());
//			}
//		} else if (e.getSource() == cut) {
//			textArea.cut();
//		} else if (e.getSource() == copy) {
//			textArea.copy();
//		} else if (e.getSource() == paste) {
//			textArea.paste();
//		} else if (e.getSource() == find) {
//			new FindDialog(textArea, false);
//		} else if (e.getSource() == findAndReplace) {
//			new FindDialog(textArea, true);
//		}

	}

	public void writeTextArea(BufferedWriter out) {
		try {
			ui.write(out);
		} catch (IOException ioe) {
			// TODO show alert message
			System.out.println("An error ocurred while writting content" + ioe.getMessage());
		}

	}

	public String retrieveTextAreaContent() {
		return ui.retrieveTextAreaContent();
	}

	public Component getUI() {
		return ui;
	}

}
