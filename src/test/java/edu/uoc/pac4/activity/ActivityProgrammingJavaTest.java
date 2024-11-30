package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution;
import edu.uoc.pac4.user.Student;
import edu.uoc.pac4.user.UserException;
import org.junit.jupiter.api.*;

import edu.uoc.pac4.activity.ActivityProgrammingJava;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityProgrammingJavaTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(2, ActivityProgrammingJava.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(ActivityProgrammingJava.class.getDeclaredField("jdkVersion").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingJava.class.getDeclaredField("jdkVersion").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingJava.class.getDeclaredField("jdkVersion").getModifiers()));
            assertEquals(String.class, ActivityProgrammingJava.class.getDeclaredField("jdkVersion").getType());

            assertTrue(Modifier.isPrivate(ActivityProgrammingJava.class.getDeclaredField("gradleVersion").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingJava.class.getDeclaredField("gradleVersion").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingJava.class.getDeclaredField("gradleVersion").getModifiers()));
            assertEquals(String.class, ActivityProgrammingJava.class.getDeclaredField("gradleVersion").getType());
        } catch (Exception e) {
            fail("The class ActivityProgrammingJava should have the fields 'jdkVersion' and 'gradleVersion'");
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, ActivityProgrammingJava.class.getDeclaredConstructors().length);
        assertEquals(5, Arrays.stream(ActivityProgrammingJava.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(ActivityProgrammingJava.class.getDeclaredMethod("getJdkVersion").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingJava.class.getDeclaredMethod("getJdkVersion").getModifiers()));
            assertEquals(String.class, ActivityProgrammingJava.class.getDeclaredMethod("getJdkVersion").getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingJava.class.getDeclaredMethod("setJdkVersion", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingJava.class.getDeclaredMethod("setJdkVersion", String.class).getModifiers()));
            assertEquals(void.class, ActivityProgrammingJava.class.getDeclaredMethod("setJdkVersion", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingJava.class.getDeclaredMethod("getGradleVersion").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingJava.class.getDeclaredMethod("getGradleVersion").getModifiers()));
            assertEquals(String.class, ActivityProgrammingJava.class.getDeclaredMethod("getGradleVersion").getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingJava.class.getDeclaredMethod("setGradleVersion", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingJava.class.getDeclaredMethod("setGradleVersion", String.class).getModifiers()));
            assertEquals(void.class, ActivityProgrammingJava.class.getDeclaredMethod("setGradleVersion", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingJava.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingJava.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, ActivityProgrammingJava.class.getDeclaredMethod("toString").getReturnType());
        } catch (Exception e) {
            fail("The class ActivityProgrammingJava should have the required methods");
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(ActivityProgramming.class.isAssignableFrom(ActivityProgrammingJava.class));
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(ActivityProgrammingJava.class.getModifiers()));
    }

    @Test
    @Tag("minimum")
    @Order(5)
    @DisplayName("Minimum - Valid parameters")
    void testActivityProgrammingJavaCreationValidParameters() throws ActivityException {
        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 25.0, "17", "7.6.1");
        assertNotNull(activityProgrammingJava);

        assertEquals("Activity 1", activityProgrammingJava.getName());
        assertEquals("Description of Activity 1", activityProgrammingJava.getDescription());
        assertEquals(25.0, activityProgrammingJava.getWeight());
        assertEquals("17", activityProgrammingJava.getJdkVersion());
        assertEquals("7.6.1", activityProgrammingJava.getGradleVersion());
    }

    @Test
    @Tag("minimum")
    @Order(6)
    @DisplayName("Minimum - Name")
    void testActivityProgrammingJavaCreationName() throws ActivityException {
        Exception exception = assertThrows(ActivityException.class, () -> new ActivityProgrammingJava(null, "Description of Activity 1", 25.0, "17", "7.6.1"));
        assertEquals("[ERROR] Name cannot be null, empty or blank", exception.getMessage());

        assertThrows(ActivityException.class, () -> new ActivityProgrammingJava("", "Description of Activity 1", 25.0, "17", "7.6.1"));
        assertThrows(ActivityException.class, () -> new ActivityProgrammingJava("   ", "Description of Activity 1", 25.0, "17", "7.6.1"));

        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 25.0, "17", "7.6.1");
        assertEquals("Activity 1", activityProgrammingJava.getName());

        activityProgrammingJava.setName("Activity 2");
        assertEquals("Activity 2", activityProgrammingJava.getName());

        assertThrows(ActivityException.class, () -> activityProgrammingJava.setName(null));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setName(""));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setName("   "));

        assertEquals("Activity 2", activityProgrammingJava.getName());
    }

    @Test
    @Tag("minimum")
    @Order(7)
    @DisplayName("Minimum - Description")
    void testActivityProgrammingJavaCreationDescription() throws ActivityException {
        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 25.0, "17", "7.6.1");
        assertEquals("Description of Activity 1", activityProgrammingJava.getDescription());

        activityProgrammingJava.setDescription("Description of Activity 2");
        assertEquals("Description of Activity 2", activityProgrammingJava.getDescription());

        ActivityProgrammingJava activityProgrammingJava1 = new ActivityProgrammingJava("Activity 1", null, 25.0, "17", "7.6.1");
        assertEquals("", activityProgrammingJava1.getDescription());
    }

    @Test
    @Tag("minimum")
    @Order(8)
    @DisplayName("Minimum - Weight")
    void testActivityProgrammingJavaCreationWeight() throws ActivityException {
        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 0.0, "17", "7.6.1");
        assertEquals(0.0, activityProgrammingJava.getWeight());

        activityProgrammingJava.setWeight(50.0);
        assertEquals(50.0, activityProgrammingJava.getWeight());

        activityProgrammingJava.setWeight(100.0);
        assertEquals(100.0, activityProgrammingJava.getWeight());

        ActivityProgrammingJava activityProgrammingJava1 = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", -1.0, "17", "7.6.1");
        assertEquals(0.0, activityProgrammingJava1.getWeight());

        ActivityProgrammingJava activityProgrammingJava2 = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 100.1, "17", "7.6.1");
        assertEquals(100.0, activityProgrammingJava2.getWeight());
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - JDK Version")
    void testActivityProgrammingJavaJdkVersion() throws ActivityException {
        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 25.0, "17", "7.6.1");

        activityProgrammingJava.setJdkVersion("1");
        assertEquals("1", activityProgrammingJava.getJdkVersion());

        activityProgrammingJava.setJdkVersion("11.0");
        assertEquals("11.0", activityProgrammingJava.getJdkVersion());

        activityProgrammingJava.setJdkVersion("17.0.1");
        assertEquals("17.0.1", activityProgrammingJava.getJdkVersion());

        Exception exception = assertThrows(ActivityException.class, () -> activityProgrammingJava.setJdkVersion(null));
        assertEquals("[ERROR] JDK version must be in the format x.y.z where y and z are optional", exception.getMessage());

        assertThrows(ActivityException.class, () -> activityProgrammingJava.setJdkVersion(""));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setJdkVersion(" "));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setJdkVersion("17."));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setJdkVersion("a.b.c"));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setJdkVersion("1..0"));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setJdkVersion("1.0."));
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - Gradle Version")
    void testActivityProgrammingJavaGradleVersion() throws ActivityException {
        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 25.0, "17", "7.6.1");

        activityProgrammingJava.setGradleVersion("1.0");
        assertEquals("1.0", activityProgrammingJava.getGradleVersion());

        activityProgrammingJava.setGradleVersion("2.1.1");
        assertEquals("2.1.1", activityProgrammingJava.getGradleVersion());

        activityProgrammingJava.setGradleVersion("7.6");
        assertEquals("7.6", activityProgrammingJava.getGradleVersion());

        Exception exception = assertThrows(ActivityException.class, () -> activityProgrammingJava.setGradleVersion(null));
        assertEquals("[ERROR] Gradle version must be in the format x.y.z where z is optional", exception.getMessage());

        assertThrows(ActivityException.class, () -> activityProgrammingJava.setGradleVersion(""));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setGradleVersion(" "));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setGradleVersion("7"));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setGradleVersion("7."));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setGradleVersion("a.b"));
        assertThrows(ActivityException.class, () -> activityProgrammingJava.setGradleVersion("1.1..0"));
    }

    @Test
    @Tag("advanced")
    @Order(11)
    @DisplayName("Advanced - toString")
    void testActivityProgrammingJavaToString() throws ActivityException {
        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 25.0, "17", "7.6.1");
        assertEquals("[Java] Activity 1: Description of Activity 1" + System.lineSeparator() + "Total executions: 0 (25.0%) (jdk-17, gradle v7.6.1)", activityProgrammingJava.toString());
    }

    @Test
    @Tag("advanced")
    @Order(12)
    @DisplayName("Advanced - Executions")
    void testActivityProgrammingJavaExecutions() throws ActivityException, UserException {
        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 25.0, "17", "7.6.1");
        assertEquals(0, activityProgrammingJava.getExecutions().size());

        Student student = new Student("student@uoc.edu", "Name", "Surname");
        Execution execution1 = new Execution(8.7, student, activityProgrammingJava);

        assertEquals(1, activityProgrammingJava.getExecutions().size());
        assertEquals(execution1, activityProgrammingJava.getExecutions().getFirst());

        Execution execution2 = new Execution(9.3, student, activityProgrammingJava);

        assertEquals(2, activityProgrammingJava.getExecutions().size());
        assertEquals(execution1, activityProgrammingJava.getExecutions().getFirst());
        assertEquals(execution2, activityProgrammingJava.getExecutions().getLast());
    }

    @Test
    @Tag("advanced")
    @Order(13)
    @DisplayName("Advanced - Executions and toString")
    void testActivityProgrammingJavaExecutionsAndToString() throws ActivityException, UserException {
        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 25.0, "17", "7.6.1");
        Student student = new Student("student@uoc.edu", "Name", "Surname");

        new Execution(8.7, student, activityProgrammingJava);

        assertEquals("[Java] Activity 1: Description of Activity 1" + System.lineSeparator() + "Total executions: 1 (25.0%) (jdk-17, gradle v7.6.1)", activityProgrammingJava.toString());

        new Execution(9.3, student, activityProgrammingJava);

        assertEquals(2, activityProgrammingJava.getExecutions().size());

        assertEquals("[Java] Activity 1: Description of Activity 1" + System.lineSeparator() + "Total executions: 2 (25.0%) (jdk-17, gradle v7.6.1)", activityProgrammingJava.toString());
    }

    @Test
    @Tag("advanced")
    @Order(14)
    @DisplayName("Advanced - Clone")
    void testActivityProgrammingJavaClone() throws ActivityException, CloneNotSupportedException, UserException {
        ActivityProgrammingJava activityProgrammingJava = new ActivityProgrammingJava("Activity 1", "Description of Activity 1", 25.0, "17", "7.6.1");
        ActivityProgrammingJava activityProgrammingJavaClone = (ActivityProgrammingJava) activityProgrammingJava.clone();

        assertEquals(activityProgrammingJava.getName(), activityProgrammingJavaClone.getName());
        assertEquals(activityProgrammingJava.getDescription(), activityProgrammingJavaClone.getDescription());
        assertEquals(activityProgrammingJava.getWeight(), activityProgrammingJavaClone.getWeight());
        assertEquals(activityProgrammingJava.getJdkVersion(), activityProgrammingJavaClone.getJdkVersion());
        assertEquals(activityProgrammingJava.getGradleVersion(), activityProgrammingJavaClone.getGradleVersion());

        new Execution(8.7, new Student("student@uoc.edu", "Name", "Surname"), activityProgrammingJava);
        assertEquals(1, activityProgrammingJava.getExecutions().size());

        activityProgrammingJavaClone = (ActivityProgrammingJava) activityProgrammingJava.clone();
        assertEquals(0, activityProgrammingJavaClone.getExecutions().size());
    }

}
