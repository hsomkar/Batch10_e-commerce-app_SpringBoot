package com.te.ecommersboot.service;

import java.util.List;

import com.te.ecommersboot.beans.ItemBean;

public interface AdminService {
	public ItemBean getEmpData(Integer aid);

	public boolean addItem(ItemBean Bean);

	public boolean updateItem(ItemBean infoBean);

	public boolean deleteItem(Integer id);

	public List<ItemBean> getAllEmployeeDetails();
}