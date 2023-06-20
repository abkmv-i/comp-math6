package com.lab6spring;


import com.lab6spring.Charts.UploadChart;
import com.lab6spring.Methods.EulerMethod;
import com.lab6spring.Methods.MilanaMethod;
import com.lab6spring.Methods.RungeMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class IOData {

    @GetMapping("/")
    public String welcomePage() {
        return "welcomePage";
    }

    @GetMapping("/data")
    public String input(Model model) {
        model.addAttribute("form", new Form());
        return "index";
    }


    @GetMapping("/file")
    public String file(Model model) {
        model.addAttribute("file", new File());
        return "file";
    }

    @GetMapping("/resultPage")
    public String outTable(@ModelAttribute Form form, Model model) {
        EulerMethod eulerMethod = new EulerMethod();
        RungeMethod rungeMethod = new RungeMethod();
        MilanaMethod milanaMethod = new MilanaMethod();
        int n = (int) (Math.abs(form.getB() - form.getA()) / form.getH()) + 1;

        if (form.getMethod() == 1) {
            double[][] result = eulerMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(),
                    form.getNumberOfFunction(), form.getH());
            UploadChart.result = result;
            model.addAttribute("result", result);
        } else if (form.getMethod() == 2) {
            double[][] result = eulerMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(),
                    form.getNumberOfFunction(), form.getE());
            model.addAttribute("result", result);
            UploadChart.result = result;
        } else if (form.getMethod() == 3) {
            double[][] result = milanaMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(),
                    form.getNumberOfFunction(), form.getE());
            UploadChart.result = result;
            model.addAttribute("result", result);
        }
        UploadChart.numberOfFunction = form.getNumberOfFunction();

        return "result";
    }

    @GetMapping("/resultFiles")
    public String outFileTable(@ModelAttribute File file, Model model) throws IOException {
        Form form = getDataFromFile(file.getFileName(), file.getMethod(), file.getNumberOfFunction());
        EulerMethod eulerMethod = new EulerMethod();
        RungeMethod rungeMethod = new RungeMethod();
        MilanaMethod milanaMethod = new MilanaMethod();
        int n = (int) (Math.abs(form.getB() - form.getA()) / form.getH()) + 1;

        if (form.getMethod() == 1) {
            double[][] result = eulerMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(),
                    form.getNumberOfFunction(), form.getH());
            UploadChart.result = result;
            model.addAttribute("result", result);
        } else if (form.getMethod() == 2) {
            double[][] result = eulerMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(),
                    form.getNumberOfFunction(), form.getE());
            model.addAttribute("result", result);
            UploadChart.result = result;
        } else if (form.getMethod() == 3) {
            double[][] result = milanaMethod.method(form.getA(), form.getB(), form.getY0(), form.getH(),
                    form.getNumberOfFunction(), form.getE());
            UploadChart.result = result;
            model.addAttribute("result", result);
        }
        UploadChart.numberOfFunction = form.getNumberOfFunction();
        return "result";
    }

    private Form getDataFromFile(String filePath, int method, int numberOfFunction) throws IOException {
        try {
            double a, b, y0, h, e;
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/irinaabakumova/" + filePath)));
            String[] data = reader.readLine().split(" ");
            if (!isNumber(data[0])) throw new NumberFormatException("Не верное значениe");
            else a = Double.parseDouble(data[0]);
            if (!isNumber(data[1])) throw new NumberFormatException("Не верное значениe");
            else b = Double.parseDouble(data[1]);
            if (!isNumber(data[2])) throw new NumberFormatException("Не верное значениe");
            else h = Double.parseDouble(data[2]);
            if (!isNumber(data[3])) throw new NumberFormatException("Не верное значениe");
            else y0 = Double.parseDouble(data[3]);
            if (!isNumber(data[4])) throw new NumberFormatException("Не верное значениe");
            else e = Double.parseDouble(data[4]);

            return new Form(method, numberOfFunction, a, b, h, y0, e);


        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
