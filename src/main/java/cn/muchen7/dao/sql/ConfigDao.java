package cn.muchen7.dao.sql;

import cn.muchen7.dao.bean.ConfigBean;
import cn.muchen7.dao.datasource.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConfigDao {
    /**
     * 更新网站配置
     * @param config 配置bean
     * @return 是否设置成功
     *
     **/
    public boolean updateConfig(ConfigBean config){
        Connection conn;
        boolean isSet=false;
        try {
            conn = Mysql.getConnection();
            String json=config.toJson();

            String sql="update mb_config set mbc_value=? where mbc_id=1;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,json);
            preparedStatement.executeUpdate();
            isSet=true;
            Mysql.closeConnection(preparedStatement,conn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSet;
    }
    public ConfigBean getConfig(){
        Connection conn;
        String json="";
        try {
            conn = Mysql.getConnection();
            String sql="select mbc_value from mb_config where mbc_id = 1";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()) {
                json = rs.getString(1);
            }
            Mysql.closeConnection(preparedStatement,conn);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ConfigBean.getConfigBean(json);
    }
}
