package StringExercisese;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 寻找最长子串
 * @athor:lhl
 * @create:2019-08-15 11:25
 */
public class Find_Max_Substring {

    static List<String> Method(String str1,String str2){

        ArrayList<String>Anwser=new ArrayList<String>();

        //先取短的那个字符串,然后建立两个标志,.标志组合为一个窗口
        //窗口每次都会固定大小在str2上面滑动,然后匹配str1,若是匹配不了,窗口就减小1

        if(str1.length()<=str2.length()){
            //str1 是长的 str2 是短的
            String str3;
            str3=str1;
            str1=str2;
            str2=str3;
        }


        for(int i=str2.length();i>0;i--){

            //滑动窗口

                //j为窗口大小 k为窗口起始位置
                int j;
                int k;
                for(j=i,k=0;j>=1;k++){
                    //判断是否可以继续滑动,否则超出字符串范围
                    if (k+j>str2.length()){
                        break;
                    }

                    String subString=str2.substring(k,k+j);
                    if (str1.contains(subString)){
                        //如果包含子串则是其最大子串
                        Anwser.add(subString);
                    }
                }
                if (Anwser.isEmpty()!=true){
                    return Anwser;
                }

        }

        return null;
    }

    public static void main(String[] args) {

        String str1="aaahelloabcdggggg";
        String str2="bhellogggggr";

        List<String> stringList = Method(str1, str2);
        System.out.println(stringList);
    }
}
