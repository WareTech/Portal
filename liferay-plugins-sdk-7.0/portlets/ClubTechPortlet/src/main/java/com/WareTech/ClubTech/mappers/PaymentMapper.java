package com.WareTech.ClubTech.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.WareTech.ClubTech.model.Payment;

public interface PaymentMapper 
{
	@Select("SELECT * FROM Payment")
	List<Payment> selectAll();

	@Select("SELECT * FROM Payment WHERE id = #{id}")
	Payment selectById(Long id);

	@Insert("INSERT INTO Payment (id, playerId, suscriptionId, amount, date) VALUES (#{id}, #{playerId}, #{suscriptionId}, #{amount}, #{date})")
	void insert(Payment payment);
	
	@Update("UPDATE Payment SET id = #{id}, playerId = #{playerId}, suscriptionId = #{suscriptionId}, amount = #{amount}, date = #{date} WHERE id = #{id}")
	void update(Payment player);
	
	@Delete("DELETE FROM Payment WHERE id = #{id}")
	void delete(Long id);
}
