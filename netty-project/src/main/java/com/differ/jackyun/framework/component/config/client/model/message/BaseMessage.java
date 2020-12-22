/*
 * Copyright (c) 2020. Hangzhou Differsoft Co., Ltd. All rights reserved.
 */

package com.differ.jackyun.framework.component.config.client.model.message;

import java.io.Serializable;

/**
 * @since 2020/12/4 8:42
 * @author zhangxd
 * @desc  报文基类
 */
public abstract class BaseMessage implements Serializable {
	/**
	 * 报文类型
	 */
	private String messageType;

	/**
	 * 副本ID
	 */
	private String duplicateId;

	/**
	 * 唯一ID
	 */
	private Long messageId;

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getDuplicateId() {
		return duplicateId;
	}

	public void setDuplicateId(String duplicateId) {
		this.duplicateId = duplicateId;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
}
