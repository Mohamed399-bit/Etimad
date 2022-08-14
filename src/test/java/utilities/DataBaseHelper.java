/*
 * Copyright (c) INTELLISC 2020.
 * All Rights Reserved.
 *
 * ver          Developer          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00  Eng. Mohamed Abden 23/06/2020 - Script created.
 */
package utilities;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBaseHelper {

	public static String valueID;
	public static String valueNAme;
	public static String valueTimeForm;
	public static String valueTimeTo;

	public static String lectureName;
	public static String lectureTime;



	//Method to connect to oracle database and run SQL query
	public static void getValuesFromDataBase ()
	{  
		 String url = "jdbc:postgresql://192.168.0.174:5432/aman_ph2_stg";
	        String user = "postgres";
	        String password = "postgres";


			try (
					Connection connection =
							DriverManager.getConnection(url, user, password))
			//Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")
			{

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("select ttc.id,ttc.desc_ar ,TO_CHAR(ttc.time_from,'HH:MI') ,TO_CHAR(ttc.time_to,'HH:MI')\n" +
					"from aman_ph2_stg.tms.tms_training_class ttc\n" +
					"where ttc.training_type_id = 4\n" +
					"and TO_CHAR(ttc.created_date,'MM-DD-YYYY') = TO_CHAR(CURRENT_TIMESTAMP,'MM-DD-YYYY')\n" +
					"order by id desc;");
			while (resultSet.next()) {
			//System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("model"), resultSet.getString("price"));
				valueID = resultSet.getString(1);
				valueNAme = resultSet.getString(2);
				valueTimeForm = resultSet.getString(3);
				valueTimeTo = resultSet.getString(3);
			}

			} catch (Exception ex) {
		System.out.println("Connection failure.");
		ex.printStackTrace();
	}
			System.out.println(valueID);
			System.out.println(valueNAme);
			System.out.println(valueTimeForm);
			System.out.println(valueTimeTo);

	}


	public static String getRoadExamNameFromDataBase(String dateToday){
		String url = "jdbc:postgresql://192.168.0.174:5432/aman_ph2_stg";
		String user = "postgres";
		String password = "postgres";
		String roadExamName = null;

		try (
				Connection connection = DriverManager.getConnection(url, user, password))
		//Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select ttc.desc_ar\n" +
					"from aman_ph2_stg.tms.tms_training_class ttc\n" +
					"where ttc.training_type_id = 4\n" +
					"and TO_CHAR(ttc.created_date,'MM-DD-YYYY') = TO_CHAR(CURRENT_TIMESTAMP,'MM-DD-YYYY')\n" +
					"and TO_CHAR(ttc.time_from,'HH:MI') = '"+ dateToday +"'\n" +
					"order by id desc;");
			//"+getReservationTimeForRoadExam()+"

			while (resultSet.next()) {
				roadExamName = resultSet.getString(1);
			}

		} catch (Exception ex) {
			System.out.println("Connection failure.");
			ex.printStackTrace();
		}
		//System.out.println("Road Exam name is : " + roadExamName);
		return roadExamName;
	}

	public static void updateClassForRoadExamToday(){

		String url = "jdbc:postgresql://192.168.0.174:5432/aman_ph2_stg";
		String user = "postgres";
		String password = "postgres";

		try (
				Connection connection = DriverManager.getConnection(url, user, password))
		//Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")
		{
			Statement statement = connection.createStatement();
			String sql = "update aman_ph2_stg.tms.tms_training_class\n" +
					"set status = 1\n" +
					"where training_type_id = 4\n" +
					"and TO_CHAR(created_date,'MM-DD-YYYY') = TO_CHAR(CURRENT_TIMESTAMP,'MM-DD-YYYY')";
			statement.executeUpdate(sql);

			connection.close();
		} catch (Exception ex) {
			System.out.println("Connection failure.");
			ex.printStackTrace();
		}
	}

	public static String getUserNameForEmp(String nationalid){
		String url = "jdbc:postgresql://192.168.0.174:5432/aman_ph2_stg";
		String user = "postgres";
		String password = "postgres";
		String username = null;

		try (
				Connection connection = DriverManager.getConnection(url, user, password))
		//Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select e.national_id \n" +
					"from aman_ph2_stg.staffum.employee e\n" +
					"where e.user_id = (select tcf.user_id\n" +
					"from aman_ph2_stg.tms.tms_class_facilitators tcf\n" +
					"where tcf.training_class_id = (select ttc.id \n" +
					"from aman_ph2_stg.tms.tms_training_class ttc\n" +
					"where ttc.id = (select ta.training_class_id\n" +
					"from aman_ph2_stg.tms.tms_attendees ta\n" +
					"where ta.national_id ='"+ nationalid +"')\n" +
					"and ttc.training_type_id = 1))\n" +
					"limit 1");
			//"+getReservationTimeForRoadExam()+"

			while (resultSet.next()) {
				username = resultSet.getString(1);
			}

		} catch (Exception ex) {
			System.out.println("Connection failure.");
			ex.printStackTrace();
		}
		//System.out.println("Road Exam name is : " + roadExamName);
		return username;
	}

	public static void getLectureNameAndTime(String nationalID){
		String url = "jdbc:postgresql://192.168.0.174:5432/aman_ph2_stg";
		String user = "postgres";
		String password = "postgres";
		String username = null;

		try (
				Connection connection = DriverManager.getConnection(url, user, password))
		//Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select ttc.desc_ar , TO_CHAR(ttc.time_from,'HH:MI')\n" +
					"from aman_ph2_stg.tms.tms_training_class ttc\n" +
					"where ttc.id = (select ta.training_class_id\n" +
					"from aman_ph2_stg.tms.tms_attendees ta\n" +
					"where ta.national_id ='"+nationalID+"')\n" +
					"and ttc.training_type_id = 1;");
			//"+getReservationTimeForRoadExam()+"

			while (resultSet.next()) {
				lectureName = resultSet.getString(1);
				lectureTime = resultSet.getString(2);
			}

		} catch (Exception ex) {
			System.out.println("Connection failure.");
			ex.printStackTrace();
		}
		//System.out.println("Road Exam name is : " + roadExamName);
	}

	public static void updateTrianingClassForLectures(){

		String url = "jdbc:postgresql://192.168.0.174:5432/aman_ph2_stg";
		String user = "postgres";
		String password = "postgres";

		try (
				Connection connection = DriverManager.getConnection(url, user, password))
		//Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")
		{
			Statement statement = connection.createStatement();
			String sql = "update aman_ph2_stg.tms.tms_training_class\n" +
					"set status = 1\n" +
					"where training_type_id = 1\n" +
					"and TO_CHAR(created_date,'MM-DD-YYYY') = TO_CHAR(CURRENT_TIMESTAMP,'MM-DD-YYYY')";
			statement.executeUpdate(sql);

			connection.close();
		} catch (Exception ex) {
			System.out.println("Connection failure.");
			ex.printStackTrace();
		}
	}
}
