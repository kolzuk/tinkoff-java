package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private int countOfAttempts;
    private ConnectionException cause;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
        this.countOfAttempts = 0;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        if (countOfAttempts >= maxAttempts) {
            throw new ConnectionException();
        }

        countOfAttempts++;

        try {
            manager.getConnection().execute(command);
        } catch (ConnectionException exception) {
            cause = exception;
        }
    }
}
