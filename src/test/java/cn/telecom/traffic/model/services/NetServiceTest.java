package cn.telecom.traffic.model.services;

import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.telecom.traffic.common.AES;
import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/Spring-context-test.xml" })
public class NetServiceTest {

	@Autowired
	NetService netService;

	@Test
	public void testCharge() {

		System.out.println("当前JRE：" + System.getProperty("java.version"));
		System.out.println("当前JVM的默认字符集：" + Charset.defaultCharset());
		JSONObject result = netService.charge();
		System.out.println(result.toString());
	}

	@Test
	public void testAES() {
		try {
			String encryptedStr = AES.encrypt(
					"{\"request_no\":\"SO2014122312345678\",\"member_key\":\"7df1613567c94d1194fxsc891ec77064\"}",
					"H5gOs1ZshKZ6WikN", "8888159601152533");
			System.out.println(encryptedStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
