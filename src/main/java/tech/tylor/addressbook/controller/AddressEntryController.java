package tech.tylor.addressbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.tylor.addressbook.model.AddressEntry;
import tech.tylor.addressbook.repository.AddressEntryRepository;

@Controller
public class AddressEntryController {

    @Autowired
    private AddressEntryRepository addressEntryRepository;

    // index
    @GetMapping("/")
    public String index(AddressEntry addressEntry, Model model) {
        model.addAttribute("entries", addressEntryRepository.findAll());
        return "bookentry/index";
    }

    @PostMapping("/bookentries")
    public String addNewAddressEntry(AddressEntry addressEntry, Model model) {
        addressEntryRepository.save(addressEntry);
        model.addAttribute("firstName", addressEntry.getFirstName());
        model.addAttribute("lastName", addressEntry.getLastName());
        model.addAttribute("email", addressEntry.getEmail());
        model.addAttribute("phone", addressEntry.getPhone());
        return "bookentry/result";
    }

    // add
    @GetMapping(value = "/bookentries/new")
    public String newAddress (AddressEntry addressEntry) {
        return "bookentry/new";
    }

    // delete
    @RequestMapping("/bookentry/delete/{id}")
    public String deleteAddressById(@PathVariable Long id, AddressEntry addressEntry) {
        addressEntryRepository.deleteById(id);
        return "bookentry/delete";
    }



}
