package edu.uoc.pac4.university;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversityExceptionTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkExceptions() {
        int numFields = 5;

        // Check attribute fields
        assertEquals(numFields, UniversityException.class.getDeclaredFields().length, "The class must have exactly " + numFields + " attributes");

        try {
            assertTrue(Modifier.isPublic(UniversityException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(UniversityException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(UniversityException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, UniversityException.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] Name cannot be null, empty or blank", UniversityException.INVALID_NAME);

            assertTrue(Modifier.isPublic(UniversityException.class.getDeclaredField("INVALID_ABBREVIATION").getModifiers()));
            assertTrue(Modifier.isStatic(UniversityException.class.getDeclaredField("INVALID_ABBREVIATION").getModifiers()));
            assertTrue(Modifier.isFinal(UniversityException.class.getDeclaredField("INVALID_ABBREVIATION").getModifiers()));
            assertEquals(String.class, UniversityException.class.getDeclaredField("INVALID_ABBREVIATION").getType());
            assertEquals("[ERROR] Abbreviation has to contain between 2 and 6 uppercase letters", UniversityException.INVALID_ABBREVIATION);

            assertTrue(Modifier.isPublic(UniversityException.class.getDeclaredField("INVALID_FOUNDATION_DATE").getModifiers()));
            assertTrue(Modifier.isStatic(UniversityException.class.getDeclaredField("INVALID_FOUNDATION_DATE").getModifiers()));
            assertTrue(Modifier.isFinal(UniversityException.class.getDeclaredField("INVALID_FOUNDATION_DATE").getModifiers()));
            assertEquals(String.class, UniversityException.class.getDeclaredField("INVALID_FOUNDATION_DATE").getType());
            assertEquals("[ERROR] Foundation date cannot be null or in the future", UniversityException.INVALID_FOUNDATION_DATE);

            assertTrue(Modifier.isPublic(UniversityException.class.getDeclaredField("INVALID_ADDRESS").getModifiers()));
            assertTrue(Modifier.isStatic(UniversityException.class.getDeclaredField("INVALID_ADDRESS").getModifiers()));
            assertTrue(Modifier.isFinal(UniversityException.class.getDeclaredField("INVALID_ADDRESS").getModifiers()));
            assertEquals(String.class, UniversityException.class.getDeclaredField("INVALID_ADDRESS").getType());
            assertEquals("[ERROR] Address cannot be null", UniversityException.INVALID_ADDRESS);

            assertTrue(Modifier.isPublic(UniversityException.class.getDeclaredField("INVALID_WEBSITE").getModifiers()));
            assertTrue(Modifier.isStatic(UniversityException.class.getDeclaredField("INVALID_WEBSITE").getModifiers()));
            assertTrue(Modifier.isFinal(UniversityException.class.getDeclaredField("INVALID_WEBSITE").getModifiers()));
            assertEquals(String.class, UniversityException.class.getDeclaredField("INVALID_WEBSITE").getType());
            assertEquals("[ERROR] Website cannot be null and must be a valid URL", UniversityException.INVALID_WEBSITE);
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
        assertEquals(numConstructors, UniversityException.class.getConstructors().length, "The class must have exactly " + numConstructors + " constructor");

        try {
            assertTrue(Modifier.isPublic(UniversityException.class.getConstructor(String.class).getModifiers()), "The constructor UniversityException(String) must be public");
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        int numMethods = 0;

        // Check number of methods
        assertEquals(numMethods, UniversityException.class.getDeclaredMethods().length, "The class must have exactly " + numMethods + " constructor");
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(UniversityException.class), "UniversityException class must inherit from Exception");
    }

}
