package cn.muchen7.service;

import cn.muchen7.dao.bean.ConfigBean;
import cn.muchen7.dao.sql.ConfigDao;

public class ConfigService {
    private static ConfigBean configBean;
    static {
        configBean = new ConfigDao().getConfig();
    }

    public static ConfigBean getConfig(){
        return configBean;
    }

    public static boolean updateConfig(ConfigBean configBean){
        if(new ConfigDao().updateConfig(configBean)){
            ConfigService.configBean = configBean;
            return true;
        }

        return false; 
    }
}
