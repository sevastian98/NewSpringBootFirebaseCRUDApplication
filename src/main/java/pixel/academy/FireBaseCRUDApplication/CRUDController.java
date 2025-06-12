package pixel.academy.FireBaseCRUDApplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.IntrospectionException;
import java.util.concurrent.ExecutionException;

@RestController
public class CRUDController {

    public CRUDService crudService;

    public CRUDController(CRUDService crudService) {
        this.crudService = crudService;
    }

    @PostMapping("/create")
    public String createCRUD(@RequestBody CRUD crud) throws IntrospectionException, ExecutionException, InterruptedException {
        return crudService.createCRUD(crud);
    }

    @GetMapping("/get")
    public CRUD getCRUD(@RequestParam String documentID) throws IntrospectionException, ExecutionException, InterruptedException {
        return crudService.getCRUD(documentID);
    }
    @PutMapping("/update")
    public String updateCRUD(@RequestBody CRUD crud) throws IntrospectionException, ExecutionException, InterruptedException {
        return crudService.updateCRUD(crud);
    }
    @PutMapping("/delete")
    public String deleteCRUD(@RequestParam CRUD documentID) throws IntrospectionException, ExecutionException {
        return crudService.deleteCRUD(String.valueOf(documentID));
    }

    @GetMapping("/test")
    public ResponseEntity<String> thestGetEndpoint(){
        return ResponseEntity.ok("Test Get Endpoint is Working");
    }


}
