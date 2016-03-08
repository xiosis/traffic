package cn.telecom.traffic.model.dao;

import java.util.Map;
import java.util.TreeMap;

import cn.telecom.traffic.common.PersistEnum;

public enum UserType implements PersistEnum<UserType> {
	SUPER_ADMIN(1), ADMIN(2), USER(3);

	private static final Map<Integer, UserType> map = new TreeMap<Integer, UserType>();

	static {
		map.put(SUPER_ADMIN.getId(), SUPER_ADMIN);
		map.put(ADMIN.getId(), ADMIN);
		map.put(USER.getId(), USER);
	};

	private int id;

	private UserType(final int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public boolean isEqualTo(final int id) {
		return this.id == id;
	}

	public boolean isEqualTo(final UserType type) {
		if (type == null) {
			return false;
		}
		return this.id == type.getId();
	}

	public int getPersistedValue() {
		return getId();
	}

	public UserType returnEnum(Integer persistedValue) {
		return map.get(persistedValue);
	}

	public Map<Integer, UserType> getAllValueMap() {
		return map;
	}

}
