/**
 * @Project_Name 32_AnhNH_Ex1_Quan Ly
 */
package com.luvina.test.gui.panel;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.luvina.test.gui.frame.MainFrame;
import com.luvina.test.gui.icommon.IPanelAction;
import com.luvina.test.logic.manager.Manager;
import com.luvina.test.logic.user.Student;

/**
 * @author Hoang Anh
 * @since 26 thg 1, 2021
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ManagerPanel extends BasePanel {

	private static final int MARGIN_TOP  = 20;
	private static final int MARGIN_LEFT = 20;
	private static final int MARGIN_TEXT = 6;
	
	private static final int TEXT_FEILD_WIDTH = 580;
	private static final int BUTTON_WIDTH 	  = 130;
	private static final int TABLE_HEIGHT	  = 300;

	private static final String[] HEADER = new String[] { "ID", 
														  "Tên",
														  "Ngày sinh",
														  "Điểm Toán",
														  "Điểm Văn", 
														  "Điểm Anh",
														  "Lớp",
														  "GPA" };

	private JLabel lbTitle;
	
	private JTextField tfName;

	private JButton btSearch;
	private JButton btSortByName;
	private JButton btSortByScore;
	private JButton btAddStudent;
	private JButton btClearStudent;
	private JButton btEditStudent;
	
	private JTable tableStudent;
	
	private DefaultTableModel modelListStudent;
	
	private IPanelAction event;
	private Manager manager;

	public void addPanelAction(IPanelAction event) {
		this.event = event;
	}
	
	@Override
	public void init() {
		setSize(MainFrame.WIDTH, MainFrame.HEIGHT);
		setLocation(0, 0);
		setLayout(null);

		manager = new Manager();
	}

	@Override
	public void addComponent() {
		FontMetrics fm = getFontMetrics(MainFrame.fontNormal);
		FontMetrics fmTitle = getFontMetrics(MainFrame.fontHeader);
		int textHeight = fm.getHeight() + MARGIN_TEXT;
		
		// lbTitle
		lbTitle = new JLabel("QUẢN LÝ SINH VIÊN", JLabel.CENTER);
		lbTitle.setFont(MainFrame.fontHeader);
		int labelWidth = fmTitle.stringWidth(lbTitle.getText());
		lbTitle.setSize(labelWidth, fmTitle.getHeight() + 14);
		lbTitle.setLocation(MainFrame.WIDTH / 2 - labelWidth / 2, MARGIN_TOP);

		// tfSubject
		tfName = new JTextField("Nhập tên học sinh");
		tfName.setFont(MainFrame.fontNormal);
		tfName.setSize(TEXT_FEILD_WIDTH, textHeight);
		tfName.setLocation(MARGIN_LEFT, lbTitle.getY() + lbTitle.getHeight() + MARGIN_TOP);

		// btSearch
		btSearch = new JButton("Tìm kiếm");
		btSearch.setName("btSearch");
		btSearch.setFont(MainFrame.fontNormal);
		btSearch.setSize(BUTTON_WIDTH, textHeight);
		btSearch.setLocation(tfName.getX() + tfName.getWidth() + MARGIN_LEFT, tfName.getY());

		// allTimeTable
		tableStudent = new JTable();
		tableStudent.setShowGrid(true);
		tableStudent.setCellSelectionEnabled(false);
		tableStudent.setBackground(Color.yellow);
		tableStudent.setAutoCreateRowSorter(true);
		updateTable();
		
		
		JScrollPane scrTable = new JScrollPane(tableStudent);
		scrTable.setSize(btSearch.getX() - tfName.getX() + btSearch.getWidth(), TABLE_HEIGHT);
		scrTable.setLocation(tfName.getX(), tfName.getY() + tfName.getHeight() + MARGIN_TOP);

		// btSortByName
		btSortByName = new JButton();
		btSortByName.setName("btSortByName");
		btSortByName.setText("Xếp theo tên");
		btSortByName.setFont(MainFrame.fontNormal);
		btSortByName.setSize(BUTTON_WIDTH, textHeight);
		btSortByName.setLocation(tfName.getX(), scrTable.getY() + scrTable.getHeight() + MARGIN_TOP);
		
		// btSortByScore
		btSortByScore = new JButton("Xếp theo điểm");
		btSortByScore.setName("btSortByScore");
		btSortByScore.setFont(MainFrame.fontNormal);
		btSortByScore.setSize(BUTTON_WIDTH, textHeight);
		btSortByScore.setLocation(btSortByName.getX() + BUTTON_WIDTH + MARGIN_LEFT, btSortByName.getY());
		
		// btAddStudent
		btAddStudent = new JButton("Thêm");
		btAddStudent.setName("btAddStudent");
		btAddStudent.setFont(MainFrame.fontNormal);
		btAddStudent.setSize(BUTTON_WIDTH, textHeight);
		btAddStudent.setLocation(btSortByScore.getX() + BUTTON_WIDTH + MARGIN_LEFT, btSortByName.getY());
		
		// btClearStudent
		btClearStudent = new JButton("Xóa");
		btClearStudent.setName("btClearStudent");
		btClearStudent.setFont(MainFrame.fontNormal);
		btClearStudent.setSize(BUTTON_WIDTH, textHeight);
		btClearStudent.setLocation(btAddStudent.getX() + BUTTON_WIDTH + MARGIN_LEFT, btSortByName.getY());
		
		// btEditStudent
		btEditStudent = new JButton("Sửa");
		btEditStudent.setName("btEditStudent");
		btEditStudent.setFont(MainFrame.fontNormal);
		btEditStudent.setSize(BUTTON_WIDTH, textHeight);
		btEditStudent.setLocation(btClearStudent.getX() + BUTTON_WIDTH + MARGIN_LEFT, btSortByName.getY());
		
		
		add(lbTitle);
		add(tfName);
		
		add(btSearch);
		add(btSortByName);
		add(btSortByScore);
		add(btAddStudent);
		add(btClearStudent);
		add(btEditStudent);
		
		add(scrTable);
	}

	

	@Override
	public void addEvent() {
		focusTextfield();
		buttonAction();
	}

	// ------------------------ Private layer ------------------------

	private void focusTextfield() {
		FocusListener focus = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(tfName.getText().equals("")) {
					tfName.setForeground(Color.blue);
					tfName.setText("Nhập tên học sinh");
					updateTable();
			    }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				 if(tfName.getText().equals("Nhập tên học sinh")) {
					 tfName.setText("");
					 tfName.setForeground(Color.black);
			    }
			}
		};
		tfName.addFocusListener(focus);
	}
	
	/**
	 * 
	 */
	private void updateTable(ArrayList<Student> listUser) {
		modelListStudent = new DefaultTableModel(HEADER, 0);
		for (Student user : listUser) {
			String[] row = new String[] { user.getUserID(),
										  user.getName(),
										  user.getDate(),
										  user.getMathScore(),
										  user.getLiteratureScore(),
										  user.getEnglishScore(),
										  user.getGrade(),
										  user.getGPA() };
			modelListStudent.addRow(row);
		}
		tableStudent.setModel(modelListStudent);
		tableStudent.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableStudent.getColumnModel().getColumn(1).setPreferredWidth(150);
	}

	public void updateTable() {
		manager.refreshList();
		ArrayList<Student> list = manager.getListStudent();
		modelListStudent = new DefaultTableModel(HEADER, 0);
		for (Student user : list) {
			String[] row = new String[] { user.getUserID(),
										  user.getName(),
										  user.getDate(),
										  user.getMathScore(),
										  user.getLiteratureScore(),
										  user.getEnglishScore(),
										  user.getGrade(),
										  user.getGPA() };
			modelListStudent.addRow(row);
		}
		
		tableStudent.setModel(modelListStudent);
		tableStudent.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableStudent.getColumnModel().getColumn(1).setPreferredWidth(150);
	}
	
	/**
	 * 
	 */
	private void buttonAction() {
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton) e.getSource();
				switch(temp.getName()) {
					case "btSearch":
						findStudent();
						break;
					case "btSortByName":
						sortStudent(manager.SORT_BY_NAME);
						break;
					case "btSortByScore":
						sortStudent(manager.SORT_BY_SCORE);
						break;
					case "btAddStudent":
						addStudent();
						break;
					case "btEditStudent":
						editStudent();
						break;
					case "btClearStudent":
						removeStudent();
						break;
				}
			}
		};
		
		btSearch.addActionListener(action);
		btSortByName.addActionListener(action);
		btSortByScore.addActionListener(action);
		btAddStudent.addActionListener(action);
		btEditStudent.addActionListener(action);
		btClearStudent.addActionListener(action);
	}

	private void findStudent() {
		manager.sortDefault();
		String name = tfName.getText().trim();

		if(name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên", "Thông báp", JOptionPane.ERROR_MESSAGE);
			return;
		} else if("Nhập tên học sinh".equals(name)) {
			JOptionPane.showMessageDialog(null, "Chưa nhập tên", "Thông báp", JOptionPane.ERROR_MESSAGE);
			return;
		}
		updateTable(manager.findStudent(name));
	}
	
	private void sortStudent(String sortType) {
		manager.sortStudent(sortType);
		updateTable();
	}
	
	private void removeStudent() {
		manager.sortDefault();
		int idx = tableStudent.getSelectedRow();
		String userID = (String) modelListStudent.getValueAt(idx, 0);
		System.out.println(userID);
		if(manager.removeStudent(userID)) {
			updateTable();
			JOptionPane.showMessageDialog(null, "Xóa thành công", 
			        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} else { 
			JOptionPane.showMessageDialog(null, "Xóa không thành công", 
					"Thông báo", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void addStudent() {
		event.changePanel("Thêm học sinh");
	}
	
	private void editStudent() {
		manager.sortDefault();
		int idx = tableStudent.getSelectedRow();
		if(idx == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng trong bảng", 
					"Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String userID = (String) modelListStudent.getValueAt(idx, 0);
		System.out.println(userID);
		event.changePanel("Thêm học sinh", userID);
	}
}
