package com.flexon.restAPIHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/all")
    public List<Customer> showCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping(path = "/find/{accountID}")
    public ResponseEntity findCustomer(@PathVariable long accountID){
        List <Customer> c = customerRepository.findByID(accountID);
        if (c.isEmpty()){
            return new ResponseEntity<>("Customer not found", HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @PostMapping(path ="/add")
    public ResponseEntity addNewCustomer(@RequestParam String firstName,
                                         @RequestParam String lastName,
                                         @RequestParam String email,
                                         @RequestParam long phone
                                       ){
        Customer c = new Customer();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(email);
        c.setPhone(phone);
        customerRepository.save(c);
        return new ResponseEntity<>("Customer created",HttpStatus.OK);

    }

    //Delete a customer
    @DeleteMapping(path = "/delete/{accountID}")
    public ResponseEntity deleteCustomer(@PathVariable long accountID){
        List <Customer> c = customerRepository.findByID(accountID);
        if (c.isEmpty()){
            return new ResponseEntity<>("Customer not found",HttpStatus.OK);
        }
        customerRepository.deleteById(accountID);
        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }
    @PutMapping(path = "update/{accountID}")
    public ResponseEntity updateCustomer( @PathVariable long accountID,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName,
                                          @RequestParam String email,
                                          @RequestParam long phone){

        List <Customer> customer = customerRepository.findByID(accountID);
        if (customer.isEmpty()){
            return new ResponseEntity<>("Customer not found", HttpStatus.OK);
        }
        Customer c = new Customer();
        c.setAccountID(accountID);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(email);
        c.setPhone(phone);
        customerRepository.save(c);
        return new ResponseEntity<>("Customer info updated", HttpStatus.OK);
    }



}
