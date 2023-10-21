package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private ConnectionException cause;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        int countOfAttempts = 0;

        while (countOfAttempts <= maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (ConnectionException e) {
                countOfAttempts++;
                cause = e;
            } catch (Exception e) {
                countOfAttempts++;
            }
        }
    }
}
