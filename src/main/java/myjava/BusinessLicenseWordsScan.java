package myjava;

import com.alibaba.fastjson.JSON;
import myjava.entity.BusinessLicense;
import myjava.entity.BusinessPermit;
import myjava.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author l
 * @date 2021/6/16 15:48
 * @description
 *
 * https://market.aliyun.com/products/57124001/cmapi013592.html?spm=5176.2020520132.101.2.42ad7218miJ4xX#sku=yuncode759200000
 * 印刷文字识别-营业执照识别/OCR文字识别
 * OCR (Optical Character Recognition,光学字符识别)
 *
 * demo
 *
 *
 *
 */
public class BusinessLicenseWordsScan {
    public static void main(String[] args) {

        String imagePath = BusinessLicenseWordsScan.class.getResource("/").getPath()+"businessLicense1.jpg";
        imagePath = "./src/main/resources/businessLicense2.jpg";
        String imageBinary = getImageBinary(imagePath);
//        BusinessLicense businessLicense = getBusinessLicense(imageBinary);

        String foodBusinessLicenseUrl = "http://txlcoss.oss-cn-hangzhou.aliyuncs.com//aliyuncs/resource/2020/08/02/4240457.jpg?x-oss-process=image/resize,h_700";
        foodBusinessLicenseUrl = "./src/main/resources/foodBusinessLicense1.jpg";
        imageBinary = getImageBinary(foodBusinessLicenseUrl);

        int type = 1;
        BusinessPermit fbl = getFoodBusinessLicense(type,imageBinary);
        System.out.println(fbl.getSid());
        for (Map map:fbl.getPrism_keyValueInfo()){
            System.out.println(map.get("key")+"----"+map.get("value"));

        }

    }

    /**
     * @param  type 0 url , 1 binary
     * */
    private static BusinessPermit getFoodBusinessLicense(int type, String foodBusinessLicenseUrl) {
        BusinessPermit foodBusinessLicense = null;
        String host = "https://ocrapi-food-blicense.taobao.com";
        String path = "/ocrservice/foodBlicense";
        String method = "POST";
        String appcode = "87761b11d9424c7bbe090f70c94f23fa";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
//        String bodys = "{\"img\":\"\",\"url\":\"\"}";

        String bodys = "{\"url\":\""+foodBusinessLicenseUrl+"\"}";
        if (type == 1)
            bodys = "{\"img\":\""+foodBusinessLicenseUrl+"\"}";

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response.toString());
            //获取response的body
//            System.out.println(EntityUtils.toString(response.getEntity()));
            foodBusinessLicense = JSON.parseObject(EntityUtils.toString(response.getEntity()), BusinessPermit.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return foodBusinessLicense;

    }


    public static BusinessLicense getBusinessLicense(String imageUrl){
        BusinessLicense businessLicense = null;

        String host = "https://dm-58.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_business_license.json";
        String method = "POST";
        String appcode = "87761b11d9424c7bbe090f70c94f23fa";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
//        String bodys = "{\"image\":\"图片二进制数据的base64编码或者图片url\"}";
        //url 的方试
//        String imageUrl = "http://txlcoss.oss-cn-hangzhou.aliyuncs.com//aliyuncs/resource/2020/04/28/4012674.jpg";
//        String bodys = "{\"image\":\""+imageUrl+"\"}";
        //读取文件的方式 。
        //BusinessLicenseWordsScan.class.getResource("/").getPath() ==  /E:/practice/java/mjava/target/classes/

        String bodys = "{\"image\":\""+imageUrl+"\"}";

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            System.out.println(EntityUtils.toString(response.getEntity()));
            //获取response的body
            businessLicense = JSON.parseObject(EntityUtils.toString(response.getEntity()),BusinessLicense.class);
            System.out.println(businessLicense.getName()+"..."+businessLicense.getReg_num()+"..."+businessLicense.getAddress()+"..."+businessLicense.getPerson());



        } catch (Exception e) {
            e.printStackTrace();
        }

        return businessLicense;
    }

    public static String getImageBinary(String imageFile){
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imageFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);

    }
}
