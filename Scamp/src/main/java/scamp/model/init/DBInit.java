package scamp.model.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import scamp.service.EmailService;
import scamp.service.RoleService;
import scamp.service.UserService;

@Configuration
public class DBInit implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;

    public DBInit(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
            roleService.initRoles();
            userService.initAdmin();
    }

}
