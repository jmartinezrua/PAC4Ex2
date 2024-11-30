package edu.uoc.pac4;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DSLabStatusTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    void checkFieldsSanity() {
        assertEquals(5, DSLabStatus.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPublic(DSLabStatus.class.getDeclaredField("ACTIVE").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabStatus.class.getDeclaredField("ACTIVE").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabStatus.class.getDeclaredField("ACTIVE").getModifiers()));
            assertEquals(DSLabStatus.class, DSLabStatus.class.getDeclaredField("ACTIVE").getType());

            assertTrue(Modifier.isPublic(DSLabStatus.class.getDeclaredField("INACTIVE").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabStatus.class.getDeclaredField("INACTIVE").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabStatus.class.getDeclaredField("INACTIVE").getModifiers()));
            assertEquals(DSLabStatus.class, DSLabStatus.class.getDeclaredField("INACTIVE").getType());

            assertTrue(Modifier.isPublic(DSLabStatus.class.getDeclaredField("MAINTENANCE").getModifiers()));
            assertTrue(Modifier.isStatic(DSLabStatus.class.getDeclaredField("MAINTENANCE").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabStatus.class.getDeclaredField("MAINTENANCE").getModifiers()));
            assertEquals(DSLabStatus.class, DSLabStatus.class.getDeclaredField("MAINTENANCE").getType());

            assertTrue(Modifier.isPrivate(DSLabStatus.class.getDeclaredField("status").getModifiers()));
            assertFalse(Modifier.isStatic(DSLabStatus.class.getDeclaredField("status").getModifiers()));
            assertTrue(Modifier.isFinal(DSLabStatus.class.getDeclaredField("status").getModifiers()));
            assertEquals(String.class, DSLabStatus.class.getDeclaredField("status").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, DSLabStatus.class.getDeclaredConstructors().length);
        assertEquals(4, Arrays.stream(DSLabStatus.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(DSLabStatus.class.getDeclaredMethod("getStatus").getModifiers()));
            assertFalse(Modifier.isStatic(DSLabStatus.class.getDeclaredMethod("getStatus").getModifiers()));
            assertFalse(Modifier.isFinal(DSLabStatus.class.getDeclaredMethod("getStatus").getModifiers()));
            assertEquals(String.class, DSLabStatus.class.getDeclaredMethod("getStatus").getReturnType());

            assertTrue(Modifier.isPublic(DSLabStatus.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(DSLabStatus.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(DSLabStatus.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, DSLabStatus.class.getDeclaredMethod("toString").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("minimum")
    @Order(3)
    @DisplayName("Minimum - Status")
    void testDSLabStatusStatus() {
        assertEquals("Active", DSLabStatus.ACTIVE.getStatus());
        assertEquals("Inactive", DSLabStatus.INACTIVE.getStatus());
        assertEquals("Maintenance", DSLabStatus.MAINTENANCE.getStatus());
    }

}
