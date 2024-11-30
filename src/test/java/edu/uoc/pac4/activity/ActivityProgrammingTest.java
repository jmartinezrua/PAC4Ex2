package edu.uoc.pac4.activity;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityProgrammingTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        assertEquals(1, ActivityProgramming.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(ActivityProgramming.class.getDeclaredField("weight").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgramming.class.getDeclaredField("weight").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgramming.class.getDeclaredField("weight").getModifiers()));
            assertEquals(double.class, ActivityProgramming.class.getDeclaredField("weight").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, ActivityProgramming.class.getDeclaredConstructors().length);
        assertEquals(3, Arrays.stream(ActivityProgramming.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(ActivityProgramming.class.getDeclaredMethod("getWeight").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgramming.class.getDeclaredMethod("getWeight").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgramming.class.getDeclaredMethod("getWeight").getModifiers()));
            assertEquals(double.class, ActivityProgramming.class.getDeclaredMethod("getWeight").getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgramming.class.getDeclaredMethod("setWeight", double.class).getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgramming.class.getDeclaredMethod("setWeight", double.class).getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgramming.class.getDeclaredMethod("setWeight", double.class).getModifiers()));
            assertEquals(void.class, ActivityProgramming.class.getDeclaredMethod("setWeight", double.class).getReturnType());

            assertTrue(Modifier.isPublic(ActivityProgramming.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityProgramming.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityProgramming.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, ActivityProgramming.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Interface implementation")
    void checkInterfaceImplementation() {
        assertTrue(Evaluable.class.isAssignableFrom(ActivityProgramming.class));
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Inheritance definition")
    void checkInheritance() {
        assertTrue(Activity.class.isAssignableFrom(ActivityProgramming.class));
    }

    @Test
    @Tag("sanity")
    @Order(5)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertTrue(Modifier.isAbstract(ActivityProgramming.class.getModifiers()));
    }

}
