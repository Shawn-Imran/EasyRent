package com.example.easyrent.Controller;

import com.example.easyrent.Model.*;
import com.example.easyrent.Repository.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
//=========Dependency Injection Area Start======//
    @Autowired
    UserRepository userRepository;
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    MethodController methodController;
    @Autowired
    SubServiceRepository subServiceRepository;
    @Autowired
    SingleServiceRepository singleServiceRepository;
    @Autowired
    TemporaryHold temporaryHold;
    @Autowired
    DealsRepository dealsRepository;
    @Autowired
    ProfileRepository profileRepository;

//=========Dependency Injection Area End======//
//=========Home Area Start======//
    @GetMapping("/home")
    public String getHome(Model model){
        Profile profile=new Profile();
        List <Services> officialservicesList=new ArrayList<Services>();
        List <Services> sponsoredservicesList=new ArrayList<Services>();
        officialservicesList=servicesRepository.findByType("Official");
        sponsoredservicesList=servicesRepository.findByType("Sponsored");
        model.addAttribute("officialservicesList",officialservicesList);
        model.addAttribute("sponsoredservicesList",sponsoredservicesList);
        methodController.navigationValues(model);
        model.addAttribute(profile);
        return "home";
    }
    @PostMapping("/postNavigation")
    public String postNavigation(Navigation navigation,Model model){
        List<SingleService>singleServiceList=new ArrayList<SingleService>();
        singleServiceList=singleServiceRepository.findBySub(navigation.flag);
        methodController.navigationValues(model);
        model.addAttribute("singleServiceList",singleServiceList);
        return "single_services";
    }
    @GetMapping("/contact")
    public String getContact(Model model){
        methodController.navigationValues(model);
        return "contact";
    }
    @GetMapping("/faq")
    public String getFaq(Model model){
        methodController.navigationValues(model);
        return "faq";
    }
    @PostMapping("/postSearch")
    public String postSearch(Profile profile,Model model){
        methodController.navigationValues(model);
        List <Services> officialservicesList=new ArrayList<Services>();
        List <Services> sponsoredservicesList=new ArrayList<Services>();
        officialservicesList=servicesRepository.findByType("Official");
        sponsoredservicesList=servicesRepository.findByType("Sponsored");
        model.addAttribute("officialservicesList",officialservicesList);
        model.addAttribute("sponsoredservicesList",sponsoredservicesList);
        return "services";
    }

//=========Home Area End======//
//=========Registration Area Start======//
    @GetMapping("/register")
    public String getRegister(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "registered";
    }

    @PostMapping("/postRegister")
    public String postRegister(User user,Model model){
        userRepository.save(user);
        Profile profile=new Profile();
        profile.name=user.name;
        profile.primarynumber=user.number;
        profile.email=user.email;
        profile.address=user.address;
        profileRepository.save(profile);
        Login login=new Login();
        model.addAttribute(login);
        return "login";
    }
//=========Registration Area End======//

//=========Login Area Start======//
    @GetMapping("/login")
    public String getLogin(Model model){
        Login login=new Login();
        methodController.navigationValues(model);
        model.addAttribute(login);
        return "login";
    }
    @PostMapping("/postLogin")
    public String postLogin(Login login,Model model){
        TemporaryHold.email=login.email;
        List <User> userList=new ArrayList<User>();
        List <Services> officialservicesList=new ArrayList<Services>();
        List <Services> sponsoredservicesList=new ArrayList<Services>();
        User user=new User();
        userList=userRepository.findByEmail(login.email);
        userList.add(user);
        if (userList.size()>1){
            if (userList.get(0).password.equals(login.password)){
                officialservicesList=servicesRepository.findByType("Official");
                sponsoredservicesList=servicesRepository.findByType("Sponsored");
                methodController.navigationValues(model);
                model.addAttribute("officialservicesList",officialservicesList);
                model.addAttribute("sponsoredservicesList",sponsoredservicesList);
                return "services";
            }
            else {
                methodController.navigationValues(model);
                Login login1=new Login();
                methodController.navigationValues(model);
                model.addAttribute("login",login1);
                return "login";
            }
        }
        else {
            methodController.navigationValues(model);
            Login login1=new Login();
            model.addAttribute("login",login1);
            return "login";
        }
    }
//=========Login Area End======//

