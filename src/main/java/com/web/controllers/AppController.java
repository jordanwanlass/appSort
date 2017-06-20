package com.web.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by jordanwanlass on 6/3/17.
 */
@Controller
@RequestMapping("/")
public class AppController {
    @RequestMapping(value = { "/", "/exterior"}, method = RequestMethod.GET)
    public ModelAndView homePage(ModelMap model) {
        return new ModelAndView("exterior");
    }

    @RequestMapping(value = { "/dashboard"}, method = RequestMethod.GET)
    public ModelAndView dashboardPage(ModelMap model) {
        return new ModelAndView("dashboard");
    }


    @RequestMapping(value = { "/aboutUs"}, method = RequestMethod.GET)
    public ModelAndView productsPage(ModelMap model) {
        return new ModelAndView("aboutUs");
    }

    @RequestMapping(value = { "/contactUs"}, method = RequestMethod.GET)
    public ModelAndView contactUsPage(ModelMap model) {
        return new ModelAndView("contactUs");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            HttpSession session) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            session.invalidate();
            SecurityContextHolder.getContext().setAuthentication(null);
            model.addObject("timeout", "setTimeout(\"refreshPage()\", 60000)");
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;
    }

    @RequestMapping(value = {"/directOrder"}, method = RequestMethod.GET)
    public ModelAndView directOrder(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("directOrder");
        return modelAndView;
    }
}
