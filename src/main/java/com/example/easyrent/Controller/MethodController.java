package com.example.easyrent.Controller;

import com.example.easyrent.Model.Navigation;
import com.example.easyrent.Model.Profile;
import com.example.easyrent.Model.TemporaryHold;
import com.example.easyrent.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MethodController {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    TemporaryHold temporaryHold;

    public void navigationValues(Model model){
        Navigation navigation=new Navigation();
        model.addAttribute("navigation",navigation);
        List<Profile>profileList=new ArrayList<Profile>();
        profileList=profileRepository.findByEmail(temporaryHold.email);
        Profile profile1=new Profile();
        profileList.add(profile1);
        if (profileList.size()>1){
            model.addAttribute("profile",profileList.get(0));
            System.out.println(profileList.get(0).getName());
        }
        //-------Transports-------//
        String cars="Cars";
        model.addAttribute("cars",cars);
        String bikes="Bikes";
        model.addAttribute("bikes",bikes);
        String buses="Buses";
        model.addAttribute("buses",buses);
        String bicycle="Bicycle";
        model.addAttribute("bicycle",bicycle);
        String boats="Boats";
        model.addAttribute("boats",boats);
        String planes="Planes";
        model.addAttribute("planes",planes);
        String trucks="Trucks";
        model.addAttribute("trucks",trucks);
        //------Transports end-----//

        //-------Properties-------//
        String appartment="Appartment";
        model.addAttribute("appartment",appartment);
        String commercial="Commercial";
        model.addAttribute("commercial",commercial);
        String house="House";
        model.addAttribute("house",house);
        String officespace="Officespace";
        model.addAttribute("officespace",officespace);
        String factory="Factory";
        model.addAttribute("factory",factory);
        String warehouse="Warehouse";
        model.addAttribute("warehouse",warehouse);
        //------properties end-----//

        //-------Heavy Equipment-------//
        String excavator="Excavator";
        model.addAttribute("excavator",excavator);
        String crane="Crane";
        model.addAttribute("crane",crane);
        String roadroller="Roadroller";
        model.addAttribute("roadroller",roadroller);
        String bulldozer="Bulldozer";
        model.addAttribute("bulldozer",bulldozer);
        String weldingmachine="Weldingmachine";
        model.addAttribute("weldingmachine",weldingmachine);
        //------Heavy Equipment end-----//

        //-------Office Equipment-------//
        String ac="AC";
        model.addAttribute("ac",ac);
        String projector="Projector";
        model.addAttribute("projector",projector);
        String printer="Printer";
        model.addAttribute("printer",printer);
        String scanner="Scanner";
        model.addAttribute("scanner",scanner);
        String laminator="Laminator";
        model.addAttribute("laminator",laminator);
        //------Office Equipment end-----//

        //-------Event Equipment-------//
        String accommodation="Accommodation";
        model.addAttribute("accommodation",accommodation);
        String catering="Catering";
        model.addAttribute("catering",catering);
        String livecast="Livecast";
        model.addAttribute("livecast",livecast);
        String sound="Sound";
        model.addAttribute("sound",sound);
        String stage="Stage";
        model.addAttribute("stage",stage);
        String chairandtable="ChairandTable";
        model.addAttribute("chairandtable",chairandtable);
        //------Event Equipment end-----//

        //-------Home Appliances-------//
        String electricdevices="ElectricDevices";
        model.addAttribute("electricdevices",electricdevices);
        String gasstove="GasStove";
        model.addAttribute("gasstove",gasstove);
        String cleaner="Cleaner";
        model.addAttribute("cleaner",cleaner);
        String cooker="Cooker";
        model.addAttribute("cooker",cooker);
        String acH="AC";
        model.addAttribute("ac",acH);
        String clothdryer="ClothDryer";
        model.addAttribute("clothdryer",clothdryer);
        //------Event Equipment end-----//

    }
}
