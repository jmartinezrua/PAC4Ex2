package edu.uoc.pac4.activity;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EvaluableTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Methods definition")
    void checkMethods() {
        assertEquals(1, Evaluable.class.getDeclaredMethods().length);

        final Class<Evaluable> ownClass = Evaluable.class;

        try {
            assertTrue(Modifier.isPublic(ownClass.getDeclaredMethod("getWeight").getModifiers()));
            assertTrue(Modifier.isAbstract(ownClass.getDeclaredMethod("getWeight").getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("[ERROR] There is some problem with the definition of methods: " + e.getMessage());
        }
    }

}
