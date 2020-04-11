package com.wangby.controller;

import com.sun.media.sound.SoftTuning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Map<String, Object>> selectAll() {
        String sql = "select * from replies";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;


    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable("id") int id, String content)  {
        String sql = "update replies set content = ? where id = " + id;
        int a = jdbcTemplate.update(sql, content);
        System.out.println(a);
        return "update_success";
    }
}
