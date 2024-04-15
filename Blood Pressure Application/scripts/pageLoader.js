/*
 * Author:   Amanda Martel
 * Date:     10/10/2020
 *
 * Filename: pageLoader.js
 * Program to get user information including first name, last name, birthdate, password, and health insurance number. 
 * Allows user to store records for blood pressure. Program will graph blood pressure vs date and preovide suggestions. 
 * Sources: Orginal code from textbook: Building Cross-Platform 
 * Mobile and Web Apps for Engineers and Scientists An Active Learning Approach. 
 * Pawan Lingras with Matt Triff and Rucha Lingras. Copyright 2017 Cengage Learning. 
 */


/*Runs the function to display the user information or records every time their div is shown
 */
 
 /* uses on attribute on "pageshow" id to load correct HTML page */
/* 
 * Function name: resizeGraph()
 * Purpose: resize the graph for the device 
 * Parameters: 
 * Called by: resize()
 * Calls: css(), width()
 */
function resizeGraph() {
  if ($(window).width() < 700) {
    $("#GraphCanvas").css({
      "width": $(window).width() - 50
    });
    $("#AdviceCanvas").css({
      "width": $(window).width() - 50
    });
  }
}

// Attach event handler for window resizing event
//Calls: resizeGraph()
$(window).resize(function () {
  resizeGraph();
});

/*Runs the function to display the user information, history,
 * graph or suggestions, every time their div is shown
 */
/* 
 * Function name: on()
 * Purpose: display proper page on load depending on active page  
 * Parameters: pageshow 
 * Called by: pageshow ID on ui-page-active. 
 * Calls: showUserForm(), loadUserInformation(), listRecords(), advicePage(), resizeGraph(), drawGraph()
 */
$(document).on("pageshow", function () {
  if ($('.ui-page-active').attr('id') ==
    "pageUserInfo") {
    showUserForm();
  } else if ($('.ui-page-active').attr('id') ==
    "pageRecords") {
    loadUserInformation();
    listRecords();
  } else if ($('.ui-page-active').attr('id') ==
    "pageAdvice") {
    advicePage();
    resizeGraph();
  } else if ($('.ui-page-active').attr('id') ==
    "pageGraph") {
    drawGraph();
    resizeGraph();
  }
});