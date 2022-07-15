package Booker.WebApplication.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class BookTest {



    @Test
    void testConstructor2() {
        Book actualBook = new Book("Dr", "Isbn");
        HashSet<Author> authorSet = new HashSet<>();
        actualBook.setAuthors(authorSet);
        actualBook.setId(123L);
        actualBook.setIsbn("Isbn");
        Publisher publisher = new Publisher();
        publisher.setAddressLine("42 Main St");
        publisher.setBooks(new HashSet<>());
        publisher.setCity("Oxford");
        publisher.setId(123L);
        publisher.setName("Name");
        publisher.setState("MD");
        publisher.setZip("21654");
        actualBook.setPublisher(publisher);
        actualBook.setTitle("Dr");
        String actualToStringResult = actualBook.toString();
        assertSame(authorSet, actualBook.getAuthors());
        assertEquals(123L, actualBook.getId().longValue());
        assertEquals("Isbn", actualBook.getIsbn());
        assertSame(publisher, actualBook.getPublisher());
        assertEquals("Dr", actualBook.getTitle());
        assertEquals("Book{id=123, title='Dr', isbn='Isbn'}", actualToStringResult);
    }



    @Test
    void testEquals() {
        Publisher publisher = new Publisher();
        publisher.setAddressLine("42 Main St");
        publisher.setBooks(new HashSet<>());
        publisher.setCity("Oxford");
        publisher.setId(123L);
        publisher.setName("Name");
        publisher.setState("MD");
        publisher.setZip("21654");

        Book book = new Book();
        book.setAuthors(new HashSet<>());
        book.setId(123L);
        book.setIsbn("Isbn");
        book.setPublisher(publisher);
        book.setTitle("Dr");

        Publisher publisher1 = new Publisher();
        publisher1.setAddressLine("42 Main St");
        publisher1.setBooks(new HashSet<>());
        publisher1.setCity("Oxford");
        publisher1.setId(123L);
        publisher1.setName("Name");
        publisher1.setState("MD");
        publisher1.setZip("21654");

        Book book1 = new Book();
        book1.setAuthors(new HashSet<>());
        book1.setId(123L);
        book1.setIsbn("Isbn");
        book1.setPublisher(publisher1);
        book1.setTitle("Dr");
        assertEquals(book, book1);
        int expectedHashCodeResult = book.hashCode();
        assertEquals(expectedHashCodeResult, book1.hashCode());
    }


}

