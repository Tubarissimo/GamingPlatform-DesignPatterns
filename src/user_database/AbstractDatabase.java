package user_database;

import java.util.ArrayList;
import user.*;

public abstract class AbstractDatabase {
    protected ArrayList<AbstractUser> userList;
    protected AbstractUser connectedUser;

    public AbstractDatabase(){
        this.userList = new ArrayList<>();
        this.connectedUser = null;
    }

    // GETTERS
    public ArrayList<AbstractUser> getUserList() {
        return userList;
    }
    public AbstractUser getConnectedUser() {
        return connectedUser;
    }

    // SETTERS
    public void setConnectedUser(AbstractUser connectedUser) {
        this.connectedUser = connectedUser;
    }

    public abstract void registerUser();

    public abstract void login();

    public abstract void logout();

    public AbstractUser validateUser(String email, String password) {
        for (AbstractUser user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public AbstractUser searchUser(String nickname) {
        for (AbstractUser user : userList) {
            if (user.getNickname().equals(nickname)) {
                return user;
            }
        }
        return null;
    }

    public AbstractUser userExists(String string) {
        for (AbstractUser user : userList) {
            if (user.getEmail().equals(string)) {
                return user;
            } else if (user.getNickname().equals(string)){
                return user;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder userString = new StringBuilder();

        for (AbstractUser user : userList) {
            userString.append(user);
        }

        return userString.toString();
    }
}
