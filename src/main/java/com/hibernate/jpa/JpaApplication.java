package com.hibernate.jpa;

import com.hibernate.jpa.OneToMany_Unidirectional.Student;
import com.hibernate.jpa.OneToMany_Unidirectional.StudentRepository;
import com.hibernate.jpa.OneToMany_Unidirectional.University;
import com.hibernate.jpa.OneToMany_Unidirectional.UniversityRepository;
import com.hibernate.jpa.OneToOne_Unidirectional.Address;
import com.hibernate.jpa.OneToOne_Unidirectional.AddressRepository;
import com.hibernate.jpa.OneToOne_Unidirectional.User;
import com.hibernate.jpa.OneToOne_Unidirectional.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaApplication {


	private static final Logger log = LoggerFactory.getLogger((JpaApplication.class));
	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
		                    SpringApplication.run(JpaApplication.class, args);


		StudentRepository studentRepository =configurableApplicationContext.getBean(StudentRepository.class);
		UniversityRepository universityRepository =configurableApplicationContext.getBean(UniversityRepository.class);

		Student student1 = new Student("111");
		Student student2 = new Student("112");

		List<Student> students = Arrays.asList(student1,student2);
		University university = new University("Marmara",students);
		universityRepository.save(university);

		/*
		AddressRepository addressRepository = configurableApplicationContext.getBean(AddressRepository.class);
		UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);

		Address address = new Address("Kadıköy");
		addressRepository.save(address);

		User user =new User("sedat",address);
		User temp =userRepository.save(user);
        */

		/*
		CarRepository carRepository = configurableApplicationContext.getBean(CarRepository.class);
		OwnerRepository ownerRepository = configurableApplicationContext.getBean(OwnerRepository.class);

		Car car = new Car("m200");
		carRepository.save(car);

		Owner owner= new Owner("sedat bilece");
		owner.setCar(car);
		ownerRepository.save(owner);

		Optional<Car> optionalCar = carRepository.findById(1L);
		Optional<Owner> optionalOwner = ownerRepository.findById(1L);

		log.info(optionalCar.get().getModel() +" owner is"+optionalCar.get().getOwner().getName());
        */

		/*
		PersonRepository personRepository =
				   configurableApplicationContext.getBean(PersonRepository.class);

		Person myPerson = new Person("sedat","bilece");
		  personRepository.save(myPerson);
		  */

	}

}
