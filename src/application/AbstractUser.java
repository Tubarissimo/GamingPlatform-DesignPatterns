package application;

public abstract class AbstractUser {
    protected String email;
    protected String password;
    protected String nickname;
    protected int age;

    public AbstractUser(String email, String password, String nickname, int age)
    {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
    }

    // GETTERS
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getNickname() {
        return nickname;
    }
    public int getAge() {
        return age;
    }
}
