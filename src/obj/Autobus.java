package obj;

public class Autobus {
    int seatsTaken=0;
    int seats;
    int seatCost;

    public void setSeatCost(int seatCost) {this.seatCost = seatCost;}

    public void setSeats(int seats) {this.seats = seats;}

    public void setSeatsTaken(int seatsTaken) {this.seatsTaken = seatsTaken;}

    public int getSeatCost() {return seatCost;}

    public int getSeats() {return seats;}

    public int getSeatsTaken() {return seatsTaken;}

    public int getTakenCost(){return seatCost*seatsTaken;}

    public int getSeatsFree(){return seats-seatsTaken;}

    public int getState(){
        if(seatsTaken==0) return 0;
        else if(seats==seatsTaken) return 2;
        return 1;
    }


}
