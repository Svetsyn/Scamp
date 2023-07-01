package scamp.service.serviceImpl;

import org.springframework.stereotype.Service;
import scamp.model.entity.Role;
import scamp.model.enumerated.RoleName;
import scamp.repository.RoleRepository;
import scamp.service.RoleService;

import java.util.List;

import static scamp.constant.Definition.*;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {
            Role admin = new Role();
            admin.setRoleName(RoleName.ADMIN);
            admin.setDescription(ROLE_ADMIN_DESCRIPTION);

            Role user = new Role();
            user.setRoleName(RoleName.USER);
            user.setDescription(ROLE_USER_DESCRIPTION);

            Role vip = new Role();
            vip.setRoleName(RoleName.VIP);
            vip.setDescription(ROLE_VIP_DESCRIPTION);

            roleRepository.saveAll(List.of(admin, user, vip));
        }
    }
}
