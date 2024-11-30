package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution;
import edu.uoc.pac4.user.Student;
import edu.uoc.pac4.user.UserException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityProgrammingCppTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(2, ActivityProgrammingCpp.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(ActivityProgrammingCpp.class.getDeclaredField("compiler").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingCpp.class.getDeclaredField("standard").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingCpp.class.getDeclaredField("compiler").getModifiers()));
            assertEquals(String.class, ActivityProgrammingCpp.class.getDeclaredField("compiler").getType());

            assertTrue(Modifier.isPrivate(ActivityProgrammingCpp.class.getDeclaredField("standard").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingCpp.class.getDeclaredField("standard").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingCpp.class.getDeclaredField("standard").getModifiers()));
            assertEquals(String.class, ActivityProgrammingCpp.class.getDeclaredField("standard").getType());
        } catch (Exception e) {
            fail("The class ActivityProgrammingCpp should have the fields 'compilerVersion' and 'makeVersion'");
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, ActivityProgrammingCpp.class.getDeclaredConstructors().length);
        assertEquals(5, Arrays.stream(ActivityProgrammingCpp.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(ActivityProgrammingCpp.class.getDeclaredMethod("getCompiler").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingCpp.class.getDeclaredMethod("getCompiler").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingCpp.class.getDeclaredMethod("getCompiler").getModifiers()));
            assertEquals(String.class, ActivityProgrammingCpp.class.getDeclaredMethod("getCompiler").getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingCpp.class.getDeclaredMethod("setCompiler", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingCpp.class.getDeclaredMethod("setCompiler", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingCpp.class.getDeclaredMethod("setCompiler", String.class).getModifiers()));
            assertEquals(void.class, ActivityProgrammingCpp.class.getDeclaredMethod("setCompiler", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingCpp.class.getDeclaredMethod("getStandard").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingCpp.class.getDeclaredMethod("getStandard").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingCpp.class.getDeclaredMethod("getStandard").getModifiers()));
            assertEquals(String.class, ActivityProgrammingCpp.class.getDeclaredMethod("getStandard").getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingCpp.class.getDeclaredMethod("setStandard", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingCpp.class.getDeclaredMethod("setStandard", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingCpp.class.getDeclaredMethod("setStandard", String.class).getModifiers()));
            assertEquals(void.class, ActivityProgrammingCpp.class.getDeclaredMethod("setStandard", String.class).getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgrammingCpp.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgrammingCpp.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgrammingCpp.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, ActivityProgrammingCpp.class.getDeclaredMethod("toString").getReturnType());
        } catch (Exception e) {
            fail("The class ActivityProgrammingCpp should have the methods 'getCompiler', 'setCompiler', 'getStandard', 'setStandard', 'toString'");
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Activity.class.isAssignableFrom(ActivityProgrammingCpp.class));
        assertTrue(ActivityProgramming.class.isAssignableFrom(ActivityProgrammingCpp.class));
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertFalse(Modifier.isAbstract(ActivityProgrammingCpp.class.getModifiers()));
    }

    @Test
    @Tag("minimum")
    @Order(5)
    @DisplayName("Minimum - Valid parameters")
    void testActivityProgrammingCppCreationValidParameters() throws ActivityException {
        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 25.0, "g++", "C++11");
        assertNotNull(activityProgrammingCpp);

        assertEquals("Activity 1", activityProgrammingCpp.getName());
        assertEquals("Description of Activity 1", activityProgrammingCpp.getDescription());
        assertEquals(25.0, activityProgrammingCpp.getWeight());
        assertEquals("g++", activityProgrammingCpp.getCompiler());
        assertEquals("C++11", activityProgrammingCpp.getStandard());
    }

    @Test
    @Tag("minimum")
    @Order(6)
    @DisplayName("Minimum - Name")
    void testActivityProgrammingCppCreationName() throws ActivityException {
        Exception exception = assertThrows(ActivityException.class, () -> new ActivityProgrammingCpp(null, "Description of Activity 1", 25.0, "g++", "C++11"));
        assertEquals("[ERROR] Name cannot be null, empty or blank", exception.getMessage());

        assertThrows(ActivityException.class, () -> new ActivityProgrammingCpp("", "Description of Activity 1", 25.0, "g++", "C++11"));
        assertThrows(ActivityException.class, () -> new ActivityProgrammingCpp("   ", "Description of Activity 1", 25.0, "g++", "C++11"));

        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 25.0, "g++", "C++11");
        assertEquals("Activity 1", activityProgrammingCpp.getName());

        activityProgrammingCpp.setName("Activity 2");
        assertEquals("Activity 2", activityProgrammingCpp.getName());

        assertThrows(ActivityException.class, () -> activityProgrammingCpp.setName(null));
        assertThrows(ActivityException.class, () -> activityProgrammingCpp.setName(""));
        assertThrows(ActivityException.class, () -> activityProgrammingCpp.setName("   "));

        assertEquals("Activity 2", activityProgrammingCpp.getName());
    }

    @Test
    @Tag("minimum")
    @Order(7)
    @DisplayName("Minimum - Description")
    void testActivityProgrammingCppCreationDescription() throws ActivityException {
        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 25.0, "g++", "C++11");
        assertEquals("Description of Activity 1", activityProgrammingCpp.getDescription());

        activityProgrammingCpp.setDescription("Description of Activity 2");
        assertEquals("Description of Activity 2", activityProgrammingCpp.getDescription());

        ActivityProgrammingCpp activityProgrammingCpp1 = new ActivityProgrammingCpp("Activity 1", null, 25.0, "g++", "C++11");
        assertEquals("", activityProgrammingCpp1.getDescription());
    }

    @Test
    @Tag("minimum")
    @Order(8)
    @DisplayName("Minimum - Weight")
    void testActivityProgrammingCppCreationWeight() throws ActivityException {
        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 0.0, "g++", "C++11");
        assertEquals(0.0, activityProgrammingCpp.getWeight());

        activityProgrammingCpp.setWeight(50.0);
        assertEquals(50.0, activityProgrammingCpp.getWeight());

        activityProgrammingCpp.setWeight(100.0);
        assertEquals(100.0, activityProgrammingCpp.getWeight());

        ActivityProgrammingCpp activityProgrammingCpp1 = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", -1.0, "g++", "C++11");
        assertEquals(0.0, activityProgrammingCpp1.getWeight());

        ActivityProgrammingCpp activityProgrammingCpp2 = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 100.1, "g++", "C++11");
        assertEquals(100.0, activityProgrammingCpp2.getWeight());
    }

    @Test
    @Tag("minimum")
    @Order(9)
    @DisplayName("Minimum - Compiler")
    void testActivityProgrammingCppCreationCompiler() throws ActivityException {
        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 25.0, "g++", "C++11");
        assertEquals("g++", activityProgrammingCpp.getCompiler());

        activityProgrammingCpp.setCompiler("clang++");
        assertEquals("clang++", activityProgrammingCpp.getCompiler());

        activityProgrammingCpp.setCompiler("  gcc  ");
        assertEquals("gcc", activityProgrammingCpp.getCompiler());

        assertThrows(ActivityException.class, () -> activityProgrammingCpp.setCompiler(null));
        assertThrows(ActivityException.class, () -> activityProgrammingCpp.setCompiler(""));
        assertThrows(ActivityException.class, () -> activityProgrammingCpp.setCompiler("   "));

        assertEquals("gcc", activityProgrammingCpp.getCompiler());
    }

    @Test
    @Tag("minimum")
    @Order(10)
    @DisplayName("Minimum - Standard")
    void testActivityProgrammingCppCreationStandard() throws ActivityException {
        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 25.0, "g++", "C++11");
        assertEquals("C++11", activityProgrammingCpp.getStandard());

        activityProgrammingCpp.setStandard("C++14");
        assertEquals("C++14", activityProgrammingCpp.getStandard());

        activityProgrammingCpp.setStandard("  C++11   ");
        assertEquals("C++11", activityProgrammingCpp.getStandard());

        assertThrows(ActivityException.class, () -> activityProgrammingCpp.setStandard(null));
        assertThrows(ActivityException.class, () -> activityProgrammingCpp.setStandard(""));
        assertThrows(ActivityException.class, () -> activityProgrammingCpp.setStandard("   "));

        assertEquals("C++11", activityProgrammingCpp.getStandard());
    }

    @Test
    @Tag("advanced")
    @Order(11)
    @DisplayName("Advanced - toString")
    void testActivityProgrammingCppToString() throws ActivityException {
        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 25.0, "g++", "C++11");
        assertEquals("[C++] Activity 1: Description of Activity 1" + System.lineSeparator() + "Total executions: 0 (25.0%) (g++, C++11)", activityProgrammingCpp.toString());

        ActivityProgrammingCpp activityProgrammingCpp1 = new ActivityProgrammingCpp("Activity 2", "Description of Activity 2", 50.0, "clang++", "C++14");
        assertEquals("[C++] Activity 2: Description of Activity 2" + System.lineSeparator() + "Total executions: 0 (50.0%) (clang++, C++14)", activityProgrammingCpp1.toString());
    }

    @Test
    @Tag("advanced")
    @Order(12)
    @DisplayName("Advanced - Executions")
    void testActivityProgrammingCppExecutions() throws ActivityException, UserException {
        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 25.0, "g++", "C++11");
        assertEquals(0, activityProgrammingCpp.getExecutions().size());

        Student student = new Student("student@uoc.edu", "Name", "Surname");
        Execution execution1 = new Execution(8.7, student, activityProgrammingCpp);

        assertEquals(1, activityProgrammingCpp.getExecutions().size());
        assertEquals(execution1, activityProgrammingCpp.getExecutions().getFirst());

        Execution execution2 = new Execution(9.3, student, activityProgrammingCpp);

        assertEquals(2, activityProgrammingCpp.getExecutions().size());
        assertEquals(execution1, activityProgrammingCpp.getExecutions().getFirst());
        assertEquals(execution2, activityProgrammingCpp.getExecutions().getLast());
    }

    @Test
    @Tag("advanced")
    @Order(13)
    @DisplayName("Advanced - Executions and toString")
    void testActivityProgrammingCppExecutionsAndToString() throws ActivityException, UserException {
        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 25.0, "g++", "C++11");
        Student student = new Student("student@uoc.edu", "Name", "Surname");
        new Execution(8.7, student, activityProgrammingCpp);

        assertEquals("[C++] Activity 1: Description of Activity 1" + System.lineSeparator() + "Total executions: 1 (25.0%) (g++, C++11)", activityProgrammingCpp.toString());

        new Execution(9.3, student, activityProgrammingCpp);

        assertEquals(2, activityProgrammingCpp.getExecutions().size());

        assertEquals("[C++] Activity 1: Description of Activity 1" + System.lineSeparator() + "Total executions: 2 (25.0%) (g++, C++11)", activityProgrammingCpp.toString());
    }

    @Test
    @Tag("advanced")
    @Order(14)
    @DisplayName("Advanced - Clone")
    void testActivityProgrammingCppClone() throws ActivityException, CloneNotSupportedException, UserException {
        ActivityProgrammingCpp activityProgrammingCpp = new ActivityProgrammingCpp("Activity 1", "Description of Activity 1", 25.0, "g++", "C++11");
        ActivityProgrammingCpp activityProgrammingCppClone = (ActivityProgrammingCpp) activityProgrammingCpp.clone();

        assertEquals(activityProgrammingCpp.getName(), activityProgrammingCppClone.getName());
        assertEquals(activityProgrammingCpp.getDescription(), activityProgrammingCppClone.getDescription());
        assertEquals(activityProgrammingCpp.getWeight(), activityProgrammingCppClone.getWeight());
        assertEquals(activityProgrammingCpp.getCompiler(), activityProgrammingCppClone.getCompiler());
        assertEquals(activityProgrammingCpp.getStandard(), activityProgrammingCppClone.getStandard());

        new Execution(8.7, new Student("student@uoc.edu", "Name", "Surname"), activityProgrammingCpp);
        assertEquals(1, activityProgrammingCpp.getExecutions().size());

        activityProgrammingCppClone = (ActivityProgrammingCpp) activityProgrammingCpp.clone();
        assertEquals(0, activityProgrammingCppClone.getExecutions().size());
    }

}
