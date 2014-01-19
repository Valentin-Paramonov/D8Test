package paramonov.valentine.d8test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import paramonov.valentine.d8test.beans.Book;
import paramonov.valentine.d8test.beans.User;
import paramonov.valentine.d8test.service.StorageService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private StorageService<User> userStorageService;

    @Autowired
    UserController(StorageService<User> userService) {
        this.userStorageService = userService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listUser() {
        ModelAndView modelAndView = new ModelAndView("list-users");

        modelAndView.addObject("users", userStorageService.getValues());

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView("add-user");

        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("add-user");
        }

        if(userStorageService.add(user)) {
            ModelAndView modelAndView = new ModelAndView("list-users");
            modelAndView.addObject("users", userStorageService.getValues());
            return modelAndView;
        }

        return new ModelAndView("add-user");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteUser(User user) {
        ModelAndView modelAndView = new ModelAndView("list-users");

        userStorageService.delete(user.getId());
        modelAndView.addObject("users", userStorageService.getValues());

        return modelAndView;
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public ModelAndView detailsUser(User user) {
        ModelAndView modelAndView = new ModelAndView("details-user");

        User editUser = userStorageService.get(user.getId());
        modelAndView.addObject("user", editUser);
        modelAndView.addObject("booksSize", editUser.getBooks().size());
        modelAndView.addObject("newBook", new Book());

        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateUser(@Valid User user, BindingResult result) {
        ModelAndView modelAndView;

        Book book = new Book();
        int bookSize = user.getBooks().size();

        if(result.hasErrors()) {
            modelAndView =  new ModelAndView("details-user");

            modelAndView.addObject("newBook", book);
            modelAndView.addObject("booksSize", bookSize);

            return modelAndView;
        }

        if(userStorageService.update(user)) {
            modelAndView = new ModelAndView("list-users");

            modelAndView.addObject("users", userStorageService.getValues());
            modelAndView.addObject("newBook", new Book());

            return modelAndView;
        }

        modelAndView =  new ModelAndView("details-user");

        modelAndView.addObject("newBook", book);
        modelAndView.addObject("booksSize", bookSize);

        return modelAndView;
    }

    @RequestMapping(value="/{userID}/book/delete/{bookId}", method=RequestMethod.POST)
    public ModelAndView deleteBook(@PathVariable("userID") long userId, @PathVariable("bookId") int bookId) {
        ModelAndView modelAndView = new ModelAndView("details-user");

        final User user = userStorageService.get(userId);
        final List<Book> books = user.getBooks();

        try {
            books.remove(bookId);
        } catch(IndexOutOfBoundsException ioobe) {
            // Can you keep a secret?
        }

        modelAndView.addObject("user", user);
        modelAndView.addObject("booksSize", books.size());
        modelAndView.addObject("newBook", new Book());

        return modelAndView;
    }

    @RequestMapping(value="/{userID}/book/add", method=RequestMethod.POST)
    public ModelAndView addBook(@PathVariable("userID") long userId, @Valid @ModelAttribute("newBook") Book book, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("details-user");

        final User user = userStorageService.get(userId);
        final List<Book> books = user.getBooks();

        if(!result.hasErrors()) {
            books.add(book);
        }

        modelAndView.addObject("user", user);
        modelAndView.addObject("booksSize", books.size());
        modelAndView.addObject("newBook", book);

        return modelAndView;
    }
}
