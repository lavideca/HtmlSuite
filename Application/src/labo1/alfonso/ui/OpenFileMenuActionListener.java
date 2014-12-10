package labo1.alfonso.ui;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;

import labo1.alfonso.business.HtmlParsingService;
import labo1.alfonso.model.HtmlDocument;

public class OpenFileMenuActionListener extends BaseActionListener {
	public OpenFileMenuActionListener(MainWindow parent) {
		super(parent);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this.getParent());
		String path = fc.getSelectedFile().getAbsolutePath();
		try {
			HtmlDocument doc = HtmlParsingService.getHtmlDocumentFromPath(path);
			this.getParent().FillTree(doc.getDocument());
			this.getParent().resetSize();
			this.getParent().setVisible(true);
		} catch (ParserConfigurationException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
