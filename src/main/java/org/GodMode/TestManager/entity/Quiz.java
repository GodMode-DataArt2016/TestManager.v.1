package org.GodMode.TestManager.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({ @NamedQuery(name = "Quiz.findAllQuizes",
        query = "SELECT q FROM Quiz AS q"),
        @NamedQuery(name = "Quiz.findQuizesBySubject",
                query ="SELECT q FROM Quiz AS q WHERE q.subject.id=:subjectId")})
@Entity
public class Quiz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    @NotNull
    @Size(min=5, max=50)
    private String name;
    @OneToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("ID")
    private Set<Question> questions;

    public Quiz() {
        super();
    }

    public Quiz(Long id, String name, Subject subject) {
        super();
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public Quiz(String name, Subject subject) {
        super();
        this.name = name;
        this.subject = subject;
    }

    public Quiz(String name, Subject subject, Set<Question> questions) {
        super();
        this.name = name;
        this.subject = subject;
        this.questions = questions;
    }

    public Quiz(Long id, String name, Subject subject, Set<Question> questions) {
        super();
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.questions = questions;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
        Quiz other = (Quiz) obj;
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
        if (subject == null) {
            if (other.subject != null)
                return false;
        } else if (!subject.equals(other.subject))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Quiz [id=" + id + ", name=" + name + ", subject=" + subject
                + ", questions=" + questions + "]";
    }

}
