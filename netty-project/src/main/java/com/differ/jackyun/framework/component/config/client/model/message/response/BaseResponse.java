/*
 * Copyright (c) 2020. Hangzhou Differsoft Co., Ltd. All rights reserved.
 */

package com.differ.jackyun.framework.component.config.client.model.message.response;

import com.differ.jackyun.framework.component.config.client.model.message.BaseMessage;

/**
 * @since 2020/12/4 8:56
 * @author zhangxd
 * @desc  响应报文体
 */
public class BaseResponse extends BaseMessage {

	/**
	 * 响应结果
	 */
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
