package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.Stock;
import com.rest.exception.ResourceNotFoundException;
import com.rest.repo.StockRepository;
@Service
public class StockService 
{
	@Autowired
	private StockRepository stockRepo;
	
	public void addStock(Stock newStock)
	{
		stockRepo.save(newStock);
		System.out.println("Stock Added Successfully");
	}
	
	public List<Stock> allStocks()
	{
		return stockRepo.findAll();
	}
	
	public Stock getStock(Integer stock_id)
	{
		return stockRepo.findById(stock_id).orElseThrow(()
				-> new ResourceNotFoundException("Stock Not Found Of ID ="+stock_id));
	}
	
	public String deleteStock(Integer stock_id)
	{
		Stock foundStock = stockRepo.findById(stock_id).orElseThrow(() 
				-> new ResourceNotFoundException("Stock Not Found Of ID ="+stock_id));
		stockRepo.delete(foundStock);
		return "Stock Deleted Successfuly!!!";
	}
	
	public String updateStock(Integer stock_id, Stock updatedStock)
	{
		Stock existingStock = stockRepo.findById(stock_id).orElseThrow(()
				-> new ResourceNotFoundException("Stock Not Found Of ID ="+stock_id));
		int updatedPrice = updatedStock.getCurrentPrice();
		existingStock.setCurrentPrice(updatedPrice);
		
		stockRepo.save(existingStock);
		return "Stock Updated Successfully";
		
	}

}
