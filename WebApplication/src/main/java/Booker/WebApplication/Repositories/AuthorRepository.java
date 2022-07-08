package Booker.WebApplication.Repositories;

import Booker.WebApplication.Model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
