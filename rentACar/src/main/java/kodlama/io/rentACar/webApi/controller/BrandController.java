package kodlama.io.rentACar.webApi.controller;


import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.response.GetAllBrandResponse;
import kodlama.io.rentACar.entity.concrete.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }

}
