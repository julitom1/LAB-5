package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.Service;
import java.net.MalformedURLException;
import java.util.*;

import edu.eci.cvds.servlet.model.Todo.Todo;

@WebServlet(
    urlPatterns = "/servlets"
)
public class Servlets extends HttpServlet{
	

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,MalformedURLException {
	   try{
		List<Todo> lista=new ArrayList<Todo>();
		
		int id=Integer.valueOf(req.getParameter("id")).intValue();
		Todo todo=Service.getTodo(id);
		lista.add(todo);
		resp.setStatus(200);
		resp.setContentType("text/html");
		resp.getWriter().println(Service.todosToHTMLTable(lista));
		}
		catch(java.io.FileNotFoundException e){
			resp.sendError(400);
		}
		catch(java.lang.NumberFormatException e){
			resp.sendError(400);
		}
		catch(MalformedURLException e){
			resp.sendError(500);
		}
		catch(Exception e){
			//resp.getWriter().println(e);
			resp.sendError(400);
		}
		
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,MalformedURLException {
		try{
		List<Todo> lista=new ArrayList<Todo>();
		
		int id=Integer.valueOf(req.getParameter("id")).intValue();
		Todo todo=Service.getTodo(id);
		lista.add(todo);
		resp.setStatus(200);
		resp.setContentType("text/html");
		resp.getWriter().println(Service.todosToHTMLTable(lista));
		}
		catch(java.io.FileNotFoundException e){
			resp.sendError(400);
		}
		catch(java.lang.NumberFormatException e){
			resp.sendError(400);
		}
		catch(MalformedURLException e){
			resp.sendError(500);
		}
		catch(Exception e){
			//resp.getWriter().println(e);
			resp.sendError(400);
		}

	
   }
   

   

}