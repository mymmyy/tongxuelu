package org.jxnd.tongxuelu.test;


import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jxnd.tongxuelu.controller.MSG;
import org.jxnd.tongxuelu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.List;
/**
 * 使用Spring测试模块提供的测试请求功能，测试curd请求的正确性
 * Spring4测试的时候，需要servlet3.0的支持
 * 因为需要测试请求，所以需要把spring mvc的配置文件加入
 * Created by mym on 2017/8/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class MVCTest {

    //得到spring的IOC，@Autowire可以自动装配IOC内部的内容给对象，而如何把自己装配给别的对象？
    //通过@WebAppConfiguration进行注解即可
    @Autowired
    WebApplicationContext context;

    //虚拟MVC请求，获取得到处理结果
    MockMvc mockMvc;

    @Before
    public void initMokcMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }



    @Test
    public void testPage() throws Exception {
        //模拟请求，得到返回值
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/list").param("pn","5"))
                .andReturn();

        //请求成功以后  请求域中有pageINfo；我们可以取出来pageInfo进行验证
        MockHttpServletRequest request = mvcResult.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        //进行输出
        System.out.println("当前页码："+pageInfo.getPageNum());
        System.out.println("总页码："+pageInfo.getPages());
        System.out.println("总记录数："+pageInfo.getTotal());
        int[] nums = pageInfo.getNavigatepageNums();
        System.out.println("在页面需要连续显示的页码：");
        for(int i:nums){
            System.out.print(i+"、");
        }
        System.out.println();

        //获取员工数据
        List<User> list = pageInfo.getList();
        for(User e:list){
            System.out.println(e);
        }


    }



}
