package com.wangby.dao;

import com.wangby.entity.Menu;
import com.wangby.entity.MenuExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * MenuDAO继承基类
 */
@Repository
public interface MenuDAO extends MyBatisBaseDao<Menu, Integer, MenuExample> {
}