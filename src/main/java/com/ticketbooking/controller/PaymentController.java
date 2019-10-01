package com.ticketbooking.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import com.ticketbooking.domain.PaytmDetails;
import com.ticketbooking.vo.Passenger;
import com.ticketbooking.vo.TravelersForm;

@Controller
public class PaymentController {
	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private PaytmDetails paytmDetails;
	
	/*testing 
	purpose*/
	@RequestMapping(value="/txnTest")
	public String getBase() {
		return "TxnTest";
	}
	
	/*testing 
		purpose*/
	@RequestMapping(value="/pgredirectTest")
	public ModelAndView getRedirect(@RequestParam(name="CUST_ID") String customerId,
			@RequestParam(name="TXN_AMOUNT") String transactionAmount,
			@RequestParam(name="ORDER_ID") String orderId) throws Exception {
		
		String redirectUrl = paytmDetails.getPaytmUrl()+"?ORDER_ID="+orderId;
		
		ModelAndView modelAndView = new ModelAndView("redirect:"+redirectUrl);
		TreeMap<String, String> parameters = new TreeMap<>();
		
		paytmDetails.getDetails().forEach((k,v)-> parameters.put(k, v));
		
		paytmDetails.getDetails().forEach((k,v) -> {
			System.out.println("key: "+ k + "  value: "+ v);	
		});
		
		parameters.put("MOBILE_NO","9876543210");
		parameters.put("EMAIL","test@gmail.com");
		parameters.put("ORDER_ID",orderId);
		parameters.put("TXN_AMOUNT",transactionAmount);
		parameters.put("CUST_ID",customerId);
		String checkSum =  getCheckSum(parameters);
		parameters.put("CHECKSUMHASH",checkSum);
		modelAndView.addAllObjects(parameters);
		return modelAndView;
	}
	
	@RequestMapping(value="/pgredirect")
	public ModelAndView getRedirect(
			@RequestParam(name="TXN_AMOUNT") String transactionAmount,
			ModelMap model, TravelersForm passengers) throws Exception {				
		
		logger.warn("---redirectUrl --- " + paytmDetails.getPaytmUrl());
		ModelAndView modelAndView = new ModelAndView("redirect:"+paytmDetails.getPaytmUrl());
		TreeMap<String, String> parameters = new TreeMap<>();
		paytmDetails.getDetails().forEach((k,v)-> parameters.put(k, v));
		parameters.put("MOBILE_NO",passengers.getPassengerContact().getMobile());
		parameters.put("EMAIL",passengers.getPassengerContact().getEmail());
		parameters.put("ORDER_ID",getOrderId());
		parameters.put("TXN_AMOUNT", transactionAmount);
		parameters.put("CUST_ID","CUS_001");				
		String checkSum =  getCheckSum(parameters);
		parameters.put("CHECKSUMHASH",checkSum);
		
		parameters.forEach((k,v) -> {
			logger.warn("key: "+ k + "  value: "+ v);	
		});
		
		modelAndView.addAllObjects(parameters);
		return modelAndView;
	}

	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return CheckSumServiceHelper.
				getCheckSumServiceHelper().
				genrateCheckSum(paytmDetails.getMerchantKey(), parameters);
	}
	
	@ResponseBody
	@RequestMapping(value="/pgresponse")
	public String getResponseRedirect(HttpServletRequest request) {
		
		Map<String, String[]> mapData = request.getParameterMap();
		TreeMap<String,String> parameters = new TreeMap<String,String>();
		mapData.forEach((key,val)-> parameters.put(key, val[0]));
		String paytmChecksum =  "";
		if(mapData.containsKey("CHECKSUMHASH"))
		{
			paytmChecksum = mapData.get("CHECKSUMHASH")[0];
		}
		String result;
		
		boolean isValideChecksum = false;
		try{
			isValideChecksum = validateCheckSum(parameters, paytmChecksum);
			if(isValideChecksum && parameters.containsKey("RESPCODE")){
				if(parameters.get("RESPCODE").equals("01")){
					result = parameters.toString();
				}else{
					result="<b>Payment Failed.</b>";
				}
			}else{
				result="<b>Checksum mismatched.</b>";
			}
		}catch(Exception e){
			result=e.toString();
		}
		return result;
	}

	private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		return CheckSumServiceHelper.
				getCheckSumServiceHelper().
				verifycheckSum(paytmDetails.getMerchantKey(),parameters,paytmChecksum);
	}
	
	private String getTransactionAmount(List<Passenger> passengers) throws Exception {
		
		double totalFare =0.0;
		
		for(int i=0; i<passengers.size(); i++)
		{
			totalFare += passengers.get(i).getSeat().getFare();
		}
		return String.valueOf(totalFare);
	}
	
	private String getOrderId() throws Exception {
		
		String orderId="ORD"+ new Random().nextInt(1000000);
		
		logger.info("ORDER_ID :::::: " + orderId);
		
		return orderId;
	}
}