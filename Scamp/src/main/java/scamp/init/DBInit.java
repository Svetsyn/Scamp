package scamp.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
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
