package application;

import java.util.ArrayList;
import java.util.Scanner;

public class CreatorDatabase extends AbstractDatabase{
    private ArrayList<Creator> creatorList;
    private Creator connectedUser;
    private Scanner in = new Scanner(System.in);

    public CreatorDatabase()
    {
        this.creatorList = new ArrayList<>();
        this.connectedUser = null;
    }

    // getters
    public ArrayList<Creator> getCreatorList() {
        return creatorList;
    }
    public Creator getConnectedUser() {
        return connectedUser;
    }

    // setters
    public void setConnectedUser(Creator connectedUser) {
        this.connectedUser = connectedUser;
    }

    @Override
    public void registerUser()
    {
        Creator newUser = new Creator(null, null, null, 0);

        try {
            System.out.println("Type your e-mail adress: ");
            newUser.setEmail(in.nextLine());
            System.out.println("Type your password: ");
            newUser.setPassword(in.nextLine());
            System.out.println("Type your user nickname: ");
            newUser.setNickname(in.nextLine());
            System.out.println("How old are you: ");
            newUser.setAge(in.nextInt());
            
            if (newUser.getAge() < 18)
            {
                System.out.println("You're a minor, you don't have permission to create a creator account!!!");
                return;
            }

            creatorList.add(newUser);
            System.out.println("New creator created successfully!\n");
        }
        catch (java.util.InputMismatchException e) 
        {
            System.out.println("Invalid input.");
        } 
        catch (java.util.NoSuchElementException e) 
        {
            System.out.println("Error reading input. Please try again.");
        }
    }

    public Creator validateUser(String email, String password) {
        for (Creator user : creatorList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Creator searchUser(String nickname) {
        for (Creator user : creatorList) {
            if (user.getNickname().equals(nickname)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void login()
    {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Type your e-mail adress: ");
            String emailString = in.nextLine();
            System.out.println("Type your password: ");
            String passwordString = in.nextLine();
            
            if (validateUser(emailString, passwordString) != null)
            {
                setConnectedUser(validateUser(emailString, passwordString));
                System.out.println("Logged in successfully!\n");
            }
            else
            {
                System.out.println("User not found\n");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during login...");
        }
    }

    @Override
    public void logout()
    {
        setConnectedUser(null);
    }

    public void createGame(Creator connectedCreator,GameLibrary gameLibrary)
    {
        Scanner in = new Scanner(System.in);

        try {
            Game newGame = new Game(null, 0);

            System.out.println("What's the name of the game?");
            newGame.setName(in.nextLine());
            System.out.println("How much it costs?");
            newGame.setPrice(in.nextInt());

            gameLibrary.getGameList().add(newGame);
            connectedCreator.getCreatedGames().getGameList().add(newGame);
            System.out.println("Game published succesfully!\n");
            return;
        } catch (Exception e) {
            System.out.println("Invalid game information...");
        }
    }

    public void showCreatedGames(Creator connectedCreator)
    {
        if (connectedCreator.getCreatedGames() == null)
        {
            System.out.println("You haven't created any games yet...\n");
            return;
        }
        System.out.println(connectedCreator.getCreatedGames());
    }

    @Override
    public String toString() {
        StringBuilder userString = new StringBuilder();

        for (Creator user : creatorList) {
            userString.append(user);
        }

        return userString.toString();
    }
}
