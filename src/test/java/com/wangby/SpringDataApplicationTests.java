package com.wangby;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringDataApplicationTests {

    @Autowired
    DataSource dataSource;



    @Test
    void contextLoads() throws SQLException {
        System.out.println("************************");
        System.out.println(dataSource.getClass());
        Connection con = dataSource.getConnection();
        System.out.println(con);

        DruidDataSource druidDataSource = (DruidDataSource)dataSource;
        System.out.println(druidDataSource.getInitialSize());
        System.out.println(druidDataSource.getMaxActive());

        con.close();
        System.out.println("************************");
    }

}
