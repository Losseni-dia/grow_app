package grow.backend.model;

public enum UserRole {
    ADMIN("admin"),
    AGENT("agent"),
    USER("user"),
    PARTENAIRE("partenaire");
   
    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getValue() {
        return role;
    }
}
