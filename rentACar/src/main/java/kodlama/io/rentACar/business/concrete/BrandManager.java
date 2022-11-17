package kodlama.io.rentACar.business.concrete;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.response.GetAllBrandResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entity.concrete.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> responseList = new ArrayList<>();

        GetAllBrandResponse getAllBrandResponse = new GetAllBrandResponse();

        for(Brand brand: brands){
            getAllBrandResponse.setId(brand.getId());
            getAllBrandResponse.setName(brand.getName());
            responseList.add(getAllBrandResponse);
        }
        return responseList;
    }
}
