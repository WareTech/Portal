package com.WareTech.ClubTech.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.WareTech.ClubTech.config.Database;
import com.WareTech.ClubTech.mappers.PlayerMapper;
import com.WareTech.ClubTech.model.Player;

public class PlayerDAO 
{
	public List<Player> selectAll() 
	{
		SqlSession sqlSession = Database.getInstance().getSqlSessionFactory().openSession();
		List<Player> playerList = sqlSession.getMapper(PlayerMapper.class).selectAll();
		sqlSession.close();

		return playerList;
	}
	
	public void insert(Player player) 
	{
		player.setId(System.currentTimeMillis());
		SqlSession sqlSession = Database.getInstance().getSqlSessionFactory().openSession();
		sqlSession.getMapper(PlayerMapper.class).insert(player);
		sqlSession.commit();
		sqlSession.close();
	}
}
