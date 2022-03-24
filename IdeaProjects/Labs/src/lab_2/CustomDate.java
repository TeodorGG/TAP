package lab_2;


import java.util.Date;

public class CustomDate extends Date {

    public CustomDate(int y, int m, int d){
        super(y,m,d);
    }

    public String getSeason(){
        if(this.getMonth()>=3 && this.getMonth()<=5){
            return "Primavara";
        } else if(this.getMonth()>=6 && this.getMonth()<=8){
            return "Vara";
        } else if(this.getMonth()>=9 && this.getMonth()<=11){
            return "Toamna";
        } else {
            return "Iarna";
        }
    }
}
