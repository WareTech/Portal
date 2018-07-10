package com.WareTech.ClubTech.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.WareTech.ClubTech.model.Player;


public class PlayerDAOTest
{
	@Test
	public void testSelectAll()
	{
		List<Player> playerList = new PlayerDAO().selectAll();
		
		Assert.assertEquals(playerList.size(), 1);
	}
}
