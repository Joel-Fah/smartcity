# Smart City Web Application

The Smart City project is a web-based software application designed to provide essential information about a city to
newcomers. The application includes modules for tourism, student assistance, job opportunities, and business
information, making it an all-in-one guide for city exploration and resources.

## Features

- **Administration Module**: Central control for uploading and managing city data.
- **Tourism Module**: Information on hotels, restaurants, landmarks, and more.
- **Student Module**: Resources for educational institutes, libraries, and coaching centers.
- **Job Seekers Module**: Listings for job opportunities across industries.
- **Business Module**: Information on trade and business centers.

---

## Prerequisites

Ensure you have the following installed on your system:

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

---

## Installation

1. Create a fork of the repository by clicking the "Fork" button in the top right corner of
   this [page](https://github.com/Joel-Fah/smartcity).
2. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/smart-city.git
   ```
   ```
   cd smart-city
   ```
3. **Set Up the Database**:
    - Create a PostgreSQL database with the name `your_database_name`.
    - Note down the username and password for your database.

4. **Configure Environment Variables**:
    - Create a `.env` file in the project root with the following content:
      ```plaintext
      DATABASE_URL=jdbc:postgresql://localhost:5432/your_database_name
      DATABASE_USER=your_username
      DATABASE_PASSWORD=your_password
      ```

5. **Install Dependencies**:
   Run the following command to download and install project dependencies:
   ```bash
   mvn clean install
   ```

6. **Run the Application**:
   Start the application using Maven:
   ```bash
   mvn spring-boot:run
   ```
   Or run the `SmartCityApplication` class from IntelliJ IDEA.

---

## Usage

- **Access the Application**:
  Open your browser and navigate to [http://localhost:8080](http://localhost:8080).

- **Login**:
  You can use the following default credentials for the admin account:
    - Username: `admin`
    - Password: `Admin123#`
      But feel free to create your own account.


- **Modules**:
    - **Administration**: Manage city data.
    - **Tourism**: Browse hotels, landmarks, and more.
    - **Students**: Access educational resources.
    - **Job Seekers**: Find job listings.
    - **Business**: View trade and business opportunities.

---

## Development

1. **Run Tests**:
   ```bash
   mvn test
   ```

2. **Build the Project**:
   ```bash
   mvn package
   ```

3. **Run the Application from IntelliJ IDEA**:
    - Open the project in IntelliJ IDEA.
    - Navigate to the `SmartCityApplication` class and click `Run`.

---

## Contributing

1. **Fork the Repository**:
    - Navigate to the [GitHub repository](https://github.com/Joel-Fah/smartcity) and click the "Fork" button.

2. **Create a New Branch**:
   ```bash
   git checkout -b your-branch-name
   ```

3. **Commit Your Changes**:
   ```bash
   git commit -m "Add feature description"
   ```

4. **Push to the Branch**:
   ```bash
   git push origin your-branch-name
   ```

5. **Open a Pull Request**:
    - Go to your forked repository, select the branch, and click "New Pull Request".

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Troubleshooting

- **Database Connection Issues**:
    - Ensure the PostgreSQL service is running.
    - Verify the credentials in the `.env` file.

- **Port Conflict**:
    - If port `8080` is in use, modify `application.properties`:
      ```properties
      server.port=8081
      ```

