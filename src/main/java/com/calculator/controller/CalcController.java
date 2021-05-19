package com.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.model.CalcModel;
import com.calculator.repository.CalcRepo;


@RestController
@CrossOrigin
public class CalcController {

	@Autowired
	CalcRepo calrepo;
	
	@PostMapping("/loan/save")
	public String saveLoan(@RequestBody CalcModel calData) {
		
		double arpValue;
		int principal=calData.getPrincipal();
		int rate=calData.getRate();
		int term=calData.getTerm();
		double interest;
		double fees;
		
		//calculating the interest
		interest=(principal*rate*term)/100;
		
		//calculating fees based on type
		switch(calData.getType()) {
		case "student":
			fees=0.00;
			break;
		case "auto":
			fees=500;
			break;
		case "personal":
			fees=750;
			break;
		case "mortgage":
			fees=1500;
			break;
		default:
			fees=0.00;
			break;
		}
		
		//calculating ARP
		arpValue=((((fees+interest)/principal)/term)*365)*100;
		String sValue = (String) String.format("%.2f", arpValue);
		Double arp = Double.parseDouble(sValue);
		 
		//updating the ARP value in the object 
		calData.setArp(arp);
		
		//saving the data 
		if(calrepo.save(calData)!=null)
			return "Saved Successfully";
		else
			return "Error while saving";
	}
	
	@GetMapping("/loan/get")
	public List<CalcModel> getLoan() {
		
		return calrepo.findAll();
	}
	
}
