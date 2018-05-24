package com.WareTech.ClubTech.views;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@ManagedBean
public class PlayerListView {

	public List<User> getUsers() {
		
		List<User> userList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		return userList;
	}
	
	public User getUser() {
		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			return PortalUtil.getUser(httpServletRequest);
		} catch (Exception exception) {
			return null;
		}
	}
}
