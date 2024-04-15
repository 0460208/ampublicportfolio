/*
 * Author:   Amanda Martel
 * Date:     10/31/2020
 *
 * Filename: Table.js
 * Program to get user information including first name, last name, birthdate, password, and health insurance number. 
 * Allows user to store records for blood pressure. Program will graph blood pressure vs date and preovide suggestions. 
 * Sources: Orginal code from textbook: Building Cross-Platform 
 * Mobile and Web Apps for Engineers and Scientists An Active Learning Approach. 
 * Pawan Lingras with Matt Triff and Rucha Lingras. Copyright 2017 Cengage Learning. 
 */


// Removes all record data from localStorage 
// calls: removeItem, listRecords, alert
// parameters: 'tbRecords'
// called by: click function on the object with the id btnClearHistory 
$("#btnClearHistory").click(function () {
  localStorage.removeItem("tbRecords");
  listRecords();
  alert("All records have been deleted.");
});

/* The value of the Submit Record button is used
 * to determine which operation should be
 * performed
 */ 
//calls click event listener fucntion on id btnAddRecord 
$("#btnAddRecord").click(function () {
  /*.button("refresh") function forces jQuery
   * Mobile to refresh the text on the button
   */
  $("#btnSubmitRecord").val("Add").button(
    "refresh"); //adds value "Add" to id #btnSubmitRecord 
});


$("#frmNewRecordForm").submit(function () {
  var formOperation = $("#btnSubmitRecord").val(); //create variable formOperation

  if (formOperation == "Add") {
    addRecord(); //call addRecord function 
    $.mobile.changePage("#pageRecords");
  } else if (formOperation == "Edit") {
    editRecord($("#btnSubmitRecord").attr(
      "indexToEdit"));
    $.mobile.changePage("#pageRecords");
    $("#btnSubmitRecord").removeAttr(
      "indexToEdit");
  }

  /*Must return false, or else submitting form
   * results in reloading the page
   */
  return false;
});

$("#pageNewRecordForm").on("pageshow", function () {
  //We need to know if we are editing or adding a record everytime we show this page
  //If we are adding a record we show the form with blank inputs
  var formOperation = $("#btnSubmitRecord").val(); //create variable formOperation 

  if (formOperation == "Add") {
    clearRecordForm();
  } else if (formOperation == "Edit") {
    //If we are editing a record we load the stored data in the form
    showRecordForm($("#btnSubmitRecord").attr(
      "indexToEdit"));
  }
});


/*
* function name: loadUserInformation()
* function purpose: get user information from local storage
* parameters: e
* called by: pageshow 
* other functions called: 
*/
function loadUserInformation() {
  try {
	  //get user information from local storage 
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
    $("#divUserSection").empty();
    var today = new Date(); //create today variable 
    var dob = new Date(user.DOB); //create dob variable 
    var age = Math.floor((today - dob) / (
      365.25 * 24 * 60 * 60 * 1000)); //create age variable 

	// create divUserSection  
    $("#divUserSection").append("User's Name:" +
      user.FirstName + " " + user.LastName +
      "<br>Age: " + age +
      "<br>Health Card Number: " + user.HealthCardNumber +
      "<br>New Password : " + user.NewPassword);
    $("#divUserSection").append(
      "<br><a href='#pageUserInfo' data-mini='true' data-role='button' data-icon='edit' data-iconpos='left' data-inline='true' >Edit Profile</a>"
    );
    $('#divUserSection [data-role="button"]').button(); // 'Refresh' the button
  }
}

/*
* function name: clearRecordForm()
* function purpose: remove user information from local storage
* parameters: ""
* called by: #btnSubmitRecord 
*/
function clearRecordForm() {
  $('#datExamDate').val("");
  $('#bpUpperValue').val("");
  $('#bpLowerValue').val("");
  return true;
}

/*
* function name: compareDates()
* function purpose: compare variable x date with variable y date 
* parameters: a, b 
* called by: listRecords() 
*/
function compareDates(a, b) {
  var x = new Date(a.Date);
  var y = new Date(b.Date);

  if (x > y) {
    return 1;
  } else {
    return -1;
  }
}

