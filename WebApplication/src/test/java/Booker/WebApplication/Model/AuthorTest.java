package Booker.WebApplication.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class AuthorTest {

    @Test
    void testConstructor() {
        Author actualAuthor = new Author();
        HashSet<Book> bookSet = new HashSet<>();
        actualAuthor.setBooks(bookSet);
        actualAuthor.setFirstName("Jane");
        actualAuthor.setId(123L);
        actualAuthor.setLastName("Doe");
        String actualToStringResult = actualAuthor.toString();
        assertSame(bookSet, actualAuthor.getBooks());
        assertEquals("Jane", actualAuthor.getFirstName());
        assertEquals(123L, actualAuthor.getId().longValue());
        assertEquals("Doe", actualAuthor.getLastName());
        assertEquals("Author{id=123, firstName='Jane', lastName='Doe'}", actualToStringResult);
    }


    @Test
    void testConstructor2() {
        Author actualAuthor = new Author("Jane", "Doe");
        HashSet<Book> bookSet = new HashSet<>();
        actualAuthor.setBooks(bookSet);
        actualAuthor.setFirstName("Jane");
        actualAuthor.setId(123L);
        actualAuthor.setLastName("Doe");
        String actualToStringResult = actualAuthor.toString();
        assertSame(bookSet, actualAuthor.getBooks());
        assertEquals("Jane", actualAuthor.getFirstName());
        assertEquals(123L, actualAuthor.getId().longValue());
        assertEquals("Doe", actualAuthor.getLastName());
        assertEquals("Author{id=123, firstName='Jane', lastName='Doe'}", actualToStringResult);
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals() {
        Author author = new Author();
        author.setBooks(new HashSet<>());
        author.setFirstName("Jane");
        author.setId(123L);
        author.setLastName("Doe");
        assertNotEquals(author, null);
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals2() {
        Author author = new Author();
        author.setBooks(new HashSet<>());
        author.setFirstName("Jane");
        author.setId(123L);
        author.setLastName("Doe");
        assertNotEquals(author, "Different type to Author");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Author#equals(Object)}
     *   <li>{@link Author#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Author author = new Author();
        author.setBooks(new HashSet<>());
        author.setFirstName("Jane");
        author.setId(123L);
        author.setLastName("Doe");
        assertEquals(author, author);
        int expectedHashCodeResult = author.hashCode();
        assertEquals(expectedHashCodeResult, author.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Author#equals(Object)}
     *   <li>{@link Author#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Author author = new Author();
        author.setBooks(new HashSet<>());
        author.setFirstName("Jane");
        author.setId(123L);
        author.setLastName("Doe");

        Author author1 = new Author();
        author1.setBooks(new HashSet<>());
        author1.setFirstName("Jane");
        author1.setId(123L);
        author1.setLastName("Doe");
        assertEquals(author, author1);
        int expectedHashCodeResult = author.hashCode();
        assertEquals(expectedHashCodeResult, author1.hashCode());
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals5() {
        Author author = new Author();
        author.setBooks(new HashSet<>());
        author.setFirstName("Jane");
        author.setId(1L);
        author.setLastName("Doe");

        Author author1 = new Author();
        author1.setBooks(new HashSet<>());
        author1.setFirstName("Jane");
        author1.setId(123L);
        author1.setLastName("Doe");
        assertNotEquals(author, author1);
    }

    /**
     * Method under test: {@link Author#equals(Object)}
     */
    @Test
    void testEquals6() {
        Author author = new Author();
        author.setBooks(new HashSet<>());
        author.setFirstName("Jane");
        author.setId(null);
        author.setLastName("Doe");

        Author author1 = new Author();
        author1.setBooks(new HashSet<>());
        author1.setFirstName("Jane");
        author1.setId(123L);
        author1.setLastName("Doe");
        assertNotEquals(author, author1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Author#equals(Object)}
     *   <li>{@link Author#hashCode()}
     * </ul>
     */
    @Test
    void testEquals7() {
        Author author = new Author();
        author.setBooks(new HashSet<>());
        author.setFirstName("Jane");
        author.setId(null);
        author.setLastName("Doe");

        Author author1 = new Author();
        author1.setBooks(new HashSet<>());
        author1.setFirstName("Jane");
        author1.setId(null);
        author1.setLastName("Doe");
        assertEquals(author, author1);
        int expectedHashCodeResult = author.hashCode();
        assertEquals(expectedHashCodeResult, author1.hashCode());
    }
}

