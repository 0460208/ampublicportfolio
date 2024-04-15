// JavaScript Document
/*
Author:   Amanda Martel
Date:     10/7/2020

Filename: Recipe.js
JavaScript file for Recipe.html
Program will allow user to input serving size and recipie will calculate each new ingredient amount needed for the recipe.
*/

//jQuery statement to replace event listener
$("#button").click(calculateCookies);
//create event listener to call calculateCookies function when element with id of "button" is clicked 
//document.getElementById("button").addEventListener("click", calculateCookies);
//create calculateCookies function
function calculateCookies() {
	//create variables for original recipe 
	var originalCookies = 16; 
	var butter = 10; 
	var flour = 1.5; 
	var sugar = 0.5; 
	var salt = 0.5; 
	var vanilla = 0.5; 
	//jQuery statement to create variable serving for the value input from user 
	var serving = $("#serving").val();
	//create variable serving for the value input from user 
	//var serving = document.getElementById("serving").value;
	//calculate multiplication factor for new ingredient amounts 
	var newServingSize = serving / originalCookies; 
	//create variables for each new ingredient amount 
	var newButter = butter * newServingSize;
	var newFlour = flour * newServingSize;
	var newSugar = sugar * newServingSize;
	var newSalt = salt * newServingSize;
	var newVanilla = vanilla * newServingSize;
	//replace with jQuery statements to change innerHTML of original recipe amounts
	$("#originalServing").html(serving);
	$("#butter").html(newButter);
	$("#flour").html(newFlour);
	$("#sugar").html(newSugar);
	$("#salt").html(newSalt);
	$("#vanilla").html(newVanilla);
	//change the innerHTML of original recipe amounts to new ingredient amounts 
	//document.getElementById("originalServing").innerHTML = serving;
	//document.getElementById("butter").innerHTML = newButter; 
	//document.getElementById("flour").innerHTML = newFlour;
	//document.getElementById("sugar").innerHTML = newSugar;
	//document.getElementById("salt").innerHTML = newSalt;
	//document.getElementById("vanilla").innerHTML = newVanilla;
	
}