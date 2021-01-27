/**
 * @Project_Name 32_AnhNH_Ex1_Quan Ly
 */
package com.luvina.test.main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.luvina.test.gui.frame.MainFrame;

/**
 * @author Hoang Anh
 * @since 26 thg 1, 2021
 * @version 1.0
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// set look and feel to system dependent
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

}
