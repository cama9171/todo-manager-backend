package com.dev.task_manager_backend.modal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @ColumnDefault("false")
    private boolean status;

    // Many tasks for one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
