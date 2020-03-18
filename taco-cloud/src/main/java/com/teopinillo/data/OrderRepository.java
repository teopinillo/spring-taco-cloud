package com.teopinillo.data;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.teopinillo.entity.Order;

public interface OrderRepository extends CrudRepository <Order, Long >{
	
	List<Order> findByDeliveryZip (String deliveryZip);
	
	List<Order> readOrdersByDeliveryZipAndPlacedAtBetween (
			String deliveryZip, Date startDate, Date endDate );
	
	//Error:  No property deliveryTo found for type Order!
	//List<Order> findByDeliveryCityOrderByDeliveryTo(String city);
	
	//@Query ("SELECT order o WHERE o.deliveryCity='Seatle'")
	//List<Order> readOrdersDeliveredInSeatle();
	
	
}
