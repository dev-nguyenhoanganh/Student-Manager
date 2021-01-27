/**
 * @Project_Name 32_AnhNH_Ex1_Quan Ly
 */
package com.luvina.test.logic.user;

/**
 * @author Hoang Anh
 * @since 26 thg 1, 2021
 * @version 1.0
 */
public class Student {
	private String userID;
	private String name;
	private String date;
	private String mathScore;
	private String literatureScore;
	private String englishScore;
	private String grade;
	private String GPA;


	/**
	 * 
	 */
	public Student(String 	   userID, 
				   String 	   name, 
				   String 	   date, 
				   String 	   mathScore, 
				   String 	   literatureScore,
				   String 	   englishScore,
				   String 	   grade) {

		this.userID	 		 = userID;
		this.name			 = name;
		this.date			 = date;
		this.mathScore 		 = mathScore;
		this.literatureScore = literatureScore;
		this.englishScore 	 = englishScore;
		this.grade 			 = grade;

		setDiemTB();
	}

	/**
	 * 
	 */
	public Student(String 	   userID, 
				   String 	   name, 
				   String 	   date, 
				   String 	   mathScore, 
				   String 	   literatureScore,
				   String 	   englishScore,
				   String 	   grade,
				   String 	   GPA) {

		this.userID	 		 = userID;
		this.name			 = name;
		this.date			 = date;
		this.mathScore 		 = mathScore;
		this.literatureScore = literatureScore;
		this.englishScore 	 = englishScore;
		this.grade 			 = grade;
		this.GPA 			 = GPA;
	}
	
	// ------------------ Student Method -----------------	
	@Override
	public String toString() {
		return     userID 		   + "_" 
				+  name   		   + "_" 
				+  date   		   + "_" 
				+  mathScore       + "_" 
				+  literatureScore + "_" 
				+  englishScore    + "_"
				+  grade     	   + "_"
				+  GPA + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		Student object = (Student) obj;
		return userID.equals(object.getUserID());
	}


	/**
	 * 
	 */
	public void setDiemTB() {
		double sum = Double.parseDouble(mathScore) + 
			  Double.parseDouble(literatureScore)  +  
			  Double.parseDouble(englishScore);
		int roundNumber = (int) (sum * 100 / 3);
		sum = (double) roundNumber / 100;
		this.GPA = "" + sum;
		
	}

	// ----------------- Getter & Setter -----------------

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the mathScore
	 */
	public String getMathScore() {
		return mathScore;
	}

	/**
	 * @param mathScore the mathScore to set
	 */
	public void setMathScore(String mathScore) {
		this.mathScore = mathScore;
	}

	/**
	 * @return the literatureScore
	 */
	public String getLiteratureScore() {
		return literatureScore;
	}

	/**
	 * @param literatureScore the literatureScore to set
	 */
	public void setLiteratureScore(String literatureScore) {
		this.literatureScore = literatureScore;
	}

	/**
	 * @return the englishScore
	 */
	public String getEnglishScore() {
		return englishScore;
	}

	/**
	 * @param englishScore the englishScore to set
	 */
	public void setEnglishScore(String englishScore) {
		this.englishScore = englishScore;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the gPA
	 */
	public String getGPA() {
		return GPA;
	}

	/**
	 * @param gPA the gPA to set
	 */
	public void setGPA(String gPA) {
		GPA = gPA;
	}
}
