package edu.uoc.pac4.user;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserExceptionTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        assertEquals(2, UserException.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(UserException.class.getDeclaredField("INVALID_EMAIL").getModifiers()));
            assertTrue(Modifier.isStatic(UserException.class.getDeclaredField("INVALID_EMAIL").getModifiers()));
            assertTrue(Modifier.isFinal(UserException.class.getDeclaredField("INVALID_EMAIL").getModifiers()));
            assertEquals(String.class, UserException.class.getDeclaredField("INVALID_EMAIL").getType());
            assertEquals("[ERROR] The email must start with any character end with @uoc.edu", UserException.INVALID_EMAIL);

            assertTrue(Modifier.isPublic(UserException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isStatic(UserException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertTrue(Modifier.isFinal(UserException.class.getDeclaredField("INVALID_NAME").getModifiers()));
            assertEquals(String.class, UserException.class.getDeclaredField("INVALID_NAME").getType());
            assertEquals("[ERROR] Name cannot be null, empty or blank", UserException.INVALID_NAME);
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Constructors definition")
    void checkConstructors() {
        assertEquals(1, UserException.class.getConstructors().length);

        try {
            assertTrue(Modifier.isPublic(UserException.class.getConstructor(String.class).getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Exception.class.isAssignableFrom(UserException.class));
    }

}
