package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuaima
 * @create 2019-09-16 11:47
 */
public class test {

    //方法：将 中缀表达式转成对应的List
    //  s="1+((2+3)×4)-5";
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
//        String str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        String str="";
        do {
            //如果c是一个非数字，我需要加入到ls
            if((c=s.charAt(i)) < 48 ||  (c=s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { //如果是一个数，需要考虑多位数
                    str+=c;
                    i++;
                    if (i==s.length()|| (i<s.length()&&(s.matches("\\d+")))) {
                        ls.add(str);
                        str="";
                    }
            }
        }while(i < s.length());
        return ls;//返回
    }

    public static void main(String[] args) {
        String str = "156+265*364645-45";
        List list =toInfixExpressionList2(str);
        System.out.println(list);
    }

    //方法：将 中缀表达式转成对应的List
    //  s="1+((2+3)×4)-5";
    public static List<String> toInfixExpressionList2(String s) {
        //定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        String str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，我需要加入到ls
            if((c=s.charAt(i)) < 48 ||  (c=s.charAt(i)) > 57) {
                ls.add("" + c);
                i++; //i需要后移
            } else { //如果是一个数，需要考虑多位数
                str = ""; //先将str 置成"" '0'[48]->'9'[57]
                while(i < s.length() && (s.substring(i,i+1).matches("\\d+"))) {
                    str += s.substring(i,i+1);//拼接
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;//返回
    }
}
