# 4670506Assignment2

## About the App

This Android application was developed for Assignment 2. The app allows a user to log in using their student ID and first name.

Once the login is successful, the app retrieves mythology data from the provided API and displays it on the dashboard. Users can select a mythology entity to view more information on the details screen.

## Login Details

Use the following details to test the application:

- Username: `4670506`
- Password: `Kim`

## Features

- Login using student ID and first name
- Login validation and error messages
- Retrieves data from the provided API
- Displays mythology entities using a RecyclerView
- Allows users to select an entity to view more details
- Navigation between Login, Dashboard and Details screens
- Dependency injection using Koin
- Unit tests for LoginViewModel

## Project Structure

The project is separated into different packages to keep the code organised and easier to maintain.

- `data.api` contains the Retrofit API service
- `data.model` contains the data classes used by the app
- `data.repository` handles communication with the API
- `di` contains the Koin dependency injection setup
- `ui.login` contains the Login screen and ViewModel
- `ui.dashboard` contains the Dashboard, RecyclerView adapter and ViewModel
- `ui.details` contains the Details screen

## Technologies and Dependencies

The application uses:

- Kotlin
- Android SDK
- Retrofit
- Gson Converter
- Koin
- RecyclerView
- Android ViewModel
- Kotlin Coroutines
- JUnit

All required dependencies are included in the Gradle files and will be downloaded automatically when the project is opened and synced in Android Studio.

## API

Base URL:

`https://nit3213apinew.onrender.com/`

Endpoints used:

- `POST /footscray/auth` for login
- `GET /dashboard/{keypass}` for retrieving mythology data

An internet connection is required for the application to log in and load the dashboard data.

## How to Build the Application

1. Clone or download the Git repository.
2. Open the project in Android Studio.
3. Allow Android Studio to complete the Gradle sync.
4. Make sure the required Android SDK is installed.
5. Select **Build > Assemble Project**.
6. Wait for the build to complete successfully.

## How to Run the Application

1. Open the project in Android Studio.
2. Start an Android emulator or connect an Android device.
3. Select the `app` run configuration.
4. Click **Run**.
5. Enter the provided username and password.
6. After a successful login, the mythology dashboard will be displayed.
7. Select an item from the dashboard to open the details screen.

## Testing

Unit tests have been added for the `LoginViewModel` to check the login validation.

The tests are located in:

`app/src/test/java/com/example/a4670506assignment2/LoginViewModelTest.kt`

The tests can be run from Android Studio using the unit test folder or test file.