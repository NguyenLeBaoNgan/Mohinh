package com.example.Mohinh.controller;

import com.example.Mohinh.entities.NSX;
import com.example.Mohinh.entities.Product;
import com.example.Mohinh.entities.TheLoai;
import com.example.Mohinh.service.GiamGiaService;
import com.example.Mohinh.service.NSXService;
import com.example.Mohinh.service.ProductService;
import com.example.Mohinh.service.TheLoaiService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private TheLoaiService theLoaiService;
    @Autowired
    private GiamGiaService giamGiaService;
    @Autowired
    private NSXService nsxService;

    @GetMapping("/view")
    public String viewProduct(Model model){
//        List<Product> productList = productService.getAll();
//        model.addAttribute("productList", productList);
//
        return findPaginated(1, model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model){
        int pageSize=12;
        Page<Product> page = productService.findPaginated(pageNo, pageSize);
        List<Product> productList = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("productList", productList);
        List<TheLoai> theLoaiList = theLoaiService.getAllTL();
        model.addAttribute("theLoaiList",theLoaiList);
        return "index";
    }



    @GetMapping("/add")
    public String addProduct( Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        model.addAttribute("theloai", theLoaiService.getAllTL());
        model.addAttribute("giamgia", giamGiaService.getAllGiamgia());
        model.addAttribute("nsx", nsxService.getAllNSX());
        return "addproduct";
    }
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, Model model, Long idgiamgia, Long idtheloai,Long idnsx) {

        productService.addProduct(product,idgiamgia,idtheloai,idnsx);

        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        return "product-list";
    }

    @GetMapping("/edit/{idsp}")
    public String editProduct(@PathVariable("idsp") long idsp, Model model, Long idgiamgia, Long idtheloai,Long idnsx) {
        Product product = productService.getProductId(idsp);
        model.addAttribute("product", product);
        model.addAttribute("theloai", theLoaiService.getAllTL());
        model.addAttribute("giamgia", giamGiaService.getAllGiamgia());
        model.addAttribute("nsx", nsxService.getAllNSX());
        return "editproduct";
    }

    @PostMapping("/update/{idsp}")
    public String updateProduct(@PathVariable("idsp") long idsp, @ModelAttribute("product") @Validated Product product,
                                BindingResult result, Model model, Long idgiamgia, Long idtheloai,Long idnsx) {
        if (result.hasErrors()) {
            product.setIdsp(idsp);
            return "editproduct";
        }
        productService.updateProduct(product,idgiamgia,idtheloai,idnsx);
        return "redirect:/product/list";

    }

    @GetMapping("/delete/{idsp}")
    public String delete(@PathVariable("idsp") Long idsp, Model model) {
        productService.removeProduct(idsp);
        return "redirect:/product/list";
    }


    @GetMapping("/productbyidtl/{idtheloai}")
    public String loctheloai(@PathVariable("idtheloai") Long idtheloai, Model model) {
        List<Product> productList = productService.getProductByTheloai(idtheloai);
        model.addAttribute("productList", productList);
        return "pccomponent";
    }

    @GetMapping("/search")
    public String searchProduct(
            @NotNull Model model,
            @RequestParam String keyword) {
        model.addAttribute("productList", productService.searchProduct(keyword));
//        model.addAttribute("keyword", keyword);
//        model.addAttribute("theloai", theLoaiService.getAllTL());
        return "gaminggear";
    }

    @GetMapping("/chitiet/{idsp}")
    public String chitietProduct(@PathVariable("idsp") Long idsp, Model model) {
        Product product= productService.getProductId(idsp);
        model.addAttribute("product",product);

        return "chitiet";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("productList", productService.getAll());
        return "product-list";
    }

    //
    @GetMapping("/addTL")
    public String addTL( Model model){
        TheLoai theLoai=new TheLoai();
        model.addAttribute("theloai",theLoai);

        return "addTL";
    }
    @PostMapping("/addTL")
    public String addTL(@ModelAttribute("theloai") TheLoai theLoai, Model model) {

        theLoaiService.saveTheLoai(theLoai);

        return "redirect:/product/listdanhmuc";
    }
    @GetMapping("/listdanhmuc")
    public String viewlistDM(Model model){
        model.addAttribute("theloaiList", theLoaiService.getAllTL());
        return "danhmuclist";
    }


    @GetMapping("/editTL/{idtheloai}")
    public String editTL(@PathVariable("idtheloai") long idtheloai, Model model) {
        TheLoai theLoai = theLoaiService.getTheLoaiById(idtheloai);
        model.addAttribute("theloai", theLoai);
//        model.addAttribute("theloai", theLoaiService.getAllTL());
        return "editTL";
    }

    @PostMapping("/updateTL/{idtheloai}")
    public String updateTL(@PathVariable("idtheloai") long idtheloai, @ModelAttribute("theloai") @Validated TheLoai theLoai,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            theLoai.setIdtheloai(idtheloai);
            return "editTL";
        }
        theLoaiService.saveTheLoai(theLoai);
        return "redirect:/product/listdanhmuc";

    }

    @GetMapping("/deleteTL/{idtheloai}")
    public String deleteTL(@PathVariable("idtheloai") Long idtheloai, Model model) {
        theLoaiService.deteleTheLoai(idtheloai);
        return "redirect:/product/listdanhmuc";
    }


    //

    @GetMapping("/addNSX")
    public String addNSX( Model model){
        NSX nsx=new NSX();
        model.addAttribute("NSX",nsx);
        return "addNSX";
    }
    @PostMapping("/addNSX")
    public String addNSX(@ModelAttribute("NSX")  NSX nsx, Model model) {

        nsxService.saveNSX(nsx);

        return "redirect:/product/listnsx";
    }
    @GetMapping("/listnsx")
    public String viewlistnsx(Model model){
        model.addAttribute("nsxList", nsxService.getAllNSX());
        return "nsxlist";
    }

    @GetMapping("/editNSX/{idnsx}")
    public String editNSX(@PathVariable("idnsx") long idnsx, Model model) {
        NSX nsx = nsxService.getNSXById(idnsx);
        model.addAttribute("nsx", nsx);
//        model.addAttribute("theloai", theLoaiService.getAllTL());
        return "editNSX";
    }

    @PostMapping("/updateNSX/{idnsx}")
    public String updateNSX(@PathVariable("idnsx") long idnsx, @ModelAttribute("nsx") @Validated NSX nsx,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            nsx.setIdnsx(idnsx);
            return "editNSX";
        }
        nsxService.saveNSX(nsx);
        return "redirect:/product/listnsx";

    }

    @GetMapping("/deleteNSX/{idnsx}")
    public String deleteNSX(@PathVariable("idnsx") Long idnsx, Model model) {
        nsxService.deteleNSX(idnsx);
        return "redirect:/product/listnsx";
    }

}
