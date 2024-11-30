package edu.uoc.pac4.execution;

import edu.uoc.pac4.activity.Activity;
import edu.uoc.pac4.activity.ActivityException;
import edu.uoc.pac4.activity.ActivityQuiz;
import edu.uoc.pac4.activity.ActivityQuizType;
import edu.uoc.pac4.user.Student;
import edu.uoc.pac4.user.UserException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExecutionTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(3, Execution.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Execution.class.getDeclaredField("score").getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredField("score").getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredField("score").getModifiers()));
            assertEquals(double.class, Execution.class.getDeclaredField("score").getType());

            assertTrue(Modifier.isPrivate(Execution.class.getDeclaredField("student").getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredField("student").getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredField("student").getModifiers()));
            assertEquals(Student.class, Execution.class.getDeclaredField("student").getType());

            assertTrue(Modifier.isPrivate(Execution.class.getDeclaredField("activity").getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredField("activity").getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredField("activity").getModifiers()));
            assertEquals(Activity.class, Execution.class.getDeclaredField("activity").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, Execution.class.getDeclaredConstructors().length);
        assertEquals(7, Arrays.stream(Execution.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Execution.class.getDeclaredMethod("getScore").getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredMethod("getScore").getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredMethod("getScore").getModifiers()));
            assertEquals(double.class, Execution.class.getDeclaredMethod("getScore").getReturnType());

            assertTrue(Modifier.isPublic(Execution.class.getDeclaredMethod("setScore", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredMethod("setScore", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredMethod("setScore", double.class).getModifiers()));
            assertEquals(void.class, Execution.class.getDeclaredMethod("setScore", double.class).getReturnType());

            assertTrue(Modifier.isPublic(Execution.class.getDeclaredMethod("getStudent").getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredMethod("getStudent").getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredMethod("getStudent").getModifiers()));
            assertEquals(Student.class, Execution.class.getDeclaredMethod("getStudent").getReturnType());

            assertTrue(Modifier.isPublic(Execution.class.getDeclaredMethod("setStudent", Student.class).getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredMethod("setStudent", Student.class).getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredMethod("setStudent", Student.class).getModifiers()));
            assertEquals(void.class, Execution.class.getDeclaredMethod("setStudent", Student.class).getReturnType());

            assertTrue(Modifier.isPublic(Execution.class.getDeclaredMethod("getActivity").getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredMethod("getActivity").getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredMethod("getActivity").getModifiers()));
            assertEquals(Activity.class, Execution.class.getDeclaredMethod("getActivity").getReturnType());

            assertTrue(Modifier.isPublic(Execution.class.getDeclaredMethod("setActivity", Activity.class).getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredMethod("setActivity", Activity.class).getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredMethod("setActivity", Activity.class).getModifiers()));
            assertEquals(void.class, Execution.class.getDeclaredMethod("setActivity", Activity.class).getReturnType());

            assertTrue(Modifier.isPublic(Execution.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Execution.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Execution.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Execution.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("advanced")
    @Order(3)
    @DisplayName("Advanced - Valid parameters")
    void testUniversityCreationValidParameters() throws UserException, ActivityException {
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);

        Execution execution = new Execution(5.0, student, activityQuiz);

        assertEquals(5.0, execution.getScore());
        assertEquals(student, execution.getStudent());
        assertEquals(activityQuiz, execution.getActivity());
    }

    @Test
    @Tag("advanced")
    @Order(4)
    @DisplayName("Advanced - Score")
    void testUniversityCreationInvalidScore() throws UserException, ActivityException {
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);

        Execution execution = new Execution(5.0, student, activityQuiz);
        assertEquals(5.0, execution.getScore());

        execution = new Execution(-1.0, student, activityQuiz);
        assertEquals(0.0, execution.getScore());

        execution = new Execution(11.0, student, activityQuiz);
        assertEquals(10.0, execution.getScore());

        execution.setScore(-1.0);
        assertEquals(0.0, execution.getScore());

        execution.setScore(11.0);
        assertEquals(10.0, execution.getScore());

        execution.setScore(5.0);
        assertEquals(5.0, execution.getScore());
    }

    @Test
    @Tag("advanced")
    @Order(5)
    @DisplayName("Advanced - Student")
    void testUniversityCreationInvalidStudent() throws ActivityException, UserException {
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);

        Execution execution = new Execution(5.0, student, activityQuiz);
        assertEquals(student, execution.getStudent());
    }

    @Test
    @Tag("advanced")
    @Order(6)
    @DisplayName("Advanced - Activity")
    void testUniversityCreationInvalidActivity() throws UserException, ActivityException {
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);

        Execution execution = new Execution(5.0, student, activityQuiz);
        assertEquals(activityQuiz, execution.getActivity());
    }

    @Test
    @Tag("advanced")
    @Order(7)
    @DisplayName("Advanced - toString")
    void testUniversityCreationToString() throws UserException, ActivityException {
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);
        Execution execution = new Execution(5.0, student, activityQuiz);

        assertEquals("[STUDENT] Name Surname (student@uoc.edu) Total executions: 1" + System.lineSeparator() +
                "Activity 1: Description of Activity 1" + System.lineSeparator() +
                "Total executions: 1" + System.lineSeparator() +
                "Collection of questions with multiple choices" + System.lineSeparator() +
                "Score: 5.0", execution.toString());
    }

}
