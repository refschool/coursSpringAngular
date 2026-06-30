package user.microservices.microservices.entities;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;
    private String role;

    public Role(Long role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    public Role() {
        super();
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role [role_id=" + role_id + ", role=" + role + "]";
    }
}