/**
 * @Project_Name 32_AnhNH_Ex1_Quan Ly
 */
package com.luvina.test.gui.frame;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.luvina.test.gui.icommon.ICommon;
import com.luvina.test.gui.icommon.IPanelAction;
import com.luvina.test.gui.panel.AddStudentPanel;
import com.luvina.test.gui.panel.ManagerPanel;

/**
 * @author Hoang Anh
 * @since 26 thg 1, 2021
 * @version 1.0
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ICommon, IPanelAction {

	public static final int WIDTH = 770 + 16;
	public static final int HEIGHT = 500 + 39;

	public static final Font fontHeader = new Font("Calibri", Font.BOLD, 36);
	public static final Font fontNormal = new Font("Calibri", Font.PLAIN, 16);

	private ManagerPanel managerPanel;
	private AddStudentPanel addStudentPanel;
	
	

	/**
	 * 
	 */
	public MainFrame() {
		init();
		addComponent();
		addEvent();
	}

	@Override
	public void init() {
		setTitle("Student Manager");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		
	}

	@Override
	public void addComponent() {
		managerPanel = new ManagerPanel();
		managerPanel.addPanelAction(this);

		addStudentPanel = new AddStudentPanel();
		addStudentPanel.addPanelAction(this);
		addStudentPanel.setVisible(false);
		
		add(managerPanel);
		add(addStudentPanel);
	}

	@Override
	public void addEvent() {
		windowListen();
	}
	
	@Override
	public void changePanel(String panelName) {
		if("manager".equals(panelName)) {
			managerPanel.setVisible(true);
			addStudentPanel.setVisible(false);
			managerPanel.updateTable();
		} else {
			managerPanel.setVisible(false);
			addStudentPanel.setVisible(true);
		}
	}
	

	@Override
	public void changePanel(String panelName, String userID) {
		managerPanel.setVisible(false);
		addStudentPanel.setVisible(true);
		addStudentPanel.setStudentInfo(userID);
	}

	// ------------------------ Private layer ------------------------

	private void windowListen() {
		WindowAdapter window = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Xác nhận thoát",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		}; 
		addWindowListener(window);;
	}


}
