package com.revature.API;

import com.revature.models.CustomersModel;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class CustomerController {

	CustomerAPIdao dao;
	
	public CustomerController(Javalin app) {
		
		dao = new CustomerAPIdao();
		
		app.get("/Customers/{custUsername}", getHandler);
		app.post("/Customers", postHandler);
		app.put("/Customers/{custUsername}", putHandler);
		app.delete("/Customers/{custUsername}", deleteHandler);
	}
	
	public Handler getHandler = ctx -> {
		String username = ctx.pathParam("cust_username");
		
		CustomersModel customer = dao.get(username);
		ctx.json(customer);
	};
	
	public Handler postHandler = ctx -> {
		CustomersModel customer = ctx.bodyAsClass(CustomersModel.class);
		dao.create(customer);
		ctx.status(201);
	};
	
	public Handler putHandler = ctx -> {
		CustomersModel customer = ctx.bodyAsClass(CustomersModel.class);
		dao.update(customer);
		ctx.status(200);
	};
	
	public Handler deleteHandler = ctx -> {
		CustomersModel customer = ctx.bodyAsClass(CustomersModel.class);
		dao.delete(customer);
		ctx.status(200);
	};
}

