package DSA3;

//import hashtable from java inbuilt library
import java.util.Hashtable;

public class PlayerRoster extends HashTable {

    public static class Player {
        protected String firstName;
        protected String lastName;
        protected int number;

        public Player(String firstName, String lastName, int number) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.number = number;
        }

        public String toString() {
            return firstName + " " + lastName + " #" + number;
        }
    }

    public PlayerRoster(Player[] players) {
        super(12 <= countNonNull(players) && countNonNull(players) <= 15 ? countNonNull(players) : 12);
        int nonNullLen = countNonNull(players);
        if (12 > nonNullLen || nonNullLen > 15) {
            throw new IllegalStateException("Size must be between 12 and 15");
        }
        for (Player player : players) {
            put(player.number, player);
        }
    }

    public void addPlayer(String firstName, String lastName, int number) {
        Player player = new Player(firstName, lastName, number);
        put(player.number, player);
    }

    public void addPlayer(Player player) {
        put(player.number, player);
        if (countNonNull() < 12 || countNonNull() > 15) {
            throw new IllegalStateException("Size must be between 12 and 15, currently " + countNonNull());
        }
    }

    public void removePlayer(int number) {
        if (countNonNull() < 12 || countNonNull() > 15) {
            throw new IllegalStateException("Size must be between 12 and 15");
        }
        remove(number);
    }

    public Player retrievePlayer(int number) {
        return (Player) get(number);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Entry entry : table) {
            if (entry != null && entry.value != null) {
                sb.append(entry.toString() + ",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Test Case 1: Create a player roster with an initial set of players
        Player[] initialPlayers = new Player[13];

        for(int i = 0; i < 13; i++) {
            initialPlayers[i] = new Player("John", "Smith", i + 1);
        }

        PlayerRoster playerRoster1 = new PlayerRoster(initialPlayers);
        System.out.println("Initial Player Roster: " + playerRoster1);

        // Test Case 2: Add a new player
        System.out.println("Adding Bob Johnson");
        playerRoster1.addPlayer("Bob", "Johnson", 4);
        System.out.println("Player Roster after adding Bob Johnson: " + playerRoster1);

        // Test Case 3: Remove a player
        System.out.println("Removing player with number 2");
        playerRoster1.removePlayer(2);
        System.out.println("Player Roster after removing player with number 2: " + playerRoster1);

        // Test Case 4: Retrieve a player
        System.out.println("Retrieving player with number 1");
        Player retrievedPlayer = playerRoster1.retrievePlayer(1);
        System.out.println("Retrieved Player: " + retrievedPlayer);

        // Test Case 5: Try to add a player with an existing number (should not be allowed)
        System.out.println("Adding a player with number 1 (should overwrite existing player)");
        playerRoster1.addPlayer("Charlie", "Brown", 1); // Number 1 is already in use
        System.out.println("Player Roster after adding Charlie Brown: " + playerRoster1);

        // Test Case 6: Try to create a roster with less than 12 players (should not be allowed)
        try {
            PlayerRoster smallRoster = new PlayerRoster(new Player[5]);
            smallRoster.addPlayer("Small", "Roster", 5);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test Case 7: Try to add more than 15 players (should not be allowed)
        Player[] tooManyPlayers = new Player[16];
        for (int i = 0; i < 16; i++) {
            tooManyPlayers[i] = new Player("Exceed", "Limit", i + 1);
        }
        try {
            PlayerRoster excessiveRoster = new PlayerRoster(tooManyPlayers);
            System.out.println("Excessive Roster: " + excessiveRoster);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        }    

}
