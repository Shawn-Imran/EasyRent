package com.example.easyrent.Controller;

import com.example.easyrent.Model.Login;
import com.example.easyrent.Model.Services;
import com.example.easyrent.Model.Test;
import com.example.easyrent.Repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
/*@Author:Tamzid Khan
  @####1959###752##02%9

  Query:
   #single-product add# INSERT INTO `single_services` (`id`, `sid`, `type`, `service`, `subservice`, `name`, `description`, `cost`, `img`, `imgB`)
   VALUES (NULL, 'exc0001', 'Official', 'Heavy Equipment', 'Excavator', 'Mini Excavator 302.7D CR', 'Net Power:20.7 HP\r\nOperating Weight:6239 lb\r\nMaximum Digging Depth:2544/2744 mm (8 ft 4 in/9 ft 0 in)', '1000Tk./d', 'images/miniexcavatorS.png', 'images/miniexcavatorB.png');
 */

@Controller
public class TestController {
    @Autowired
    ServicesRepository servicesRepository;
    @GetMapping("/test")
    public String getTest(Model model){
        Test test=new Test();
        model.addAttribute(test);
        return "test";

}
@PostMapping("/postTest")
public String  postTest(Test test,Model model){
    System.out.println(test.t);
    Test test1=new Test();
    model.addAttribute("test",test1);
    return "test";
}
    @PostMapping("/postTest1")
    public String  postTest1(Test test,Model model){
            Login login=new Login();
            model.addAttribute(login);
            System.out.println(test.t);
            return "login";

    }


}


