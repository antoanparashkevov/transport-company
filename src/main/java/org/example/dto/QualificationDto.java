package org.example.dto;

public class QualificationDto {

    private long id;

    private String type;

    //default constructor
    public QualificationDto() {
    }

    //parametrized constructor
    public QualificationDto(long id, String type) {
        this.id = id;
        this.type = type;
    }

    //GETTERS START

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    //GETTERS END

    //SETTERS START

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    //SETTERS END

    @Override
    public String toString() {
        return "QualificationDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
