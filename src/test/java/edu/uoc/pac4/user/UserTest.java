package edu.uoc.pac4.user;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(3, User.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(User.class.getDeclaredField("email").getModifiers()));
            assertFalse(Modifier.isStatic(User.class.getDeclaredField("email").getModifiers()));
            assertFalse(Modifier.isFinal(User.class.getDeclaredField("email").getModifiers()));
            assertEquals(String.class, User.class.getDeclaredField("email").getType());

            assertTrue(Modifier.isPrivate(User.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(User.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(User.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, User.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(User.class.getDeclaredField("surname").getModifiers()));
            assertFalse(Modifier.isStatic(User.class.getDeclaredField("surname").getModifiers()));
            assertFalse(Modifier.isFinal(User.class.getDeclaredField("surname").getModifiers()));
            assertEquals(String.class, User.class.getDeclaredField("surname").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, User.class.getDeclaredConstructors().length);
        assertEquals(7, Arrays.stream(User.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(User.class.getDeclaredMethod("getEmail").getModifiers()));
            assertFalse(Modifier.isStatic(User.class.getDeclaredMethod("getEmail").getModifiers()));
            assertFalse(Modifier.isFinal(User.class.getDeclaredMethod("getEmail").getModifiers()));
            assertEquals(String.class, User.class.getDeclaredMethod("getEmail").getReturnType());

            assertTrue(Modifier.isPublic(User.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(User.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(User.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, User.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(User.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(User.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(User.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, User.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(User.class.getDeclaredMethod("setSurname", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(User.class.getDeclaredMethod("setSurname", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(User.class.getDeclaredMethod("setSurname", String.class).getModifiers()));
            assertEquals(void.class, User.class.getDeclaredMethod("setSurname", String.class).getReturnType());

            assertTrue(Modifier.isPublic(User.class.getDeclaredMethod("getSurname").getModifiers()));
            assertFalse(Modifier.isStatic(User.class.getDeclaredMethod("getSurname").getModifiers()));
            assertFalse(Modifier.isFinal(User.class.getDeclaredMethod("getSurname").getModifiers()));
            assertEquals(String.class, User.class.getDeclaredMethod("getSurname").getReturnType());

            assertTrue(Modifier.isPublic(User.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(User.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(User.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, User.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertTrue(Modifier.isAbstract(User.class.getModifiers()));
    }

}
