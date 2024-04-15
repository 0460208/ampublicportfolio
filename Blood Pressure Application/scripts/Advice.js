/*
 * Author:   Amanda Martel
 * Date:     10/10/2020
 *
 * Filename: Advice.js
 * Program to get user information including first name, last name, birthdate, password, and health insurance number. 
 * Allows user to store records for blood pressure. Program will graph blood pressure vs date and preovide suggestions. 
 * Sources: Orginal code from textbook: Building Cross-Platform 
 * Mobile and Web Apps for Engineers and Scientists An Active Learning Approach. 
 * Pawan Lingras with Matt Triff and Rucha Lingras. Copyright 2017 Cengage Learning. 
 */



/*
 * Name: advicePage()
 * Purpose: display advicePage 
 * Parameters passed: tbRecords, ctx, UpperValue, LowerValue
 * Called by: on function on "pageshow"
 * Calls: getItem(), attr(), parse(), sort(), drawAdviceCanvas()
 */
function advicePage() {
  if (localStorage.getItem("tbRecords") ===
    null) {
    alert("No records exist.");

    $(location).attr("href", "#pageMenu");
  } else {

    var tbRecords = JSON.parse(localStorage.getItem(
      "tbRecords"));
    tbRecords.sort(compareDates);
    var i = tbRecords.length - 1; //get the last record item
    var UpperValue = tbRecords[i].UpperValue; //create UpperValue variable 
	var LowerValue = tbRecords[i].LowerValue; //create LowerValue variable 
    var c = document.getElementById(
      "AdviceCanvas"); //create c variable 
    var ctx = c.getContext("2d");
    ctx.fillStyle = "#c0c0c0";
    ctx.fillRect(0, 0, 550, 850);
    ctx.font = "22px Arial";
	 //call drawAdviceCanvas pass ctx, UpperValue, LowerValue 
    drawAdviceCanvas(ctx, UpperValue, LowerValue);

  }
}

/*
 * Name: drawAdviceCanvas()
 * Purpose: display current blood pressure and how it compares to reccommended range 
 * Parameters passed: ctx, UpperValue, LowerValue 
 * Called by: advicePage()
 * Calls: BPWrite(), BPUpperMeter(), BPLowerMeter(), fillText()
 */
function drawAdviceCanvas(ctx, UpperValue, LowerValue) {
  ctx.font = "22px Arial"; //set the font 
  ctx.fillStyle = "black"; //set color 
  //display current blood pressure 
  ctx.fillText("Your current blood pressure is: " + UpperValue + "/" + LowerValue +
    ".", 25, 320);
  //display target blood pressure 	
  ctx.fillText(
      "Your target blood pressure is: 120/80",
      25, 350);

    BPUpperMeter(ctx, UpperValue); //call BPUpperMeter pass ctx, UpperValue 
	BPWrite(ctx, UpperValue, LowerValue); //call BPWrite pass ctx, UpperValue, LowerValue
	BPLowerMeter(ctx, LowerValue); //call BPLowerMeter pass ctx, LowerValue 
}


/*
 * Name: BPUpperWrite()
 * Purpose: chose advice level for UpperValue  
 * Parameters passed: ctx, UpperValue
 * Called by: drawAdviceCanvas()
 * Calls: writeUpperAdvice() 
 */
function BPWrite(ctx, UpperValue, LowerValue) {
  if ((UpperValue > 140 || LowerValue > 90)) {
    writeUpperAdvice(ctx, "red"); //call writeUpperAdvice pass ctx, "red"
  } else if ((UpperValue > 120 || LowerValue > 80)) {
    writeUpperAdvice(ctx, "yellow"); //call writeUpperAdvice pass ctx, "yellow"
  } else if ((UpperValue > 90 && LowerValue > 60)) {
    writeUpperAdvice(ctx, "green"); //call writeUpperAdvice pass ctx, "green"
  } else {
    writeUpperAdvice(ctx, "blue"); //call writeUpperAdvice pass ctx, "blue"
  }
}



/*
 * Name: writeUpperAdvice()
 * Purpose: write message for UpperValue level  
 * Parameters passed: ctx, level
 * Called by: BPUpperWrite()
 * Calls: fillText() 
 */
