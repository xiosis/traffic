package cn.telecom.traffic.model.managers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import cn.telecom.traffic.model.dao.Order;
import cn.telecom.traffic.model.dao.Traffic;

@Service
public class OrderManager extends HibernateDaoSupport {

	Logger logger = Logger.getLogger(OrderManager.class);
	Logger foncLogger = Logger.getLogger("FoncLogger");

	@Autowired
	AnnotationSessionFactoryBean sessionFactory;

	public void addOrderInBase(Order order) {
		getHibernateTemplate().save(order);
	}

	public void addTrafficInBase(Traffic traffic) {
		getHibernateTemplate().save(traffic);
	}
}
