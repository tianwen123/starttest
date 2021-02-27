package org.example;

import org.example.common.DpBase;
import org.example.utils.RetrofitManager;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Unit test for simple App.
 */

public class AppTest extends DpBase {
    /**
     * Rigorous Test :-)
     */

    @Test(description = "第一个描述",testName ="第一个名字")
    public void shouldAnswerWithTrue(){
        System.out.println("你好");
    }
//    @Test(description = "第2个描述",dataProvider = "dbconfig")
//    @Path("testdata/demo.yaml")
    @Test
    public void shouldAnswerWithTrue2(){
//        IUserService userService = RetrofitManager.getInstance().getRetrofit().create(IUserService.class);
//        Call<String> res=userService.getString();
//        res.enqueue(new Callback<String>() {
//            //请求成功时回调
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                // 步骤7：处理返回的数据结果
//
//                System.out.println( response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable throwable) {
//                System.out.println( call.toString());
//            }
//
//        });

    }
}
