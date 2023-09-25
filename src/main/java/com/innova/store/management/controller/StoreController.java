package com.innova.store.management.controller;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import com.innova.store.management.model.City;
import com.innova.store.management.model.District;
import com.innova.store.management.model.StoreEntity;
import com.innova.store.management.model.dto.StoreDto;
import com.innova.store.management.repository.StoreRepository;
import com.innova.store.management.service.CityService;
import com.innova.store.management.service.DistrictService;
import com.innova.store.management.service.ReportService;
import com.innova.store.management.service.StoreService;
import jakarta.annotation.Nullable;
import net.sf.jasperreports.engine.JRException;
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

     @Autowired
     private StoreService storeService;

     @Autowired
     private ReportService reportService;

     @GetMapping("/get-all-stores")
    public ResponseEntity<List<StoreEntity>> getAllStore () {
         List<StoreEntity> allStorelist = storeRepository.findAll();
         return ResponseEntity.ok(allStorelist);
     }

     @GetMapping("/get-stores")
     public ResponseEntity<List<StoreDto>> getStores (@Nullable @RequestParam("city")String city, @RequestParam("district") String district) {
         Map<String,Object> parameters = reportService.generateParams(city,district);
         List<StoreEntity> allStorelist = new ArrayList<>();
         if(!"null".equals(city)&&!"null".equals(district)) {
             allStorelist = storeRepository.findByCityAndDistrict(city, district);
         }
         else if(!"null".equals(city)){
             allStorelist = storeRepository.findByCity(city);
         }
         else{
             allStorelist = storeRepository.findAll();
         }
         List<StoreDto> allStorelistDto = allStorelist.stream().map(i->{
         StoreDto storeDto = new StoreDto();
         storeDto.setStore_name(i.getStore_name());
         storeDto.setStore_type(i.getStore_type());
         storeDto.setCity(i.getCity().getName());
         storeDto.setDistrict(i.getDistrict().getName());
         storeDto.setStore_link(i.getStore_link());
         return storeDto;
     }).collect(Collectors.toList());
         try {
             String pdf = reportService.exportReport("pdf",allStorelistDto,parameters);
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         } catch (JRException e) {
             throw new RuntimeException(e);
         }

     return  ResponseEntity.ok(allStorelistDto);
    }

    @PostMapping("/create-stores")
    public StoreEntity createStore(@RequestBody StoreDto storeRequest) {
         if(storeRequest==null)
             return null;
        City city = cityService.findCityByName(storeRequest.getCity()) != null ?
                cityService.findCityByName(storeRequest.getCity()) :
                new City(storeRequest.getCity());

        District district = districtService.findByNameAndCity(storeRequest.getDistrict(),storeRequest.getCity())!=null?
                districtService.findByNameAndCity(storeRequest.getDistrict(),storeRequest.getCity()):
                new District(storeRequest.getDistrict(),city);
        StoreEntity store = new StoreEntity(storeRequest.getStore_type(),
                city,
                district,
                storeRequest.getStore_name(),
                storeRequest.getStore_link());
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
