<?php 
// Amanda Martel, 2/1/2021, chapter1-3
//declare and initialize the local variable $user.
$user = 'Not Logged In';
//Start the session
session_start();
//display text to the web page
echo 'Sessions Page One<br />';
//session_id() returns the actual session ID created by the server. 
$SID = session_id();
//declare and initialize the session variable $_SESSION['user']
$_SESSION['user'] = 'Authorized User';
//test to see if the session variable is set (contains a value)
if(isset($_SESSION['user']))
{
//do if isset is true
//setting the local variable to the session variable value
$user = $_SESSION['user'];
}
else 
{
//do if isset is false//setting the local variable to the value 'Guest'
$user = 'Guest';
}
//display the value of the local variable to the web page
//answer should be either 'Authorized User'or 'Guest'
echo 'User variable: '.$user;
//display the session ID that was generated by the session_start() command
echo '<br /> Session_id: '.$SID;
echo ' <br /><br /><br />';
//create and display a link for the next page
echo '<a href="sessions2.php">Sessions Page Two</a>';
?>