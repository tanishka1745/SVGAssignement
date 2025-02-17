# Random Dog Generator App

This is a simple Android app that fetches random dog images using an API and allows users to view and cache them. The app also provides functionality to navigate between screens and manage cached images.

## Features

- **Generate Random Dog Image**: Fetch and display random dog images from an API.
- **Cache Dog Images**: Cache images that have been fetched so that users can view previously fetched images without downloading them again.
- **Navigation**: Navigate between screens such as the main screen, image generator, and cached images screen.
- **UI**: User-friendly interface designed using Jetpack Compose with modern UI components.

## Screens

- **Main Screen**: Displays the title "Random Dog Generator!" with buttons to generate a new dog image or view cached images.
- **Image Generator Screen**: Allows the user to fetch a random dog image from an API and display it on the screen.
- **Cache Screen**: Displays a list of previously cached images.

  # Demo Video:
  https://www.youtube.com/shorts/Vhe5DjWgl2k

## Technologies Used

- **Jetpack Compose**: For building the user interface.
- **LruCache**: For caching the fetched dog images.
- **Coroutines**: For handling asynchronous image fetching.
- **Navigation**: For navigating between different screens of the app.
- **Material3**: For modern UI components, such as `TopAppBar`, `Button`, etc.

## Installation

### Prerequisites
Make sure you have the following installed:
- Android Studio (latest version)
- Kotlin 1.6 or higher
- Gradle 7.0 or higher


