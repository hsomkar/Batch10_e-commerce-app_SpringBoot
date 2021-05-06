package com.te.ecommersboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.ecommersboot.beans.ItemBean;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	public ItemBean getEmpData(Integer aid) {
		EntityManager manager = factory.createEntityManager();
		ItemBean bean = manager.find(ItemBean.class, aid);
		return bean;
	}

	public boolean addItem(ItemBean Bean) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(Bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateItem(ItemBean infoBean) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ItemBean orgData = manager.find(ItemBean.class, infoBean.getId());
			if (infoBean.getName() != null && infoBean.getName() != "") {
				orgData.setName(infoBean.getName());
			}
			if (infoBean.getQty() != null) {
				orgData.setQty(infoBean.getQty());
			}
			if (infoBean.getPrice() != null) {
				orgData.setPrice(infoBean.getPrice());
			}
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteItem(Integer id) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ItemBean infoBean = manager.find(ItemBean.class, id);
			manager.remove(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<ItemBean> getAllEmployeeDetails() {
		List<ItemBean> Beans = null;
		try {
			EntityManager manager = factory.createEntityManager();
			Query query = manager.createQuery("from ItemBean");
			Beans = query.getResultList();
		} catch (Exception e) {
			Beans = null;
			e.printStackTrace();
		}
		return Beans;
	}
}
