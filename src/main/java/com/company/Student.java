package com.company;

public class Student {
    private String name;
    private String surname;
    private int group;
    private String university;
    private String faculty;

    public void setField(String field,String value) throws IllegalArgumentException, NumberFormatException {
        switch (field){
            case "name":{
                name = value;
                break;
            }
            case "surname":{
                surname = value;
                break;
            }
            case "group":{
                group = Integer.valueOf(value);
                break;
            }
            case "university":{
                university = value;
                break;
            }
            case "faculty":{
                faculty = value;
                break;
            }
            default:{
                throw new IllegalArgumentException("Неверное имя поля");
            }
        }
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group=" + group +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
