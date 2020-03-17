package com.teopinillo.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.teopinillo.Order;

public interface OrderRepository extends CrudRepository <Order, Long >{
	List<Order> findByDeliveyZip (String deliveryZip);
	
	List<Order> readOrdersByDeliveryZipAndPlacedAtBetween (
			String deliveryZip, Date startDate, Date endDate );
	
	List<Order> findByDeliveryCityOrderByDeliveryTo(String city);
	
	@Query ("order o where o.deliveryCity='Seatle")
	List<Order> readOrdersDeliveredInSeatle();
	
	
}
