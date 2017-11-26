package kpi.supplychain.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.util.Date;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9]{3,15}$",
            message = "Invalid login:"
                    + " only digits and letters allowed, "
                    + "length between 3 and 15 characters")
    @Column(name = "login", unique = true)
    private String login;

    @Size(min = 3,
            message = "Password must be at least 3 characters long")
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message = "Invalid email address.")
    @Column(name = "email", unique = true)
    private String email;

    @Size(max = 20, message = "First name too long")
    @Pattern(regexp = "[a-zA-z]+((['-][a-zA-Z])*)+[a-zA-Z]*$",
            message = "Invalid first name: "
                    + "Only letters, dash and apostrophe allowed. "
                    + "Only letters at the beginning/end")
    @Column(name = "firstname")
    private String firstName;

    @Size(max = 20, message = "Last name too long")
    @Pattern(regexp = "[a-zA-z]+((['-][a-zA-Z])*)+[a-zA-Z]*$",
            message = "Invalid last name: "
                    + "Only letters, dash and apostrophe allowed. "
                    + "Only letters at the beginning/end")
    @Column(name = "lastname")
    private String lastName;

    @NotNull(message = "Invalid date")
    @Temporal(TemporalType.DATE)
    @Past(message = "User haven't born yet?")
    @Column(name = "birthday")
    private Date birthday;

    @NotNull(message = "Role may not be null")
    @ManyToOne(targetEntity = Role.class, optional = false)
    @JoinColumn(name = "id_role")
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (!email.equals(user.email)) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (!id.equals(user.id)) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!role.equals(user.role)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + role.hashCode();
        return result;
    }
}
