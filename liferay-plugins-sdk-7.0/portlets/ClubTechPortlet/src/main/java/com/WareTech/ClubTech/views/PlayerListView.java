package com.WareTech.ClubTech.views;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.WareTech.ClubTech.dao.PlayerDAO;
import com.WareTech.ClubTech.model.Player;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

@ManagedBean
@SessionScoped
public class PlayerListView 
{
	final static Logger LOGGER = Logger.getLogger(PlayerListView.class);

	protected PlayerDAO playerDAO = new PlayerDAO();
	protected Player player = new Player();
	protected String birthdate;
	
	public String getBirthdate() 
	{
		if (this.getPlayer() == null || (this.getPlayer().getBirthdate() == null))
		{
			return null;
		}
		
		return Player.DATE_TIME_FORMATTER.parse(this.getPlayer().getBirthdate()).toString();
	}

	public void setBirthdate(String birthdate)
	{
		this.birthdate = birthdate;
	}

	public PlayerDAO getPlayerDAO() 
	{
		return playerDAO;
	}

	public void setPlayerDAO(PlayerDAO playerDAO) 
	{
		this.playerDAO = playerDAO;
	}

	public Player getPlayer() 
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	public List<Player> getPlayerList()
	{
		return this.getPlayerDAO().selectAll();
	}

	public List<User> getUserList()
	{
		List<User> userList = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		return userList;
	}
	
	public List<Player> getEmployeeList()
		throws Exception	
	{
		return this.playerDAO.selectAll();
	}

	public void create()
	{
		this.playerDAO.insert(this.getPlayer());
	}
}
