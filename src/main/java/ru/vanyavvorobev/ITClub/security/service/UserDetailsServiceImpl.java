package ru.vanyavvorobev.ITClub.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vanyavvorobev.ITClub.entity.UserEntity;
import ru.vanyavvorobev.ITClub.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity userEntity;
        if(isLoginByUsername(login)) {
             userEntity = userRepository.findByUsername(login)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));
        } else {
            userEntity = userRepository.findByLogin(login)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));
        }
        return UserDetailsImpl.build(userEntity);
    }

    public static Boolean isLoginByUsername(String login) {
        return !isLoginByEmail(login);
    }

    public static Boolean isLoginByEmail(String login) {
        return login.contains("@");
    }

}
