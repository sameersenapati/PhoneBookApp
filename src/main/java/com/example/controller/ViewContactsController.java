package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Contact;
import com.example.service.ContactService;

@Controller
public class ViewContactsController {
	@Autowired
	private ContactService service;

	@RequestMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId,Model model) {
	Contact c = service.getContactById(contactId);
	model.addAttribute("contact", c);
		return "contactInfo";
	}

	public String updateContact() {
		return null;
	}
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {
		boolean isDeleted = service.deleteContact(contactId);
		if(isDeleted) {
			return "redirect:/viewContacts";
		}
		return "";
	}
}
