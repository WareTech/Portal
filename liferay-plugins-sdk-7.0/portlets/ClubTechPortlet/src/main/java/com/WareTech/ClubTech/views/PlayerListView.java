package com.WareTech.ClubTech.views;

import java.security.Principal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

@ManagedBean
public class PlayerListView {

	final static Logger LOGGER = Logger.getLogger(PlayerListView.class);
	
	public List<User> getUsers() {
		LOGGER.info("getUsers()");
		List<User> userList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		return userList;
	}
	
	public User getUser() {
		LOGGER.info("getUser()");
		try {
			Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			
			if (principal == null) {
				return null;
			}
			
			String userId = principal.getName();
			return UserLocalServiceUtil.getUser(new Long(userId));
		} catch (Exception exception) {
			LOGGER.error(exception);
			return null;
		}
	}
}
