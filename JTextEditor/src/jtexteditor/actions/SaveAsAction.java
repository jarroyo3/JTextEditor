package jtexteditor.actions;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import jtexteditor.controller.Controller;
import jtexteditor.controller.EditorController;

public class SaveAsAction extends ActionHandler {

	public SaveAsAction(Controller controller) {
		super(controller);
	}

	@Override
	public void handle(ActionEvent actionEvent) throws IOException {
		JFileChooser saveFileChoose = new JFileChooser();
		EditorController c = (EditorController) controller;
		int optionSaveFile = saveFileChoose.showSaveDialog(c.getUI());
		if (optionSaveFile == JFileChooser.APPROVE_OPTION) {
			File file = saveFileChoose.getSelectedFile();
			c.setUiTitle(file.getName());
			BufferedWriter out = new BufferedWriter(new FileWriter(file.getPath()));
			out.write(c.retrieveTextAreaContent());
			out.close();
		}
	}
}
