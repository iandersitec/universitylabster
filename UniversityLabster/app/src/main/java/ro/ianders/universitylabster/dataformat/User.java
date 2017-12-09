package ro.ianders.universitylabster.dataformat;

import java.util.HashMap;

/**
 * Created by paul.iusztin on 08.12.2017.
 */

public class User {

    private String userID;
    private String email;
    private String password;
    private String username;
    private String firstName;
    private String lastName;
    private String year;
    private String faculty;

    public User(){

    }
    public User(String userID, String email, String password) {
        this.email = email;
        this.password = password;
        this.userID = userID;
        this.username = "username";
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.year = "year";
        this.faculty = "faculty";
    }

    public User(String userID, String email, String password, String username, String firstName, String lastName, String year, String faculty) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.faculty = faculty;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getYear() {
        return year;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public HashMap<String, Object> toMap() {
        HashMap<String, Object> myMap = new HashMap<>();


        myMap.put("email", email);
        myMap.put("userID", userID);
        myMap.put("firstName", firstName);
        myMap.put("lastName", lastName);
        myMap.put("year", year);
        myMap.put("faculty", faculty);
        myMap.put("password", password);
        myMap.put("username", username);

        return myMap;
    }
}
