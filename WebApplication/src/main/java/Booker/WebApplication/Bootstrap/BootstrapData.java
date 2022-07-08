package Booker.WebApplication.Bootstrap;

import Booker.WebApplication.Model.Author;
import Booker.WebApplication.Model.Book;
import Booker.WebApplication.Model.Publisher;
import Booker.WebApplication.Repositories.AuthorRepository;
import Booker.WebApplication.Repositories.BookRepository;
import Booker.WebApplication.Repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setCity("UK");
        publisher.setState("London");

        publisherRepository.save(publisher);

        Author junji = new Author("Junji","Ito");
        Book tomie = new Book("Tomie","123123" );
        junji.getBooks().add(tomie);
        tomie.getAuthors().add(junji);

        tomie.setPublisher(publisher);
        publisher.getBooks().add(tomie);

        authorRepository.save(junji);
        bookRepository.save(tomie);
        publisherRepository.save(publisher);

        Author will = new Author("William", "Golding");
        Book lord = new Book("Lord of the Flies", "321321");
        will.getBooks().add(lord);
        lord.getAuthors().add(will);

        lord.setPublisher(publisher);
        publisher.getBooks().add(lord);

        authorRepository.save(will);
        bookRepository.save(lord);
        publisherRepository.save(publisher);

        System.out.println("--------------------------");
        System.out.println("BOOTSTRAP");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of publisher books: " + publisher.getBooks().size());
        System.out.println("--------------------------");
    }
}
