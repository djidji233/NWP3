package rs.edu.raf.nwp.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.nwp.model.UserType;
import rs.edu.raf.nwp.services.UserTypeService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/usertypes")
public class UserTypeRestController {

    private final UserTypeService userTypeService;

    public UserTypeRestController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserType> getAllUserTypes(){ return userTypeService.findAll(); }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserTypeById(@RequestParam("userTypeId") Long id){
        Optional<UserType> optionalUserType = userTypeService.findById(id);
        if(optionalUserType.isPresent()) {
            return ResponseEntity.ok(optionalUserType.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserType createUserType(@RequestBody UserType type) {
        return userTypeService.save(type);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserType updateUserType(@RequestBody UserType type){
        return userTypeService.save(type);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUserType(@PathVariable("id") Long id){
        userTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
