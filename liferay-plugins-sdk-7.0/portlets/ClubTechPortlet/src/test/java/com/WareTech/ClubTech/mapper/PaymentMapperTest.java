package com.WareTech.ClubTech.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.WareTech.ClubTech.config.Database;
import com.WareTech.ClubTech.mappers.PaymentMapper;
import com.WareTech.ClubTech.model.Payment;

public class PaymentMapperTest
{
	@Test
	public void testCRUD()
	{
		Long id = System.currentTimeMillis();
		Long playerId = 1l; 
		Long suscriptionId = 1l; 
		Double amount = 450.50d; 
		Date date = new Date(); 
				
		SqlSession session = Database.getInstance().getSqlSessionFactory().openSession();
		
		PaymentMapper paymentMapper = session.getMapper(PaymentMapper.class);
		
		int size = paymentMapper.selectAll().size();
		
		Payment payment = new Payment(id, playerId, suscriptionId, amount, date);
		paymentMapper.insert(payment);
		
		List<Payment> paymentList = paymentMapper.selectAll();
		Assert.assertEquals(paymentList.size(), size + 1);
		
		payment = paymentMapper.selectById(id);
		Assert.assertEquals(payment.getId(), id);
		Assert.assertEquals(payment.getSuscriptionId(), suscriptionId);
		Assert.assertEquals(payment.getAmount(), amount);
//		Assert.assertEquals(payment.getDate().toString(), date.toString());
		
		payment.setDate(new Date());
		paymentMapper.update(payment);
		
		paymentMapper.delete(id);
		
		int newSize = paymentMapper.selectAll().size();
		Assert.assertEquals(size, newSize);
		
		session.close();
	}
}
