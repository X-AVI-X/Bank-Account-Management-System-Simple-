public class Date {
    public int day;
    public int month;
    public int year;

    public Date () {
        //System.out.println("Date:");
        this.day=0;
        this.month=0;
        this.year=0;
    }
    public Date (int day, int month, int year) {
        //System.out.println("ParaDate:");
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public void setDay (int day){
        this.day=day;
    }
    public void setMonth (int month){
        this.month=month;
    }
    public void setYear (int year){
        this.year=year;
    }

    public int getDay (){
        return this.day;
    }
    public int getMonth (){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }

}