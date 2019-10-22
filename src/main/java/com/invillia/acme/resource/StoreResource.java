package com.invillia.acme.resource;

import com.invillia.acme.dto.StoreDTO;
import com.invillia.acme.service.StroreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("stores")
public class StoreResource {

    @Autowired
    private StroreServiceImpl storeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StoreDTO> getStores(){
        return storeService.getStores();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StoreDTO getStore(@PathVariable("id") Long id){
        return storeService.getStore(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public StoreDTO getStoreByName(@PathVariable("name") String name){
        return storeService.getStoreByName(name);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStore(@RequestBody StoreDTO store ){
        storeService.saveStore(store);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateStore(@RequestBody StoreDTO store){
        storeService.updateStore(store);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStore(@PathParam("id") Long id){
        storeService.deleteStore(id);
    }
}
