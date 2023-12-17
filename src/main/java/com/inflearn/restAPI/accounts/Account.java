package com.inflearn.restAPI.accounts;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Please explain the class
 *
 * @author : wookjin
 * @fileName : Account
 * @since : 12/16/23
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Integer id;

    private String email;
    private String password;
    @ElementCollection(fetch = jakarta.persistence.FetchType.EAGER)
    @Enumerated(value = jakarta.persistence.EnumType.STRING)
    private Set<AccountRole> roles;

}
