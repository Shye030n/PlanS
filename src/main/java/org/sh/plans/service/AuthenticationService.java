package org.sh.plans.service;

import org.sh.plans.entity.User;

public interface AuthenticationService {
    public User signInAndReturnJWT(User signInRequest);
}
