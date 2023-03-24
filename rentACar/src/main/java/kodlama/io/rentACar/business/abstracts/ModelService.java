package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.request.CreateModelRequest;
import kodlama.io.rentACar.business.response.GetAllModelsResponse;

import java.util.List;

public interface ModelService {

    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);
}
