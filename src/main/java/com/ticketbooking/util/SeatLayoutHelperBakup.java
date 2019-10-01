package com.ticketbooking.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.ticketbooking.util.SeatLayoutHelperBakup;
import com.websecure.zzzRefer.RedBus_seat_Item;

public class SeatLayoutHelperBakup {/*

	private static final Logger logger = LoggerFactory.getLogger(SeatLayoutHelperBakup.class);

	 @SuppressWarnings("unchecked")
	private String Redbus_BuildOnWordSeatsLayout_backup(List<RedBus_seat_Item> lstSeats, int totalcols, int totalRows)
     {
         StringBuilder stbhtml = new StringBuilder();
         StringBuilder zerotrow = new StringBuilder();
         StringBuilder firstrow = new StringBuilder();
         StringBuilder secoundtrow = new StringBuilder();
         StringBuilder thirdtrow = new StringBuilder();
         StringBuilder fourthtrow = new StringBuilder();
         try
         {
             if (lstSeats.size() > 0)
             {
                 List<RedBus_seat_Item> riSeater = null;
                 List<RedBus_seat_Item> riSleeper = null;

//                 if (!lstSeats.Where(a => a.length == "2").Any())                	 
                 if (!lstSeats.stream().filter(t -> t.getLength() == 2).findAny().isPresent())
                 {
//                     riSeater = lstSeats.Where(a => (a.width == "1" && a.length != "2") || (a.width != "2" && a.length != "2")).ToList();
                     riSeater = (List<RedBus_seat_Item>) lstSeats.stream().filter(t -> (t.getWidth() == 1 && t.getLength() != 2) || (t.getWidth() == 2 && t.getLength() != 2));
                 }
//                 if (lstSeats.Where(a => a.length == "2").Any())
                 if(lstSeats.stream().filter(t -> t.getLength() == 2).findAny().isPresent())
                 {
                     riSleeper = lstSeats;
                     //riSleeper = lstSeats.ToList();
                 }
//                 List<RedBus_seat_Item> rilength = lstSeats.Where(a => a.length == "2").ToList();
                 List<RedBus_seat_Item> rilength = lstSeats.stream().filter(a -> a.getLength() == 2).collect(Collectors.toList());
                 
                 //  [--  Seater -- ]

                 if (riSeater != null && riSeater.size() > 0 && rilength.size() == 0)
                 {
                     List<RedBus_seat_Item> riSeaterrow1 = null;
                     List<RedBus_seat_Item> riSeaterrow2 = null;
                     List<RedBus_seat_Item> riSeaterrow3 = null;
                     List<RedBus_seat_Item> riSeaterrow4 = null;
                     List<RedBus_seat_Item> riSeaterrow5 = null;
                     stbhtml.append(" <div class=\"drvrow ksrtcsleeper\"><img src=\"../assets/images/steering.png\"></div>");
                     stbhtml.append("<div class=\"passengers - seat\">");
                     stbhtml.append("<div class=\"table-responsive\">");
                     stbhtml.append("<table class=\"tblparent ksrtcsleeper\" border='0'><tr><td>");
//                     stbhtml.append("<table border='0'><tr><td colspan=" + riSeater.Select(y => y.row).Distinct().Count() + "></td></tr>");
                     stbhtml.append("<table border='0'><tr><td colspan=" + riSeater.stream().map(y -> y.getRow()).distinct().count() + "></td></tr>");
//                     if (riSeater.Select(y => y.row).Distinct().Count() > 0)
                     if (riSeater.stream().map(y-> y.getRow()).distinct().count() > 0)
                     {
//                         if (riSeater.Select(a => (a.row == "0")).Any())
                    	 if (riSeater.stream().map(a -> a.getRow() == 0).findAny().isPresent())
                         {
//                             if (riSeater.Select(a => (a.row == "0")).Count() > 0)
                    		 if (riSeater.stream().map(a -> a.getRow() == 0).count() > 0)
//                                 riSeaterrow1 = riSeater.Where(a => (a.row == "0")).OrderBy(x => Convert.ToInt32(x.column)).ToList();
                            	 riSeaterrow1 = riSeater.stream().filter(a -> a.getRow() == 0).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
//                                 objRedBus_seat_Itemlayout = riSeaterrow1[x];
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                 }
                                 else
                                 {
                                     stbhtml.append("<td><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSeater.Select(a => (a.row == "1")).Any())
                    	 if (riSeater.stream().map(a -> a.getRow() == 1).findAny().isPresent())	 
                         {
//                             if (riSeater.Select(a => (a.row == "1")).Count() > 0)
                             if (riSeater.stream().map(a -> a.getRow() == 1).count() > 0)
//                                 riSeaterrow2 = riSeater.Where(a => (a.row == "1")).OrderBy(x => Convert.ToInt32(x.column)).ToList();
                            	 riSeaterrow2 = riSeater.stream().filter(a -> a.getRow() == 1).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow2.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
//                                 objRedBus_seat_Itemlayout = riSeaterrow2[x];
                                 objRedBus_seat_Itemlayout = riSeaterrow2.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName()  + " value=" + objRedBus_seat_Itemlayout.getFare()  + "></td>");
                                 }
                                 else
                                 {
                                     stbhtml.append("<td ><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSeater.Select(a => (a.row == "2")).Any())
                    	 if (riSeater.stream().map(a -> a.getRow() == 2).findAny().isPresent())
                         {
//                             if (riSeater.Select(a => (a.row == "2")).Count() > 0)
                    		 if (riSeater.stream().map(a -> a.getRow() == 2).count() > 0)
//                                 riSeaterrow3 = riSeater.Where(a => (a.row == "2")).OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow3 = riSeater.stream().filter(a -> a.getRow() == 2).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow3.size(); x++)
                             {
                                 if (riSeaterrow3.size() == 1)
                                 {
                                     for (int y = 0; y < riSeaterrow1.size() - 1; y++)
                                     {
                                         stbhtml.append("<td style='width:52px;'>&nbsp;</td>");
                                     }
                                 }
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
//                                 objRedBus_seat_Itemlayout = riSeaterrow3[x];
                                 objRedBus_seat_Itemlayout = riSeaterrow3.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName()  + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare()  + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName()  + " value=" + objRedBus_seat_Itemlayout.getFare()  + "></td>");
                                 }
                                 else
                                 {
                                     stbhtml.append("<td ><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSeater.Select(a => (a.row == "3")).Any())
                    	 if (riSeater.stream().filter(a -> a.getRow() == 3).findAny().isPresent())
                         {
//                             if (riSeater.Select(a > (a.row == "3")).Count() > 0)
                    		 if (riSeater.stream().map(a -> a.getRow() == 3).count() > 0)
//                                 riSeaterrow4 = riSeater.Where(a => (a.row == "3")).OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow4 = riSeater.stream().filter(a -> a.getRow() == 3).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             int rowa = riSeaterrow1.size();
                             int rowd = riSeaterrow4.size();
                             for (int x = 0; x < riSeaterrow4.size(); x++)
                             {
                                 if (rowa > rowd)
                                 {
                                     stbhtml.append("<td style='width:50px;'>&nbsp;</td>");
                                     rowd = rowd + 1;
                                 }
                                 else
                                 {
                                     break;
                                 }
                             }
                             for (int x = 0; x < riSeaterrow4.size(); x++)
                             {



                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
//                                 objRedBus_seat_Itemlayout = riSeaterrow4[x];
                                 objRedBus_seat_Itemlayout = riSeaterrow4.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                 }
                                 else
                                 {
                                     stbhtml.append("<td style='width:50px;'><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }

                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSeater.Select(a => (a.row == "4")).Any())
                    	 if (riSeater.stream().map(a -> a.getRow() == 4).findAny().isPresent())
                         {
//                             if (riSeater.Select(a => (a.row == "4")).Count() > 0)
                    		 if (riSeater.stream().filter(a -> a.getRow() == 4).count() > 0)
//                                 riSeaterrow5 = riSeater.Where(a => (a.row == "4")).OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow5 = riSeater.stream().filter(a -> a.getRow() == 4).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             int rowa = riSeaterrow1.size();
                             int rowd = riSeaterrow5.size();
                             for (int x = 0; x < riSeaterrow5.size(); x++)
                             {
                                 if (rowa > rowd)
                                 {
                                     stbhtml.append("<td style='width:50px;'>&nbsp;</td>");
                                     rowd = rowd + 1;
                                 }
                                 else
                                 {
                                     break;
                                 }
                             }
                             for (int x = 0; x < riSeaterrow5.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
                                 objRedBus_seat_Itemlayout = riSeaterrow5.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                 }
                                 else
                                 {
                                     stbhtml.append("<td><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

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
//                 #endregion
//                 #region   [--  sleeper -- ]
                 if (riSleeper != null && riSleeper.size() > 0)
                 {
                     List<RedBus_seat_Item> riSeaterrow1 = null;
                     List<RedBus_seat_Item> riSeaterrow2 = null;
                     List<RedBus_seat_Item> riSeaterrow3 = null;
                     List<RedBus_seat_Item> riSeaterrow4 = null;
                     List<RedBus_seat_Item> riSeaterrow5 = null;
                     stbhtml.append(" <div class=\"drvrow ksrtcsleeper\"><img src=\"../assets/images/steering.png\"></div>");
                     stbhtml.append("<div class=\"passengers - seat\">");
                     stbhtml.append("<div class=\"table-responsive\">");
                     stbhtml.append("<div style=\"padding: 10px; border: solid 1px #ccc;margin-bottom: 10px;\"><table class=\"tblparent ksrtcsleeper\" border='0'><tr><td>");
//                     stbhtml.append("<table border='0'><tr><td style=\"border-bottom:double;\" colspan=" + riSleeper.Where(x => x.zindex == "0").Select(y => y.row).Distinct().Count() + ">Lower Berth</td></tr>");
                     stbhtml.append("<table border='0'><tr><td style=\"border-bottom:double;\" colspan=" + riSleeper.stream().filter(x -> x.getZindex() == 0).map(y -> y.getRow()).distinct().count() + ">Lower Berth</td></tr>");

//                     if (riSleeper.Select(y => y.row).Distinct().Count() > 0)
                     if (riSleeper.stream().map(y -> y.getRow()).distinct().count() > 0)
                     {
//                         if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "0")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(a -> a.getRow() == 0).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "0")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(a -> a.getRow() == 0).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "0")).Where(x => x.zindex == "0").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			   riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 0).filter(x -> x.getZindex() == 0).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                    			 stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
//                                 objRedBus_seat_Itemlayout = riSeaterrow1[x];
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
//                                 if (objRedBus_seat_Itemlayout.available.ToUpper() == "TRUE")
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td  class=\"blockedseatssleeper\" ><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength()  == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength()  == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {

//                                 if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "1")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 1).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "1")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(a -> a.getRow() == 1).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "1")).Where(x => x.zindex == "0").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 1).filter(x -> x.getZindex() == 0).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
//                                 objRedBus_seat_Itemlayout = riSeaterrow1[x];
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {

//                                 if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)	 
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "2")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 2).findAny() != null)
                         {
//                             if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "2")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 2).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "2")).Where(x => x.zindex == "0").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 2).filter(x -> x.getZindex() == 0).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 if (riSeaterrow1.size() == 1)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(i => i.zindex == "0").Select(a => (a.row == "1")).Count(); y++)
                                	 for (int y = 0; y < riSleeper.stream().filter(i -> i.getZindex() == 0).map(a -> a.getRow() == 1).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:50px;'>&nbsp;</td>");
                                     }
                                 }
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
//                                 objRedBus_seat_Itemlayout = riSeaterrow1[x];
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {

//                                 if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
                         else
                         {
//                             if (riSleeper.Where(x => x.zindex == "0").Where(x => x.length == "2").Any())
                        	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getLength() == 2).findAny().isPresent())
                             {
                                 stbhtml.append("<tr><td><table><tr>");
//                                 for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "1")).Count(); y++)
                                 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 1).count(); y++)
                                 {
                                     stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                 }
                                 stbhtml.append("</tr></table></td></tr>");
                             }
                         }
//                         if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "3")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 3).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "3")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 3).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "3")).Where(x => x.zindex == "0").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 3).filter(x -> x.getZindex() == 0).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
//                                 objRedBus_seat_Itemlayout = riSeaterrow1[x];
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {

//                                 if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0) 
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "4")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 4).findAny().isPresent())                       	
                         {
//                             if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "4")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 4).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "4")).Where(x => x.zindex == "0").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 4).filter(x -> x.getZindex() == 0).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
//                                 objRedBus_seat_Itemlayout = riSeaterrow1[x];
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {

//                                 if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "5")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 5).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "0").Select(a => (a.row == "5")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 0).map(a -> a.getRow() == 5).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "5")).Where(x => x.zindex == "0").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 5).filter(x -> x.getZindex() == 0).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 0)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {

//                                 if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "0").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 0).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
                     }
                     stbhtml.append("</table>");
                     stbhtml.append("</tr></table></div>");
                     ///---- upper birth
//                     stbhtml.append("<div style=\"padding: 10px; border: solid 1px #ccc;margin-bottom: 10px;\"><table border='0'><tr><td style=\"border-bottom:double; \" colspan=" + riSleeper.Where(x => x.zindex == "1").Select(y => y.row).Distinct().Count() + ">Upper Berth</td></tr>");
                     stbhtml.append("<div style=\"padding: 10px; border: solid 1px #ccc;margin-bottom: 10px;\"><table border='0'><tr><td style=\"border-bottom:double; \" colspan=" + riSleeper.stream().filter(x -> x.getZindex() == 1).map(y -> y.getRow()).distinct().count() + ">Upper Berth</td></tr>");  
//                     if (riSleeper.Select(y => y.row).Distinct().Count() > 0)
                     if (riSleeper.stream().map(y -> y.getRow()).distinct().count() > 0)
                     {
//                         if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "0")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 0).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "0")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 0).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "0")).Where(x => x.zindex == "1").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 0).filter(x -> x.getZindex() == 1).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {
//                                 if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }

                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "1")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 1).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "1")).Count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "1")).Where(x => x.zindex == "1").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 1).count() > 0)
                                 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 1).filter(x -> x.getZindex() == 1).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {
//                                 if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "1").Where(x =filter x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "2")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 2).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "2")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 2).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "2")).Where(x => x.zindex == "1").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 2).filter(x -> x.getZindex() == 1).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 if (riSeaterrow1.size() == 1)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(i => i.zindex == "1").Select(a => (a.row == "1")).Count(); y++)
                                	 for (int y = 0; y < riSleeper.stream().filter(i -> i.getZindex() == 1).map(a -> a.getRow() == 1).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:50px;'>&nbsp;</td>");
                                     }
                                 }
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {
//                                 if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
                         else
                         {
//                             if (riSleeper.Where(x => x.zindex == "1").Where(x => x.length == "2").Any())
                        	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getLength() == 2).findAny().isPresent())
                             {
                                 stbhtml.append("<tr><td><table><tr>");
//                                 for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "1")).Count(); y++)
                                 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 1).count(); y++)
                                 {
                                     stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                 }
                                 stbhtml.append("</tr></table></td></tr>");
                             }
                         }
//                         if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "3")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 3).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "3")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 3).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "3")).Where(x => x.zindex == "1").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 3).filter(x -> x.getZindex() == 1).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {
//                                 if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "4")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 4).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "4")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 4).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "4")).Where(x => x.zindex == "1").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 4).filter(x -> x.getZindex() == 1).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {
//                                 if (riSleeper.Where(x => x.zindex == 1).Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
                             }
                             stbhtml.append("</tr></table></td></tr>");
                         }
//                         if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "5")).Any())
                    	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 5).findAny().isPresent())
                         {
//                             if (riSleeper.Where(x => x.zindex == "1").Select(a => (a.row == "5")).Count() > 0)
                    		 if (riSleeper.stream().filter(x -> x.getZindex() == 1).map(a -> a.getRow() == 5).count() > 0)
//                                 riSeaterrow1 = riSleeper.Where(a => (a.row == "5")).Where(x => x.zindex == "1").OrderBy(x => Convert.ToInt32(x.column)).ToList();
                    			 riSeaterrow1 = riSleeper.stream().filter(a -> a.getRow() == 5).filter(x -> x.getZindex() == 1).sorted(Comparator.comparing(RedBus_seat_Item::getCol)).collect(Collectors.toList());
                             stbhtml.append("<tr><td><table><tr>");
                             for (int x = 0; x < riSeaterrow1.size(); x++)
                             {
                                 RedBus_seat_Item objRedBus_seat_Itemlayout = new RedBus_seat_Item();
                                 objRedBus_seat_Itemlayout = riSeaterrow1.get(x);
                                 if (objRedBus_seat_Itemlayout.isAvailable().toUpperCase() == "TRUE")
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseat\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/seat-available.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"availseatsleeper\" style=\"cursor:pointer;\"><image id=" + objRedBus_seat_Itemlayout.getName() + " src=\"../assets/images/available_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/><input type='hidden' name=" + objRedBus_seat_Itemlayout.getName() + " value=" + objRedBus_seat_Itemlayout.getFare() + "></td>");

                                 }
                                 else
                                 {
                                     if (objRedBus_seat_Itemlayout.getWidth() == 1 && objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/seat-booked.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 1 & objRedBus_seat_Itemlayout.getLength() == 2 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");
                                     else if (objRedBus_seat_Itemlayout.getWidth() == 2 & objRedBus_seat_Itemlayout.getLength() == 1 && objRedBus_seat_Itemlayout.getZindex() == 1)
                                         stbhtml.append("<td class=\"blockedseatssleeper\"><image id =" + objRedBus_seat_Itemlayout.getName() + " src =\"../assets/images/booked_sleeper.png\" data-toggle=\"tooltip\" data-placement=\"bottom\" title=\"seat: " + objRedBus_seat_Itemlayout.getName() + " | Fare: " + objRedBus_seat_Itemlayout.getFare() + " \" data-original-title=\"Tooltip on right\"/></td>");

                                 }
                             }
                             if (riSeaterrow1.size() == 0)
                             {
//                                 if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count() > 0)
                            	 if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "0").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 0).map(a -> a.getRow() == 0).count(); y++)	 
                                     {
                                         stbhtml.append("<td style='width:42px;'>&nbsp;</td>");
                                     }
                                 }
//                                 else if (riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count() > 0)
                            	 else if (riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count() > 0)
                                 {
//                                     for (int y = 0; y < riSleeper.Where(x => x.zindex == "1").Where(x => x.row == "1").Select(a => (a.row == "0")).Count(); y++)
                            		 for (int y = 0; y < riSleeper.stream().filter(x -> x.getZindex() == 1).filter(x -> x.getRow() == 1).map(a -> a.getRow() == 0).count(); y++)
                                     {
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
                 //#endregion   [--  sleeper -- ]                    



             }

         }
         catch (Exception ex)
         {
        	 logger.info(ex.getMessage());
             //LogData.Write("Transport", "BuildSeatsLayout", LogMode.Excep, ex.Message);

         }
         return stbhtml.toString();
     }
*/}
