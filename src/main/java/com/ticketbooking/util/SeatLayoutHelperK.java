package com.ticketbooking.util;

//for online compiler

//package com.websecure.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.multipart.MultipartFile;

//import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
//import com.websecure.domain.SeatLayout;
//import com.websecure.repository.SeatLayoutRepository;
//import com.websecure.domain.SeatLayout;
//import com.websecure.util.SeatLayoutHelper;

public class SeatLayoutHelperK {

	// length=1 and width=1 - seater
	// length=2 and width=1 - horizontal sleeper
	// length=1 and width=2 - vertical sleeper

	// Seat layout
	// 00 01
	// 10 11
	// private static final Logger logger =
	// LoggerFactory.getLogger(SeatLayoutHelper.class);

	// @Autowired
	// private SeatLayoutRepository seatLayoutRepository;
	// List<SeatLayout> busSeatLayout =
	// seatLayoutRepository.findSeatLayoutByBus(1);

	private static List<SeatLayout> list;

	static {
		// created required instances
		// create ur in-memory objects here
		list = new ArrayList<SeatLayout>();

		SeatLayout seatLayout1 = new SeatLayout();
		seatLayout1.setBus(1);
		seatLayout1.setName("1A");
		seatLayout1.setFare(500);
		seatLayout1.setLength(1);
		seatLayout1.setWidth(1);
		seatLayout1.setZindex(0);
		seatLayout1.setRow(0);
		seatLayout1.setCol(0);
		seatLayout1.setAvailable("TRUE");

		SeatLayout seatLayout2 = new SeatLayout();
		seatLayout2.setBus(1);
		seatLayout2.setName("2A");
		seatLayout2.setFare(500);
		seatLayout2.setLength(1);
		seatLayout2.setWidth(1);
		seatLayout2.setZindex(0);
		seatLayout2.setRow(0);
		seatLayout2.setCol(1);
		seatLayout2.setAvailable("TRUE");

		SeatLayout seatLayout3 = new SeatLayout();
		seatLayout3.setBus(1);
		seatLayout3.setName("B1");
		seatLayout3.setFare(500);
		seatLayout3.setLength(1);
		seatLayout3.setWidth(1);
		seatLayout3.setZindex(0);
		seatLayout3.setRow(1);
		seatLayout3.setCol(0);
		seatLayout3.setAvailable("TRUE");

		SeatLayout seatLayout4 = new SeatLayout();
		seatLayout4.setBus(1);
		seatLayout4.setName("B2");
		seatLayout4.setFare(500);
		seatLayout4.setLength(1);
		seatLayout4.setWidth(1);
		seatLayout4.setZindex(0);
		seatLayout4.setRow(1);
		seatLayout4.setCol(1);
		seatLayout4.setAvailable("TRUE");

		list.add(seatLayout1);
		list.add(seatLayout2);
		list.add(seatLayout3);
		list.add(seatLayout4);

	}

