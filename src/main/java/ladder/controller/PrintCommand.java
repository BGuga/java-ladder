package ladder.controller;

public enum PrintCommand {
    PRINT_ALL("all"),
    PRINT_ONE("");

    private String command;

    PrintCommand(String command) {
        this.command = command;
    }

    public static PrintCommand of(String value) {
        if (value.equals(PRINT_ALL.command)) {
            return PRINT_ALL;
        }
        return PRINT_ONE;
    }
}
