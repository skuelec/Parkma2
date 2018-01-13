package at.se.fhcampus.parkma2.models;

/**
 * Created by kuele on 27.12.2017.
 */

public class User {


    /* Attribute/Variablen */
    private String username;
    private String password;


    /* Konstruktoren */
    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    /* Methoden */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
