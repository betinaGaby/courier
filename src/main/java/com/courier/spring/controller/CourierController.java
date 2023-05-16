package com.courier.spring.controller;

import com.courier.spring.model.RegisterModel;
import com.courier.spring.repository.RegisterRepository;
import com.courier.spring.service.Implementation.RegisterImplementation;
import org.attoparser.prettyhtml.PrettyHtmlMarkupHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CourierController {
    @Autowired
    private RegisterRepository courierRepo;

    private final RegisterImplementation registerImplementation;

    public CourierController(RegisterImplementation registerImplementation) {
        this.registerImplementation = registerImplementation;
    }
    @GetMapping("/mail")
    public String registrationPage (Model model){
        model.addAttribute("requestRegistration", new RegisterModel());
        return "registration_page";
    }

    @GetMapping("/user")
    public String userPage (Model model){
        model.addAttribute("requestUser", new RegisterModel());
        return "Userpage";
    }
    @PostMapping("/courier")
    public String registration(@ModelAttribute RegisterModel registerModel){
        System.out.println("requestCourier" +registerModel);
        RegisterModel registerModel1 = registerImplementation.createCourier(registerModel);
        return registerModel1 == null? "registration_page" : "redirect:/user";
        }

    @GetMapping("/personal")
    public String courierList(Model model) {
        List<RegisterModel> ListOfCouriers = registerImplementation.courierList();
        model.addAttribute("ListOfCouriers", ListOfCouriers);
        return "personal";
    }
    @GetMapping("/update/{id}")
    public String updateCourier(@PathVariable("id")Integer id, Model model){
        Optional<RegisterModel> cour = courierRepo.findUserById(id);
        RegisterModel courier = cour.get();
        model.addAttribute("Courier", courier);

        return "Edit";
    }

@GetMapping("/delete/{id}")
    public String deleteCourier(@PathVariable("id") Integer id){
        courierRepo.deleteById(id);
        return "redirect:/display";
    }
}
