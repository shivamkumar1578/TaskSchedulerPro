package core;

public class Task {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    public void execute() {
        try {
            Thread.sleep(1000); // simulate work
        } catch (Exception ignored) {}
    }

    public String getName() {
        return name;
    }
}
