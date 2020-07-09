package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Contact;
import com.example.service.ContactService;

@Controller
public class ContactInfoController {
    @Autowired
	private ContactService service;
   
    @GetMapping(value = {"/addContact" })
    public  String loadForm(Model model) {
    	Contact c = new Contact();
    	model.addAttribute("contact", c);
    	return "contactInfo";
    }
    @RequestMapping(value = "/saveContact",method = RequestMethod.POST)
    public String handleSubmitButton( @ModelAttribute("contact") Contact c,Model model) {
    	boolean isSaved = service.saveContact(c);
    	if(isSaved) {
    		model.addAttribute("succMsg", "Conatct Saved");
    	}
    	else {
    		model.addAttribute("errMsg", "Failed to Save Contact");
    	}
    	return "contactInfo";
    }
    @GetMapping("/viewContacts")
    public String handleViewContactsLink(Model model) {
    	List<Contact> contactsList = service.getAllContacts();
    	model.addAttribute("contacts", contactsList);
    	return "viewContacts";
    }
    
    
}//class
