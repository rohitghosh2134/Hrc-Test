package com.highradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/grey_goose?zeroDateTimeBehavior=convertToNull";
	
	static final String USER="root";
	static final String PASSWORD="ROHITghosh1234";
	
	

    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		req.setCharacterEncoding("UTF-8");
		resp.addHeader("Access-Control-Allow-Origin","http://localhost:3000");
		Connection conn = null;
		Statement stmt = null;
		List<Response> demoList = new ArrayList<>();
		
		String cust_number=req.getParameter("cust_number");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String sql;
			if(cust_number=="")
				sql="select sl_no,business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id from winter_internship";
			else
				sql="select sl_no,business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id from winter_internship where cust_number like '"+cust_number+"%'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Response res=new Response();
				res.setsl_no(rs.getInt("sl_no"));
				res.setbusiness_code(rs.getString("business_code"));
				res.setcust_number(rs.getString("cust_number"));
				res.setclear_date(rs.getDate("clear_date"));
				res.setbuisness_year(rs.getInt("buisness_year"));
				res.setdoc_id(rs.getString("doc_id"));
				res.setposting_date(rs.getDate("posting_date"));
				res.setdocument_create_date(rs.getDate("document_create_date"));
				res.setdue_in_date(rs.getDate("due_in_date"));
				res.setinvoice_currency(rs.getString("invoice_currency"));
				res.setdocument_type(rs.getString("document_type"));
				res.setposting_id(rs.getInt("posting_id"));
				res.settotal_open_amount(rs.getDouble("total_open_amount"));
				res.setbaseline_create_date(rs.getDate("baseline_create_date"));
				res.setcust_payment_terms(rs.getString("cust_payment_terms"));
				res.setinvoice_id(rs.getInt("invoice_id"));
				demoList.add(res);
			}
				String jsonString = getJSONStringFromObject(demoList);
				resp.setContentType("text/plain");
				try {
					resp.getWriter().write(jsonString);
					File files=new File("D:/HRC BACKEND/Hrc/src/assets/json/Winter_Internship.json");
					files.delete();
					FileWriter file=new FileWriter("D:/HRC BACKEND/Hrc/src/assets/json/Winter_Internship.json");
					file.write(jsonString);
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	private String getJSONStringFromObject(List<Response> filmlist) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(filmlist);
		//System.out.print(json);
		return json;
	}

}
