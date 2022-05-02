package com.revature.API;

import com.revature.models.AccountModel;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AccountController {

AccountsAPIdao dao;
	
	public AccountController(Javalin app) {
		
		dao = new AccountsAPIdao();
		
		app.get("/Account/{accounNumber}", getHandler);
		app.post("/Account", postHandler);
		app.put("/Account/{accountNumber}", putHandler);
		app.delete("/Account/{accountNumber}", deleteHandler);
	}
	
	public Handler getHandler = ctx -> {
		String accNum = ctx.pathParam("Account_num");
		
		AccountModel account = dao.get(accNum);
		ctx.json(account);
	};
	
	public Handler postHandler = ctx -> {
		AccountModel account = ctx.bodyAsClass(AccountModel.class);
		dao.create(account);
		ctx.status(201);
	};
	
	public Handler putHandler = ctx -> {
		AccountModel account = ctx.bodyAsClass(AccountModel.class);
		dao.update(account);
		ctx.status(200);
	};
	
	public Handler deleteHandler = ctx -> {
		AccountModel account = ctx.bodyAsClass(AccountModel.class);
		dao.delete(account);
		ctx.status(200);
	};
}

