package com.njbdqn.mydemo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.njbdqn.mydemo.dao.UserinfosDAO;
import com.njbdqn.mydemo.entity.Userinfos;

/**
 * Servlet implementation class TestController
 */
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String name = request.getParameter("username");
		List<Userinfos> users = new UserinfosDAO().findUserByName(name);
		//System.out.println(users);
		String value = new ObjectMapper().writeValueAsString(users);
		//System.out.println(value);
		PrintWriter out = response.getWriter();
		out.write(value);
		out.flush();
		out.close();
	}

}
