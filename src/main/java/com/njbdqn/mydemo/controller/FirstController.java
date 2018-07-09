package com.njbdqn.mydemo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.njbdqn.mydemo.dao.UserinfosDAO;
import com.njbdqn.mydemo.entity.Userinfos;

/**
 * Servlet implementation class FirstController
 */
public class FirstController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 中文处理
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//接受前端页面 传送来的数据
		String username= request.getParameter("username");
		UserinfosDAO udao = new UserinfosDAO();
		// 把后台向jsp页面传送的数据存到request中
		request.setAttribute("xx", udao.findUserByName(username));
		//  跳转并传送数据给页面
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
