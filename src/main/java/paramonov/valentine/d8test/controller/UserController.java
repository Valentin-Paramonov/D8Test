package paramonov.valentine.d8test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import paramonov.valentine.d8test.bean.Book;
import paramonov.valentine.d8test.bean.User;
import paramonov.valentine.d8test.service.StorageService;

import javax.validation.Valid;
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
        modelAndView.addObject("newbook", new Book());

        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateUser(@Valid User user, BindingResult result, @Valid Book book, BindingResult bookResult) {
        if(result.hasErrors()) {
            return new ModelAndView("details-user");
        }

        if(!bookResult.hasErrors()) {
            user.getBooks().add(book);
        }

        if(userStorageService.update(user)) {
            ModelAndView modelAndView = new ModelAndView("list-users");
            modelAndView.addObject("users", userStorageService.getValues());
            return modelAndView;
        }

        return new ModelAndView("details-user");
    }
}
