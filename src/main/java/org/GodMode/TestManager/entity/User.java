package org.GodMode.TestManager.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@NamedQueries({
        @NamedQuery(name = "User.getAllUsers", query = "SELECT u FROM User AS u"),
        @NamedQuery(name = "User.getAllUsersTotalResulCount", query = "SELECT count(u.id) FROM User AS u"),
        @NamedQuery(name = "User.getAllUsersByRole", query = "SELECT u FROM User AS u WHERE u.role=:role"),
        @NamedQuery(name = "User.getAllUsersByRoleTotalResulCount", query = "SELECT count(u.id) FROM User AS u WHERE u.role=:role"),
        @NamedQuery(name = "User.getByEmailAndPassword", query = "SELECT u FROM User AS u WHERE u.email=:email AND u.password=:password"),
        @NamedQuery(name = "User.getByEmail", query = "SELECT u FROM User AS u WHERE u.email=:email"),
        @NamedQuery(name = "User.getUsersAssignedToQuiz", query = "SELECT DISTINCT u FROM User AS u, IN(u.avaliableQuizes) q WHERE q.id=:quizId") })
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "EMAIL") })
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @Column(name = "LAST_NAME")
    @Size(min = 2, max = 60)
    private String surname;
    @Column(name = "EMAIL")
    @NotNull
    @Email
    private String email;
    @Column(name = "PASSWORD")
    @NotNull
    private String password;
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_AVALIABLE_QUIZ", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "QUIZ_ID") })
    private Set<Quiz> avaliableQuizes;

    @OneToMany(mappedBy = "user")
    private Set<QuizResult> quizResults;

    public User(String name, String surname, String email, String password,
                Role role) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Quiz> getAvaliableQuizes() {
        return avaliableQuizes;
    }

    public void setAvaliableQuizes(Set<Quiz> avaliableQuizes) {
        this.avaliableQuizes = avaliableQuizes;
    }

    public Set<QuizResult> getQuizResults() {
        return quizResults;
    }

    public void setQuizResults(Set<QuizResult> quizResults) {
        this.quizResults = quizResults;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (role != other.role)
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", surname=" + surname
                + ", email=" + email + ", password=" + password + ", role="
                + role + "]";
    }

}
