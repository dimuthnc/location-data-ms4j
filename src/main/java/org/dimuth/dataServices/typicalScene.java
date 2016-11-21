package org.dimuth.dataServices;

import org.json.JSONObject;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

import static java.awt.SystemColor.text;
import static org.dimuth.dataServices.DataHandler.getEndTime;

/**
 * Created by dimuth on 11/4/16.
 */
public class typicalScene {
    public void divideData(){
        ArrayList<String> sun=new ArrayList<String>();
        ArrayList<String> mon=new ArrayList<String>();
        ArrayList<String> tue=new ArrayList<String>();
        ArrayList<String> wed=new ArrayList<String>();
        ArrayList<String> thu=new ArrayList<String>();
        ArrayList<String> fri=new ArrayList<String>();
        ArrayList<String> sat=new ArrayList<String>();
        ArrayList<String> sunD=new ArrayList<String>();
        ArrayList<String> monD=new ArrayList<String>();
        ArrayList<String> tueD=new ArrayList<String>();
        ArrayList<String> wedD=new ArrayList<String>();
        ArrayList<String> thuD=new ArrayList<String>();
        ArrayList<String> friD=new ArrayList<String>();
        ArrayList<String> satD=new ArrayList<String>();
        String data;
        try{
            BufferedReader input = new BufferedReader(new FileReader("output.txt"));
            data=input.readLine();
            while(data!=null){
                String[] dataLine = data.split(" ");
                System.out.println(data);
                java.util.Date time=new java.util.Date(Long.parseLong(dataLine[1]));
                int day=time.getDay();



                if(day==0){
                    sun.add(dataLine[1]);
                    sunD.add(dataLine[0]);

                }
                else if(day==1){
                    mon.add(dataLine[1]);
                    monD.add(dataLine[0]);

                }
                else if(day==2){
                    tue.add(dataLine[1]);
                    tueD.add(dataLine[0]);

                }
                else if(day==3){
                    wed.add(dataLine[1]);
                    wedD.add(dataLine[0]);

                }
                else if(day==4){
                    thu.add(dataLine[1]);
                    thuD.add(dataLine[0]);

                }
                else if(day==5){
                    fri.add(dataLine[1]);
                    friD.add(dataLine[0]);

                }
                else if(day==6){
                    sat.add(dataLine[1]);
                    satD.add(dataLine[0]);

                }
                data=input.readLine();

            }
        }

        catch (FileNotFoundException fnf){
            System.out.println("File Not Found");
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            System.out.println("IOException");
            ioe.printStackTrace();
        }
        saveHourSummary("mon",mon,monD);
        saveHourSummary("tue",tue,tueD);
        saveHourSummary("wed",wed,wedD);
        saveHourSummary("thu",thu,thuD);
        saveHourSummary("fri",fri,friD);
        saveHourSummary("sat",sat,satD);
        saveHourSummary("sun",sun,sunD);


    }
    public void saveHourSummary(String day,ArrayList<String> Timelist,ArrayList<String> DataList){
        ArrayList<String> h00 = new ArrayList<String>();
        ArrayList<String> h01 = new ArrayList<String>();
        ArrayList<String> h02 = new ArrayList<String>();
        ArrayList<String> h03 = new ArrayList<String>();
        ArrayList<String> h04 = new ArrayList<String>();
        ArrayList<String> h05 = new ArrayList<String>();
        ArrayList<String> h06 = new ArrayList<String>();
        ArrayList<String> h07 = new ArrayList<String>();
        ArrayList<String> h08 = new ArrayList<String>();
        ArrayList<String> h09 = new ArrayList<String>();
        ArrayList<String> h10 = new ArrayList<String>();
        ArrayList<String> h11 = new ArrayList<String>();
        ArrayList<String> h12 = new ArrayList<String>();
        ArrayList<String> h13 = new ArrayList<String>();
        ArrayList<String> h14 = new ArrayList<String>();
        ArrayList<String> h15 = new ArrayList<String>();
        ArrayList<String> h16 = new ArrayList<String>();
        ArrayList<String> h17 = new ArrayList<String>();
        ArrayList<String> h18 = new ArrayList<String>();
        ArrayList<String> h19 = new ArrayList<String>();
        ArrayList<String> h20 = new ArrayList<String>();
        ArrayList<String> h21 = new ArrayList<String>();
        ArrayList<String> h22 = new ArrayList<String>();
        ArrayList<String> h23 = new ArrayList<String>();


        for (int x=0;x<Timelist.size();x++) {
            java.util.Date time=new java.util.Date(Long.parseLong(Timelist.get(x)));
            int h = time.getHours();
            int m =time.getMinutes();
            String d = DataList.get(x);

            if(h==0){
                if(m<30){
                    h00.add(d);

                }
                else{
                    h23.add(d);

                }

            }
            else if(h==1){
                if(m<30){
                    h01.add(d);
                }
                else{
                    h02.add(d);
                }

            }
            else if(h==2){
                if(m<30){
                    h02.add(d);

                }
                else{
                    h03.add(d);

                }

            }
            else if(h==3){
                if(m<30){
                    h03.add(d);

                }
                else{
                    h04.add(d);

                }

            }
            else if(h==4){
                if(m<30){
                    h04.add(d);

                }
                else{
                    h05.add(d);

                }

            }
            else if(h==5){
                if(m<30){
                    h05.add(d);

                }
                else{
                    h06.add(d);

                }

            }
            else if(h==6){

                if(m<30){
                    h06.add(d);

                }
                else{
                    h07.add(d);

                }

            }
            else if(h==7){
                if(m<30){
                    h07.add(d);

                }
                else{
                    h08.add(d);

                }

            }
            else if(h==8){
                if(m<30){
                    h08.add(d);

                }
                else{
                    h09.add(d);

                }

            }
            else if(h==9){
                if(m<30){
                    h09.add(d);

                }
                else{
                    h10.add(d);
                }

            }
            else if(h==10){
                if(m<30){
                    h10.add(d);
                }
                else{
                    h11.add(d);
                }

            }
            else if(h==11){
                if(m<30){
                    h11.add(d);

                }
                else{
                    h12.add(d);

                }

            }
            else if(h==12){

                if(m<30){
                    h12.add(d);

                }
                else{
                    h13.add(d);

                }

            }
            else if(h==13){
                if(m<30){
                    h13.add(d);
                }
                else{
                    h14.add(d);
                }

            }
            else if(h==14){
                if(m<30){
                    h14.add(d);

                }
                else{
                    h15.add(d);

                }

            }
            else if(h==15){
                if(m<30){
                    h15.add(d);
                }
                else{
                    h16.add(d);

                }

            }
            else if(h==16){
                if(m<30){
                    h16.add(d);

                }
                else{
                    h17.add(d);

                }

            }
            else if(h==17){
                if(m<30){
                    h17.add(d);

                }
                else{
                    h18.add(d);

                }

            }
            else if(h==18){
                if(m<30){
                    h18.add(d);

                }
                else{
                    h19.add(d);

                }

            }
            else if(h==19){
                if(m<30){
                    h19.add(d);

                }
                else{
                    h20.add(d);

                }

            }
            else if(h==20){
                if(m<30){
                    h20.add(d);

                }
                else{
                    h21.add(d);

                }

            }
            else if(h==21){
                if(m<30){
                    h21.add(d);

                }
                else{
                    h22.add(d);

                }

            }
            else if(h==22){
                if(m<30){
                    h22.add(d);

                }
                else{
                    h23.add(d);

                }

            }
            else if(h==23){
                if(m<30){
                    h23.add(d);

                }
                else{

                    h00.add(d);
                }

            }




        }

        ArrayList<String> sensors = Connection.DetailsList("sensor_id");
        saveArrayAvarage(h00,sensors,day,"00");
        saveArrayAvarage(h01,sensors,day,"01");
        saveArrayAvarage(h02,sensors,day,"02");
        saveArrayAvarage(h03,sensors,day,"03");
        saveArrayAvarage(h04,sensors,day,"04");
        saveArrayAvarage(h05,sensors,day,"05");
        saveArrayAvarage(h06,sensors,day,"06");
        saveArrayAvarage(h07,sensors,day,"07");
        saveArrayAvarage(h08,sensors,day,"08");
        saveArrayAvarage(h09,sensors,day,"09");
        saveArrayAvarage(h10,sensors,day,"10");
        saveArrayAvarage(h11,sensors,day,"11");
        saveArrayAvarage(h12,sensors,day,"12");
        saveArrayAvarage(h13,sensors,day,"13");
        saveArrayAvarage(h14,sensors,day,"14");
        saveArrayAvarage(h15,sensors,day,"15");
        saveArrayAvarage(h16,sensors,day,"16");
        saveArrayAvarage(h17,sensors,day,"17");
        saveArrayAvarage(h18,sensors,day,"18");
        saveArrayAvarage(h19,sensors,day,"19");
        saveArrayAvarage(h20,sensors,day,"20");
        saveArrayAvarage(h21,sensors,day,"21");
        saveArrayAvarage(h22,sensors,day,"22");
        saveArrayAvarage(h23,sensors,day,"23");


    }
    public void saveArrayAvarage(ArrayList<String> arr,ArrayList<String> sensors,String day,String h){
        ArrayList<Integer> Darray= new ArrayList<Integer>(Collections.nCopies(sensors.size(), 0));

        for(int y=0;y<arr.size();y++){
            int index=sensors.indexOf(arr.get(y));
            int current=Darray.get(index);
            Darray.set(index,current+1);

        }
        String text=day+" "+h;

        for(int k=0;k<Darray.size();k++){

            text = text+" "+Darray.get(k);


        }
        try(FileWriter fw = new FileWriter("typicalScene.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public static JSONObject getTypicalScene(String day, String hour){
        int[] days=getNumberofDates(new java.util.Date(Long.parseLong(DataHandler.getInitStartTime())),new java.util.Date(Long.parseLong(DataHandler.getEndTime())));
        String data;
        int numberOfDays=1;
        switch (day){
            case "mon":
                numberOfDays=days[1];
            case "tue":
                numberOfDays=days[2];
            case "wed":
                numberOfDays=days[3];
            case "thu":
                numberOfDays=days[4];
            case "fri":
                numberOfDays=days[5];
            case "sat":
                numberOfDays=days[6];
            case "sun":
                numberOfDays=days[0];



        }
        ArrayList<String> typicalDensity = new ArrayList<String>();
        try{
            BufferedReader input = new BufferedReader(new FileReader("typicalScene.txt"));
            data = input.readLine();

            String[] dataLine = data.split(" ");

            while((!dataLine[0].equals(day)) || (!dataLine[1].equals(hour))){
                data=input.readLine();
                dataLine = data.split(" ");

            }

            for(int z=2;z< dataLine.length ;z++){
                typicalDensity.add(String.valueOf(Double.parseDouble(dataLine[z])/numberOfDays));
            }
            double min=getMinimum();
            double max=getMaximum();
            for (int p=0;p<typicalDensity.size();p++){
                double current =Double.parseDouble(typicalDensity.get(p));
                double newValue=(current-min)*100.0/(max-min);

                typicalDensity.set(p,String.format("%.4f",newValue));
            }


        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        JSONObject jobj = new JSONObject();
        jobj.put("C",typicalDensity);
        jobj.put("X",Connection.DetailsList("X"));
        jobj.put("Y",Connection.DetailsList("Y"));
        jobj.put("ID", Connection.DetailsList("ID"));
        return jobj;


    }
    private static double getMaximum(){
        int[] days=getNumberofDates(new java.util.Date(Long.parseLong(DataHandler.getInitStartTime())),new java.util.Date(Long.parseLong(DataHandler.getEndTime())));

        String data;
        double max=0;
        try{
            BufferedReader input = new BufferedReader(new FileReader("typicalScene.txt"));
            data = input.readLine();



            String[] dataLine;

            int line=0;
            while(line<168){


                dataLine = data.split(" ");
                String day=dataLine[0];
                int numberOfDays=1;
                switch (day){
                    case "mon":
                        numberOfDays=days[1];
                    case "tue":
                        numberOfDays=days[2];
                    case "wed":
                        numberOfDays=days[3];
                    case "thu":
                        numberOfDays=days[4];
                    case "fri":
                        numberOfDays=days[5];
                    case "sat":
                        numberOfDays=days[6];
                    case "sun":
                        numberOfDays=days[0];



                }
                for(int x=2;x<dataLine.length;x++){
                    double value =Integer.parseInt(dataLine[x])/numberOfDays;
                    if(value>max){
                        max=value;
                    }

                }
                data=input.readLine();
                line+=1;










            }


        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        return max;

    }
    private static double getMinimum(){
        int[] days=getNumberofDates(new java.util.Date(Long.parseLong(DataHandler.getInitStartTime())),new java.util.Date(Long.parseLong(DataHandler.getEndTime())));


        String data;
        double min=10000;
        try{
            BufferedReader input = new BufferedReader(new FileReader("typicalScene.txt"));
            data = input.readLine();


            String[] dataLine = data.split(" ");
            String day=dataLine[0];
            min=Integer.parseInt(dataLine[2]);
            int line=0;
            int numberOfDays=1;
            switch (day) {
                case "mon":
                    numberOfDays = days[1];
                case "tue":
                    numberOfDays = days[2];
                case "wed":
                    numberOfDays = days[3];
                case "thu":
                    numberOfDays = days[4];
                case "fri":
                    numberOfDays = days[5];
                case "sat":
                    numberOfDays = days[6];
                case "sun":
                    numberOfDays = days[0];
            }
            while(line<168){
                dataLine = data.split(" ");
                for(int x=2;x<dataLine.length;x++){
                    int value =Integer.parseInt(dataLine[x])/numberOfDays;
                    if(value<min){
                        min=value;
                    }

                }
                data=input.readLine();
                line+=1;



            }


        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        return min;

    }

    public static int[] getNumberofDates(java.util.Date startDate, java.util.Date endDate) {

        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        int[] days = new int[7];
        Arrays.fill(days,0);

        //Return 0 if start and end are the same


        do {
            //excluding start date
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if(startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                days[0]=days[0]+1;
            }
            else if(startCal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
                days[1]=days[1]+1;
            }
            else if(startCal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
                days[2]=days[2]+1;
            }
            else if(startCal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
                days[3]=days[3]+1;
            } else if(startCal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY){
                days[4]=days[4]+1;
            }
            else if(startCal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
                days[5]=days[5]+1;
            }
            else if(startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                days[6]=days[6]+1;
            }


        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date



        return days;
    }

}
