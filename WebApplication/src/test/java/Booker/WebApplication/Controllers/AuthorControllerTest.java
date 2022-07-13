package Booker.WebApplication.Controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import Booker.WebApplication.Model.Author;
import Booker.WebApplication.Repositories.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@ContextConfiguration(classes = {AuthorController.class})
@ExtendWith(SpringExtension.class)
class AuthorControllerTest {
    @Autowired
    private AuthorController authorController;

    @MockBean
    private AuthorRepository authorRepository;


    @Test
    void testGetAuthors() throws Exception {
        when(authorRepository.findAll()).thenReturn((Iterable<Author>) mock(Iterable.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/authors");
        MockMvcBuilders.standaloneSetup(authorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("authors"))
                .andExpect(MockMvcResultMatchers.view().name("authors/list"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("authors/list"));
    }

}

