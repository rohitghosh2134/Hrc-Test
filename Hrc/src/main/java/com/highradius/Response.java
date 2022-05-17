package com.highradius;

import java.sql.*;
public class Response {
	private int sl_no,posting_id,invoice_id, buisness_year;
	private Date clear_date,posting_date,document_create_date,due_in_date,baseline_create_date;
	private double total_open_amount;
	private String aging_bucket,business_code,cust_number,doc_id,invoice_currency,document_type,cust_payment_terms;
	
	public String getaging_bucket()
	{
		return aging_bucket;
	}
	public void setaging_bucket(String aging_bucket)
	{
		this.aging_bucket=aging_bucket;
	}
	public int getsl_no()
	{
		return sl_no;
	}
	public void setsl_no(int sl_no)
	{
		this.sl_no=sl_no;
	}
	public int getposting_id() {
		return posting_id;
	}
	public void setposting_id(int posting_id)
	{
		this.posting_id=posting_id;
	}
	public int getinvoice_id()
	{
		return invoice_id;
	}
	public void setinvoice_id(int invoice_id)
	{
		this.invoice_id=invoice_id;
	}
	public int  getbuisness_year()
	{
		return buisness_year;
	}
	public void setbuisness_year(int buisness_year)
	{
		this.buisness_year=buisness_year;
	}
	public Date getclear_date()
	{
		return clear_date;
	}
	public void setclear_date(Date clear_date)
	{
		this.clear_date=clear_date;
	}
	public Date getposting_date() {
		return posting_date;
	}
	public void setposting_date(Date posting_date)
	{
		this.posting_date=posting_date;
	}
	public Date getdocument_create_date() {
		return document_create_date;
	}
	public void setdocument_create_date(Date document_create_date)
	{
		this.document_create_date=document_create_date;
	}
	public Date getdue_in_date() {
		return due_in_date;
	}
	public void setdue_in_date(Date due_in_date)
	{
		this.due_in_date=due_in_date;
	}
	public Date baseline_create_date() {
		return baseline_create_date;
	}
	public void setbaseline_create_date(Date baseline_create_date)
	{
		this.baseline_create_date=baseline_create_date;
	}
	public double total_open_amount() {
		return total_open_amount;
	}
	public void settotal_open_amount(double total_open_amount)
	{
		this.total_open_amount=total_open_amount;
	}
	
	public String getbusiness_code() {
		return business_code;
	}
	public void setbusiness_code(String business_code)
	{
		this.business_code=business_code;
	}
	public String getcust_number() {
		return cust_number;
	}
	public void setcust_number(String cust_number)
	{
		this.cust_number=cust_number;
	}
	public String getdoc_id() {
		return doc_id;
	}
	public void setdoc_id(String doc_id)
	{
		this.doc_id=doc_id;
	}
	public String getinvoice_currency() {
		return invoice_currency;
	}
	public void setinvoice_currency(String invoice_currency)
	{
		this.invoice_currency=invoice_currency;
	}
	public String getdocument_type() {
		return document_type;
	}
	public void setdocument_type(String document_type)
	{
		this.document_type=document_type;
	}
	public String getcust_payment_terms() {
		return cust_payment_terms;
	}
	public void setcust_payment_terms(String cust_payment_terms)
	{
		this.cust_payment_terms=cust_payment_terms;
	}
	
}
