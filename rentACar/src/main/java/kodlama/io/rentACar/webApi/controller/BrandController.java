package kodlama.io.rentACar.webApi.controller;


import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandResponse;
import kodlama.io.rentACar.entity.concrete.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public GetAllBrandResponse getBrandById(@PathVariable int id){
       Brand brand =  brandService.getById(id);
       GetAllBrandResponse getAllBrandResponse = new GetAllBrandResponse();
       getAllBrandResponse.setName(brand.getName());
        return getAllBrandResponse;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
        brandService.add(createBrandRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody CreateBrandRequest createBrandRequest){
        brandService.update(id,createBrandRequest);
    }



}
