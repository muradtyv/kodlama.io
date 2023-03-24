package kodlama.io.rentACar.business.concrete;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandResponse;
import kodlama.io.rentACar.business.request.UpdateBrandRequest;
import kodlama.io.rentACar.business.response.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.exception.BusinessException;
import kodlama.io.rentACar.core.utilities.mapper.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entity.concrete.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();


        List<GetAllBrandResponse> responsesList = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());

        return responsesList;
    }

    @Override
    public void add(CreateBrandRequest ceCreateBrandRequest) {
        this.brandBusinessRules.checkNameExists(ceCreateBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(ceCreateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
       Brand brand = brandRepository.findById(id).orElseThrow();
       GetByIdBrandResponse getByIdBrandResponse = this.modelMapperService.forResponse()
               .map(brand, GetByIdBrandResponse.class);
        return getByIdBrandResponse;
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}
