package grow.backend.model;

public enum UserRole {
    ADMIN("admin"),
    AGENT("agent"),
    USER("user"),
    PARTENAIRE("partenaire"),
    PORTEUR("porteur de projet"),
    INVESTISSEUR("investisseur");
   
    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getValue() {
        return role;
    }
}
