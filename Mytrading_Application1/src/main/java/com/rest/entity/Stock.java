package com.rest.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Stock
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer stock_id;
   @Column(length=50)
   private String componyName;
   
   private int currentPrice;
   
   private int quantity;
   
   private LocalDate tradeDate;

    public Stock() 
    {
	  super();
    }

	public Stock(Integer stock_id, String componyName, int currentPrice, int quantity, LocalDate tradeDate) 
	{
		super();
		this.stock_id = stock_id;
		this.componyName = componyName;
		this.currentPrice = currentPrice;
		this.quantity = quantity;
		this.tradeDate = tradeDate;
	}

	public Integer getStock_id() {
		return stock_id;
	}

	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
	}

	public String getComponyName() {
		return componyName;
	}

	public void setComponyName(String componyName) {
		this.componyName = componyName;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}

	@Override
	public String toString() {
		return "Stock [stock_id=" + stock_id + ", componyName=" + componyName + ", currentPrice=" + currentPrice
				+ ", quantity=" + quantity + ", tradeDate=" + tradeDate + "]";
	}
	
	
    
    
   
   
   
}
