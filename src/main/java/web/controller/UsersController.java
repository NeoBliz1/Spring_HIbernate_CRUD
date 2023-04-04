package web.controller;

import hibernate.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.UserWebServiceImpl;


@Controller
public class UsersController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserWebServiceImpl.class);

	private final UserWebServiceImpl innerUserWebServiceImpl;
	@Autowired
	public UsersController(UserWebServiceImpl userWebServiceImpl) {
		innerUserWebServiceImpl = userWebServiceImpl;
	}
    
    @GetMapping("/")
    public String printUsers(ModelMap model) {
        model.addAttribute("usersList", innerUserWebServiceImpl.getUsersListForWeb());
        LOGGER.info("Users printed");
        return "index";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("user") User formUser){
        LOGGER.info(String.valueOf(formUser.getFirstName()));
        LOGGER.info(String.valueOf(formUser.getLastName()));
        LOGGER.info(String.valueOf(formUser.getEmail()));
        innerUserWebServiceImpl.addUserToDatabase(formUser);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeUserById(@PathVariable long id) {
        innerUserWebServiceImpl.removeUserById(id);
        return "redirect:/";
    }

    @PostMapping("/updateUserData")
    public String editUserData(@RequestBody User fetchUserData) {
        LOGGER.info("Data start fetched");
        LOGGER.info("Request body: " + fetchUserData);
        LOGGER.info(String.valueOf(fetchUserData.getId()));
        LOGGER.info(String.valueOf(fetchUserData.getFirstName()));
        LOGGER.info(String.valueOf(fetchUserData.getLastName()));
        LOGGER.info(String.valueOf(fetchUserData.getEmail()));
        innerUserWebServiceImpl.editUserData(fetchUserData);
        LOGGER.info("Data fetched");
        return "redirect:/";
    }
}