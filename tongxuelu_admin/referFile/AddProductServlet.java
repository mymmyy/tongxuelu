package cn.onestore.web.servlet;

import cn.onestore.domain.Product;
import cn.onestore.domain.Shop;
import cn.onestore.exception.UploadException;
import cn.onestore.service.ProductServiceDao;
import cn.onestore.service.ProductServiceDaoImpl;
import cn.onestore.utils.PicUtils;
import cn.onestore.utils.UploadUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by 明柯 on 2017/4/20.
 * 商品的web层
 */
public class AddProductServlet extends HttpServlet{
    private ProductServiceDao productServiceDao = new ProductServiceDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //要做的事：1.创建一个文件项（用来存储传过来的文件项内容，可以是临时存储区，也可以是磁盘）
        //2.创建ServletFileUpload 对象
        //3.分别获取文件项内容（上传项和非上传项）、并且分配随机目录、随机名称
        //组装数据库存储的imgurl
        //4.文件上传操作
        //5.调用service方法添加商品
        //6.给出提示信息，返回添加商品页面

        //0.准备product对象
        Product product = new Product();
        Integer shopid = null;
        Shop shop = null;

        //1.创建文件项，并配置临时缓冲区大小（默认为10k）、设置临时文件存储位置
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024*1024*5);//设置缓冲区为5M
        factory.setRepository(new File(this.getServletContext().getRealPath("/temp")));
        //设置临时文件存储位置

        //2.创建ServletFileUpload对象
        ServletFileUpload upload = new ServletFileUpload(factory);

        //3.1 分别获取文件项内容
        //3.1.1 判断是否是上传操作
        if(upload.isMultipartContent(req)){
            //即是上传操作
            upload.setHeaderEncoding("utf-8");//解决上传文件中文乱码问题

            //3.1.2 得到所有的文件项
            try {
                //这里用文件项接口接收
                List<FileItem> items = upload.parseRequest(req);

                //3.1.3 遍历items判断是否是上传项
                for(FileItem item:items){
                    if(item.isFormField()){
                        //说明是简单项（普通项）,把名称和内容获取并放到指定参数中
                        //这里要把内容封装到pruduct中,判断类型integer，String，double
                        //把内容以指定编码get到
                        String fieldName = item.getFieldName();
                        if("pname".equals(fieldName)){
                            product.setPname(item.getString("utf-8"));
                        }else if("price".equals(fieldName)){
                            product.setPrice(Double.parseDouble(item.getString("utf-8")));
                        }else if("category".equals(fieldName)){
                            product.setCategory(item.getString("utf-8"));
                        }
                        else if("pnum".equals(fieldName)){
                            product.setPnum(Integer.valueOf(item.getString("utf-8")));
                        }
                        else if("description".equals(fieldName)){
                            product.setDescription(item.getString("utf-8"));
                        }else if("shopid".equals(fieldName)){
                            shopid=Integer.valueOf(item.getString("utf-8"));
                        }

                    }else {
                        //说明是上传组件
                        String fileName = item.getName();//得到上传文件名称，包含了路径的名称
                        //3.2 通过上传工具类获得真实名称： d:/a/a/a.txt-->a.txt
                        fileName = UploadUtils.subFileName(fileName);

                        //3.3 得到随机名称
                        String uuidFileName = UploadUtils.generateRandonFileName(fileName);

                        //3.4 得到随机目录
                        String randomDir = UploadUtils.generateRandomDir(uuidFileName);

                        //3.5 得到在项目文件下的存储位置
                        String path = this.getServletContext().getRealPath("/upload"+randomDir);

                        //3.6 得到一个文件（有路径的文件，用于文件操作--》上传文件）
                        File pathFile = new File(path);

                        //3.6.1 如果文件不存在就创建一个
                        if(!pathFile.exists()){
                            pathFile.mkdirs();
                        }

                        //3.7 得到存储到数据库的imgurl  这个路径是基于项目的虚拟路径
                        String imgurl = File.separator+"upload"+randomDir+File.separator+uuidFileName;
                        //放到product对象中去
                        product.setImgurl(imgurl);

                        //4.文件上传存储到项目文件夹中
                        item.write(new File(pathFile,uuidFileName));

                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //附加一个功能：得到商品的缩略图
            PicUtils putils = new PicUtils(this.getServletContext()
                    .getRealPath(product.getImgurl()));
            putils.resize(120, 120);

            //5.调用service方法添加商品
            try{
                HttpSession session = req.getSession();
                shop = (Shop)session.getAttribute("userShop");
                productServiceDao.addProduct(product,shopid);
                //6.返回信息，返回添加商品页面
                resp.getWriter().write("<script>alert('添加成功')</script>");
                resp.getWriter().write("<script>window.location.href='/product/addproduct.jsp'</script>");
            }catch (UploadException e) {
                req.setAttribute("fail.message","上传失败，请稍后重试");
                req.setAttribute("userShop",shop);
                req.getRequestDispatcher(req.getContextPath()+"/product/addproduct.jsp").forward(req,resp);
            }

        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
