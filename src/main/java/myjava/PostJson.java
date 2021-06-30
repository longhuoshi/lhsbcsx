package myjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyThrad implements Runnable{
	public static String strTime = System.currentTimeMillis()+"";


	@Override
	public void run() {
		String postData = "{\"buyerId\":1010,"
				+ "\"customerDeliveryDate\":\"2018-06-21\","
				+ "\"customerDeliveryTime\":5,\"lastModifyDate\":\"\","
						+ "\"orderDetail\":["
						+ " {"
						+ "\"customerRemark\":\"��˷����µ�\","
						+ "\"goodsId\":109,"
						+ " \"goodsName\":\"������(��)\","
						+ "\"goodsNum\":4,"
						+ " \"orderDetailId\":-1,"
						+ "\"orderDetailType\":10,"
						+ "\"orderType\":10,"
						+ "\"orderTypeInit\":11,"
						+ "\"price\":6,"
						+ "\"specDesc\":\"ɢװ\","
						+ "\"supplierId\":2271,"
						+ "\"supplierName\":\"�����˺�Y\","
						+ "\"ticketFlag\":false,"
						+ "\"untiCode\":\"��\","
						+ "\"suppliers\":["
						+ "{"
							+ "\"id\":2271,"
							+ "\"name\":\"�����˺�Y\""
						+ "},"
						+ "{"
							+ "\"id\":830,"
							+ "\"name\":\"�Թ�\""
						+ "},"
						+ "{"
						+ "\"id\":2270,"
						+ "\"name\":\"�����˺�Z\""
					+ "}"
				+ "]"
			+ "}"
		+ "],"
		+ "\"orderId\":-1,"
		+ "\"remark\":\"\","
		+ "\"source\":1,"
		+ "\"status\":0,"
		+ "\"totalAmount\":8.00"
	+ "}";
		
		PostJson.postserver(postData,strTime);
		
		
	}
	
}


public class PostJson {
	private static final String base = "http://192.168.10.80"; //  http://localhost:8080   http://192.168.10.80
	private static final String actionUrl = base+"/extInterface/mobile/orderSave";// /efarm
	public static void main(String[] args) {
		MyThrad mRunnable = new MyThrad();
		Thread thread = new Thread(mRunnable);
		Thread thread2 = new Thread(mRunnable);
		thread.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start();
//		System.out.println("hello");
		

	}
	
	public static String getDateTime(){
		String format = "yyyyMMddHHmmssSSS";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}
	/**
	 * ��������
	 * @param postData ���ݰ�
	 * @param packageId ָ������к�
	 * 
	 * */
	public static String postserver(String postData,String strTime) {
		String result = "";
		
		
		URL url;
		try {

			url = new URL(actionUrl+"?token=3934139b37235f0a43337827ad40ebed&timestamp="+strTime);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
			connection.setDoOutput(true);  
			connection.setRequestMethod("POST");  
			connection.setRequestProperty("Content-Type", "application/json");
			
			java.io.OutputStream os=connection.getOutputStream();  
			OutputStreamWriter osw=new OutputStreamWriter(os);  
			 osw.write(postData);
			//" + str
			 osw.flush();  
//			 osw.close();
			/*�����ļ����ݸ����ʵ��*/

		 BufferedReader inss = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
		 String line = null;  
		 StringBuffer content= new StringBuffer();  
		 while((line = inss.readLine()) != null){//lineΪ����ֵ����Ϳ����ж��Ƿ�ɹ���  
			content.append(line);  
		 }
		inss.close() ;  
//		System.out.println("==content=="+content.toString());
		String signMsg = content.toString();
		signMsg = signMsg.substring(8,signMsg.length());
		byte[] signB = signMsg.getBytes();	
//        signB = ReturnValue.base64dec(signMsg.getBytes());
        result = new String(signB,"utf-8");
//		System.out.println(" ");
		System.out.println(Thread.currentThread()+"���ؽ����" + result);
//		System.out.println("���н�����");
        
		inss=null;  
		url=null; 
		} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}  catch (ProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
		return result;
	}

}
