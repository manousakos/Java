package csd.uoc.gr.A21;
public class Sensor{
    private String id;
    private boolean violation;
    private boolean on;

    public Sensor(String id, boolean on, boolean violation) {
        this.id = id;
        this.violation =  violation;
        this.on = on;

    }

    public String get_Id() {
        return id;
    }

    public void set_Id(String id) {
        this.id = id;
    }

    public boolean get_On() {
        return on;
    }

    public void set_On(boolean on) {
        this.on = on;
    }

    public boolean get_Violation() {
        return violation;
    }

    public void set_Violation(boolean violation) {
        this.violation = violation;
    }

    public String toString(){
        String sumStringer;

        sumStringer="Sensor with id = "+id+", On state = "+on+", Violation state = "+violation;
        return sumStringer;
    }
}
