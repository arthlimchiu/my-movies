# MyMovies
A simple Movies app in MVVM that uses the TMDb API.

<img src="https://media.giphy.com/media/TEhr1gRBwp1ZeZumar/giphy.gif" height="512" width="280">

# How to run
1. Register an account in [TMDb](https://www.themoviedb.org/account/signup)
2. Click your avatar -> Settings -> API
3. Generate a new API key
4. Copy API key under **API Key (v3 auth)**
5. Open **TMDbApi** interface found in mymovies -> movies -> repository
6. Replace `<YOUR_API_KEY_HERE>` with your own API key from TMDb
7. Build & Run

# Scope
* No pagination. Just straight up one page query to demonstrate the architecture.
* No offline support e.g. Room

# Libraries/Dependencies
* Retrofit2
* RxJava2
* Glide
* Dagger2
* Gson
* ViewModel
* LiveData