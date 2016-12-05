package com.amir.controllers;

import com.amir.entities.BlogUser;
import com.amir.repository.BlogUserRepository;
import com.amir.validator.BloggerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BlogUserRepository repo;

    @Autowired
    private BloggerValidator validator;

    @ModelAttribute("isUser")
    public boolean isUser(Authentication auth) {
        return auth != null &&
                auth.getAuthorities().contains(AuthorityUtils.createAuthorityList("ROLE_USER").get(0));
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/stats")
    public String stats() {
        return "stats";
    }

    @RequestMapping("/publish")
    public String publish() {
        return "publish";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/topic")
    public String topic() {
        return "topic";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addBlogger(Model model) {
        model.addAttribute("blogger", new BlogUser());
        System.out.println("*******************************");
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("blogger") BlogUser blogger, BindingResult bindingResult) {

        validator.validate(blogger, bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println();
            System.out.println("the project did not validate");
            System.out.println();
            return "register";
        } else {
            System.out.println();
            System.out.println("The project validated.");
            System.out.println();
        }
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        String encodedPassword = encoder.encode(blogger.getPassword());
        blogger.setPassword(encodedPassword);
        repo.save(blogger);
        Authentication auth = new UsernamePasswordAuthenticationToken(blogger, blogger.getPassword(),
                blogger.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "home";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new BloggerValidator());
    }
}
