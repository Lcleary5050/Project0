package com.revature.API;

import com.revature.models.EmployeesModel;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeesController {

	
EmployeesAPIdao dao;

public EmployeesController(Javalin app) {
	
	dao = new EmployeesAPIdao();
	
	app.get("/Employees/{empid}", getHandler);
	app.post("/Employees", postHandler);
	app.put("/Employees/{empid}", putHandler);
	app.delete("/Employees/{empid}", deleteHandler);
}

public Handler getHandler = ctx -> {
	String empid = ctx.pathParam("emp_id");
	
	EmployeesModel employee = dao.get(empid);
	ctx.json(employee);
};

public Handler postHandler = ctx -> {
	EmployeesModel employee = ctx.bodyAsClass(EmployeesModel.class);
	dao.create(employee);
	ctx.status(201);
};

public Handler putHandler = ctx -> {
	EmployeesModel employee = ctx.bodyAsClass(EmployeesModel.class);
	dao.update(employee);
	ctx.status(200);
};

public Handler deleteHandler = ctx -> {
	EmployeesModel employee = ctx.bodyAsClass(EmployeesModel.class);
	dao.delete(employee);
	ctx.status(200);
};
}
