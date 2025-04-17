package practice.jdbc;

import java.util.Collection;

public interface JdbcDao1<T, K>
{
	Collection<T> getAll(); 
    T getOne(K key);
    //CREATE
    void add(T t);  
    

}

