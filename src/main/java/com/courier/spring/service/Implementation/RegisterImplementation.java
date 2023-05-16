package com.courier.spring.service.Implementation;

import com.courier.spring.model.RegisterModel;
import com.courier.spring.repository.RegisterRepository;
import com.courier.spring.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegisterImplementation implements RegisterService {
    @Autowired
    private RegisterRepository registerRepo;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public RegisterModel createCourier(RegisterModel register) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("gabybetina5@gmail.com");
        message.setTo(register.getEmail());
        message.setText("Your package has been sent!!");
        message.setSubject("confirmation Email");
        mailSender.send(message);
        return registerRepo.save(register);
    }

    @Override
    public RegisterModel updateCourier(RegisterModel register) {
       RegisterModel courier = findUserById((register));
       if (courier!= null){
           courier.setCourier_id(register.getCourier_id());
           courier.setCname(register.getCname());
           courier.setSname(register.getSname());
           courier.setSphone(register.getSphone());
           courier.setEmail(register.getEmail());
           courier.setRname(register.getRname());
           courier.setRphone(register.getRphone());
           courier.setRoute(register.getRoute());
           courier.setTransport(register.getTransport());
           return registerRepo.save(courier);
       }else {
           return createCourier(register);
       }

    }

    @Override
    public void deleteCourier(RegisterModel register) {
        registerRepo.deleteAll(); ;
    }

    @Override
    public RegisterModel findUserById(RegisterModel register) {
        return registerRepo.findById(register.getCourier_id()).get();
    }

    @Override
    public List<RegisterModel> courierList() {
////        if (keyword!=null){
////            return registerRepo.se
//        }
        return registerRepo.findAll();
    }

    @Override
    public RegisterModel getCourier(RegisterModel register) {
        return registerRepo.findUserById(register.getId()).get();
    }
}
