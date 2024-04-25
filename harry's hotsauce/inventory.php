<?php
session_start();
include 'includes/core.php';
include 'includes/connection.php';
date_default_timezone_set('America/New_York');
error_reporting(E_ERROR | E_PARSE);

if(loggedin()) {
$_SESSION['Login_username'] = getuserfield('Login_username');
$accountID = $_SESSION['Login_account_id'];

$query = "SELECT * FROM `Accounts` WHERE `Account_id` = '".$accountID."'";
if (!$result = mysqli_query($link, $query))
{
   $result = 0;
   echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
}
else
{
$row = mysqli_fetch_array($result,MYSQLI_BOTH);
}

//putting account table columns in variables 
$firstName = $row['Account_firstname'];
$lastName = $row['Account_lastname'];
$email = $row['Account_email_address'];
$address = $row['Account_address1'];
$city = $row['Account_city'];
$state = $row['Account_state_region'];
$zip = $row['Account_postal_code'];
?>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Harry's Hot Sauce</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link href="css/layout.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="wrapper">
<?php include 'includes/header.php'; ?>


<div id="body-wrapper">

<p class="titles">Inventory</p>

<? 
//get the product name 
$query2 = "SELECT * products_name FROM `Products`";
if (!$query_run2 = mysqli_query($link, $query2))
{
   $query_run2 = 0;
   $productsName = null;
}
else 
{
$row2 = mysqli_fetch_array($query_run2,MYSQLI_BOTH);
$productsName = $row2[0];
}
//if (is_null($employeeNumber))
//{$employeeNumber = 1001;}
//else 
//{$employeeNumber++;}

//build select combo for product names 
$query1 = "SELECT Products_name FROM `Products`";
if (!$query_run1 = mysqli_query($link, $query1))
{
   $query_run1 = 0;
   echo ('Error executing query1 in Inventory: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
}
else 
{
$row = mysqli_fetch_array($query_run1,MYSQLI_BOTH);
$productsnamesbox='<select name="Names" id="combo">';
$productsnamesbox.='<option value=0>' . ' '. '</option>';
$productsnamesbox.='<option value="' . $row['Products_name'] . '">' . $row['Products_name'] . '</option>';
}
while ($row = mysqli_fetch_array($query_run1,MYSQLI_BOTH))
{
    $productsnamesbox.='<option value="' . $row['Products_name'] . '">' . $row['Products_name'] . '</option>';
}
$productsnamesbox.='</select>';
mysqli_free_result($query_run1);


//build select combo for product images 
$query1 = "SELECT Products_image FROM `Products`";
if (!$query_run1 = mysqli_query($link, $query))
{
   $result = 0;
   echo ('Error executing query1 in Inventory: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
}
else 
{
$row1 = mysqli_fetch_array($query_run1,MYSQLI_BOTH);
$pImgbox='<select name="productImg" id="combo">';
$pImgbox.='<option value=0>' .' '. '</option>';
$pImgbox.='<optiion value="' . $row['Products_image']. '">'.$row['Products_image'].'</option>';
}
while($row = mysqli_fetch_array($query_run1,MYSQLI_BOTH)) 
{
   $pImgbox.='<option value="' . $row['Products_image'].'">'.$row['Products_image'].'</option>';
}
$pImgbox.='</select>';
mysqli_free_result($query_run1);

//build select combo for employee status 
$query1 = "SELECT Products_name FROM `Products`";
if (!$query_run1 = mysqli_query($link, $query1))
{
   $query_run1 = 0; 
   echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
}
else 
{
$row1 = mysqli_fetch_array($query_run1,MYSQLI_BOTH);
$empstatusbox='<select name="Estatus" id="combo">';
$empstatusbox.='<option value=0>' .' '. '</option>';
$empstatusbox.='<option value="' . $row1['GL_data']. '">'.$row['GL_data'].'</option>';
}
while ($row = mysqli_fetch_array($query_run1,MYSQLI_BOTH))
{
   $empstatusbox.'<option value="' .$row['GL_data'].'">'.$row['GL_data'].'</option>';
}
$empstatusbox.'</select>';
mysqli_free_result($query_run1);

//build select combo for Products_image 
$query1 = "SELECT Account_lastname, Account_firstname, Employee_account_id FROM `Employee`, `Accounts` WHERE `Employee_position_title` = 'Manager' and `Employee_account_id` = `Account_id` order by 1";
if (!$query_run1 = mysqli_query($link, $query1))
{
   !$query_run1 = 0;
   echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
}
else {
$row1 = mysqli_fetch_array($query_run1,MYSQLI_BOTH);
$empmgrbox='<select name="managerID" id="combo">';
$empmgrbox.='<option value=0>' .' '. '</option>';
$empmgrbox.='<option value="' . $row1['Employee_account_id'] . '">'. $row1['Account_lastname'] .', ' .$row1['Account_firstname']. '</option>';
}
while ($row = mysqli_fetch_array($query_run1,MYSQLI_BOTH))
{
   $empmgrbox.='<option value="' . $row1['Employee_account_id'] . '">'. $row1['Account_lastname'] .', ' .$row1['Account_firstname']. '</option>';
}
$empmgrbox.'</select>';
mysqli_free_result($query_run1);
?>

<div id="register-wrapper">
<form action="" method="post">

<div class="label-wrapper">
<p>Product Name:</p>
<? echo $productsnamesbox; ?>
</div>

<input type="submit" name="submitfind" value="Find" class="submit-reset">
<input type="reset" name="reset" value="Reset" class="submit-reset">
</form>
<?php
$productNameID = 0;
if(isset($_POST['submitfind']))
{
$productNameID = $_POST['Names'];
$_SESSION['NameID'] = $productNameID;

//if the submit find button is clicked do the following 
$fquery = "SELECT * FROM `Products` WHERE `Products_name` = '".$productNameID."'";
if (!$fresult = mysqli_query($link,$fquery))
{
   $fresult = 0;
   echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");   
}
else
{
$frow = mysqli_fetch_array($fresult,MYSQLI_BOTH);
//putting products table columns in variables 
$pImage = $prow['Products_image'];
$pName = $prow['Products_name'];
$pNumber = $prow['Products_item_number'];
$pDisplayName = $prow['Products_display_name'];
$pPrice = $prow['Products_unit_price'];
$pDiscountPrice = $prow['Products_discounted_unit_price'];
$pQuantity = $prow['Products_quantity_per_unit'];
$pImageId = $prow['Products_image_id'];
$pDescription = $prow['Products_description'];
$pStatus = $prow['Products_status'];
$pStartDate = $prow['Products_start_date'];
$pEndDate = $prow['Products_end_date'];
$pNotes = $prow['Products_notes'];
}
if ($productNameID != 0)
{
ECHO $pName.', '.$pNumber.' '.$pPrice.'<BR/>';
//ECHO $faddress.'<BR />';
//if (!empty($faddress2)) {ECHO 'Line 2 : '.$faddress2.'<BR />';}
//ECHO $fcity.', '.$fstate.' '.$fzip.'<BR /><BR />';
//ECHO 'Acct Status: '. $facctStatus.'<BR />';
//ECHO 'Email: ' . $femail.'<BR />';
}
}
?>
</div>
<div id="register-wrapper">
<?php
//if the submit find button is clicked do the following 
$equery = "SELECT * FROM `Products` WHERE `Products_name` = '".$_SESSION['NameID']."'";
if (!$eresult = mysqli_query($link,$equery))
{
   $eresult = 0;
   echo ('Error executing query in Inventory: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");   
}
else
{
$erow = mysqli_fetch_array($eresult,MYSQLI_BOTH);
$eempnumber = $erow['Employee_number'];
$eempstatus = $erow['Employee_status'];
$eempmanid = $erow['Employee_manager_id'];
$eempposition = $erow['Employee_position_title'];
}
if (isset($eempnumber)) {$ecurrentemp = 'YES'; $employeeNumber=$eempnumber;
$smbutton = 'Update';} else {$ecurrentemp = 'NO'; $smbutton='Add';}


//build select combo for employee positions 
$query1 = "SELECT GL_data FROM `General_lookup` WHERE `GL_type` = 'Employee Position' order by 1";
if (!$query_run1 = mysqli_query($link,$query1))
{
   $query_run1 = 0;
   echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");   
}
else
{
$row1 = mysqli_fetch_array($query_run1,MYSQLI_BOTH);
$empposbox='<select name="positionTitle" id="combo">';
$empposbox.='<option value=0>' .' '. '</option>';
}
if ($eemposition == $row1['GL_data'])
{$empposbox.='<option value="' . $row1['GL_data'] .'" selected>'.$row1['GL_data'].'</option>';}
else 
 {$empposbox.='<option value="' . $row1['GL_data'] .'">'.$row1['GL_data'].'</option>';}
 while ($row = mysqli_fetch_array($query_run1, MYSQLI_BOTH))
 {
    if ($eemposition == $row['GL_data'])
       {$empposbox.='<option value="' . $row['GL_data'] .'" selected>'.$row['GL_data'].'</option>';}
    else 
      {$empposbox.='<option value="' . $row['GL_data'] .'"> '.$row['GL_data'].'</option>';}
    }
$empposbox.='</select>';
mysqli_free_result($query_run1);

//build select combo for employee status 
$query1 = "SELECT GL_data FROM `General_lookup` WHERE `GL_type` = 'Employee Status' order by 1";
$empstatusbox='<select name="Estatus" id="combo">';
$empstatusbox.='<option value=0>' .' '. '</option>';
if (!$query_run1 = mysqli_query($link,$query1))
{
   $query_run1 = 0;
   echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");   
}
else
{
$row1 = mysqli_fetch_array($query_run1,MYSQLI_BOTH);
}
if ($eempstatus == $row1['GL_data'])
{$empstatusbox.='<option value="' . $row1['GL_data'] .'" selected>'.$row1['GL_data'].'</option>';}
else 
 {$empstatusbox.='<option value="' . $row1['GL_data'] .'" selected>'.$row1['GL_data'].'</option>';}
 while ($row = mysqli_fetch_array($query_run1, MYSQLI_BOTH))
 {
    if ($eempstatus == $row['GL_data'])
       {$empstatusbox.='<option value="' . $row['GL_data'] .'" selected>'.$row['GL_data'].'</option>';}
    else 
      {$empstatusbox.='<option value="' . $row['GL_data'] .'" selected>'.$row['GL_data'].'</option>';}
    }
$empstatusbox.='</select>';
mysqli_free_result($query_run1);

//build select combo for managers 
$query1 ="SELECT Account_lastname, Account_firstname, Employee_account_id, Employee_position_title FROM `Employee`, `Accounts` WHERE 
`Employee_position_title` = 'Manager' and `Employee_account_id` = `Account_id` order by 1";
if (!$query_run1 = mysqli_query($link,$query1))
{
   $query_run1 = 0;
   echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");   
}
else
{
$row1 = mysqli_fetch_array($query_run1,MYSQLI_BOTH);
$empmgrbox='<select name="managerID" id="combo">';
$empmgrbox.='<option value=0>' .' '. '</option>';
}
if ($eempmanid == $row1['Employee_account_id'])
{$empmgrbox.='<option value="' . $row1['Employee_account_id'] .'" selected>'.$row1['Account_lastname']. ', ' .$row1['Account_firstname'].'</option>';}
else 
 {$empmgrbox.='<option value="' . $row1['Employee_account_id'] .'">'.$row1['Account_lastname'] .', ' .$row1['Account_firstname']. '</option>';}
 while ($row = mysqli_fetch_array($query_run1, MYSQLI_BOTH))
 {
    if ($eempposition == $row['Employee_position_title'])
       {$empmgrbox.='<option value="' . $row['Employee_account_id'] .'" selected>'.$row['Account_lastname'] .', ' .$row['Account_firstname'] .'</option>';}
    else 
      {$empmgrbox.='<option value="' . $row['GL_data'] .'" selected>'.$row['GL_data'].'</option>';}
    }
$empmgrbox.='</select>';
mysqli_free_result($query_run1);
?>
<form action="" method="post">

<div class="label-wrapper">
Image:
<? echo $pImgbox; ?>
</div>

<div class="label-wrapper">
Product Name: 
<input type="text" placeholder=" " name="employeeNumber" size="38" />
</div>

<div class="label-wrapper">
Product units in stock: 
<input type="text" placeholder=" " name="employeeNumber" size="38" />
</div>

<div class="label-wrapper">
Product unit price: 
<input type="text" placeholder=" " name="employeeNumber" size="38" />
</div>

<div class="label-wrapper">
Product description: 
<input type="text" placeholder=" " name="employeeNumber" size="38" />
</div>



<div class="label-wrapper">
Product notes: 
<input type="text" placeholder=" " name="employeeNumber" size="38"/>
</div>

<input type="submit" name="submitmaintenance" value=<?php echo $smbutton; ?> class="submit-reset">
<input type="reset" name="reset" value="Reset" class="submit-reset">
</form>
<?php
if(isset($_POST['submitmaintenance']) and $_SESSION['NameID'] != 0)
{
   //all html form names turned into php variables 
   $dateTime = date("Y-m-d H:i:s");
   $managerID = $_POST['managerID'];
   $positionTitle = $_POST['positionTitle'];
   $estatus = $_POST['Estatus'];   
   $eprivid = 1;
   $NameID = $_SESSION['NameID'];  
   if($ecurrenttemp == 'NO')
    {
      // if the submit maintenance button is clicked do the following 
      $query = "INSERT INTO `Employee`  (`Employee_number`, `Employee_manager_id`, `Employee_account_id`, `Employee_status`,
      `Employee_start_date`, `Employee_position_title`, `Employee_created_date`, `Employee_created_by`, `Employee_last_updated`, 
      `Employee_last_updated_by`) 
      VALUES ('$employeeNumber', '$managerID', '$NameID', '$estatus', '$dateTime', '$positionTitle', '$dateTime', 'Employee Registration', 
      '$dateTime', 'Employee Registration')";
    if (!$query_run = mysqli_query($link, $query))
    {
    $query_run = 0;
    echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");   
    $estatus = 'Error';
    }
    if ($estatus == 'Active')
    {$astatusid = '2';}
    else
    {$astatusid = '1';}
    //update the acccount_type_id to employee
   
    $query7 = "UPDATE `Accounts` SET `Account_AT_id` = '".$astatusid."', `Account_last_update_date` = '".$dateTime."', `Account_last_update_by` = 'Employee Maintenance' 
    WHERE `Account_id` = '".$_SESSION['NameID']."'"; 
    if(!$query_run7 = mysqli_query($link, $query7)) 
    {
      $query_run7 = 0;
      echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");   
       }   
   $_SESSION['NameID'] = 0;
      }
      else 
      { 
      $query = "UPDATE `Employee` SET `Employee_manager_id` = '".$managerID."', `Employee_status` = '".$estatus."', `Employee_position_title` = '".$positionTitle."'
      WHERE `Employee_number` = '".$employeeNumber."'";
         if (!$query_run = mysqli_query($link, $query))
         {
            $query_run = 0;
            echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");   
         }
         if ($estatus == 'Active')
         {$astatusid = '2';}
         else
         {$astatusid = '1';}

         $query7 = "UPDATE `Accounts` SET `Account_AT_id` = '".$astatusid."', `Account_last_update_date` = '".$dateTime."', `Account_last_update_by` = 'Employee Maintenance'
         WHERE `Account_id` = '".$_SESSION['NameID']."'";
         if(!$query_run7 = mysqli_query($link, $query7)) 
         {
         $query_run7 = 0;
         echo ('Error executing query in Employeemaintenance: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");   
         }   
   $_SESSION['NameID'] = 0;
      }
      $NameID =0;
      $_SESSION['NameID'] = 0;
      
   }
   ?>

   </div> 
   </div>
   <?php include 'includes/footer.php'; ?>
   </div>
   <?php include 'includes/signout.php'; ?>
   </body>
   </html>
   <?php 
} else 
{ header('Location: login.php'); }
?>





         

