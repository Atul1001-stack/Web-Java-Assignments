package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Stock;
import com.rest.service.StockService;

@RestController
public class StockController 
{
	@Autowired
	private StockService stockService;
	
	//http://localhost:9090/add   ---------POST
	@PostMapping("/add")
	public void addStock(@RequestBody Stock newStock)
	{
		stockService.addStock(newStock);
	}
	
	//http://localhost:9090/stocks  ------GET
	@GetMapping("/stocks")
	public List<Stock> getAllStocks()
	{
		return stockService.allStocks();
	}
	
	//http://localhost:9090/stocks/{id} --------GET
	@GetMapping("/stocks/{stock_id}")
	public Stock getStockById(@PathVariable Integer stock_id)
	{
		Stock foundStock = null;
		
		try 
		{
			foundStock = stockService.getStock(stock_id);
		}
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		return foundStock;
	}

	//http://localhost:9090/delete/{id} --------DELETE
	@DeleteMapping("/delete/{id}")
	public String deletedStockById(@PathVariable Integer stock_id)
	{
		try
		{
			return stockService.deleteStock(stock_id);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	//http://localhost:9090/update/{id} --------PUT
		@DeleteMapping("/update/{id}")
		public String updatedStockById(@PathVariable Integer stock_id, @RequestBody Stock updateStock)
		{
			try
			{
				return stockService.updateStock(stock_id,updateStock);
			}
			catch(Exception e)
			{
				return e.getMessage();
			}
		}
	
	
}
