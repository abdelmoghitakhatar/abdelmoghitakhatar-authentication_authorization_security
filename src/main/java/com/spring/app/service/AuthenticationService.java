package com.spring.app.service;

import com.spring.app.dto.AuthenticationDTO;

public interface AuthenticationService {

  String authenticate(AuthenticationDTO auth);
}
