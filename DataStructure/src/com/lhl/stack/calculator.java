package com.lhl.stack;

/**
 * @athor:lhl
 * @create:2019-07-15 0:54
 * 利用两个栈实现输入一串数学公式计算结果
 */
public class calculator {
    public static void main(String[] args) {

        calculator c1=new calculator();
        System.out.println(c1.theMethod("3*4+1"));
    }

    //需要一个方法来确定符号的优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            //java中char可以与int互换
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else return -1;
    }

    //判断是否为一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //判断是否为数字
    public boolean isNumber(char val) {
        return val >= 48 && val <= 57;
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new RuntimeException("运算错误");
        }
    }

    public int theMethod(String expr) {
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        //建立扫描索引
        int index = 0;

        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch;

        while (true) {
            //依次得到expr的每一个字符
            //substring前闭后开
            ch = expr.substring(index, index + 1).charAt(0);

            //判断ch是什么然后做相应的处理
            //是符号,则入符号栈
            if (isOper(ch)) {
                //判断是否符号栈为空
                if (operStack.isEmpty()) {
                    //为空则入栈
                    operStack.push(ch);
                } else {
                    //不为空则与前一个符号做比较
                    // ch 优先级大于等于前一个符号
                    if (priority(operStack.getTop()) <= priority(ch)) {
                        operStack.push(ch);
                    } else {
                        // 优先级小于前一个符号
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = cal(num2, num1, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }
                }

            }
            //如果是数字,直接入数栈
            else if (isNumber(ch)) {
                numStack.push(ch);
            }

            //index加一,判断是否扫描到最后
            index++;
            if (index > expr.length()) {
                break;
            }

        }

        //进行栈运算
        while (true) {
            //如果符号栈为空则计算到最后的结果
            // 数栈中只有一个且为最后结果

            if (operStack.isEmpty()) {
                return numStack.getTop();
            } else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = cal(num2, num1, oper);
                numStack.push(res);
            }

        }

    }

}