/*
* function name: listRecords()
* function purpose: list user records 
* parameters: 
* called by: callDelete(), addRecord(), editRecord() 
*/
function listRecords() {
  try {
	  //get tbRecords from local storage 
    var tbRecords = JSON.parse(localStorage.getItem(
      "tbRecords"));
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

  //Load previous records, if they exist
  if (tbRecords != null) {
    //Order the records by date
    tbRecords.sort(compareDates);

    //Initializing the table
    //create table for records 
    $("#tblRecords").html(
      "<thead>" +
      "   <tr>" +
      "     <th>Date</th>" +
	  "     <th>BP</th>" +
      "     <th> Upper </th>"   +
      "     <th> Lower </th>"   +
      "     <th> Edit / Delete</th>" +
      "   </tr>" +
      "</thead>" +
      "<tbody>" +
      "</tbody>"
    );

    //Loop to insert the each record in the table
    for (var i = 0; i < tbRecords.length; i++) {
      var rec = tbRecords[i]; //create rec variable 
      $("#tblRecords tbody").append("<tr>" +
        "  <td>" + rec.Date + "</td>" + 
		" <td></td>"	 +						
        "  <td>" + rec.UpperValue + "</td>" +
        "  <td>" + rec.LowerValue +
        "</td>" +
        "  <td><a data-inline='true'  data-mini='true' data-role='button' href='#pageNewRecordForm' onclick='callEdit(" +
        i +
        ")' data-icon='edit' data-iconpos='notext'></a>" +
        "  <a data-inline='true'  data-mini='true' data-role='button' href='#' onclick='callDelete(" +
        i +
        ")' data-icon='delete' data-iconpos='notext'></a></td>" +
        "</tr>");
    }

    $('#tblRecords [data-role="button"]').button(); // 'Refresh' the buttons. Without this the delete/edit buttons wont appear
  } else {
    tbRecords = []; //If there is no data,set an empty array
    $("#tblRecords").html("");
  }
  return true;
}

/*
* function name: showRecordForm()
* function purpose: display the record form  
* parameters: index
*/
function showRecordForm(index) {
  try {
	  //get tbRecords from local storage 
    var tbRecords = JSON.parse(localStorage.getItem(
      "tbRecords"));
    var rec = tbRecords[index];
    $('#datExamDate').val(rec.Date);
    $('#bpUpperValue').val(rec.UpperValue);
    $('#bpLowerValue').val(rec.LowerValue);
  } catch (e) {
    /* Google browsers use different error 
     * constant
     */
    if (window.navigator.vendor ===
      "Google Inc.") {
      if (e == DOMException.QUOTA_EXCEEDED_ERR) {
        alert(
          "Error: Local Storage limit exceeds."
        ); //alert message 
      }
    } else if (e == QUOTA_EXCEEDED_ERR) {
      alert("Error: Saving to local storage."); //alert message 
    }

    console.log(e);
  }
}

/* Checks that users have entered all valid info
 * and that the date they have entered is not in
 * the future
 */
/*
* function name: checkRecordForm()
* function purpose: check the information in the user records 
* parameters: 
* called by: addRecord()
*/
function checkRecordForm() {
  //for finding current date 
  var d = new Date(); //create d variable 
  var month = d.getMonth() + 1; //create month variable 
  var date = d.getDate(); //create date variable 
  var currentDate = d.getFullYear() + '/' +
    (('' + month).length < 2 ? '0' : '') +
    month + '/' +
    (('' + date).length < 2 ? '0' : '') + date; //create currentDate variable 

  if (($("#datExamDate").val() != "") &&
    ($("#datExamDate").val() <= currentDate) &&
    (parseFloat($("#bpUpperValue").val()) <
      1000000) &&
    ($("#bpLowerValue").val() != "")) {
    return true;
  } else {
    return false;
  }
}

/*
* function name: callEdit()
* function purpose: load the record edit page 
* parameters: index
* called by: 
*/
function callEdit(index) {
  $("#btnSubmitRecord").attr("indexToEdit",
    index);
  /*.button("refresh") function forces jQuery
   * Mobile to refresh the text on the button
   */
  $("#btnSubmitRecord").val("Edit").button(
    "refresh");
}

// Delete the given index and re-display the table
/*
* function name: callDelete()
* function purpose: delete user records 
* parameters: index
* called by: listRecords(), deleteRecord()
*/
function callDelete(index) {
  deleteRecord(index); //call deleteRecord()
  listRecords(); //call listRecords()
}

/*
* function name: addRecord()
* function purpose: add user records 
* parameters: checkRecordForm()
* called by: checkRecordForm()
* calls: checkRecordForm(), clearRecordForm(), listRecords()
*/
function addRecord() {
  if (checkRecordForm()) {
    var record = {
      "Date": $('#datExamDate').val(),
      "UpperValue": $('#bpUpperValue').val(),
      "LowerValue": $('#bpLowerValue')
        .val()
    };

    try {
      var tbRecords = JSON.parse(localStorage.getItem(
        "tbRecords"));
      if (tbRecords == null) {
        tbRecords = [];
      }
      tbRecords.push(record);
      localStorage.setItem("tbRecords", JSON.stringify(
        tbRecords));
      alert("Saving Information");
      clearRecordForm(); //call clearRecordForm()
      listRecords(); //callListRecords()
    } catch (e) {
      /* Google browsers use different error 
       * constant
       */
      if (window.navigator.vendor ===
        "Google Inc.") {
        if (e == DOMException.QUOTA_EXCEEDED_ERR) {
          alert(
            "Error: Local Storage limit exceeds."
          ); //alert message 
        }
      } else if (e == QUOTA_EXCEEDED_ERR) {
        alert("Error: Saving to local storage."); //alert message 
      }

      console.log(e);
    }
  } else {
    alert("Please complete the form properly."); //alert message 
  }

  return true;
}
/*
* function name: deleteRecord()
* function purpose: delete user records 
* parameters: index
* called by: click event on delete button
* calls: removeItem(), setItem(), alert()
*/
function deleteRecord(index) {
  try {
	  //get tbRecords from local storage 
    var tbRecords = JSON.parse(localStorage.getItem(
      "tbRecords"));

    tbRecords.splice(index, 1);

    if (tbRecords.length == 0) {
      /* No items left in records, remove entire 
       * array from localStorage
       */
      localStorage.removeItem("tbRecords");
    } else {
      localStorage.setItem("tbRecords", JSON.stringify(
        tbRecords));
    }
  } catch (e) {
    /* Google browsers use different error 
     * constant
     */
    if (window.navigator.vendor ===
      "Google Inc.") {
      if (e == DOMException.QUOTA_EXCEEDED_ERR) {
        alert(
          "Error: Local Storage limit exceeds."
        ); //alert message 
      }
    } else if (e == QUOTA_EXCEEDED_ERR) {
      alert("Error: Saving to local storage."); //alert message 
    }

    console.log(e);
  }
}

/*
* function name: editRecord()
* function purpose: edit user records 
* parameters: index
* called by: click event on edit button 
* calls: checkRecordForm(), clearRecordForm(), listRecords(), alert()
*/
function editRecord(index) {
  if (checkRecordForm()) {
    try {
		//get tbRecords from local storage
      var tbRecords = JSON.parse(localStorage.getItem(
        "tbRecords")); 
      tbRecords[index] = {
        "Date": $('#datExamDate').val(),
        "UpperValue": $('#bpUpperValue').val(),
        "LowerValue": $(
          '#bpLowerValue').val()
      }; //Alter the selected item in the array
      localStorage.setItem("tbRecords", JSON.stringify(
        tbRecords)); //Saving array to local storage
      alert("Saving Information");
      clearRecordForm(); //call clearRecordForm()
      listRecords(); //call listRecords()
    } catch (e) {
      /* Google browsers use different error 
       * constant
       */
      if (window.navigator.vendor ===
        "Google Inc.") {
        if (e == DOMException.QUOTA_EXCEEDED_ERR) {
          alert(
            "Error: Local Storage limit exceeds."
          ); //alert message 
        }
      } else if (e == QUOTA_EXCEEDED_ERR) {
		  //alert message 
        alert("Error: Saving to local storage.");
      }

      console.log(e);
    }
  } else {
	  //alert message 
    alert("Please complete the form properly.");
  }
}