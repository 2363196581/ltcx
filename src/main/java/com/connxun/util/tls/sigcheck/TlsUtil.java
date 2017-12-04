//package com.connxun.util.tls.sigcheck;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//
//import com.jfinal.kit.JsonKit;
//import com.jfinal.kit.PathKit;
//import com.jfinal.kit.Prop;
//import com.jfinal.kit.PropKit;
//import com.jfinal.log.Log;
//import com.util.Utils;
//
///**
// *
// * @author flyinke
// * https://www.qcloud.com/document/product/269/1510
// */
//public class TlsSigUtil  {
//	Log log = Log.getLog(TlsSigUtil.class);
//
//	private static File priKeyFile;
//	private static File pubKeyFile;
//	private static tls_sigcheck sigcheck;
//	private static String sdkAppid;
//
//
//	public TlsSigUtil() {
//		Prop pr = PropKit.use("config.properties");
//        sigcheck = new tls_sigcheck();
//
//        String os = System.getProperty("os.name");
//        if(os.toLowerCase().startsWith("win")){
//        	//C:/"+pr.get("baseUploadPath")+"/
//        	sigcheck.loadJniLib(PathKit.getRootClassPath()+"/jnisigcheck_mt_x64.dll");
//        }else{
//        	//PropKit.use("config.properties").get("baseUploadPath")
//        	sigcheck.loadJniLib(PathKit.getRootClassPath()+"/jnisigcheck_mt_x64.so");
//        }
//        sdkAppid = pr.get("im.SdkAppid");
//	}
//
//	/**
//	 * 生成sig
//	 * @param identifier
//	 * @return
//	 * @throws Exception
//	 */
//	public  CheckResultEntity genSin(String identifier ) throws Exception {
//		CheckResultEntity resultEntity = new CheckResultEntity();
//		priKeyFile = new File(PathKit.getRootClassPath()+"/private_key");
//		StringBuilder strBuilder = new StringBuilder();
//        String s = "";
//
//        BufferedReader br = new BufferedReader(new FileReader(priKeyFile));
//        while ((s = br.readLine()) != null) {
//            strBuilder.append(s + '\n');
//        }
//        br.close();
//        String priKey = strBuilder.toString();
////        System.out.println("identifier="+identifier+"   sdkAppid="+sdkAppid+"   priKey="+priKey);
//		int ret = sigcheck.tls_gen_signature_ex2(sdkAppid, identifier, priKey);
//        resultEntity.setRet(ret);
//        if (0 != ret) {
//        	log.error("identifier "+identifier+"  ret " + ret + " " + sigcheck.getErrMsg());
//        	resultEntity.setOk(false);
//        	resultEntity.setErrMsg(sigcheck.getErrMsg());
//
//        }
//        else
//        {
//        	//log.info("identifier "+identifier+"  sig:\n"+sigcheck.getSig());
//        	resultEntity.setOk(true);
//        	resultEntity.setSig(sigcheck.getSig());
//
//        }
//        return resultEntity;
//	}
//
//	/**
//	 * 验证sig
//	 * @param identifier
//	 * @param sig
//	 * @return
//	 * @throws Exception
//	 */
//	public   CheckResultEntity checkSin(String identifier,String sig) throws Exception {
//		System.out.println(sig);
//		CheckResultEntity resultEntity = new CheckResultEntity();
//		pubKeyFile = new File(PathKit.getRootClassPath()+"/public_key");
//		StringBuilder strBuilder = new StringBuilder();
//        String s = "";
//
//        BufferedReader br = new BufferedReader(new FileReader(pubKeyFile));
//		strBuilder.setLength(0);
//        while ((s = br.readLine()) != null) {
//            strBuilder.append(s + '\n');
//        }
//        br.close();
//        String pubKey = strBuilder.toString();
//		int ret = sigcheck.tls_check_signature_ex2(sig, pubKey, sdkAppid, identifier);
//		resultEntity.setRet(ret);
//        if (0 != ret) {
//        	log.error("identifier "+identifier+"  ret " + ret + " " + sigcheck.getErrMsg());
//        	resultEntity.setOk(false);
//        	resultEntity.setErrMsg(sigcheck.getErrMsg());
//
//        }
//        else
//        {
//        	resultEntity.setOk(true);
//        	resultEntity.setSig(sig);
//        	resultEntity.setExpireTime(sigcheck.getExpireTime());
//        	resultEntity.setInitTime(sigcheck.getInitTime());
//        }
//
//        return resultEntity;
//	}
//	 tls_sigcheck demo = new tls_sigcheck();
//
//	public static void main(String[] args) throws Exception {
//		try {
////			String sig = JsonKit.toJson(new TlsSigUtil().genSin("wyl123456"));
//			CheckResultEntity resultEntity=new TlsSigUtil().genSin("wyl123456");
//			System.out.println(resultEntity.getSig());
//			resultEntity = new TlsSigUtil().checkSin("wyl123456", resultEntity.getSig());
//			System.out.println(JsonKit.toJson(resultEntity));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
