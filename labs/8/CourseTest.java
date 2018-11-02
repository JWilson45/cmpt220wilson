public class CourseTest {
	public static void main(String[] args) {
		Course course = new Course("Intro");

		course.addStudent("Billy");
		course.addStudent("Ray");
		course.addStudent("Cirus");

		course.dropStudent("Ray");
		
		
		System.out.println("Students in this course:");
		System.out.println(course.getStudents().toString() + " (" + course.getNumberOfStudents() + " Students)");
	}

}
