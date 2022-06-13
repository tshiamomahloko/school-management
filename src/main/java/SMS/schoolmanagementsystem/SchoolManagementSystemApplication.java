package SMS.schoolmanagementsystem;

import SMS.schoolmanagementsystem.models.*;
import SMS.schoolmanagementsystem.repositories.SchoolGroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(SchoolGroupRepository repository) {

		return args -> {
			SchoolGroup allCourses = new SchoolGroup("Courses", "All courses offered");

			allCourses = repository.save(allCourses);

			SchoolComponent FoC = new SchoolGroup("Faculty of Commerce", "Law and Management");

			SchoolComponent bComAcc = new SchoolGroup("BCom", "Accounting");

			bComAcc.add(new CourseModule("Accounting 11", "The purpose of this module is to understand and account for basic transactions and events in a sole proprietor and the financial reporting thereof in a contemporary environment through focused learning of the Conceptual Framework, investing and financing activities, debtors and creditors cycle, cash and cash equivalents and VAT.", 15));
			bComAcc.add(new CourseModule("Economics 11", "The purpose of the module is to introduce the student to economics by providing a broad perspective on the fundamental principles of economics and the influences on an economy.", 15));

			FoC.add(bComAcc);

			allCourses.add(FoC);

			System.out.println("\nALL COURSES\n");

			repository.save(allCourses);

			Student student = new Student("Lebo", "Nzimande", "YaQwaQwa", "yaqwaqwa@example.com", bComAcc);

			UndergraduateCourses undergraduateCourses = new UndergraduateCourses(allCourses);

			student.displayInfo();

			System.out.println("\nSCHOOL COMPONENT\n");
			undergraduateCourses.getSchoolComponentList();
		};
	}
}
