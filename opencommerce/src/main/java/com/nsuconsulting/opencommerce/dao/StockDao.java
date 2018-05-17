package com.nsuconsulting.opencommerce.dao;

import com.nsuconsulting.opencommerce.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockDao extends JpaRepository<Stock, Long> {
	List<Stock> findStocksByLocation_Id(Long idLocation);
	List<Stock> findStocksByLocation_IdAndProduct_IdIs(Long locationId, List<Long> ids);
	Optional<Stock> findStockByProduct_IdAndQuantityGreaterThanAndLocation_Id(Long productId, Double quantity, Long locationId);
	List<Stock> findStocksByProduct_Id(Long productId);
	Optional<Stock> findStockByProduct_IdAndLocation_Id(Long idProduct, Long idLocation);
}
