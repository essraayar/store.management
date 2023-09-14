package com.innova.store.management.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.innova.store.management.model.City;
import com.innova.store.management.model.District;
import com.innova.store.management.model.StoreEntity;
import com.innova.store.management.model.dto.StoreRequest;
import com.innova.store.management.repository.StoreRepository;
import com.innova.store.management.service.CityService;
import com.innova.store.management.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/store")
@CrossOrigin("http://localhost:8080/")
public class StoreController {

    /*@GetMapping("/name")
    public ResponseEntity<String> getStores(){
        return ResponseEntity.status(HttpStatus.OK).body("Esra");
    }*/

     @Autowired
     StoreRepository storeRepository;
     @Autowired
     private CityService cityService;

     @Autowired
     private DistrictService districtService;

     @GetMapping("/get-all-stores")
    public List<StoreEntity> getAllStore () {
     List<StoreEntity> allStorelist = storeRepository.findAll();
     return allStorelist;
    }

    @PostMapping("/create-stores")
    public StoreEntity createStore(@RequestBody StoreRequest storeRequest) {
        City city = cityService.findCityByName(storeRequest.getCity()) != null ?
                cityService.findCityByName(storeRequest.getCity()) :
                new City(storeRequest.getCity());

        District district = districtService.findByNameAndCity(storeRequest.getDistrict(),storeRequest.getCity())!=null?
                districtService.findByNameAndCity(storeRequest.getDistrict(),storeRequest.getCity()):
                new District(storeRequest.getDistrict(),city);
        StoreEntity store = new StoreEntity(storeRequest.getStore_type(),
                city,
                district,
                storeRequest.getStore_name());
        StoreEntity savedStore = storeRepository.save(store);

        return savedStore;
    }

    @PutMapping("/update-stores/{id}")
    public ResponseEntity<StoreEntity> updateEmployee(@PathVariable(value = "id") Long storeId,@RequestBody StoreEntity storeDetails) {
        StoreEntity store = storeRepository.findById(storeId).get();
        store.setStore_type(storeDetails.getStore_type());
        store.setCity(storeDetails.getCity());
        store.setDistrict(storeDetails.getDistrict());
        store.setStore_name(storeDetails.getStore_name());
        final StoreEntity updatedStore = storeRepository.save(store);
        return ResponseEntity.ok(updatedStore);
    }

    @DeleteMapping("/delete-stores/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long storeId)
    {
        StoreEntity store = storeRepository.findById(storeId).get();
        storeRepository.delete(store);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }






}
