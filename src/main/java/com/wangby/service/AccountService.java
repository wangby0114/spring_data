package com.wangby.service;

import com.wangby.entity.Account;

import java.util.List;

public interface AccountService {

    Account findByLoginNameAndPassword(String loginName, String password);

    List<Account> findAllList();
}
