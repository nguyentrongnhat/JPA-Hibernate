package com.project.app.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Enrollment {
    @EmbeddedId
    private EnrollmentId id = new EnrollmentId();

    // TODO: Map Many-to-One relationships with Student and Course

    public Enrollment() {}

    public Enrollment(EnrollmentId id) { this.id = id; }

    public EnrollmentId getId() { return id; }
    public void setId(EnrollmentId id) { this.id = id; }
}

