package ro.ianders.universitylabster.dataformat;

/**
 * Created by paul.iusztin on 08.12.2017.
 */

public class User {

    private String userID;
    private String email;
    private String password;

    public User(){

    }
    public User(String userID, String email, String password) {
        this.email = email;
        this.password = password;
        this.userID = userID;
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
}
