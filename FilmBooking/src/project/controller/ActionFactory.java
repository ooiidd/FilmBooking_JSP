package project.controller;

import project.admin.AdminBack;
import project.admin.AdminLogin;
import project.admin.AdminLoginform;
import project.admin.InsertFilm;
import project.admin.RemoveMember;
import project.admin.RemoveMovie;
import project.admin.ToInsertFilm;
import project.admin.ToMemberManagement;
import project.host.Home;
import project.host.HostCardPay;
import project.host.HostLogin;
import project.host.HostLoginAction;
import project.host.HostLogout;
import project.host.HostMemberChange;
import project.host.HostMemberChangeAction;
import project.host.HostMovieList;
import project.host.HostPayList;
import project.host.HostPaySuccess;
import project.host.HostRemoveReserve;
import project.host.HostReserveList;
import project.host.HostSignin;
import project.host.IdCheck;
import project.host.ToSignin;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}
	public ActionInterface getAction(String command) {
		ActionInterface action = null;
		System.out.println(command);
		if(command.equals("movielist")) {
			action = new HostMovieList();
		}else if(command.equals("choice_movie")) {
			action = new HostLogin();
		}else if(command.equals("login")) {
			action = new HostLoginAction();
		}else if(command.equals("pay")) {
			action = new HostPayList();
		}else if(command.equals("card_pay")) {
			action = new HostCardPay();
		}else if(command.equals("remove_reserve")) {
			action = new HostRemoveReserve();
		}else if(command.equals("pay_success")) {
			action = new HostPaySuccess();
		}else if(command.equals("to_sign_in")) {
			action = new ToSignin();
		}else if(command.equals("sign_in")) {
			action = new HostSignin();
		}else if(command.equals("idcheck")) {
			action = new IdCheck();
		}else if(command.equals("adminlogin")) {
			action = new AdminLoginform();
		}else if(command.equals("admin_login_action")) {
			action = new AdminLogin();
		}else if(command.equals("remove_movie")) {
			action = new RemoveMovie();
		}else if(command.equals("to_insert_film")) {
			action = new ToInsertFilm();
		}else if(command.equals("to_member_management")) {
			action = new ToMemberManagement();
		}else if(command.equals("insert_film")) {
			action = new InsertFilm();
		}else if(command.equals("remove_member")) {
			action = new RemoveMember();
		}else if(command.equals("back_to_list")) {
			action = new AdminBack();
		}else if(command.equals("to_member_change")) {
			action = new HostMemberChange();
		}else if(command.equals("member_change")) {
			action = new HostMemberChangeAction();
		}else if(command.equals("logout")) {
			action = new HostLogout();
		}else if(command.equals("home")) {
			action = new Home();
		}else if(command.equals("pay_cancel")) {
			action = new HostReserveList();
		}
		return action;
	}
}