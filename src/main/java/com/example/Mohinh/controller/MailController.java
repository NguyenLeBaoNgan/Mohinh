package com.example.Mohinh.controller;

import com.example.Mohinh.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    private JavaMailSender mailSender;


    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

//    @GetMapping("/mail")
//    public String showMail(@RequestParam("total") double total, Model model) {
//        model.addAttribute("total", total);
//        return "form_mail";
//    }

//    @PostMapping("/send")
    @GetMapping("/mail")
    public String senMail(@RequestParam("total") double total)
                          {
//        if (action.equals("textmail")) {
            SimpleMailMessage mailMessage= new SimpleMailMessage();
            mailMessage.setTo("dinhnguyen1812002@gmail.com");
            mailMessage.setSubject("thong bao mua hang");
            mailMessage.setText(String.valueOf(total));
            javaMailSender.send(mailMessage);
            return "success";
//        }else if(action.equals("htmlmail")){
//            try {
//                String htmlContent = "<h1>Đây Là HTML Mail</h1><p>" + String.valueOf(total) + "</p>";
//                emailService.sendHtmlEmail("knkeniki@gmail.com", "thong bao mua hang", htmlContent);
//                return "success"; // Điều hướng đến trang thành công sau khi gửi email
//            } catch (MessagingException e) {
//                // Xử lý lỗi nếu gửi email thất bại
//                return "error";
//            }
        }
//        return "error";

    }





