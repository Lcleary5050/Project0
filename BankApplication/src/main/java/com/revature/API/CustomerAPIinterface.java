package com.revature.API;

public interface CustomerAPIinterface <T, ID> {
	
	public void create(T element);
	
	public T get(ID id);
	
	public void update(T element);
	
	public void delete(T element);

}
