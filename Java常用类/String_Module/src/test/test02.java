package test;

/**
 *
 * 测试 final关键字
 * @athor:lhl
 * @create:2019-07-27 20:23
 */
public class test02 implements CharSequence{

    private final char value[];

    public test02() {
        value = new char[0];
    }


    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }



}
