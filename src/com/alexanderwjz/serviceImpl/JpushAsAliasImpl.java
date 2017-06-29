package com.alexanderwjz.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NativeHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

import com.alexander.utils.PushMethod;
import com.alexander.utils.ReadPropertiesFile;
import com.alexanderwjz.service.JpushAsAlias;

public class JpushAsAliasImpl implements JpushAsAlias{
	protected static final Logger LOG = LoggerFactory.getLogger(JpushAsAlias.class);
	@Override
	public void push(String usernameAsalias, String UserDefinedMessage) {
		// TODO Auto-generated method stub
		ReadPropertiesFile rp=new ReadPropertiesFile();
		rp.readprotery();
		// TODO Auto-generated method stub
		System.out.println("usernameAsalias"+usernameAsalias +"UserDefinedMessage"+UserDefinedMessage);
		ClientConfig clientConfig = ClientConfig.getInstance();
		final JPushClient jpushClient = new JPushClient(rp.getAPP_KEY(), rp.getMASTER_SECRET(),
				null, clientConfig);
		String authCode = ServiceHelper.getBasicAuthorization(rp.getAPP_KEY(),
				rp.getMASTER_SECRET());
		NativeHttpClient httpClient = new NativeHttpClient(authCode, null,
				clientConfig);
		jpushClient.getPushClient().setHttpClient(httpClient);
		final PushPayload payload = PushMethod.buildPushObject_all_alias_alert(usernameAsalias, UserDefinedMessage);
		try {
			PushResult result = jpushClient.sendPush(payload);
			LOG.info("Got result - " + result);
			} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
			LOG.error("Sendno: " + payload.getSendno());
			} catch (APIRequestException e) {
			LOG.error(
					"Error response from JPush server. Should review and fix it. ",
					e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
			LOG.error("Sendno: " + payload.getSendno());
		}
		
		
	}
}
