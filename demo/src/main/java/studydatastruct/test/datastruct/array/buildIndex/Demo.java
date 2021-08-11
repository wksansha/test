package studydatastruct.test.datastruct.array.buildIndex;

import java.util.*;

/**
 * @author wangkai
 * @create 2020/12/22
 */
public class Demo {

    public static void main(String[] args) {

        // 老公组
        List<Couple> husbands = new ArrayList<>();
        husbands.add(new Couple(1, "梁山伯"));
        husbands.add(new Couple(2, "牛郎"));
        husbands.add(new Couple(3, "干将"));
        husbands.add(new Couple(4, "工藤新一"));
        husbands.add(new Couple(5, "罗密欧"));

        // 老婆组
        List<Couple> wives = new ArrayList<>();
        wives.add(new Couple(1, "祝英台"));
        wives.add(new Couple(2, "织女"));
        wives.add(new Couple(3, "莫邪"));
        wives.add(new Couple(4, "毛利兰"));
        wives.add(new Couple(5, "朱丽叶"));

        compose(husbands,wives);
    }
    private static void compose(List<Couple> husbands,List<Couple> wives){
        ListIterator<Couple> iterator = wives.listIterator();
        for (Couple husband : husbands) {
            // 迭代器遍历
            while (iterator.hasNext()) {
                Couple wife = iterator.next();
                // 记录循环的次数
                if (husband.getFamilyId().equals(wife.getFamilyId())) {
                    System.out.println(husband.getUserName() + "爱" + wife.getUserName());
                    // 迭代器删除
                    iterator.remove();
                    break;
                }
            }
        }
    }
    //创建索引
    private static void compose1(List<Couple> husbands,List<Couple> wives){
        Map<Integer,Couple> map = new HashMap<>();
        for(Couple wive : wives){
            map.put(wive.getFamilyId(),wive);
        }
        for(Couple husband : husbands){
            System.out.println(husband.getUserName() + "爱" + map.get(husband.getFamilyId()).getUserName());
        }
    }
}

