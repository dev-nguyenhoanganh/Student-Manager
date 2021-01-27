/**
 * @Project_Name 32_AnhNH_Ex1_Quan Ly
 */
package com.luvina.test.logic.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import com.luvina.test.logic.user.Student;

/**
 * @author Hoang Anh
 * @since 26 thg 1, 2021
 * @version 1.0
 */
public class Manager {
	public final String SORT_BY_NAME  = "name";
	public final String SORT_BY_SCORE  = "score";

	private ArrayList<Student> listStudent = new ArrayList<Student>();

	private static final String SRC_ACCOUNT  = ".\\data\\account.txt";
	

	/**
	 * 
	 */
	public Manager() {
		listStudent = convertFileToList();
	}

	public Comparator<Student> sortByName = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};
	
	public Comparator<Student> sortByScore = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			double result = Double.parseDouble(o1.getGPA()) 
						  - Double.parseDouble(o2.getGPA());
			if(result > 0) {
				return 1;
			} else if (result < 0) {
				return -1;
			}
			return 0;
		}
	};
	
	public Comparator<Student> sortByID = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			return Integer.parseInt(o1.getUserID()) 
				 - Integer.parseInt(o2.getUserID());
		}
	};
	
	// ----------------- Manager Method -----------------

	public void sortDefault() {
		listStudent.sort(sortByID);
		convertListToFile();
	}
	
	public void sortStudent(String sortBy) {
		if(SORT_BY_NAME.equals(sortBy)) {
			listStudent.sort(sortByName);
		} else if(SORT_BY_SCORE.equals(sortBy)) {
			listStudent.sort(sortByScore);
		} 
		convertListToFile();
	}
	
	/**
	 * 
	 */
	public boolean addStudent(Student newStudent) {
		if(listStudent.contains(newStudent)) {
			return false;
		}
		listStudent.add(newStudent);
		return convertListToFile();
	}

	public boolean removeStudent(String studentID) {
		int idx = listStudent.indexOf(new Student(studentID, "", "", "0", "0", "0", ""));
		
		if (idx == -1) {
			return false;
		}
		listStudent.remove(idx);
		return convertListToFile();
	}
	
	public boolean editStudent(Student newStudent) {
		int idx = listStudent.indexOf(newStudent);
		
		if(idx == -1) {
			return false;
		}
		listStudent.set(idx, newStudent);
		return convertListToFile();
	}
	
	/**
	 * 
	 */
	public ArrayList<Student> findStudent(String name) {
		ArrayList<Student> result = new ArrayList<Student>();
		for (Student user : listStudent) {
			if(user.getName().contains(name)) {
				result.add(user);
			}
		}
		return result;
	}

	public void refreshList() {
		listStudent = convertFileToList();
	}
	
	/**
	 * @return the listStudent
	 */
	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	/**
	 * @param listStudent the listStudent to set
	 */
	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}
	
	
	
	
	
	
	// ----------------- Read and Write File -----------------

	/**
	 * 
	 */
	private ArrayList<Student> convertFileToList() {
		try {
			String data = readFile(SRC_ACCOUNT);
			String[] dataLine = data.split("\n");
			ArrayList<Student> list = new ArrayList<Student>();
			for (int i = 0; i < dataLine.length; i++) {
				String[] studentInfor = dataLine[i].split("_");
				Student student = new Student(  studentInfor[0], 
												studentInfor[1], 
												studentInfor[2], 
												studentInfor[3],
												studentInfor[4], 
												studentInfor[5],
												studentInfor[6],
												studentInfor[7]  );
				
				list.add(student);
			}
			return list;
		} catch (Exception e) {
			return new ArrayList<Student>();
		}
	}

	public boolean convertListToFile() {
		String data = "";
		for (Student user : listStudent) {
			data += user.toString();
		}
		return writeToFile(data, SRC_ACCOUNT);
	}

	/**
	 * @param path
	 * @return
	 */
	private String readFile(String path) {
		String data = "";
		try {
			File file = new File(path);
			if (!file.exists()) {
				return null;
			}
			FileInputStream fI = new FileInputStream(file);
			byte[] arrByte = new byte[8192];
			int length = fI.read(arrByte);
			while (length != -1) {
				data += new String(arrByte, 0, length);
				length = fI.read(arrByte);
			}
			fI.close();
		} catch (IOException e) {
			System.out.println("Lỗi Hệ Thống");
		}
		return data;
	}

	private boolean writeToFile(String input, String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			FileOutputStream fO = new FileOutputStream(file);
			byte[] byteArr = input.getBytes();
			fO.write(byteArr);
			fO.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
//	private boolean deleteFile(String path) {
//		try {
//			File file = new File(path);
//			return file.delete();
//		}  
//		catch(Exception e)  
//		{  
//			return false;
//		}
//	}
}
