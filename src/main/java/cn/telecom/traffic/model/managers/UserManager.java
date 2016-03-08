package cn.telecom.traffic.model.managers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import cn.telecom.traffic.model.dao.User;

@Service
public class UserManager extends HibernateDaoSupport {

	Logger logger = Logger.getLogger(UserManager.class);
	Logger foncLogger = Logger.getLogger("FoncLogger");
	
	@Autowired
	AnnotationSessionFactoryBean sessionFactory;

	/*
	 * @Properties(name = "email.title") private String emailTitle;
	 */

	/**
	 * verifier un utilisateur
	 * 
	 * @param username
	 * @param password
	 * @return objet User si trouve, null sinon
	 */
	@SuppressWarnings("unchecked")
	public User getMatchingUser(String username, String password) {

		String queryString = "from User u Where u.username = ? and u.password = ?";
		List<User> results = getHibernateTemplate().find(queryString, new Object[] { username, password });
		if (results.size() > 0) {
			User user = results.get(0);
			return user;
		}
		return null;
	}

	/**
	 * verifier un utilisateur
	 * 
	 * @param email
	 * @return objet User si trouve, null sinon
	 */
	@SuppressWarnings("unchecked")
	public User getMatchingUser(String username) {
		String queryString = "from User u Where u.username = ?";
		List<User> results = getHibernateTemplate().find(queryString, new Object[] { username });
		if (results.size() > 0) {
			User user = results.get(0);
			return user;
		}
		return null;
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean usernameIsExistInBase(String username) {
		String queryString = "from User u where u.username = ?";
		List<User> results = getHibernateTemplate().find(queryString, new Object[] { username });
		if (results.size() > 0)
			return true;
		return false;
	}

	/**
	 * sauvegarder un nouveau objet dans la base
	 */
	public void addUserInBase(User user) {
		getHibernateTemplate().save(user);
	}

	/**
	 * modifier
	 * 
	 * @param user
	 */
	public void updateUserInBase(User user) {
		getHibernateTemplate().update(user);
	}

	/**
	 * retirer un objet
	 * 
	 * @param persistentInstance
	 */
	public void removeUserFromBase(User user) {
		foncLogger.info("remove user : " + user.getUsername());
		getHibernateTemplate().delete(user);
	}

	/**
	 * recuperer les utilisateurs de la base
	 * 
	 * @param id
	 * @return User
	 */
	public User getUserFromBase(int id) {
		User instance = getHibernateTemplate().get(User.class, id);
		return instance;
	}

	/**
	 * recuperer tous
	 * 
	 * @return tableau des objets User trouves
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		String queryString = "from User";
		return getHibernateTemplate().find(queryString);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll(int type) {
		String queryString = "from User where type = ?";
		List<User> results = getHibernateTemplate().find(queryString, new Object[] { type });
		return results;
	}

	/*public List<User> findUsersByAdmin(User admin) {
		ArrayList<User> res = new ArrayList<User>();
		if (admin.getType() == User.CLIENT_ADMIN) {
			for (User user : admin.getUsers()) {
				if (user.getType() == User.CLIENT_USER)
					res.add(user);
			}
		}
		return res;
	}*/

}
