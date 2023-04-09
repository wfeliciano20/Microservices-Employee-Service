package com.williamfeliciano.employeeservice.service.Impl;

import com.williamfeliciano.employeeservice.Exception.EmailAlreadyExistException;
import com.williamfeliciano.employeeservice.dto.APIResponseDto;
import com.williamfeliciano.employeeservice.dto.DeparmentDto;
import com.williamfeliciano.employeeservice.dto.EmployeeDto;
import com.williamfeliciano.employeeservice.entity.Employee;
import com.williamfeliciano.employeeservice.repository.EmployeeRepository;
import com.williamfeliciano.employeeservice.service.APIClient;
import com.williamfeliciano.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
//import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    //private RestTemplate restTemplate;

    //private WebClient webClient;

    private APIClient apiClient;

    private ModelMapper modelMapper;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());
        if (optionalEmployee.isPresent()){
            throw new EmailAlreadyExistException("Email already exists");
        }
        Employee employeeToSave = modelMapper.map(employeeDto,Employee.class);
        Employee employee = employeeRepository.save(employeeToSave);
        return modelMapper.map(employee,EmployeeDto.class);
    }

    //@CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        LOGGER.info("Inside getEmployeeByID method");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new RuntimeException("Could not find employee"));
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);
//        // make the api call with the rest template
//        ResponseEntity<DeparmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDeparmentCode(), DeparmentDto.class);
//        // extract the DeparmentDto from the response body
//        DeparmentDto deparmentDto = responseEntity.getBody();

        // use webclient
//        DeparmentDto deparmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/"+ employee.getDeparmentCode())
//                .retrieve()
//                .bodyToMono(DeparmentDto.class)
//                .block();
        // Open Feign
        DeparmentDto deparmentDto = apiClient.getDepartment(employee.getDeparmentCode());
        // Create the Responsedto
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDeparment(deparmentDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId,Exception exception){
        LOGGER.info("Inside getDefaultDepartment method");
        // Get Employyee
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new RuntimeException("Could not find employee"));

        // Get EmployeeDto
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);

        // Create default deparment
        DeparmentDto deparmentDto = new DeparmentDto();
        deparmentDto.setDepartmentName("R&D Deparment");
        deparmentDto.setDepartmentCode("RD001");
        deparmentDto.setDepartmentDescription("Research and Development Department");


        // Create the Responsedto
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDeparment(deparmentDto);

        return apiResponseDto;
    }

}
