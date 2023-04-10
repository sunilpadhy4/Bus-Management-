package com.buscrud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buscrud.entity.bus;
import com.buscrud.repository.BusRepository;

@RestController
public class buscontroller {
	
	@Autowired
	  private BusRepository repository;
	

	 public BusRepository getRepository() {
		return repository;
	}

	public void setRepository(BusRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/test")
		public String Testbus()
		{
			return "hello etc";
		}
	 
	@GetMapping("/bus")
	  public List<bus> getAllbus() {
	    return repository.findAll();
	  }
	 
	  @PostMapping("/bussave")
	  bus createOrSavebus(@RequestBody bus newbus) {
	    return repository.save(newbus);
	  }
	 
	  @GetMapping("/bus/{id}")
	  bus getbusById(@PathVariable String id) {
	    return repository.findById(id).get();
	  }
	  
	  @PutMapping("/idbus/{id}")
	  bus updatebus(@RequestBody bus newbus , @PathVariable String id) {
		  
		  return repository.findById(id).map(bus -> {
//			  bus.setId(newbus.getId());
			  bus.setName(newbus.getName());
			  bus.setRoute(newbus.getRoute());
			  bus.setTrip(newbus.getRoute());
			  bus.setStarttime(newbus.getStarttime());
			  bus.setEndtime(newbus.getEndtime());
			  return repository.save(bus);
			  }).orElseGet(() -> {
				  newbus.setId(id);
				  return repository.save(newbus);
			  });
	  }
	  
	  @DeleteMapping("/delbus/{id}")
	  void deleteEmployee(@PathVariable String id) {
	    repository.deleteById(id);
	  }
	 
}
