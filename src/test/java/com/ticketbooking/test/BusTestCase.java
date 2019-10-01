package com.ticketbooking.test;

//import static org.junit.Assert.assertEquals;

//import java.util.Calendar;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;

//import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.authentication.TestingAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
//import org.tesolin.crossover.entity.Flight;
//import org.tesolin.crossover.entity.FlightTicket;
//import org.tesolin.crossover.service.FlightService;
//import org.tesolin.crossover.service.TicketService;

import com.ticketbooking.TicketBookingApplication;
import com.ticketbooking.repository.BusRepository;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
//@SpringApplicationConfiguration(classes = AirTicketReservationSystemApplication.class) //removed in 1.5 RELEASE
@SpringBootTest(classes = TicketBookingApplication.class) //removed in 1.5 RELEASE
@WebAppConfiguration


public class BusTestCase {
	
	@Autowired
	private BusRepository busRepository;
	
	@Test
	public void testFindSeatLayoutByBus() {
		
		Assert.assertEquals("Something went wrong while fetching the list of products!", 3, busRepository.findActiveBus(true).size());
	}
	
//	@Autowired
//	private TicketService ticketService;
//	
//	private final Date dateFrom = DateUtils.round(DateUtils.addDays(new Date(), 1),Calendar.DATE);
//	private final Date dateTo = DateUtils.round(DateUtils.addDays(new Date(), 2),Calendar.DATE);
//	
//	@Test
//	public void testSearchFlight() {
//		Map<String, Collection<Flight>> searchFlights = flightService.searchFlights(1, 2, dateFrom, dateTo);
//		Assert.assertFalse("Search Flights", searchFlights.isEmpty());
//	}
//	
//	@Test
//	public void testBookFlight() {
//		Map<String, Collection<Flight>> searchFlights = flightService.searchFlights(1, 2, dateFrom, dateTo);
//		
//		Flight flight = searchFlights.get("oneway").iterator().next();
//		
//		SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken("user","credential"));
//		
//		Collection<FlightTicket> bookFlight = ticketService.bookFlight(flight.getId(), null, 1, 0, 0);
//		Assert.assertFalse("Search Flights", bookFlight.isEmpty());
//	}

}
