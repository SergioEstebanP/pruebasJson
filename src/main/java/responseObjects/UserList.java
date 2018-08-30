package responseObjects;

import commonServices.Compare;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserList extends JSONObject implements Compare {

    // ATTRIBUTES
    private ArrayList<User> listaUsuarios;
    private int page;
    private int per_page;
    private int total;
    private int total_pages;

    // BUILDERS
        // DEFAULT
    public UserList () {
        super();
    }

        // JSONOBJECT
    public UserList (JSONObject userList) {

    }

        // PARAMETERS
    public UserList () {

    }


    // METHODS
        // SETTERS
    public void set
    @Override
    public boolean equals(User object) {
        return false;
    }
}
