import java.util.ArrayList;

public class Course {
	private String courseName;
	private ArrayList<String> students;
	
	public Course(String courseName) {
		this.courseName = courseName;
		students = new ArrayList<String>();
	}
	
	public void addStudent(String student) {
		students.add(student);
	}

	public String getCourseName() {
		return courseName;
	}

	public ArrayList<String> getStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return students.size();
	}
	
	public void dropStudent(String student) {
		students.remove(student);
	}
}