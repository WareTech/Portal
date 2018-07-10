package com.WareTech.ClubTech.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.WareTech.ClubTech.model.Player;

public interface PlayerMapper 
{
	@Select("SELECT * FROM Player")
	List<Player> selectAll();

	@Select("SELECT * FROM Player WHERE id = #{id}")
	Player selectById(Long id);

	@Insert("INSERT INTO Player (id, firstname, lastname, dni, birthdate, category, year, status, code) VALUES (#{id}, #{firstname}, #{lastname}, #{dni}, #{birthdate}, #{category}, #{year}, #{status}, #{code})")
	void insert(Player player);
	
	@Update("UPDATE Player SET (id = #{id}, firstname = #{firstname}, lastname = #{lastname}, dni = #{dni}, birthdate = #{birthdate}, category = #{category}, year = #{year}, status = #{status}, code = #{code} WHERE id = #{id}")
	void update(Player player);
	
	@Delete("DELETE FROM Player WHERE id = #{id}")
	void delete(Long id);
}
