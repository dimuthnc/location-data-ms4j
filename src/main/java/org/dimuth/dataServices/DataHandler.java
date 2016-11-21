package org.dimuth.dataServices;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by dimuth on 10/11/16.
 */
public class DataHandler {
    public JSONObject loadData(double start, double end){
        JSONObject response = new JSONObject();
        ArrayList<String> Xarray = new ArrayList<String>();
        ArrayList<String> Yarray = new ArrayList<String>();
        ArrayList<String> Xlist= Connection.DetailsList("X");
        ArrayList<String> Ylist =Connection.DetailsList("Y");
        ArrayList<String> IDlist=Connection.DetailsList("ID");
        try{
            BufferedReader input = new BufferedReader(new FileReader("output.txt"));

            String data; // Character read from filein
            int readed =0;
            int recorded=0;
            boolean notStarted=true;
            boolean notFinished =true;

            while((data = input.readLine()) != null  && notStarted){
                String[] dataLine =data.split(" ");
                if(Double.parseDouble(dataLine[1].substring(1,dataLine[1].length()))>start){
                    int index=IDlist.indexOf(dataLine[0]);

                    Xarray.add(Xlist.get(index));
                    Yarray.add(Ylist.get(index));
                    notStarted=false;

                }


            }





            while ((data = input.readLine()) != null && notFinished) {

                    String[] dataLine = data.split(" ");
                    if(Double.parseDouble(dataLine[1].substring(1,dataLine[1].length()))<end) {
                        int index=IDlist.indexOf(dataLine[0]);

                        Xarray.add(Xlist.get(index));
                        Yarray.add(Ylist.get(index));
                    }
                    else{
                        notFinished =false;
                    }
















            }




        }
        catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }


