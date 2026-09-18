import java.util.Stack;

public class ActionStack {

    private Stack<String> actions;

    public ActionStack() {
        actions = new Stack<>();
    }

    // Add a new action
    public void pushAction(String action) {
        actions.push(action);
    }

    // Remove and return the most recent action
    public String popAction() {
        if (actions.isEmpty()) {
            return null;
        }

        return actions.pop();
    }

    // Display recent actions
    public void displayActions() {

        if (actions.isEmpty()) {
            System.out.println("No recent actions available.");
            return;
        }

        System.out.println("\n===== Recent Actions =====");

        for (int i = actions.size() - 1; i >= 0; i--) {
            System.out.println("- " + actions.get(i));
        }
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return actions.isEmpty();
    }
}