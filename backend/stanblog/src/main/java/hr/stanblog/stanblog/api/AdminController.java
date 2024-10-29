package hr.stanblog.stanblog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.stanblog.stanblog.dto.AdminDto;
import hr.stanblog.stanblog.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody AdminDto adminDto){
        adminService.authentificateAdmin(adminDto);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
