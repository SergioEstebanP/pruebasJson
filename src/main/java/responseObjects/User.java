package responseObjects;

import commonServices.Compare;
import org.json.JSONObject;

public class User extends JSONObject implements Compare {

    // ATTRIBUTES
    private int id;
    private String firstName;
    private String lastName;
    private String avatar;

    // BUILDER
        // PARAM
    public User (int id, String name, String lastName, String avatar) {
        setId(id);
        setName(name);
        setLastName(lastName);
        setAvatar(avatar);
    }

        // DEFAULT
    public User () {
        super();
    }

        // JSONOBJECT
    public User (JSONObject user) {
        setId(user.getInt("id"));
        setName(user.getString("first_name"));
        setLastName(user.getString("last_name"));
        setAvatar(user.getString("avatar"));
    }

    // METHODS
        // SETTER
    public void setId (int id) {
        this.id = id;
    }

    public void setName (String name) {
        this.firstName = name;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public void setAvatar (String avatar) {
        this.avatar = avatar;
    }

        // GETTERS
    public int getId () {
        return this.id;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getLastName () {
        return this.lastName;
    }

    public String getAvatar () {
        return this.avatar;
    }

    @Override
    public boolean equals(User object) {
        return (getId() == object.getId()      &
            getFirstName().equals(object.getFirstName()) &
            getLastName().equals(object.getLastName())  &
            getAvatar().equals(object.getAvatar()));
    }

}
