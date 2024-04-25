<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Harry's Hot Sauce</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link href="css/layout.css" rel="stylesheet" type="text/css">
</head>

<body>
<?php
include 'includes/core.php';
include 'includes/connection.php';
?>

<div id="wrapper">
<?php include 'includes/header.php'; ?>

<div id="body-wrapper">

<p class="titles">Sources used in creating this website</p>

<br />
<br />
<!-- place sources of your images and related data here --> 
<p>Items, Item pictures, Descriptions, Prices - all created by Amanda Martel, 2020.</p>

<br />
<br />

</div>

<?php include 'includes/footer.php'; ?>

</div>

<?php
if(loggedin())
{
include 'includes/signout.php';
}
else 
{
include 'includes/signIn.php';
}
?>

</body>
</html>


