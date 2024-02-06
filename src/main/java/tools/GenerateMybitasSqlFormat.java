package tools;

/**
 * @author l
 * @date 2024/1/5 11:46
 * @description
 *1、查出表字段
 * SELECT GROUP_CONCAT(column_name) FROM information_schema.columns WHERE table_name='buyer_goods_check_detail'
 * 字段1,字段1,字段1 ... ...
 *
 * 2、把字段转化成
 *
 */
public class GenerateMybitasSqlFormat {
    public static void main(String[] args) {
        String fields = "RECEIPT_ID,SHARE_MODE,RECEIPT_TYPE,GROUP_ID,CUSTOMER_DELIVERY_DATE,ORDER_ID,BUYER_ID,SUPPLIER_ID,STAFF_ID,STAFF_NAME,BEGIN_DATE,END_DATE,APP_CODE,VIDEO_URL,LNG,LAT,RS_ID,RS_IDS,CREATER,CREATE_DATE,RECEIPT_ALL_IN_ONE_TYPE";
        String[] split = fields.split(",");
        StringBuffer sb = new StringBuffer();
        for (String s : split) {
            sb.append("#{item.").append(s).append("},");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
