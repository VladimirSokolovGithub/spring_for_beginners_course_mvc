package spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@RequestMapping("/employee")
public class MyController3 {

    @RequestMapping("/")
    public String showFirstView3() {
        return "first-view3";
    }

    @RequestMapping("/askDetails3")
    public String askEmployeeDetails3(Model model) {

        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view3";
    }

//    @RequestMapping(path = "/showDetails3", method = RequestMethod.GET)

    //Вместо аннотации @RequestMapping мы можем использовать аннотацию @GetMapping,
    //которая делает всё тоже самое, но ограничена уже HTTP методом "get".
//    @GetMapping("/showDetails3")

    //Если мы хотим использовать метод "post", то мы должны пользоваться
    //аннотацией @PostMapping, которая предназначена для HTTP метода "post"
    @PostMapping("/showDetails3")
    public String showEmployeeDetails3(@Valid @ModelAttribute("employee") Employee emp
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view3";
        }
        else {
            return "show-emp-details-view3";
        }
    }

}


