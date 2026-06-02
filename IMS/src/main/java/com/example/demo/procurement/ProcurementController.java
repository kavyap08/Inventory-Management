package com.example.demo.procurement;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.parts.Parts;
import com.example.demo.parts.PartsService;
import com.example.demo.user.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProcurementController {

    @Autowired
    private PartsService partsservice;

    @Autowired
    private PrService prservice;

    @GetMapping("/generate-pr")
    public String generatePR(
            HttpServletRequest request,
            Model model) {

        User user = (User)
                request.getSession()
                        .getAttribute("sessionUser");

        if(user == null) {

            return "redirect:/login";
        }

        String sku =
                request.getParameter("sku");

        Parts part =
                partsservice.findBySku(sku);

        model.addAttribute("part", part);

        model.addAttribute("user", user);
        model.addAttribute("username",
                user.getUsername());
        model.addAttribute("role",
                user.getRole());

        return "generate-pr";
    }

    @PostMapping("/create-pr")
    public String createPR(
            HttpServletRequest request) {

        User user = (User)
                request.getSession()
                        .getAttribute("sessionUser");

        if(user == null) {

            return "redirect:/login";
        }

        String sku =
                request.getParameter("sku");

        Parts part =
                partsservice.findBySku(sku);

        Pr pr = new Pr();

        pr.setPart(part);

        pr.setCreatedBy(user);

        pr.setCurrentStock(
                part.getStock());

        pr.setThreshold(
                part.getThreshold());

        pr.setRequestedQty(
                100 - part.getStock());

        pr.setCreatedAt(
                LocalDateTime.now());

        pr.setStatus(
                Pr.PRStatus.OPEN);

        pr.setPrNumber(
                "PR-" +
                System.currentTimeMillis());

        prservice.save(pr);

        return "redirect:/pr-list";
    }

    @GetMapping("/pr-list")
    public String prList(
            HttpServletRequest request,
            Model model) {

        User user = (User)
                request.getSession()
                        .getAttribute("sessionUser");

        if(user == null) {

            return "redirect:/login";
        }

        List<Pr> prs =
                prservice.findAllPR();

        model.addAttribute("prs", prs);

        model.addAttribute("user", user);
        model.addAttribute("username",
                user.getUsername());
        model.addAttribute("role",
                user.getRole());

        return "pr-list";
    }
}