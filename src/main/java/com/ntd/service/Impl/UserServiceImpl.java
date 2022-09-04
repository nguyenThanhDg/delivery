package com.ntd.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntd.pojo.User;
import com.ntd.repository.UserRepository;
import com.ntd.service.UserService;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addUser(User user) {
        try {
            String pass = user.getPassword();
            user.setPassword(this.passwordEncoder.encode(pass));
            user.setUserRole(User.customer);
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            user.setAvatar((String) r.get("secure_url"));
            user.setCreatedDate(new Date());
            user.setActive(Boolean.TRUE);
            return this.userRepository.addUser(user);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        return userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Không tồn tại!");
        }
        User u = users.get(0);
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public List<Object[]> getUsersGoShipper() {
        return this.userRepository.getUsersGoShipper();
    }

    @Override
    public boolean changeRole(User user) {
        return this.userRepository.changeRole(user);
    }

    @Override
    public List<User> getUserShipper(int page) {
        return this.userRepository.getUserShipper(page);
    }

    @Override
    public long countUserShipper() {
        return this.userRepository.countUserShipper();
    }

    @Override
    public boolean checkShiper(int id) {
        return this.userRepository.checkShiper(id);
    }

    @Override
    public List<Object[]> getUserShipper() {
        return this.userRepository.getUserShipper();
    }

    @Override
    public boolean changeRoleToCustomer(User user) {
        return this.userRepository.changeRoleToCustomer(user);
    }

    @Override
    public Object getShipperById(int id) {
       return this.userRepository.getShipperById(id);
    }

    @Override
    public boolean updateUser(User user, int id) {
        return this.userRepository.updateUser(user, id);
    }

    @Override
    public long countCustomer() {
        return this.userRepository.countCustomer();
    }

    @Override
    public boolean checkUserName(String string) {
        return this.userRepository.checkUserName(string);
    }

    
}
