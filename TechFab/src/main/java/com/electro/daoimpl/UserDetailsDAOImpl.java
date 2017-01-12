package com.electro.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electro.dao.UserDetailsDAO;
import com.electro.model.BillingAddress;
import com.electro.model.Cart;
import com.electro.model.ShippingAddress;
import com.electro.model.User;
import com.electro.model.UserDetails;
import com.electro.model.UserRole;


@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	public void addUserDetails(UserDetails userDetails) {

		
		Session session =sessionFactory.getCurrentSession();
		User user=new User();
		user.setUserId(userDetails.getUserId());
		user.setUserName(userDetails.getUserName());
		user.setPassword(userDetails.getPassword());
		user.setEnabled(true);
		session.saveOrUpdate(user);
		
		Cart cart=new Cart();
		cart.setCartId(userDetails.getUserId());
		cart.setUserId(user.getUserId());
		
		session.saveOrUpdate(cart);
		
		UserRole userRole=new UserRole();
		userRole.setUserId(user.getUserId());
		userRole.setRoleId(1);
		session.saveOrUpdate(userRole);

		
		
		
//		userDetails.getBillingAddress().setUserDetails(userDetails);
//		session.saveOrUpdate(userDetails.getBillingAddress());
//		
//		userDetails.getShippingAddress().setUserDetails(userDetails);
//		session.saveOrUpdate(userDetails.getShippingAddress());
//		
		userDetails.setUserId(user.getUserId());
		userDetails.setCartId(cart.getCartId());
		session.saveOrUpdate(userDetails);
		
		session.flush();
	

		
	}


	public void addBillingAddress(BillingAddress billingAddress) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);

	}


	public void addShippingAddress(ShippingAddress shippingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
		
	}
	
	public UserDetails getUserByName(String userName)
	{
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetails> userList=session.createQuery("from UserDetails where userName= '"+userName+"'").list();
		return userList.get(0);
		
	}
	
	
	

}
