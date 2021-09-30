package jtexteditor.actions;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFileChooser;

import jtexteditor.controller.Controller;

public abstract class ActionHandler {

	protected Controller controller;
	protected JFileChooser openFileChoose;

	public ActionHandler(Controller controller) {
		this.controller = controller;
	}

	public abstract void handle(ActionEvent actionEvent) throws IOException;
}
