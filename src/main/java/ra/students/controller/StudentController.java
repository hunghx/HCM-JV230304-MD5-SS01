package ra.students.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.students.model.dto.req.StudentCreateDto;
import ra.students.service.IStudentService;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public String list(Model model){
        model.addAttribute("list",studentService.findAll());
        return "student/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("studentAdd", new StudentCreateDto() );
        return "student/add";
    }
    @PostMapping("/add")
    public String doAdd(@Valid @ModelAttribute("studentAdd") StudentCreateDto request, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("studentAdd",request);
            return "student/add";
        }
        studentService.add(request);
        return "redirect:/";
    }

}
