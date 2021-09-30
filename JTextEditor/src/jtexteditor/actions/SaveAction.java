package jtexteditor.actions;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jtexteditor.controller.Controller;
import jtexteditor.controller.EditorController;
import jtexteditor.utils.Constants;

public class SaveAction extends ActionHandler {

	public SaveAction(Controller controller) {
		super(controller);
	}

	@Override
	public void handle(ActionEvent actionEvent) throws IOException {
		if (Constants.SAVE_TEXT.equals(actionEvent.getActionCommand())) {
			System.out.println("SSSSSSSS");
			if (openFileChoose != null) {
				EditorController controller = ((EditorController) this.controller);
				File file = openFileChoose.getSelectedFile();
				controller.setUiTitle(file.getName());
				try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
					controller.writeTextArea(out);
					out.close();

				} catch (IOException ioe) {
					System.out.println("SaveAction:: Error while buffering and writing text area content");
				}
			} else {
				new SaveAsAction(controller).handle(actionEvent);
			}
		}
	}
}
