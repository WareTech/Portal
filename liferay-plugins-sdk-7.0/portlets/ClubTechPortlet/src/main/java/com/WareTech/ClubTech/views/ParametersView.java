package com.WareTech.ClubTech.views;

import java.security.Principal;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.WareTech.ClubTech.enums.Category;
import com.WareTech.ClubTech.enums.State;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

@ManagedBean
@ApplicationScoped
public class ParametersView 
{
	final static Logger LOGGER = Logger.getLogger(ParametersView.class);
	
	public String[] getCategories()
	{
		return Category.ALL;
	}
	
	public String[] getStates()
	{
		return State.ALL;
	}
	
	public User getUser() 
	{
		try
		{
			Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			
			if (principal == null) 
			{
				return null;
			}
			
			String userId = principal.getName();
			return UserLocalServiceUtil.getUser(new Long(userId));
		} 
		catch (Exception exception) 
		{
			LOGGER.error(exception);
			return null;
		}
	}
	
	public ThemeDisplay getThemeDisplay()
	{
		return (ThemeDisplay) FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestMap()
				.get(WebKeys.THEME_DISPLAY);
	}
}
