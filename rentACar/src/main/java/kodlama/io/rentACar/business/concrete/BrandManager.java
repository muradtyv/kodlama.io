package kodlama.io.rentACar.business.concrete;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entity.concrete.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


        for(Brand brand: brands){
            GetAllBrandResponse getAllBrandResponse = new GetAllBrandResponse();
            getAllBrandResponse.setId(brand.getId() );
            getAllBrandResponse.setName(brand.getName());
            responseList.add(getAllBrandResponse);
        }
        return responseList;
    }

    @Override
    public void add(CreateBrandRequest ceCreateBrandRequest) {

        Brand brand = new Brand();
        brand.setName(ceCreateBrandRequest.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(int id, CreateBrandRequest updateBrandRequest) {
        Brand brand = getById(id);
        brand.setName(updateBrandRequest.getName());
        brandRepository.save(brand);
    }

    @Override
    public Brand getById(int id) {

       Optional<Brand> brandOptional = brandRepository.findById(id);

      Brand brand =  brandOptional.stream().filter(item -> item.getId() == id)
               .findFirst().get();
        return brand;
    }
}
