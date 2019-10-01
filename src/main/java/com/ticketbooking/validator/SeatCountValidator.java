package com.ticketbooking.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ticketbooking.vo.TravelersForm;

@Component
public class SeatCountValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return TravelersForm.class.isAssignableFrom(clazz);
	}	

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		TravelersForm form = (TravelersForm) target;
		
		if(form.getPassengers().size() >6){
			ValidationUtils.rejectIfEmpty(errors, "name", "seat.count.error");
		}
	}

}
