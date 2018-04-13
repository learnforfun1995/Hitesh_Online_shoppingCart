package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	
	public boolean addSupplier(Supplier supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}


	public boolean updateSupplier(Supplier supplier) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteSupplier(Supplier supplier) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	public Supplier getSupplier(int supplierId) 
	{
		// TODO Auto-generated method stub
		return null;
	}


	public List<Supplier> listCategories() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	

}


