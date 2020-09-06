package cn.muchen7.dao.datasource;

import java.sql.Connection;
/**工厂类，在这里能直接改数据库连接池**/
public class Mysql {
    /**从Druid获取数据库连接**/
    public static Connection getConnection() throws Exception{
        return Druid.getConnection();
    }
    /**关闭数据库连接**/
    public static void closeConnection(Object ... objects){
        Druid.closeConnection(objects);
    }
}
