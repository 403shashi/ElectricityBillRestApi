package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Electricity;
import com.web.repo.ElectricityRepo;



@Service
public class ElectricityServiceImp implements ElectricityService {
	
	
	@Autowired
	private ElectricityRepo repo;

	@Override
	public Electricity saveRecord(Electricity e) {
		int unit=0;
		double tot=0.0;
		unit=e.getCurrent_reading()-e.getPrevious_reading();
		e.setUnits(unit);
		if(unit<300)
		{
			tot=unit*1.75;
		}
		else if(unit>=300 && unit<500)
		{
			tot=unit*3.75;
		}
		else if(unit>=500)
		{
			tot=unit*7.35;
		}
		e.setTotalbill(tot);
		Electricity e1=repo.save(e);
		return e;
	}

	
	@Override
	public Electricity getOneRecord(int cid) {
		Electricity get = repo.findById(cid).get();
		return get;
	}

	@Override
	public List<Electricity> getAllRecord() {
		List<Electricity> getAll=repo.findAll();
		return getAll;
	
	}

	



	@Override
	public void deleteRecord(int cid) {
		  repo.deleteById(cid);

	}


	@Override
	public Electricity updateRecord(Electricity e, int cid) {
		  Electricity oldRecord=repo.findById(cid).get();
			oldRecord.setCname(e.getCname());
			oldRecord.setCurrent_reading(e.getCurrent_reading());
			oldRecord.setPrevious_reading(e.getPrevious_reading());
			int unts=0;
			double total=0.0;
			unts=e.getCurrent_reading()-e.getPrevious_reading();
			e.setUnits(unts);
			if(unts<300)
			{
				total=unts*1.75;
			}
			else if(unts>=300 && unts<500)
			{
				total=unts*3.75;
			}
			else if(unts>=500)
			{
				total=unts*7.35;
			}
			oldRecord.setUnits(unts);
			oldRecord.setTotalbill(total);
			Electricity e1=repo.save(oldRecord);
			return e1;
		}	

	}





















































