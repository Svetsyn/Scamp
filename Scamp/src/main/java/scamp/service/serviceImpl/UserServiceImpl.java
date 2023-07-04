package scamp.service.serviceImpl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import scamp.model.entity.Role;
import scamp.model.entity.User;
import scamp.repository.RoleRepository;
import scamp.repository.UserRepository;
import scamp.service.EmailService;
import scamp.service.UserService;

import java.util.List;

import static scamp.constant.Mail.ADMIN_MAIL_SUBJECT;
import static scamp.constant.Mail.ADMIN_MAIL_TEXT;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JavaMailSender javaMailSender;
    private final EmailService emailService;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, JavaMailSender javaMailSender, EmailService emailService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.javaMailSender = javaMailSender;
        this.emailService = emailService;
    }

    @Override
    public void initAdmin() {
        if(userRepository.count() == 0){
            User user = new User();
            user.setFirstName("Sve");
            user.setLastName("Svet");
            user.setEmail("svetsyn@gmail.com");
            user.setRate(100L);
            List<Role> allRoles = roleRepository.findAll();
            user.setRoles(allRoles);
            user.setAvatar(null);
            userRepository.save(user);

            emailService.sendSimpleMessage(user.getEmail(),ADMIN_MAIL_SUBJECT,ADMIN_MAIL_TEXT);

        }
    }

}
