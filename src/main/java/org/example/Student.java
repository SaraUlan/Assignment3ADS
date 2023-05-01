package org.example;

public class Student {
    private String name;
    private String lastname;

    public Student(){}

    public Student(String name, String lastname){
        this.name = name;
        this.lastname = lastname;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        String strKey = String.valueOf(this.name + " " + this.lastname);
        for (int i = 0; i < strKey.length(); i++) {
            hash += (int) strKey.charAt(i);
        }
        return hash;
    }

    @Override
    public String toString(){
        return "%s %s".formatted(this.name, this.lastname);
    }
}
