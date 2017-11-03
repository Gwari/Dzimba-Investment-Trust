<?php

require "init.php";
//define variables
$name=null;
$identification=null;
$cellnumber=null;
$payment=null;
$house=null;
$duration=null;


if(isset($_POST['name'])){
	$name=$_POST['name'];
}
if(isset($name)){
	echo $name;
}

if(isset($_POST['identification'])){
	$identification=$_POST['identification'];
}

if(isset($_POST['cellnumber'])){
	$cellnumber=$_POST['cellnumber'];
}

if(isset($_POST['payment'])){
	$$payment=$_POST['payment'];
}

if(isset($_POST['house'])){
	$house=$_POST['house'];
}

if(isset($_POST['duration'])){
	$duration=$_POST['duration'];
}

//launch sqlquery to insert data into table customer_list
$sql_query="insert into customer_list values('$name','$identification','$cellnumber','$payment','$house','$duration');";

if(mysqli_query($con,$sql_query))
{
	//echo "<h3> Data Insertion Success Great...</h3>";
}
else
{
	//echo "Data insertion error....".mysqli_error($con);
}

?>