	public String Redbus_BuildOnWordSeatsLayout_backup(List<SeatLayout> lstSeats) {
		StringBuilder stbhtml = new StringBuilder();

		try {
			if (lstSeats.size() > 0) {
				List<SeatLayout> riSeater = null;
				List<SeatLayout> riSleeper = null;

				// if (!lstSeats.Where(a => a.length == "2").Any())
				// if (!seatLayoutRepository.findBusSeatLayoutByLength(2,
				// 1).contains(2))
				if (!lstSeats.stream().filter(t -> t.getLength() == 2).findAny().isPresent()) {
					// riSeater = lstSeats.Where(a => (a.width == "1" &&
					// a.length != "2") || (a.width != "2" && a.length !=
					// "2")).ToList();

					riSeater = lstSeats.stream().filter(
							t -> (t.getWidth() == 1 && t.getLength() != 2) || (t.getWidth() == 2 && t.getLength() != 2))
							.collect(Collectors.toList());

				}
				// if (lstSeats.Where(a => a.length == "2").Any())
				if (lstSeats.stream().filter(t -> t.getLength() == 2).findAny().isPresent()) {
					riSleeper = lstSeats;
					// riSleeper = lstSeats.ToList();
				}
				// List<SeatLayout> rilength = lstSeats.Where(a => a.length ==
				// "2").ToList();
				List<SeatLayout> rilength = lstSeats.stream().filter(a -> a.getLength() == 2)
						.collect(Collectors.toList());

				// [-- Seater -- ]

				if (riSeater != null && riSeater.size() > 0 && rilength.size() == 0) {
					List<SeatLayout> riSeaterrow1 = null;
					List<SeatLayout> riSeaterrow2 = null;
					List<SeatLayout> riSeaterrow3 = null;
					List<SeatLayout> riSeaterrow4 = null;
					List<SeatLayout> riSeaterrow5 = null;
					stbhtml.append(
							" <div class=\"drvrow ksrtcsleeper\"><img src=\"../assets/images/steering.png\"></div>");
					stbhtml.append("<div class=\"passengers - seat\">");
					stbhtml.append("<div class=\"table-responsive\">");
					stbhtml.append("<table class=\"tblparent ksrtcsleeper\" border='0'><tr><td>");
					// stbhtml.append("<table border='0'><tr><td colspan=" +
					// riSeater.Select(y => y.row).Distinct().Count() +
					// "></td></tr>");
					stbhtml.append("<table border='0'><tr><td colspan="
							+ riSeater.stream().map(y -> y.getRow()).distinct().count() + "></td></tr>");
					// if (riSeater.Select(y => y.row).Distinct().Count() > 0)
					if (riSeater.stream().map(y -> y.getRow()).distinct().count() > 0) {
						System.out.println("riSeater.stream().map(y -> y.getRow()).distinct().count() :: " + riSeater.stream().map(y -> y.getRow()).distinct().count());

						// if (riSeater.Select(a => (a.row == "0")).Any())
						if (riSeater.stream().map(a -> a.getRow() == 0).findAny().isPresent()) 
						{
							System.out.println("RISeater SIZE :: " + riSeater.size() + ", RISeater Row :: " + riSeater);
							for(int i=0; i < riSeater.size() ; i++)
							{
								System.out.println("ROW[" + i + "] : " + riSeater.get(i).getRow() + ", SeatNo : " + riSeater.get(i).getCol());
							}
							System.out.println("RISeater SIZE[0] :: " + riSeater.size() + ", RISeater Row :: " + riSeater);
							System.out.println("COUNT ROW 0:: " + riSeater.stream().filter(a -> a.getRow() != null && a.getRow() == 0).count());
							
							// if (riSeater.Select(a => (a.row == "0")).Count()
							// > 0)
							// if(riSeater.stream().map(a -> a.getRow() ==
							// 0).count() > 0)

							if (riSeater.stream().filter(a ->  a.getRow() == 0).count() > 0)	
								System.out.println("riSeater.stream().filter(a -> a.getRow() != null && a.getRow() == 0).count() > 0 :: " + riSeater.stream().filter(a -> a.getRow() != null && a.getRow() == 0).count());
								// riSeaterrow1 = riSeater.Where(a => (a.row ==
								// "0")).OrderBy(x =>
								// Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSeater.stream().filter(a -> a.getRow() == 0)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							if (riSeaterrow1 != null && !riSeaterrow1.isEmpty()) {
								for (int x = 0; x < riSeaterrow1.size(); x++) {
//									SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
									SeatLayout objRedBus_seat_Itemlayout = null;
									// objRedBus_seat_Itemlayout =
									// riSeaterrow1[x];
									System.out.println("riSeaterrow1.get(" + x + ") :: "+ riSeaterrow1.get(x));
									System.out.println("objRedBus_seat_Itemlayout :: " + objRedBus_seat_Itemlayout);
									objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
									if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									} else {
										stbhtml.append("<td><image id =" + objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}

						// if (riSeater.Select(a => (a.row == "1")).Any())
						if (riSeater.stream().map(a -> a.getRow() == 1).findAny().isPresent()) 
						{
							System.out.println(
									"ROW 1:: " + riSeater.stream().map(a -> a.getRow() == 1).findAny().isPresent());
							// if (riSeater.Select(a => (a.row == "1")).Count()
							// > 0)

							if (riSeater.stream().filter(a -> a.getRow() != null && a.getRow() == 1).count() > 0)
								// riSeaterrow2 = riSeater.Where(a => (a.row ==
								// "1")).OrderBy(x =>
								// Convert.ToInt32(x.column)).ToList();
								riSeaterrow2 = riSeater.stream().filter(a -> a.getRow() == 1)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							if (riSeaterrow2 != null && !riSeaterrow2.isEmpty()) {
								for (int x = 0; x < riSeaterrow2.size(); x++) {
									SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
									// objRedBus_seat_Itemlayout =
									// riSeaterrow2[x];
									objRedBus_seat_Itemlayout = riSeaterrow2.get(x);
									if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									} else {
										stbhtml.append("<td ><image id =" + objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSeater.Select(a => (a.row == "2")).Any())
						if (riSeater.stream().filter(a -> a.getRow() == 2).findAny().isPresent()) {//showing wrong output
							// if (riSeater.Select(a => (a.row == "2")).Count()
							// > 0)
							if (riSeater.stream().filter(a -> a.getRow() != null && a.getRow() == 2).count() > 0)
								// riSeaterrow3 = riSeater.Where(a => (a.row ==
								// "2")).OrderBy(x =>
								// Convert.ToInt32(x.column)).ToList();
								riSeaterrow3 = riSeater.stream().filter(a -> a.getRow() == 2)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							if (riSeaterrow3 != null && !riSeaterrow3.isEmpty()) {
								for (int x = 0; x < riSeaterrow3.size(); x++) {
									if (riSeaterrow3.size() == 1) {
										for (int y = 0; y < riSeaterrow1.size() - 1; y++) {
											stbhtml.append("<td style='width:52px;'>&nbsp;</td>");
										}
									}
									SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
									// objRedBus_seat_Itemlayout =
									// riSeaterrow3[x];
									objRedBus_seat_Itemlayout = riSeaterrow3.get(x);
									if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									} else {
										stbhtml.append("<td ><image id =" + objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSeater.Select(a => (a.row == "3")).Any())
						if (riSeater.stream().filter(a -> a.getRow() == 3).findAny().isPresent()) 
						{
							// if (riSeater.Select(a > (a.row == "3")).Count() >
							// 0)
							if (riSeater.stream().filter(a -> a.getRow() != null && a.getRow() == 3).count() > 0)
								// riSeaterrow4 = riSeater.Where(a => (a.row ==
								// "3")).OrderBy(x =>
								// Convert.ToInt32(x.column)).ToList();
								riSeaterrow4 = riSeater.stream().filter(a -> a.getRow() == 3)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							int rowa = riSeaterrow1.size();
							int rowd = riSeaterrow4.size();
							if (riSeaterrow4 != null && !riSeaterrow4.isEmpty()) {
								for (int x = 0; x < riSeaterrow4.size(); x++) {
									if (rowa > rowd) {
										stbhtml.append("<td style='width:50px;'>&nbsp;</td>");
										rowd = rowd + 1;
									} else {
										break;
									}
								}
								for (int x = 0; x < riSeaterrow4.size(); x++) {

									SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
									// objRedBus_seat_Itemlayout =
									// riSeaterrow4[x];
									objRedBus_seat_Itemlayout = riSeaterrow4.get(x);
									if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									} else {
										stbhtml.append("<td style='width:50px;'><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

									}

								}

							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSeater.Select(a => (a.row == "4")).Any())
						if (riSeater.stream().filter(a -> a.getRow() == 4).findAny().isPresent()) {
							// if (riSeater.Select(a => (a.row == "4")).Count()
							// > 0)
							if (riSeater.stream().filter(a -> a.getRow() == 4).count() > 0)
								// riSeaterrow5 = riSeater.Where(a => (a.row ==
								// "4")).OrderBy(x =>
								// Convert.ToInt32(x.column)).ToList();
								riSeaterrow5 = riSeater.stream().filter(a -> a.getRow() == 4)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							int rowa = riSeaterrow1.size();
							int rowd = riSeaterrow5.size();
							for (int x = 0; x < riSeaterrow5.size(); x++) {
								if (rowa > rowd) {
									stbhtml.append("<td style='width:50px;'>&nbsp;</td>");
									rowd = rowd + 1;
								} else {
									break;
								}
							}
							for (int x = 0; x < riSeaterrow5.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								objRedBus_seat_Itemlayout = riSeaterrow5.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
											+ objRedBus_seat_Itemlayout.getName()
											+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
											+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
											+ objRedBus_seat_Itemlayout.getFare()
											+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
											+ objRedBus_seat_Itemlayout.getName() + " value="
											+ objRedBus_seat_Itemlayout.getFare() + "></td>");
								} else {
									stbhtml.append("<td><image id =" + objRedBus_seat_Itemlayout.getName()
											+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
											+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
											+ objRedBus_seat_Itemlayout.getFare()
											+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							stbhtml.append("</tr></table></td></tr>");

						}
					}
					stbhtml.append("</table>");
					stbhtml.append("</tr></table>");
					stbhtml.append("</div>");
					stbhtml.append("</div>");
				}
				// #endregion
				// #region [-- sleeper -- ]
				if (riSleeper != null && riSleeper.size() > 0) {
					List<SeatLayout> riSeaterrow1 = null;
					List<SeatLayout> riSeaterrow2 = null;
					List<SeatLayout> riSeaterrow3 = null;
					List<SeatLayout> riSeaterrow4 = null;
					List<SeatLayout> riSeaterrow5 = null;
					stbhtml.append(
							" <div class=\"drvrow ksrtcsleeper\"><img src=\"../assets/images/steering.png\"></div>");
					stbhtml.append("<div class=\"passengers - seat\">");
					stbhtml.append("<div class=\"table-responsive\">");
					stbhtml.append(
							"<div style=\"padding: 10px; border: solid 1px #ccc;margin-bottom: 10px;\"><table class=\"tblparent ksrtcsleeper\" border='0'><tr><td>");
					// stbhtml.append("<table border='0'><tr><td
					// style=\"border-bottom:double;\" colspan=" +
					// riSleeper.Where(x => x.zindex == "0").Select(y =>
					// y.row).Distinct().Count() + ">Lower Berth</td></tr>");
					stbhtml.append("<table border='0'><tr><td style=\"border-bottom:double;\" colspan="
							+ riSleeper.stream().filter(x -> x.getZindex() == 0).map(y -> y.getRow()).distinct().count()
							+ ">Lower Berth</td></tr>");

					// if (riSleeper.Select(y => y.row).Distinct().Count() > 0)
					if (riSleeper.stream().map(y -> y.getRow()).distinct().count() > 0) {
						// if (riSleeper.Where(x => x.zindex == "0").Select(a =>
						// (a.row == "0")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(a -> a.getRow() == 0).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "0").Select(a => (a.row == "0")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(a -> a.getRow() == 0)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "0")).Where(x => x.zindex == "0").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 0)
										.filter(x -> x.getZindex() == 0)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								// objRedBus_seat_Itemlayout = riSeaterrow1[x];
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								// if
								// (objRedBus_seat_Itemlayout.available.ToUpper()
								// == "TRUE")
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td  class=\"blockedseatssleeper\" ><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {

								// if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSleeper.Where(x => x.zindex == "0").Select(a =>
						// (a.row == "1")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 1).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "0").Select(a => (a.row == "1")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(a -> a.getRow() == 1)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "1")).Where(x => x.zindex == "0").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 1)
										.filter(x -> x.getZindex() == 0)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								// objRedBus_seat_Itemlayout = riSeaterrow1[x];
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {

								// if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSleeper.Where(x => x.zindex == "0").Select(a =>
						// (a.row == "2")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 2)
								.findAny() != null) {
							// if (riSleeper.Where(x => x.zindex ==
							// "0").Select(a => (a.row == "2")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 2)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "2")).Where(x => x.zindex == "0").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 2)
										.filter(x -> x.getZindex() == 0)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								if (riSeaterrow1.size() == 1) {
									// for (int y = 0; y < riSleeper.Where(i =>
									// i.zindex == "0").Select(a => (a.row ==
									// "1")).Count(); y++)
									for (int y = 0; y < riSleeper.stream().filter(i -> i.getZindex() == 0)
											.map(a -> a.getRow() == 1).count(); y++) {
										stbhtml.append("<td style='width:50px;'>&nbsp;</td>");
									}
								}
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								// objRedBus_seat_Itemlayout = riSeaterrow1[x];
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {

								// if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						} else {
							// if (riSleeper.Where(x => x.zindex == "0").Where(x
							// => x.length == "2").Any())
							if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getLength() == 2)
									.findAny().isPresent()) {
								stbhtml.append("<tr><td><table><tr>");
								// for (int y = 0; y < riSleeper.Where(x =>
								// x.zindex == "0").Select(a => (a.row ==
								// "1")).Count(); y++)
								for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
										.map(a -> a.getRow() == 1).count(); y++) {
									stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
								}
								stbhtml.append("</tr></table></td></tr>");
							}
						}
						// if (riSleeper.Where(x => x.zindex == "0").Select(a =>
						// (a.row == "3")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 3).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "0").Select(a => (a.row == "3")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 3)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "3")).Where(x => x.zindex == "0").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 3)
										.filter(x -> x.getZindex() == 0)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								// objRedBus_seat_Itemlayout = riSeaterrow1[x];
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {

								// if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSleeper.Where(x => x.zindex == "0").Select(a =>
						// (a.row == "4")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 4).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "0").Select(a => (a.row == "4")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 4)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "4")).Where(x => x.zindex == "0").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 4)
										.filter(x -> x.getZindex() == 0)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								// objRedBus_seat_Itemlayout = riSeaterrow1[x];
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {

								// if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSleeper.Where(x => x.zindex == "0").Select(a =>
						// (a.row == "5")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 5).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "0").Select(a => (a.row == "5")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 5)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "5")).Where(x => x.zindex == "0").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 5)
										.filter(x -> x.getZindex() == 0)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 0)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {

								// if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "0").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "0").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
					}
					stbhtml.append("</table>");
					stbhtml.append("</tr></table></div>");
					/// ---- upper birth
					// stbhtml.append("<div style=\"padding: 10px; border: solid
					// 1px #ccc;margin-bottom: 10px;\"><table border='0'><tr><td
					// style=\"border-bottom:double; \" colspan=" +
					// riSleeper.Where(x => x.zindex == "1").Select(y =>
					// y.row).Distinct().Count() + ">Upper Berth</td></tr>");
					stbhtml.append(
							"<div style=\"padding: 10px; border: solid 1px #ccc;margin-bottom: 10px;\"><table border='0'><tr><td style=\"border-bottom:double; \" colspan="
									+ riSleeper.stream().filter(x -> x.getZindex() == 1).map(y -> y.getRow()).distinct()
											.count()
									+ ">Upper Berth</td></tr>");
					// if (riSleeper.Select(y => y.row).Distinct().Count() > 0)
					if (riSleeper.stream().map(y -> y.getRow()).distinct().count() > 0) {
						// if (riSleeper.Where(x => x.zindex == "1").Select(a =>
						// (a.row == "0")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 0).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "1").Select(a => (a.row == "0")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 0)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "0")).Where(x => x.zindex == "1").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 0)
										.filter(x -> x.getZindex() == 1)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {
								// if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}

							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSleeper.Where(x => x.zindex == "1").Select(a =>
						// (a.row == "1")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 1).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "1").Select(a => (a.row == "1")).Count() > 0)
							// riSeaterrow1 = riSleeper.Where(a => (a.row ==
							// "1")).Where(x => x.zindex == "1").OrderBy(x =>
							// Convert.ToInt32(x.column)).ToList();
							if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 1)
									.count() > 0)
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 1)
										.filter(x -> x.getZindex() == 1)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {
								// if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x =filter x.row == "1").Select(a
								// => (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSleeper.Where(x => x.zindex == "1").Select(a =>
						// (a.row == "2")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 2).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "1").Select(a => (a.row == "2")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 2)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "2")).Where(x => x.zindex == "1").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 2)
										.filter(x -> x.getZindex() == 1)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");

							for (int x = 0; x < riSeaterrow1.size(); x++) {
								if (riSeaterrow1.size() == 1) {
									// for (int y = 0; y < riSleeper.Where(i =>
									// i.zindex == "1").Select(a => (a.row ==
									// "1")).Count(); y++)
									for (int y = 0; y < riSleeper.stream().filter(i -> i.getZindex() == 1)
											.map(a -> a.getRow() == 1).count(); y++) {
										stbhtml.append("<td style='width:50px;'>&nbsp;</td>");
									}
								}
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {
								// if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						} else {
							// if (riSleeper.Where(x => x.zindex == "1").Where(x
							// => x.length == "2").Any())
							if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getLength() == 2)
									.findAny().isPresent()) {
								stbhtml.append("<tr><td><table><tr>");
								// for (int y = 0; y < riSleeper.Where(x =>
								// x.zindex == "1").Select(a => (a.row ==
								// "1")).Count(); y++)
								for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
										.map(a -> a.getRow() == 1).count(); y++) {
									stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
								}
								stbhtml.append("</tr></table></td></tr>");
							}
						}
						// if (riSleeper.Where(x => x.zindex == "1").Select(a =>
						// (a.row == "3")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 3).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "1").Select(a => (a.row == "3")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 3)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "3")).Where(x => x.zindex == "1").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 3)
										.filter(x -> x.getZindex() == 1)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {
								// if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSleeper.Where(x => x.zindex == "1").Select(a =>
						// (a.row == "4")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 4).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "1").Select(a => (a.row == "4")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 4)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "4")).Where(x => x.zindex == "1").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 4)
										.filter(x -> x.getZindex() == 1)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {
								// if (riSleeper.Where(x => x.zindex ==
								// 1).Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
						// if (riSleeper.Where(x => x.zindex == "1").Select(a =>
						// (a.row == "5")).Any())
						if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 5).findAny()
								.isPresent()) {
							// if (riSleeper.Where(x => x.zindex ==
							// "1").Select(a => (a.row == "5")).Count() > 0)
							if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 5)
									.count() > 0)
								// riSeaterrow1 = riSleeper.Where(a => (a.row ==
								// "5")).Where(x => x.zindex == "1").OrderBy(x
								// => Convert.ToInt32(x.column)).ToList();
								riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 5)
										.filter(x -> x.getZindex() == 1)
										.sorted(Comparator.comparing(SeatLayout::getCol)).collect(Collectors.toList());
							stbhtml.append("<tr><td><table><tr>");
							for (int x = 0; x < riSeaterrow1.size(); x++) {
								SeatLayout objRedBus_seat_Itemlayout = new SeatLayout();
								objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
								if (objRedBus_seat_Itemlayout.getAvailable().toUpperCase() == "TRUE") {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
												+ objRedBus_seat_Itemlayout.getName() + " value="
												+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append(
												"<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id="
														+ objRedBus_seat_Itemlayout.getName()
														+ " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
														+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
														+ objRedBus_seat_Itemlayout.getFare()
														+ " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name="
														+ objRedBus_seat_Itemlayout.getName() + " value="
														+ objRedBus_seat_Itemlayout.getFare() + "></td>");

								} else {
									if (objRedBus_seat_Itemlayout.getWidth() == 1
											&& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 1
											& objRedBus_seat_Itemlayout.getLength() == 2
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");
									else if (objRedBus_seat_Itemlayout.getWidth() == 2
											& objRedBus_seat_Itemlayout.getLength() == 1
											&& objRedBus_seat_Itemlayout.getZindex() == 1)
										stbhtml.append("<td class=\"blockedseatssleeper\"><image id ="
												+ objRedBus_seat_Itemlayout.getName()
												+ " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: "
												+ objRedBus_seat_Itemlayout.getName() + " | Fare: "
												+ objRedBus_seat_Itemlayout.getFare()
												+ " \" data-original-title=\"Tooltip on right\"/></td>");

								}
							}
							if (riSeaterrow1.size() == 0) {
								// if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "0").Select(a =>
								// (a.row == "0")).Count() > 0)
								if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "0").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
								// else if (riSleeper.Where(x => x.zindex ==
								// "1").Where(x => x.row == "1").Select(a =>
								// (a.row == "0")).Count() > 0)
								else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1)
										.map(a -> a.getRow() == 0).count() > 0) {
									// for (int y = 0; y < riSleeper.Where(x =>
									// x.zindex == "1").Where(x => x.row ==
									// "1").Select(a => (a.row == "0")).Count();
									// y++)
									for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1)
											.filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++) {
										stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
									}
								}
							}
							stbhtml.append("</tr></table></td></tr>");
						}
					}
					stbhtml.append("</table></div>");
					stbhtml.append("</div>");
					stbhtml.append("</div>");
				}
				// #endregion [-- sleeper -- ]

			}

		} catch (Exception ex) {
			ex.printStackTrace();
			// logger.info(ex.getMessage());
			// LogData.Write("Transport", "BuildSeatsLayout", LogMode.Excep,
			// ex.Message);

		}
		return stbhtml.toString();
	}

//	public static void main(String a[]) {
//		SeatLayoutHelperK msb = new SeatLayoutHelperK();
//		String result = msb.Redbus_BuildOnWordSeatsLayout_backup(list);
//
//		System.out.println("REEEE" + result);
//	}
}

class SeatLayout {

