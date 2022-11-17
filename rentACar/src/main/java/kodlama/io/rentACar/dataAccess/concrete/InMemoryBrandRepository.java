//package kodlama.io.rentACar.dataAccess.concrete;
//
//import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
//import kodlama.io.rentACar.entity.concrete.Brand;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class InMemoryBrandRepository implements BrandRepository {
//
//    List<Brand> brands;
//
//    public InMemoryBrandRepository() {
//        brands = new ArrayList<Brand>();
//        brands.add(new Brand(1,"BMW"));
//        brands.add(new Brand(2,"Mercedes"));
//        brands.add(new Brand(3,"Audi"));
//        brands.add(new Brand(4,"Renault"));
//    }
//
//    @Override
//    public List<Brand> getAll() {
//        return brands;
//    }
//}
