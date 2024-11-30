package edu.uoc.pac4.university;

import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversityTest {

    @Test
    @Tag("sanity")
    @Order(1)
    @DisplayName("Sanity - Fields definition")
    public void checkFieldsSanity() {
        assertEquals(5, University.class.getDeclaredFields().length);

        try {
            assertTrue(Modifier.isPrivate(University.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredField("name").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredField("name").getModifiers()));
            assertEquals(String.class, University.class.getDeclaredField("name").getType());

            assertTrue(Modifier.isPrivate(University.class.getDeclaredField("abbreviation").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredField("abbreviation").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredField("abbreviation").getModifiers()));
            assertEquals(String.class, University.class.getDeclaredField("abbreviation").getType());

            assertTrue(Modifier.isPrivate(University.class.getDeclaredField("foundationDate").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredField("foundationDate").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredField("foundationDate").getModifiers()));
            assertEquals(LocalDate.class, University.class.getDeclaredField("foundationDate").getType());

            assertTrue(Modifier.isPrivate(University.class.getDeclaredField("address").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredField("address").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredField("address").getModifiers()));
            assertEquals(String.class, University.class.getDeclaredField("address").getType());

            assertTrue(Modifier.isPrivate(University.class.getDeclaredField("website").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredField("website").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredField("website").getModifiers()));
            assertEquals(String.class, University.class.getDeclaredField("website").getType());
        } catch (NoSuchFieldException e) {
            fail("[ERROR] There is some problem with the definition of the attributes: " + e.getMessage());
        }
    }

    @Test
    @Tag("sanity")
    @Order(2)
    @DisplayName("Sanity - Methods definition")
    void checkMethodsSanity() {
        assertEquals(1, University.class.getDeclaredConstructors().length);
        assertEquals(11, Arrays.stream(University.class.getDeclaredMethods()).filter(m -> Modifier.isPublic(m.getModifiers())).toList().size());

        try {
            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("getName").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("getName").getModifiers()));
            assertEquals(String.class, University.class.getDeclaredMethod("getName").getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("setName", String.class).getModifiers()));
            assertEquals(void.class, University.class.getDeclaredMethod("setName", String.class).getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("getAbbreviation").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("getAbbreviation").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("getAbbreviation").getModifiers()));
            assertEquals(String.class, University.class.getDeclaredMethod("getAbbreviation").getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("setAbbreviation", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("setAbbreviation", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("setAbbreviation", String.class).getModifiers()));
            assertEquals(void.class, University.class.getDeclaredMethod("setAbbreviation", String.class).getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("getFoundationDate").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("getFoundationDate").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("getFoundationDate").getModifiers()));
            assertEquals(LocalDate.class, University.class.getDeclaredMethod("getFoundationDate").getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("setFoundationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("setFoundationDate", LocalDate.class).getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("setFoundationDate", LocalDate.class).getModifiers()));
            assertEquals(void.class, University.class.getDeclaredMethod("setFoundationDate", LocalDate.class).getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("getAddress").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("getAddress").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("getAddress").getModifiers()));
            assertEquals(String.class, University.class.getDeclaredMethod("getAddress").getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("setAddress", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("setAddress", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("setAddress", String.class).getModifiers()));
            assertEquals(void.class, University.class.getDeclaredMethod("setAddress", String.class).getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("getWebsite").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("getWebsite").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("getWebsite").getModifiers()));
            assertEquals(String.class, University.class.getDeclaredMethod("getWebsite").getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("setWebsite", String.class).getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("setWebsite", String.class).getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("setWebsite", String.class).getModifiers()));
            assertEquals(void.class, University.class.getDeclaredMethod("setWebsite", String.class).getReturnType());

            assertTrue(Modifier.isPublic(University.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isStatic(University.class.getDeclaredMethod("toString").getModifiers()));
            assertFalse(Modifier.isFinal(University.class.getDeclaredMethod("toString").getModifiers()));
            assertEquals(String.class, University.class.getDeclaredMethod("toString").getReturnType());
        } catch (Exception e) {
            fail("[ERROR] There is some problem with the definition of the methods: " + e.getMessage());
        }
    }

    @Test
    @Tag("minimum")
    @Order(3)
    @DisplayName("Minimum - Valid parameters")
    void testUniversityCreationValidParameters() throws UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu");
        assertEquals("Universitat Oberta de Catalunya", university.getName());
        assertEquals("UOC", university.getAbbreviation());
        assertEquals(LocalDate.of(1994, 10, 6), university.getFoundationDate());
        assertEquals("Av. Tibidabo, 39-43", university.getAddress());
        assertEquals("https://www.uoc.edu", university.getWebsite());

        university = new University("Virtual University", "VU", LocalDate.of(2020, 1, 1), "Wirtland", "https://www.virtualuniversity.wirtland");
        assertEquals("Virtual University", university.getName());
        assertEquals("VU", university.getAbbreviation());
        assertEquals(LocalDate.of(2020, 1, 1), university.getFoundationDate());
        assertEquals("Wirtland", university.getAddress());
        assertEquals("https://www.virtualuniversity.wirtland", university.getWebsite());
    }

    @Test
    @Tag("minimum")
    @Order(4)
    @DisplayName("Minimum - Name")
    void testUniversityCreationName() throws UniversityException {
        UniversityException exception = assertThrows(UniversityException.class, () -> new University(null, "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertEquals("[ERROR] Name cannot be null, empty or blank", exception.getMessage());

        assertThrows(UniversityException.class, () -> new University("", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertThrows(UniversityException.class, () -> new University(" ", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));

        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu");
        assertEquals("Universitat Oberta de Catalunya", university.getName());

        university.setName("Virtual University");
        assertEquals("Virtual University", university.getName());

        university.setName(" NEW ");
        assertEquals("NEW", university.getName());

        university.setName("Everything, even spaces, numbers and specials characters like !@#$%^&*()_+{}[]|\\:;\"'<>,.?/");
        assertEquals("Everything, even spaces, numbers and specials characters like !@#$%^&*()_+{}[]|\\:;\"'<>,.?/", university.getName());

        assertThrows(UniversityException.class, () -> university.setName(null));
        assertThrows(UniversityException.class, () -> university.setName(""));
        assertThrows(UniversityException.class, () -> university.setName(" "));

        assertEquals("Everything, even spaces, numbers and specials characters like !@#$%^&*()_+{}[]|\\:;\"'<>,.?/", university.getName());
    }

    @Test
    @Tag("minimum")
    @Order(5)
    @DisplayName("Minimum - Abbreviation")
    void testUniversityCreationAbbreviation() throws UniversityException {
        UniversityException exception =  assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", null, LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertEquals("[ERROR] Abbreviation has to contain between 2 and 6 uppercase letters", exception.getMessage());

        assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", "", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", " ", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", "U", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", "   ", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", "12", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", "/()", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", "ABCDEFG", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));

        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu");
        assertEquals("UOC", university.getAbbreviation());

        university.setAbbreviation("VU");
        assertEquals("VU", university.getAbbreviation());

        university.setAbbreviation("NEW");
        assertEquals("NEW", university.getAbbreviation());

        university.setAbbreviation("ABCDEF");
        assertEquals("ABCDEF", university.getAbbreviation());

        assertThrows(UniversityException.class, () -> university.setAbbreviation(null));
        assertThrows(UniversityException.class, () -> university.setAbbreviation(""));
        assertThrows(UniversityException.class, () -> university.setAbbreviation(" "));
        assertThrows(UniversityException.class, () -> university.setAbbreviation("12"));
        assertThrows(UniversityException.class, () -> university.setAbbreviation("   "));
        assertThrows(UniversityException.class, () -> university.setAbbreviation("/()"));
        assertThrows(UniversityException.class, () -> university.setAbbreviation("ABCDEFGH"));

        assertEquals("ABCDEF", university.getAbbreviation());
    }

    @Test
    @Tag("minimum")
    @Order(6)
    @DisplayName("Minimum - Foundation date")
    void testUniversityCreationFoundationDate() throws UniversityException {
        UniversityException exception = assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", "UOC", null, "Av. Tibidabo, 39-43", "https://www.uoc.edu"));
        assertEquals("[ERROR] Foundation date cannot be null or in the future", exception.getMessage());

        assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", "UOC", LocalDate.now().plusDays(1), "Av. Tibidabo, 39-43", "https://www.uoc.edu"));

        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu");
        assertEquals(LocalDate.of(1994, 10, 6), university.getFoundationDate());

        University university2 = new University("Virtual University", "VU", LocalDate.now().minusDays(1), "Wirtland", "https://www.virtualuniversity.wirtland");
        assertEquals(LocalDate.now().minusDays(1), university2.getFoundationDate());

        university2 = new University("Virtual University", "VU", LocalDate.now(), "Wirtland", "https://www.virtualuniversity.wirtland");
        assertEquals(LocalDate.now(), university2.getFoundationDate());

        university.setFoundationDate(LocalDate.of(2020, 1, 1));
        assertEquals(LocalDate.of(2020, 1, 1), university.getFoundationDate());

        university.setFoundationDate(LocalDate.of(2021, 12, 31));
        assertEquals(LocalDate.of(2021, 12, 31), university.getFoundationDate());

        university.setFoundationDate(LocalDate.now().minusDays(1));
        assertEquals(LocalDate.now().minusDays(1), university.getFoundationDate());

        university.setFoundationDate(LocalDate.now());
        assertEquals(LocalDate.now(), university.getFoundationDate());

        assertThrows(UniversityException.class, () -> university.setFoundationDate(null));
        assertThrows(UniversityException.class, () -> university.setFoundationDate(LocalDate.now().plusDays(1)));

        assertEquals(LocalDate.now(), university.getFoundationDate());
    }

    @Test
    @Tag("minimum")
    @Order(7)
    @DisplayName("Minimum - Address")
    void testUniversityCreationAddress() throws UniversityException {
        UniversityException exception = assertThrows(UniversityException.class, () -> new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), null, "https://www.uoc.edu"));
        assertEquals("[ERROR] Address cannot be null", exception.getMessage());

        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu");
        assertEquals("Av. Tibidabo, 39-43", university.getAddress());

        University university1 = new University("Virtual University", "VU", LocalDate.now().minusDays(1), "", "https://www.virtualuniversity.wirtland");
        assertEquals("", university1.getAddress());

        University university2 = new University("Virtual University", "VU", LocalDate.now().minusDays(1), "  ", "https://www.virtualuniversity.wirtland");
        assertEquals("", university2.getAddress());

        university.setAddress("Wirtland");
        assertEquals("Wirtland", university.getAddress());

        university.setAddress(" N E W ");
        assertEquals("N E W", university.getAddress());

        university.setAddress("Everything, even spaces, numbers and specials characters like !@#$%^&*()_+{}[]|\\:;\"'<>,.?/");
        assertEquals("Everything, even spaces, numbers and specials characters like !@#$%^&*()_+{}[]|\\:;\"'<>,.?/", university.getAddress());

        assertThrows(UniversityException.class, () -> university.setAddress(null));

        assertEquals("Everything, even spaces, numbers and specials characters like !@#$%^&*()_+{}[]|\\:;\"'<>,.?/", university.getAddress());
    }

    @Test
    @Tag("minimum")
    @Order(8)
    @DisplayName("Minimum - Website")
    void testUniversityCreationWebsite() throws UniversityException {
        University university = new University("Universitat Oberta de Catalunya", "UOC", LocalDate.of(1994, 10, 6), "Av. Tibidabo, 39-43", "https://www.uoc.edu");
        assertEquals("https://www.uoc.edu", university.getWebsite());

        university.setWebsite("http://example.com");
        assertEquals("http://example.com", university.getWebsite());

        university.setWebsite("https://sub.domain.example.com/path/to/resource");
        assertEquals("https://sub.domain.example.com/path/to/resource", university.getWebsite());

        university.setWebsite("http://example.org");
        assertEquals("http://example.org", university.getWebsite());

        university.setWebsite("https://my-site.co.uk");
        assertEquals("https://my-site.co.uk", university.getWebsite());

        university.setWebsite("https://validwebsite.io/path");
        assertEquals("https://validwebsite.io/path", university.getWebsite());

        UniversityException exception = assertThrows(UniversityException.class, () -> university.setWebsite(null));
        assertEquals("[ERROR] Website cannot be null and must be a valid URL", exception.getMessage());

        assertThrows(UniversityException.class, () -> university.setWebsite("invalid-website"));
        assertThrows(UniversityException.class, () -> university.setWebsite("http//missing-colon.com"));
        assertThrows(UniversityException.class, () -> university.setWebsite("htp://typo-in-protocol.com"));
        assertThrows(UniversityException.class, () -> university.setWebsite("://missing-protocol.com"));
        assertThrows(UniversityException.class, () -> university.setWebsite("http://.com"));
        assertThrows(UniversityException.class, () -> university.setWebsite("http://domain-without-tld"));
        assertThrows(UniversityException.class, () -> university.setWebsite("https:/one-slash.com"));
        assertThrows(UniversityException.class, () -> university.setWebsite("ftp://not-http.com"));

        assertEquals("https://validwebsite.io/path", university.getWebsite());
    }

}
