package studydatastruct.test.datastruct.digui;

/**
 * @author wangkai
 * @create 2021/3/18
 */
import java.io.*;

public class Main{


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        while((str = br.readLine())!= null){
            int g = 0;
            g = Integer.parseInt(str);

            if(g == 0){
                return;
            }

            int count = 0;

            while (true){
                int f = g/3;
                count+=f;
                g =g%3 +f;

                if(g < 3){
                    break;
                }
            }

            if(g==2){
                count+=1;
            }
            System.out.println(count);
        }
    }

}
