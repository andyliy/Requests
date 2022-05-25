package com.andy.cases;

import com.andy.Constants.constants;
import com.andy.utils.Requests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterCase {  //操作事务

    @Test
    public void testRegister(String params){
        String Url = constants.register_url;  //从constants取得基础数据url
        String method = constants.method;   //从constants取得方法名称method
        String body = Requests.call(method , Url , params);  //调用utils.Requests下的call方法
        boolean flag = body.contains("登陆成功");
        System.out.println("断言结果：" + flag);
        Assert.assertEquals(flag,true); //断言输出，可以记录用例测试情况

    }


    //使用DataProvider对输入参数做操作，带入@Test中直接使用
    @DataProvider(name = "datas")
    public Object[][] datas(){
        Object[][] datas = {   //输入多种数据形式，对接口进行测试
                {"username=&password=123"},  //username字段为空，password字段为123
                {"username=123123&password=123"},  //username字段为123123，password字段为123
                {"username=123123&password="},  //username字段为123123，password字段为空
                {}
        };
        return datas;
    }
}
