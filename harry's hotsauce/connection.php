<html>
<title>Connection Test Page</title>
<body><center> Amanda Martel Connections Test Page</center>
<p>
<?PHP
/* The Connection to the MySQL Database */
include 'Appendix_A_Connection.php';
$link = mysqli_connect($db_host, $db_user, $db_pass, $db_dbname, $db_port);
if(mysqli_connect_error()) {
    die('Could not connect: ' . mysqli_connect_error($link)." - ".mysqli_connect_error($link)."<BR>");   
}
else 
{
    echo 'Connected successfully<BR>';
}
$db_query = "Select * from ".$db_dbname.".CONNECTION_TEST";
//Execute query
if(!$result = mysqli_query($link, $db_query))
{
    $result = 0;
    die('Error executing query: ' . mysqli_error()." - ".mysqli_error()."<BR>");
}
else 
{
    //retrieve  and print the first row of data only 
    $array = mysqli_fetch_array($result,MYSQLI_BOTH);
    $out_status = $array[0];
    echo $array[0]."  ";
    echo $array[1]."  ";
    echo $array[2]."  ";
    print("<BR><BR>");
    //retrieve and print entire table 
    $result = mysqli_query($link, $db_query); //force requery to start again
    while($array = mysqli_fetch_array($result,MYSQLI_BOTH))
    {
        print("<FONT COLOR='RED'>$array[0]   $array[1]  $array[2]</FONT><BR>");
    }
}

mysqli_close($link);
echo ' <BR /><BR />';
echo '<a href="main.html">Home Page</a> ';
?>
</p>
</body>
</html>