/*
 * Copyright (c) 2020. Hangzhou Differsoft Co., Ltd. All rights reserved.
 */

package com.differ.jackyun.framework.component.config.client.model.message.request;

import com.differ.jackyun.framework.component.config.client.model.message.BaseMessage;

/**
 * @since 2020/12/4 8:51
 * @author zhangxd
 * @desc  推送的请求类型消息
 */
public class PushRequest extends BaseMessage {
	/**
	 * 配置编码
	 */
	private String configCode;

	/**
	 * 新值
	 */
	private Object newConfigValue;

	public String getConfigCode() {
		return configCode;
	}

	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}

	public Object getNewConfigValue() {
		return newConfigValue;
	}

	public void setNewConfigValue(Object newConfigValue) {
		this.newConfigValue = newConfigValue;
	}
}
