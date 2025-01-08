import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

// Class representing a Sport
class Sport {
    private String name;
    private int teamSize;

    public Sport(String name, int teamSize) {
        this.name = name;
        this.teamSize = teamSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return "Sport{name='" + name + '\'' + ", teamSize=" + teamSize + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sport sport = (Sport) o;
        return teamSize == sport.teamSize && Objects.equals(name, sport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teamSize);
    }
}

// Class representing a Player
class Player {
    private String name;
    private int age;
    private String sport;

    public Player(String name, int age, String sport) {
        this.name = name;
        this.age = age;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + '\'' + ", age=" + age + ", sport='" + sport + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age && Objects.equals(name, player.name) && Objects.equals(sport, player.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sport);
    }
}

// Class representing a Sports Club
class SportsClub {
    private String name;
    private List<Sport> sports;
    private List<Player> players;

    public SportsClub(String name) {
        this.name = name;
        this.sports = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addSport(Sport sport) {
        sports.add(sport);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> searchPlayersBySport(String sportName) {
        List<Player> result = new ArrayList<>();
        for (Player player : players) {
            if (player.getSport().equalsIgnoreCase(sportName)) {
                result.add(player);
            }
        }
        return result;
    }

    public void sortPlayersByName() {
        players.sort(Comparator.comparing(Player::getName));
    }

    public void displayAllSports() {
        for (Sport sport : sports) {
            System.out.println(sport);
        }
    }

    public void displayAllPlayers() {
        for (Player player : players) {
            System.out.println(player);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Sports Club
        SportsClub club = new SportsClub("Elite Sports Club");

        // Add Sports
        club.addSport(new Sport("Football", 11));
        club.addSport(new Sport("Basketball", 5));
        club.addSport(new Sport("Tennis", 2));

        // Add Players
        club.addPlayer(new Player("John Doe", 25, "Football"));
        club.addPlayer(new Player("Jane Smith", 22, "Basketball"));
        club.addPlayer(new Player("Mike Johnson", 30, "Tennis"));
        club.addPlayer(new Player("Emily Davis", 19, "Football"));

        // Display all sports
        System.out.println("Sports in the club:");
        club.displayAllSports();

        // Display all players
        System.out.println("\nPlayers in the club:");
        club.displayAllPlayers();

        // Search for players in a specific sport
        System.out.println("\nPlayers in Football:");
        List<Player> footballPlayers = club.searchPlayersBySport("Football");
        for (Player player : footballPlayers) {
            System.out.println(player);
        }

        // Sort and display players by name
        System.out.println("\nPlayers sorted by name:");
        club.sortPlayersByName();
        club.displayAllPlayers();
    }
}
