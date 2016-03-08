package cn.telecom.traffic.common;

import java.util.Map;

public interface PersistEnum<E extends Enum<?>> {
	 
    int getPersistedValue();
     
    E returnEnum(Integer persistedValue);
     
    Map<Integer, E> getAllValueMap();
}
