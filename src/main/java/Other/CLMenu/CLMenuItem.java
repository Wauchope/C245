package Other.CLMenu;

public class CLMenuItem {
    String description;
    Runnable method;

    public CLMenuItem(String description, Runnable method) {
        this.description = description;
        this.method = method;
    }

    public CLMenuItem(String description) {
        this.description = description;
        method = () -> {
            throw new UnsupportedOperationException("Not Yet Implemented");
        };
    }

    public CLMenuItem() {
        description = "Not Yet Implemented";
        method = () -> {
            throw new UnsupportedOperationException(description);
        };
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Runnable getMethod() {
        return method;
    }

    public void setMethod(Runnable method) {
        this.method = method;
    }
}
