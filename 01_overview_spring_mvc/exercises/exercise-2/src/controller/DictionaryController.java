package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;

@Controller
public class DictionaryController {


    @Autowired
    DictionaryService dictionaryService;


    @GetMapping("/dictionary")
    public String show(@RequestParam String keyWord, Model model) {

        if (dictionaryService.search(keyWord) == null) {
            model.addAttribute("message", "Not Find");
        } else {
            model.addAttribute("dictionary", dictionaryService.search(keyWord));
        }



        return "search";
    }
}
