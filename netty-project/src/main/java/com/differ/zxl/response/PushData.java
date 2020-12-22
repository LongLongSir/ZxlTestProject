package com.differ.zxl.response;

/**
 * 推送的数据结构
 */
public class PushData {

    private String configCode;

    private Object defaultValue;

    private Object newConfigValue;

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Object getNewConfigValue() {
        return newConfigValue;
    }

    public void setNewConfigValue(Object newConfigValue) {
        this.newConfigValue = newConfigValue;
    }
}
