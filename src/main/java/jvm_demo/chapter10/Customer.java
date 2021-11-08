package jvm_demo.chapter10;
/**
 * 105-对象的内存布局
 * */
public class Customer {
    int id = 1001;
    String name;
    Account acct;

    {
        name="匿名客户";
    }
    public Customer(){
        acct = new Account();
    }
}

class Account{}
