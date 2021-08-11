package studydatastruct.test.datastruct.array.useHashMap;

import java.util.HashMap;
import java.util.Map;

public class BaseOperateArray {


    public static void main(String[] args){
        int[] a = twosum();
        if (a != null) {
            for(int s:a){
                System.out.println(s);
            }
        }
    }

    /**
     * two sum
     * @return
     */
    private static int[] twosum(){
        int[] testnum = {2,4,5,3,6};
        int a= 8;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<testnum.length;i++){
            int value = a - testnum[i];
            if(map.containsKey(value)){
                return new int[]{map.get(value),i};
            }else{
                map.put(testnum[i],i);
            }
        }
        return null;
    }
}
