package csd.uoc.gr.A21;

public class SensorTESTERsimple {
    public static void main(String[] lala) {

        SensorLine newSensorLine= new SensorLine();
        int j=0;
        boolean mode;
        String id;

        for( int i =0; i<100; i++){

            if(i%4==0)  mode = true;
            else mode = false;

            id="SID"+i;

            if(i==0){
                newSensorLine.add(new Sensor(id,true,mode));
            }
            else if(i==1){
                newSensorLine.add(new TemperatureSensor(id,true,mode));
            }
            else{
                newSensorLine.add(new LaserSensor(id,true,mode, (float)i) );
            }
        }
        System.out.println( newSensorLine.toString() );
    }
}
