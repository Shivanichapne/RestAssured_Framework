package ecom;

import java.util.List;

import org.testng.annotations.Test;

import pojo.CreateOrder;
import pojo.Orders;

public class PlaceOrderWithPojo extends BaseData {
	
	
	@Test
	public void placeOrderTest() {
		Orders orders = new Orders();

		orders.setCountry("India");
		orders.setProductOrderedId(prdId);

		CreateOrder co = new CreateOrder();

		List<Orders> orderList = co.getOrders();
	}
}
