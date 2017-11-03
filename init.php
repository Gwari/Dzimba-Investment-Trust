<?php
$db_name="dzimbacustomerlist";
$mysql_user="root";
$mysql_pass="";
$server_name="localhost";

$con=mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name);
if(!$con)
{
	echo"Conncetion Error...".mysqli_connect_error();
}
else
{
	echo"<h3>Database conncetion Success Great....</h3>";
}

?>