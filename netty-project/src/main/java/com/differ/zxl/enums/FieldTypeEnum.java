package com.differ.zxl.enums;

/**
 * 字段类型
 */
public enum FieldTypeEnum {

    DATA_TYPE_INT(1),
    DATA_TYPE_BOOLEAN(2),
    DATA_TYPE_STRING(3);

    private int dataType;

    private FieldTypeEnum(int dataType){
        this.dataType=dataType;
    }

    public int getDataType() {
        return dataType;
    }
}
