package com.leaf.demo;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class Test {
	public static void main(String[] args) throws Exception {
		// 加载配置文件
		ClientGlobal.init("M:\\workspace\\java\\pinyougoumall\\fastDFSDemo\\src\\main\\resources\\fdfs_client.conf");
		// 创建tracker的客户端
		TrackerClient client = new TrackerClient();
		// 连接管理者服务端
		TrackerServer trackerServer = client.getConnection();
		// 生命存储服务端
		StorageServer storageServer = null;
        //获取存储服务器的客户端对象
		StorageClient storageClient = new StorageClient(trackerServer,storageServer);
		//file_id
		String[] str = storageClient.upload_file("D:\\temp\\spotlight.jpg", "jpg", null);
		for (String string : str) {
			System.out.println(string);
			/**
返回结果group1
M00/00/00/wKgZhVwnEUeAWQpeAAGVypfKEEM079.jpg
			 */
		}
		//http://访问地址：192.168.25.133/group1/M00/00/00/wKgZhVwnEUeAWQpeAAGVypfKEEM079.jpg
	}
}
