package com.cn.springcloud.controller;

import com.cn.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@DefaultProperties(defaultFallback = "Payment_Global_FallBackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value="/consumer/service/hystrixOk/{id}")
    public String hystrixOk(@PathVariable("id")int id){
        return paymentService.hystrixOk(id);
    }

  /*  @GetMapping(value="/service/hystrixTimeout/{id}")
    public String hystrixTimeout(@PathVariable("id") int id){
        return paymentService.hystrixTimeout(id);
    }*/

   @GetMapping(value="/service/hystrixTimeout/{id}")
   @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler",
   commandProperties ={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})//3秒以内是正常的业务
//   @HystrixCommand
   public String hystrixTimeout(@PathVariable("id") int id){
       int time = 2000;
       int i = 100/0;
       try{

//           TimeUnit.MILLISECONDS.sleep(time);
       }catch (Exception e){
           e.printStackTrace();
       }
      return paymentService.hystrixTimeout(id);
   }

   public String hystrixTimeoutHandler(@PathVariable("id") int id){
       return "消费端熔断测试，id："+id+"支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
   }

   public String Payment_Global_FallBackMethod(){
       return "全局FallBackMehnod，服务器暂时不可用，请稍后尝试!!";
   }
}
