package myjava;

/**
 * @author l
 * @date 2021/12/1 16:34
 * @description
 */
public enum PayEnumStrategy {
    ALI_PAY("com.lhs.AliPay"),
    WECHAT_PAY("com.lhs.WeChatPay");

    PayEnumStrategy(String className) {
        this.className = className;
    }
    /**
     * class完整地址
     */
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

/**调用示例：
 *         PayEnumStrategy ali_pay = PayEnumStrategy.valueOf("WECHAT_PAY");
 *         System.out.println(ali_pay.getClassName());
 * */

