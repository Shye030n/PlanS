package org.sh.plans.repository;

import org.sh.plans.entity.Role;
import org.sh.plans.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Modifying
    @Query("update User set role =: role where username =: username")
    void updateUserRole(@Param("username")String username, @Param("role") Role role);
}
