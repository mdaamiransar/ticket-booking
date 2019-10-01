<script>
portal.controller("REDBUSTicketSearchCtrl", function ($scope, $http) {
   
    $scope.generalfilters = [{ ctrl: "autofill", default: false, filltype: "dynamic", id: 4, isreadonly: false, key: "partner", name: "Partner", removeonchange: "", text: "", value: "" }];
    $scope.items = {};
    $("#origin").typeahead({
        hint: true,
        highlight: true,
        minLength: 3,
        source: function (srcCity, response) {
            response = LoadData(srcCity, response);
        },
        updater: function (item) {
            $('#origin').val(map[item].id);
            $('#startid').val(map[item].id);
            $('#lblError').html('');
            return item;
        }
    });

    $("#destination").typeahead({
        hint: true,
        highlight: true,
        minLength: 3,
        maxLength: 3,
        source: function (srcCity, response) {
            response = LoadData_DESTINATION(srcCity, response);
        },
        updater: function (item) {
            $('#destination').val(map[item].id);
            $('#endid').val(map[item].id);
            $('#lblError').html('');
            return item;
        }
    });

    $scope.dv_TicketBookingSearch = true;
    function LoadData(srcCity, response) {
        if (srcCity.length >= 3 && srcCity.length <= 6) {
             $("#startid").val("");
            $('#body_tag').loading({ theme: 'dark' });
            $http({
                url: 'Redbus_LoadCitiesDetails/Transport',
                type: 'GET',
                params: { cName: srcCity }
            }).then(function (res) {

                if (isHTML(res.data)) {
                    window.location.href = '../Home/Logout';
                    return;
                }

                var resData = res.data.root;

                if (resData.code == "0") {
                    items = [];
                    map = {};
                    if (resData.item != null) {
                        if (resData.item.length > 1) {
                            $.each(resData.item, function (i, item) {
                                var id = item.id;
                                var name = item.name;
                                map[name] = { id: id, name: name };
                                items.push(name);
                            });
                        }
                        else {
                            var id = resData.item.id;
                            var name = resData.item.name;
                            map[name] = { id: id, name: name };
                            items.push(name);
                        }
                    }

                    response(items);

                    $(".dropdown-menu").css("height", "auto");

                } else {
                    $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> ' + resData.desc + ' </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
                    $('html, body').animate({ scrollTop: 0 }, "slow");
                    //$scope.ErrorMsg = resData.desc;
                    $('#body_tag').loading('stop');
                }

                $('#body_tag').loading('stop');
            });
        }
    }

    function LoadData_DESTINATION(srcCity, response) {        
        if (srcCity.length >= 3 && srcCity.length <= 6) {
            $("#endid").val("");
                $('#body_tag').loading({ theme: 'dark' });
                $http({
                    url: 'Redbus_LoadCitiesDetails_destinations/Transport',
                    type: 'GET',
                    params: { cName: srcCity, sourcid: $('#startid').val() }
                }).then(function (res) {

                    if (isHTML(res.data)) {
                        window.location.href = '../Home/Logout';
                        return;
                    }

                    var resData = res.data.root;

                    if (resData.code == "0") {
                        items = [];
                        map = {};
                        if (resData.item != null) {
                            if (resData.item.length > 1) {
                                $.each(resData.item, function (i, item) {
                                    var id = item.id;
                                    var name = item.name;
                                    map[name] = { id: id, name: name };
                                    items.push(name);
                                });
                            }
                            else {
                                var id = resData.item.id;
                                var name = resData.item.name;
                                map[name] = { id: id, name: name };
                                items.push(name);
                            }
                        }

                        response(items);

                        $(".dropdown-menu").css("height", "auto");

                    } else {
                        $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> ' + resData.desc + ' </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
                        $('html, body').animate({ scrollTop: 0 }, "slow");
                        $('#body_tag').loading('stop');
                    }

                    $('#body_tag').loading('stop');
                });
            }       
        
    }
    var dt = new Date();
    var dd = dt.getDate();
    var mm = dt.getMonth();
    var yyy = dt.getFullYear();
    var endDt = new Date(yyy, mm + 1, dd);

    $('.RedBusDatePicker').datepicker({
        startDate: new Date(),
        format: "dd/mm/yyyy",
        autoclose: true,
        endDate: endDt
    }).datepicker("setDate", new Date(dt.getDate(), dt.getMonth(), dt.getFullYear()));
    $('.RedBusDatePicker').datepicker().datepicker("setDate", new Date());


    $scope.SearchData = function ($event) {

        var onwordDate = $('#onwardDate').val();       

        var selectedOnWardDT = $('#onwardDate').val();
        $('#day').val(selectedOnWardDT.split('/')[0]);
        $('#month').val(selectedOnWardDT.split('/')[1]);
        $('#year').val(selectedOnWardDT.split('/')[2]);
        $('#lblError').html('');
        if ($('#journeytype').val() != "" && $('#startid').val() != "" && $('#endid').val() != "" && $('#day').val() != "" && $('#month').val() != "" && $('#year').val() != "" && $('#origin').val() != "" && $('#destination').val() != "") {
            var startid = $('#startid').val();
            var endid = $('#endid').val();       
            var day = $('#day').val();
            var month = $('#month').val();
            var year = $('#year').val();
            if ($('#startid').val() != $('#endid').val()) {
                $('#body_tag').loading({ theme: 'dark' });
                $http({
                    url: 'Redbus_LoadSearchData/Travel',
                    type: 'GET',
                    params: { startid: startid, endid: endid, day: day, month: month, year: year }
                }).then(function (res) {
                    if (res == "-1") {
                        $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt">Dear User, currently we are unable to process your request. Please try after sometime.</div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
                        $('html, body').animate({ scrollTop: 0 }, "slow");
                        $('#body_tag').loading('stop');
                    }

                    if (isHTML(res.data)) {
                        window.location.href = '../Home/Logout';
                        return;
                    }

                    var ResData = [];
                    var resData = res.data.root;
                    if (resData.code == "0") {
                        $('#lblError').html('');
                        $scope.rowCount = resData.item.length;
                        ResData.push(resData.item);
                        if (ResData[0].length == undefined || ResData[0].length == 1) {
                            $scope.ticketBookList = ResData;
                        }
                        else {
                            $scope.ticketBookList = resData.item;
                        }

                        $scope.selectedDate = $('#onwardDate').val();
                        $scope.fromName = $('#origin').val();
                        $scope.toName = $('#destination').val();
                        $scope.dv_TicketBookingSearch = false;
                        $scope.dv_TicketOnwordBookingList = true;
                        $('#body_tag').loading('stop');
                    } else {
                        $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> ' + resData.desc + ' </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
                        $('html, body').animate({ scrollTop: 0 }, "slow");
                        $('#body_tag').loading('stop');
                    }
                });
                $event.preventDefault();
            }
            else {
                $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> Source and Destination should not be same. </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
                $('html, body').animate({ scrollTop: 0 }, "slow");
                $event.preventDefault();
            }
        } else {
            if ($('#startid').val() == "" || $('#endid').val() == "") {
                if ($('#startid').val() == "")
                {
                    $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt">please provide valid origin point </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
                    $('html, body').animate({ scrollTop: 0 }, "slow");
                }
            else{
                    $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> please provide valid destination point  </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
                    $('html, body').animate({ scrollTop: 0 }, "slow");
            }
                $event.preventDefault();
            }
        }
    }

    $scope.CheckOnwordSeatSelection = function ($event) {
      
        if ($scope.Selected_Seats != null && $scope.Selected_Seats != "") {
            if ($("#Selected_dropingpoints").val() == "") {
                $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> Please select pickup points </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
                $('html, body').animate({ scrollTop: 0 }, "slow");
                $event.preventDefault();
            }
            // get the farelist
            var pricelist=[];
            var seatlist = $("#Selected_Seats").val();
            var selectedSeatArryfinal = seatlist.slice(0, seatlist.length - 1).split(',')
            if(selectedSeatArryfinal.length>0)
            {
                for (var i = 0; i < selectedSeatArryfinal.length; i++)
                {
                    if(selectedSeatArryfinal[i] !="")
                    {
                        if (i == 0) {
                            pricelist.push($("input[name=" + selectedSeatArryfinal[i] + "]").val());
                        }
                        else {
                            pricelist.push("#" + $("input[name=" + selectedSeatArryfinal[i] + "]").val());
                        }
                    }
                }
                $("#combinedfarelist").val(pricelist.join(""));

            }
            else {
                pricelist.push("#" + $("input[name=" + seatlist + "]").val());
                $("#combinedfarelist").val(pricelist);
            }
           
        } else {
            $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> Please select  seats </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
            $('html, body').animate({ scrollTop: 0 }, "slow");
            $event.preventDefault();
        }
    }

    $scope.CheckSeatSelection = function ($event) {
        var totalNoOfSeatsCount = parseInt($('#nofseats').val());
        if ($scope.Selected_RoundTrip_Seats != null && $scope.Selected_RoundTrip_Seats != "") {
            var selectedSeats = $('#Return_Selected_Seats').val() + ',';
            var selectedSeatsArry;
            selectedSeatsArry = $('#Return_Selected_Seats').val().split(',');
            if (totalNoOfSeatsCount == selectedSeatsArry.length) {

            } else {
                $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> Please select ' + $('#nofseats').val() + ' seats </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
                $('html, body').animate({ scrollTop: 0 }, "slow");
                $event.preventDefault();
            }
        } else {
            $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> Please select ' + $('#nofseats').val() + ' seats </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>')
            $('html, body').animate({ scrollTop: 0 }, "slow");
            $event.preventDefault();
        }

    }

    
    $scope.modifySearch = function () {
        $('#lblError').html('');
        $scope.dv_TicketOnwordBookingList = false;
        $scope.dv_TicketBookingSearch = true;      
    }

    //#region Commented Code for Seat Layout
    //$scope.GetSeatLayout = function (serviceatId, servicetypeid, serviceId, busType, tripcode, adultfare, departuretime) {
    //    $('#serviceid').val(serviceId);
    //    $('#servicetypeid').val(servicetypeid);
    //    $('#concessionid').val('1466060086837'); $('#busType').val(busType);
    //    $('#tripcode').val(tripcode); $('#adultfare').val(adultfare); $('#departuretime').val(departuretime);
    //    $('#body_tag').loading({ theme: 'dark' });
    //    $http({
    //        url: 'GetSeatLayout/Travel',
    //        type: 'GET',
    //        params: { servicecatid: serviceatId, concessionid: '1466060086837', startplaceid: $('#startid').val(), endplaceid: $('#endid').val(), serviceid: serviceId, day: $('#day').val(), month: $('#month').val(), year: $('#year').val(), journeytype: $('#journeytype').val() }
    //    }).then(function (res) {
    //        if (typeof (res.data) == 'string') {
    //            //alert("Invalid server response");
    //            window.location.href = '../home/Logout';
    //            return;
    //        }

    //        var resData = res.data.root;
    //        if (resData.code == "0") {
    //            var allSeatsInfo = resData.item.allseatsinfo;
    //            var allSeatsInfoArray = allSeatsInfo.split('|');//Individual seats
    //            var htmlRaw = '';
    //            var columns = resData.item.columns;
    //            var rows = resData.item.rows;
    //            //Get All seat no in an Order                

    //            //1--> Seat No
    //            //,availSeat--> Seat Status
    //            //,0--> Sequiential Number
    //            //,3
    //            var rowCount = 1;
    //            htmlRaw += '<div class="row row1-1">';
    //            $.each(allSeatsInfoArray, function (index, value) {
    //                if (value != "") {

    //                    var IndividualSeatInfoArray = value.split(',');
    //                    var seatNo = IndividualSeatInfoArray[0];
    //                    var seatStatus = IndividualSeatInfoArray[1];
    //                    var seatSeqNo = IndividualSeatInfoArray[2];

    //                    if (seatStatus == 'availSeat') {
    //                        htmlRaw += '<span><a data-seatno="' + seatNo + '" href="#" class="available"></a></span>';
    //                    } else if (seatStatus == 'bookedSeat') {
    //                        htmlRaw += '<span><a data-seatno="' + seatNo + '" href="#" class="booked"></span>';
    //                    }
    //                    //Column Cal
    //                    if (index % parseInt(columns) == 0) {
    //                        htmlRaw += '</div><div class="row row1-' + rowCount + '">';
    //                        rowCount + 1;
    //                    }

    //                    if (rowCount == 3) {
    //                        htmlRaw += '<div class="row walking-row text-right"><span><a href="#" class="available"></a></span></div>';
    //                    }
    //                    //row Cal

    //                }
    //            });
    //            htmlRaw += '</div>';
    //            $('#passengersList').html(htmlRaw);

    //            //$scope.allseatsinfo = 
    //            $scope.columns = resData.item.columns;

    //            $scope.dv_TicketOnwordBookingList = false;
    //            $scope.dv_TicketBookingLayout = true;
    //            $scope.dv_SeatLayout = true;
    //            $('#body_tag').loading('stop');
    //        } else {
    //            $('#ErroMsg').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> ' + resData.desc + ' </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>');
    //            $('#body_tag').loading('stop');
    //        }

    //    });
    //}
    //#endregion

    $scope.BuildSeatLayout = function (tripid) {
        $('#passengersList').html('');         
        $('#body_tag').loading({ theme: 'dark' });
        $http({
            url: 'Redbus_BuildSeatLayout/Travel',
            type: 'GET',
            params: { tripid: tripid }
        }).then(function (res) {            

            var resData = res.data;
            if (resData.root != null) {
                $('#lblError').html('<div class="row marzero"><div class="col-lg-12 col-md-12 padzero mx-auto popcusalrt"><div class="alert alert-warning alert-dismissible fade show" role="alert"><div class="popmesimg"><img src="../assets/images/info_small.png"  alt="success"/></div><div class="popmestxt"> ' + resData.root.desc + ' </div><div class="clearfix"></div><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div></div></div>');
                $('html, body').animate({ scrollTop: 0 }, "slow");
                $('#body_tag').loading('stop');
            } else {
                if (res.data == "-1") {
                    $('#body_tag').loading('stop');
                }
                else {
                    $('#passengersList').html(res.data);
                    $scope.dv_TicketOnwordBookingList = false;
                    $scope.dv_TicketBookingLayout = true;
                    $scope.dv_TicketRoundTripBookingList = false;
                    $scope.li_Back = true;
                    $scope.dv_SeatLayout = true;
                    $('[data-toggle="tooltip"]').tooltip();
                    $('#body_tag').loading('stop');
                    checkOnwordSeatSelection();
                    checkOnwordBearthSelection();
                   
                }
            }

            
        });
    }


    $scope.rowClick = function (rowData) {
        $scope.classdesc = rowData.classdesc;
        $scope.tripcode = rowData.tripcode;
        $scope.Travel = rowData.travels
        $scope.bustype = rowData.bustype
        $("#tripid").val(rowData.id);
        $("#journey_up_down").val($('#origin').val() + "-" + $('#destination').val());
        $("#bus_type").val(rowData.bustype)
        $("#lbl_arr_time").val(rowData.arrivaltime)
        $("#lbl_Travels_Name").val(rowData.travels)

        $("#cancellationpolicy").val(rowData.cancellationpolicy)
        $("#partialcancellationallowed").val(rowData.partialcancellationallowed)
     //   $("#blockid").val(rowData.)
        $scope.JournyFromDate = $('#onwardDate').val();
        $scope.dropingpoints_redbus = rowData.boardingtimes
   
        $scope.BuildSeatLayout(rowData.id)
        
        // $scope.GetSeatLayout(rowData.servicecatid, rowData.servicetypeid, rowData.serviceid, rowData.classdesc, rowData.tripcode, rowData.adultfare, rowData.departuretime)

    }



    var selectedSeatlist = '';
    var returnselectedSeatlist = '';
    var selectedSeatCount = 0;
    var selectedSeat = '';
    var selectedSeatArry;
    var individualfare;
    var selectedSeatfare;
    var fare = '';
    var farelist = '';
    var coutofseat;
    //Chair Seat Selection for Onword
    function checkOnwordSeatSelection() {
    
        $('.availseat').on('click', function () {
            $('#lblError').html('');
            //get the class of the td
            if ($(this)[0].className == "availseat") {
                var blockedcount = $('.blockedseats')
                if (blockedcount.length == 6) {
                    var currentarray = selectedSeatArry.length;
                    var firstelement = selectedSeatArry[0];
                    if ($("#" + firstelement).parent().attr("class") == "blockedseats" && $("#" + firstelement).attr('src').indexOf("selectedsleeper.png") > -1) {
                        $("#" + firstelement).attr('src', '../assets/images/available_sleeper.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseatsleeper');
                    }
                    else if ($("#" + firstelement).parent().attr("class") == "blockedseats" && $("#" + firstelement).attr('src').indexOf("sleeperseatselected.png") > -1) {
                        $("#" + firstelement).attr('src', '../assets/images/sleeperseatavailable.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseat');
                    }
                    else if ($("#" + firstelement).parent().attr("class") == "blockedseats" && $("#" + firstelement).attr('src').indexOf("selectedsleeper1.png") > -1) {
                        $("#" + firstelement).attr('src', '../assets/images/availablesleeper1.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseat');
                    }
                    else {
                        $("#" + firstelement).attr('src', '../assets/images/seat-available.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseat');
                    }
                    fare = $("input[name=" + firstelement + "]").val();
                  //  individualfare = $("input[name=" + firstelement + "]").val() + ',';
                    farelist = (parseFloat(farelist) - parseFloat(fare)).toFixed(2);
                    $scope.Selected_Seats_fare = farelist.toString();                    
                    //remove(selectedSeatfare, individualfare);
                    remove(selectedSeatArry,firstelement);
                    selectedSeatCount--;
                    if (selectedSeatArry.length == 1) {

                        selectedSeatlist = selectedSeatArry.toString();
                        $scope.Selected_Seats = selectedSeatlist;
                    }
                    else {


                        selectedSeatlist = selectedSeatArry.toString();
                        $scope.Selected_Seats = selectedSeatlist;
                    }
                    //if ((currentarray.length-1)== selectedSeatArry.length)
                    //{
                        selectedSeat = $(this).find('img').attr('id') + ',';
                        fare = $(this).find('input').val();
                    // $(this).find('img').attr('src', '../assets/images/seat-selected.png');
                        if ($(this).find('img').attr('src').indexOf("sleeperseatavailable.png") > -1) {
                            $(this).find('img').attr('src', '../assets/images/sleeperseatselected.png');
                        }
                        else {
                            $(this).find('img').attr('src', '../assets/images/seat-selected.png');
                        }
                        $(this).removeClass('availseat').addClass('blockedseats');
                        $(this).css('cursor', 'auto');
                        selectedSeatlist += selectedSeat;
                        if (farelist == "") {
                            farelist = parseFloat(fare);
                        }
                        else {
                            farelist = (parseFloat(farelist) + parseFloat(fare)).toFixed(2);
                        }
                        selectedSeatCount++;
                        $scope.Selected_Seats = selectedSeatlist
                        $scope.Selected_Seats_fare = farelist.toString();
                        if (selectedSeatCount == 1) {
                            selectedSeatArry = selectedSeatlist;

                        }
                        {
                            selectedSeatArry = selectedSeatlist.split(',');
                        }
                    //}

                }
                else {
                    selectedSeat = $(this).find('img').attr('id') + ',';
                    fare = $(this).find('input').val();
                    if ($(this).find('img').attr('src').indexOf("sleeperseatavailable.png") > -1) {
                        $(this).find('img').attr('src', '../assets/images/sleeperseatselected.png');
                    }
                    else
                    {
                        $(this).find('img').attr('src', '../assets/images/seat-selected.png');
                    }
                   
                    $(this).removeClass('availseat').addClass('blockedseats');
                    $(this).css('cursor', 'auto');
                    selectedSeatlist += selectedSeat;
                    if (farelist == "") {
                        farelist = parseFloat(fare);
                    }
                    else {
                        farelist = (parseFloat(farelist) + parseFloat(fare)).toFixed(2);
                    }
                    selectedSeatCount++;
                    $scope.Selected_Seats = selectedSeatlist
                    $scope.Selected_Seats_fare = farelist.toString();
                    if (selectedSeatCount == 1) {
                        selectedSeatArry = selectedSeatlist;

                    }
                    {
                        selectedSeatArry = selectedSeatlist.split(',');
                    }
                }
             
            }
            else {
                var BlockedSeats = $('.blockedseats');
                if ($(this).find('img').attr('src').indexOf("sleeperseatselected.png") > -1)
                {
                    $(this).find('img').attr('src', '../assets/images/sleeperseatavailable.png');
                }
                else {
                    $(this).find('img').attr('src', '../assets/images/seat-available.png');
                }
              
                $(this).removeClass('blockedseats').addClass('availseat');
                    fare = $(this).find('input').val();
                    farelist = (parseFloat(farelist) - parseFloat(fare)).toFixed(2);
                    $scope.Selected_Seats_fare = farelist.toString();
                  
                    remove(selectedSeatArry, $(this).find('img').attr('id'));
                    selectedSeatCount--;
                if (selectedSeatArry.length == 1)
                {

                    selectedSeatlist = selectedSeatArry.toString();
                    $scope.Selected_Seats = selectedSeatlist;
                }
                else
                {
              

                    selectedSeatlist = selectedSeatArry.toString();
                    $scope.Selected_Seats = selectedSeatlist;
                }
            }    
            $('#fare').val($scope.Selected_Seats_fare)
            $('#Selected_Seats').val($scope.Selected_Seats);
            var tempseleted = $scope.Selected_Seats;
            tempseleted = tempseleted.substring(0, tempseleted.length - 1);
            $scope.Selected_Seats = tempseleted;
                $scope.$apply(); 
        })
    }
    $scope.onchangedroping = function (ddpoint) {
        $("#Selected_dropingpoints").val(ddpoint);
        $('#lblError').html('');
    }
    //Bearth Selection for Onword
    function checkOnwordBearthSelection() {
     
        $('.availseatsleeper').on('click', function () {
            $('#lblError').html('');
            //get the class of the td
            if ($(this)[0].className == "availseatsleeper") {
                var blockedcount =   $('.blockedseats').length 
                if (blockedcount == 6) {
                    var currentarray = selectedSeatArry.length;
                    var firstelement = selectedSeatArry[0];
                    if ($("#" + firstelement).parent().attr("class") == "blockedseats" && $("#" + firstelement).attr('src').indexOf("selectedsleeper.png") > -1) {
                        $("#" + firstelement).attr('src', '../assets/images/available_sleeper.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseatsleeper');

                    }
                    else if ($("#" + firstelement).parent().attr("class") == "blockedseats" && $("#" + firstelement).attr('src').indexOf("selectedsleeper1.png") > -1) {
                        $("#" + firstelement).attr('src', '../assets/images/availablesleeper1.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseat');
                    }
                    else if ($("#" + firstelement).parent().attr("class") == "blockedseats" && $("#" + firstelement).attr('src').indexOf("sleeperseatselected.png") > -1) {
                        $("#" + firstelement).attr('src', '../assets/images/sleeperseatavailable.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseat');
                    }
                    else {
                        $("#" + firstelement).attr('src', '../assets/images/seat-available.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseat');
                    }
                    fare = $("input[name=" + firstelement + "]").val();
                    //  individualfare = $("input[name=" + firstelement + "]").val() + '#,';
                    farelist = (parseFloat(farelist) - parseFloat(fare));
                    $scope.Selected_Seats_fare = farelist.toString();
                    //remove(selectedSeatfare, individualfare);
                    remove(selectedSeatArry, firstelement);
                    selectedSeatCount--;
                    if (selectedSeatArry.length == 1) {

                        selectedSeatlist = selectedSeatArry.toString();
                        $scope.Selected_Seats = selectedSeatlist;
                    }
                    else {


                        selectedSeatlist = selectedSeatArry.toString();
                        $scope.Selected_Seats = selectedSeatlist;
                    }
                    //if ((currentarray.length-1)== selectedSeatArry.length)
                    //{
                    selectedSeat = $(this).find('img').attr('id') + ',';
                    fare = $(this).find('input').val();
                    if ($(this).find('img').attr('src').indexOf("availablesleeper1.png") > -1) {
                        $(this).find('img').attr('src', '../assets/images/selectedsleeper1.png');
                    }
                    else {
                        $(this).find('img').attr('src', '../assets/images/selectedsleeper.png');
                    }
                  
                    $(this).removeClass('availseatsleeper').addClass('blockedseats');
                    $(this).css('cursor', 'auto');
                    selectedSeatlist += selectedSeat;
                    if (farelist == "") {
                        farelist = parseFloat(fare);
                    }
                    else {
                        farelist = (parseFloat(farelist) + parseFloat(fare));
                    }
                    selectedSeatCount++;
                    $scope.Selected_Seats = selectedSeatlist
                    $scope.Selected_Seats_fare = farelist.toString();
                    if (selectedSeatCount == 1) {
                        selectedSeatArry = selectedSeatlist;

                    }
                    {
                        selectedSeatArry = selectedSeatlist.split(',');
                    }
                    //}

                }
                else {
                    selectedSeat = $(this).find('img').attr('id') + ',';
                    fare = $(this).find('input').val();
                    if ($(this).find('img').attr('src').indexOf("availablesleeper1.png") > -1) {
                        $(this).find('img').attr('src', '../assets/images/selectedsleeper1.png');
                    }
                    else {
                        $(this).find('img').attr('src', '../assets/images/selectedsleeper.png');
                    }
                    $(this).removeClass('availseatsleeper').addClass('blockedseats');
                    $(this).css('cursor', 'auto');
                    selectedSeatlist += selectedSeat;
                    if (farelist == "") {
                        farelist = parseFloat(fare);
                    }
                    else {
                        farelist = (parseFloat(farelist) + parseFloat(fare));
                    }
                    selectedSeatCount++;
                    $scope.Selected_Seats = selectedSeatlist
                    $scope.Selected_Seats_fare = farelist.toString();
                    if (selectedSeatCount == 1) {
                        selectedSeatArry = selectedSeatlist;

                    }
                    {
                        selectedSeatArry = selectedSeatlist.split(',');
                    }
                }

            }
            else {
                var BlockedSeats = $('.blockedseats');
                if ($(this).find('img').attr('src').indexOf("availablesleeper1.png") > -1) {
                    $(this).find('img').attr('src', '../assets/images/selectedsleeper1.png');
                }
                else {
                    $(this).find('img').attr('src', '../assets/images/available_sleeper.png');
                }
                $(this).removeClass('blockedseats').addClass('availseatsleeper');
                fare = $(this).find('input').val();
                farelist = (parseFloat(farelist) - parseFloat(fare));
                $scope.Selected_Seats_fare = farelist.toString();

                remove(selectedSeatArry, $(this).find('img').attr('id'));
                selectedSeatCount--;
                if (selectedSeatArry.length == 1) {

                    selectedSeatlist = selectedSeatArry.toString();
                    $scope.Selected_Seats = selectedSeatlist;
                }
                else {


                    selectedSeatlist = selectedSeatArry.toString();
                    $scope.Selected_Seats = selectedSeatlist;
                }
            }
            $('#fare').val($scope.Selected_Seats_fare)
            $('#Selected_Seats').val($scope.Selected_Seats);
            var tempseleted = $scope.Selected_Seats;
            tempseleted = tempseleted.substring(0, tempseleted.length - 1);
            $scope.Selected_Seats = tempseleted;
            $scope.$apply();
        })
    }

    function checkOnwordSeatSelection_sleeper_seat() {
 
        $('.availseat').on('click', function () {
            $('#lblError').html('');
            //get the class of the td
            if ($(this)[0].className == "availseat") {
                var blockedcount = $('.blockedseats')
                if (blockedcount.length == 6) {
                    var currentarray = selectedSeatArry.length;
                    var firstelement = selectedSeatArry[0];
                    if ($("#" + firstelement).parent().attr("class") == "blockedseats" && $("#" + firstelement).attr('src').indexOf("selectedsleeper.png") > -1) {
                        $("#" + firstelement).attr('src', '../assets/images/available_sleeper.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseatsleeper');
                    }
                    else if ($("#" + firstelement).parent().attr("class") == "blockedseats" && $("#" + firstelement).attr('src').indexOf("sleeperseatselected.png") > -1) {
                        $("#" + firstelement).attr('src', '../assets/images/sleeperseatavailable.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseat');
                    }
                    else {
                        $("#" + firstelement).attr('src', '../assets/images/seat-available.png');
                        $("#" + firstelement).parent().removeClass('blockedseats').addClass('availseat');
                    }
                    fare = $("input[name=" + firstelement + "]").val();
                    //  individualfare = $("input[name=" + firstelement + "]").val() + ',';
                    farelist = (parseFloat(farelist) - parseFloat(fare)).toFixed(2);
                    $scope.Selected_Seats_fare = farelist.toString();
                    //remove(selectedSeatfare, individualfare);
                    remove(selectedSeatArry, firstelement);
                    selectedSeatCount--;
                    if (selectedSeatArry.length == 1) {

                        selectedSeatlist = selectedSeatArry.toString();
                        $scope.Selected_Seats = selectedSeatlist;
                    }
                    else {


                        selectedSeatlist = selectedSeatArry.toString();
                        $scope.Selected_Seats = selectedSeatlist;
                    }
                    //if ((currentarray.length-1)== selectedSeatArry.length)
                    //{
                    selectedSeat = $(this).find('img').attr('id') + ',';
                    fare = $(this).find('input').val();
                    $(this).find('img').attr('src', '../assets/images/sleeperseatselected.png');
                    $(this).removeClass('availseat').addClass('blockedseats');
                    $(this).css('cursor', 'auto');
                    selectedSeatlist += selectedSeat;
                    if (farelist == "") {
                        farelist = parseFloat(fare);
                    }
                    else {
                        farelist = (parseFloat(farelist) + parseFloat(fare)).toFixed(2);
                    }
                    selectedSeatCount++;
                    $scope.Selected_Seats = selectedSeatlist
                    $scope.Selected_Seats_fare = farelist.toString();
                    if (selectedSeatCount == 1) {
                        selectedSeatArry = selectedSeatlist;

                    }
                    {
                        selectedSeatArry = selectedSeatlist.split(',');
                    }
                    //}

                }
                else {
                    selectedSeat = $(this).find('img').attr('id') + ',';
                    fare = $(this).find('input').val();
                    $(this).find('img').attr('src', '../assets/images/sleeperseatselected.png');
                    $(this).removeClass('availseat').addClass('blockedseats');
                    $(this).css('cursor', 'auto');
                    selectedSeatlist += selectedSeat;
                    if (farelist == "") {
                        farelist = parseFloat(fare);
                    }
                    else {
                        farelist = (parseFloat(farelist) + parseFloat(fare)).toFixed(2);
                    }
                    selectedSeatCount++;
                    $scope.Selected_Seats = selectedSeatlist
                    $scope.Selected_Seats_fare = farelist.toString();
                    if (selectedSeatCount == 1) {
                        selectedSeatArry = selectedSeatlist;

                    }
                    {
                        selectedSeatArry = selectedSeatlist.split(',');
                    }
                }

            }
            else {
                var BlockedSeats = $('.blockedseats');
                $(this).find('img').attr('src', '../assets/images/sleeperseatavailable.png');
                $(this).removeClass('blockedseats').addClass('availseat');
                fare = $(this).find('input').val();
                farelist = (parseFloat(farelist) - parseFloat(fare)).toFixed(2);
                $scope.Selected_Seats_fare = farelist.toString();

                remove(selectedSeatArry, $(this).find('img').attr('id'));
                selectedSeatCount--;
                if (selectedSeatArry.length == 1) {

                    selectedSeatlist = selectedSeatArry.toString();
                    $scope.Selected_Seats = selectedSeatlist;
                }
                else {


                    selectedSeatlist = selectedSeatArry.toString();
                    $scope.Selected_Seats = selectedSeatlist;
                }
            }
            $('#fare').val($scope.Selected_Seats_fare)
            $('#Selected_Seats').val($scope.Selected_Seats);
            var tempseleted = $scope.Selected_Seats;
            tempseleted = tempseleted.substring(0, tempseleted.length - 1);
            $scope.Selected_Seats = tempseleted;
            $scope.$apply();
        })
    }

    function remove(array, element) {
        const index = array.indexOf(element);

        if (index !== -1) {
            array.splice(index, 1);
        }
    }


});
</script>