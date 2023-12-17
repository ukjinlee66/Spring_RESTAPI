package com.inflearn.restAPI.configs;

import com.inflearn.restAPI.accounts.Account;
import com.inflearn.restAPI.accounts.AccountRole;
import com.inflearn.restAPI.accounts.AccountService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Please explain the class
 *
 * @author : wookjin
 * @fileName : AppConfig
 * @since : 12/16/23
 */
@Order(0)
@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


//    @Bean
//    public ApplicationRunner applicationRunner()  {
//        return new ApplicationRunner() {
//            @Autowired
//            AccountService accountService;
//
//            @Override
//            public void run(ApplicationArguments args) throws Exception {
//                Account account = Account.builder()
//                    .email("wookjin@email.com")
//                    .password("wookjin")
//                    .roles(Set.of(AccountRole.ADMIN, AccountRole.USER))
//                    .build();
//                accountService.saveAccount(account);
//            }
//        };
//    }
}
