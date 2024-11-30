package edu.uoc.pac4.activity;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityExceptionTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        assertEquals(6, ActivityException.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(ActivityException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(ActivityException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, ActivityException.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] Name cannot be null, empty or blank", ActivityException.INVALID_NAME);

            assertTrue(Modifier.isPublic(ActivityException.class.getDeclaredField("INVALID_CPP_COMPILER").getModifiers()));
            assertTrue(Modifier.isStatic(ActivityException.class.getDeclaredField("INVALID_CPP_COMPILER").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityException.class.getDeclaredField("INVALID_CPP_COMPILER").getModifiers()));
            assertEquals(String.class, ActivityException.class.getDeclaredField("INVALID_CPP_COMPILER").getType());
            assertEquals("[ERROR] Compiler cannot be null, empty or blank", ActivityException.INVALID_CPP_COMPILER);

            assertTrue(Modifier.isPublic(ActivityException.class.getDeclaredField("INVALID_CPP_STANDARD").getModifiers()));
            assertTrue(Modifier.isStatic(ActivityException.class.getDeclaredField("INVALID_CPP_STANDARD").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityException.class.getDeclaredField("INVALID_CPP_STANDARD").getModifiers()));
            assertEquals(String.class, ActivityException.class.getDeclaredField("INVALID_CPP_STANDARD").getType());
            assertEquals("[ERROR] Standard cannot be null, empty or blank", ActivityException.INVALID_CPP_STANDARD);

            assertTrue(Modifier.isPublic(ActivityException.class.getDeclaredField("INVALID_JDK_VERSION").getModifiers()));
            assertTrue(Modifier.isStatic(ActivityException.class.getDeclaredField("INVALID_JDK_VERSION").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityException.class.getDeclaredField("INVALID_JDK_VERSION").getModifiers()));
            assertEquals(String.class, ActivityException.class.getDeclaredField("INVALID_JDK_VERSION").getType());
            assertEquals("[ERROR] JDK version must be in the format x.y.z where y and z are optional", ActivityException.INVALID_JDK_VERSION);

            assertTrue(Modifier.isPublic(ActivityException.class.getDeclaredField("INVALID_GRADLE_VERSION").getModifiers()));
            assertTrue(Modifier.isStatic(ActivityException.class.getDeclaredField("INVALID_GRADLE_VERSION").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityException.class.getDeclaredField("INVALID_GRADLE_VERSION").getModifiers()));
            assertEquals(String.class, ActivityException.class.getDeclaredField("INVALID_GRADLE_VERSION").getType());
            assertEquals("[ERROR] Gradle version must be in the format x.y.z where z is optional", ActivityException.INVALID_GRADLE_VERSION);

            assertTrue(Modifier.isPublic(ActivityException.class.getDeclaredField("INVALID_PYTHON_VERSION").getModifiers()));
            assertTrue(Modifier.isStatic(ActivityException.class.getDeclaredField("INVALID_PYTHON_VERSION").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityException.class.getDeclaredField("INVALID_PYTHON_VERSION").getModifiers()));
            assertEquals(String.class, ActivityException.class.getDeclaredField("INVALID_PYTHON_VERSION").getType());
            assertEquals("[ERROR] Python version must be in the format x.y.z where z is optional", ActivityException.INVALID_PYTHON_VERSION);
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructors() {
        assertEquals(1, ActivityException.class.getConstructors().length);

        try {
            assertTrue(Modifier.isPublic(ActivityException.class.getConstructor(String.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(ActivityException.class));
    }

}
