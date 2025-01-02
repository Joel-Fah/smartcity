package com.smartcity.smartcity;

import com.smartcity.smartcity.model.Admin;
import com.smartcity.smartcity.model.Category;
import com.smartcity.smartcity.model.Contact;
import com.smartcity.smartcity.model.Facility;
import com.smartcity.smartcity.repository.AdminRepository;
import com.smartcity.smartcity.repository.CategoryRepository;
import com.smartcity.smartcity.repository.ContactRepository;
import com.smartcity.smartcity.repository.FacilityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final FacilityRepository facilityRepository;
    private final CategoryRepository categoryRepository;
    private final ContactRepository contactRepository;

    public DataLoader(AdminRepository adminRepository, PasswordEncoder passwordEncoder, FacilityRepository facilityRepository, CategoryRepository categoryRepository, ContactRepository contactRepository) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.facilityRepository = facilityRepository;
        this.categoryRepository = categoryRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) {
        if (adminRepository.count() == 0) {
            // Create an admin user
            Admin admin = new Admin();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("Admin123#"));
            admin.setRole("ADMIN");
            adminRepository.save(admin);
        }

        if (facilityRepository.count() == 0) {
            // Create and save categories
            Category education = new Category();
            education.setName("Education");
            education.setDescription("Universities, schools, and libraries");
            education.setImageUrl("https://images.pexels.com/photos/159711/books-bookstore-book-reading-159711.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            categoryRepository.save(education);

            Category healthcare = new Category();
            healthcare.setName("Healthcare");
            healthcare.setDescription("Hospitals, clinics, and pharmacies");
            healthcare.setImageUrl("https://images.pexels.com/photos/40568/medical-appointment-doctor-healthcare-40568.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            categoryRepository.save(healthcare);

            // Create and save facilities
            Facility university = new Facility();
            university.setName("ICT University");
            university.setDescription("The ICT University is a hybrid of online and onsite undergraduate and graduate degree programs. Faculty members represent a global consortium of Universities and Colleges that infuse ICTs in ALL its academic disciplines.");
            university.setCategory(education);
            university.setAddress("Zoatupsi, Messassi");
            university.setTags("University, Technology, Education");
            university.setRating(3.5);
            university.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/a/a5/ICT-University-campus-yaounde.jpg");
            facilityRepository.save(university);

            Facility school = new Facility();
            school.setName("Greenfield High School");
            school.setDescription("A prestigious high school with excellent academic records.");
            school.setCategory(education);
            school.setAddress("Downtown, City Center");
            school.setTags("High School, Education");
            school.setRating(4.0);
            school.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/1/17/Greenfield_High_School_%28Wisconsin%29_exterior.jpg");
            facilityRepository.save(school);

            Facility hospital = new Facility();
            hospital.setName("Johns Hopkins Hospital");
            hospital.setDescription("For more than 125 years, The Johns Hopkins Hospital has been a leader in the diagnosis and treatment of disease. Above all, we aim to provide the highest-quality health care and service to all our patients.");
            hospital.setCategory(healthcare);
            hospital.setAddress("Baltimore, Maryland");
            hospital.setTags("Hospital, Healthcare");
            hospital.setRating(4.5);
            healthcare.setImageUrl("https://www.hopkinsmedicine.org/-/media/images/locations/ignore/jhh-bridge.jpeg");
            facilityRepository.save(hospital);

            Facility clinic = new Facility();
            clinic.setName("Sunshine Clinic");
            clinic.setDescription("A small clinic offering primary healthcare services.");
            clinic.setCategory(healthcare);
            clinic.setAddress("West End, Suburb");
            clinic.setTags("Clinic, Healthcare");
            clinic.setRating(3.0);
            clinic.setImageUrl("https://cdcssl.ibsrv.net/ibimg/smb/1500x844_80/webmgr/1m/u/r/11-15-22/Reception_20221115_2152.jpg.webp?de7744755b57cfd1450f021942388923");
            facilityRepository.save(clinic);

            // Create and save contacts for the facilities
            Contact phoneContact = new Contact();
            phoneContact.setType("Phone");
            phoneContact.setValue("656997810");
            phoneContact.setFacility(university);
            contactRepository.save(phoneContact);

            Contact emailContact = new Contact();
            emailContact.setType("Email");
            emailContact.setValue("info@ictuniversity.edu.cm");
            emailContact.setFacility(university);
            contactRepository.save(emailContact);
        }
    }
}