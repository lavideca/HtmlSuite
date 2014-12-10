package labo1.alfonso.console;

import labo1.alfonso.ui.MainWindow;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        		MainWindow window = new MainWindow();
        		window.toString();
            }
        });
	}

}
