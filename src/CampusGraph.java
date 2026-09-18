import java.util.*;

public class CampusGraph {

    // Adjacency List
    private Map<String, List<String>> campus;

    public CampusGraph() {
        campus = new HashMap<>();
    }

    // Add campus location
    public boolean addLocation(String location) {

        if (campus.containsKey(location)) {
            return false;
        }

        campus.put(location, new ArrayList<>());
        return true;
    }

    // Remove campus location
    public boolean removeLocation(String location) {

        if (!campus.containsKey(location)) {
            return false;
        }

        campus.remove(location);

        // Remove this location from other neighbours
        for (List<String> neighbours : campus.values()) {
            neighbours.remove(location);
        }

        return true;
    }

    // Add connection between two locations
    public boolean addConnection(String from, String to) {

        if (!campus.containsKey(from) || !campus.containsKey(to)) {
            return false;
        }

        if (from.equalsIgnoreCase(to)) {
            return false;
        }

        if (campus.get(from).contains(to)) {
            return false;
        }

        campus.get(from).add(to);
        campus.get(to).add(from);

        return true;
    }

    // Remove connection
    public boolean removeConnection(String from, String to) {

        if (!campus.containsKey(from) || !campus.containsKey(to)) {
            return false;
        }

        if (!campus.get(from).contains(to)) {
            return false;
        }

        campus.get(from).remove(to);
        campus.get(to).remove(from);

        return true;
    }

    // Display campus connections
    public void displayConnections() {

        if (campus.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("\n===== Campus Connections =====");

        for (String location : campus.keySet()) {

            System.out.print(location + " -> ");

            List<String> neighbours = campus.get(location);

            if (neighbours.isEmpty()) {
                System.out.println("No connections");
            } else {
                System.out.println(String.join(", ", neighbours));
            }
        }
    }

    // BFS traversal
    public void bfs(String startLocation) {

        if (!campus.containsKey(startLocation)) {
            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startLocation);
        queue.offer(startLocation);

        System.out.println("\n===== BFS Campus Traversal =====");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.println(current);

            for (String neighbour : campus.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
    }

    // Check whether a location exists
    public boolean containsLocation(String location) {
        return campus.containsKey(location);
    }
}