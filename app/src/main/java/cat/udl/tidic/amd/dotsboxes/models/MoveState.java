package cat.udl.tidic.amd.dotsboxes.models;

public class MoveState {
    public boolean isValid;
    public String message;

    public MoveState(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }
}
