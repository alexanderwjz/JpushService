package com.alexander.utils;

import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
/**
 * 
 * @author alexanderwjz
 * @email 1666796947@qq.com
 * @function 该类提供了按不同的方式去推送消息的方法
 */

public class PushMethod {
	/**
	 * 推送自定义消息，按别名去推送
	 * @param UserDefinedMessage 自定义消息
	 * @param usernameAsalias 别名
	 * @return
	 */
	public static PushPayload buildPushObject_all_alias_alert(String usernameAsalias, String UserDefinedMessage) {		
		return PushPayload.newBuilder()
		.setPlatform(Platform.all())
		.setAudience(Audience.alias(usernameAsalias))
		.setMessage(Message.content(UserDefinedMessage)).build();
}
	/**
	 * 推送通知，所有平台，所有设备
	 * @param notice 通知的内容
	 * @return
	 */
	public static PushPayload buildPushObject_all_all_alert(String notice) {		
		return PushPayload.newBuilder()
		.setPlatform(Platform.all())
		.setAudience(Audience.all())
		.setNotification(Notification.alert(notice))
		.build();
}
}
