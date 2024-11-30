package edu.uoc.pac4.user;

import edu.uoc.pac4.activity.ActivityException;
import edu.uoc.pac4.activity.ActivityQuiz;
import edu.uoc.pac4.activity.ActivityQuizType;
import edu.uoc.pac4.execution.Execution;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(1, Student.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Student.class.getDeclaredField("executions").getModifiers()));
            assertFalse(Modifier.isStatic(Student.class.getDeclaredField("executions").getModifiers()));
            assertFalse(Modifier.isFinal(Student.class.getDeclaredField("executions").getModifiers()));
            assertEquals(LinkedList.class, Student.class.getDeclaredField("executions").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, Student.class.getDeclaredConstructors().length);
        assertEquals(4, Student.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Student.class.getDeclaredMethod("addExecution", Execution.class).getModifiers()));
            assertFalse(Modifier.isStatic(Student.class.getDeclaredMethod("addExecution", Execution.class).getModifiers()));
            assertFalse(Modifier.isFinal(Student.class.getDeclaredMethod("addExecution", Execution.class).getModifiers()));
            assertEquals(void.class, Student.class.getDeclaredMethod("addExecution", Execution.class).getReturnType());

            assertTrue(Modifier.isPublic(Student.class.getDeclaredMethod("getExecutions").getModifiers()));
            assertFalse(Modifier.isStatic(Student.class.getDeclaredMethod("getExecutions").getModifiers()));
            assertFalse(Modifier.isFinal(Student.class.getDeclaredMethod("getExecutions").getModifiers()));
            assertEquals(LinkedList.class, Student.class.getDeclaredMethod("getExecutions").getReturnType());

            assertTrue(Modifier.isPublic(Student.class.getDeclaredMethod("getLastExecutionSubmitted").getModifiers()));
            assertFalse(Modifier.isStatic(Student.class.getDeclaredMethod("getLastExecutionSubmitted").getModifiers()));
            assertFalse(Modifier.isFinal(Student.class.getDeclaredMethod("getLastExecutionSubmitted").getModifiers()));
            assertEquals(Execution.class, Student.class.getDeclaredMethod("getLastExecutionSubmitted").getReturnType());

            assertTrue(Modifier.isPublic(Student.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Student.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Student.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Student.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(User.class.isAssignableFrom(Student.class));
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(Student.class.getModifiers()));
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Minimum - Valid parameters")
    void checkValidParameters() throws UserException {
        Student student = new Student("student@uoc.edu", "Name", "Surname");

        assertEquals("student@uoc.edu", student.getEmail());
        assertEquals("Name", student.getName());
        assertEquals("Surname", student.getSurname());
    }

    @Test
    @Tag("advanced")
    @Order(6)
    @DisplayName("Advanced - Email")
    void testStudentCreationEmail() throws UserException {
        Exception exception = assertThrows(UserException.class, () -> new Student(null, "Name", "Surname"));

        assertEquals("[ERROR] The email must start with any character end with @uoc.edu", exception.getMessage());

        assertThrows(UserException.class, () -> new Student("", "Name", "Surname"));
        assertThrows(UserException.class, () -> new Student("   ", "Name", "Surname"));
        assertThrows(UserException.class, () -> new Student("@uoc.edu", "Name", "Surname"));

        Student student = new Student("a@uoc.edu", "Name", "Surname");
        assertEquals("a@uoc.edu", student.getEmail());

        Student student2 = new Student("student@uoc.edu", "Name", "Surname");
        assertEquals("student@uoc.edu", student2.getEmail());

        assertThrows(UserException.class, () -> student.setEmail(null));
        assertThrows(UserException.class, () -> student.setEmail(""));
        assertThrows(UserException.class, () -> student.setEmail("   "));
        assertThrows(UserException.class, () -> student.setEmail("@uoc.edu"));

        assertEquals("a@uoc.edu", student.getEmail());
    }

    @Test
    @Tag("minimum")
    @Order(7)
    @DisplayName("Minimum - Name")
    void testStudentCreationName() throws UserException {
        Exception exception = assertThrows(UserException.class, () -> new Student("a@uoc.edu", null, "Surname"));

        assertEquals("[ERROR] Name cannot be null, empty or blank", exception.getMessage());

        assertThrows(UserException.class, () -> new Student("a@uoc.edu", "", "Surname"));
        assertThrows(UserException.class, () -> new Student("a@uoc.edu", "   ", "Surname"));

        Student student = new Student("a@uoc.edu", "Name", "Surname");
        assertEquals("Name", student.getName());

        student.setName("Name 2");
        assertEquals("Name 2", student.getName());

        assertThrows(UserException.class, () -> student.setName(null));
        assertThrows(UserException.class, () -> student.setName(""));
        assertThrows(UserException.class, () -> student.setName("   "));

        assertEquals("Name 2", student.getName());
    }

    @Test
    @Tag("minimum")
    @Order(8)
    @DisplayName("Minimum - Surname")
    void testStudentCreationSurname() throws UserException {
        Student student = new Student("a@uoc.edu", "Name", null);

        assertEquals("", student.getSurname());

        student.setSurname("Surname");
        assertEquals("Surname", student.getSurname());

        Student student2 = new Student("a@uoc.edu", "Name", "Surname");
        assertEquals("Surname", student2.getSurname());
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - Executions")
    void testStudentCreationExecutions() throws UserException, ActivityException {
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);

        assertEquals(0, student.getExecutions().size());

        new Execution(3.0, student, activityQuiz);
        assertEquals(3.0, student.getExecutions().getLast().getScore());
        assertEquals(1, student.getExecutions().size());

        new Execution(5.0, student, activityQuiz);
        assertEquals(5.0, student.getExecutions().getLast().getScore());
        assertEquals(2, student.getExecutions().size());
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - Last Execution Submitted")
    void testStudentCreationLastExecutionSubmitted() throws UserException, ActivityException {
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);

        assertThrows(NoSuchElementException.class, student::getLastExecutionSubmitted);

        new Execution(3.0, student, activityQuiz);
        assertEquals(3.0, student.getLastExecutionSubmitted().getScore());

        new Execution(5.0, student, activityQuiz);
        assertEquals(5.0, student.getLastExecutionSubmitted().getScore());
    }

    @Test
    @Tag("advanced")
    @Order(11)
    @DisplayName("Advanced - toString")
    void testStudentCreationToString() throws UserException, ActivityException {
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);

        new Execution(3.0, student, activityQuiz);
        assertEquals("[STUDENT] Name Surname (student@uoc.edu) Total executions: 1", student.toString());

        new Execution(5.0, student, activityQuiz);
        assertEquals("[STUDENT] Name Surname (student@uoc.edu) Total executions: 2", student.toString());
    }

}
