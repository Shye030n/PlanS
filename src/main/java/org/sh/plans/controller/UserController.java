package org.sh.plans.controller;

import lombok.RequiredArgsConstructor;
import org.sh.plans.entity.Role;
import org.sh.plans.security.UserPrinciple;
import org.sh.plans.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Spring MVC 컨트롤러를 선언하며 REST API를 제공
@RequestMapping("/api/user") // "/api/user" 경로의 모든 요청을 처리
@RequiredArgsConstructor // 필수 생성자를 통해 DI (Dependency Injection)를 자동으로 생성
public class UserController {
    private final UserService userService; // UserService 의존성 주입

    @PutMapping("/change/{role}") // PUT 메서드로 역할 변경 처리
    public ResponseEntity<Object> changeRole(
            @AuthenticationPrincipal UserPrinciple userPrinciple, // 인증된 사용자 정보 가져오기
            @PathVariable Role role // 역할(권한)을 PathVariable로 수신
    ) {
        userService.changeRole(role, userPrinciple.getUsername()); // 사용자 권한 변경 서비스 호출
        return ResponseEntity.ok(true); // 응답 성공
    }
}

