package Booker.WebApplication.Bootstrap;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import Booker.WebApplication.Model.Author;
import Booker.WebApplication.Model.Book;
import Booker.WebApplication.Model.Publisher;
import Booker.WebApplication.Repositories.AuthorRepository;
import Booker.WebApplication.Repositories.BookRepository;
import Booker.WebApplication.Repositories.PublisherRepository;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BootstrapData.class})
@ExtendWith(SpringExtension.class)
class BootstrapDataTest {
    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BootstrapData bootstrapData;

    @MockBean
    private PublisherRepository publisherRepository;


    @Test
    void testRun() throws Exception {
        Author author = new Author();
        author.setBooks(new HashSet<>());
        author.setFirstName("Jane");
        author.setId(123L);
        author.setLastName("Doe");
        when(authorRepository.save((Author) any())).thenReturn(author);
        when(authorRepository.count()).thenReturn(3L);

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
        when(bookRepository.save((Book) any())).thenReturn(book);
        when(bookRepository.count()).thenReturn(3L);

        Publisher publisher1 = new Publisher();
        publisher1.setAddressLine("42 Main St");
        publisher1.setBooks(new HashSet<>());
        publisher1.setCity("Oxford");
        publisher1.setId(123L);
        publisher1.setName("Name");
        publisher1.setState("MD");
        publisher1.setZip("21654");
        when(publisherRepository.save((Publisher) any())).thenReturn(publisher1);
        when(publisherRepository.count()).thenReturn(3L);
        bootstrapData.run("Args");
    }
}

