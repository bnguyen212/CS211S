package unittesting;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

public class CourseTest {
	
	private Student s1, s2, s3;
	private Course course;
	
	// behind the scenes, Java will add a default constructor: public CourseTest() {}

	@Before
	public void setUp() {
		course = new Course("Java");
		s1 = new Student("Sally Studier");
		s2 = new Student("Pat Procrastinator");
		s3 = new Student("Alan AsksALot");
	}

	
	@Test
	public void testAddStudentToEmpty() {
		course.addStudent(s1);
		List<Student> studentList = new ArrayList<>(course.getStudents());
		
		assertTrue(studentList.contains(s1));
		assertTrue(studentList.size()==1);
	}
	

	@Test 
	public void testAddStudentToNonEmpty() {
	    course.addStudent(s1);
	    course.addStudent(s2);
        List<Student> originalStudentList = new ArrayList<>(course.getStudents());
        course.addStudent(s3);
        List<Student> modifiedStudentList =  new ArrayList<>(course.getStudents());
        assertTrue(modifiedStudentList.contains(s3));
        assertTrue(modifiedStudentList.size()==(originalStudentList.size()+1));
	}
	

    @Test
    public void testAddDuplicateStudent() {
        course.addStudent(s1);
        List<Student> originalStudentList = new ArrayList<>(course.getStudents());
        boolean result = course.addStudent(s1);
        List<Student> modifiedStudentList = new ArrayList<>(course.getStudents());
        assertTrue(modifiedStudentList.contains(s1));
        assertTrue(originalStudentList.size() == modifiedStudentList.size());
        assertFalse(result);
    }

	@Test
	public void testRemoveStudentFromEmpty() {
		boolean result = course.removeStudent(s1);
		List<Student> studentList = new ArrayList<>(course.getStudents());
		
		assertNotNull(studentList);
		assertTrue(studentList.isEmpty());
		assertFalse(result);
	}
	    

	@Test
    public void testRemoveExistingStudentFromNonEmpty() {
        course.addStudent(s1);
        course.addStudent(s2);
        List<Student> originalStudentList = new ArrayList<>(course.getStudents());     
	    boolean result = course.removeStudent(s1);
        List<Student> modifiedStudentList = new ArrayList<>(course.getStudents());	    
        
        assertNotNull(modifiedStudentList);
        assertFalse(modifiedStudentList.isEmpty());
        assertFalse(modifiedStudentList.contains(s1));
        assertTrue(modifiedStudentList.size() == (originalStudentList.size()-1));
        assertTrue(result);
    }	
	

    @Test
    public void testRemoveNonExistingStudentFromNonEmpty() {
        course.addStudent(s1);
        course.addStudent(s2);
        List<Student> originalStudentList = new ArrayList<>(course.getStudents());
        boolean result = course.removeStudent(s3);
        List<Student> modifiedStudentList = new ArrayList<>(course.getStudents());

        assertNotNull(modifiedStudentList);
        assertFalse(modifiedStudentList.isEmpty());
        assertFalse(modifiedStudentList.contains(s3));
        assertTrue(modifiedStudentList.size() == originalStudentList.size());
        assertFalse(result);
    }

}
