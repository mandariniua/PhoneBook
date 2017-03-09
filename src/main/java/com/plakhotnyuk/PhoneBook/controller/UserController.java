package com.plakhotnyuk.PhoneBook.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.plakhotnyuk.PhoneBook.bean.User;
import com.plakhotnyuk.PhoneBook.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
    UserService userService;
	
	@RequestMapping(value = "/signup")
    public ModelAndView createForm() {
    	ModelAndView mav = new ModelAndView("user/registration");
    	mav.addObject("user", new User());
        return mav;
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, BindingResult result) {
    	System.out.println("saontehusnaoehusntoeahustnoeahusntoeahusntoheantuhoentuhoneahutn-----------");
        if (result.hasErrors()) {
            return "user/registration";
        }
        userService.saveUser(user);
        return "redirect:/user/" + user.getUsername();
    }
	
	@RequestMapping(value = "/{userId}")
    public String getUserProfile(@PathVariable String userId, Map<String, Object> model) {
        User user = userService.findByUsername(userId);
        model.put("user", user);
        return "user/view";
    }

}
