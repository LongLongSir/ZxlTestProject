/*
 * Copyright (c) 2020. Hangzhou Differsoft Co., Ltd. All rights reserved.
 */

package com.differ.jackyun.framework.component.config.client.model.message.request;

import com.differ.jackyun.framework.component.config.client.model.message.BaseMessage;

/**
 * @since 2020/12/4 8:47
 * @author zhangxd
 * @desc  同步请求消息
 */
public class SyncRequest extends BaseMessage {

	/**
	 * 配置编码
	 */
	private String configCode;

	/**
	 * 命名空间
	 */
	private String nameSpace;


	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public String getConfigCode() {
		return configCode;
	}

	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}
}
