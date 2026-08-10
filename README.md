# CGPA-SGPA Calculator

A Java-based console application for managing and computing **SGPA** (Semester Grade Point Average) and **CGPA** (Cumulative Grade Point Average) for students across three engineering branches — **CSE**, **Mechanical**, and **Civil**.

---

## 📌 Features

- **Multi-branch support**: CSE, Mechanical, and Civil Engineering
- **Per-semester SGPA calculation** based on subject marks and credit weights
- **Cumulative CGPA tracking** across all 8 semesters
- **Student management** for multiple students at once
- **Sort students** by overall CGPA or by SGPA of a specific semester
- **Search by enrollment number** to view a student's complete academic profile
- **Input validation** throughout — handles empty inputs, non-numeric values, out-of-range marks, invalid enrollment numbers, and invalid choices gracefully

---

## 🏗️ Project Structure

```
CGPA-SGPA calculator/
├── Spi-Cpi_calculator.java   # Main source file (all classes)
├── Student.class             # Compiled Student class
├── Run.class                 # Compiled Run base class
├── CSE.class                 # Compiled CSE branch class
├── Mechanical.class          # Compiled Mechanical branch class
├── Civil.class               # Compiled Civil branch class
├── Main.class                # Compiled entry point
└── README.md
```

### Class Overview

| Class | Role |
|---|---|
| `Student` | Stores student data (name, enrollment number, marks, SGPA/CGPA arrays) and provides sorting helpers |
| `Run` | Base class containing shared SGPA/CGPA calculation logic and display methods |
| `CSE` | Extends `Run`; defines CSE subjects and credits for all 8 semesters |
| `Mechanical` | Extends `Run`; defines Mechanical subjects and credits for all 8 semesters |
| `Civil` | Extends `Run`; defines Civil subjects and credits for all 8 semesters |
| `Main` | Entry point; handles branch selection and the main menu loop |

---

## 🧮 Calculation Logic

### SGPA
```
SGPA = Σ(marks[i] × credit[i]) / (Σ credit[i] × 10)
```
Marks are entered out of 100 and normalized to a 10-point grade scale.

### CGPA
```
CGPA = Average of all SGPA values up to the current semester
```

---

## 📚 Branch-wise Subjects

<details>
<summary><strong>CSE (Semesters 1–4 shown; 5–8 are project-based)</strong></summary>

| Sem | Subjects | Credits |
|-----|----------|---------|
| 1 | Mathematics-1, Java-1, Software Engineering, IOT-Workshop, Computer-Workshop, Physics, Environmental Science | 6, 6, 4, 2, 2, 4, 0 |
| 2 | Mathematics-2, Java-2, Data Structures, DBMS, FEEE | 5, 6, 6, 6, 4 |
| 3 | Digital Electronics, Full Stack Dev-1, Probability Theory, Python-1, Effective Technical Communication, Constitution of India | 5, 6, 5, 5, 3, 0 |
| 4 | Python-2, Discrete Mathematics, Full Stack Dev-2, COA, Theory of Computation | 5, 4, 6, 5, 5 |

</details>

<details>
<summary><strong>Mechanical (Semesters 1–6 shown; 7–8 are project-based)</strong></summary>

| Sem | Subjects | Credits |
|-----|----------|---------|
| 1 | Physics, Mathematics-I, Workshop Practice, Engineering Graphics-I, Python Programming | 4, 4, 4, 4, 5 |
| 2 | Mathematics-II, Engineering Mechanics, Electrical & Electronics Engg, Engineering Graphics-II, Environmental Science | 5, 6, 4, 4, 0 |
| 3 | Conventional Machining, Mathematics-III, Python, Thermodynamics-1, Strength of Materials, Kinematics of Machines, Effective Technical Communication, Constitution of India | 5, 5, 5, 4, 5, 6, 3, 0 |
| 4 | Fluid Mechanics, Material Science, Thermodynamics-2, Design of Machine Elements (×2) | 6, 3, 5, 6, 5 |

</details>

<details>
<summary><strong>Civil (Semesters 1–4 shown; 5–8 are project-based)</strong></summary>

| Sem | Subjects | Credits |
|-----|----------|---------|
| 1 | Python Programming, Basic Civil Engineering, Mathematics-I, Physics | 5, 5, 4, 4 |
| 2 | Mathematics-II, Basic Electrical Engineering, Engineering Graphics, Workshop Practice, Environmental Science | 4, 5, 6, 2, 0 |
| 3 | Mathematics-III, Mechanics of Solids, Building & Town Planning, Geotechnical Engineering, Effective Technical Communication, Constitution of India | 5, 5, 4, 5, 3, 0 |
| 4 | Mathematics-IV, Structural Mechanics-I, Mechanics of Fluids, Concrete Technology, Surveying | 5, 5, 5, 4, 4 |

</details>

---

## 🚀 How to Run

### Prerequisites
- **Java JDK 8+** installed and added to `PATH`

### Compile
```bash
javac Spi-Cpi_calculator.java
```

### Run
```bash
java Main
```

---

## 🖥️ Usage Walkthrough

1. **Select branch**: Enter `1` for CSE, `2` for Mechanical, or `3` for Civil.
2. **Enter number of students** (must be a positive integer).
3. For each student, provide:
   - **Name** (letters and spaces only)
   - **Enrollment Number** (exactly 14 digits)
   - **Marks** for every subject across all 8 semesters (0–100)
4. After data entry, choose from the menu:

| Option | Action |
|--------|--------|
| `1` | Display all students' SGPA and CGPA for a chosen semester |
| `2` | Sort all students by overall CGPA (descending) |
| `3` | Sort all students by SGPA of a chosen semester (descending) |
| `4` | Search and display a specific student's full academic profile by enrollment number |
| `5` | Exit |

---

## ✅ Input Validation

| Input | Validation Rules |
|-------|-----------------|
| Student Name | Non-empty, letters and spaces only |
| Enrollment Number | Exactly 14 numeric digits |
| Marks | Numeric value between 0 and 100 |
| Number of Students | Positive integer |
| Menu / Semester choices | Integer within the valid range |

---

## 🛠️ Technologies Used

- **Language**: Java (standard library only)
- **I/O**: `java.util.Scanner`
- **Paradigm**: Object-Oriented Programming (Inheritance, Encapsulation)

---

## 👤 Author

**Kashyap** — Semester 1 project
