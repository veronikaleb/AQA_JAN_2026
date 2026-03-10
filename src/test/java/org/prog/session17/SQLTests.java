package org.prog.session17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.session16.dto.PersonDto;
import org.prog.session16.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.Socket;
import java.sql.*;
import java.util.List;

//TODO: run this and make sure it works

public class SQLTests {

    private Connection conn;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "root",
                "password"
        );
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    @Test
    public void testSQLSelect() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from Persons");

        while (resultSet.next()) {
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String title = resultSet.getString("Title");

            System.out.println(title + " " + firstName + " " + lastName);
        }
    }

    @Test
    public void testSQLInsert() throws SQLException {
        Statement stmt = conn.createStatement();
        boolean result = stmt.execute("INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                "VALUES ('TestFirstName1', 'TestLastName1', 'TestGender', 'TestTitle', 'TestNat')");
        Assert.assertFalse(result, "Failed to insert into DB");
    }

    @Test
    public void populateDbTest() throws SQLException {
        //request users from service
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("inc", "gender,name,nat");
        requestSpecification.queryParam("results", "3");

        Response response = requestSpecification.get();
        ResultsDto dto = response.as(ResultsDto.class);
        //turn them to java list
        List<PersonDto> persons = dto.getResults();

        //for each element in list -> record to DB
        PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                        "VALUES (?, ?, ?, ?, ?)");

        for (PersonDto person : persons) {
            preparedStatement.setString(1, person.getName().getFirst());
            preparedStatement.setString(2, person.getName().getLast());
            preparedStatement.setString(3, person.getGender());
            preparedStatement.setString(4, person.getName().getTitle());
            preparedStatement.setString(5, person.getNat());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to insert into DB " + person);
            }
        }


//        Statement stmt = conn.createStatement();
//        for (PersonDto person : persons) {
//            boolean result = stmt.execute(
//                    "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
//                            "VALUES ('" + person.getName().getFirst() + "', 'TestLastName1', 'TestGender', 'TestTitle', 'TestNat')");
//        }
    }
}
