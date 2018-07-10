package com.WareTech.ClubTech.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.WareTech.ClubTech.config.Database;
import com.WareTech.ClubTech.enums.Category;
import com.WareTech.ClubTech.enums.State;
import com.WareTech.ClubTech.enums.Year;
import com.WareTech.ClubTech.mappers.PlayerMapper;
import com.WareTech.ClubTech.model.Player;

public class PlayerMapperTest
{
	@Test
	public void testSelectAll()
	{
		List<Player> playerList = Database.getInstance().getSqlSessionFactory().openSession().getMapper(PlayerMapper.class).selectAll();
		
		Assert.assertEquals(playerList.size(), 1);
	}
	
	@Test
	public void testSelectById()
	{
		Long id = 1l;
		Player player = Database.getInstance().getSqlSessionFactory().openSession().getMapper(PlayerMapper.class).selectById(id);
		
		Assert.assertEquals(player.getId(), Long.valueOf(1));
		Assert.assertEquals(player.getFirstname(), "Augusto");
		Assert.assertEquals(player.getLastname(), "Soncini");
		Assert.assertEquals(player.getDni(), "25952726");
		Assert.assertEquals(player.getBirthdate(), "19770612");
		Assert.assertEquals(player.getCategory(), "MAYORES");
		Assert.assertEquals(player.getYear(), "SENIOR");
		Assert.assertEquals(player.getStatus(), "ACTIVO");
		Assert.assertEquals(player.getCode(), "augustosoncini");
	}
	
	@Test
	public void testCRUD()
	{
		Long id = System.currentTimeMillis();
		String firstname = "Augusto";
		String lastname = "Soncini"; 
		String dni = "25952726"; 
		String birthdate = "19770612"; 
		String category = Category.MAYORES; 
		String year = Year.SENIOR; 
		String status = State.EN_LISTA; 
		String code = "augustosoncini";
				
		SqlSession session = Database.getInstance().getSqlSessionFactory().openSession();
		
		PlayerMapper playerMapper = session.getMapper(PlayerMapper.class);
		
		int size = playerMapper.selectAll().size();
		
		Player player = new Player(id, firstname, lastname, dni, birthdate, category, year, status, code);
		playerMapper.insert(player);
		
		List<Player> playerList = playerMapper.selectAll();
		Assert.assertEquals(playerList.size(), size + 1);
		
		player = playerMapper.selectById(id);
		Assert.assertEquals(player.getId(), id);
		Assert.assertEquals(player.getFirstname(), firstname);
		Assert.assertEquals(player.getLastname(), lastname);
		Assert.assertEquals(player.getDni(), dni);
		Assert.assertEquals(player.getBirthdate(), birthdate);
		Assert.assertEquals(player.getCategory(), category);
		Assert.assertEquals(player.getYear(), year);
		Assert.assertEquals(player.getStatus(), status);
		Assert.assertEquals(player.getCode(), code);
		
		player.setFirstname("test");
		playerMapper.update(player);
		
		playerMapper.delete(id);
		
		int newSize = playerMapper.selectAll().size();
		
		Assert.assertEquals(size, newSize);
		session.close();
	}
}
