package spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController2 {

    @RequestMapping("/")
    public String showFirstView2() {
        return "first-view2";
    }

    @RequestMapping("/askDetails2")
    public String askEmployeeDetails2(Model model) {

//1-й момент
//        Employee emp = new Employee();
//        emp.setName("Artem");
//        emp.setSurname("Sokolov");
//        emp.setSalary(500);
//        model.addAttribute("employee", emp);

        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view2";
    }

    @RequestMapping("/showDetails2")
    public String showEmployeeDetails2(@ModelAttribute("employee") Employee emp) {

        //2-й момент
        //в методе showEmployeeDetails2 с помощью аннотации @ModelAttribute("employee"),
        // связываем атрибут модели по имени employee с параметром метода Employee emp и
        // можем работать с полями этого атрибута т.е. изменять их как хотим.
        // Например:
        String name = emp.getName();
        emp.setName("Mr " + name);

        String surname = emp.getSurname();
        emp.setSurname(surname + "!");

        int salary = emp.getSalary();
        emp.setSalary(salary*10);

         return "show-emp-details-view2";
    }

}


