package com.example.Mohinh.service;

import com.example.Mohinh.entities.Role;
import com.example.Mohinh.entities.User;
import com.example.Mohinh.repository.RoleRepository;
import com.example.Mohinh.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) {
        // Kiểm tra xem người dùng có tồn tại hay không
//        if (userRepository.findByUsername(user.getUsername()) != null) {
//            throw new IllegalArgumentException("Username already exists");
//        }

        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role defaultRole = roleService.getDefaultRole();
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);
        user.setRoles(roles);
        // Lưu người dùng vào cơ sở dữ liệu
        userRepository.save(user);

    }

    @Autowired
    private RoleService roleService;
}
