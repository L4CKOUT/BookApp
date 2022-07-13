package Booker.WebApplication.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PublisherTest {

    @Test
    void testConstructor() {
        Publisher actualPublisher = new Publisher();
        actualPublisher.setAddressLine("42 Main St");
        HashSet<Book> bookSet = new HashSet<>();
        actualPublisher.setBooks(bookSet);
        actualPublisher.setCity("Oxford");
        actualPublisher.setId(123L);
        actualPublisher.setName("Name");
        actualPublisher.setState("MD");
        actualPublisher.setZip("21654");
        String actualToStringResult = actualPublisher.toString();
        assertEquals("42 Main St", actualPublisher.getAddressLine());
        assertSame(bookSet, actualPublisher.getBooks());
        assertEquals("Oxford", actualPublisher.getCity());
        assertEquals(123L, actualPublisher.getId().longValue());
        assertEquals("Name", actualPublisher.getName());
        assertEquals("MD", actualPublisher.getState());
        assertEquals("21654", actualPublisher.getZip());
        assertEquals("Publisher{id=123, name='Name', addressLine='42 Main St', city='Oxford', state='MD', zip='21654'}",
                actualToStringResult);
    }


    @Test
    void testEquals() {
        Publisher publisher = new Publisher();
        publisher.setAddressLine("42 Main St");
        publisher.setBooks(new HashSet<>());
        publisher.setCity("Oxford");
        publisher.setId(1L);
        publisher.setName("Name");
        publisher.setState("MD");
        publisher.setZip("21654");

        Publisher publisher1 = new Publisher();
        publisher1.setAddressLine("42 Main St");
        publisher1.setBooks(new HashSet<>());
        publisher1.setCity("Oxford");
        publisher1.setId(123L);
        publisher1.setName("Name");
        publisher1.setState("MD");
        publisher1.setZip("21654");
        assertNotEquals(publisher, publisher1);
    }

}

