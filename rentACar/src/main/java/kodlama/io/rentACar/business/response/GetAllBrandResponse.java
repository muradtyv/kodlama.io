package kodlama.io.rentACar.business.response;


import kodlama.io.rentACar.entity.concrete.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandResponse {

    private int id;
    private String name;

//    public GetAllBrandResponse(Brand brand) {
//        brand.getId() = id;
//        brand.getName() = name;
//    }
}
