package com.websecure.zzzRefer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author DELL
 *
 */
//@Entity
public class RedBusTicketSearch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

//	[Required(ErrorMessageResourceType = (typeof(ResourceMessages)), ErrorMessageResourceName = "Required_origin")]
//    [RegularExpression("[a-zA-Z\\s]+", ErrorMessageResourceType = (typeof(ResourceMessages)), ErrorMessageResourceName = "Invalid_origin")]
//    [Display(Name = "lbl_origin", ResourceType = typeof(ResourceTravels))]

	public String origin;
	
//	[Required(ErrorMessageResourceType = (typeof(ResourceMessages)), ErrorMessageResourceName = "Required_destination")]
//    [RegularExpression("[a-zA-Z\\s]+", ErrorMessageResourceType = (typeof(ResourceMessages)), ErrorMessageResourceName = "Invalid_destination")]
//    [Display(Name = "lbl_destination", ResourceType = typeof(ResourceTravels))]

	public String destination;
	
	public String day;
	
	public String month;
	
	public String year;
	
//	[Display(Name = "lbl_redBus_Ticket_Search", ResourceType = typeof(ResourceTravels))]

	public String lbl_redBus_Ticket_Search;

	// [Display(Name = "lbl_Please_enter_the_following_details", ResourceType =
	// typeof(ResourceTravels))]
	
	public String lbl_Please_enter_the_following_details;

//	[Display(Name = "lbl_Enter_Date_of_Journey", ResourceType = typeof(ResourceTravels))]

	public String lbl_Enter_Date_of_Journey;

	public String startid;
	
	public String wholedata;
	
	public String tripid;
	
	public String endid;

//	[Display(Name = "lbl_Journey_Details", ResourceType = typeof(ResourceTravels))]

	public String lbl_Journey_Details;
	
//	[Required(ErrorMessageResourceType = (typeof(ResourceMessages)), ErrorMessageResourceName = "Required_onwardDate")]
//	[Display(Name = "lbl_onwardDate", ResourceType = typeof(ResourceTravels))]

	public String onwardDate;
	
//	[Display(Name = "lbl_Modify_Search", ResourceType = typeof(ResourceTravels))]

	public String lbl_Modify_Search;
	
//	[Display(Name = "lbl_Search_Result", ResourceType = typeof(ResourceTravels))]

	public String lbl_Search_Result;
	
//	[Display(Name = "lbl_Please_select_below_required_service_type", ResourceType = typeof(ResourceTravels))]

	public String lbl_Please_select_below_required_service_type;
	
//	[Display(Name = "lbl_Travels_Name", ResourceType = typeof(ResourceTravels))]

	public String lbl_Travels_Name;
	
//	[Display(Name = "lbl_Travel_Time", ResourceType = typeof(ResourceTravels))]

	public String lbl_Travel_Time;
	
//	[Display(Name = "lbl_Fares", ResourceType = typeof(ResourceTravels))]

	public String lbl_Fares;

//	[Display(Name = "lbl_Dep_Time", ResourceType = typeof(ResourceTravels))]
	public String lbl_dep_time;
	
//	[Display(Name = "lbl_arr_time", ResourceType = typeof(ResourceTravels))]

	public String lbl_arr_time;
	
//	[Display(Name = "lbl_seats", ResourceType = typeof(ResourceTravels))]

//	public String lbl_seats;
	
//	[Display(Name = "lbl_Redbus_Note", ResourceType = typeof(ResourceTravels))]

	public String lbl_Redbus_Note;

//	[Display(Name = "lbl_Redbus_Ticket_Booking", ResourceType = typeof(ResourceTravels))]

	public String lbl_Redbus_Ticket_Booking;

//	[Display(Name = "lbl_Redbus_Select_Seat", ResourceType = typeof(ResourceTravels))]

	public String lbl_Redbus_Select_Seat;

//	[Display(Name = "lbl_Please_Select_Seats", ResourceType = typeof(ResourceTravels))]

	public String lbl_Please_Select_Seats;
	
//	[Display(Name = "lbl_Selected_Seats", ResourceType = typeof(ResourceTravels))]

	public String Selected_Seats;

//	[Display(Name = "lbl_pickuppoinrts", ResourceType = typeof(ResourceTravels))]

	public String lbl_Selected_dropingpoints;
	
	public String Selected_dropingpoints;
	
	public String fare;

	public String Return_Selected_Seats;


//	[Display(Name = "lbl_Available", ResourceType = typeof(ResourceTravels))]

	public String lbl_Available;
	
//	[Display(Name = "lbl_Selected", ResourceType = typeof(ResourceTravels))]

	public String lbl_Selected;
	
//	[Display(Name = "lbl_Booked", ResourceType = typeof(ResourceTravels))]

	public String lbl_Booked;
	
	public String ddldropingpoints;
	
	public String journey_up_down;
	
//	[Display(Name = "bus_type", ResourceType = typeof(ResourceTravels))]

	public String bus_type;
	
//	[Display(Name = "lbl_travels", ResourceType = typeof(ResourceTravels))]

	public String lbl_travels;
	
	public String cancellationpolicy;
	
	public String partialcancellationallowed;

	public String bplandmark;

	public String bpname;
	
	public String bpaddress;

	public String bpcontact;
	
	public String bplocation;

	public String blockid;
	
	public String combinedfarelist;

}