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
 * @function �����ṩ�˰���ͬ�ķ�ʽȥ������Ϣ�ķ���
 */

public class PushMethod {
	/**
	 * �����Զ�����Ϣ��������ȥ����
	 * @param UserDefinedMessage �Զ�����Ϣ
	 * @param usernameAsalias ����
	 * @return
	 */
	public static PushPayload buildPushObject_all_alias_alert(String usernameAsalias, String UserDefinedMessage) {		
		return PushPayload.newBuilder()
		.setPlatform(Platform.all())
		.setAudience(Audience.alias(usernameAsalias))
		.setMessage(Message.content(UserDefinedMessage)).build();
}
	/**
	 * ����֪ͨ������ƽ̨�������豸
	 * @param notice ֪ͨ������
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
