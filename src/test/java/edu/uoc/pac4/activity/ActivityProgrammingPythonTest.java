package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution;
import edu.uoc.pac4.user.Student;
import edu.uoc.pac4.user.UserException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityProgrammingPythonTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(2, ActivityProgrammingPython.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(ActivityProgrammingPython.class.getDeclaredField("pythonVersion").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingPython.class.getDeclaredField("pythonVersion").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingPython.class.getDeclaredField("pythonVersion").getModifiers()));
            assertEquals(String.class, ActivityProgrammingPython.class.getDeclaredField("pythonVersion").getType());

            assertTrue(Modifier.isPrivate(ActivityProgrammingPython.class.getDeclaredField("usesVirtualEnv").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingPython.class.getDeclaredField("usesVirtualEnv").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingPython.class.getDeclaredField("usesVirtualEnv").getModifiers()));
            assertEquals(boolean.class, ActivityProgrammingPython.class.getDeclaredField("usesVirtualEnv").getType());
        } catch (Exception e) {
            fail("The class ActivityProgrammingPython should have the fields 'pythonVersion' and 'usesVirtualEnv'");
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, ActivityProgrammingPython.class.getDeclaredConstructors().length);
        assertEquals(5, Arrays.stream(ActivityProgrammingPython.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(ActivityProgrammingPython.class.getDeclaredMethod("getPythonVersion").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingPython.class.getDeclaredMethod("getPythonVersion").getModifiers()));
            assertEquals(String.class, ActivityProgrammingPython.class.getDeclaredMethod("getPythonVersion").getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingPython.class.getDeclaredMethod("setPythonVersion", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingPython.class.getDeclaredMethod("setPythonVersion", String.class).getModifiers()));
            assertEquals(void.class, ActivityProgrammingPython.class.getDeclaredMethod("setPythonVersion", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingPython.class.getDeclaredMethod("getUsesVirtualEnv").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingPython.class.getDeclaredMethod("getUsesVirtualEnv").getModifiers()));
            assertEquals(boolean.class, ActivityProgrammingPython.class.getDeclaredMethod("getUsesVirtualEnv").getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingPython.class.getDeclaredMethod("setUsesVirtualEnv", boolean.class).getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingPython.class.getDeclaredMethod("setUsesVirtualEnv", boolean.class).getModifiers()));
            assertEquals(void.class, ActivityProgrammingPython.class.getDeclaredMethod("setUsesVirtualEnv", boolean.class).getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingPython.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingPython.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, ActivityProgrammingPython.class.getDeclaredMethod("toString").getReturnType());
        } catch (Exception e) {
            fail("The class ActivityProgrammingPython should have the required methods");
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(ActivityProgramming.class.isAssignableFrom(ActivityProgrammingPython.class));
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(ActivityProgrammingPython.class.getModifiers()));
    }

    @Test
    @Tag("minimum")
    @Order(5)
    @DisplayName("Minimum - Valid parameters")
    void testActivityProgrammingPythonCreationValidParameters() throws ActivityException {
        ActivityProgrammingPython activityProgrammingPython = new ActivityProgrammingPython("Activity 1", "Description of Activity 1", 25.0, "3.9.6", true);
        assertNotNull(activityProgrammingPython);

        assertEquals("Activity 1", activityProgrammingPython.getName());
        assertEquals("Description of Activity 1", activityProgrammingPython.getDescription());
        assertEquals(25.0, activityProgrammingPython.getWeight());
        assertEquals("3.9.6", activityProgrammingPython.getPythonVersion());
        assertTrue(activityProgrammingPython.getUsesVirtualEnv());
    }

    @Test
    @Tag("minimum")
    @Order(6)
    @DisplayName("Minimum - Name")
    void testActivityProgrammingPythonCreationName() throws ActivityException {
        Exception exception = assertThrows(ActivityException.class, () -> new ActivityProgrammingPython(null, "Description of Activity 1", 25.0, "3.9.6", true));
        assertEquals("[ERROR] Name cannot be null, empty or blank", exception.getMessage());

        assertThrows(ActivityException.class, () -> new ActivityProgrammingPython("", "Description of Activity 1", 25.0, "3.9.6", true));
        assertThrows(ActivityException.class, () -> new ActivityProgrammingPython("   ", "Description of Activity 1", 25.0, "3.9.6", true));

        ActivityProgrammingPython activityProgrammingPython = new ActivityProgrammingPython("Activity 1", "Description of Activity 1", 25.0, "3.9.6", true);
        assertEquals("Activity 1", activityProgrammingPython.getName());

        activityProgrammingPython.setName("Activity 2");
        assertEquals("Activity 2", activityProgrammingPython.getName());

        assertThrows(ActivityException.class, () -> activityProgrammingPython.setName(null));
        assertThrows(ActivityException.class, () -> activityProgrammingPython.setName(""));
        assertThrows(ActivityException.class, () -> activityProgrammingPython.setName("   "));

        assertEquals("Activity 2", activityProgrammingPython.getName());
    }

    @Test
    @Tag("advanced")
    @Order(7)
    @DisplayName("Advanced - Python Version")
    void testActivityProgrammingPythonVersion() throws ActivityException {
        ActivityProgrammingPython activityProgrammingPython = new ActivityProgrammingPython("Activity 1", "Description of Activity 1", 25.0, "3.9.6", true);

        activityProgrammingPython.setPythonVersion("3.8");
        assertEquals("3.8", activityProgrammingPython.getPythonVersion());

        activityProgrammingPython.setPythonVersion("3.10.1");
        assertEquals("3.10.1", activityProgrammingPython.getPythonVersion());

        Exception exception = assertThrows(ActivityException.class, () -> activityProgrammingPython.setPythonVersion(null));
        assertEquals("[ERROR] Python version must be in the format x.y.z where z is optional", exception.getMessage());

        assertThrows(ActivityException.class, () -> activityProgrammingPython.setPythonVersion(""));
        assertThrows(ActivityException.class, () -> activityProgrammingPython.setPythonVersion(" "));
        assertThrows(ActivityException.class, () -> activityProgrammingPython.setPythonVersion("3"));
        assertThrows(ActivityException.class, () -> activityProgrammingPython.setPythonVersion("3."));
        assertThrows(ActivityException.class, () -> activityProgrammingPython.setPythonVersion("a.b.c"));
        assertThrows(ActivityException.class, () -> activityProgrammingPython.setPythonVersion("3.9..0"));
    }

    @Test
    @Tag("advanced")
    @Order(8)
    @DisplayName("Advanced - Virtual Environment")
    void testActivityProgrammingPythonVirtualEnvironment() throws ActivityException {
        ActivityProgrammingPython activityProgrammingPython = new ActivityProgrammingPython("Activity 1", "Description of Activity 1", 25.0, "3.9.6", true);

        activityProgrammingPython.setUsesVirtualEnv(false);
        assertFalse(activityProgrammingPython.getUsesVirtualEnv());

        activityProgrammingPython.setUsesVirtualEnv(true);
        assertTrue(activityProgrammingPython.getUsesVirtualEnv());
    }

    @Test
    @Tag("advanced")
    @Order(9)
    @DisplayName("Advanced - toString")
    void testActivityProgrammingPythonToString() throws ActivityException {
        ActivityProgrammingPython activityProgrammingPython = new ActivityProgrammingPython("Activity 1", "Description of Activity 1", 25.0, "3.9.6", true);
        assertEquals("[Python] Activity 1: Description of Activity 1" + System.lineSeparator() + "Total executions: 0 (25.0%) (3.9.6, with virtualenv)", activityProgrammingPython.toString());
    }

    @Test
    @Tag("advanced")
    @Order(10)
    @DisplayName("Advanced - Executions and toString")
    void testActivityProgrammingPythonExecutionsAndToString() throws ActivityException, UserException {
        ActivityProgrammingPython activityProgrammingPython = new ActivityProgrammingPython("Activity 1", "Description of Activity 1", 25.0, "3.9.6", true);
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        new Execution(8.7, student, activityProgrammingPython);

        assertEquals("[Python] Activity 1: Description of Activity 1" + System.lineSeparator() + "Total executions: 1 (25.0%) (3.9.6, with virtualenv)", activityProgrammingPython.toString());

        new Execution(9.3, student, activityProgrammingPython);

        assertEquals(2, activityProgrammingPython.getExecutions().size());

        assertEquals("[Python] Activity 1: Description of Activity 1" + System.lineSeparator() + "Total executions: 2 (25.0%) (3.9.6, with virtualenv)", activityProgrammingPython.toString());
    }

    @Test
    @Tag("advanced")
    @Order(11)
    @DisplayName("Advanced - Clone")
    void testActivityProgrammingPythonClone() throws ActivityException, CloneNotSupportedException, UserException {
        ActivityProgrammingPython activityProgrammingPython = new ActivityProgrammingPython("Activity 1", "Description of Activity 1", 25.0, "3.9", true);
        ActivityProgrammingPython activityProgrammingPythonClone = (ActivityProgrammingPython) activityProgrammingPython.clone();

        assertEquals(activityProgrammingPython.getName(), activityProgrammingPythonClone.getName());
        assertEquals(activityProgrammingPython.getDescription(), activityProgrammingPythonClone.getDescription());
        assertEquals(activityProgrammingPython.getWeight(), activityProgrammingPythonClone.getWeight());
        assertEquals(activityProgrammingPython.getPythonVersion(), activityProgrammingPythonClone.getPythonVersion());
        assertEquals(activityProgrammingPython.getUsesVirtualEnv(), activityProgrammingPythonClone.getUsesVirtualEnv());

        new Execution(8.7, new Student("student@uoc.edu", "Name", "Surname"), activityProgrammingPython);
        assertEquals(1, activityProgrammingPython.getExecutions().size());

        activityProgrammingPythonClone = (ActivityProgrammingPython) activityProgrammingPython.clone();
        assertEquals(0, activityProgrammingPythonClone.getExecutions().size());
    }
}
