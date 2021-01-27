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
import javax.swing.JTextField;

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
public class AddStudentPanel extends BasePanel {
	private static final int MARGIN_TOP  = 20;
	private static final int MARGIN_LEFT = 35;
	private static final int MARGIN_TEXT = 10;
	
	private static final int TEXT_FEILD_WIDTH = 580;
	private static final int BUTTON_WIDTH 	  = 130;
	
	private static final String REGEX_ALL_CHAR = "";
	private static final String REGEX_NAME = "[\\D|\\W]+";
//	private static final String REGEX_ID = "[\\S]{5,}";
	private static final String REGEX_SCORE = "(\\d+(\\.\\d+)?)|(\s)";
	private static final String REGEX_DATE = "\\d{1,2}\\/\\d{1,2}\\/\\d{4}";

	private JLabel lbTitle;
	private JLabel lbID;
	private JLabel lbName;
	private JLabel lbDateOfBirth;
	private JLabel lbMathScore;
	private JLabel lbLiteratureScore;
	private JLabel lbEnglishScore;
	private JLabel lbGrade;
	
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfDateOfBirth;
	private JTextField tfMathScore;
	private JTextField tfLiteratureScore;
	private JTextField tfEnglishScore;
	private JTextField tfGrade;

	private JButton btSave;
	private JButton btBack;
	
	private boolean editStudent = false;
	
	private Manager manager;
	
	private IPanelAction event;
	
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
		lbTitle = new JLabel("THÔNG TIN HỌC SINH", JLabel.CENTER);
		lbTitle.setFont(MainFrame.fontHeader);
		int labelWidth = fmTitle.stringWidth(lbTitle.getText());
		lbTitle.setSize(labelWidth, fmTitle.getHeight() + 14);
		lbTitle.setLocation(MainFrame.WIDTH / 2 - labelWidth / 2, MARGIN_TOP);
		
		// lbID
		lbID = new JLabel("ID");
		lbID.setFont(MainFrame.fontNormal);
		lbID.setSize(lbID.getPreferredSize());
		lbID.setLocation(MARGIN_LEFT, lbTitle.getY() + lbTitle.getHeight() + MARGIN_TOP);
		
		// lbName
		lbName = new JLabel("Nhập tên");
		lbName.setFont(MainFrame.fontNormal);
		lbName.setSize(lbName.getPreferredSize());
		lbName.setLocation(MARGIN_LEFT, lbID.getY() + lbID.getHeight() + MARGIN_TOP);
		
		// lbDateOfBirth
		lbDateOfBirth = new JLabel("Ngày sinh");
		lbDateOfBirth.setFont(MainFrame.fontNormal);
		lbDateOfBirth.setSize(lbDateOfBirth.getPreferredSize());
		lbDateOfBirth.setLocation(MARGIN_LEFT, lbName.getY() + lbName.getHeight() + MARGIN_TOP);
		
		// lbMathScore
		lbMathScore = new JLabel("Điểm Toán");
		lbMathScore.setFont(MainFrame.fontNormal);
		lbMathScore.setSize(lbMathScore.getPreferredSize());
		lbMathScore.setLocation(MARGIN_LEFT, lbDateOfBirth.getY() + lbDateOfBirth.getHeight() + MARGIN_TOP);
		
		// lbLiteratureScore
		lbLiteratureScore = new JLabel("Điểm Văn");
		lbLiteratureScore.setFont(MainFrame.fontNormal);
		lbLiteratureScore.setSize(lbLiteratureScore.getPreferredSize());
		lbLiteratureScore.setLocation(MARGIN_LEFT, lbMathScore.getY() + lbMathScore.getHeight() + MARGIN_TOP);
		
		// lbEnglishScore
		lbEnglishScore = new JLabel("Điểm Anh");
		lbEnglishScore.setFont(MainFrame.fontNormal);
		lbEnglishScore.setSize(lbEnglishScore.getPreferredSize());
		lbEnglishScore.setLocation(MARGIN_LEFT, lbLiteratureScore.getY() + lbLiteratureScore.getHeight() + MARGIN_TOP);
		
