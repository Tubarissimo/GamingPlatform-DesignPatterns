package application;

public class Creator extends AbstractUser {
    private GameLibrary createdGames;


    public Creator(String email,String password,String nickname,int age)
    {
        super(email,password,nickname,age);

        this.createdGames = new GameLibrary();
    }

    // GETTERS
    public GameLibrary getCreatedGames() {
        return createdGames;
    }

    // SETTERS
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String showLibrary()
    {
        StringBuilder gameString = new StringBuilder();

        gameString.append("\tLIBRARY\n\n");
        for (Game game : createdGames.getGameList()) {
            gameString.append("\t").append(createdGames.getGameList().indexOf(game)+1).append(" >> ").append(game.getName()).append("\n");
        }
        gameString.append("\n");

        if (gameString.toString() == "") return "You have created no game yet...\n";
        return gameString.toString();
    }

    @Override
    public String toString() 
    {
        return  "NAME:\t " + this.nickname + "\n\n" + 
                "AGE:\t " + this.age + "\n\n" +
                "CONTACT: " + this.email + "\n\n" +
                "\n\n";
    }
}
