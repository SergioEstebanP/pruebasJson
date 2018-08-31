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
    public UserList (int a) {
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
    @Override
    public boolean equals(User object) {
        return false;
    }
}
