/*
 * Copyright (c) 2020. Hangzhou Differsoft Co., Ltd. All rights reserved.
 */

package com.differ.jackyun.framework.component.config.client.model.message.response;

/**
 * @since 2020/12/4 9:04
 * @author zhangxd
 * @desc  推送结果消息
 */
public class PushResponse extends BaseResponse {
	/**
	 * 是否成功
	 */
	private boolean success;

	/**
	 * 当前值
	 */
	private Object currentValue;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Object currentValue) {
		this.currentValue = currentValue;
	}
}
