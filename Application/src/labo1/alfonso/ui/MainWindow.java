package labo1.alfonso.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTree;

import labo1.alfonso.model.TreeModelAdapter;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.w3c.dom.Document;

public class MainWindow extends JFrame {
	private JTree tree;
    
	public JTree getTree() {
		return tree;
	}

	public MainWindow() {
		this.setTitle("Labo 1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.createMenuBar();
		this.createSyntaxArea();
		this.setLocationRelativeTo(null);
		this.resetSize();
	}
	
	public void resetSize() {
		this.pack();
		this.setVisible(true);
	}
	
	public void FillTree(Document root) {
		this.tree = new JTree(new TreeModelAdapter(root));
	    this.add(tree, BorderLayout.WEST);
	}
	
	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		JMenuItem menuItem = new JMenuItem("Open file");
		menuItem.setMnemonic(KeyEvent.VK_O);
		menuItem.addActionListener(new OpenFileMenuActionListener(this));
		menu.add(menuItem);
		menuBar.add(menu);
		this.add(menuBar, BorderLayout.NORTH);
	}
	
	private void createSyntaxArea() {
		RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
	    textArea.setCodeFoldingEnabled(true);
	    textArea.setAntiAliasingEnabled(true);
	    RTextScrollPane sp = new RTextScrollPane(textArea);
	    sp.setFoldIndicatorEnabled(true);
	    this.add(sp, BorderLayout.EAST);
	}
}