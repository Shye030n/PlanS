package org.sh.plans.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sh.plans.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPrinciple implements UserDetails {
    private Long id;
    private String username;
    private String password;
    transient private User user;
    private Set<GrantedAuthority> authorities;

    @Override //계정의 권한 목록 리턴
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override //비밀번호 리턴
    public String getPassword() {
        return password;
    }
    @Override //계정의 고유한 값(pk) 리턴
    public String getUsername() {
        return username;
    }

    @Override //계정의 만료여부
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override //계정의 잠김여부
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override //비밀번호 만료여부
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override //계정의 활성화 여부
    public boolean isEnabled() {
        return true;
    }
    public Long getId() {
        return id;
    }
}
