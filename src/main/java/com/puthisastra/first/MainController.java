package com.puthisastra.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class MainController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AdressRepository adressRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
    @ResponseBody
    public List<Person> getListPerson() {
		return personRepository.findAll();
    }
	
	@GetMapping("/departments")
    @ResponseBody
    public List<Department> getListDepartment() {
		return departmentRepository.findAll();
    }
	
	@GetMapping("/roles")
    @ResponseBody
    public List<Role> getListRoles() {
		return roleRepository.findAll();
    }
	
	@GetMapping("/adress")
    @ResponseBody
    public List<Adress> getListAdress() {
		return adressRepository.findAll();
    }
	
	@GetMapping("/create")
    @ResponseBody
    public Person createPerson() {
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Doe");
		person.setAge(13);
		person.setLastUpdatedTime(new Date());
		Department department = new Department();
		department.setName("Test");
		person.setDepartment(department);
		Role role = new Role();
		role.setName("boss");
		role = roleRepository.save(role);
		person.setRole(role);
		Adress adress = new Adress();
		adress.setName("billy");
		adress = adressRepository.save(adress);
		
		Adress adress2 = new Adress();
		adress2 = adressRepository.save(adress2);
		adress2.setName("lilly");
		
		person.setAdress(Arrays.asList(adress, adress2));
		return personRepository.save(person);
    }
	
	@GetMapping("/createRole")
    @ResponseBody
    public Role createRole() {
		Role role = new Role();
		role.setName("boss");
		return roleRepository.save(role);
    }
	
	@GetMapping("/getRole")
    @ResponseBody
    public List<Role> getRole() {
		return roleRepository.findByName("boss");
    }
	
	@GetMapping("/createAdress")
    @ResponseBody
    public Adress createAdress() {
		Adress adress = new Adress();
		adress.setName("boss");
		adress.setCity("phnom penh");
		adress.setCountry("cambodia");
		adress.setNumber(10);
		return adressRepository.save(adress);
    }
	
	@GetMapping("/createAdress2")
    @ResponseBody
    public Adress createAdress2() {
		Adress adress = new Adress();
		adress.setName("boss");
		adress.setCity("phnom penh");
		adress.setCountry("japan");
		adress.setNumber(20);
		return adressRepository.save(adress);
    }
	
	@GetMapping("/createAdress3")
    @ResponseBody
    public Adress createAdress3() {
		Adress adress = new Adress();
		adress.setName("boss");
		adress.setCity("phnom penh");
		adress.setCountry("japan");
		return adressRepository.save(adress);
    }
	
	@GetMapping("/getadress")
    @ResponseBody
    public List<Adress> getAdress() {
		return adressRepository.findByCityIgnoreCase("Phnom penh");
    }
	
	@GetMapping("/getadressasc")
    @ResponseBody
    public List<Adress> getAdressAsc() {
		return adressRepository.findByCityOrderByCityAsc("phnom penh");
    }
	
	@GetMapping("/getadressdesc")
    @ResponseBody
    public List<Adress> getAdressDesc() {
		return adressRepository.findByCityOrderByCountryDesc("phnom penh");
    }
	
	@GetMapping("/getadressfirst")
    @ResponseBody
    public Adress getAdressFirst() {
		return adressRepository.findFirstByOrderByCountryAsc();
    }
	
	@GetMapping("/getadresstop")
    @ResponseBody
    public Adress getAdressTop() {
		return adressRepository.findTopByOrderByCountryAsc();
    }
	
	@GetMapping("/getadresstop3")
    @ResponseBody
    public List<Adress> getAdressTop3() {
		return adressRepository.findTop3ByOrderByCountryDesc();
    }
	
	@GetMapping("/getadresslessthan")
    @ResponseBody
    public List<Adress> getAdressLessThan() {
		return adressRepository.findByNumberLessThan(20);
    }
	
	@GetMapping("/getadresslessthanequal")
    @ResponseBody
    public List<Adress> getAdressLessThanEqual() {
		return adressRepository.findByNumberLessThanEqual(20);
    }
	
	@GetMapping("/getadressgreaterthan")
    @ResponseBody
    public List<Adress> getAdressGreaterThan() {
		return adressRepository.findByNumberGreaterThan(20);
    }
	
	@GetMapping("/getadressgreaterthanequal")
    @ResponseBody
    public List<Adress> getAdressGreaterThanEqual() {
		return adressRepository.findByNumberGreaterThanEqual(20);
    }
	
	@GetMapping("/getadressbetween")
    @ResponseBody
    public List<Adress> getAdressBetween() {
		return adressRepository.findByNumberBetween(9, 21);
    }
	
	@GetMapping("/getadressisnull")
    @ResponseBody
    public List<Adress> getAdressIsNull() {
		return adressRepository.findByNumberIsNull();
    }
	
	@GetMapping("/getadressisnotnull")
    @ResponseBody
    public List<Adress> getAdressIsNotNull() {
		return adressRepository.findByNumberIsNotNull();
    }
	
	@GetMapping("/getadresslike")
    @ResponseBody
    public List<Adress> getAdressLike() {
		return adressRepository.findByCountryLike("%jap%");
    }
	
	@GetMapping("/getadressnotlike")
    @ResponseBody
    public List<Adress> getAdressNotLike() {
		return adressRepository.findByCountryNotLike("%jap%");
    }
	
	@GetMapping("/getadressjpql")
    @ResponseBody
    public List<Adress> getAdressJpql() {
		return adressRepository.findByCountryQuery("cambodia");
    }
	
	@GetMapping("/getadressjpqllike")
    @ResponseBody
    public List<Adress> getAdressJpqlLike() {
		return adressRepository.findByCountryQueryLike("camb");
    }
	
	@GetMapping("/getadressjpqlnamed")
    @ResponseBody
    public List<Adress> getAdressJpqlNamed() {
		return adressRepository.findByCountryAndName("japan", "boss");
    }
	
	@GetMapping("/getadressjpqlmax")
    @ResponseBody
    public Integer getAdressJpqlMax() {
		return adressRepository.findByNumberQueryMax();
    }
	
	@GetMapping("/getadressjpqlmin")
    @ResponseBody
    public Integer getAdressJpqlMin() {
		return adressRepository.findByNumberQueryMin();
    }
	
	@GetMapping("/getadressjpqlcount")
    @ResponseBody
    public Integer getAdressJpqlCount() {
		return adressRepository.findByNumberQueryCount("japan");
    }
	
	@GetMapping("/getadressjpqlsum")
    @ResponseBody
    public Integer getAdressJpqlSum() {
		return adressRepository.findByNumberQuerySum("japan");
    }
	
	@GetMapping("/getadressjpqlsort")
    @ResponseBody
    public List<Adress> getAdressJpqlSort() {
		return adressRepository.findByCountryQuerySort();
    }
	
	@GetMapping("/getadressjpqlsort2")
    @ResponseBody
    public List<Adress> getAdressJpqlSort2() {
		return adressRepository.findByCountryQuerySort(new Sort(Direction.DESC, "country"));
    }
	
	@GetMapping("/updatejpql")
    @ResponseBody
    public List<Adress> updateJPQL() {
		adressRepository.setName("bingo", 10);
		return adressRepository.findAll();
    }
	
	@GetMapping("/deletejpql")
    @ResponseBody
    public List<Adress> deleteJPQL() {
		adressRepository.deleteByNumber(10);
		return adressRepository.findAll();
    }
	
	@GetMapping("/getadressnative")
    @ResponseBody
    public List<Adress> getAdressNative() {
		return adressRepository.findByCountryNativeQuery("cambodia");
    }
	
	@GetMapping("/updaterolenative")
    @ResponseBody
    public List<Role> updateRoleNative() {
		roleRepository.updateCreatedTime();
		return roleRepository.findAll();
    }
	
	@GetMapping("/createandupdateadress")
    @ResponseBody
    public Adress createAndUpdateAdress() {
		Adress adress = adressRepository.getOne(1L);
		adress.setName("lala");
		return adressRepository.save(adress);
    }
	
	@GetMapping("/updateperson")
    @ResponseBody
    public Person updatePerson() {
		Person person = personRepository.findAll().get(0);
		person.setAge(99);
		return personRepository.save(person);
    }
	
	@GetMapping("/updateperson2")
    @ResponseBody
    public List<Person> updatePerson2() {
		personRepository.setName("Baba", 13);
		return personRepository.findAll();
    }
	
	
	
	@GetMapping("/transaction1")
    @ResponseBody
	public List<Job> createWithoutTransaction() {
		try {
			jobService.transactionsWithoutAnnotation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobRepository.findAll();
	}
	
	@GetMapping("/transaction2")
    @ResponseBody
	public List<Job> createWithTransaction() {
		try {
			jobService.transactionsWithAnnotation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobRepository.findAll();
	}
	
	@GetMapping("/deleteperson")
    @ResponseBody
	public List<Person> deletePerson() {
		personRepository.deleteAll();
		return personRepository.findAll();
	}
	
	@GetMapping("/addroletoperson")
    @ResponseBody
	public void addRoleToPerson() {
		List<Person> persons = personRepository.findAll();
		Person person = persons.get(0);
		Person person2 = persons.get(1);
		person2.setRole(person.getRole());
		personRepository.save(person2);
	}
	
	@GetMapping("/deleterole")
    @ResponseBody
	public void deleteRole() {
		Person person = personRepository.findAll().get(0);
		roleRepository.delete(person.getRole());
	}
	
	private Book createBook(String title) {
		Book book = new Book();
		book.setTitle(title);
		return bookRepository.save(book);
	}
	
	private Author createAuthor(String fullname) {
		Author author = new Author();
		author.setFullName(fullname);
		return authorRepository.save(author);
	}
	
	@GetMapping("/initbookandauthor")
    @ResponseBody
	public void initbookandauthor() {
		Author author1 = createAuthor("John Doe");
		Author author2 = createAuthor("Harry Potter");
		Author author3 = createAuthor("Morgan Trello");
		
		Book book1 = createBook("Prince");
		Book book2 = createBook("Koala");
		Book book3 = createBook("Peter Pan");
		
		author1.addBook(book1);
		author1.addBook(book3);
		author2.addBook(book2);
		author3.addBook(book3);
		
		authorRepository.save(author1);
		authorRepository.save(author2);
		authorRepository.save(author3);
	}
	
	@GetMapping("/authors")
    @ResponseBody
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}
	
	@GetMapping("/books")
    @ResponseBody
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/deleteauthors")
    @ResponseBody
	public void deleteAuthors() {
		Author author = authorRepository.findAll().get(0);
		int total = author.getBooks().size();
		for (int i = 0; i < total; i++) {
			author.removeBook(author.getBooks().get(0));
		}
		authorRepository.delete(author);
	}
	
	@GetMapping("/createorder")
    @ResponseBody
	public void createOrder() {
		Order order = new Order();
		order.setName("Test");
		OrderDetail detail = new OrderDetail();
		detail.setName("Finish");
		order.setOrderDetail(detail);
		orderRepository.save(order);
	}
	
	@GetMapping("/getorders")
    @ResponseBody
	public List<Order> getOrder() {
		return orderService.getOrders();
	}
	
	@GetMapping("/getordersdto")
    @ResponseBody
	public List<OrderDTO> getOrderDTO() {
		return orderService.getOrdersWithoutDetailDTO();
	}
	
	@GetMapping("/getRoleMultiple")
    @ResponseBody
    public Role getRoleMultiple() {
		roleService.findById(1L);
		return roleService.findById(1L);
    }
	
	@GetMapping("/getRoleQueryCache")
    @ResponseBody
    public List<Role> getRoleQueryCache() {
		roleRepository.findByName("boss");
		return roleRepository.findByName("boss");
    }
	
	@GetMapping("/getRoleSlow")
    @ResponseBody
    public Role getRoleSlow() throws InterruptedException {
		Role role = roleService.findById(1L);
		TimeUnit.SECONDS.sleep(10);
		return role;
    }
	
	@GetMapping("/createDepartments")
    @ResponseBody
    public Department createDepartments() {
		Department department = new Department();
		department.setName("test");
		return departmentRepository.save(department);
    }
	
	@GetMapping("/getDepartmentsPagination")
    @ResponseBody
    public Page<Department> getDepartmentsPagination(Pageable pageRequest) {
		return departmentRepository.findByName("test", pageRequest);
    }
}
