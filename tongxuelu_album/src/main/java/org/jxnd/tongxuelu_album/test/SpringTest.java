package org.jxnd.tongxuelu_album.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jxnd.tongxuelu_album.dao.UserMapper;
import org.jxnd.tongxuelu_album.entity.Album;
import org.jxnd.tongxuelu_album.entity.FtpConfig;
import org.jxnd.tongxuelu_album.service.IAlbumService;
import org.jxnd.tongxuelu_album.service.IPhotoService;
import org.jxnd.tongxuelu_album.service.IUserService;
import org.jxnd.tongxuelu_album.service.impl.AlbumService;
import org.jxnd.tongxuelu_album.utils.FtpUtil;
import org.jxnd.tongxuelu_album.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * Created by mym on 2017/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringTest {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private IUserService iUserService;

	@Autowired
	private IPhotoService iPhotoService;

    
    @Test
    public void test1(){

		System.out.println(userMapper.getUserIdAndPwd("20170904","f5bb0c8de146c67b44babbf4e6584cc0").getDescription());
    }
    
    @Test
    public void testMD5(){
    	
    	System.out.println(MD5Utils.md5("123456"));
    	System.out.println(System.getProperties().getProperty("java.vm.version"));
    }
    
//    @Test
//    public void selectUserByUserId(){
//    	System.out.println(iUserService.selectUserByUserId("20170904"));
//    }
    
    
    /**
	 * 利用通道完成文件复制
	 */
	@Test
	public void nodirectBufferCopyTest(){
		FileOutputStream fos = null;
		FileInputStream fis = null;
		FileChannel inChannel = null; 
		FileChannel outChannel = null;
		
		try {
			fos = new FileOutputStream("http://192.168.73.187/images/1.jpg/10_1.jpg");
			fis = new FileInputStream("d://10.jpg");
			
			//获取通道
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();
			
			//分配缓冲区
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			//将通道数据读出来存放到缓冲区
			while(inChannel.read(buf) != -1){
				//把缓冲区的数据写到输出通道中
				buf.flip();				//切换读取数据模式
				outChannel.write(buf);
				//然后再清空缓冲区，等待下一次存放数据
				buf.clear();
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(outChannel != null)
					outChannel.close();
				if(inChannel != null)
					inChannel.close();
				if(fos != null)
					fos.close();
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
		}
		
	}
	
	@Autowired
	private FtpConfig ftpConfig;

	
	@Test
	public void testFTPUpload() throws IOException{
		
		
		/*System.out.println(ftpConfig.getFTP_ADDRESS());
		boolean result = FtpUtil.uploadFile(ftpConfig.getFTP_ADDRESS(), ftpConfig.getFTP_PORT(), ftpConfig.getFTP_USERNAME(),
				ftpConfig.getFTP_PASSWORD(), ftpConfig.getFTP_BASEPATH(), "/upload", "10.jpg", new FileInputStream("d://18.jpg"));
		*/
		
		//String result = FtpUtil.pictureUpload("2.jpg", "/upload", new FileInputStream("d://10.jpg"));
		String result = FtpUtil.pictureUploadByConfig(ftpConfig,"5.gif", "/upload/5/2", new FileInputStream("d://tttest.gif"));

		System.out.println(result);
		
		
	
	}

	@Autowired
	private IAlbumService iAlbumService;

	@Test
	public void testAlbum(){
		List<Album> list = iAlbumService.selectAll();
		if(list != null){
			System.out.println(list.get(1).getAlbumName());
			System.out.println(list.get(0).getPhotoList().get(0).getPhotoUrl());
		}
	}




	@Test
	public void test11(){
		System.out.println(iPhotoService.deleteByPhotoId(1));
	}




    
    

  
}
