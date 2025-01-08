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
            university.setMapLocationUrl("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3980.3273692694943!2d11.514089773637231!3d3.9527747476900403!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x108bc87b87815f9b%3A0x42cdb742c77af0f9!2sICT%20University!5e0!3m2!1sen!2scm!4v1736351649745!5m2!1sen!2scm");
            facilityRepository.save(university);

            Facility school = new Facility();
            school.setName("Greenfield High School");
            school.setDescription("A prestigious high school with excellent academic records.");
            school.setCategory(education);
            school.setAddress("Downtown, City Center");
            school.setTags("High School, Education");
            school.setRating(4.0);
            school.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/1/17/Greenfield_High_School_%28Wisconsin%29_exterior.jpg");
            school.setMapLocationUrl("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2920.0585764863554!2d-87.99039482499327!3d42.95596999724767!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x880511b145f7ace5%3A0xefb12d5541f38045!2sGreenfield%20High%20School!5e0!3m2!1sen!2scm!4v1736351779097!5m2!1sen!2scm");
            facilityRepository.save(school);

            Facility hospital = new Facility();
            hospital.setName("Johns Hopkins Hospital");
            hospital.setDescription("For more than 125 years, The Johns Hopkins Hospital has been a leader in the diagnosis and treatment of disease. Above all, we aim to provide the highest-quality health care and service to all our patients.");
            hospital.setCategory(healthcare);
            hospital.setAddress("Baltimore, Maryland");
            hospital.setTags("Hospital, Healthcare");
            hospital.setRating(4.5);
            hospital.setImageUrl("https://www.hopkinsmedicine.org/-/media/images/locations/ignore/jhh-bridge.jpeg");
            hospital.setMapLocationUrl("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3087.6592421598193!2d-76.59640802516884!3d39.295977760431136!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c80462dd7f9b41%3A0xeceddd36a48a8c8f!2sThe%20Johns%20Hopkins%20Hospital!5e0!3m2!1sen!2scm!4v1736351857973!5m2!1sen!2scm");
            facilityRepository.save(hospital);

            Facility clinic = new Facility();
            clinic.setName("Sunshine Clinic");
            clinic.setDescription("A small clinic offering primary healthcare services.");
            clinic.setCategory(healthcare);
            clinic.setAddress("West End, Suburb");
            clinic.setTags("Clinic, Healthcare");
            clinic.setRating(3.0);
            clinic.setImageUrl("https://cdcssl.ibsrv.net/ibimg/smb/1500x844_80/webmgr/1m/u/r/11-15-22/Reception_20221115_2152.jpg.webp?de7744755b57cfd1450f021942388923");
            clinic.setMapLocationUrl("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3591.8499154618003!2d28.742793174314695!3d-25.808525047974257!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x1eeab3e700bf87d5%3A0x69aeb44a66351d79!2sSunshine%20Clinic!5e0!3m2!1sen!2scm!4v1736351925916!5m2!1sen!2scm");
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