package IO_Test.exercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 记录文本中每个字符出现的次数
 * @athor:lhl
 * @create:2019-09-15 17:04
 */
public class CountWords {

    public static void main(String[] args) {
        count("F:\\IDEA Projects\\project\\Java常用类\\src\\IO_Test\\exercise\\123.txt","F:\\IDEA Projects\\project\\Java常用类\\src\\IO_Test\\exercise\\1234.txt");
    }

    public static void count(String path,String dest){
        FileReader fr= null;
        FileWriter fw= null;

        try {
            //创建流
            fr = new FileReader(path);
            fw = new FileWriter(dest);

            HashMap<String,Integer> map=new HashMap<>();

            //读取并统计
            int len=0;
            while ((len=fr.read())!=-1){
                //除去空格
                if((char)len!=' '&&(char)len!='\r'&&(char)len!='\n'&&(char)len!='\t'){
                    //有的话值+1
                    if(map.containsKey(String.valueOf((char)len))){
                        map.put(String.valueOf((char) len),map.get(String.valueOf((char) len))+1);
                    }

                    //没有的话穿建一个
                    else{
                        map.put(String.valueOf((char) len),1);
                    }
                }

            }
            //文件遍历完成,写入结果(遍历)

            Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

            while (iterator.hasNext()){
                Map.Entry<String, Integer> entry = iterator.next();
                String key = entry.getKey();
                Integer value = entry.getValue();
                //写入值
                fw.write(key+" : ");
                fw.write(value+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
