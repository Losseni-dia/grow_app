package grow.backend.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import grow.backend.model.User;
import grow.backend.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        final User user = userRepository.findByLogin(nom);

        if (user == null) {
            throw new UsernameNotFoundException("User " + nom + " not found");
        }

        return new org.springframework.security.core.userdetails.User(
                nom,
                user.getPassword(),
                getGrantedAuthorities(user.getRole().toString()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return authorities;
    }

}