		// lbGrade
		lbGrade = new JLabel("Lớp");
		lbGrade.setFont(MainFrame.fontNormal);
		lbGrade.setSize(lbGrade.getPreferredSize());
		lbGrade.setLocation(MARGIN_LEFT, lbEnglishScore.getY() + lbEnglishScore.getHeight() + MARGIN_TOP);
		
		// tfID
		tfID = new JTextField("Nhập ID");
		tfID.setFont(MainFrame.fontNormal);
		tfID.setForeground(Color.green);
		tfID.setName("id");
		tfID.setSize(TEXT_FEILD_WIDTH, textHeight);
		tfID.setLocation(lbMathScore.getX() + lbMathScore.getWidth() + MARGIN_LEFT, lbID.getY());
		
		// tfName
		tfName = new JTextField("Nhập tên học sinh");
		tfName.setFont(MainFrame.fontNormal);
		tfName.setForeground(Color.green);
		tfName.setName("name");
		tfName.setSize(TEXT_FEILD_WIDTH, textHeight);
		tfName.setLocation(tfID.getX(), lbName.getY());
		
		// tfDateOfBirth
		tfDateOfBirth = new JTextField("Ví dụ - 31/07/1998");
		tfDateOfBirth.setFont(MainFrame.fontNormal);
		tfDateOfBirth.setForeground(Color.green);
		tfDateOfBirth.setName("date");
		tfDateOfBirth.setSize(TEXT_FEILD_WIDTH, textHeight);
		tfDateOfBirth.setLocation(tfID.getX(), lbDateOfBirth.getY());
		
		// tfMathScore
		tfMathScore = new JTextField("Ví dụ - 8.0");
		tfMathScore.setFont(MainFrame.fontNormal);
		tfMathScore.setForeground(Color.green);
		tfMathScore.setName("math");
		tfMathScore.setSize(TEXT_FEILD_WIDTH, textHeight);
		tfMathScore.setLocation(tfID.getX(), lbMathScore.getY());
		
		// tfLiteratureScore
		tfLiteratureScore = new JTextField("Ví dụ - 8.0");
		tfLiteratureScore.setFont(MainFrame.fontNormal);
		tfLiteratureScore.setForeground(Color.green);
		tfLiteratureScore.setName("literature");
		tfLiteratureScore.setSize(TEXT_FEILD_WIDTH, textHeight);
		tfLiteratureScore.setLocation(tfID.getX(), lbLiteratureScore.getY());
		
		// tfEnglishScore
		tfEnglishScore = new JTextField("Ví dụ - 8.0");
		tfEnglishScore.setFont(MainFrame.fontNormal);
		tfEnglishScore.setForeground(Color.green);
		tfEnglishScore.setName("english");
		tfEnglishScore.setSize(TEXT_FEILD_WIDTH, textHeight);
		tfEnglishScore.setLocation(tfID.getX(), lbEnglishScore.getY());
		
		// tfGrade
		tfGrade = new JTextField("Nhập lớp - 10A");
		tfGrade.setFont(MainFrame.fontNormal);
		tfGrade.setForeground(Color.green);
		tfGrade.setName("tfGrade");
		tfGrade.setSize(TEXT_FEILD_WIDTH, textHeight);
		tfGrade.setLocation(tfID.getX(), lbGrade.getY());
		
		
		// btSave
		btSave = new JButton("Lưu");
		btSave.setName("btSave");
		btSave.setFont(MainFrame.fontNormal);
		btSave.setSize(BUTTON_WIDTH, textHeight);
		btSave.setLocation(MARGIN_LEFT, tfGrade.getY() + tfGrade.getHeight() + MARGIN_TOP);
		
		// btBack
		btBack = new JButton("Trở lại");
		btBack.setName("btBack");
		btBack.setFont(MainFrame.fontNormal);
		btBack.setSize(BUTTON_WIDTH, textHeight);
		btBack.setLocation(tfGrade.getX() + tfGrade.getWidth() - btBack.getWidth(), btSave.getY());
		
		add(lbTitle);
		add(lbID);
		add(lbName);
		add(lbDateOfBirth);
		add(lbMathScore);
		add(lbLiteratureScore);
		add(lbEnglishScore);
		add(lbGrade);
		
