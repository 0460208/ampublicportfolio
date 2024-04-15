/*
 * Author:   Amanda Martel
 * Date:     10/10/2020
 *
 * Filename: Navigation.js
 * Program to get user information including first name, last name, birthdate, password, and health insurance number. 
 * Allows user to store records for blood pressure. Program will graph blood pressure vs date and preovide suggestions. 
 * Sources: Orginal code from textbook: Building Cross-Platform 
 * Mobile and Web Apps for Engineers and Scientists An Active Learning Approach. 
 * Pawan Lingras with Matt Triff and Rucha Lingras. Copyright 2017 Cengage Learning. 
 */




 /* Name of function: addValueToPassword()
  * Purpose: adds value clicked to text input field 
  * Parameter: identified by id in HTML file. The button will be either a number or backspace.
  * Called by: .click attribute on each button with an id in the HTML file
  * Calls: .val()
  */
function addValueToPassword(button) {
  var currVal = $("#passcode").val();
  if (button == "bksp") {
    $("#passcode").val(currVal.substring(0,
      currVal.length - 1));
  } else {
    $("#passcode").val(currVal.concat(button));
  }
}


 /* Name of function: getPassword()
  * Purpose: get password from local storage, if none exists returns default password. 
  * Parameter: user
  * Called by: .click attribute on each button with an id in the HTML file
  * Calls: getItem(), parse()
  */
function getPassword() {
  if (typeof (Storage) == "undefined") {
    alert(
      "Your browser does not support HTML5 localStorage. Try upgrading."
    );
  } else if (localStorage.getItem("user") !=
    null) {
    return JSON.parse(localStorage.getItem(
      "user")).NewPassword;
  } else {
    /*Default password*/
    return "2345";
  }
}

 /* Name of function: ()
  * Purpose: to create password variable to call getPassword. 
  * Parameter: passcode, user, href, #pagemenu
  * Called by: .click attribute on each button with an id #btnEnter
  * Calls: getPassword(), getItem(), attr(), button()
  */
$("#btnEnter").click(function () {
  var password = getPassword();

  if (document.getElementById("passcode").value ==
    password) {
      if (localStorage.getItem("user") ==
        null) {
        /* User has not been created, direct user 
         * to User Creation page
         */
        $("#btnEnter").attr("href",
          "#pageUserInfo").button();
      } else {
        $("#btnEnter").attr("href",
          "#pageMenu").button();
      }
    
  } else {
    alert(
      "Incorrect password, please try again."
    );
  }
});

