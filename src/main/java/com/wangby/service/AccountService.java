package com.wangby.service;

import com.wangby.entity.Account;

public interface AccountService {

    public Account findByLoginNameAndPassword(String loginName, String password);
}
