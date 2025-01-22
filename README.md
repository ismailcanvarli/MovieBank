# Movie Bank

MovieBank is a modern movie sales application developed using advanced Android development techniques and technologies. The app includes features such as listing movies, viewing details, adding favorites, sorting, and managing the shopping cart. It also offers Dark Mode and Light Mode theme options alongside support for both Turkish and English languages. The "Poppins" font is used throughout the app, enhancing the user experience with a modern and aesthetic design.

## 📸 Screenshots

<table align="center">
    <tr>
        <td align="center">
            <strong><h2>Splash Screen</h2></strong>
            <img src="https://github.com/user-attachments/assets/c588eb1d-fef3-40cd-b12f-182627bb622c" alt="Splash Screen" width="225" height="auto">
        </td>
        <td align="center">
            <strong><h2>Home Screen</h2></strong>
            <img src="https://github.com/user-attachments/assets/7d859cd2-8358-4ef1-8119-432c719088cb" alt="Home Page" width="225" height="auto">
        </td>
        <td align="center">
            <strong><h2>Details Sreen</h2></strong>
            <img src="https://github.com/user-attachments/assets/0ce12b0b-6bd4-4cad-a974-9022a4975f7f" alt="Movie Details" width="225" height="auto">
        </td>
    </tr>
    <tr>
        <td align="center">
            <strong><h2>Favorites Screen</h2></strong>
            <img src="https://github.com/user-attachments/assets/4a8aef56-eadc-4670-af66-ac3b173a135a" alt="Favorites" width="225" height="auto">
        </td>
        <td align="center">
            <strong><h2>Cart Screen</h2></strong>
            <img src="https://github.com/user-attachments/assets/3066e0f6-12d6-447d-93f4-ebf92c692a94" alt="Cart" width="225" height="auto">
        </td>
    </tr>
</table>

## Features

### Home Page

- List all movies.
- Search by movie or director name.
- Sort movies by name, rating, or price.
- Navigate to the detailed page of a selected movie.
- Choose between Dark Mode and Light Mode themes.
- Language support for both Turkish and English.

### Details Page

- View movie details.
- Place movie orders.
- Add or remove movies from favorites.
- Aesthetic look with the use of the "Poppins" font.

### Favorites Screen

- View movies added to favorites.
- Add or remove movies from favorites.

### Cart Screen

- Increase or decrease the quantity of products added to the cart.
- Delete products from the cart.
- Apply discount codes.

### Splash Screen

- Displays an animated Lottie animation during the app launch.
- Automatically navigates to the home screen after a 3-second delay.
- Provides a smooth and engaging introduction to the app.

## Technologies Used

- **Jetpack Compose**: Modern and declarative UI building.
- **Retrofit**: API communication. (Gson Converter and OkHttp support.)
- **Dagger Hilt**: Dependency Injection for managing dependencies efficiently across the application.
- **Coil**: Image loading.
- **MVVM**: Application architecture.
- **Navigation**: Navigation between screens.
- **LiveData and Coroutines**: Managing data streams.
- **Room Database**: Local storage for user favorite movies.
- **Lottie**: Added animated splash screen for a modern user experience.


## API

This project uses the following APIs for fetching movie data and managing cart operations:

- **Get All Movies**: [http://kasimadalan.pe.hu/movies/getAllMovies.php](http://kasimadalan.pe.hu/movies/getAllMovies.php)
- **Get Cart Movies**: [http://kasimadalan.pe.hu/movies/getMovieCart.php](http://kasimadalan.pe.hu/movies/getMovieCart.php)
- **Add Movie to Cart**: [http://kasimadalan.pe.hu/movies/insertMovie.php](http://kasimadalan.pe.hu/movies/insertMovie.php)
- **Delete Movie from Cart**: [http://kasimadalan.pe.hu/movies/deleteMovie.php](http://kasimadalan.pe.hu/movies/deleteMovie.php)
- **Fetch Movie Images**: [http://kasimadalan.pe.hu/movies/images](http://kasimadalan.pe.hu/movies/images)

## JSON Examples

**All Movies**:
```json
{
  "movies": [
    {
      "id": "1",
      "name": "Interstellar",
      "image": "interstellar.png",
      "price": 12.99,
      "category": "Science Fiction",
      "rating": 8.6,
      "year": 2014,
      "director": "Christopher Nolan",
      "description": "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."
    }
  ]
}
```

## Installation

1. Clone this project:
   ```bash
   git clone https://github.com/ismailcanvarli/MovieBank.git
   ```
2. Open it with Android Studio.
3. Synchronize the required dependencies.
4. Run the application:
   - Use `Shift + F10` or the Run button in Android Studio.

## Testing

Follow these steps to test the application:

1. View the list of movies on the home page.
2. Navigate to the details page of a selected movie.
3. Add a movie to the cart from the details page. Repeat this process twice.
4. View the cart.
5. Add and view movies in the favorites screen.
6. Remove movies from the cart one by one.
7. Apply a discount code `WELCOME20`.

---

If you have any questions or suggestions, feel free to reach out!
