package jtexteditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class FindDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel labelFind, labelFindAndReplace;
	private JButton btnFind, btnFindNext, btnReplace, btnReplaceAll, btnCancel;
	private JTextField textFind, textFindAndReplace;
	private JTextArea mainTextArea;

	private int windowWidth = 400;
	private int windowHeight = 150;
	private int keepSearch;
	private JPanel backgroundPanel;

	private boolean isFindAndReplace;
	private Highlighter highlighter;

	public FindDialog(JTextArea mainTextArea, boolean isFindAndReplace) {
		this.mainTextArea = mainTextArea;
		this.isFindAndReplace = isFindAndReplace;
		highlighter = mainTextArea.getHighlighter();
		init();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			highlighter.removeAllHighlights();
			setVisible(false);
		} else if (e.getSource() == btnFind) {
			highlighter.removeAllHighlights();
			keepSearch = 0;
			find();
		} else if (e.getSource() == btnFindNext) {
			highlighter.removeAllHighlights();
			find();
			// findNext();
		} else if (e.getSource() == btnReplace) {
			keepSearch = 0;
			find();
			replace();
		} else if (e.getSource() == btnReplaceAll) {
			do {
				find();
				replace();
            }while(mainTextArea.getText().contains(textFind.getText()));
		}

	}

	private void replace() {
		String text = mainTextArea.getText();
		String findString = textFind.getText();
		String replaceString = textFindAndReplace.getText();
		text = text.replaceFirst(findString, replaceString);
		mainTextArea.setText(text);
	}

	private void find() {
		String textToFind = textFind.getText().toLowerCase();
		String text = mainTextArea.getText();

		int startPoint = text.indexOf(textToFind, keepSearch);
		int endPoint = startPoint + textToFind.length();

		if (textToFind.length() < 1) {
			JOptionPane.showMessageDialog(null, "Nothing to find");
			return;
		}

		if (startPoint != -1) {
			Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(
					Color.YELLOW);
			try {
				highlighter.addHighlight(startPoint, endPoint, painter);
			} catch (BadLocationException e) {
				e.printStackTrace();
			} finally {
				keepSearch = endPoint;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Text \"" + textToFind
					+ "\" not found");
			return;
		}
	}

	private void init() {
		String title = "Find";

		backgroundPanel = new JPanel();
		labelFind = new JLabel("Find:");
		labelFindAndReplace = new JLabel("Replace:");
		textFind = new JTextField(30);
		textFindAndReplace = new JTextField(30);
		btnFind = new JButton("Find");
		btnFindNext = new JButton("Find Next");
		btnReplace = new JButton("Replace");
		btnReplaceAll = new JButton("Replace All");
		btnCancel = new JButton("Cancel");

		int labWidth = 80;
		int labHeight = 30;

		labelFind.setBounds(10, 10, labWidth, labHeight);
		add(labelFind);
		textFind.setBounds(10 + labWidth, 10, 120, 30);
		add(textFind);

		btnFind.setBounds(225, 6, 115, 20);
		add(btnFind);
		btnFind.addActionListener(this);

		btnFindNext.setBounds(225, 28, 115, 20);
		add(btnFindNext);
		btnFindNext.addActionListener(this);

		int btnCancelPositionY = 70;
		if (isFindAndReplace) {
			labHeight = 20;
			btnCancelPositionY = 94;
			windowHeight = 180;
			title += " and replace";
			labelFindAndReplace.setBounds(10, 10 + labHeight + 10, labWidth,
					labHeight);
			add(labelFindAndReplace);
			textFindAndReplace.setBounds(10 + labWidth, 10 + labHeight + 10,
					120, 30);
			add(textFindAndReplace);

			btnReplace.setBounds(225, 50, 115, 20);
			add(btnReplace);
			btnReplace.addActionListener(this);

			btnReplaceAll.setBounds(225, 72, 115, 20);
			add(btnReplaceAll);
			btnReplaceAll.addActionListener(this);
		}

		btnCancel.setBounds(225, btnCancelPositionY, 115, 20);
		add(btnCancel);
		btnCancel.addActionListener(this);

		setLayout(null);
		setLocationByPlatform(true);
		setSize(windowWidth, windowHeight);
		setTitle(title);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
	}

}