function writeUpperAdvice(ctx, level) {
  var adviceLine1 = ""; //create adviceLine1 variable set to empty string 
  var adviceLine2 = ""; //create adviceLine2 variable set to empty string 

	// set level to red
  if (level == "red") {
	  //if level is exactly equal to red
    adviceLine1 =
      "You may have high blood pressure.";
    adviceLine2 = "Your risk of serious health problems could go up.";
	  //if level is exactly equal to yellow
  } else if (level == "yellow") {
	  //set yellow advice 
    adviceLine1 =
      "You may have pre-high blood pressure.";
    adviceLine2 = "Yours is a little higher than it should be.";
	  //if level is exactly equal to green
  } else if (level == "green") {
	  //set green advice 
    adviceLine1 =
      "Your blood pressure reading is healthy.";
	  //if level is exactly equal to blue 
  } else if (level == "blue") {
	  // set blue advice 
    adviceLine1 =
      "Your blood pressure is too low.";
	adviceLine2 = "This usually isn't a problem, although you could feel dizzy.";
  }
	//display blood pressure level 
  ctx.font = "20px Arial"; //set the font 
  ctx.fillText("Your blood pressure level is " + level +
    ".", 25, 440);
  //display adviceLine1
  //display adviceLine2 	
  ctx.fillText(adviceLine1, 25, 480);
  ctx.fillText(adviceLine2, 25, 500);
  
}



/*
 * Name: BPUpperMeter()
 * Purpose: create the meter for UpperValue   
 * Parameters passed: ctx, UpperValue
 * Called by: drawAdviceCanvas() 
 * Calls: RGraph.CornerGauge(), drawMeter() 
 */
function BPUpperMeter(ctx, UpperValue) {
	//create new corner gauge 
    var cg = new RGraph.CornerGauge(
        "AdviceCanvas", 70, 190, UpperValue)
	  //set chart ranges and colors 
      .Set("chart.colors.ranges", [
        [140, 191, "red"],
        [121, 140, "yellow"],
        [90, 120, "green"],
		[70, 90, "blue"]
      ]);
 
  drawMeter(cg); //call drawMeter pass cg
}

/*
 * Name: BPLowerMeter()
 * Purpose: create the meter for LowerValue   
 * Parameters passed: ctx, LowerValue 
 * Called by: drawAdviceCanvas() 
 * Calls: RGraph.CornerGauge(), drawLowerMeter())
 */
function BPLowerMeter(ctx, LowerValue) {
	//create new corner gauge
    var cg = new RGraph.CornerGauge(
        "AdviceCanvas", 40, 100, LowerValue)
	  //set chart ranges and colors 
      .Set("chart.colors.ranges", [
        [90, 100, "red"],
        [80, 90, "yellow"],
        [60, 80, "green"],
		[40, 60, "blue"]  
      ]);
  drawLowerMeter(cg); //call drawLowerMeter pass cg 
}

/*
 * Name: drawMeter()
 * Purpose: draw the meter 
 * Parameters passed: g 
 * Called by: BPUpperMeter()
 * Calls: .Set(), .Draw () 
 */

// Meter properties
function drawMeter(g) {
  g.Set("chart.value.text.units.post", "")
    .Set("chart.value.text.boxed", false)
    .Set("chart.value.text.size", 14)
    .Set("chart.value.text.font", "Arial")
    .Set("chart.value.text.bold", true)
    .Set("chart.value.text.decimals", 0)
    .Set("chart.shadow.offsetx", 5)
    .Set("chart.shadow.offsety", 5)
    .Set("chart.scale.decimals", 0)
    .Set("chart.title", "BLOOD PRESSURE LEVEL- UPPER VALUE")
    .Set("chart.radius", 250)
    .Set("chart.centerx", 50)
    .Set("chart.centery", 250)
    .Draw();
}

/*
 * Name: drawLowerMeter()
 * purpose: draw the lower meter   
 * parameters passed: g 
 * called by: BPLowerMeter()
 * calls: .Set(), .Draw () 
 */

// Meter properties
function drawLowerMeter(g) {
  g.Set("chart.value.text.units.post", "")
    .Set("chart.value.text.boxed", false)
    .Set("chart.value.text.size", 14)
    .Set("chart.value.text.font", "Arial")
    .Set("chart.value.text.bold", true)
    .Set("chart.value.text.decimals", 0)
    .Set("chart.shadow.offsetx", 5)
    .Set("chart.shadow.offsety", 5)
    .Set("chart.scale.decimals", 0)
    .Set("chart.title", "BLOOD PRESSURE LEVEL- LOWER VALUE")
    .Set("chart.radius", 250)
    .Set("chart.centerx", 50)
    .Set("chart.centery", 800)
    .Draw();
}