//=========Profile Area Start======//
    @GetMapping("/profile")
    public String getProfile(Model model){
        Profile profile=new Profile();
        model.addAttribute(profile);
        return "profile";
    }
    @PostMapping("/postProfile")
    public String postProfile(Profile profile,Model model){
        if (temporaryHold.email.equals("default")){
            methodController.navigationValues(model);
            Login login=new Login();
            model.addAttribute(login);
            return "login";
        }
        else {
            methodController.navigationValues(model);
            return "profile";
        }

    }

    @PostMapping("/postEdit")
    public String postEdit(Profile profile,Model model){
        int updatep=profileRepository.updateByemail(temporaryHold.email,profile.name,profile.primarynumber,profile.secondarynumber,profile.address,profile.city,profile.country,profile.postalcode,profile.about);

        int updateU=userRepository.updateByemail(temporaryHold.email,profile.primarynumber,profile.address);
        methodController.navigationValues(model);
        return "profile";
    }

//=========Profile Area End======//

//=========Services Area Start======//
    @GetMapping("/services")
    public String getServices(Model model){
        List <Services> officialservicesList=new ArrayList<Services>();
        List <Services> sponsoredservicesList=new ArrayList<Services>();
        officialservicesList=servicesRepository.findByType("Official");
        sponsoredservicesList=servicesRepository.findByType("Sponsored");
        methodController.navigationValues(model);
        model.addAttribute("officialservicesList",officialservicesList);
        model.addAttribute("sponsoredservicesList",sponsoredservicesList);
        return "services";
    }
    @PostMapping("/postServices")
    public String postServices(Navigation navigation,Model model){
        List<SubService>subServiceList=new ArrayList<SubService>();
        System.out.println(navigation.flag+navigation.type);
        subServiceList=subServiceRepository.findByTypeNService(navigation.type,navigation.flag);
        methodController.navigationValues(model);
        model.addAttribute("subServiceList",subServiceList);
        return "sub_services";

    }
    @PostMapping("/postSubservice")
    public String postSubservice(Navigation navigation,Model model){
        List<SingleService>singleServiceList=new ArrayList<SingleService>();
        System.out.println(navigation.flag+navigation.type);
        singleServiceList=singleServiceRepository.findByTypeNSub(navigation.type,navigation.flag);
        methodController.navigationValues(model);
        model.addAttribute("singleServiceList",singleServiceList);
        return "single_services";
    }
    @PostMapping("/postSingleservice")
    public String postSingleservice(Navigation navigation,Model model){
        List<SingleService>singleServiceList=new ArrayList<SingleService>();
        List<SingleService>singleServicesimilar=new ArrayList<SingleService>();
        List<SingleService>similarservices=new ArrayList<SingleService>();
        System.out.println(navigation.flag+navigation.type);
        singleServiceList=singleServiceRepository.findBysid(navigation.flag);
        singleServicesimilar=singleServiceRepository.findBySub(singleServiceList.get(0).subservice);
        for (int k=0;k<singleServicesimilar.size();k++){
            if (k<4){
                similarservices.add(singleServicesimilar.get(k));
            }
            else {
                break;
            }
        }
        methodController.navigationValues(model);
        model.addAttribute("singleservice",singleServiceList.get(0));
        model.addAttribute("similarserviceList",similarservices);
        return "service_confirm";
    }
    @PostMapping("/postServiceconfirm")
    public String postServiceconfirm(Navigation navigation,Model model){
        temporaryHold.service=navigation.flag;
        if (temporaryHold.email.equals("default")){
            Login login=new Login();
            methodController.navigationValues(model);
            model.addAttribute(login);
            return "login";
        }
        else {
            User user=new User();
            List<User>userList=new ArrayList<User>();
            userList=userRepository.findByEmail(temporaryHold.email);
            List<SingleService>singleServices=new ArrayList<SingleService>();
            singleServices=singleServiceRepository.findBysid(navigation.flag);
            Deals deals=new Deals();
            deals.sid=navigation.flag;
            deals.email=userList.get(0).email;
            deals.name=userList.get(0).name;
            deals.number=userList.get(0).number;
            deals.address=userList.get(0).address;
            deals.status="Pending";
            dealsRepository.save(deals);
            List<Deals>dealsList=new ArrayList<Deals>();
            dealsList=dealsRepository.findByEmail(temporaryHold.email);
            List<Dummy>dummyList=new ArrayList<Dummy>();
            for (int i=0;i<dealsList.size();i++){
                Dummy dummy=new Dummy();
                singleServices=singleServiceRepository.findBysid(dealsList.get(i).sid);
                dummy.name=singleServices.get(0).name;
                dummy.description=singleServices.get(0).description;
                dummy.cost=singleServices.get(0).cost;
                dummy.imgB=singleServices.get(0).imgB;
                dummy.sid=dealsList.get(i).sid;
                dummy.status=dealsList.get(i).status;
                dummy.type=singleServices.get(0).type;
                dummy.address=dealsList.get(i).address;
                dummyList.add(dummy);
            }
            String cancel="cancel";
            String change="change";
            model.addAttribute("cancel",cancel);
            model.addAttribute("change",change);
            model.addAttribute("dealsList",dummyList);
            methodController.navigationValues(model);
            return "deals";
        }
    }
    @PostMapping("/postYourdeals")
    public String postYourdeals(Navigation navigation,Model model){
        List<SingleService>singleServices=new ArrayList<SingleService>();
        List<Deals>dealsList=new ArrayList<Deals>();
        dealsList=dealsRepository.findByEmail(temporaryHold.email);
        List<Dummy>dummyList=new ArrayList<Dummy>();
        for (int i=0;i<dealsList.size();i++){
            Dummy dummy=new Dummy();
            singleServices=singleServiceRepository.findBysid(dealsList.get(i).sid);
            dummy.name=singleServices.get(0).name;
            dummy.description=singleServices.get(0).description;
            dummy.cost=singleServices.get(0).cost;
            dummy.imgB=singleServices.get(0).imgB;
            dummy.sid=dealsList.get(i).sid;
            dummy.status=dealsList.get(i).status;
            dummy.type=singleServices.get(0).type;
            dummy.address=dealsList.get(i).address;
            dummyList.add(dummy);
        }
        String cancel="cancel";
        String change="change";
        model.addAttribute("cancel",cancel);
        model.addAttribute("change",change);
        model.addAttribute("dealsList",dummyList);
        methodController.navigationValues(model);
        return "deals";
    }

    @PostMapping("/postCanceldeal")
    public String postCanceldeal(Navigation navigation,Model model){
        if (navigation.type.equals("cancel")) {
            int f = dealsRepository.deleteByEmailNsid(temporaryHold.email, navigation.flag);
            List<SingleService> singleServices = new ArrayList<SingleService>();
            List<Deals> dealsList = new ArrayList<Deals>();
            dealsList = dealsRepository.findByEmail(temporaryHold.email);
            List<Dummy> dummyList = new ArrayList<Dummy>();
            for (int i = 0; i < dealsList.size(); i++) {
                Dummy dummy = new Dummy();
                singleServices = singleServiceRepository.findBysid(dealsList.get(i).sid);
                dummy.name = singleServices.get(0).name;
                dummy.description = singleServices.get(0).description;
                dummy.cost = singleServices.get(0).cost;
                dummy.imgB = singleServices.get(0).imgB;
                dummy.sid = dealsList.get(i).sid;
                dummy.status = dealsList.get(i).status;
                dummy.type = singleServices.get(0).type;
                dummy.address = dealsList.get(i).address;
                dummyList.add(dummy);
            }
            String cancel = "cancel";
            String change = "change";
            model.addAttribute("cancel", cancel);
            model.addAttribute("change", change);
            model.addAttribute("dealsList", dummyList);
            methodController.navigationValues(model);
            return "deals";
        }
        else {
            List<Deals> dealsList = new ArrayList<Deals>();
            dealsList = dealsRepository.findByEmailNsid(temporaryHold.email,navigation.flag);
            model.addAttribute("deal",dealsList.get(0));
            methodController.navigationValues(model);
            Updateinfo updateinfo=new Updateinfo();
            model.addAttribute(updateinfo);
            return "info";
        }
    }

    @PostMapping("/postInfo")
    public String postChangeaddress(Updateinfo updateinfo,Model model){
        int update=dealsRepository.setByAddressNnumber(temporaryHold.email,updateinfo.flag,updateinfo.number,updateinfo.address);
        List<SingleService> singleServices = new ArrayList<SingleService>();
        List<Deals> dealsList = new ArrayList<Deals>();
        dealsList = dealsRepository.findByEmail(temporaryHold.email);
        List<Dummy> dummyList = new ArrayList<Dummy>();
        for (int i = 0; i < dealsList.size(); i++) {
            Dummy dummy = new Dummy();
            singleServices = singleServiceRepository.findBysid(dealsList.get(i).sid);
            dummy.name = singleServices.get(0).name;
            dummy.description = singleServices.get(0).description;
            dummy.cost = singleServices.get(0).cost;
            dummy.imgB = singleServices.get(0).imgB;
            dummy.sid = dealsList.get(i).sid;
            dummy.status = dealsList.get(i).status;
            dummy.type = singleServices.get(0).type;
            dummy.address = dealsList.get(i).address;
            dummyList.add(dummy);
        }
        String cancel = "cancel";
        String change = "change";
        model.addAttribute("cancel", cancel);
        model.addAttribute("change", change);
        model.addAttribute("dealsList", dummyList);
        methodController.navigationValues(model);
        return "deals";
    }


//=========Services Area End======//


}
