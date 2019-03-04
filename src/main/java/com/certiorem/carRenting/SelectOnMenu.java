package com.certiorem.carRenting;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class SelectOnMenu {
	
	private Connection conn = null;
	private Scanner scanner = new Scanner(System.in);
	private int selectedOption;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String url;
    private String host;
    private String port;
    private String db;
    private String user;
    private String pass;
    
	
	
		
	public SelectOnMenu() throws Exception {
		
		this.host = "localhost";
		this.port = "3306";
		this.db = "car_renting";
		this.user = "root";
		this.pass = "Pa$$w0rd";
		
		this.url= "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + pass + "&useSSL=false";
		ConnectToDb();
	}
	
	public void ConnectToDb() throws Exception {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(url);
			this.statement = conn.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showMessage() {
		
		System.out.println("\nSelect one number to select option: \n -> Show all the cars (1) \n -> Insert new car (2) \n "
				+ "-> Update car (3) \n -> Delete car (4) \n -> Exit (5)");
		
		selectedOption = scanner.nextInt();
		
		
		
	}
	
	public void selectedMenuSwitcher() throws Exception {
		switch (selectedOption) {
			case 1:
				showDb();
				break;
			case 2:
				insertNewCar();
				break;
			case 3:
				System.out.println("Select car to update: ");
				
				break;
			case 4:
				System.out.println("Select car id to delete: ");
				int carIdSelected = scanner.nextInt();
				deleteCar(carIdSelected);
				break;
			case 5:
				System.exit(0);
				break;
	
			default:
				break;
		}
	}
	
	public void insertNewCar() {
		
		System.out.print("Insert the car id: ");
		int carId = scanner.nextInt();
		
		System.out.print("Insert the car brand: ");
		String carBrand = scanner.nextLine();
		carBrand = scanner.nextLine();
		
		System.out.print("Insert the car model: ");
		String carModel = scanner.nextLine();
		
		System.out.print("Insert the doors amount: ");
		int doors = scanner.nextInt();
		
		
		System.out.print("Insert the car renting price per day: ");
		int rentingPricePerDay = scanner.nextInt();
		
		//Cars car = new Cars(carBrand, carModel, doors, rentingPricePerDay);
		
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO car_renting.cars values (?,?,?,?,?)");
			preparedStatement.setInt(1, carId);
			preparedStatement.setString(2, carBrand);
			preparedStatement.setString(3, carModel);
			preparedStatement.setInt(4, doors);
			preparedStatement.setInt(5, rentingPricePerDay);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----Car added to DB!-----");
	}
	
	public void updateCar() {
		
	}
	
	public void deleteCar(int carIdSelected) {
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM car_renting.cars WHERE car_id = " + carIdSelected);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----Car deleted from DB!-----");
	}
	
	public void showDb() throws Exception {
		try {
			resultSet = statement.executeQuery("SELECT * FROM car_renting.cars;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        writeResult(resultSet);
	}
	
	public void writeResult(ResultSet resultSet) throws Exception {
		
		while(resultSet.next()) {
			
			String carBrand = resultSet.getString("car_brand");
			String carModel = resultSet.getString("car_model");;
			Integer doors = resultSet.getInt("car_door");
			Integer price= resultSet.getInt("car_renting_price");
			
			System.out.println("Car brand: " + carBrand + "\nCar model: " + carModel + "\nCar doors: " + doors + "\nRenting price per day: " + price + "\n");
			
		}
		
	}
	
	

}
