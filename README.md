Mobile Coding Challenge - GitHub Trending Repos
===========================================

### Idea of the App
The task is to implement a small app that will list the most starred Github repos that were created in the last 30 days.
You'll be fetching the sorted JSON data directly from the Github API (Github API explained down below).

### Features
* As a User I should be able to list the most starred Github repos that were created in the last 30 days.
* As a User I should see the results as a list. One repository per row.
* As a User I should be able to see for each repo/row the following details :
  * Repository name
  * Repository description
  * Numbers of stars for the repo.
  * Username and avatar of the owner.
* [BONUS] As a User I should be able to keep scrolling and new results should appear (pagination).


<h2>Libraries Used</h2>

1. Retrofit:  
A type-safe HTTP client for Android and Java . 
- https://github.com/square/retrofi 
2. Picasso:  
A powerful image downloading and caching library for Android . 
- https://github.com/square/picasso  
3. Lombok: 
Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more . 
- https://projectlombok.org

<h3>Building using Android Studio...</h3>

1. Open Android Studio and launch the Android SDK manager from it (Tools | Android | SDK Manager)
1. Ensure the following components are installed and updated to the latest version.
   1. *Android SDK Platform-Tools*
   1. *Android Support Repository*
   1. *Google Repository*
1. Return to Android Studio and select *Open an existing Android Studio project*
1. Select the **URCodingChallenge** directory.

**IMPORTANT** Ensure you have set the ANDROID_HOME environment variable.

    cd /path/to/URCodingChallenge
    export ANDROID_HOME = /path/to/android/sdk
    ./gradlew build
