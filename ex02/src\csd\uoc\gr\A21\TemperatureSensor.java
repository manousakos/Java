package csd.uoc.gr.A21;
public class TemperatureSensor extends Sensor
{
    TemperatureSensor(String id, boolean on, boolean violation){
        super(id,on,violation);
    }

    public String toString(){
        String tempStringer;

        tempStringer= super.toString()+", (temp. sensor)";
        return tempStringer;
    }
}