	private Integer id;

	private Integer bus;

	private String name;

	private Integer seatType;

	private Integer deck;

	private Integer totalSeats;

	private Integer layoutType;

	private Integer lastRowSeats;

	private Integer noOfSleeperSeats;

	private Integer row;

	private Integer col;

	private Integer length;

	private Integer width;

	private Integer zindex;

	private String seatNo;

	private Integer baseFare;

	private Integer fare;

	private Integer ladiesSeat;

	private String available;

	private Integer views;

	private Boolean status;

	private String createdBy;

	private String modifiedBy;

	private String createdDate;

	private String modifiedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBus() {
		return bus;
	}

	public void setBus(Integer bus) {
		this.bus = bus;
	}

	public Integer getSeatType() {
		return seatType;
	}

	public void setSeatType(Integer seatType) {
		this.seatType = seatType;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getLayoutType() {
		return layoutType;
	}

	public void setLayoutType(Integer layoutType) {
		this.layoutType = layoutType;
	}

	public Integer getLastRowSeats() {
		return lastRowSeats;
	}

	public void setLastRowSeats(Integer lastRowSeats) {
		this.lastRowSeats = lastRowSeats;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getNoOfSleeperSeats() {
		return noOfSleeperSeats;
	}

	public void setNoOfSleeperSeats(Integer noOfSleeperSeats) {
		this.noOfSleeperSeats = noOfSleeperSeats;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public Integer getDeck() {
		return deck;
	}

	public void setDeck(Integer deck) {
		this.deck = deck;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public Integer getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(Integer baseFare) {
		this.baseFare = baseFare;
	}

	public Integer getLadiesSeat() {
		return ladiesSeat;
	}

	public void setLadiesSeat(Integer ladiesSeat) {
		this.ladiesSeat = ladiesSeat;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getZindex() {
		return zindex;
	}

	public void setZindex(Integer zindex) {
		this.zindex = zindex;
	}

	// length=1 and width=1 - seater
	// length=2 and width=1 - horizontal sleeper
	// length=1 and width=2 - vertical sleeper
}
