package Booker.WebApplication.Repositories;

import Booker.WebApplication.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
