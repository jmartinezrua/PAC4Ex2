package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DSLabExceptionTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkExceptions() {
        int numFields = 7;

        // Check attribute fields
        assertEquals(numFields, DSLabException.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(DSLabException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, DSLabException.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] Name cannot be null, empty or blank", DSLabException.INVALID_NAME);

            assertTrue(Modifier.isPublic(DSLabException.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabException.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabException.class.getDeclaredField("INVALID_DESCRIPTION").getModifiers()));
            assertEquals(String.class, DSLabException.class.getDeclaredField("INVALID_DESCRIPTION").getType());
            assertEquals("[ERROR] Description cannot be null", DSLabException.INVALID_DESCRIPTION);

            assertTrue(Modifier.isPublic(DSLabException.class.getDeclaredField("INVALID_VERSION_MAJOR").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabException.class.getDeclaredField("INVALID_VERSION_MAJOR").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabException.class.getDeclaredField("INVALID_VERSION_MAJOR").getModifiers()));
            assertEquals(String.class, DSLabException.class.getDeclaredField("INVALID_VERSION_MAJOR").getType());
            assertEquals("[ERROR] Major version cannot be negative", DSLabException.INVALID_VERSION_MAJOR);

            assertTrue(Modifier.isPublic(DSLabException.class.getDeclaredField("INVALID_VERSION_MINOR").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabException.class.getDeclaredField("INVALID_VERSION_MINOR").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabException.class.getDeclaredField("INVALID_VERSION_MINOR").getModifiers()));
            assertEquals(String.class, DSLabException.class.getDeclaredField("INVALID_VERSION_MINOR").getType());
            assertEquals("[ERROR] Minor version cannot be negative", DSLabException.INVALID_VERSION_MINOR);

            assertTrue(Modifier.isPublic(DSLabException.class.getDeclaredField("INVALID_VERSION_PATCH").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabException.class.getDeclaredField("INVALID_VERSION_PATCH").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabException.class.getDeclaredField("INVALID_VERSION_PATCH").getModifiers()));
            assertEquals(String.class, DSLabException.class.getDeclaredField("INVALID_VERSION_PATCH").getType());
            assertEquals("[ERROR] Patch version cannot be negative", DSLabException.INVALID_VERSION_PATCH);

            assertTrue(Modifier.isPublic(DSLabException.class.getDeclaredField("NO_ENOUGH_CPU").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabException.class.getDeclaredField("NO_ENOUGH_CPU").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabException.class.getDeclaredField("NO_ENOUGH_CPU").getModifiers()));
            assertEquals(String.class, DSLabException.class.getDeclaredField("NO_ENOUGH_CPU").getType());
            assertEquals("[ERROR] This server does not have enough CPU", DSLabException.NO_ENOUGH_CPU);

            assertTrue(Modifier.isPublic(DSLabException.class.getDeclaredField("UNIVERSITY_NULL").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabException.class.getDeclaredField("UNIVERSITY_NULL").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabException.class.getDeclaredField("UNIVERSITY_NULL").getModifiers()));
            assertEquals(String.class, DSLabException.class.getDeclaredField("UNIVERSITY_NULL").getType());
            assertEquals("[ERROR] University cannot be null", DSLabException.UNIVERSITY_NULL);
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructors() {
        int numConstructors = 1;

        // Check number of constructors
        assertEquals(numConstructors, DSLabException.class.getConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(DSLabException.class.getConstructor(String.class).getModifiers()), "The constructor DSLabException(String) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(DSLabException.class), "DSLabException class must inherit from Exception");
    }

}
