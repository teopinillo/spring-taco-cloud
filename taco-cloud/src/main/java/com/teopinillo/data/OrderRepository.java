package com.teopinillo.data;

import com.teopinillo.Order;

public interface OrderRepository {
	Order save(Order order);
}
