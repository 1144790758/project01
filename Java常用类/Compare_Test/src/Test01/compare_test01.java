package Test01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @athor:lhl
 * @create:2019-08-18 21:49
 *
 *
 * Comparable:属于持久性的增加比较方式
 * Comparator:属于临时比较,可以随时指定怎么比较
 */
public class compare_test01 {
    public static void main(String[] args) {
        System.out.println(1);
    }
    //通过comparable的实现接口的对象来比较大小

    @Test
    public void test01(){
        Book b1=new Book("思修",20);
        Book b2=new Book("体育",25);
        Book b3=new Book("统计",60);

        Book[] arry=new Book[]{b1,b2,b3};

        //利用Arrays进行排序和输出
        Arrays.sort(arry);

        System.out.println(Arrays.toString(arry));

    }

    //通过comparator的方式随时更改排序方式 (从大到小)
    @Test
    public void test02(){
        Book2 b1=new Book2("思修",20);
        Book2 b2=new Book2("体育",25);
        Book2 b3=new Book2("统计",60);

        Book2[] arry=new Book2[]{b1,b2,b3};



        Arrays.sort(arry, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Book2 && o1 instanceof Book2){
                    if (((Book2) o1).price >((Book2)o2).price){
                        return -1;
                    }else if (((Book2) o1).price <((Book2)o2).price){
                        return 1;
                    }else return 0;
                }
                throw new RuntimeException("类型错误");
            }
        });

        System.out.println(Arrays.toString(arry));


    }


    //使用泛型的方式完成定制排序(Comparator)
    @Test
    public void test03(){
        TreeSet<Book2> set=new TreeSet<>(new Comparator<Book2>() {
            @Override
            public int compare(Book2 o1, Book2 o2) {
                if(o1.price>o2.price){
                    return 1;
                }else if(o1.price<o2.price){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        Book2 b1=new Book2("思修",20);
        Book2 b2=new Book2("体育",25);
        Book2 b3=new Book2("统计",60);

        set.add(b1);
        set.add(b2);
        set.add(b3);

        //遍历集合
        Iterator<Book2> iterator = set.iterator();

        while (iterator.hasNext()){
            Book2 next = iterator.next();
            System.out.println(next);

        }
    }

}

// Book类实现接口
class Book implements Comparable{
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    //重写compareTo(返回从小到大顺序)
    @Override
    public int compareTo(Object o) {
        if(o instanceof Book){
            Book b=(Book) o;
            if(this.price>b.price){
                return 1;
            }else if(this.price<b.price){
                return -1;
            }else return 0;
        }

        throw new RuntimeException("传入的对象有误,不能相比较");
    }
}

class Book2  {
    String name;
    int price;

    public Book2(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}

