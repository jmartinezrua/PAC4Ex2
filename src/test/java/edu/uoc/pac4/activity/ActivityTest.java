package edu.uoc.pac4.activity;

import edu.uoc.pac4.execution.Execution;
import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivityTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(3, Activity.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(Activity.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, Activity.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(Activity.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredField("description").getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredField("description").getModifiers()));
            assertEquals(String.class, Activity.class.getDeclaredField("description").getType());

            assertTrue(Modifier.isPrivate(Activity.class.getDeclaredField("executions").getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredField("executions").getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredField("executions").getModifiers()));
            assertEquals(LinkedList.class, Activity.class.getDeclaredField("executions").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, Activity.class.getDeclaredConstructors().length);
        assertEquals(8, Arrays.stream(Activity.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(Activity.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, Activity.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(Activity.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, Activity.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Activity.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredMethod("getDescription").getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredMethod("getDescription").getModifiers()));
            assertEquals(String.class, Activity.class.getDeclaredMethod("getDescription").getReturnType());

            assertTrue(Modifier.isPublic(Activity.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredMethod("setDescription", String.class).getModifiers()));
            assertEquals(void.class, Activity.class.getDeclaredMethod("setDescription", String.class).getReturnType());

            assertTrue(Modifier.isPublic(Activity.class.getDeclaredMethod("addExecution", Execution.class).getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredMethod("addExecution", Execution.class).getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredMethod("addExecution", Execution.class).getModifiers()));
            assertEquals(void.class, Activity.class.getDeclaredMethod("addExecution", Execution.class).getReturnType());

            assertTrue(Modifier.isPublic(Activity.class.getDeclaredMethod("getExecutions").getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredMethod("getExecutions").getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredMethod("getExecutions").getModifiers()));
            assertEquals(LinkedList.class, Activity.class.getDeclaredMethod("getExecutions").getReturnType());

            assertTrue(Modifier.isPublic(Activity.class.getDeclaredMethod("clone").getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredMethod("clone").getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredMethod("clone").getModifiers()));
            assertEquals(Object.class, Activity.class.getDeclaredMethod("clone").getReturnType());

            assertTrue(Modifier.isPublic(Activity.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(Activity.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(Activity.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, Activity.class.getDeclaredMethod("toString").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(3)
    @DisplayName("Sanity - Interface implementation")
    void checkInterfaceImplementation() {
        assertTrue(Cloneable.class.isAssignableFrom(Activity.class));
    }

    @Test
    @Tag("sanity")
    @Order(4)
    @DisplayName("Sanity - Class definition")
    void checkAbstractClass() {
        assertTrue(Modifier.isAbstract(Activity.class.getModifiers()));
    }

}
