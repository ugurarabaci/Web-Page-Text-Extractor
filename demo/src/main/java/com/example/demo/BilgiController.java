package com.example.demo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class BilgiController {

    /*Bilgi bilgi= new Bilgi();

    @RequestMapping("/string")
    @ResponseBody
    String home(String result) {


        return bilgi.getResult();
    }

    public FirstService() throws IOException {
    }
    */

    @GetMapping("/register")
    public String showForm(Model model) throws IOException {
        BilgiCek bilgiCek = new BilgiCek();
        model.addAttribute("bilgiCek", bilgiCek);
        return "index.html";
    }


    @PostMapping("/register")
    public String submitForm(@ModelAttribute("bilgiCek") BilgiCek bilgiCek) throws IOException {
        String page= bilgiCek.getPage();
        Connection conn = Jsoup.connect(page);
        Document doc = conn.get();
        bilgiCek.setResult(doc.body().text());
        return "indexok.html";
    }


}