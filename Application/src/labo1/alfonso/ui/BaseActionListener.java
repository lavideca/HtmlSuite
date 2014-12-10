package labo1.alfonso.ui;

import java.awt.event.ActionListener;

public abstract class BaseActionListener implements ActionListener {
	private MainWindow parent;
	
	protected MainWindow getParent() {
		return parent;
	}

	protected void setParent(MainWindow parent) {
		this.parent = parent;
	}

	public BaseActionListener(MainWindow parent) {
		this.setParent(parent);
	}
}
