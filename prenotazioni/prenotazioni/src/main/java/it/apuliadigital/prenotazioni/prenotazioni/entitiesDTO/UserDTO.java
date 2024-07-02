package it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO;

public class UserDTO {
    private String name;
    private String surname;
    private String phone; 


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name and surname: " + this.name + " " + this.surname + ". \nPhone: " + this.phone;
    }
}
