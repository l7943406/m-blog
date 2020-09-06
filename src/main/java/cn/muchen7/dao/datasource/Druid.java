package cn.muchen7.dao.datasource;/*
 * Created with IntelliJ IDEA.
 * @Author: Muchen
 * DateTime: 2020 - 8 - 13  9 : 7
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/*
 * Druid连接池的工具类
 */
class Druid {

    /**Druid数据库连接对象**/
    private static DataSource ds ;

    /*
     * 静态代码块，初始化Druid数据库连接池
     */
    static {
        try {

            Properties pro = new Properties();//用于读取文件的对象
            pro.load(Druid.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {

            e.printStackTrace();
            System.err.println("打开druid配置文件失败！");
            System.exit(-1);

        } catch (Exception e) {

            System.err.println("初始化druid发生错误！");
            e.printStackTrace();
            System.exit(-1);

        }
    }

    /**
     * 从Druid中过去Connection数据库连接对象
     * @return Connection对象
     * */
    protected static Connection getConnection() throws Exception
    {
        return ds.getConnection();
    }

    /**
     * 私有类，用来关闭ResultSet,PreparedStatement,Connection连接对象
     * */
    private static void closeConnection(ResultSet rs, PreparedStatement pres, Connection conn)
    {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pres != null) {
            try {
                pres.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 依次关闭ResultSet,PreparedStatement,Connection连接对象
     * @param objects 变长参数列表，接受ResultSet,PreparedStatement,Connection对象
     * */
    protected static void closeConnection(Object ... objects) {
        for(Object obj : objects){
            if(obj instanceof ResultSet){
                closeConnection((ResultSet) obj,null,null);
            }
        }
        for(Object obj : objects){
            if(obj instanceof  PreparedStatement){
                closeConnection(null,(PreparedStatement)obj,null);
            }
        }
        for(Object obj : objects){
            if(obj instanceof Connection){
                closeConnection(null,null,(Connection)obj);
            }
        }
    }
}


