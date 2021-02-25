package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

    // handles requests at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }

    // handles requests at /goodbye
    //now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return  "Goodbye, Spring";
    }

    //dynamic response
    //handles request of the form/hello/?name=LaunchCode
    // ex) localhost:8080/hello?name=jim
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
        String properGreeting = HelloController.createMessage(name, language);
        return properGreeting;
    }

    //handles request of the form /hello/launchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello " + name + "!";
    }

    //hello/form
    @GetMapping ("form")
    public String helloForm(){
        /*

         */
       return "<html>" +
               "<body>" +
               "<form action='hello' method='post'>" +//submit a request to /hello
               "<input type='text' name='name'>" +
               "<select name= 'language'>" +
                   "<option value='English'>English</option>" +
                   "<option value='Spanish'>Spanish</option>" +
                   "<option value='French'>French</option>" +
                   "<option value='Italian'>Italian</option>" +
                   "<option value='German'>German</option>" +
               "</select>" +
               "<input type='submit' value='greet me!'>" +
               "</form>" +
               "</body>" +
               "</html>";
    }
    public static String createMessage(String name, String language){
        switch(language){
            case "Spanish":
                return "Hola, "+name;
            case "French":
                return "Bonjour, "+name;
            case "Italian":
                return "Ciao, "+name;
            case "German":
                return "Hallo, "+name;
            case "English":
            default:
                return "Hello, " + name;


        }
    }
}
