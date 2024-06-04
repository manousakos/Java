package csd.uoc.gr.A21;
public class SensorLine extends Sensor
{
    private static int activeCapacity ;
    private static Sensor[] sensArray = new Sensor[1000];

    // add Sensor method, increases counter by 1
    public static void add(Sensor s){
        sensArray[activeCapacity] = s;
        activeCapacity++;
    }

    SensorLine(){
        super("Anonymous sensorLine",false,false);
    }

    SensorLine(String id, boolean on, boolean violation){
        super(id,on,violation);
    }


     public String toString(){

         String retString="";

         retString+="SensorLine "+ get_Id();

         retString+="\n";
         retString+="Number of Sensors=";
         retString+= activeCapacity;
         retString+="\n";

         retString+="Violated=";
         retString+=isViolated();
         retString+="\n";

         retString+="# of violated sensors=";
         retString+=sumViolated();
         retString+="\n";

         retString+="Ids of Violated: ";
         retString+=idViolated();

         return retString;


     }

     private int sumViolated(){
        int cntrViolated=0;
        for( int i=0; i< activeCapacity; i++){
            if(sensArray[i].get_Violation()) cntrViolated++;
        }
        return cntrViolated;
     }

     private String idViolated(){
        String idString="";
        for( int i=0; i< activeCapacity; i++){
            if(sensArray[i].get_Violation()){
                idString+=sensArray[i].get_Id();
                idString+=" ";
            }

        }
        return idString;
     }
    /* ++++++++++++++++++++++++++++++++++++++++++++++++++++= */

    public void setOn( boolean mode){

        for(int i=0 ; i< activeCapacity; i++){
            sensArray[i].set_On(mode);
        }
    }

    public boolean isViolated(){
        for(int i=0 ; i< activeCapacity; i++){
            // if violation == true , return true
            if( sensArray[i].get_Violation())   return true;
        }

        return false;
    }

    public static Sensor[] getSensors(){

        Sensor[] retSensors= new Sensor[activeCapacity];
        for( int i=0; i< activeCapacity; i++){
            retSensors[i] = sensArray[i];
        }

        return retSensors;
    }
}
