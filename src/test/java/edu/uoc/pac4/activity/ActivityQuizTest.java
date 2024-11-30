package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution;
import edu.uoc.pac4.user.Student;
import edu.uoc.pac4.user.UserException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityQuizTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        assertEquals(1, ActivityQuiz.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(ActivityQuiz.class.getDeclaredField("type").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityQuiz.class.getDeclaredField("type").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityQuiz.class.getDeclaredField("type").getModifiers()));
            assertEquals(ActivityQuizType.class, ActivityQuiz.class.getDeclaredField("type").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, ActivityQuiz.class.getDeclaredConstructors().length);
        assertEquals(3, Arrays.stream(ActivityQuiz.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(ActivityQuiz.class.getDeclaredMethod("getType").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityQuiz.class.getDeclaredMethod("getType").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityQuiz.class.getDeclaredMethod("getType").getModifiers()));
            assertEquals(ActivityQuizType.class, ActivityQuiz.class.getDeclaredMethod("getType").getReturnType());

            assertTrue(Modifier.isPublic(ActivityQuiz.class.getDeclaredMethod("setType", ActivityQuizType.class).getModifiers()));
            assertFalse(Modifier.isStatic(ActivityQuiz.class.getDeclaredMethod("setType", ActivityQuizType.class).getModifiers()));
            assertFalse(Modifier.isFinal(ActivityQuiz.class.getDeclaredMethod("setType", ActivityQuizType.class).getModifiers()));
            assertEquals(void.class, ActivityQuiz.class.getDeclaredMethod("setType", ActivityQuizType.class).getReturnType());

            assertTrue(Modifier.isPublic(ActivityQuiz.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityQuiz.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityQuiz.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, ActivityQuiz.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Activity.class.isAssignableFrom(ActivityQuiz.class));
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(ActivityQuiz.class.getModifiers()));
    }

    @Test
    @Tag("minimum")
    @Order(5)
    @DisplayName("Minimum - Valid parameters")
    void testActivityQuizCreationValidParameters() throws ActivityException {
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);
        assertNotNull(activityQuiz);

        assertEquals("Activity 1", activityQuiz.getName());
        assertEquals("Description of Activity 1", activityQuiz.getDescription());
        assertEquals(ActivityQuizType.MULTIPLE_CHOICE, activityQuiz.getType());
    }

    @Test
    @Tag("minimum")
    @Order(6)
    @DisplayName("Minimum - Name")
    void testActivityQuizCreationName() throws ActivityException {
        Exception exception = assertThrows(ActivityException.class, () -> new ActivityQuiz(null, "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE));
        assertEquals("[ERROR] Name cannot be null, empty or blank", exception.getMessage());

        assertThrows(ActivityException.class, () -> new ActivityQuiz("", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE));
        assertThrows(ActivityException.class, () -> new ActivityQuiz("   ", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE));

        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);
        assertEquals("Activity 1", activityQuiz.getName());

        activityQuiz.setName("Activity 2");
        assertEquals("Activity 2", activityQuiz.getName());

        assertThrows(ActivityException.class, () -> activityQuiz.setName(null));
        assertThrows(ActivityException.class, () -> activityQuiz.setName(""));
        assertThrows(ActivityException.class, () -> activityQuiz.setName("   "));

        assertEquals("Activity 2", activityQuiz.getName());
    }

    @Test
    @Tag("minimum")
    @Order(7)
    @DisplayName("Minimum - Description")
    void testActivityQuizCreationDescription() throws ActivityException {
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);
        assertEquals("Description of Activity 1", activityQuiz.getDescription());

        activityQuiz.setDescription("Description of Activity 2");
        assertEquals("Description of Activity 2", activityQuiz.getDescription());

        ActivityQuiz activityQuiz1 = new ActivityQuiz("Activity 1", null, ActivityQuizType.MULTIPLE_CHOICE);
        assertEquals("", activityQuiz1.getDescription());
    }

    @Test
    @Tag("minimum")
    @Order(8)
    @DisplayName("Minimum - Type")
    void testActivityQuizCreationType() throws ActivityException {
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);
        assertEquals(ActivityQuizType.MULTIPLE_CHOICE, activityQuiz.getType());

        activityQuiz.setType(ActivityQuizType.TRUE_FALSE);
        assertEquals(ActivityQuizType.TRUE_FALSE, activityQuiz.getType());

        activityQuiz.setType(ActivityQuizType.SHORT_ANSWER);
        assertEquals(ActivityQuizType.SHORT_ANSWER, activityQuiz.getType());
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - toString")
    void testActivityQuizToString() throws ActivityException {
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);
        assertEquals("Activity 1: Description of Activity 1" + System.lineSeparator() +
                "Total executions: 0" + System.lineSeparator() +
                "Collection of questions with multiple choices", activityQuiz.toString());

        activityQuiz.setType(ActivityQuizType.TRUE_FALSE);
        assertEquals("Activity 1: Description of Activity 1" + System.lineSeparator() +
                "Total executions: 0" + System.lineSeparator() +
                "Collection of questions with true or false answers", activityQuiz.toString());

        activityQuiz.setType(ActivityQuizType.SHORT_ANSWER);
        assertEquals("Activity 1: Description of Activity 1" + System.lineSeparator() +
                "Total executions: 0" + System.lineSeparator() +
                "Collection of questions with short answers", activityQuiz.toString());
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - Executions")
    void testActivityQuizExecutions() throws ActivityException, UserException {
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);
        assertEquals(0, activityQuiz.getExecutions().size());

        Student student = new Student("student@uoc.edu", "Name", "Surname");
        Execution execution1 = new Execution(8.7, student, activityQuiz);

        assertEquals(1, activityQuiz.getExecutions().size());
        assertEquals(execution1, activityQuiz.getExecutions().getFirst());

        Execution execution2 = new Execution(9.3, student, activityQuiz);

        assertEquals(2, activityQuiz.getExecutions().size());
        assertEquals(execution1, activityQuiz.getExecutions().getFirst());
        assertEquals(execution2, activityQuiz.getExecutions().getLast());
    }

    @Test
    @Tag("advanced")
    @Order(11)
    @DisplayName("Advanced - Executions and toString")
    void testActivityQuizExecutionsAndToString() throws ActivityException, UserException {
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        new Execution(8.7, student, activityQuiz);

        assertEquals("Activity 1: Description of Activity 1" + System.lineSeparator() +
                "Total executions: 1" + System.lineSeparator() +
                "Collection of questions with multiple choices", activityQuiz.toString());

        new Execution(9.3, student, activityQuiz);

        assertEquals(2, activityQuiz.getExecutions().size());

        assertEquals("Activity 1: Description of Activity 1" + System.lineSeparator() +
                "Total executions: 2" + System.lineSeparator() +
                "Collection of questions with multiple choices", activityQuiz.toString());
    }

    @Test
    @Tag("advanced")
    @Order(14)
    @DisplayName("Advanced - Clone")
    void testActivityQuizClone() throws ActivityException, CloneNotSupportedException, UserException {
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);
        ActivityQuiz activityQuizClone = (ActivityQuiz) activityQuiz.clone();

        assertEquals(activityQuiz.getName(), activityQuizClone.getName());
        assertEquals(activityQuiz.getDescription(), activityQuizClone.getDescription());
        assertEquals(activityQuiz.getType(), activityQuizClone.getType());

        new Execution(8.7, new Student("student@uoc.edu", "Name", "Surname"), activityQuiz);
        assertEquals(1, activityQuiz.getExecutions().size());

        activityQuizClone = (ActivityQuiz) activityQuiz.clone();
        assertEquals(0, activityQuizClone.getExecutions().size());
    }
}
