package StringBuffer_01;

/**
 *
 * StringBuffer: 可变字符串序列,但是效率较StringBuilder 效率低,
 * 因为其是线程安全的
 *
 * 关于其扩容的问题:默认是一个长度为16的空数组,
 * 扩容扩大为原来的2倍+2 创建这样一个数组,
 * 再把原来的内容和新加的内容复制过去
 *
 * 开发建议:使用StringBuffer(int capacity),
 * 设置长度,避免复制扩容,可以提高效率,StringBuilder也是类似
 *
 * @athor:lhl
 * @create:2019-07-30 0:14
 */
public class StringBuffer_test01 {
}
