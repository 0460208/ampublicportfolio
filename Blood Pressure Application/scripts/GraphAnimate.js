/*
 *  Author:   Amanda Martel
 *  Date:     11/2/2020
 *
 *  Filename: GraphAnimate.html
 *  Program to get user information including first name, last name, birthdate, password, and health insurance number. 
 *  Allows user to store records for blood pressure. Program will graph blood pressure vs date and preovide suggestions. 
 *  Sources: Orginal code from textbook: Building Cross-Platform 
 *  Mobile and Web Apps for Engineers and Scientists An Active Learning Approach. 
 *  Pawan Lingras with Matt Triff and Rucha Lingras. Copyright 2017 Cengage Learning. 
*/
	
/* 
 * Function name: drawGraph()
 * Purpose: draw the graph on the graph page based on user records
 * Parameters: item "tbRecords" from local storage, BParr, Datearr, BPLower, BPUpper, 
 * Called by: 
 * Calls: getItem(), attr(), setUpCanvas(), getBPhistory(), drawLines(), labelAxes()  
 */
function drawGraph() {
  if (localStorage.getItem("tbRecords") ===
    null) {
    alert("No records exist."); //item "tbRecords" is null, return "No records exist"

	  //call setupCanvas() 
    $(location).attr("href", "#pageMenu");
  } else {
    setupCanvas();

    var BParr = new Array(); //create new array named BParr
    var BParrLower = new Array(); //create new array named BParrLower  
    var Datearr = new Array(); //create new array named Datearr
	 //call getBPhistory and pass BParr, Datearr, BParrLower parameters  
    getBPhistory(BParr, Datearr, BParrLower); 

    var BPLower = new Array(2); //create new array named BPLower 
    var BPUpper = new Array(2); //create new array named BPUpper 
	BPUpper[0] = BPUpper[1] = 120; //set limit for BPUpper to 120 
    BPLower[0] = BPLower[1] = 80; //set limit for BPLower to 80 
    //getTSHbounds(tshLower, tshUpper);

	  //call drawLines and pass BParr, BPUpper, BPLower, Datearr, BParrLower parameters 
    drawLines(BParr, BPUpper, BPLower,
      Datearr, BParrLower)
	  //call labelAxes 
    labelAxes();
  }
}
/* 
 * Function name: setUpCanvas()
 * Purpose: set the canvas for the graph page 
 * Parameters: elemeent with ID GraphCanvas, variable 2D, 0, 0, 500, 500
 * Called by: drawGraph()
 * Calls: getElementById(), getContext(), fillRect()
 */
function setupCanvas() {

  var c = document.getElementById("GraphCanvas"); //create variable c 
  var ctx = c.getContext("2d"); //create variable ctx 

  ctx.fillStyle = "#FFFFFF"; //fill style on ctx variable 
  ctx.fillRect(0, 0, 500, 500); //fill rect object 


}


/* 
 * Function name: getBPhistory()
 * Purpose: get BPhistory from local storage and compare dates  
 * Parameters: BParr, Datearr, tbRecords, compareDates
 * Called by: drawGraph()
 * Calls: getItem(), sortt(), new Date(), getMonth(), getDate(), parseFloat()
 */
function getBPhistory(BParr, Datearr, BParrLower) {
  var tbRecords = JSON.parse(localStorage.getItem(
    "tbRecords"));

	//call sort function pass compareDates parameter 
  tbRecords.sort(compareDates);

	//for statement to get the date 
  for (var i = 0; i < tbRecords.length; i++) {
    var date = new Date(tbRecords[i].Date);

    /*These methods start at 0, must increment
     * by one to compensate
     */
    var m = date.getMonth() + 1; //create m variable 
    var d = date.getDate(); //create d variable 

    //The x-axis label
    Datearr[i] = (m + "/" + d); //create Datearr array 
	  

    //The point to plot
	  //parse values 
    BParr[i] = parseFloat(tbRecords[i].UpperValue);
    BParrLower[i] = parseFloat(tbRecords[i].LowerValue);	  
	  
  }
}

/* 
 * Function name: drawLines()
 * Purpose: draw the lines on graph canvas 
 * Parameters: BParr, BPUpper, BPLower, Datearr
 * Called by: drawGraph()
 * Calls: new RGraph.Line(), set(), draw()
 */
function drawLines(BParr, BPUpper, BPLower,
  Datearr, BParrLower) {
	//create a new RGraph.line object pass "GraphCanvas", BParr, BPUpper, BPLower, BParrLower parameters
  var BPline = new RGraph.Line("GraphCanvas",
      BParr, BPUpper, BPLower, BParrLower) 
  //set line label, colors, shadow, tickmark, ticksize, and chart title 
    .Set("labels", Datearr)
    .Set("colors", ["blue", "green", "red", "purple"])
    .Set("shadow", true)
    .Set("shadow.offsetx", 1)
    .Set("shadow.offsety", 1)
    .Set("linewidth", 1)
    .Set("numxticks", 6)
    .Set("scale.decimals", 0)
    .Set("xaxispos", "bottom")
    .Set("gutter.left", 35)
    .Set("tickmarks", "filledcircle")
    .Set("ticksize", 5)
    .Set("chart.labels.ingraph", ["UpperBP", "", "","", "", "", "LowerBP", ""])
    .Set("chart.title", "Blood Pressure Graph")
    .Draw();
}
/* 
 * Function name: labelAxes()
 * Purpose: label the axes of the graph
 * Parameters: element with the ID of GraphCanvas,  element with ID of 2D
 * Called by: drawGraph()
 * Calls: getElementById(), getContext, fillText(), rotate(), textAlign(), fillText()
 */
function labelAxes() {
  var c = document.getElementById("GraphCanvas"); //create variable c 
  var ctx = c.getContext("2d"); //create variable ctx 
  ctx.font = "11px Georgia";
  ctx.fillStyle = "green";
  ctx.fillText("Date(MM/DD)", 400, 470);
  ctx.rotate(-Math.PI / 2);
  ctx.textAlign = "center";
  ctx.fillText("BP Value", -250, 10);
}