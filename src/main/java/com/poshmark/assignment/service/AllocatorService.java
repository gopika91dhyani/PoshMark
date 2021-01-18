package com.poshmark.assignment.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
import org.springframework.stereotype.Service;

import com.poshmark.assignment.models.Resource;

@Service
public class AllocatorService {
	
	public void getAllocation(Resource res) throws FileNotFoundException, IOException, ParseException {
		
		int hours = res.getHours();
		int cpus = res.getCpus();
		float price = res.getPrice();
		String area = res.getRegion();
		
		float ratePerHour = price/hours;
		
		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\ezmahgo\\Documents\\SpringBootTrial\\PoshMark\\src\\main\\resources\\data\\cost.json")); 
	    JSONObject jo = (JSONObject) obj;	    
	    JSONObject o = (JSONObject) jo.get(area);
	    
	    Map<Integer,Double> valueMap = new TreeMap<Integer,Double>();
	    
	    valueMap.put(getNumOfCPU("large"), (Double)o.get("large"));
	    valueMap.put(getNumOfCPU("xlarge"), (Double)o.get("xlarge"));
	    valueMap.put(getNumOfCPU("2xlarge"), (Double)o.get("2xlarge"));
	    valueMap.put(getNumOfCPU("4xlarge"), (Double)o.get("4xlarge"));
	    valueMap.put(getNumOfCPU("8xlarge"), (Double)o.get("8xlarge"));
	    valueMap.put(getNumOfCPU("10xlarge"), (Double)o.get("10xlarge"));
    
	    for(Entry<Integer,Double> e: valueMap.entrySet()) {
	    	
	    	if(cpus % e.getKey() == 0 && e.getValue() <= ratePerHour) {
	    		  int num = Math.round(cpus/e.getKey());
	    		  
	    	}
	    	
	    }
		
		
		
	}
	
	public int getNumOfCPU(String type) {
		switch(type) {
		  case "large" : return 1; 
		  case "xlarge" : return 2; 
		  case "2xlarge" : return 4; 
		  case "4xlarge" : return 8; 
		  case "8xlarge" : return 16; 
		  case "10xlarge" : return 32; 
		  default : return 0;
		}

	}

}
