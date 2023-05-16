package com.courier.spring.service.Implementation;

import com.courier.spring.model.Usermodel;
import com.courier.spring.repository.UserRepository;
import com.courier.spring.service.UserService;
import com.courier.spring.model.Usermodel;
import com.courier.spring.repository.UserRepository;
import com.courier.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplemantation implements UserService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    private JavaMailSender mailSender;
    @Override
    public Usermodel createUser(Usermodel user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("gabybetina5@gmail.com");
        message.setTo(user.getEmail());
        message.setText("Thank you for signing up to betina's Courier");
        message.setSubject("account approved");

        mailSender.send(message);
        return userRepo.save(user);
    }

    @Override
    public Usermodel updateUser(Usermodel user) {
        return null;
    }

    @Override
    public void deleteUser(Usermodel user) {
        userRepo.delete(user);
    }

    @Override
    public Usermodel findUserById(Usermodel user) {
        return userRepo.findById(user.getId()).get();
    }

    @Override
    public Usermodel findUserByEmail(Usermodel user) {
        return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElse(null);
    }

    @Override
    public List<Usermodel> userList() {
        return userRepo.findAll();
    }

    @Override
    public Usermodel getUser(Usermodel user) {
        return null;
    }
}
