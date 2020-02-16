package com.lhx.charity.service;


import com.lhx.charity.entity.User;
import com.lhx.charity.utils.Result;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    Result<User> login(User user);

    Result<User> add(User user);

    Result<User> updatePassword(User user);


}
