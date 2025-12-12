# MAD204-ASSIGNMENT3--DARSHILKUMAR-KARKAR

**Assignment 3: Notes & Media Manager App** **Course:** F2025 MAD204-01 Java Development for MA  
**Student:** Darshilkumar Karkar  
**Student ID:** A00203357  
**Submission Date:** December 12, 2025

---

## Project Overview
This Android application is a comprehensive productivity tool designed to help users manage personal notes with attached media (images/videos). It integrates multiple data persistence techniques including **Room Database** for structured storage, **SharedPreferences** for user settings, and **Internal File Storage** for backups.

The app features a layered architecture (MVVM), background services for notifications, and JSON export capabilities for data portability.

## Features
### Core Features
* **User Preferences:** Saves Username and Theme (Dark/Light mode) using `SharedPreferences`.
* **Notes Management (CRUD):** Create, Read, Update, and Delete notes using `Room Database`.
* **Media Attachments:** Attach images/videos to notes using the system Media Picker.
* **Favorites System:** Mark notes as "Favorites" and filter them efficiently.

### Advanced Features
* **Background Service:** A `Service` runs to trigger a "Don't forget your notes!" notification after a delay.
* **JSON Export:** Export all notes to a JSON format for external backup using `GSON`.
* **File Storage:** Saves a backup text file to internal storage.
* **RecyclerView:** Dynamic list handling with `ListAdapter` and `DiffUtil`.

## Technologies Used
* **Language:** Kotlin
* **Minimum SDK:** API 30
* **Architecture:** Layered (Data, UI, Utils)
* **Libraries:**
    * AndroidX Room (Database)
    * Google Gson (JSON Parsing)
    * Kotlin Coroutines (Async operations)
    * AndroidX Lifecycle & ViewModel

## Setup Instructions
1.  Clone the repository:
    ```bash
    git clone [https://github.com/YOUR_USERNAME/MAD204-ASSIGNMENT3--DARSHILKUMAR-KARKAR.git](https://github.com/YOUR_USERNAME/MAD204-ASSIGNMENT3--DARSHILKUMAR-KARKAR.git)
    ```
2.  Open the project in **Android Studio**.
3.  Sync Gradle files to download dependencies.
4.  Run the application on an Emulator or Physical Device (API 30+).

## GitHub Workflow
This project was developed using professional version control practices, including:
* **Feature Branches:** Distinct branches for database, UI, and services.
* **Pull Requests:** 8 merged PRs representing logical project milestones.
* **Commits:** Granular, descriptive commit history.

---
*This project is submitted as part of the MAD204 Assignment 3 requirements.*