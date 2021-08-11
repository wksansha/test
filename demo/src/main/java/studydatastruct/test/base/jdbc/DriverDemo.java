package studydatastruct.test.base.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author wangkai
 * @create 2020/6/16
 */
public class DriverDemo {
    @Test
    public void testDriver() throws SQLException {
        //1. 创建一个 Driver 实现类的对象
        Driver driver = new com.mysql.jdbc.Driver();

        //2. 准备连接数据库的基本信息: url, user, password
        String url = "jdbc:mysql://192.168.0.137:8997/disp_web?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "Telewave1234");

        //3. 调用 Driver 接口的　connect(url, info) 获取数据库连接
        Connection connection = driver.connect(url, info);
        System.out.println(connection);
    }
}
