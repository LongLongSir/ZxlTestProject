/*
 * Copyright (c) 2020. Hangzhou Differsoft Co., Ltd. All rights reserved.
 */

package com.differ.jackyun.framework.component.config.client.model.message.response;

import com.differ.jackyun.framework.component.config.client.model.message.BaseMessage;

/**
 * @since 2020/12/4 8:54
 * @author zhangxd
 * @desc  同步
 */
public class SyncResponse extends BaseMessage {

	/**
	 * LIST -> JSON 同步数据
	 */
	private String syncData;

	private Boolean startUpSync = false;

	public String getSyncData() {
		return syncData;
	}

	public void setSyncData(String syncData) {
		this.syncData = syncData;
	}

	public Boolean getStartUpSync() {
		return startUpSync;
	}

	public void setStartUpSync(Boolean startUpSync) {
		this.startUpSync = startUpSync;
	}
}
