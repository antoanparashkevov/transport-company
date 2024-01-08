package org.example.dto;

public class EmployeeDto {

    private long id;
    private String name;

    //parametrized constructor
    public EmployeeDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
