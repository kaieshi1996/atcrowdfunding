package com.atguigu.crowd;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.AdminService;
import com.atguigu.crowd.util.CrowdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

// 这里用junit5进行测试
@SpringJUnitConfig(locations = {"classpath:spring-persist-tx.xml", "classpath:spring-persist-mybatis.xml"})
public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void  testConnection() throws SQLException{
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testInsertAdmin(){
        Admin admin;
        admin = new Admin(null,"Rachel","123123","rui","rui@qq.com",null);
        int count = adminMapper.insert(admin);
        System.out.println(count);

    }

    @Test
    public void testTx(){
        Admin admin = new Admin(null, "mei Lee", "123456", "mei", "mei@qq.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        adminService.saveAdmin(admin);
    }

    @Test
    public void pathTest(){
        System.out.println();
    }

    @Test
    public void insert(){
        for(int i = 0;i<200;i++){
            adminMapper.insert(new Admin(null,"loginAcct"+1,"userPswd"+1,"userName"+1,"email"+1,null));
        }
    }

    @Test
    public void test2(){
        List<Admin> test = adminMapper.selectAdminByKeyword("");
        System.out.println("1223333");
        System.out.println(test);
    }

    @Test
    public  void test3(){
        Admin admin = new Admin(227,"Bobb",
                "4297F44B13955235245B2497399D7A93",
                "bb","c1996jj@gmail.com",null);
        adminMapper.updateByPrimaryKey(admin);
    }

    @Test
    public void testCreateData(){
        Admin admin;
        for (int i = 0; i < 10; i++) {
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String password = String.valueOf((int)(Math.random()*900000 + 100000));;
            String userPswd = CrowdUtil.md5(password);
            String login = getStringRandom(5);
            String userName = login.substring(0,3);
            admin = new Admin(null,captureName(login),userPswd,userName,userName+"@qq.com",date);
            adminMapper.insert(admin);
        }
    }
    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            val += (char)(random.nextInt(26)+97);
        }
        return val;
    }
    public static String captureName(String name) {
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }


}