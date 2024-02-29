package com.web.service;

import java.util.List;

import com.web.model.Electricity;

public interface ElectricityService {
	public Electricity saveRecord(Electricity e);
	public Electricity updateRecord(Electricity e,int cid);
	public Electricity getOneRecord(int cid);
	public List<Electricity>getAllRecord();
	public void deleteRecord(int cid);
	

}
