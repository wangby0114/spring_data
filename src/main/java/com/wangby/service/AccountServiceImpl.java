package com.wangby.service;

import com.wangby.dao.AccountDAO;
import com.wangby.entity.Account;
import com.wangby.entity.AccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public Account findByLoginNameAndPassword(String loginName, String password) {
        AccountExample example = new AccountExample();
        example.createCriteria().andLoginNameEqualTo(loginName).andPasswordEqualTo(password);
        List<Account> result = accountDAO.selectByExample(example);
        return result.size() == 0 ? null : result.get(0);
    }

}
