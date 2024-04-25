<?php
include 'includes/core.php';
include 'includes/connection.php';
date_default_timezone_set('America/New_York');
error_reporting(E_ERROR | E_PARSE);
?>

<?php
if(loggedin()) {
   $_SESSION['Login_username'] = getuserfield('Login_username');
   $LoginID = $_SESSION['Login_id'];
   
   //select all the information from accounts where it equals to the session login ID 
   $query = "SELECT * FROM `Accounts`, Login WHERE `Account_id` = Login_account_id and Login_id = '".$_SESSION['Login_id']."'";
   if(!$result = mysqli_query($link, $query))
   {
      $result = 0;
      echo ('Error executing query1: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
   }   
   else 
   {
   $row = mysqli_fetch_array($result,MYSQLI_BOTH);
   //putting account table columns in variables 
   $firstName = $row['Account_firstname'];
   $accountID = $row['Account_id'];
   
   //selecting all from inventory
   $query2 = "SELECT * FROM `Inventory`";
   if (!$result2 = mysqli_query($link, $query2))
   {
      $result2 = 0;
      echo ('Error executing query2: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
      }
      else
      {
         $row2 = mysqli_fetch_array($result2,MYSQLI_BOTH);
      }
   }
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

<?php
   //selecting all from the shopping cart and products 
   $query = "SELECT * FROM `Shopping_cart`, Products, Inventory WHERE `SC_account_id` = $accountID AND `SC_inventory_id` = `Inventory_id` AND `Inventory_product_id` = `Products_id` order by 'SC_inventory_id'";
   
   if(!$result = mysqli_query($link, $query))
   {
      $result = 0;
      echo ('Error executing query: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
   }   
   else 
   {
   print '<div style="width:225px; height:40px; float:left; line-height:40px; font-size:18px; font-weight:bold;">Product Name</div>';
   print '<div style="width:105px; height:40px; float:left; line-height:40px; font-size:18px; font-weight:bold;">Quantity</div>';  
   print '<div style="width:115px; height:40px; float:left; line-height:40px; font-size:18px; font-weight:bold;">Unit Price</div>';   
   print '<div style="width:105px; height:40px; float:left; line-height:40px; font-size:18px; font-weight:bold;">Subtotal</div>';  
      //variable for total starts at 0
      $total = 0;
      
      //Loop through all shopping cart and products display
      while($row = mysqli_fetch_assoc($result)) 
      {
        //add a variable for shopping cart order quantity
        $inventoryRemoveQuan = $row['SC_order_quantity'];
        print '<form method="post" action="">';
        print '<br>';
        print '<br>';       
        print '<hr>';
        print '<input type="hidden" value="'.$row[SC_inventory_id].'" name="id"/>';
        print '<div style="width:235px; height:40px; float:left; line-height:40px;">' . $row[Products_name] . '</div>'; 
        print '<div style="width:110px; height:40px; float:left; line-height:40px;"><input type="text" name="quantityOrdered" value="' . $inventoryRemoveQuan . '" style="width:40px; height:20px;"></div>';
        print '<div style="width:110px; height:40px; float:left; line-height:40px;">$'.number_format($row[SC_unit_price],2) . '</div>';
        print '<div style="width:105px; height:40px; float:left; line-height:40px;">$'.number_format($subTotal = $inventoryRemoveQuan * $row[SC_unit_price],2). '</div>';
        print '<div style="width:150px; height:40px; float:left;"><input type="submit" name="remove" value="Remove Item" class="removeItem"/></div>';
        print '<div style="width:150px; height:40px; float:left;"><input type="submit" name="updateQuan" value="Update Quantity" class="updateItem"/></div>';
        print '<br>';
        print '<br>';
        print '<br>';       
        print '<hr>';                                      
    //total variable inside loop adds all unit prices together 
        $total += $subTotal;
        print '</form>';
        }
        print '<br>';
        print '<br>';
        print '<br>';       
        //display purchase cost
        print 'Purchases $ '. number_format($total,2);
        print '<br>'; 
        //shipping variable 
        $shipping = 17.90;
        //display shipping cost
        print 'Shipping $ '. number_format($shipping,2);
        print '<br>';                
        print '<br>';                
        //display the total added to the shipping into variable grandtotal
        print 'Total $'. number_format($grandtotal= $total + $shipping,2);
        print '<br>';
        print '<br>';
        print '<br>';   
        print $error;
          print '<form action="" method="post">';
          print '<input type="submit" name="submitCheckout" value="Checkout" class="test"/>';
          print '</form>';
          
     if(isset($_POST['remove']))
     {
       //if the remove button is clicked post the ID into a variable ID 
       $id=intval($_POST['id']);
       
       //delete the item from the shopping cart that was removed
       $query3 ="DELETE FROM `Shopping_cart` WHERE `SC_inventory_id` = '$id' AND `SC_account_id` = '$accountID' ";
       
       if (!$query_run3 = mysqli_query($link, $query3))
       {
          $result = 0;
          echo ('Error executing query3: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
       }   
       else 
       {                  
       //relink to the carts page
       header('Location: cart.php');
       }
       }
       
       if(isset($_POST['updateQuan']))
       {
       //check to see if the update quatity was checked if it was post variable to ID and other variables
          $id=intval($_POST['id']);
          $quantityOrdered = $_POST['quantityOrdered'];
          if($quantityOrdered != 0)
          {
             //update the shopping cart with the quantity 
             $query19 = "UPDATE `Shopping_cart` SET `SC_order_quantity` = '".$quantityOrdered."', `SC_last_updated_date` = now(), `SC_last_updated_by` = 'Update Cart (Updated)' WHERE `SC_account_id` = $accountID AND `SC_inventory_id` = $id ";
             if (!$query_run19 = mysqli_query($link, $query19))
          {
          $result = 0;
          echo ('Error executing query19: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
             }   
          }
          else 
          { 
          
          //delete the item from the shopping cart that was removed
          $query3 ="DELETE FROM `Shopping_cart` WHERE `SC_inventory_id` = '$id' AND `SC_account_id` = '$accountID' ";
          if (!$query_run3 = mysqli_query($link, $query3))
          {
          $result = 0;
          echo ('Error executing query3: ' . mysqli_errno($link)." - ".mysqli_error($link)."<BR>");
          }   
          }
 
        //link to customer cart page 
        header('Location: cart.php'); 
        }
        
        if(isset($_POST['submitCheckout']) and $total != 0)   
        {
           //check if submit checkout was clicked 
           
           //link to customer checkout page
           echo "<script type='text/javascript'> document.location = 'checkout.php';
           </script>";
           }
           }
           ?>
           </div>
           <?php include 'includes/footer.php'; ?>
           </div>
           <?php include 'includes/signout.php'; ?>
           
   </body>
   </html>
   <?php
   
      } else {
      header('Location: login.php');
      }
   ?>
