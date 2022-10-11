package spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


//Аннотация @Controller - это специальный компонент с помощью, которого
//наш контроллер будет найден при сканировании Spring-ом нашего пакета.
//Внутри контроллера создадим метод с помощью которого и будет происходить вызов нашего view.
//Метод будет возвращать String - имя нашего view и благодаря конфигурации, которую мы прописывали
//в applicationContext.xml к имени нашего view в начало будет добавлена информация в каком пакете
//находится наш view - prefix и в конец будет добавлено расширение файла нашего view -.jsp - это suffix.
//Наш метод должен срабатывать, когда мы вводим в браузер просто слэш - /. Это прописывается с помощью
//аннотации @RequestMapping("/"). В параметрах аннотации, в двойных ковычках мы пишем при каком адресе
//должен сработать наш метод, и отобразить наш view, в нашем случае это слэш/.

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }


    //метод для урока Les_4

//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails() {
//        return "show-emp-details-view";
//    }


    //метод для урока Les_5

//    @RequestMapping("/showDetails")
//    public String showEmployeeDetails(HttpServletRequest request, Model model) {
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("discription", " - java instructor");
//
//        return "show-emp-details-view";
//    }


    //метод для урока Les_6

    @RequestMapping("/showDetails")
    public String showEmployeeDetails(@RequestParam("employeeName") String empName, Model model) {

        empName = "Mr. " + empName + "!";
        model.addAttribute("nameAttribute", empName);

        return "show-emp-details-view";
    }

}


