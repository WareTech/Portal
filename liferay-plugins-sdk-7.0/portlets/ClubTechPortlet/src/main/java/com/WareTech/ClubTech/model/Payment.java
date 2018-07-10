package com.WareTech.ClubTech.model;

import java.util.Date;

public class Payment 
{
	protected Long id;
	protected Long playerId;
	protected Long suscriptionId;
	protected Double amount;
	protected Date date;
	
	public Payment() {}
	
	public Payment(Long playerId, Long suscriptionId, Double amount, Date date) 
	{
		this(null, playerId, suscriptionId, amount, date);
	}
	
	public Payment(Long id, Long playerId, Long suscriptionId, Double amount, Date date) 
	{
		this.id = id;
		this.playerId = playerId;
		this.suscriptionId = suscriptionId;
		this.amount = amount;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Long getSuscriptionId() {
		return suscriptionId;
	}
	public void setSuscriptionId(Long suscriptionId) {
		this.suscriptionId = suscriptionId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