		add(tfID);
		add(tfName);
		add(tfDateOfBirth);
		add(tfMathScore);
		add(tfLiteratureScore);
		add(tfEnglishScore);
		add(tfGrade);
		
		add(btSave);
		add(btBack);
	}

	@Override
	public void addEvent() {
		focusTextfield();
		buttonAction();
	}

	public void setStudentInfo(String userID) {
		ArrayList<Student> list = manager.getListStudent(); 
		for (Student student : list) {
			if(userID.equals(student.getUserID())) {
				tfID.setText(student.getUserID());
				tfName.setText(student.getName());
				tfDateOfBirth.setText(student.getDate());
				tfMathScore.setText(student.getMathScore());
				tfLiteratureScore.setText(student.getLiteratureScore());
				tfEnglishScore.setText(student.getEnglishScore());
				tfGrade.setText(student.getGrade());
			}
		}
		changeTextFieldColor(Color.black);
		tfID.setEditable(false);
		editStudent = true;
	}
	
	// ------------------------ Private layer ------------------------
	
	private void focusTextfield() {
		FocusListener focus = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				JTextField temp = (JTextField) e.getSource();
				if(temp.getText().equals("")) {
					switch(temp.getName()) {
					case "name":
						tfName.setText("Nhập tên học sinh");
						tfName.setForeground(Color.green);
						break;
					case "date":
						tfDateOfBirth.setText("Ví dụ - 31/07/1998");
						tfDateOfBirth.setForeground(Color.green);
						break;
					case "math":
						tfMathScore.setText("Ví dụ - 8.0");
						tfMathScore.setForeground(Color.green);
						break;
					case "literature":
						tfLiteratureScore.setText("Ví dụ - 8.0");
						tfLiteratureScore.setForeground(Color.green);
						break;
					case "english":
						tfEnglishScore.setText("Ví dụ - 8.0");
						tfEnglishScore.setForeground(Color.green);
						break;
					case "id":
						tfID.setText("Nhập ID");
						tfID.setForeground(Color.green);
						break;
					case "tfGrade":
						tfGrade.setText("Nhập lớp - 10A");
						tfGrade.setForeground(Color.green);
						break;
						
					}
					
			    }
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				JTextField temp = (JTextField) e.getSource();
				String message = temp.getText();
				switch(temp.getName()) {
				case "name":
					if(message.equals("Nhập tên học sinh")) {
						tfName.setText("");
						tfName.setForeground(Color.black);
					} break;
				case "date":
					if(message.equals("Ví dụ - 31/07/1998")) {
						tfDateOfBirth.setText("");
						tfDateOfBirth.setForeground(Color.black);
					} break;
				case "math":
					if(message.equals("Ví dụ - 8.0")) {
						tfMathScore.setText("");
						tfMathScore.setForeground(Color.black);
					} break;
				case "literature":
					if(message.equals("Ví dụ - 8.0")) {
						tfLiteratureScore.setText("");
						tfLiteratureScore.setForeground(Color.black);
					} break;
				case "english":
					if(message.equals("Ví dụ - 8.0")) {
						tfEnglishScore.setText("");
						tfEnglishScore.setForeground(Color.black);
					} break;
				case "id":
					if(message.equals("Nhập ID")) {
						tfID.setText("");
						tfID.setForeground(Color.black);
					} break;
				case "tfGrade":
					if(message.equals("Nhập lớp - 10A")) { 
						tfGrade.setText("");
						tfGrade.setForeground(Color.black);
					} break;
				}
			}
		};
		
		tfName.addFocusListener(focus);
		tfDateOfBirth.addFocusListener(focus);
		tfMathScore.addFocusListener(focus);
		tfLiteratureScore.addFocusListener(focus);
		tfEnglishScore.addFocusListener(focus);
		tfID.addFocusListener(focus);
		tfGrade.addFocusListener(focus);
	}
	
	private void buttonAction() {
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = ((JButton) e.getSource()).getName();
				switch (name) {
					case "btBack":
						changePanel();
						break;
					case "btSave":
						saveData();
						
						break;
				}
			}
			
		};
		
		btBack.addActionListener(action);
		btSave.addActionListener(action);
	}

	private void changePanel() {
		setDefaultTextfield();
		editStudent = false;
		changeTextFieldColor(Color.green);
		tfID.setEditable(true);
		event.changePanel("manager");
	}
	
	private void saveData() {
	    String 	userID; 
	    String 	name; 
	    String 	date; 
	    String 	mathScore; 
	    String 	literatureScore;
	    String 	englishScore;
	    String 	grade;
		
		userID = tfID.getText();
		if(!validate(REGEX_ALL_CHAR, userID, "Mã học sinh")) {
			tfID.setText("Nhập ID");
			return;
		}
		
		name = tfName.getText();
		if(!validate(REGEX_NAME, name, "Tên học sinh")) {
			tfName.setText("Nhập tên học sinh");
			return;
		}
		
		date = tfDateOfBirth.getText();
		if(!validate(REGEX_DATE, date, "Ngày sinh")) {
			tfDateOfBirth.setText("Ví dụ - 31/07/1998");
			return;
		}
		
		mathScore = tfMathScore.getText();
		if(!validate(REGEX_SCORE, mathScore, "Điểm Toán")) {
			tfMathScore.setText("Ví dụ - 8.0");
			return;
		}
		
		literatureScore = tfLiteratureScore.getText();
		if(!validate(REGEX_SCORE, literatureScore, "Điểm Văn")) {
			tfLiteratureScore.setText("Ví dụ - 8.0");
			return;
		}
		
		englishScore = tfEnglishScore.getText();
		if(!validate(REGEX_SCORE, englishScore, "Điểm Anh")) {
			tfEnglishScore.setText("Ví dụ - 8.0");
			return;
		}
		
		grade = tfGrade.getText();
		if(!validate(REGEX_ALL_CHAR, literatureScore, "Tên lớp")) {
			tfGrade.setText("Nhập lớp - 10A");
			return;
		}
		
		Student temp = new Student( userID, 
								  	name, 
								  	date, 
								  	mathScore, 
								  	literatureScore, 
								  	englishScore, 
								  	grade);
		
		if(editStudent) {
			editStudent = false;
			if(manager.editStudent(temp)) {
				JOptionPane.showMessageDialog(null, 
						  "Sửa thành công", 
						  "Thông báo", 
						  JOptionPane.INFORMATION_MESSAGE);
				setDefaultTextfield();
				event.changePanel("manager");
				
				
			} else { 
			JOptionPane.showMessageDialog(null, "Sửa không thành công", 
						        "Thông báo", JOptionPane.ERROR_MESSAGE);
			}
			tfID.setEditable(true);
			return;
		}
		
		if(manager.addStudent(temp)) {
			
			JOptionPane.showMessageDialog(null, "Thêm thành công", 
						        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			setDefaultTextfield();
			event.changePanel("manager");
			return;
		} 
		JOptionPane.showMessageDialog(null, "Học sinh đã tồn tại", 
				  			    "Thông báo", JOptionPane.ERROR_MESSAGE);
	}
	
	private boolean validate(String regex, String value, String textFieldName) {
		
		
		if (regex.isEmpty()) {
			return true;
		} else if (!value.matches(regex)) {
			JOptionPane.showMessageDialog(null, textFieldName + " chưa nhập đúng", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void setDefaultTextfield() {
		tfID.setText("Nhập ID");
		tfName.setText("Nhập tên học sinh");
		tfDateOfBirth.setText("Ví dụ - 31/07/1998");
		tfMathScore.setText("Ví dụ - 8.0");
		tfLiteratureScore.setText("Ví dụ - 8.0");
		tfEnglishScore.setText("Ví dụ - 8.0");
		tfGrade.setText("Nhập lớp - 10A");
	}
	
	private void changeTextFieldColor(Color color) {
		tfID.setForeground(color);
		tfName.setForeground(color);
		tfDateOfBirth.setForeground(color);
		tfMathScore.setForeground(color);
		tfLiteratureScore.setForeground(color);
		tfEnglishScore.setForeground(color);
		tfGrade.setForeground(color);
	}
}
