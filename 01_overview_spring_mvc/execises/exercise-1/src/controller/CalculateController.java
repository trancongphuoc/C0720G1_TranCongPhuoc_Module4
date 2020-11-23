package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ReverseMoney;

@Controller
public class CalculateController {

    @Autowired
    ReverseMoney reverseMoney;

    @GetMapping("/calculate")
    public String calculate(@RequestParam String type,
                            @RequestParam String money,
                            Model model) {

        try {
            if (type.equals("vnd")) {
                model.addAttribute("result",reverseMoney.vndToUSD(Double.parseDouble(money)));
            } else {
                model.addAttribute("result",reverseMoney.usdToVND(Double.parseDouble(money)));
            }
        } catch (NumberFormatException e) {
            model.addAttribute("message","error");
        }

        return "app/result";
    }

}
