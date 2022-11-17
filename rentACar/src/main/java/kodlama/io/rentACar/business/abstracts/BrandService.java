package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.response.GetAllBrandResponse;
import kodlama.io.rentACar.entity.concrete.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {

    List<GetAllBrandResponse> getAll();
}
