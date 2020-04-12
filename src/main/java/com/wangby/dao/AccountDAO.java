package com.wangby.dao;

import com.wangby.entity.Account;
import com.wangby.entity.AccountExample;
import org.springframework.stereotype.Repository;

/**
 * AccountDAO继承基类
 */
@Repository
public interface AccountDAO extends MyBatisBaseDao<Account, Integer, AccountExample> {
}