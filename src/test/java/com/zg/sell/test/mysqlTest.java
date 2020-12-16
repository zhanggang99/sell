package com.zg.sell.test;

import com.zg.sell.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class mysqlTest {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void mysqlTestJdbc(){
        String sql = "select id,name,password from ay_user";
        List<User> list = (List<User>) jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User(resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("password"));
                return user;
            }
        });
        System.out.println("查询成功！");
        for (User user:list){
            System.out.println(user.toString());
        }
    }
}
