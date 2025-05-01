package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>
{

}
