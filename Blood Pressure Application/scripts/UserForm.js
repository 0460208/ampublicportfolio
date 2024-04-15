/*
 * Author:   Amanda Martel
 * Date:     10/10/2020
 *
 * Filename: UserForm.js
 * Program to get user information including first name, last name, birthdate, password, and health insurance number. 
 * Allows user to store records for blood pressure. Program will graph blood pressure vs date and preovide suggestions. 
 * Sources: Orginal code from textbook: Building Cross-Platform 
 * Mobile and Web Apps for Engineers and Scientists An Active Learning Approach. 
 * Pawan Lingras with Matt Triff and Rucha Lingras. Copyright 2017 Cengage Learning. 
 */


/* calls the saveUserForm() function */ 
$("#frmUserForm").submit(function () { //Event : submitting the form
  saveUserForm();
  return true;
});

 /* 
  * Name of function: checkUserForm() 
  * Purpose: to check for empty fields in the user form 
  * Parameter: 
  * Called by: saveUserForm() function 
  * Calls: getMonth(), getDate(), getFullYear(), val()
  */
function checkUserForm() { //Check for empty fields in the form
  //for finding current date 
  var d = new Date();
  var month = d.getMonth() + 1;
  var date = d.getDate();
  var year = d.getFullYear();
  var currentDate = year + '/' +
    (('' + month).length < 2 ? '0' : '') +
    month + '/' +
    (('' + date).length < 2 ? '0' : '') + date;

  if (($("#txtFirstName").val() != "") &&
    ($("#txtLastName").val() != "") &&
    ($("#txtHealthCardNumber").val() != "") &&
    ($("#datBirthdate").val() != "") && ($(
      "#datBirthdate").val() <= currentDate)) {
    return true;
  } else {
    return false;
  }
}

 /* 
  * Name of function: saveUserForm() 
  * Purpose: to save user information 
  * Parameter: checkUserForm() function 
  * Called by: submit attribute on the object with id of frmUserForm
  * Calls: val(), setItem(), changePage()
  */
function saveUserForm() {
  if (checkUserForm()) {
    var user = {
      "FirstName": $("#txtFirstName").val(),
      "LastName": $("#txtLastName").val(),
      "HealthCardNumber": $(
        "#txtHealthCardNumber").val(),
      "NewPassword": $("#changePassword").val(),
      "DOB": $("#datBirthdate").val()
    };

    try {
      localStorage.setItem("user", JSON.stringify(user));
      alert("Saving Information");

      $.mobile.changePage("#pageMenu");
      window.location.reload();
    } catch (e) {
      /* Google browsers use different error 
       * constant
       */
      if (window.navigator.vendor ===
        "Google Inc.") {
        if (e == DOMException.QUOTA_EXCEEDED_ERR) {
          alert(
            "Error: Local Storage limit exceeds."
          );
        }
      } else if (e == QUOTA_EXCEEDED_ERR) {
        alert("Error: Saving to local storage.");
      }

      console.log(e);
    }
  } else {
    alert("Please complete the form properly.");
  }

}


 /* 
  * Name of function: showUserForm() 
  * Purpose: load stored values saved in userForm
  * Parameter: user
  * Called by: on attribute on the document object 
  * Calls: parse(), getItem(), log(), val()
  */
function showUserForm() { //Load the stored values in the form
  try {
    var user = JSON.parse(localStorage.getItem(
      "user"));
  } catch (e) {
    /* Google browsers use different error 
     * constant
     */
    if (window.navigator.vendor ===
      "Google Inc.") {
      if (e == DOMException.QUOTA_EXCEEDED_ERR) {
        alert(
          "Error: Local Storage limit exceeds."
        );
      }
    } else if (e == QUOTA_EXCEEDED_ERR) {
      alert("Error: Saving to local storage.");
    }

    console.log(e);
  }

  if (user != null) {
    $("#txtFirstName").val(user.FirstName);
    $("#txtLastName").val(user.LastName);
    $("#txtHealthCardNumber").val(user.HealthCardNumber);
    $("#changePassword").val(user.NewPassword);
    $("#datBirthdate").val(user.DOB);
  }
}