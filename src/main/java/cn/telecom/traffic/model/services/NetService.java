package cn.telecom.traffic.model.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.telecom.traffic.common.HttpRequestUtils;
import net.sf.json.JSONObject;

@Service
public class NetService {

	@Value("${service.telecom.url}")
	private String url; 
	
	@Value("${service.telecom.iv}")
	private String iv; 
	
	@Value("${service.telecom.password}")
	private String password; 
	
	public JSONObject charge() {
		JSONObject jsonObj = HttpRequestUtils.httpGet(url);
		return jsonObj;
	}
}
