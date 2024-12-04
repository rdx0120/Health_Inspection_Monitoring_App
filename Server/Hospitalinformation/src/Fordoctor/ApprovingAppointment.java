package Fordoctor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import Database.DatabaseConnection;
import GetterSetter.Book;
import GetterSetter.Countries;

/**
 * Servlet implementation class ApprovingAppointment
 */
@WebServlet("/ApprovingAppointment")
public class ApprovingAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String methodname="";
	DatabaseConnection db1=new DatabaseConnection();
	 JsonObject jsonObject;
	 Connection con;
	 String sendToMObile;
	    ArrayList<Book> books=new ArrayList<Book>();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovingAppointment() {
        super();
        con=db1.dbconnection();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Book> books=new ArrayList<Book>();
		 String hospname=request.getParameter("id");
		  books=getAllCountries(hospname);
		  Gson gson = new Gson();
		  JsonElement element = gson.toJsonTree(books, new TypeToken<List<Countries>>() {}.getType());
JsonObject jsonObject=new JsonObject();

		  JsonArray jsonArray = element.getAsJsonArray();
		  jsonObject.add("jsonarrayval", jsonArray);
		  response.setContentType("application/json");
		  response.getWriter().print(jsonObject);
	
	
	}

	public  ArrayList<Book> getAllCountries(String hospname) {
	     //connection = con;
	        ArrayList<Book> booklist = new ArrayList<Book>();
	        String sql="Update  multipleappointment set status='Approved' where id="+hospname+"";
	    	
	        System.out.println(sql);
			int i=db1.getUpdate(sql);

			
			
		       
		    	
		    	     Book book=new Book();
		            if(i>0) { 
		            	
		            	
		            	
		            book.setBookName("1");
		           
		               
		               
		            }
		            else
		            {
		            	
		            	 book.setBookName("0");
		            }
		            booklist.add(book);
		         

	        return booklist;
	}
}

