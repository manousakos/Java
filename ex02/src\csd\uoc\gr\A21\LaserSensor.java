package csd.uoc.gr.A21;
public class LaserSensor extends Sensor
{
    private float range;
    LaserSensor(String id, boolean on, boolean violation, float range ){
        super(id,on,violation);
        this.range=range;
    }

    public String toString(){
        String tempStringer;

        tempStringer= super.toString() + "range = "+ range + ", (laser sensor)";
        return tempStringer;
    }
}
