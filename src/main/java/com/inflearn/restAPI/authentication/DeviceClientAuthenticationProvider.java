package com.inflearn.restAPI.authentication;

import com.inflearn.restAPI.accounts.Account;
import com.inflearn.restAPI.accounts.AccountRepository;
import com.inflearn.restAPI.accounts.AccountRole;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Please explain the class
 *
 * @author : wookjin
 * @fileName : DeviceClientAuthenticationProvider
 * @since : 12/25/23
 */

@RequiredArgsConstructor
@Component
public class DeviceClientAuthenticationProvider implements AuthenticationProvider {
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Optional<Account> accounts = accountRepository.findByEmail(username);
        if (accounts.isPresent()) {
            Account account = accounts.get();
            if (passwordEncoder.matches(password, account.getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthorities(account.getRoles()));
            } else {
                throw new RuntimeException("Bad credentials");
            }
        } else {
            throw new RuntimeException("Bad credentials");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<AccountRole> roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (AccountRole role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
