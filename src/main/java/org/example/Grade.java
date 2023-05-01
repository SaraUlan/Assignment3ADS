package org.example;

public class Grade {
    private String grade;
    public Grade(){}

    public Grade(String grade){
        this.grade = grade;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        String strKey = String.valueOf(this.grade);
        for (int i = 0; i < strKey.length(); i++) {
            hash += (int) strKey.charAt(i);
        }
        return hash;
    }


    @Override
    public String toString(){
        return "%s".formatted(this.grade);
    }
}
