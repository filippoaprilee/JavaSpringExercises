package it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO;

public class RestaurantTableDTO {
    private int seats;
    private String tableType; // TODO enum. cerca @RequestBody enum

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getTableType() {
        return this.tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }
    
}
