package com.electro.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electro.dao.CartItemDAO;
import com.electro.model.CartItem;
import com.electro.model.Category;

@Repository

public class CartItemDAOImpl implements CartItemDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	public void addCartItem(CartItem cartItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);

	}
	
public CartItem getCartListById(int cartItemId) {
		
		Session session=sessionFactory.getCurrentSession();
		String hql="from CartItem where cartItemId="+cartItemId;
		@SuppressWarnings("unchecked")
		List<CartItem> cilist=session.createQuery(hql).list();
		return cilist.get(0);
	}
	
	

	


}
