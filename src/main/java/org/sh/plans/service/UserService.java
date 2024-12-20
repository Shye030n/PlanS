package org.sh.plans.service;

import org.sh.plans.entity.Role;
import org.sh.plans.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user); //유저 저장
    User findByUsername(String username); //유저 찾기
    void changeRole(Role newRole, String username); //유저 role 변경
    List<User> findAllUsers(); //전체 유저 찾기

}
