# Movie Bank

MovieBank is a modern movie sales application developed using advanced Android development techniques and technologies. The app includes features such as listing movies, viewing details, adding favorites, sorting, and managing the shopping cart. It also offers Dark Mode and Light Mode theme options alongside support for both Turkish and English languages. The "Poppins" font is used throughout the app, enhancing the user experience with a modern and aesthetic design.

## Screenshots

### Light Theme (English)
<p align="center">
  <img src="https://github.com/user-attachments/assets/63eac6ee-e3ee-4600-bfe3-510561454081" alt="Home Page" width="20%" style="margin-right: 10px;"/>
  <img src="https://github.com/user-attachments/assets/37a881af-39b1-4b49-9418-b547a08fb658" alt="Movie Details" width="20%" style="margin-right: 10px;"/>
  <img src="https://github.com/user-attachments/assets/e94f1496-e5a6-434b-8041-b97b2698a450" alt="Favorites" width="20%" style="margin-right: 10px;"/>
  <img src="https://github.com/user-attachments/assets/d5871b6d-cb96-4254-9240-93541527380a" alt="Cart" width="20%"/>
</p>

### Dark Theme (Türkçe)
<p align="center">
  <img src="https://github.com/user-attachments/assets/e11f7b9e-1d1a-4a76-a2ec-d299087ed82d" alt="Anasayfa" width="20%" style="margin-right: 10px;"/>
  <img src="https://github.com/user-attachments/assets/a198e4a1-0466-4d17-91cb-01d1b00fba41" alt="Film Detayları" width="20%" style="margin-right: 10px;"/>
  <img src="https://github.com/user-attachments/assets/fe36de07-850e-42ec-9c81-003f38d311f4" alt="Favoriler" width="20%" style="margin-right: 10px;"/>
  <img src="https://github.com/user-attachments/assets/b746df26-47d2-4039-a419-da7c33d32b3d" alt="Sepet" width="20%"/>
</p>

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

## Technologies Used

- **Jetpack Compose**: Modern and declarative UI building.
- **Retrofit**: API communication.
  - Gson Converter and OkHttp support.
- **Dagger Hilt**: Dependency Injection.
- **Coil**: Image loading.
- **MVVM**: Application architecture.
- **Navigation**: Navigation between screens.
- **LiveData and Coroutines**: Managing data streams.
- **Room Database**: Local storage for user favorite movies.

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
