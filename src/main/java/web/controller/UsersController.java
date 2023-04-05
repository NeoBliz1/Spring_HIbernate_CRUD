package web.controller;

import hibernate.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.service.UserWebServiceImpl;


@Controller
@Slf4j
public class UsersController {

    private final UserWebServiceImpl innerUserWebServiceImpl;

    @Autowired
    public UsersController(UserWebServiceImpl userWebServiceImpl) {
        innerUserWebServiceImpl = userWebServiceImpl;
    }

    @GetMapping("/")
    public String printUsers(ModelMap model, RedirectAttributes redirectAttributes) {
        model.addAttribute("usersList", innerUserWebServiceImpl.getUsersListForWeb());
        log.info("UsersController: Users printed");
        if (redirectAttributes.getFlashAttributes().containsKey("userRemoveErrMsg")) {
            String userRemoveErrMsg = (String) model.getAttribute("userRemoveErrMsg");
            model.addAttribute("userRemoveErrMsg", userRemoveErrMsg);
            log.info("UsersController: Model addAttribute added");
        }
        return "index";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("user") User formUser) {
        log.info(formUser.getFirstName());
        log.info(formUser.getLastName());
        log.info(formUser.getEmail());
        innerUserWebServiceImpl.addUserToDatabase(formUser);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeUserById(@PathVariable long id, RedirectAttributes redirectAttributes) {
        log.info("UsersController: UsersController: User removing process started");
        try {
            innerUserWebServiceImpl.removeUserById(id);
        } catch (IllegalArgumentException exception) {
            log.info("UsersController: UsersController: IllegalArgumentException thrown");
            redirectAttributes.addFlashAttribute("userRemoveErrMsg", "User with id " + id + " does not exist");
        }
        return "redirect:/";
    }

    @PostMapping("/updateUserData")
    public String editUserData(@RequestBody User fetchUserData) {
        log.info("UsersController: Data start fetched");
        log.info("UsersController: Request body: " + fetchUserData);
        log.info(String.valueOf(fetchUserData.getId()));
        log.info(fetchUserData.getFirstName());
        log.info(fetchUserData.getLastName());
        log.info(fetchUserData.getEmail());
        innerUserWebServiceImpl.editUserData(fetchUserData);
        log.info("UsersController: Data fetched");
        return "redirect:/";
    }
}