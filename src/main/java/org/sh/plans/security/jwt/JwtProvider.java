package org.sh.plans.security.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.sh.plans.security.UserPrinciple;
import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(UserPrinciple auth); //토큰 생성
    Authentication getAuthentication(HttpServletRequest request); //인증 객체 얻기
    boolean isTokenValid(HttpServletRequest request); //토큰에 대한 유효성 검사
}
