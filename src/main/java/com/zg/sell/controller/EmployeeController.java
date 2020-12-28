package com.zg.sell.controller;

import com.zg.sell.domain.Employee;
import com.zg.sell.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        logger.info("getall employees");
        return employeeRepository.findAll();
    }

//    @PostMapping("/add")
//    public Employee addEmployee(@RequestParam("name") String name,@RequestParam("age") Integer age){
//        Employee employee=new Employee(name,age);
//        return employeeRepository.save(employee);
//    }

    //优化：添加调整：由属性改为对象，这样避免属性过多时，参数过多
//    @PostMapping("/add")
//    public Employee addEmployee(Employee employee){
//        return employeeRepository.save(employee);
//    }
//
    //通过设置属性的注解，来帮过滤并提示。
    //
    //同时参数前要加 @Valid。表示验证这个对象。同时对于有错误时，错误信息会存到bingingresult对象中。做为判断，出错return null。
//    @PostMapping("/add")
//    public Employee addEmployee(@Valid Employee employee, BindingResult bindingResult){
//        if (bindingResult.hasErrors())
//        {
//            System.out.println("保存出错");
//            return null;
//        }
//        return employeeRepository.save(employee);
//    }

    //统计处理异常优化
    @PostMapping("/add")
    public Result<Employee> addEmployee(@Valid Employee employee, BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()) {
//            result.setCode(1);
//            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
//            result.setData(null);
            //重构
           return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }else{
//            result.setCode(0);
//            result.setMessage("成功");
//            result.setData(employeeRepository.save(employee));
            //重构
           return ResultUtil.success(employeeRepository.save(employee));
        }
        //return result;
    }

    //实现年龄判断报异常：/
//    @GetMapping("/getage/{id}")
//    public void getage(@PathVariable("Id") Integer id){
//        Integer age = employeeService.getAge(id);
//        if(age==1)
//            System.out.println("小于13");
//        else if(age==0)
//            System.out.println("小于18");
//
//    }
    //统一用异常 来处理
    @GetMapping("/getage/{id}")
    public void getage(@PathVariable("id") Integer id) throws Exception{
        employeeService.getAge(id);
    }

    @GetMapping("/employee/{id}")
    public Employee findOne(@PathVariable("id") Integer id){
        //System.out.println("id:="+id);
        logger.info("id:="+id);
       return employeeRepository.findById(id).orElse(null);
    }
    //更新：body要使用x-www-form-urlencoded类型。
    @PutMapping("/update/{id}")
    public Employee update(@PathVariable("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Integer age){
        Employee employee= new Employee(name,age);
        employee.setId(id);
        return employeeRepository.save(employee);
    }
    //删除
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        employeeRepository.deleteById(id);
    }

    //扩展：根据年龄查询
    @GetMapping("/age/{age}")
    public List<Employee> getByAge(@PathVariable("age") Integer age){
        return employeeRepository.findByAge(age);
    }
}
//arthas工具：https://www.bilibili.com/video/BV1MZ4y1p7we?p=1&share_medium=android&share_plat=android&share_source=COPY&share_tag=s_i&timestamp=1593065062&unique_k=Ndnuyb