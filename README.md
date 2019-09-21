This projects contains below requirement
- Minimum supported SDK = 16
- Used MVVM & Repository Design Pattern
- Unit Test cases with Mockito, Mockwebserver, Espresso.
    
Development Tools
- KOTLIN as development language
- Git as version control system
- OkHttp and Retrofit for networking
- Dagger for dependency injection
- RX Java for ASYNC Call
- Mockito and MockWebServer for mocking objects and network requests respectively in tests (ServiceTest)
    
    
Positive & Negative Scenario.
- Launch app and you can see Weather screen to see weather data.
- Switch Off the internet and launch the app, you can see error screen and Retry button.


UNIT & UI TEST CASES
- I have written sample test cases to show the code coverage using MOCKITO/ESPRESSO.


Folder Structure
─WeatherApp
    ├───uitility
    └───weatherforcast
        ├───data
        │   ├───remote
        │   │   ├───api
        │   │   └───weatherdata
        │   │       ├───request
        │   │       └───response
        │   └───repo
        ├───di
        │   ├───builder
        │   ├───component
        │   └───module
        ├───view
        └───viewmodel