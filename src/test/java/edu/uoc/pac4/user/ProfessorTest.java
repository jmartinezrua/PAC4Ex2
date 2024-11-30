package edu.uoc.pac4.user;

import edu.uoc.pac4.activity.Activity;
import edu.uoc.pac4.activity.ActivityException;
import edu.uoc.pac4.activity.ActivityQuiz;
import edu.uoc.pac4.activity.ActivityQuizType;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProfessorTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(1, Professor.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Professor.class.getDeclaredField("activities").getModifiers()));
            assertFalse(Modifier.isStatic(Professor.class.getDeclaredField("activities").getModifiers()));
            assertFalse(Modifier.isFinal(Professor.class.getDeclaredField("activities").getModifiers()));
            assertEquals(LinkedList.class, Professor.class.getDeclaredField("activities").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, Professor.class.getDeclaredConstructors().length);
        assertEquals(3, Professor.class.getDeclaredMethods().length);

        try {
            assertTrue(Modifier.isPublic(Professor.class.getDeclaredMethod("addActivity", Activity.class).getModifiers()));
            assertFalse(Modifier.isStatic(Professor.class.getDeclaredMethod("addActivity", Activity.class).getModifiers()));
            assertFalse(Modifier.isFinal(Professor.class.getDeclaredMethod("addActivity", Activity.class).getModifiers()));
            assertEquals(void.class, Professor.class.getDeclaredMethod("addActivity", Activity.class).getReturnType());

            assertTrue(Modifier.isPublic(Professor.class.getDeclaredMethod("getActivities").getModifiers()));
            assertFalse(Modifier.isStatic(Professor.class.getDeclaredMethod("getActivities").getModifiers()));
            assertFalse(Modifier.isFinal(Professor.class.getDeclaredMethod("getActivities").getModifiers()));
            assertEquals(LinkedList.class, Professor.class.getDeclaredMethod("getActivities").getReturnType());

            assertTrue(Modifier.isPublic(Professor.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Professor.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Professor.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Professor.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(User.class.isAssignableFrom(Professor.class));
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(Professor.class.getModifiers()));
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Minimum - Valid parameters")
    void checkValidParameters() throws UserException {
        Professor professor = new Professor("professor@uoc.edu", "Name", "Surname");

        assertEquals("professor@uoc.edu", professor.getEmail());
        assertEquals("Name", professor.getName());
        assertEquals("Surname", professor.getSurname());
    }

    @Test
    @Tag("advanced")
    @Order(6)
    @DisplayName("Advanced - Email")
    void testProfessorCreationEmail() throws UserException {
        Exception exception = assertThrows(UserException.class, () -> new Professor(null, "Name", "Surname"));

        assertEquals("[ERROR] The email must start with any character end with @uoc.edu", exception.getMessage());

        assertThrows(UserException.class, () -> new Professor("", "Name", "Surname"));
        assertThrows(UserException.class, () -> new Professor("   ", "Name", "Surname"));
        assertThrows(UserException.class, () -> new Professor("@uoc.edu", "Name", "Surname"));

        Professor professor = new Professor("a@uoc.edu", "Name", "Surname");
        assertEquals("a@uoc.edu", professor.getEmail());

        Professor professor2 = new Professor("professor@uoc.edu", "Name", "Surname");
        assertEquals("professor@uoc.edu", professor2.getEmail());

        assertThrows(UserException.class, () -> professor.setEmail(null));
        assertThrows(UserException.class, () -> professor.setEmail(""));
        assertThrows(UserException.class, () -> professor.setEmail("   "));
        assertThrows(UserException.class, () -> professor.setEmail("@uoc.edu"));

        assertEquals("a@uoc.edu", professor.getEmail());
    }

    @Test
    @Tag("minimum")
    @Order(7)
    @DisplayName("Minimum - Name")
    void testProfessorCreationName() throws UserException {
        Exception exception = assertThrows(UserException.class, () -> new Professor("a@uoc.edu", null, "Surname"));

        assertEquals("[ERROR] Name cannot be null, empty or blank", exception.getMessage());

        assertThrows(UserException.class, () -> new Professor("a@uoc.edu", "", "Surname"));
        assertThrows(UserException.class, () -> new Professor("a@uoc.edu", "   ", "Surname"));

        Professor professor = new Professor("a@uoc.edu", "Name", "Surname");
        assertEquals("Name", professor.getName());

        professor.setName("Name 2");
        assertEquals("Name 2", professor.getName());

        assertThrows(UserException.class, () -> professor.setName(null));
        assertThrows(UserException.class, () -> professor.setName(""));
        assertThrows(UserException.class, () -> professor.setName("   "));

        assertEquals("Name 2", professor.getName());
    }

    @Test
    @Tag("minimum")
    @Order(8)
    @DisplayName("Minimum - Surname")
    void testProfessorCreationSurname() throws UserException {
        Professor professor = new Professor("a@uoc.edu", "Name", null);

        assertEquals("", professor.getSurname());

        professor.setSurname("Surname");
        assertEquals("Surname", professor.getSurname());

        Professor professor2 = new Professor("a@uoc.edu", "Name", "Surname");
        assertEquals("Surname", professor2.getSurname());
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - Activities")
    void testAddActivity() throws UserException, ActivityException {
        Professor professor = new Professor("professor@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);

        professor.addActivity(activityQuiz);
        assertEquals(1, professor.getActivities().size());
        assertEquals(activityQuiz, professor.getActivities().getFirst());

        ActivityQuiz activityQuiz2 = new ActivityQuiz("Activity 2", "Description of Activity 2", ActivityQuizType.MULTIPLE_CHOICE);
        professor.addActivity(activityQuiz2);
        assertEquals(2, professor.getActivities().size());
        assertEquals(activityQuiz, professor.getActivities().getFirst());
        assertEquals(activityQuiz2, professor.getActivities().getLast());
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - toString")
    void testToString() throws UserException, ActivityException {
        Professor professor = new Professor("professor@uoc.edu", "Name", "Surname");
        ActivityQuiz activityQuiz = new ActivityQuiz("Activity 1", "Description of Activity 1", ActivityQuizType.MULTIPLE_CHOICE);

        assertEquals("[PROFESSOR] Name Surname (professor@uoc.edu) Total activities: 0", professor.toString());

        professor.addActivity(activityQuiz);
        assertEquals("[PROFESSOR] Name Surname (professor@uoc.edu) Total activities: 1", professor.toString());
    }

}
