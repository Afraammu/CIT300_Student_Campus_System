import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {

    private Queue<String> requests;

    public ServiceQueue() {
        requests = new LinkedList<>();
    }

    // Add a service request
    public void addRequest(String request) {
        requests.offer(request);
    }

    // Process the first request
    public String processRequest() {

        if (requests.isEmpty()) {
            return null;
        }

        return requests.poll();
    }

    // Display all requests
    public void displayRequests() {

        if (requests.isEmpty()) {
            System.out.println("No service requests available.");
            return;
        }

        System.out.println("\n===== Student Service Requests =====");

        for (String request : requests) {
            System.out.println("- " + request);
        }
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return requests.isEmpty();
    }
}