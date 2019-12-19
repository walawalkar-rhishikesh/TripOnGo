<?php

include_once 'connection.php';
	
	class User {
		
		private $db;
		private $connection;
		
		
		function __construct() {
			$this -> db = new DB_Connection();
			$this -> connection = $this->db->getConnection();
		}
		
		public function does_user_exist($email,$password,$firstname,$lastname,$mobile,$dob,$city,$country)
		{
			$query = "Select * from users where email='$email' or mobile= '$mobile' ";
			$result = mysqli_query($this->connection, $query);
			if(mysqli_num_rows($result)>0){
				$json['exists'] = ' User already exists';
				echo json_encode($json);
				mysqli_close($this -> connection);
			}else{
				$query = "insert into users (email, password, firstname, lastname, mobile, dob, city, country) values ( '$email','$password', '$firstname','$lastname','$mobile','$dob','$city','$country')";
				$inserted = mysqli_query($this -> connection, $query);
				if($inserted == 1 ){
					$json['success'] = 'Account created';
				}
				}
				echo json_encode($json);
				mysqli_close($this->connection);
			}
			
		}
		
	
	
	$user = new User();
	if(isset($_POST['email'],$_POST['password'], $_POST['firstname'], $_POST['lastname'], $_POST['mobile'], $_POST['dob'], $_POST['city'], $_POST['country'] )) {
		$email = $_POST['email'];
		$password = $_POST['password'];
		$firstname = $_POST['firstname'];
		$lastname = $_POST['lastname'];
		//$gender = $_POST['gender'];
		$mobile = $_POST['mobile'];
		$dob = $_POST['dob'];
		$city = $_POST['city'];
		$country = $_POST['country'];
		
		if(!empty($email) && !empty($password) && !empty($firstname) && !empty($lastname) && !empty($mobile) && !empty($dob) && !empty($city) && !empty($country)){
			
			$encrypted_password = md5($password);
			$user-> does_user_exist($email,$password, $firstname, $lastname, $mobile, $dob, $city, $country);
			
		}else{
			echo json_encode("All the fields are required");
		}
		
	}
	
?>
	