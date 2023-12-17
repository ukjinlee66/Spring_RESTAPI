package com.inflearn.restAPI.configs;

import com.inflearn.restAPI.accounts.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Please explain the class
 *
 * @author : wookjin
 * @fileName : AuthServerConfig
 * @since : 12/16/23
 */
@RequiredArgsConstructor
@Configuration
//@EnableAuthorizationServer
// deprecated 문제 발생 /oauth/token 서버 존재하지 않음
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    PasswordEncoder passwordEncoder;

    AuthenticationManager authenticationManager;

    AccountService accountService;

    TokenStore tokenStore;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(this.passwordEncoder);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("myApp")
            .authorizedGrantTypes("password", "refresh_token")
            .scopes("read", "write")
            .secret(this.passwordEncoder.encode("pass"))
            .accessTokenValiditySeconds(10 * 60)
            .refreshTokenValiditySeconds(6 * 10 * 60);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
            .userDetailsService(accountService)
            .tokenStore(tokenStore);
    }
}
