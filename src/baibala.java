import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'baCay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY tamnm
     *  2. STRING_ARRAY nghiatt
     *  3. STRING_ARRAY huypq
     *  4. STRING_ARRAY thongnh
     */

    public static String baCay(List<String> tamnm, List<String> nghiatt, List<String> huypq, List<String> thongnh) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        HashMap<String, Integer> map4 = new HashMap<>();

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, List<String>> mapList = new HashMap<>();
        HashMap<String, List<String>> mapMax = new HashMap<>();




        int sum1 = 0;
        for(int i =0; i < 3;i++){
            int x = Integer.parseInt((tamnm.get(i).substring(0,1)));
            String y = String.valueOf(tamnm.get(i).substring(1,2));
            map1.put(y,x);
            sum1+=x;
        }

        int sum2 = 0;
        for(int i =0; i < 3;i++){
            int x = Integer.parseInt((nghiatt.get(i).substring(0,1)));
            String y = String.valueOf(nghiatt.get(i).substring(1,2));
            map2.put(y,x);
            sum2+=x;
        }

        int sum3 = 0;
        for(int i =0; i < 3;i++){
            int x = Integer.parseInt((huypq.get(i).substring(0,1)));
            String y = String.valueOf(huypq.get(i).substring(1,2));
            map3.put(y,x);
            sum3+=x;
        }

        int sum4 = 0;
        for(int i =0; i < 3;i++){
            int x = Integer.parseInt((thongnh.get(i).substring(0,1)));
            String y = String.valueOf(thongnh.get(i).substring(1,2));
            map4.put(y,x);
            sum4+=x;
        }
        sum1 = sum1==10?10: sum1%10;
        sum2 = sum2==10?10: sum2%10;
        sum3 = sum3==10?10: sum3%10;
        sum4 = sum4==10?10: sum4%10;

        map.put("TamNM",sum1);
        map.put("NghiaTT",sum2);
        map.put("HuyPQ",sum3);
        map.put("ThongNH",sum4);

        mapList.put("TamNM", tamnm);
        mapList.put("NghiaTT", nghiatt);
        mapList.put("HuyPQ", huypq);
        mapList.put("ThongNH", thongnh);

        int max = Math.max(Math.max(sum1,sum2),Math.max(sum3,sum4));
        String result ="";
        boolean test = true;
        int count =0;

        for(String i: map.keySet()){
            if(max == map.get(i)){
                count++;
                result = i;
                mapMax.put(i,mapList.get(i));
            }
        }


        HashMap<String, String> mapMaxchat = new HashMap<>();

        if(count>1){
            boolean testR =true;
            boolean testC = true;
            boolean testB = true;
            int maxR =0;
            int maxC =0;
            int maxB =0;
            int maxT =0;
            for(String i: mapMax.keySet()){


                for(int j=0; j<3; j++){
                    if(String.valueOf(mapMax.get(i).get(j).substring(1,2)).equals("R")){
                        if(maxR < Integer.parseInt(mapMax.get(i).get(j).substring(0,1))){
                            if(Integer.parseInt(mapMax.get(i).get(j).substring(0,1))==1){
                                maxR= 10;
                                mapMaxchat.put(i,mapMax.get(i).get(j));
                                result = i;
                            }else {
                                maxR = Integer.parseInt(mapMax.get(i).get(j).substring(0,1));
                                mapMaxchat.put(i,mapMax.get(i).get(j));
                                result = i;
                            }
                        }
                        testR = false;
                        testC = false;
                        testB = false;


                    }else if(String.valueOf(mapMax.get(i).get(j).substring(1,2)).equals("C")&&testR){

                        if(maxC<Integer.parseInt(mapMax.get(i).get(j).substring(0,1))){
                            if(Integer.parseInt(mapMax.get(i).get(j).substring(0,1))==1){
                                maxC= 10;
                                mapMaxchat.put(i,mapMax.get(i).get(j));
                                result = i;
                            }else{
                                maxC = Integer.parseInt(mapMax.get(i).get(j).substring(0,1));
                                mapMaxchat.put(i,mapMax.get(i).get(j));
                                result = i;
                            }
                        }
                        testC = false;
                        testB= false;

                    }else if(String.valueOf(mapMax.get(i).get(j).substring(1,2)).equals("B")&&testC){

                        if(maxB<Integer.parseInt(mapMax.get(i).get(j).substring(0,1))){
                            if(Integer.parseInt(mapMax.get(i).get(j).substring(0,1))==1){
                                maxB= 10;
                                mapMaxchat.put(i,mapMax.get(i).get(j));
                                result = i;
                            }else{
                                maxB = Integer.parseInt(mapMax.get(i).get(j).substring(0,1));
                                mapMaxchat.put(i,mapMax.get(i).get(j));
                                result = i;
                            }
                        }
                        testB = false;
                    } else if(testB){

                        if(maxT<Integer.parseInt(mapMax.get(i).get(j).substring(0,1))){
                            if(Integer.parseInt(mapMax.get(i).get(j).substring(0,1))==1){
                                maxT= 10;
                                mapMaxchat.put(i,mapMax.get(i).get(j));
                                result = i;
                            }else{
                                maxT = Integer.parseInt(mapMax.get(i).get(j).substring(0,1));
                                mapMaxchat.put(i,mapMax.get(i).get(j));
                                result = i;
                            }
                        }
                    }

                }
            }
        }
        // 1T 3R 5B
        // 6B 9T 4C
        // 5T 4T 3T
        // 9C 9R 9B
        return result;

    }

}

public class baibala {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<String> tamnm = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        List<String> nghiatt = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        List<String> huypq = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        List<String> thongnh = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        String result = Result.baCay(tamnm, nghiatt, huypq, thongnh);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
