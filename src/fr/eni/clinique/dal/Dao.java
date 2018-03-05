package fr.eni.clinique.dal;

import java.util.List;


public interface Dao<T> {

	public T selectById(Long id)throws DALException;
	public List<T> selectAll()throws DALException;
	public void update(T data)throws DALException;
	public void insert(T data)throws DALException;
}