        response.put("X",Xarray);
        response.put("Y",Yarray);
        return response;
    }
    public JSONObject loadDataChunk(double start, double end){
        JSONObject response = new JSONObject();
        ArrayList<String> Xarray = new ArrayList<String>();
        ArrayList<String> Yarray = new ArrayList<String>();
        ArrayList<String> Tarray = new ArrayList<String>();
        ArrayList<Double> Carray = new ArrayList<Double>();
        try{
            BufferedReader input = new BufferedReader(new FileReader("output.txt"));

            String data; // Character read from filein
            int readed =0;
            int recorded=0;
            boolean notStarted=true;
            boolean notFinished =true;
            ArrayList<String> Xlist= Connection.DetailsList("X");
            ArrayList<String> Ylist =Connection.DetailsList("Y");
            ArrayList<String> IDlist=Connection.DetailsList("ID");

            while((data = input.readLine()) != null  && notStarted){
                String[] dataLine =data.split(" ");
                if(Double.parseDouble(dataLine[1].substring(1,dataLine[1].length()))>start){
                    notStarted=false;
                    int index=IDlist.indexOf(dataLine[0]);

                    Xarray.add(Xlist.get(index));
                    Yarray.add(Ylist.get(index));
                    Tarray.add(dataLine[1].substring(1,dataLine[1].length()));
                    double c= (end-Double.parseDouble(dataLine[1].substring(1,dataLine[1].length())))*255/5000;
                    Carray.add(c);

                }


            }





            while ((data = input.readLine()) != null && notFinished) {

                String[] dataLine = data.split(" ");
                if(Double.parseDouble(dataLine[1].substring(1,dataLine[1].length()))<end) {
                    int index=IDlist.indexOf(dataLine[0]);
                    Tarray.add(dataLine[1].substring(1,dataLine[1].length()));
                    Xarray.add(Xlist.get(index));
                    Yarray.add(Ylist.get(index));
                    double c= (end-Double.parseDouble(dataLine[1].substring(1,dataLine[1].length())))*255/5000;
                    Carray.add(c);

                }
                else{
                    notFinished =false;
                }
            }




        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e);
        }


        response.put("X",Xarray);
        response.put("Y",Yarray);
        response.put("T",Tarray);
        response.put("C",Carray);
        return response;
    }
    public static String getInitStartTime(){
        try{
            BufferedReader input = new BufferedReader(new FileReader("output.txt"));
            String[] dataLine =input.readLine().split(" ");

            return dataLine[1].substring(1,dataLine[1].length());
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static String getEndTime() {
        File file = new File("output.txt");
        RandomAccessFile fileHandler = null;
        try {
            fileHandler = new RandomAccessFile( file, "r" );
            long fileLength = fileHandler.length() - 1;
            StringBuilder sb = new StringBuilder();

            for(long filePointer = fileLength; filePointer != -1; filePointer--){
                fileHandler.seek( filePointer );
                int readByte = fileHandler.readByte();

                if( readByte == 0xA ) {
                    if( filePointer == fileLength ) {
                        continue;
                    }
                    break;

                } else if( readByte == 0xD ) {
                    if( filePointer == fileLength - 1 ) {
                        continue;
                    }
                    break;
                }

                sb.append( ( char ) readByte );
            }

            String lastLine = sb.reverse().toString();
            return lastLine.split(" ")[1];
        } catch( java.io.FileNotFoundException e ) {
            e.printStackTrace();
            return null;
        } catch( java.io.IOException e ) {
            e.printStackTrace();
            return null;
        } finally {
            if (fileHandler != null )
                try {
                    fileHandler.close();
                } catch (IOException e) {
                /* ignore */
                }
        }
    }

    public JSONObject getDataDensity(double start, double end){
        JSONObject response = new JSONObject();
        ArrayList<String> Xarray = new ArrayList<String>();
        ArrayList<String> Yarray = new ArrayList<String>();
        List<Integer> Darray = new ArrayList<Integer>();
        ArrayList<String> IDlist=new ArrayList<>();
        try{
            BufferedReader input = new BufferedReader(new FileReader("output.txt"));

            String data; // Character read from filein
            int readed =0;
            int recorded=0;
            boolean notStarted=true;
            boolean notFinished =true;


            Xarray= Connection.DetailsList("X");
            Yarray =Connection.DetailsList("Y");
            IDlist=Connection.DetailsList("ID");
            Darray= new ArrayList<Integer>(Collections.nCopies(IDlist.size(), 0));
            while((data = input.readLine()) != null  && notStarted){
                String[] dataLine =data.split(" ");
                if(Double.parseDouble(dataLine[1].substring(1,dataLine[1].length()))>start){
                    notStarted=false;
                    int index=IDlist.indexOf(dataLine[0]);
                    int count=Darray.get(index);
                    Darray.set(index,count+1);
                }


            }



            while ((data = input.readLine()) != null && notFinished) {

                String[] dataLine = data.split(" ");
                if(Double.parseDouble(dataLine[1].substring(1,dataLine[1].length()))<end) {
                    int index=IDlist.indexOf(dataLine[0]);
                    int count=Darray.get(index);
                     Darray.set(index,count+1);

                }
                else{
                    notFinished =false;
                }
            }





        }
        catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }

        response.put("X",Xarray);
        response.put("Y",Yarray);
        response.put("D",Darray);
        response.put("ID",IDlist);

        return response;
    }
    public JSONObject  getFrequency(double start, double gap,int sensor_id){
        ArrayList<Integer> Darray= new ArrayList<Integer>(Collections.nCopies(10, 0));
        JSONObject response = new JSONObject();
        int k=0;
        double t=start;
        double end= Double.parseDouble(getEndTime());
        String data =null;
        boolean notStarted=true;
        int c=0;
        try {
            BufferedReader input = new BufferedReader(new FileReader("output.txt"));
            while((  notStarted && (data = input.readLine()) != null) ){
                String[] dataLine =data.split(" ");
                if(Double.parseDouble(dataLine[1].substring(1,dataLine[1].length()))>start){
                    notStarted=false;
                }


            }

            while(k<10 && t<end){
                boolean notFinished=true;
                while (data != null && notFinished) {
                    String[] dataLine = data.split(" ");

                    if(Double.parseDouble(dataLine[1].substring(1,dataLine[1].length()))<= (start+((k+1)*gap))) {

                        if(Integer.parseInt(dataLine[0])==sensor_id){
                            c+=1;

                        }
                        data=input.readLine();

                    }
                    else{
                        notFinished =false;
                        Darray.set(k,c);
                        k+=1;
                        c=0;
                    }

                }



            }
        }
        catch (IOException ioe){
            System.out.println("IOE");
            ioe.printStackTrace();
        }
        response.put("Count",Darray);




        return response;
    }





}
