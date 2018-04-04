package com.almundo.test.callcenter.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    public static enum Type {
        OPERATOR, SUPERVISOR, MANAGER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 15, nullable = false)
    private Type type;

    @Column(name = "available")
    private boolean available;

    @Column(name = "busy")
    private boolean busy;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Call> calls;

    @Column(name = "email", length = 100)
    private String email;

    public Employee() {
        this.available = true;
        this.busy = false;
    }

    public Employee(String name, Type type) {
        this.name = name;
        this.type = type;
        this.available = true;
        this.busy = false;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public boolean getAvailable() {
        return available;
    }

    public boolean getBusy() {
        return busy;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

}
