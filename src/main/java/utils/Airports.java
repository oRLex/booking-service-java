package utils;

public enum Airports {

    KBP ("Kyiv"),
    LAX ("Los Angeles"),
    NRT ("Tokyo"),
    HND ("Tokyo"),
    LHR ("London"),
    LGW ("London"),
    SIN ("Singapore");

    private String title;

    Airports(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public static Airports getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
