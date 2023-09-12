package com.innova.store.management.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.innova.store.management.model.StoreEntity;
import com.innova.store.management.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/store")
public class StoreController {

    /*@GetMapping("/name")
    public ResponseEntity<String> getStores(){
        return ResponseEntity.status(HttpStatus.OK).body("Esra");
    }*/

     @Autowired
     StoreRepository storeRepository;

     @GetMapping("/get-all-stores")
    public List<StoreEntity> getAllStore () {
     List<StoreEntity> allStorelist = storeRepository.findAll();
     return allStorelist;
    }

    @PostMapping("/create-stores")
    public StoreEntity createStore(@RequestBody StoreEntity store) {
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
