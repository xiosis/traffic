package cn.telecom.traffic.model.managers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.telecom.traffic.model.dao.Order;
import cn.telecom.traffic.model.dao.Traffic;
import cn.telecom.traffic.model.dao.User;
import cn.telecom.traffic.model.dao.UserType;

public class UserManagerTest extends BaseTestCase {

	@Autowired
	private UserManager userManager;
	@Autowired
	private OrderManager orderManager;
	
	@Test
	public void testGetMatchingUser() {
		User newUser = new User();
		newUser.setUsername("xiosis");
		newUser.setFirstname("huaze");
		newUser.setLastname("tang");
		newUser.setPassword("password");
		newUser.setEmail("test@test.com");
		newUser.setType(UserType.ADMIN);
		newUser.setTel("13207154285");

		userManager.addUserInBase(newUser);

		User user = userManager.getMatchingUser("xiosis", "password");
		System.out.println(user.getUsername());
		assertNotNull(user);
		assertTrue(user.getType().isEqualTo(UserType.ADMIN));
	}

	@Test
	public void testAddUserAndOrder() {
		User newUser = new User();
		newUser.setUsername("user1");
		newUser.setFirstname("huaze");
		newUser.setLastname("tang");
		newUser.setPassword("password");
		newUser.setEmail("test@test.com");
		newUser.setType(UserType.ADMIN);
		newUser.setTel("13207154285");
		
		Traffic traffic1 = new Traffic();
		traffic1.setCode("TEST");
		traffic1.setDescription("test");
		traffic1.setActif(true);

		Order newOrder1 = new Order();
		newOrder1.setUser(newUser);
		newOrder1.setTraffic(traffic1);
		
		orderManager.addOrderInBase(newOrder1);
		//userManager.addUserInBase(newUser);
	}

}
