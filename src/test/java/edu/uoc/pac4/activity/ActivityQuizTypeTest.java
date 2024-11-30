package edu.uoc.pac4.activity;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityQuizTypeTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsDefinition() {
        assertEquals(5, ActivityQuizType.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(ActivityQuizType.class.getDeclaredField("MULTIPLE_CHOICE").getModifiers()));
            assertTrue(Modifier.isStatic(ActivityQuizType.class.getDeclaredField("MULTIPLE_CHOICE").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityQuizType.class.getDeclaredField("MULTIPLE_CHOICE").getModifiers()));
            assertEquals(ActivityQuizType.class, ActivityQuizType.class.getDeclaredField("MULTIPLE_CHOICE").getType());

            assertTrue(Modifier.isPublic(ActivityQuizType.class.getDeclaredField("TRUE_FALSE").getModifiers()));
            assertTrue(Modifier.isStatic(ActivityQuizType.class.getDeclaredField("TRUE_FALSE").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityQuizType.class.getDeclaredField("TRUE_FALSE").getModifiers()));
            assertEquals(ActivityQuizType.class, ActivityQuizType.class.getDeclaredField("TRUE_FALSE").getType());

            assertTrue(Modifier.isPublic(ActivityQuizType.class.getDeclaredField("SHORT_ANSWER").getModifiers()));
            assertTrue(Modifier.isStatic(ActivityQuizType.class.getDeclaredField("SHORT_ANSWER").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityQuizType.class.getDeclaredField("SHORT_ANSWER").getModifiers()));
            assertEquals(ActivityQuizType.class, ActivityQuizType.class.getDeclaredField("SHORT_ANSWER").getType());

            assertTrue(Modifier.isPrivate(ActivityQuizType.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityQuizType.class.getDeclaredField("description").getModifiers()));
            assertTrue(Modifier.isFinal(ActivityQuizType.class.getDeclaredField("description").getModifiers()));
            assertEquals(String.class, ActivityQuizType.class.getDeclaredField("description").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, ActivityQuizType.class.getDeclaredConstructors().length);
        assertEquals(4, Arrays.stream(ActivityQuizType.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(ActivityQuizType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityQuizType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityQuizType.class.getDeclaredMethod("getDescription").getModifiers()));
            assertEquals(String.class, ActivityQuizType.class.getDeclaredMethod("getDescription").getReturnType());

            assertTrue(Modifier.isPublic(ActivityQuizType.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(ActivityQuizType.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(ActivityQuizType.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, ActivityQuizType.class.getDeclaredMethod("toString").getReturnType());
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of constructors: " + e.getMessage());
        }

    }

}
