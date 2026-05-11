package ma.khaoulabaadi.jeeexam.web;

import ma.khaoulabaadi.jeeexam.dtos.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerController {

    private InsuranceService insuranceService;

    @GetMapping("/customers")
    public List<CustomerDTO> customers() {
        return insuranceService.listCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) throws Exception {
        return insuranceService.getCustomer(id);
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO dto) {
        return insuranceService.saveCustomer(dto);
    }

    @PutMapping("/customers/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id,
                                      @RequestBody CustomerDTO dto) {
        dto.setId(id);
        return insuranceService.updateCustomer(dto);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        insuranceService.deleteCustomer(id);
    }
}
