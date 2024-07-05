package DSA3;

import java.util.Arrays;

public class SoftballLeague extends HashTable {

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

    public SoftballLeague() {
        super(12);
    }


    public void addTeam(String teamName, Player[] playerRoster) {
        if(getIndex(teamName) == -1 && countNonNull() == 12){
            throw new IllegalStateException("Number of teams exceeds the limit of 12.");
        }

        put(teamName, playerRoster);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Entry entry : table) {
            if (entry != null && entry.value != null) {
                sb.append(entry.key + ": " + Arrays.toString((Player[]) entry.value) + "\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Test case: Create a softball hash table and add teams with rosters
        SoftballLeague softballTable = new SoftballLeague();

        Player[] team1Roster = new Player[15];
        for (int i = 0; i < 13; i++) {
            team1Roster[i] = new Player("John", "Doe", i + 1);
        }

        Player[] buckRoster = new Player[15];
        for (int i = 0; i < 13; i++) {
            buckRoster[i] = new Player("Buck", "Doe", i + 1);
        }

        for(int i=0; i<12; i++){
            softballTable.addTeam("Team"+i, Arrays.copyOfRange(team1Roster, 0, team1Roster.length));
        }

        System.out.println("Initial table: \n" + softballTable);
        softballTable.put("Team11", buckRoster);

        System.out.println("After overwriting Team11: \n" + softballTable);

        System.out.println("Exceeding the limit of 12 teams: ");
        try{
            softballTable.addTeam("Team12", buckRoster);
            System.out.println(softballTable);
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

        softballTable.remove("Team2");
        System.out.println("After removing Team2: \n" + softballTable);

    }
}
